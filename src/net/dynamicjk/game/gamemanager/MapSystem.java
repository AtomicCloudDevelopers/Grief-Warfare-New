package net.dynamicjk.game.gamemanager;

import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import net.dynamicjk.game.locationmanager.LocationManager;
import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.MapResetSystem;

public class MapSystem {

	private String lastMap;

	private String currentArena;

	private TntWars main;

	public MapSystem(TntWars main) {
		this.main = main;
	}

	public void loadArenaWorld() throws IOException {
		if (Bukkit.getWorlds().contains(getArenaName())) {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				LocationManager man = new LocationManager(main);
				ps.teleport(man.getLobbyLocation());
				ps.setGameMode(GameMode.ADVENTURE);
				System.out.println("ddd");
			}
			System.out.println("EE");
			MapResetSystem map = new MapResetSystem();
			map.executeForceReset();
			System.out.println("AA");
			Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {

				@Override
				public void run() {
					System.out.println("NE");
					World world = WorldCreator.name(getArenaName()).createWorld();
					world.setAutoSave(false);
					world.setKeepSpawnInMemory(false);
				}

			}, 60);
		} else {
			System.out.println("HI");
			MapResetSystem map = new MapResetSystem();
			map.executeForceReset();
			Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {

				@Override
				public void run() {
					System.out.println("UI");
					World world = WorldCreator.name(getArenaName()).createWorld();
					world.setAutoSave(false);
					world.setKeepSpawnInMemory(false);
				}

			}, 60);
		}
	}

	public void pickArena() {

		List<String> arenas = main.getConfig().getStringList("Game.Arenas");

		setCurrentArena(arenas.get((int) (Math.random() * arenas.size())));

		if (arenas.size() <= 1) {
			return;
		} else if (getArenaName().equals(this.getOldArena())) {
			pickArena();
		} else {
			lastMap = getArenaName();
		}

	}

	public String getArenaName() {
		return currentArena;
	}

	public String getOldArena() {
		return lastMap;
	}

	public void setCurrentArena(String arena) {
		currentArena = arena;
	}

}
