package net.dynamicjk.main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;

public class PlayerPvPListener implements Listener {

	private TntWars tnt;

	public PlayerPvPListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY)|| tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {
			e.setCancelled(true);
		}
		if(e.getEntity() instanceof Player){
		if(tnt.getGamePlayers().getSpectators().contains(e.getEntity().getName())){
			e.setCancelled(true);
		}
		}
	}

}
