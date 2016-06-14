package net.dynamicjk.main.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

import net.dynamicjk.game.api.PlayerPlaceTNTEvent;
import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;

public class PlayerBlockPlaceListener implements Listener {

	private TntWars tnt;

	public PlayerBlockPlaceListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY)
				|| tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {
			if (!tnt.getPlayerBuildMode().getBuilders().contains(e.getPlayer().getName())) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}
		if (tnt.getGameManager().getGameState().equals(GameState.RESTART)) {
			if (!tnt.getPlayerBuildMode().getBuilders().contains(e.getPlayer().getName())) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}
		if (tnt.getGameManager().getGameState().equals(GameState.INGAME)) {

			if (e.getBlock().getType().equals(Material.WORKBENCH)) {

				e.setCancelled(true);

			}

			if (e.getBlock().getType().equals(Material.TNT)) {

				if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName()
						.equals(tnt.getMessageManager().getTntName())) {

					e.setCancelled(true);
					e.getPlayer().getInventory().addItem();
					TNTPrimed primed = e.getBlock().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class);
					primed.setMetadata("primedBy", new FixedMetadataValue(tnt, e.getPlayer().getName()));
					primed.setYield(tnt.getConfig().getInt("GameManager.Kit.Default.TntExplosion"));
					primed.setFuseTicks(10);
					Bukkit.getPluginManager().callEvent(new PlayerPlaceTNTEvent(e.getPlayer(), primed));
				} else if (e.getPlayer().getPlayer().getItemInHand().getItemMeta().getDisplayName()
						.equals(tnt.getMessageManager().getTierTwoName())) {
					e.setCancelled(true);
					e.getPlayer().getInventory().addItem();
					TNTPrimed primed = e.getBlock().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class);
					primed.setMetadata("primedBy", new FixedMetadataValue(tnt, e.getPlayer().getName()));
					primed.setFuseTicks(40);
					primed.setYield(tnt.getConfig().getInt("GameManager.Server.Shop.TierTwoTntExplosion"));
					Bukkit.getPluginManager().callEvent(new PlayerPlaceTNTEvent(e.getPlayer(), primed));
				} else if (e.getPlayer().getPlayer().getItemInHand().getItemMeta().getDisplayName()
						.equals(tnt.getMessageManager().getTierThreeName())) {
					e.setCancelled(true);
					e.getPlayer().getInventory().addItem();
					TNTPrimed primed = e.getBlock().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class);
					primed.setMetadata("primedBy", new FixedMetadataValue(tnt, e.getPlayer().getName()));
					primed.setFuseTicks(70);
					primed.setYield(tnt.getConfig().getInt("GameManager.Server.Shop.TierThreeTntExplosion"));
					Bukkit.getPluginManager().callEvent(new PlayerPlaceTNTEvent(e.getPlayer(), primed));
				}
			}
		}
	}

}
