package npc.model;

import l2f.gameserver.cache.Msg;
import l2f.gameserver.model.Player;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.network.serverpackets.SystemMessage;
import l2f.gameserver.scripts.Functions;
import l2f.gameserver.templates.npc.NpcTemplate;
import l2f.gameserver.utils.Location;

import java.util.List;
import java.util.StringTokenizer;


/**
 * Đ”Đ°Đ˝Đ˝Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ¸Ń�ĐżĐľĐ»ŃŚĐ·Ń�ĐµŃ‚Ń�ŃŹ Đ˛ ĐłĐľŃ€ĐľĐ´Đµ-Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń�Đµ Đ˝Đ° Hellbound ĐşĐ°Đş Ń‚ĐľŃ‡ĐşĐ° Đ˛Ń‹Ń…ĐľĐ´Đ°
 * @author SYS
 */
public final class MoonlightTombstoneInstance extends NpcInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int KEY_ID = 9714;
	private final static long COLLAPSE_TIME = 5; // 5 ĐĽĐ¸Đ˝
	private boolean _activated = false;

	public MoonlightTombstoneInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void onBypassFeedback(Player player, String command)
	{
		if (!canBypassCheck(player, this))
			return;

		StringTokenizer st = new StringTokenizer(command);
		if (st.nextToken().equals("insertKey"))
		{
			if (player.getParty() == null)
			{
				player.sendPacket(Msg.YOU_ARE_NOT_CURRENTLY_IN_A_PARTY_SO_YOU_CANNOT_ENTER);
				return;
			}

			if (!player.getParty().isLeader(player))
			{
				player.sendPacket(Msg.ONLY_A_PARTY_LEADER_CAN_TRY_TO_ENTER);
				return;
			}

			List<Player> partyMembers = player.getParty().getMembers();
			for (Player partyMember : partyMembers)
				if (!isInRange(partyMember, INTERACTION_DISTANCE * 2))
				{
					// Đ§Đ»ĐµĐ˝Ń‹ ĐżĐ°Ń€Ń‚Đ¸Đ¸ Ń�Đ»Đ¸Ń�ĐşĐľĐĽ Đ´Đ°Đ»ĐµĐşĐľ
					Functions.show("default/32343-3.htm", player, this);
					return;
				}

			if (_activated)
			{
				// ĐŁĐ¶Đµ Đ°ĐşŃ‚Đ¸Đ˛Đ¸Ń€ĐľĐ˛Đ°Đ˝Đľ
				Functions.show("default/32343-1.htm", player, this);
				return;
			}

			if (Functions.getItemCount(player, KEY_ID) > 0)
			{
				Functions.removeItem(player, KEY_ID, 1, "MoonlightTombstoneInstance");
				player.getReflection().startCollapseTimer(COLLAPSE_TIME * 60 * 1000L);
				_activated = true;
				broadcastPacketToOthers(new SystemMessage(SystemMessage.THIS_DUNGEON_WILL_EXPIRE_IN_S1_MINUTES).addNumber(COLLAPSE_TIME));
				player.getReflection().setCoreLoc(player.getReflection().getReturnLoc());
				player.getReflection().setReturnLoc(new Location(16280, 283448, -9704));
				Functions.show("default/32343-1.htm", player, this);
				return;
			}
			// ĐťĐµŃ‚ ĐşĐ»ŃŽŃ‡Đ°
			Functions.show("default/32343-2.htm", player, this);
			return;
		}
		super.onBypassFeedback(player, command);
	}
}