package npc.model;

import java.util.StringTokenizer;

import l2f.gameserver.instancemanager.HellboundManager;
import l2f.gameserver.model.Player;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.scripts.Functions;
import l2f.gameserver.skills.AbnormalEffect;
import l2f.gameserver.templates.npc.NpcTemplate;


/**
 * Đ”Đ°Đ˝Đ˝Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ¸Ń�ĐżĐľĐ»ŃŚĐ·Ń�ĐµŃ‚Ń�ŃŹ Đ˛ ĐłĐľŃ€ĐľĐ´Đµ-Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń�Đµ Đ˝Đ° Hellbound
 * @author SYS
 */
public final class NativePrisonerInstance extends NpcInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NativePrisonerInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	protected void onSpawn()
	{
		startAbnormalEffect(AbnormalEffect.HOLD_2);
		super.onSpawn();
	}

	@Override
	public void onBypassFeedback(Player player, String command)
	{
		if (!canBypassCheck(player, this) || isBusy())
			return;

		StringTokenizer st = new StringTokenizer(command);
		if (st.nextToken().equals("rescue"))
		{
			stopAbnormalEffect(AbnormalEffect.HOLD_2);
			Functions.npcSay(this, "Thank you for saving me! Guards are coming, run!");
			HellboundManager.addConfidence(15);
			deleteMe();
		}
		else
			super.onBypassFeedback(player, command);
	}
}