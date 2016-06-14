package net.dynamicjk.main.listeners;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.dynamicjk.main.TntWars;

public class PlayerInventoryClickListener implements Listener {

	private TntWars tnt;

	public PlayerInventoryClickListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		if (e.getWhoClicked() instanceof Player) {

			Player p = (Player) e.getWhoClicked();

			if (e.getCurrentItem() != null) {

				if (e.getInventory().getName().equalsIgnoreCase(tnt.getMessageManager().getShopGUI())) {

					e.setCancelled(true);

					ItemStack item = e.getCurrentItem();

					if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(tnt.getMessageManager().getTierTwoName())) {

						if (tnt.getGamePlayers().getPlayers().get(p.getName()) >= tnt.getConfig()
								.getInt("GameManager.Server.Shop.TierTwoUnlock")) {

							p.sendMessage(tnt.getMessageManager().getItemPurchased());

							tnt.getSound().playNotePling(p);

							p.getInventory().addItem(tierTwoTnt());

						} else {

							p.sendMessage(tnt.getMessageManager().getNotEnoughBlocks("TierTwoLore", "TierTwoUnlock"));
							tnt.getSound().playNotePling(p);

						}

					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(tnt.getMessageManager().getTierThreeName())) {

						if (tnt.getGamePlayers().getPlayers().get(p.getName()) >= tnt.getConfig()
								.getInt("GameManager.Server.Shop.TierThreeUnlock")) {

							p.sendMessage(tnt.getMessageManager().getItemPurchased());

							tnt.getSound().playNotePling(p);

							p.getInventory().addItem(tierThreeTnt());

						} else {

							p.sendMessage(
									tnt.getMessageManager().getNotEnoughBlocks("TierThreeLore", "TierThreeUnlock"));
							tnt.getSound().playNotePling(p);

						}

					}

				}

			}

		}

	}

	public ItemStack tierTwoTnt() {
		ItemStack tnts = new ItemStack(Material.TNT);
		ItemMeta tntM = tnts.getItemMeta();
		tntM.setDisplayName(tnt.getMessageManager().getTierTwoName());
		tntM.setLore(Arrays.asList(tnt.getMessageManager().getTierTwoLore()));
		tnts.setItemMeta(tntM);
		return tnts;
	}

	public ItemStack tierThreeTnt() {
		ItemStack tnts = new ItemStack(Material.TNT);
		ItemMeta tntM = tnts.getItemMeta();
		tntM.setDisplayName(tnt.getMessageManager().getTierThreeName());
		tntM.setLore(Arrays.asList(tnt.getMessageManager().getTierThreeLore()));
		tnts.setItemMeta(tntM);
		return tnts;
	}
}
