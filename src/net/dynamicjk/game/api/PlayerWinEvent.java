package net.dynamicjk.game.api;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerWinEvent extends Event {

	Player p;

	public PlayerWinEvent(Player p) {
		this.p = p;
	}

	public Player getWinningPlayer() {
		return p;
	}

	public ArrayList<Player> getLoosingPlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		for (Player ps : Bukkit.getOnlinePlayers()) {
			players.add(ps);
		}
		players.remove(p);
		return players;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}