package net.dynamicjk.main.listeners;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;

public class PlayerQuitListener implements Listener {

	private TntWars tnt;

	public PlayerQuitListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY)|| tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {

			e.setQuitMessage(tnt.getMessageManager().playerQuitMessage(p));

			tnt.getLobbyScoreBoard().updateBoardForAllPlayers();

		}
		
		for (Player blocks : Bukkit.getOnlinePlayers()) {
			if (tnt.getMySQL().isEnabled()) {

				try {
					tnt.getConnection().addBlocks(blocks,tnt.getGamePlayers().getPlayers().get(blocks.getName()));
				} catch (ClassNotFoundException | SQLException r) {
					r.printStackTrace();
				}

			}
		}
		
		if (tnt.getGameManager().getGameState().equals(GameState.INGAME)|| tnt.getGameManager().getGameState().equals(GameState.RESTART)) {

			e.setQuitMessage(tnt.getMessageManager().playerQuitMessage(p));

			tnt.getGameScoreboard().updateBoardForAllPlayers();

		}
		
		if(tnt.getGamePlayers().getSpectators().contains(p.getName())){
			e.setQuitMessage(null);
		}

	}

}
