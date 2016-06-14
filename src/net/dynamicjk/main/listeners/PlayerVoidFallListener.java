package net.dynamicjk.main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;

public class PlayerVoidFallListener implements Listener {

	private TntWars tnt;

	public PlayerVoidFallListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onFall(PlayerMoveEvent e) {
		Player p = e.getPlayer();

		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY) || tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {
			
			if (tnt.getConfig().getBoolean("GameManager.Server.IGNORETHIS")) {

			if (tnt.getConfig().getBoolean("GameManager.Server.Void.Enabled")) {

				if (p.getLocation().getY() <= tnt.getConfig().getDouble("GameManager.Server.Void.Y")) {
					
					p.teleport(tnt.getLocationManager().getLobbyLocation());

				}
			}

			}

		}else if (tnt.getGameManager().getGameState().equals(GameState.INGAME) || tnt.getGameManager().getGameState().equals(GameState.RESTART)) {

			if (tnt.getConfig().getBoolean("GameManager.Server.Void.Enabled")) {
				
				if (tnt.getConfig().getBoolean("GameManager.Server.IGNORETHIS")) {

				if (p.getLocation().getY() <= tnt.getConfig().getDouble("GameManager.Server.Void.Y")) {
					
					p.teleport(tnt.getLocationManager().getGameLocation());

				}

			}
			}
		}
	}
}
