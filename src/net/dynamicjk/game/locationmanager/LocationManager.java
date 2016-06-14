package net.dynamicjk.game.locationmanager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;

public class LocationManager {

	private TntWars tnt;

	public LocationManager(TntWars tnt) {
		this.tnt = tnt;
	}

	public void setLobbyLocation(Player p) {

		tnt.getConfig().set("GameManager.Game.Lobby.world", p.getLocation().getWorld().getName());
		tnt.getConfig().set("GameManager.Game.Lobby.x", p.getLocation().getX());
		tnt.getConfig().set("GameManager.Game.Lobby.y", p.getLocation().getY());
		tnt.getConfig().set("GameManager.Game.Lobby.z", p.getLocation().getZ());

		tnt.getConfig().set("GameManager.Game.Lobby.yaw", p.getLocation().getYaw());
		tnt.getConfig().set("GameManager.Game.Lobby.pitch", p.getLocation().getPitch());

		tnt.saveConfig();

	}

	public Location getLobbyLocation() {
		Location loc = null;

		World w = Bukkit.getWorld(tnt.getConfig().getString("GameManager.Game.Lobby.world"));
		double x = tnt.getConfig().getDouble("GameManager.Game.Lobby.x");
		double y = tnt.getConfig().getDouble("GameManager.Game.Lobby.y");
		double z = tnt.getConfig().getDouble("GameManager.Game.Lobby.z");

		float yaw = (float) tnt.getConfig().getDouble("GameManager.Game.Lobby.yaw");
		float pitch = (float) tnt.getConfig().getDouble("GameManager.Game.Lobby.pitch");

		loc = new Location(w, x, y, z, yaw, pitch);

		return loc;
	}

	public void setGameLocation(Player p, String name) {

		tnt.getConfig().set("GameManager." + name + ".Game.world", p.getLocation().getWorld().getName());
		tnt.getConfig().set("GameManager." + name + ".Game.x", p.getLocation().getX());
		tnt.getConfig().set("GameManager." + name + ".Game.y", p.getLocation().getY());
		tnt.getConfig().set("GameManager." + name + ".Game.z", p.getLocation().getZ());

		tnt.getConfig().set("GameManager." + name + ".Game.yaw", p.getLocation().getYaw());
		tnt.getConfig().set("GameManager." + name + ".Game.pitch", p.getLocation().getPitch());

		tnt.saveConfig();

	}

	public Location getGameLocation() {
		Location loc = null;

		World w = Bukkit.getWorld(
				tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Game.world"));
		double x = tnt.getConfig().getDouble("GameManager." + tnt.getMapSystem().getArenaName() + ".Game.x");
		double y = tnt.getConfig().getDouble("GameManager." + tnt.getMapSystem().getArenaName() + ".Game.y");
		double z = tnt.getConfig().getDouble("GameManager." + tnt.getMapSystem().getArenaName() + ".Game.z");

		float yaw = (float) tnt.getConfig().getDouble("GameManager." + tnt.getMapSystem().getArenaName() + ".Game.yaw");
		float pitch = (float) tnt.getConfig()
				.getDouble("GameManager." + tnt.getMapSystem().getArenaName() + ".Game.pitch");

		loc = new Location(w, x, y, z, yaw, pitch);

		return loc;
	}

}
