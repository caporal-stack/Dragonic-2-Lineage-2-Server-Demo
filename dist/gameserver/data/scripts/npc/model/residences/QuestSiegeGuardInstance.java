package npc.model.residences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import l2f.commons.util.Rnd;
import l2f.gameserver.Config;
import l2f.gameserver.model.AggroList;
import l2f.gameserver.model.Creature;
import l2f.gameserver.model.Playable;
import l2f.gameserver.model.Player;
import l2f.gameserver.model.quest.Quest;
import l2f.gameserver.model.quest.QuestEventType;
import l2f.gameserver.model.quest.QuestState;
import l2f.gameserver.templates.npc.NpcTemplate;

/**
 * @author VISTALL
 * @date 19:28/23.06.2011
 */
public class QuestSiegeGuardInstance extends SiegeGuardInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestSiegeGuardInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void onDeath(Creature lastAttacker)
	{
		super.onDeath(lastAttacker);

		Player killer = lastAttacker.getPlayer();
		if (killer == null)
			return;

		Map<Playable, AggroList.HateInfo> aggroMap = getAggroList().getPlayableMap();

		Quest[] quests = getTemplate().getEventQuests(QuestEventType.MOB_KILLED_WITH_QUEST);
		if (quests != null && quests.length > 0)
		{
			List<Player> players = null; // ĐĽĐ°Ń�Ń�Đ¸Đ˛ Ń� Đ¸ĐłŃ€ĐľĐşĐ°ĐĽĐ¸, ĐşĐľŃ‚ĐľŃ€Ń‹Đµ ĐĽĐľĐłŃ�Ń‚ Đ±Ń‹Ń‚ŃŚ Đ·Đ°Đ¸Đ˝Ń‚ĐµŃ€ĐµŃ�ĐľĐ˛Đ°Đ˝Ń‹ Đ˛ ĐşĐ˛ĐµŃ�Ń‚Đ°Ń…
			if (isRaid() && Config.ALT_NO_LASTHIT) // Đ”Đ»ŃŹ Đ°Đ»ŃŚŃ‚Đ° Đ˝Đ° Đ»Đ°Ń�Ń‚Ń…Đ¸Ń‚ Đ±ĐµŃ€ĐµĐĽ Đ˛Ń�ĐµŃ… Đ¸ĐłŃ€ĐľĐşĐľĐ˛ Đ˛ĐľĐşŃ€Ń�Đł
			{
				players = new ArrayList<Player>();
				for (Playable pl : aggroMap.keySet())
					if (!pl.isDead() && (isInRangeZ(pl, Config.ALT_PARTY_DISTRIBUTION_RANGE) || killer.isInRangeZ(pl, Config.ALT_PARTY_DISTRIBUTION_RANGE)))
						players.add(pl.getPlayer());
			}
			else if (killer.getParty() != null) // ĐµŃ�Đ»Đ¸ ĐżĐ°Ń‚Đ¸ Ń‚Đľ Ń�ĐľĐ±Đ¸Ń€Đ°ĐµĐĽ Đ˛Ń�ĐµŃ… ĐşŃ‚Đľ ĐżĐľĐ´Ń…ĐľĐ´Đ¸Ń‚
			{
				players = new ArrayList<Player>(killer.getParty().size());
				for (Player pl : killer.getParty().getMembers())
					if (!pl.isDead() && (isInRangeZ(pl, Config.ALT_PARTY_DISTRIBUTION_RANGE) || killer.isInRangeZ(pl, Config.ALT_PARTY_DISTRIBUTION_RANGE)))
						players.add(pl);
			}

			for (Quest quest : quests)
			{
				Player toReward = killer;
				if (quest.getParty() != Quest.PARTY_NONE && players != null)
					if (isRaid() || quest.getParty() == Quest.PARTY_ALL) // ĐµŃ�Đ»Đ¸ Ń†ĐµĐ»ŃŚ Ń€ĐµĐąĐ´ Đ¸Đ»Đ¸ ĐşĐ˛ĐµŃ�Ń‚ Đ´Đ»ŃŹ Đ˛Ń�ĐµĐą ĐżĐ°Ń‚Đ¸ Đ˝Đ°ĐłŃ€Đ°Đ¶Đ´Đ°ĐµĐĽ Đ˛Ń�ĐµŃ… Ń�Ń‡Đ°Ń�Ń‚Đ˝Đ¸ĐşĐľĐ˛
					{
						for (Player pl : players)
						{
							QuestState qs = pl.getQuestState(quest.getName());
							if (qs != null && !qs.isCompleted())
								quest.notifyKill(this, qs);
						}
						toReward = null;
					}
					else
					{ // Đ¸Đ˝Đ°Ń‡Đµ Đ˛Ń‹Đ±Đ¸Ń€Đ°ĐµĐĽ ĐľĐ´Đ˝ĐľĐłĐľ
						List<Player> interested = new ArrayList<Player>(players.size());
						for (Player pl : players)
						{
							QuestState qs = pl.getQuestState(quest.getName());
							if (qs != null && !qs.isCompleted()) // Đ¸Đ· Ń‚ĐµŃ…, Ń� ĐşĐľĐłĐľ Đ˛Đ·ŃŹŃ‚ ĐşĐ˛ĐµŃ�Ń‚
								interested.add(pl);
						}

						if (interested.isEmpty())
							continue;

						toReward = interested.get(Rnd.get(interested.size()));
						if (toReward == null)
							toReward = killer;
					}

				if (toReward != null)
				{
					QuestState qs = toReward.getQuestState(quest.getName());
					if (qs != null && !qs.isCompleted())
						quest.notifyKill(this, qs);
				}
			}
		}
	}
}
