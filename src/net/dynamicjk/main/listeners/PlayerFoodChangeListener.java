package net.dynamicjk.main.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodChangeListener implements Listener{

	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
}
