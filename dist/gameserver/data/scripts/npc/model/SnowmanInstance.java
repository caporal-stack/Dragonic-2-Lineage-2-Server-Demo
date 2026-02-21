package npc.model;

import l2f.gameserver.model.Player;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.templates.npc.NpcTemplate;

/**
 * Đ”Đ°Đ˝Đ˝Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ¸Ń�ĐżĐľĐ»ŃŚĐ·Ń�ĐµŃ‚Ń�ŃŹ NPC Snowman Đ˛ ŃŤĐ˛ĐµĐ˝Ń‚Đµ Saving Snowman
 * @author SYS
 */
public class SnowmanInstance extends NpcInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SnowmanInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void showChatWindow(Player player, int val, Object... arg)
	{
		player.sendActionFailed();
	}
}