package net.dynamicjk.main;

import java.io.IOException;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.plugin.java.JavaPlugin;

import net.dynamicjk.game.coins.Coins;
import net.dynamicjk.game.commands.SetupCommands;
import net.dynamicjk.game.gamemanager.GameManager;
import net.dynamicjk.game.gamemanager.MapSystem;
import net.dynamicjk.game.locationmanager.LocationManager;
import net.dynamicjk.game.messages.MessageManager;
import net.dynamicjk.game.playerhandlers.PlayerBuildCache;
import net.dynamicjk.game.playerhandlers.PlayerCache;
import net.dynamicjk.game.scoreboards.GameScoreboard;
import net.dynamicjk.game.scoreboards.LobbyScoreBoard;
import net.dynamicjk.main.listeners.RegisterListeners;
import net.dynamicjk.main.metrics.Metrics;
import net.dynamicjk.main.mysql.DataBaseConnectionCreator;
import net.dynamicjk.main.mysql.MySQL;
import net.dynamicjk.main.util.HashMapPlayerWinner;
import net.dynamicjk.main.util.MapResetSystem;
import net.dynamicjk.main.util.Sounds;
import net.dynamicjk.main.util.sounds.MC_V1_8;
import net.dynamicjk.main.util.sounds.MC_V1_9;

public class TntWars extends JavaPlugin {

	public static TntWars getInstance = null;

	private GameManager gameManager;

	private PlayerCache playerCache;

	private MessageManager message;

	private LocationManager loc;

	private LobbyScoreBoard lsb;

	private PlayerBuildCache playerBuild;

	private HashMapPlayerWinner hmp;

	@SuppressWarnings("unused")
	private RegisterListeners rl;

	private GameScoreboard gsb;

	private MapResetSystem rs;

	private MySQL mysql;

	private DataBaseConnectionCreator connection;

	private Coins coins;

	private Sounds sound;

	private String version;

	private MapSystem system;

	@Override
	public void onEnable() {
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
		}
		saveDefaultConfig();
		getInstance = this;
		setVersion();
		hmp = new HashMapPlayerWinner(this);
		playerCache = new PlayerCache(this);
		gameManager = new GameManager(this);
		message = new MessageManager(this);
		loc = new LocationManager(this);
		rl = new RegisterListeners(this);
		lsb = new LobbyScoreBoard(this);
		gsb = new GameScoreboard(this);
		playerBuild = new PlayerBuildCache(this);
		mysql = new MySQL(this);
		setMapSystem(new MapSystem(this));
		setConfigVariables();
		basicSetup();

		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		getCommand("game").setExecutor(new SetupCommands(this));
		System.out.println("Plugin has been enabled");

		rs = new MapResetSystem();
		system.pickArena();
		rs.runMaps();

		if (mysql.isEnabled()) {

			try {
				setConnection(new DataBaseConnectionCreator());
				coins = new Coins(this);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void onDisable() {
		getInstance = null;
		System.out.println("Plugin has been disabled");

	}

	public GameManager getGameManager() {
		return gameManager;
	}

	public Sounds getSound() {
		return sound;
	}

	public void setSound(Sounds sound) {
		this.sound = sound;
	}

	public PlayerCache getGamePlayers() {
		return playerCache;
	}

	public MessageManager getMessageManager() {
		return message;
	}

	public LocationManager getLocationManager() {
		return loc;
	}

	public LobbyScoreBoard getLobbyScoreBoard() {
		return lsb;
	}

	public GameScoreboard getGameScoreboard() {
		return gsb;
	}

	public PlayerBuildCache getPlayerBuildMode() {
		return playerBuild;
	}

	public HashMapPlayerWinner getGameStats() {
		return hmp;
	}

	public void basicSetup() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				if (getConfig().getBoolean("GameManager.Server.IGNORETHIS")) {
					Bukkit.getWorld(getConfig().getString("GameManager.Server.World")).setStorm(false);
					Bukkit.getWorld(getConfig().getString("GameManager.Server.World"))
							.setDifficulty(Difficulty.PEACEFUL);
					Bukkit.getWorld(getConfig().getString("GameManager.Server.World")).setThunderDuration(0);
					Bukkit.getWorld(getConfig().getString("GameManager.Server.World")).setThundering(false);
					Bukkit.getWorld(getConfig().getString("GameManager.Server.World")).setWeatherDuration(0);
				}

			}

		}, 120, 120);

	}

	public void setConfigVariables() {
		if (!(getConfig().contains("GameManager.Messages.Shop.TierThree"))) {

			getConfig().set("GameManager.Messages.Shop.TierThree", "&6Tier Three");
			getConfig().set("GameManager.Messages.Shop.TierThreeLore", "&cBlocks required %blockreq%");
			getConfig().set("GameManager.Server.Shop.TierThreeTntExplosion", 15);
			getConfig().set("GameManager.Server.Shop.TierThreeUnlock", 15000);

		}
	}

	public DataBaseConnectionCreator getConnection() {
		return connection;
	}

	public void setConnection(DataBaseConnectionCreator connection) {
		this.connection = connection;
	}

	public MySQL getMySQL() {
		return mysql;
	}

	public Coins getCoins() {
		return coins;
	}

	public void setVersion() {

		try {

			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];

		} catch (ArrayIndexOutOfBoundsException whatVersionAreYouUsingException) {
			return;
		}

		if ("v1_8_R3".equals(version)) {
			version = "v1_8_R3";
			setSound(new MC_V1_8());
		} else if ("v1_9_R1".equals(version)) {
			version = "v1_9_R1";
			setSound(new MC_V1_9());
		} else if ("v1_10_R1".equals(version)) {
			version = "v1_10_R1";
			setSound(new MC_V1_9());
		} else {
			version = null;
			System.out.println("Grief Warfare has failed to startup unable to identify server version.");
		}
	}

	public MapSystem getMapSystem() {
		return system;
	}

	public void setMapSystem(MapSystem system) {
		this.system = system;
	}

}
