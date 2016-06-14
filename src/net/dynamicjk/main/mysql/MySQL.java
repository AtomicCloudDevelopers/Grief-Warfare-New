package net.dynamicjk.main.mysql;

import net.dynamicjk.main.TntWars;

public class MySQL {
	
	private TntWars tnt;
	
	public MySQL(TntWars tnt){
		this.tnt = tnt;
	}
	
	public boolean isEnabled(){
		return tnt.getConfig().getBoolean("GameManager.MySQL.Enabled");
	}
	
	public String getIp(){
		return tnt.getConfig().getString("GameManager.MySQL.Ip");
	}
	
	public String getUsername(){
		return tnt.getConfig().getString("GameManager.MySQL.Username");
	}

	public String getPassword(){
		return tnt.getConfig().getString("GameManager.MySQL.Password");
	}
	
	public String getDatabase(){
		return tnt.getConfig().getString("GameManager.MySQL.Database");
	}
	
}
