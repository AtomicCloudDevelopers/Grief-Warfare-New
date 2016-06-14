package net.dynamicjk.main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;

public class PlayerInventoryListener implements Listener {

	private TntWars tnt;

	public PlayerInventoryListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();

		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY)
				|| tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)
				|| tnt.getGameManager().getGameState().equals(GameState.INGAME)
				|| tnt.getGameManager().getGameState().equals(GameState.RESTART)) {

			if (tnt.getPlayerBuildMode().getBuilders().contains(p.getName())) {
				e.setCancelled(false);
			}else{
				e.setCancelled(true);
			}
		}
	}

}
