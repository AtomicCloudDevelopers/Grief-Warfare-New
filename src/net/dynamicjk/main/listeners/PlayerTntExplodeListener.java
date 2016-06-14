package net.dynamicjk.main.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.TabChanger;

public class PlayerTntExplodeListener implements Listener {

	private TntWars tnt;

	public PlayerTntExplodeListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onExplode(EntityExplodeEvent event) {
		if (event.getEntity().hasMetadata("primedBy")) {
			Player player = Bukkit.getPlayer(event.getEntity().getMetadata("primedBy").get(0).asString());

			int blocksBroken = event.blockList().size();
			
			for (Block block : event.blockList()) {
				block.setType(Material.AIR);
				}

			tnt.getGamePlayers().getPlayers().put(player.getName(), tnt.getGamePlayers().getPlayers().get(player.getName()) + blocksBroken);
			
			if(tnt.getConfig().getBoolean("GameManager.Server.Tab.Enabled")){
				TabChanger tab = new TabChanger(tnt);
				tab.ChangeTab(player);
			}

		}
	}

}
