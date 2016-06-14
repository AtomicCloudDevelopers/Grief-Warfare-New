package net.dynamicjk.game.playerhandlers;

import java.util.ArrayList;

import net.dynamicjk.main.TntWars;

public class PlayerBuildCache {
	
	@SuppressWarnings("unused")
	private TntWars tnt;
	
	private ArrayList<String> players = new ArrayList<String>();
	
	public PlayerBuildCache(TntWars tnt){
		this.tnt = tnt;
	}
	
	public ArrayList<String> getBuilders(){
		return players;
	}
	
	

}
