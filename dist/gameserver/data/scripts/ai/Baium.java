package ai;

import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.HashMap;
import java.util.Map;

import l2f.commons.util.Rnd;
import l2f.gameserver.ai.DefaultAI;
import l2f.gameserver.model.Creature;
import l2f.gameserver.model.Skill;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.network.serverpackets.MagicSkillUse;
import l2f.gameserver.network.serverpackets.NpcSay;
import l2f.gameserver.network.serverpackets.components.ChatType;
import bosses.BaiumManager;

public class Baium extends DefaultAI
{
	private boolean _firstTimeAttacked = true;

	// Đ‘ĐľĐµĐ˛Ń‹Đµ Ń�ĐşĐ¸Đ»Ń‹ Đ±Đ°ĐąŃ�ĐĽĐ°
	private final Skill baium_normal_attack, energy_wave, earth_quake, thunderbolt, group_hold;

	public Baium(NpcInstance actor)
	{
		super(actor);
		TIntObjectHashMap<Skill> skills = getActor().getTemplate().getSkills();
		baium_normal_attack = skills.get(4127);
		energy_wave = skills.get(4128);
		earth_quake = skills.get(4129);
		thunderbolt = skills.get(4130);
		group_hold = skills.get(4131);
	}

	@Override
	public boolean isGlobalAI()
	{
		return true;
	}

	
	@Override
	protected void onEvtAttacked(Creature attacker, int damage)
	{
	    BaiumManager.setLastAttackTime();

	    if (_firstTimeAttacked)
	    {
	        _firstTimeAttacked = false;
	        NpcInstance actor = getActor();
	        if (attacker == null)
	            return;

	        // Baium face un shout la trezire
	        actor.broadcastPacket(new NpcSay(actor, ChatType.SHOUT, "Who dares to disturb my eternal sleep?!"));


	        // Efect vizual global (toți jucătorii din zonă văd animația skillului)
	        actor.broadcastPacket(new MagicSkillUse(actor, attacker, thunderbolt.getId(), thunderbolt.getLevel(), 1000, 0));

	        // Baium folosește skillul thunderbolt pe primul atacator
	        if (attacker.isPlayer() || attacker.isSummon() || attacker.isPet())
	        {
	            addTaskCast(attacker, thunderbolt);
	        }
	    }

	    super.onEvtAttacked(attacker, damage);
	}


	@Override
	protected boolean createNewTask()
	{
		NpcInstance actor = getActor();
		if (actor == null)
			return true;

		if (!BaiumManager.getZone().checkIfInZone(actor))
		{
			teleportHome();
			return false;
		}

		clearTasks();

		Creature target;
		if ((target = prepareTarget()) == null)
			return false;

		if (!BaiumManager.getZone().checkIfInZone(target))
		{
			actor.getAggroList().remove(target, false);
			return false;
		}

		// Đ¨Đ°Đ˝Ń�Ń‹ Đ¸Ń�ĐżĐľĐ»ŃŚĐ·ĐľĐ˛Đ°Đ˝Đ¸ŃŹ Ń�ĐşĐ¸Đ»ĐľĐ˛
		int s_energy_wave = 20;
		int s_earth_quake = 20;
		int s_group_hold = actor.getCurrentHpPercents() > 50 ? 0 : 20;
		int s_thunderbolt = actor.getCurrentHpPercents() > 25 ? 0 : 20;

		Skill r_skill = null;

		if (actor.isMovementDisabled()) // Đ•Ń�Đ»Đ¸ Đ˛ Ń€Ń�Ń‚Đµ, Ń‚Đľ Đ¸Ń�ĐżĐľĐ»ŃŚĐ·ĐľĐ˛Đ°Ń‚ŃŚ ĐĽĐ°Ń�Ń�ĐľĐ˛Ń‹Đą Ń�ĐşĐ¸Đ»Đ» Đ´Đ°Đ»ŃŚĐ˝ĐµĐłĐľ Đ±ĐľŃŹ
			r_skill = thunderbolt;
		else if (!Rnd.chance(100 - s_thunderbolt - s_group_hold - s_energy_wave - s_earth_quake)) // Đ’Ń‹Đ±Đ¸Ń€Đ°ĐµĐĽ Ń�ĐşĐ¸Đ»Đ» Đ°Ń‚Đ°ĐşĐ¸
		{
			Map<Skill, Integer> d_skill = new HashMap<Skill, Integer>(); //TODO class field ?
			double distance = actor.getDistance(target);

			addDesiredSkill(d_skill, target, distance, energy_wave);
			addDesiredSkill(d_skill, target, distance, earth_quake);
			if (s_group_hold > 0)
				addDesiredSkill(d_skill, target, distance, group_hold);
			if (s_thunderbolt > 0)
				addDesiredSkill(d_skill, target, distance, thunderbolt);
			r_skill = selectTopSkill(d_skill);
		}

		// Đ�Ń�ĐżĐľĐ»ŃŚĐ·ĐľĐ˛Đ°Ń‚ŃŚ Ń�ĐşĐ¸Đ»Đ» ĐµŃ�Đ»Đ¸ ĐĽĐľĐ¶Đ˝Đľ, Đ¸Đ˝Đ°Ń‡Đµ Đ°Ń‚Đ°ĐşĐľĐ˛Đ°Ń‚ŃŚ Ń�ĐşĐ¸Đ»ĐľĐĽ baium_normal_attack
		if (r_skill == null)
			r_skill = baium_normal_attack;
		else if (r_skill.getTargetType() == Skill.SkillTargetType.TARGET_SELF)
			target = actor;

		// Đ”ĐľĐ±Đ°Đ˛Đ¸Ń‚ŃŚ Đ˝ĐľĐ˛ĐľĐµ Đ·Đ°Đ´Đ°Đ˝Đ¸Đµ
		addTaskCast(target, r_skill);
		r_skill = null;
		return true;
	}

	@Override
	protected boolean maybeMoveToHome()
	{
		NpcInstance actor = getActor();
		if (actor != null && !BaiumManager.getZone().checkIfInZone(actor))
			teleportHome();
		return false;
	}

	@Override
	protected void onEvtDead(Creature killer)
	{
		_firstTimeAttacked = true;
		super.onEvtDead(killer);
	}
}