package npc.model;

import l2f.gameserver.model.Player;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.templates.npc.NpcTemplate;

/**
 * Đ”Đ°Đ˝Đ˝Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ¸Ń�ĐżĐľĐ»ŃŚĐ·Ń�ĐµŃ‚Ń�ŃŹ NPC Sandstorm Đ˛ Đ»ĐľĐşĐ°Ń†Đ¸Đ¸ Hellbound
 * @author SYS
 */
public class SandstormInstance extends NpcInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SandstormInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void showChatWindow(Player player, int val, Object... arg)
	{}

	@Override
	public void onAction(Player player, boolean shift)
	{
		player.sendActionFailed();
	}
}