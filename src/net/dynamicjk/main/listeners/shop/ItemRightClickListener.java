package net.dynamicjk.main.listeners.shop;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.game.shop.ShopGUI;
import net.dynamicjk.main.TntWars;

public class ItemRightClickListener implements Listener {

	private TntWars tnt;

	public ItemRightClickListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e) {

		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

			Player p = e.getPlayer();
			
			

			if (p.getItemInHand() != null) {

				ItemStack item = p.getItemInHand();

				if (item.getType().equals(Material.WORKBENCH) && item.getItemMeta().getDisplayName().equals(tnt.getMessageManager().getShopName())) {

					if (tnt.getGameManager().getGameState().equals(GameState.INGAME)) {

						if (tnt.getConfig().getBoolean("GameManager.Server.Shop.Enabled")) {

							tnt.getSound().playNoteBass(p);

							ShopGUI gui = new ShopGUI(tnt, p);
							gui.openGUI();
						}

					}
				}

			} else {
				return;
			}

		}

	}

}
