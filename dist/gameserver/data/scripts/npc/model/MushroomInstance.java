package npc.model;

import java.util.ArrayList;
import java.util.List;

import l2f.commons.threading.RunnableImpl;
import l2f.gameserver.ThreadPoolManager;
import l2f.gameserver.model.Creature;
import l2f.gameserver.model.Skill;
import l2f.gameserver.model.instances.MonsterInstance;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.network.serverpackets.MagicSkillUse;
import l2f.gameserver.tables.SkillTable;
import l2f.gameserver.templates.npc.NpcTemplate;
import l2f.gameserver.utils.Location;


public class MushroomInstance extends MonsterInstance
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FANTASY_MUSHROOM = 18864;
	private static final int FANTASY_MUSHROOM_SKILL = 6427;
	
	private static final int RAINBOW_FROG = 18866;
	private static final int RAINBOW_FROG_SKILL = 6429;
	
	private static final int STICKY_MUSHROOM = 18865;
	private static final int STICKY_MUSHROOM_SKILL = 6428;
	
	private static final int ENERGY_PLANT = 18868;
	private static final int ENERGY_PLANT_SKILL = 6430;
	
	private static final int ABYSS_WEED = 18867;

	public MushroomInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public boolean canChampion()
	{
		return false;
	}

	@Override
	public void reduceCurrentHp(double i, Creature attacker, Skill skill, boolean awake, boolean standUp, boolean directHp, boolean canReflect, boolean transferDamage, boolean isDot, boolean sendMessage)
	{
		if (isDead())
			return;

		// Đ”Đ°Đ¶Đµ ĐµŃ�Đ»Đ¸ Ń�Đ±Đ¸Đ» ĐĽĐľĐ±Đ° Ń�Đ°ĐĽĐĽĐľĐ˝, Ń‚Đľ ŃŤŃ„Ń„ĐµĐşŃ‚Ń‹ ĐłŃ€Đ¸Đ±ĐľĐ˛ Đ¸Đ´Ń�Ń‚ Ń…ĐľĐ·ŃŹĐ¸Đ˝Ń�.
		Creature killer = attacker;
		if (killer.isPet() || killer.isSummon())
			killer = killer.getPlayer();

		if (getNpcId() == RAINBOW_FROG) // Đ­Ń‚ĐľŃ‚ ĐĽĐľĐ± Đ±Đ°Ń„Ń„Đ°ĐµŃ‚ Đ±Đ°Ń„Ń„ĐľĐĽ.
		{
			ThreadPoolManager.getInstance().schedule(new TaskAfterDead(this, killer, RAINBOW_FROG_SKILL), 3000);
			doDie(killer);
		}
		else if (getNpcId() == STICKY_MUSHROOM) // Đ­Ń‚ĐľŃ‚ ĐĽĐľĐ± Đ»ĐµŃ‡Đ¸Ń‚ Đ¸ Ń� Ń�Đ°Đ˝Ń�ĐľĐĽ 40% ĐşĐ¸Đ´Đ°ĐµŃ‚ ĐşĐľŃ€Đ˝Đ¸.
		{
			ThreadPoolManager.getInstance().schedule(new TaskAfterDead(this, killer, STICKY_MUSHROOM_SKILL), 3000);
			doDie(killer);
		}
		else if (getNpcId() == ENERGY_PLANT) // Đ­Ń‚ĐľŃ‚ ĐĽĐľĐ± Đ»ĐµŃ‡Đ¸Ń‚.
		{
			ThreadPoolManager.getInstance().schedule(new TaskAfterDead(this, killer, ENERGY_PLANT_SKILL), 3000);
			doDie(killer);
		}
		else if (getNpcId() == ABYSS_WEED) // TODO: ĐťĐµĐ¸Đ·Đ˛ĐµŃ�Ń‚Đ˝Đľ, Ń‡Ń‚Đľ ĐľĐ˝ Đ´ĐµĐ»Đ°ĐµŃ‚.
		{
			doDie(killer);
		}
		else if (getNpcId() == FANTASY_MUSHROOM) // Đ­Ń‚ĐľŃ‚ ĐĽĐľĐ± Ń�Đ·Ń‹Đ˛Đ°ĐµŃ‚ Đ˛Ń�ĐµŃ… ĐĽĐľĐ±ĐľĐ˛ Đ˛ ĐľĐşŃ€Ń�Đ¶Đ˝ĐľŃ�Ń‚Đ¸ Đ¸ Ń�Ń‚Đ°Đ˝Đ¸Ń‚ Đ¸Ń….
		{
			List<NpcInstance> around = getAroundNpc(700, 300);
			if (around != null && !around.isEmpty())
				for (NpcInstance npc : around)
					if (npc.isMonster() && npc.getNpcId() >= 22768 && npc.getNpcId() <= 22774)
					{
						npc.setRunning();
						npc.moveToLocation(Location.findPointToStay(this, 20, 50), 0, true);
					}
			ThreadPoolManager.getInstance().schedule(new TaskAfterDead(this, killer, FANTASY_MUSHROOM_SKILL), 4000);
		}
	}

	public static class TaskAfterDead extends RunnableImpl
	{
		private NpcInstance _actor;
		private Creature _killer;
		private Skill _skill;

		public TaskAfterDead(NpcInstance actor, Creature killer, int skillId)
		{
			_actor = actor;
			_killer = killer;
			_skill = SkillTable.getInstance().getInfo(skillId, 1);
		}

		@Override
		public void runImpl() throws Exception
		{
			if (_skill == null)
				return;

			if (_actor != null && _actor.getNpcId() == FANTASY_MUSHROOM)
			{
				_actor.broadcastPacket(new MagicSkillUse(_actor, _skill.getId(), _skill.getLevel(), 0, 0));
				List<NpcInstance> around = _actor.getAroundNpc(200, 300);
				if (around != null && !around.isEmpty())
					for (NpcInstance npc : around)
						if (npc.isMonster() && npc.getNpcId() >= 22768 && npc.getNpcId() <= 22774)
							_skill.getEffects(npc, npc, false, false);
				_actor.doDie(_killer);
				return;
			}

			if (_killer != null && _killer.isPlayer() && !_killer.isDead())
			{
				List<Creature> targets = new ArrayList<Creature>();
				targets.add(_killer);
				_killer.broadcastPacket(new MagicSkillUse(_killer, _killer, _skill.getId(), _skill.getLevel(), 0, 0));
				_skill.useSkill(_killer, targets);
			}
		}
	}
}