package npc.model;

import l2f.gameserver.model.Player;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.templates.npc.NpcTemplate;

/**
 * Đ”Đ°Đ˝Đ˝Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ¸Ń�ĐżĐľĐ»ŃŚĐ·Ń�ĐµŃ‚Ń�ŃŹ Ń‚ĐµĐ»ĐµĐżĐľŃ€Ń‚ĐµŃ€Đ°ĐĽĐ¸ Đ¸Đ·/Đ˛ Pagan Temple
 * @author SYS
 */
public class TriolsMirrorInstance extends NpcInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TriolsMirrorInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void showChatWindow(Player player, int val, Object... arg)
	{
		if (getNpcId() == 32040)
			player.teleToLocation(-12766, -35840, -10856); //to pagan
		else if (getNpcId() == 32039)
			player.teleToLocation(35079, -49758, -760); //from pagan
	}
}