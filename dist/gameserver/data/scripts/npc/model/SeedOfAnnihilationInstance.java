package npc.model;


import l2f.commons.util.Rnd;
import l2f.gameserver.model.Creature;
import l2f.gameserver.model.instances.MonsterInstance;
import l2f.gameserver.templates.npc.MinionData;
import l2f.gameserver.templates.npc.NpcTemplate;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ĐŁ ĐĽĐľĐ˝Ń�Ń‚Ń€ĐľĐ˛ Đ˛ Seed of Annihilation Ń�ĐżĐ¸Ń�ĐľĐş ĐĽĐ¸Đ˝Đ¸ĐľĐ˝ĐľĐ˛ ĐĽĐľĐ¶ĐµŃ‚ Đ±Ń‹Ń‚ŃŚ Ń€Đ°Đ·Đ˝Ń‹Đą.
 * @author Bonux
**/
public class SeedOfAnnihilationInstance extends MonsterInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int[] BISTAKON_MOBS = new int[] { 22750, 22751, 22752, 22753 };
	private static final int[] COKRAKON_MOBS = new int[] { 22763, 22764, 22765 };
	private static final int[][] BISTAKON_MINIONS = new int[][] {
			{ 22746, 22746, 22746 },
			{ 22747, 22747, 22747 },
			{ 22748, 22748, 22748 },
			{ 22749, 22749, 22749 } };
	private static final int[][] COKRAKON_MINIONS = new int[][] {
			{ 22760, 22760, 22761 },
			{ 22760, 22760, 22762 },
			{ 22761, 22761, 22760 },
			{ 22761, 22761, 22762 },
			{ 22762, 22762, 22760 },
			{ 22762, 22762, 22761 } };

	public SeedOfAnnihilationInstance(int objectId, NpcTemplate template)
	{
		super(objectId, template);
		if (ArrayUtils.contains(BISTAKON_MOBS, template.getNpcId()))
			addMinions(BISTAKON_MINIONS[Rnd.get(BISTAKON_MINIONS.length)], template);
		else if (ArrayUtils.contains(COKRAKON_MOBS, template.getNpcId()))
			addMinions(COKRAKON_MINIONS[Rnd.get(COKRAKON_MINIONS.length)], template);
	}

	private static void addMinions(int[] minions, NpcTemplate template)
	{
		if (minions != null && minions.length > 0)
			for (int id : minions)
				template.addMinion(new MinionData(id, 1));
	}

	@Override
	protected void onDeath(Creature killer)
	{
		//TODO: ĐźŃ€ĐľĐ˛ĐµŃ€Đ¸Ń‚ŃŚ Đ˝Đ° ĐľŃ„Ń„Đµ, ĐżŃ€Đ¸ Ń�Đ±Đ¸ĐąŃ�Ń‚Đ˛Đµ ĐłĐ»Đ°Đ˛Đ˝ĐľĐłĐľ ĐĽĐ¸Đ˝ŃŚŃ‘Đ˝Ń‹ Đ°Đ˝Ń�ĐżĐ°Đ˛Đ˝ŃŹŃ‚Ń�ŃŹ Đ¸Đ»Đ¸ Đ˝ĐµŃ‚.
		getMinionList().unspawnMinions();
		super.onDeath(killer);
	}

	@Override
	public boolean canChampion()
	{
		return false;
	}
}