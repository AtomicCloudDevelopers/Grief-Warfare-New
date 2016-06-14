package net.dynamicjk.main.listeners;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.game.timers.LobbyTimer;
import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.Title;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoinListener implements Listener {

	private TntWars tnt;

	public PlayerJoinListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws ClassNotFoundException, SQLException {
		Player p = e.getPlayer();

		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY)
				|| tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {

			tnt.getMessageManager().sendJoinMessage(p);

			tnt.getSound().playNotePling(p);
			tnt.getSound().playNoteSticks(p);

			p.setGameMode(GameMode.ADVENTURE);
			p.setHealth(20);
			p.setFoodLevel(20);

			p.getInventory().clear();

			for (Player ps : Bukkit.getOnlinePlayers()) {
				ps.showPlayer(p);
			}

			if (tnt.getConfig().getBoolean("GameManager.Messages.Title.JoinTitle.Enabled")) {
				sendTitle(p);
			}

			if (tnt.getConfig().getBoolean("GameManager.Server.IGNORETHIS")) {
				p.teleport(tnt.getLocationManager().getLobbyLocation());

				tnt.getLobbyScoreBoard().updateBoardForAllPlayers();
			} else {
				if (p.isOp()) {
					p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD
							+ "WARNING PLUGIN HAS NOT BEEN SETUP, PLEASE SETUP THE PLUGIN /GAME");
				}
			}

			if (tnt.getMySQL().isEnabled()) {
				tnt.getConnection().createUserStatements(p);
			}

			e.setJoinMessage(tnt.getMessageManager().playerJoinMessage(p));

			tnt.getGamePlayers().getPlayers().put(p.getName(), 0);

			if (Bukkit.getOnlinePlayers().size() >= tnt.getGameManager().getMinPlayers()) {

				if (!tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {
					tnt.getGameManager().setGameState(GameState.LOBBY_START);
					if (tnt.getConfig().getBoolean("GameManager.Server.IGNORETHIS")) {
						new LobbyTimer().runTaskTimer(tnt, 20, 20);
					}
				}
				tnt.getMessageManager().sendGameIsStartingMessage();

			}

		} else if (tnt.getGameManager().getGameState().equals(GameState.INGAME)
				|| tnt.getGameManager().getGameState().equals(GameState.RESTART)) {
			if (tnt.getConfig().getBoolean("GameManager.Server.KickIfFull")) {
				p.kickPlayer(tnt.getConfig().getString("GameManager.Messages.GameIsFull").replaceAll("&", "§"));
			} else {
				p.setGameMode(GameMode.ADVENTURE);
				p.setAllowFlight(true);
				p.setFlying(true);
				e.setJoinMessage(null);
				p.getInventory().clear();
				tnt.getGamePlayers().getPlayers().put(p.getName(), 0);
				tnt.getGamePlayers().getSpectators().add(p.getName());
				for (Player ps : Bukkit.getOnlinePlayers()) {
					ps.hidePlayer(p);
				}
			}
		}

	}

	public void sendTitle(Player p) {
		Title title = new Title();
		title.setStay(80);
		title.setFadeIn(40);
		title.setFadeOut(40);
		title.setTitle(tnt.getMessageManager().getJoinTitle(p));
		title.setSubtitle(tnt.getMessageManager().getJoinSubTitle(p));
		title.send(p);
	}

}
