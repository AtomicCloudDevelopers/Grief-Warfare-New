package net.dynamicjk.main.util;

import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;

public class TabChanger {
	
	private TntWars tnt;
	
	public TabChanger(TntWars tnt){
		this.tnt = tnt;
	}
	
	public void ChangeTab(Player p){
		
		p.setPlayerListName(tnt.getMessageManager().getPlayerListName(p));
		
	}

}
