package net.dynamicjk.game.shop;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.dynamicjk.main.TntWars;

public class ShopGUI {

	private TntWars tnt;

	private Player p;

	private Inventory inv;

	public ShopGUI(TntWars tnt, Player p) {
		this.tnt = tnt;
		this.p = p;
		inv = Bukkit.createInventory(null, 27, tnt.getMessageManager().getShopGUI());
		setGUI();
	}

	public void setGUI() {

		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);

		for (int i = 0; i < 9; i++) {

			inv.setItem(i, glass);

		}

		inv.setItem(9, glass);

		for (int i = 18; i < 27; i++) {

			inv.setItem(i, glass);

		}

		inv.setItem(17, glass);

		inv.setItem(10, tierTwoTnt());
		inv.setItem(11, tierThreeTnt());

	}

	public void openGUI() {
		p.openInventory(inv);
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
