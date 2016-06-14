package net.dynamicjk.game.timers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.dynamicjk.game.api.PlayerWinEvent;
import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.Title;

public class GameTimer extends BukkitRunnable {

	private TntWars tnt = TntWars.getInstance;

	private ArrayList<String> players = new ArrayList<String>();

	@Override
	public void run() {

		if (tnt.getGameManager().getGameState().equals(GameState.INGAME)) {
			if (Bukkit.getOnlinePlayers().size() >= tnt.getGameManager().getMinPlayers()) {

				tnt.getGameManager().setGameTimer(tnt.getGameManager().getGameTimer() - 1);
				tnt.getGameScoreboard().updateBoardForAllPlayers();

				switch (tnt.getGameManager().getGameTimer()) {

				case 798:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 700:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 600:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 500:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 400:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 300:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 200:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 100:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 60:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 50:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 40:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 30:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 20:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 10:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 5:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;

				case 4:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;

				case 3:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;

				case 2:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;

				case 1:

					tnt.getMessageManager().sendGameEnding();
					playSound();

					break;
				case 0:

					playSound();
					tnt.getMessageManager().sendGameHasEnded();

					if (tnt.getMySQL().isEnabled()) {
						if (tnt.getGameStats().getWinner() != null) {
							try {
								tnt.getConnection().addWins(tnt.getGameStats().getWinner(), 1);
								Bukkit.getPluginManager().callEvent(new PlayerWinEvent(tnt.getGameStats().getWinner()));
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
					}

					for (Player loose : Bukkit.getOnlinePlayers()) {
						if ((loose.getName() != tnt.getGameStats().getStringWinner())) {
							if (tnt.getMySQL().isEnabled()) {
								try {
									tnt.getConnection().addLooses(loose, 1);
								} catch (ClassNotFoundException | SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}

					runBlocks();

					if (tnt.getConfig().getBoolean("GameManager.Messages.Title.WinTitle.Enabled")) {

						for (Player j : Bukkit.getOnlinePlayers()) {
							sendTitle(j);
						}

					}

					new RestartTimer().runTaskTimer(tnt, 20, 20);

					if (tnt.getMySQL().isEnabled()) {
						try {
							tnt.getCoins().giveWinnerCoins();
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}

					for (Player z : Bukkit.getOnlinePlayers()) {

						z.setGameMode(GameMode.CREATIVE);

						tnt.getGameManager().setGameState(GameState.RESTART);
					}

					break;

				}

				if (tnt.getGameManager().getGameTimer() <= 0) {
					tnt.getGameManager().setGameTimer(0);
					cancel();
				}
			} else {

				cancel();
				tnt.getMessageManager().sendNotEnoughPlayersMessage();
				tnt.getGameManager().setGameState(GameState.RESTART);
				tnt.getGameManager().setLobbyTimer(tnt.getConfig().getInt("GameManager.Server.LobbyTime"));
				tnt.getLobbyScoreBoard().updateBoardForAllPlayers();
				new RestartTimer().runTaskTimer(tnt, 20, 20);

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

	public void sendTitle(Player p) {
		Title title = new Title();
		title.setStay(80);
		title.setFadeIn(40);
		title.setFadeOut(40);
		title.setTitle(tnt.getMessageManager().getWinTitle(p));
		title.setSubtitle(tnt.getMessageManager().getWinSubTitle(p));
		title.send(p);
	}

	public void runBlocks() {
		for (Player blocks : Bukkit.getOnlinePlayers()) {
			if (tnt.getMySQL().isEnabled()) {

				try {
					if (!players.contains(blocks.getName())) {
						tnt.getConnection().addBlocks(blocks, tnt.getGamePlayers().getPlayers().get(blocks.getName()));
						players.add(blocks.getName());
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
