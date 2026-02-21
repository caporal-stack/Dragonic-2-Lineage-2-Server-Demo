package npc.model;

import l2f.gameserver.model.Creature;
import l2f.gameserver.model.Skill;
import l2f.gameserver.model.instances.MonsterInstance;
import l2f.gameserver.templates.npc.NpcTemplate;
import events.SavingSnowman.SavingSnowman;

/**
 * Đ”Đ°Đ˝Đ˝Ń‹Đą Đ¸Đ˝Ń�Ń‚Đ°Đ˝Ń� Đ¸Ń�ĐżĐľĐ»ŃŚĐ·Ń�ĐµŃ‚Ń�ŃŹ ĐĽĐľĐ±ĐľĐĽ Thomas D. Turkey Đ˛ ŃŤĐ˛ĐµĐ˝Ń‚Đµ Saving Snowman
 * @author SYS
 */
public class ThomasInstance extends MonsterInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ThomasInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}

	@Override
	public void reduceCurrentHp(double i, Creature attacker, Skill skill, boolean awake, boolean standUp, boolean directHp, boolean canReflect, boolean transferDamage, boolean isDot, boolean sendMessage)
	{
		i = 10;
		if (attacker.getActiveWeaponInstance() != null)
			switch (attacker.getActiveWeaponInstance().getItemId())
			{
				// ĐĄŃ€ĐľĐ˝Đľ ĐľŃ€Ń�Đ¶Đ¸Đµ Đ˝Đ°Đ˝ĐľŃ�Đ¸Ń‚ Đ±ĐľĐ»ŃŚŃ�Đ¸Đą Ń�Ń€ĐľĐ˝
				case 4202: // Chrono Cithara
				case 5133: // Chrono Unitus
				case 5817: // Chrono Campana
				case 7058: // Chrono Darbuka
				case 8350: // Chrono Maracas
					i = 100;
					break;
				default:
					i = 10;
			}

		super.reduceCurrentHp(i, attacker, skill, awake, standUp, directHp, canReflect, transferDamage, isDot, sendMessage);
	}

	@Override
	protected void onDeath(Creature killer)
	{
		Creature topdam = getAggroList().getTopDamager();
		if (topdam == null)
			topdam = killer;
		SavingSnowman.freeSnowman(topdam);
		super.onDeath(killer);
	}

	@Override
	public boolean canChampion()
	{
		return false;
	}
}