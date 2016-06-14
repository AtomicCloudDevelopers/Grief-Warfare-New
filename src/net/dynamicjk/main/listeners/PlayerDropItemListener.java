package net.dynamicjk.main.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import net.dynamicjk.main.TntWars;

public class PlayerDropItemListener implements Listener {

	private TntWars tnt;

	public PlayerDropItemListener(TntWars tnt) {
		this.tnt = tnt;

	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {

		if (tnt.getPlayerBuildMode().getBuilders().contains(e.getPlayer().getName())) {

			e.setCancelled(false);

		} else {

			e.setCancelled(true);

		}

	}

}
