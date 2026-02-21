package events.Christmas;

import java.util.Calendar;

import l2f.commons.threading.RunnableImpl;
import l2f.gameserver.Announcements;
import l2f.gameserver.ThreadPoolManager;
import l2f.gameserver.instancemanager.ServerVariables;
import l2f.gameserver.model.GameObjectsStorage;
import l2f.gameserver.model.Player;
import l2f.gameserver.model.Skill;
import l2f.gameserver.network.serverpackets.MagicSkillUse;
import l2f.gameserver.scripts.ScriptFile;
import l2f.gameserver.tables.SkillTable;


/**
 * User: Death
 * Date: 20/12/2007
 * Time: 23:25:41
 */
public class NewYearTimer implements ScriptFile
{
	private static NewYearTimer instance;

	public static NewYearTimer getInstance()
	{
		if (instance == null)
			new NewYearTimer();
		return instance;
	}

	public NewYearTimer()
	{
		if (instance != null)
			return;

		instance = this;

		if (!isActive())
			return;

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		while (getDelay(c) < 0)
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);

		ThreadPoolManager.getInstance().schedule(new NewYearAnnouncer("Đˇ new, " + c.get(Calendar.YEAR) + ", year!!!"), getDelay(c));
		c.add(Calendar.SECOND, -1);
		ThreadPoolManager.getInstance().schedule(new NewYearAnnouncer("1"), getDelay(c));
		c.add(Calendar.SECOND, -1);
		ThreadPoolManager.getInstance().schedule(new NewYearAnnouncer("2"), getDelay(c));
		c.add(Calendar.SECOND, -1);
		ThreadPoolManager.getInstance().schedule(new NewYearAnnouncer("3"), getDelay(c));
		c.add(Calendar.SECOND, -1);
		ThreadPoolManager.getInstance().schedule(new NewYearAnnouncer("4"), getDelay(c));
		c.add(Calendar.SECOND, -1);
		ThreadPoolManager.getInstance().schedule(new NewYearAnnouncer("5"), getDelay(c));
	}

	private long getDelay(Calendar c)
	{
		return c.getTime().getTime() - System.currentTimeMillis();
	}

	/**
	 * Đ’Ń‹Đ·Ń‹Đ˛Đ°ĐµŃ‚Ń�ŃŹ ĐżŃ€Đ¸ Đ·Đ°ĐłŃ€Ń�Đ·ĐşĐµ ĐşĐ»Đ°Ń�Ń�ĐľĐ˛ Ń�ĐşŃ€Đ¸ĐżŃ‚ĐľĐ˛
	 */
	@Override
	public void onLoad()
	{}

	/**
	 * Đ’Ń‹Đ·Ń‹Đ˛Đ°ĐµŃ‚Ń�ŃŹ ĐżŃ€Đ¸ ĐżĐµŃ€ĐµĐ·Đ°ĐłŃ€Ń�Đ·ĐşĐµ
	 * ĐźĐľŃ�Đ»Đµ ĐżĐµŃ€ĐµĐ·Đ°ĐłŃ€Ń�Đ·ĐşĐ¸ onLoad() Đ˛Ń‹Đ·Ń‹Đ˛Đ°ĐµŃ‚Ń�ŃŹ Đ°Đ˛Ń‚ĐľĐĽĐ°Ń‚Đ¸Ń‡ĐµŃ�ĐşĐ¸
	 */
	@Override
	public void onReload()
	{}

	/**
	 * Đ§Đ¸Ń‚Đ°ĐµŃ‚ Ń�Ń‚Đ°Ń‚Ń�Ń� ŃŤĐ˛ĐµĐ˝Ń‚Đ° Đ¸Đ· Đ±Đ°Đ·Ń‹.
	 * @return
	 */
	private static boolean isActive()
	{
		return ServerVariables.getString("Christmas", "off").equalsIgnoreCase("on");
	}

	/**
	 * Đ’Ń‹Đ·Ń‹Đ˛Đ°ĐµŃ‚Ń�ŃŹ ĐżŃ€Đ¸ Đ˛Ń‹ĐşĐ»ŃŽŃ‡ĐµĐ˝Đ¸Đ¸ Ń�ĐµŃ€Đ˛ĐµŃ€Đ°
	 */
	@Override
	public void onShutdown()
	{}

	private class NewYearAnnouncer extends RunnableImpl
	{
		private final String message;

		private NewYearAnnouncer(String message)
		{
			this.message = message;
		}

		@Override
		public void runImpl() throws Exception
		{
			Announcements.getInstance().announceToAll(message);

			// Đ§ĐµŃ€ĐµĐ· Đ¶ĐľĐżŃ� Ń�Đ´ĐµĐ»Đ°Đ˝Đľ, Đ˝Đľ Đ˝Đµ Ń�Ń�Ń‚ŃŚ Đ˛Đ°Đ¶Đ˝Đľ :)
			if (message.length() == 1)
				return;

			for (Player player : GameObjectsStorage.getAllPlayersForIterate())
			{
				Skill skill = SkillTable.getInstance().getInfo(3266, 1);
				MagicSkillUse msu = new MagicSkillUse(player, player, 3266, 1, skill.getHitTime(player), 0);
				player.broadcastPacket(msu);
			}

			instance = null;
			new NewYearTimer();
		}
	}
}