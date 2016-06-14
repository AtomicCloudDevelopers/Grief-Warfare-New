package net.dynamicjk.main.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.listeners.shop.ItemRightClickListener;

public class RegisterListeners {
	
	@SuppressWarnings("unused")
	private TntWars tnt;
	
	private PluginManager pl = Bukkit.getPluginManager();
	
	public RegisterListeners(TntWars tnt){
		this.tnt = tnt;
		pl.registerEvents(new PlayerJoinListener(tnt), tnt);
		pl.registerEvents(new PlayerQuitListener(tnt), tnt);
		pl.registerEvents(new PlayerPvPListener(tnt), tnt);
		pl.registerEvents(new PlayerBlockBreakListener(tnt), tnt);
		pl.registerEvents(new PlayerBlockPlaceListener(tnt), tnt);
		pl.registerEvents(new PlayerTntExplodeListener(tnt), tnt);
		pl.registerEvents(new PlayerFoodChangeListener(), tnt);
		pl.registerEvents(new BukkitReloadListener(), tnt);
		pl.registerEvents(new PlayerVoidFallListener(tnt), tnt);
		pl.registerEvents(new PlayerInventoryListener(tnt), tnt);
		pl.registerEvents(new SeverPingListener(tnt), tnt);
		pl.registerEvents(new PlayerDropItemListener(tnt), tnt);
		pl.registerEvents(new ItemRightClickListener(tnt), tnt);
		pl.registerEvents(new PlayerPickupListener(), tnt);
		pl.registerEvents(new PlayerInventoryClickListener(tnt), tnt);
		pl.registerEvents(new PlayerDamageListener(), tnt);
		pl.registerEvents(new WeatherChangeListener(), tnt);
	}

}
