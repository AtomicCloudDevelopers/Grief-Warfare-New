package net.dynamicjk.game.playerhandlers;

import java.util.ArrayList;
import java.util.HashMap;

import net.dynamicjk.main.TntWars;

public class PlayerCache {

	@SuppressWarnings("unused")
	private TntWars tnt;
	
	private HashMap<String, Integer> players = new HashMap<String,Integer>();
	
	private ArrayList<String> spectators = new ArrayList<String>();

	public PlayerCache(TntWars tnt) {
		this.tnt = tnt;
	}
	
	public HashMap<String, Integer> getPlayers(){
		return players;
	}
	
	public ArrayList<String> getSpectators(){
		return spectators;
	}

}
