package npc.model.residences.castle;

import l2f.gameserver.model.Creature;
import l2f.gameserver.model.Player;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.templates.npc.NpcTemplate;

/**
 * @Author: Death
 * @Date: 17/9/2007
 * @Time: 19:11:50
 *
 * Đ­Ń‚ĐľŃ‚ Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� ĐżŃ€ĐľŃ�Ń‚Đľ Đ´Đ»ŃŹ ĐľŃ‚Ń€Đ¸Ń�ĐľĐ˛ĐşĐ¸ Ń�ĐĽĐµŃ€Ń�ĐµĐą Đ˛Ń‹Ń�ĐşĐ¸ Đ˝Đ° ĐĽĐµŃ�Ń‚Đµ ĐľŃ€Đ¸ĐłĐ¸Đ˝Đ°Đ»ŃŚĐ˝ĐľĐą Đ˝Đ° ĐľŃ�Đ°Đ´Đµ
 * Đ¤ŃŤĐąĐşĐľĐ˛Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ˝ĐµŃ�ŃŹĐ·Đ˛Đ¸ĐĽ.
 */
public class CastleFakeTowerInstance extends NpcInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CastleFakeTowerInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	/**
	 * Đ¤ŃŤĐąĐşĐľĐ˛Ń‹Đµ Đ˛Ń‹Ń�ĐşĐ¸ Đ˝ĐµĐ»ŃŚĐ·ŃŹ Đ°Ń‚Đ°ĐşĐľĐ˛Đ°Ń‚ŃŚ
	 */
	@Override
	public boolean isAutoAttackable(Creature player)
	{
		return false;
	}

	/**
	 * Đ’Ń‹Ń�ĐşĐ¸ Đ˝Đµ Ń�ĐĽĐµŃŽŃ‚ ĐłĐľĐ˛ĐľŃ€Đ¸Ń‚ŃŚ
	 */
	@Override
	public void showChatWindow(Player player, int val, Object... arg)
	{}

	/**
	 * Đ’Ń‹Ń�ĐşĐ¸ Đ˝Đµ Ń�ĐĽĐµŃŽŃ‚ ĐłĐľĐ˛ĐľŃ€Đ¸Ń‚ŃŚ
	 */
	@Override
	public void showChatWindow(Player player, String filename, Object... replace)
	{}

	@Override
	public boolean hasRandomAnimation()
	{
		return false;
	}

	/**
	 * Đ¤ŃŤĐąĐşĐľĐ˛Ń‹Đµ Đ˛Ń‹Ń�ĐşĐ¸ Đ˝ĐµŃ�ŃŹĐ·Đ˛Đ¸ĐĽŃ‹
	 * @return true
	 */
	@Override
	public boolean isInvul()
	{
		return true;
	}

	@Override
	public boolean isFearImmune()
	{
		return true;
	}

	@Override
	public boolean isParalyzeImmune()
	{
		return true;
	}

	@Override
	public boolean isLethalImmune()
	{
		return true;
	}
}