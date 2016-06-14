package net.dynamicjk.main.util;

import java.util.Collections;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;

public class HashMapPlayerWinner {

	private TntWars tnt;

	public HashMapPlayerWinner(TntWars tnt) {
		this.tnt = tnt;
	}

	public Player getWinner() {
		int max = Collections.max(tnt.getGamePlayers().getPlayers().values());

		String winner = null;

		for (Map.Entry<String, Integer> entry : tnt.getGamePlayers().getPlayers().entrySet()) {
			if (entry.getValue().equals(max)) {
				winner = entry.getKey();
				break;
			}
		}

		return Bukkit.getPlayer(winner);
	}
	
	
	public String getStringWinner() {
		int max = Collections.max(tnt.getGamePlayers().getPlayers().values());

		String winner = null;

		for (Map.Entry<String, Integer> entry : tnt.getGamePlayers().getPlayers().entrySet()) {
			if (entry.getValue().equals(max)) {
				winner = entry.getKey();
				break;
			}
		}

		return winner;
	}

}
