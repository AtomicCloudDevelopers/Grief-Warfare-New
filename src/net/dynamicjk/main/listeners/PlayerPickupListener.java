package net.dynamicjk.main.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupListener implements Listener {

	@EventHandler
	public void onPick(PlayerPickupItemEvent e) {
		
		e.setCancelled(true);

	}

}
