package net.dynamicjk.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.game.timers.LobbyTimer;
import net.dynamicjk.main.TntWars;

public class MapResetSystem {

	private static void copyFileUsingFileStreams(File source, File dest) throws IOException {

		FileUtils.copyDirectory(source, dest);

	}

	public void runMaps() {
		File dir = new File("GriefMaps");
		if (!dir.exists()) {
			dir.mkdir();
		} else {
		}
	}

	public void saveWorld(Player p, String name) throws IOException {
		p.getWorld().save();
		File worldSource = new File(name);
		File target = new File("GriefMaps/" + name);
		if (!target.exists()) {
			target.mkdirs();
		}
		copyFileUsingFileStreams(worldSource, target);

	}

	public void executeReset() throws IOException {
		Bukkit.unloadWorld(TntWars.getInstance.getMapSystem().getArenaName(), false);
		File source = FileUtils.getFile("GriefMaps/" + TntWars.getInstance.getMapSystem().getArenaName());
		File target = new File(TntWars.getInstance.getMapSystem().getArenaName());
		copyWorld(source, target);
		source = null;
		target = null;
		TntWars.getInstance.getMapSystem().pickArena();
		TntWars.getInstance.getMapSystem().loadArenaWorld();
		TntWars.getInstance.getGameManager().setGameState(GameState.LOBBY);
		TntWars.getInstance.getGameManager()
				.setLobbyTimer(TntWars.getInstance.getConfig().getInt("GameManager.Server.LobbyTime"));
		TntWars.getInstance.getGameManager()
				.setGameTimer(TntWars.getInstance.getConfig().getInt("GameManager.Server.GameTime"));
		TntWars.getInstance.getGameManager()
				.setRestartTimer(TntWars.getInstance.getConfig().getInt("GameManager.Server.RestartTime"));
		for (Player ps : Bukkit.getOnlinePlayers()) {
			ps.getInventory().clear();
		}
		if (Bukkit.getOnlinePlayers().size() >= TntWars.getInstance.getGameManager().getMinPlayers()) {
			TntWars.getInstance.getGameManager().setGameState(GameState.LOBBY_START);
			new LobbyTimer().runTaskTimer(TntWars.getInstance, 20, 20);
		}else{
			TntWars.getInstance.getLobbyScoreBoard().updateBoardForAllPlayers();
		}
	}

	public void executeForceReset() throws IOException {
		if (Bukkit.getWorlds().contains(TntWars.getInstance.getMapSystem().getArenaName())) {
			Bukkit.unloadWorld(TntWars.getInstance.getMapSystem().getArenaName(), false);
		}
		File source = FileUtils.getFile("GriefMaps/" + TntWars.getInstance.getMapSystem().getArenaName());
		File target = new File(TntWars.getInstance.getMapSystem().getArenaName());
		copyWorld(source, target);
		source = null;
		target = null;
	}
	
	public void copyWorld(File source, File target) {
		try {
			ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("session.dat"));
			if (!ignore.contains(source.getName())) {
				if (source.isDirectory()) {
					if (!target.exists())
						target.mkdirs();
					String files[] = source.list();
					for (String file : files) {
						File srcFile = new File(source, file);
						File destFile = new File(target, file);
						copyWorld(srcFile, destFile);
					}
				} else {
					InputStream in = new FileInputStream(source);
					OutputStream out = new FileOutputStream(target);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = in.read(buffer)) > 0)
						out.write(buffer, 0, length);
					in.close();
					out.close();
				}
			}
		} catch (IOException e) {

		}
	}

}
