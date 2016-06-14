package net.dynamicjk.game.timers;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.game.kit.DefaultPlayerKit;
import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.TabChanger;

public class LobbyTimer extends BukkitRunnable {

	private TntWars tnt = TntWars.getInstance;

	@Override
	public void run() {

		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {
			if (Bukkit.getOnlinePlayers().size() >= tnt.getGameManager().getMinPlayers()) {

				tnt.getGameManager().setLobbyTimer(tnt.getGameManager().getLobbyTimer() - 1);
				tnt.getLobbyScoreBoard().updateBoardForAllPlayers();

				switch (tnt.getGameManager().getLobbyTimer()) {

				case 120:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 60:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 50:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 40:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 30:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 20:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 10:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 5:

					try {
						tnt.getMapSystem().loadArenaWorld();
					} catch (IOException e) {
						e.printStackTrace();
					}
					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();
					break;

				case 4:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;

				case 3:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;

				case 2:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;

				case 1:

					tnt.getMessageManager().sendGameIsStartingMessage();
					playSound();

					break;
				case 0:

					playSound();
					tnt.getMessageManager().sendGameHasStarted();

					new GameTimer().runTaskTimer(tnt, 20, 20);
					//

					for (Player z : Bukkit.getOnlinePlayers()) {

						tnt.getGameScoreboard().updateBoardForAllPlayers();

						z.teleport(tnt.getLocationManager().getGameLocation());
						z.setGameMode(GameMode.CREATIVE);

						tnt.getGameManager().setGameState(GameState.INGAME);

						tnt.getGamePlayers().getPlayers().put(z.getName(), 0);

						DefaultPlayerKit kit = new DefaultPlayerKit(tnt);
						kit.giveKit(z);

						if (tnt.getConfig().getBoolean("GameManager.Server.Tab.Enabled")) {
							TabChanger tab = new TabChanger(tnt);
							tab.ChangeTab(z);
						}
					}

					break;

				}

				if (tnt.getGameManager().getLobbyTimer() <= 0) {
					tnt.getGameManager().setLobbyTimer(0);
					cancel();
				}
			} else {

				cancel();
				tnt.getMessageManager().sendNotEnoughPlayersMessage();
				tnt.getGameManager().setGameState(GameState.LOBBY);
				tnt.getGameManager().setLobbyTimer(tnt.getConfig().getInt("GameManager.Server.LobbyTime"));
				tnt.getLobbyScoreBoard().updateBoardForAllPlayers();

			}
		}
	}

	public void playSound() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			tnt.getSound().playNotePling(p);
			tnt.getSound().playNoteSticks(p);
		}
	}

}
