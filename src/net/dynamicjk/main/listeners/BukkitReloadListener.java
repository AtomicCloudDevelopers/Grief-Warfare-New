package net.dynamicjk.main.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.md_5.bungee.api.ChatColor;

public class BukkitReloadListener implements Listener{
	
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onPreprocess(PlayerCommandPreprocessEvent event)
	  {
	    Player p = event.getPlayer();
	    String command = event.getMessage();
	    command = command.substring(1).split("   ")[0];
	    List<String> commands = new ArrayList<String>();
	    commands.add("rl");
	    commands.add("RL");
	    commands.add("RELOAD");
	    commands.add("BUKKIT:RL");
	    commands.add("BUKKIT:RELOAD");
	    commands.add("reload");
	    commands.add("bukkit:rl");
	    commands.add("bukkit:reload");
	    
	    for(int i = 0 ;i < commands.size(); i++){
	    	if(command.equalsIgnoreCase(commands.get(i))){
	  	      event.setCancelled(true);
		      p.sendMessage(ChatColor.RED + "ERROR: This command is blocked to pervent errors with the Grief warfare Plugin, please save everything and restart the server.");
		      return;
	    	}
	    }
	    
	  }

}
