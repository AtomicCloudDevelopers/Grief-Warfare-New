package net.dynamicjk.game.timers;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.MapResetSystem;
import net.dynamicjk.main.util.SendPlayerToHub;

public class RestartTimer extends BukkitRunnable {

	private TntWars tnt = TntWars.getInstance;

	@Override
	public void run() {

		if (tnt.getGameManager().getGameState().equals(GameState.RESTART)) {

			tnt.getGameManager().setRestartTimer(tnt.getGameManager().getRestartTimer() - 1);

			switch (tnt.getGameManager().getRestartTimer()) {

			case 10:

				tnt.getMessageManager().sendGameRestarting();
				playSound();

				break;

			case 5:

				tnt.getMessageManager().sendGameRestarting();
				playSound();

				break;
			case 4:

				tnt.getMessageManager().sendGameRestarting();
				playSound();

				break;
			case 3:

				tnt.getMessageManager().sendGameRestarting();
				playSound();

				break;
			case 2:

				tnt.getMessageManager().sendGameRestarting();
				playSound();

				break;
			case 1:

				tnt.getMessageManager().sendGameRestarting();
				playSound();

				break;
			case 0:

				playSound();

				for (Player z : Bukkit.getOnlinePlayers()) {

					z.teleport(tnt.getLocationManager().getLobbyLocation());

					SendPlayerToHub server = new SendPlayerToHub(tnt);
					if (z != null) {
						server.sendToServer(z);
						z.setGameMode(GameMode.ADVENTURE);
					}
				}

				MapResetSystem mp = new MapResetSystem();
				try {
					mp.executeReset();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case -1:

				for (Player z : Bukkit.getOnlinePlayers()) {
					SendPlayerToHub server = new SendPlayerToHub(tnt);
					z.setGameMode(GameMode.ADVENTURE);
					if (z != null) {
						server.sendToServer(z);
					}
				}

				for (Player z : Bukkit.getOnlinePlayers()) {
					SendPlayerToHub server = new SendPlayerToHub(tnt);
					if (z != null) {
						server.sendToServer(z);
					}
				}

				break;
			case -2:
				for (Player z : Bukkit.getOnlinePlayers()) {
					SendPlayerToHub server = new SendPlayerToHub(tnt);
					if (z != null) {
						server.sendToServer(z);
					}
				}

				break;

			}

		} else {
			cancel();
		}

	}

	public void playSound() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			tnt.getSound().playNotePling(p);
			tnt.getSound().playNoteSticks(p);
		}
	}

}
