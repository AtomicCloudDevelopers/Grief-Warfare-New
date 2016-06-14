package net.dynamicjk.game.commands;

import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.MapResetSystem;
import net.md_5.bungee.api.ChatColor;

public class SetupCommands implements CommandExecutor {

	private TntWars tnt;

	public SetupCommands(TntWars tnt) {
		this.tnt = tnt;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("game")) {

			if (!(sender instanceof Player)) {

				sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");

				return true;

			}

			Player p = (Player) sender;

			if (p.hasPermission("game.setup")) {

				if (args.length == 0) {

					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "    Grief Warfare plugin by: " + ChatColor.GOLD
							+ "AtomicCloudDevelopers");
					p.sendMessage(ChatColor.DARK_GRAY + "    Version type: " + ChatColor.AQUA + "Public");
					p.sendMessage(ChatColor.DARK_GRAY + " ");
					p.sendMessage(ChatColor.DARK_GRAY + "    Use the command: " + ChatColor.AQUA + "/game setup");
					p.sendMessage(ChatColor.DARK_GRAY + "    To enter setup manager.");
					p.sendMessage(ChatColor.GREEN + "========================================");

					return true;

				}

				if (args[0].equalsIgnoreCase("setup")) {

					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "    Welcome to the Grief Warfare setup wizard");
					p.sendMessage(ChatColor.DARK_GRAY + "    Set Lobby Location: " + ChatColor.AQUA + "/game setlobby");
					p.sendMessage(ChatColor.RED + "    LOBBY MUST BE IN ITS OWN WORLD (DEFAULT WORLD)");
					p.sendMessage(ChatColor.DARK_GRAY + "    Set load your arenas world" + ChatColor.AQUA
							+ "/game create <World_Name>");
					p.sendMessage(ChatColor.DARK_GRAY + "    Set Game Location: " + ChatColor.AQUA
							+ "/game setgame <World_Name>");
					p.sendMessage(ChatColor.DARK_GRAY + "    Enable/Disbale build mode: " + ChatColor.AQUA
							+ "/game edit <World_Name>");
					p.sendMessage(ChatColor.DARK_GRAY + "    set map name: " + ChatColor.AQUA
							+ "/game setmapname <name> <World_Name>");
					p.sendMessage(ChatColor.DARK_GRAY + "    MOST IMPORTANT COMMAND " + ChatColor.AQUA
							+ "/game saveWorld <World_Name>");
					p.sendMessage(ChatColor.DARK_GRAY + "    Saves world for restore and enables minigame.");
					p.sendMessage(ChatColor.DARK_GRAY + "  ");
					p.sendMessage(ChatColor.RED + "Recommended once saved please restart the server, DO NOT RELOAD.");
					p.sendMessage(ChatColor.GREEN + "========================================");

					return true;

				}

				if (args[0].equalsIgnoreCase("setlobby")) {

					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "    Lobby Location has been set!");
					p.sendMessage(ChatColor.GREEN + "========================================");

					tnt.getSound().playNotePling(p);

					tnt.getLocationManager().setLobbyLocation(p);

					return true;

				}

				if (args[0].equalsIgnoreCase("create")) {

					if (args.length <= 1) {
						p.sendMessage(ChatColor.RED + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "   Proper usage: /game create <WORLD_NAME>");
						p.sendMessage(ChatColor.DARK_GRAY + "   World must exist in main server file");
						p.sendMessage(ChatColor.RED + "========================================");
						return true;
					}

					List<String> arenas = tnt.getConfig().getStringList("Game.Arenas");
					for (String s : arenas) {
						if (s.equalsIgnoreCase(args[1])) {
							p.sendMessage(ChatColor.GREEN + "========================================");
							p.sendMessage(ChatColor.DARK_GRAY + "   World already exists!");
							p.sendMessage(ChatColor.GREEN + "========================================");
							return true;
						}
					}

					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "   Loading world...");
					p.sendMessage(ChatColor.GREEN + "========================================");
					Bukkit.createWorld(WorldCreator.name(args[1])).setAutoSave(true);
					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "   Entering world...");
					p.sendMessage(ChatColor.GREEN + "========================================");
					p.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());
					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "   When you are done make sure");
					p.sendMessage(ChatColor.DARK_GRAY + "   to save world! /game saveworld ");
					p.sendMessage(ChatColor.DARK_GRAY + "   <World_Name>");
					p.sendMessage(ChatColor.GREEN + "========================================");

					arenas.add(args[1]);
					tnt.getConfig().set("Game.Arenas", arenas);
					tnt.saveConfig();

					tnt.getSound().playNotePling(p);

					return true;

				}

				if (args[0].equalsIgnoreCase("reload")) {

					p.sendMessage(ChatColor.GREEN + "========================================");
					p.sendMessage(ChatColor.DARK_GRAY + "    Reload complete!");
					p.sendMessage(ChatColor.GREEN + "========================================");

					tnt.getSound().playNotePling(p);

					tnt.saveConfig();

					return true;

				}

				if (args[0].equalsIgnoreCase("saveWorld")) {

					if (args.length <= 1) {
						p.sendMessage(ChatColor.RED + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "   Proper usage: /game saveworld <WORLD_NAME>");
						p.sendMessage(ChatColor.RED + "========================================");
						return true;
					}

					List<String> arenas = tnt.getConfig().getStringList("Game.Arenas");
					if (!arenas.contains(args[1])) {
						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.RED + "    WORLD WAS NOT CREATED!");
						p.sendMessage(ChatColor.RED + "    (CASE SENSITIVE)");
						p.sendMessage(ChatColor.GREEN + "========================================");
						return true;
					} else {

						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "    World saved!");
						p.sendMessage(ChatColor.GREEN + "========================================");

						tnt.getSound().playNotePling(p);

						tnt.getConfig().set("GameManager.Server.IGNORETHIS", true);
						tnt.getConfig().set("GameManager." + args[1] + ".World", p.getWorld().getName());
						tnt.saveConfig();

						MapResetSystem rs = new MapResetSystem();
						try {
							rs.saveWorld(p, args[1]);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					return true;

				}

				if (args[0].equalsIgnoreCase("setgame")) {

					if (args.length <= 1) {
						p.sendMessage(ChatColor.RED + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "   Proper usage: /game setgame <WORLD_NAME>");
						p.sendMessage(ChatColor.RED + "========================================");
						return true;
					}

					List<String> arenas = tnt.getConfig().getStringList("Game.Arenas");
					if (!arenas.contains(args[1])) {
						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.RED + "    WORLD WAS NOT CREATED!");
						p.sendMessage(ChatColor.RED + "    (CASE SENSITIVE)");
						p.sendMessage(ChatColor.GREEN + "========================================");
						return true;
					} else {

						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "    Game set!");
						p.sendMessage(ChatColor.GREEN + "========================================");

						tnt.getSound().playNotePling(p);

						tnt.getLocationManager().setGameLocation(p, args[1]);
					}

					return true;

				}

				if (args[0].equalsIgnoreCase("setmapname")) {

					if (args.length < 2) {
						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "    Correct usage: /game setmapname <name> <World_Name>");
						p.sendMessage(ChatColor.GREEN + "========================================");
						return true;
					}

					List<String> arenas = tnt.getConfig().getStringList("Game.Arenas");
					if (!arenas.contains(args[2])) {
						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.RED + "    WORLD WAS NOT CREATED!");
						p.sendMessage(ChatColor.RED + "    (CASE SENSITIVE)");
						p.sendMessage(ChatColor.GREEN + "========================================");
						return true;
					} else {

						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(
								ChatColor.DARK_GRAY + "    Map name has been set to: " + args[1].replaceAll("&", "§"));
						p.sendMessage(ChatColor.GREEN + "========================================");

						tnt.getSound().playNotePling(p);
						tnt.getConfig().set("GameManager." + args[2] + ".Name", args[1]);
						tnt.saveConfig();
					}
					return true;

				}

				if (args[0].equalsIgnoreCase("edit")) {

					if (args.length < 1) {
						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "    Correct usage: /game edit <World_Name>");
						p.sendMessage(ChatColor.GREEN + "========================================");
						return true;
					}

					List<String> arenas = tnt.getConfig().getStringList("Game.Arenas");
					if (!arenas.contains(args[1])) {
						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.RED + "    WORLD WAS NOT CREATED!");
						p.sendMessage(ChatColor.RED + "    (CASE SENSITIVE)");
						p.sendMessage(ChatColor.GREEN + "========================================");
						return true;
					} else if (tnt.getPlayerBuildMode().getBuilders().contains(p.getName())) {

						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "    Build mode disabled.");
						p.sendMessage(ChatColor.DARK_GRAY + "    Dont forget to save!");
						p.sendMessage(ChatColor.GREEN + "========================================");
						tnt.getSound().playNotePling(p);
						tnt.getPlayerBuildMode().getBuilders().remove(p.getName());
					} else {

						Bukkit.createWorld(WorldCreator.name(args[1]));

						p.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());

						p.sendMessage(ChatColor.GREEN + "========================================");
						p.sendMessage(ChatColor.DARK_GRAY + "    Build mode enabled.");
						p.sendMessage(ChatColor.GREEN + "========================================");

						tnt.getSound().playNotePling(p);

						tnt.getPlayerBuildMode().getBuilders().add(p.getName());
					}

					return true;

				}

			} else {

				p.sendMessage(ChatColor.GREEN + "========================================");
				p.sendMessage(ChatColor.DARK_GRAY + "    Grief Warfare plugin by: " + ChatColor.GOLD
						+ "AtomicCloudDevelopers");
				p.sendMessage(ChatColor.DARK_GRAY + "    Version type: " + ChatColor.AQUA + "Public");
				p.sendMessage(ChatColor.GREEN + "========================================");

			}
		}
		return false;
	}

}
