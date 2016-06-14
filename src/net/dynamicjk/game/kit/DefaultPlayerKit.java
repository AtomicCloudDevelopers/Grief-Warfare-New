package net.dynamicjk.game.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.dynamicjk.main.TntWars;

public class DefaultPlayerKit {

	private TntWars tnt;

	public DefaultPlayerKit(TntWars tnt) {
		this.tnt = tnt;
	}

	public void giveKit(Player p) {

		ItemStack tntr = new ItemStack(Material.TNT);
		ItemMeta tntm = tntr.getItemMeta();
		tntm.setDisplayName(tnt.getMessageManager().getTntName());
		tntr.setItemMeta(tntm);

		p.getInventory().setItem(0, tntr);

		if (tnt.getConfig().getBoolean("GameManager.Server.Shop.Enabled")) {

			ItemStack shop = new ItemStack(Material.WORKBENCH);
			ItemMeta shopm = shop.getItemMeta();
			shopm.setDisplayName(tnt.getMessageManager().getShopName());
			shop.setItemMeta(shopm);

			p.getInventory().setItem(4, shop);

		}

		
		if (tnt.getConfig().getBoolean("GameManager.Server.LobbyItem.Enabled")) {
		ItemStack extra = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta extram = extra.getItemMeta();
		extram.setDisplayName(tnt.getMessageManager().getExtraName());
		extra.setItemMeta(extram);

		p.getInventory().setItem(8, extra);
		}

	}

}
