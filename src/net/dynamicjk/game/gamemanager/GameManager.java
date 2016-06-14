package net.dynamicjk.game.gamemanager;

import net.dynamicjk.main.TntWars;

public class GameManager {

	@SuppressWarnings("unused")
	private TntWars tnt;

	private int lobby_timer;
	private int game_timer;
	private int restart_timer;

	private int minPlayers;
	private int maxPlayers;

	private GameState state;

	public GameManager(TntWars tnt) {
		this.tnt = tnt;

		state = GameState.LOBBY;

		lobby_timer = tnt.getConfig().getInt("GameManager.Server.LobbyTime");
		game_timer = tnt.getConfig().getInt("GameManager.Server.GameTime");
		restart_timer = tnt.getConfig().getInt("GameManager.Server.RestartTime");

		minPlayers = tnt.getConfig().getInt("GameManager.Server.MinPlayers");
		maxPlayers = tnt.getConfig().getInt("GameManager.Server.MaxPlayers");

	}

	public int getLobbyTimer() {
		return lobby_timer;
	}

	public int getGameTimer() {
		return game_timer;
	}

	public int getRestartTimer() {
		return restart_timer;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setLobbyTimer(int i) {
		this.lobby_timer = i;
	}

	public void setGameTimer(int i) {
		this.game_timer = i;
	}

	public void setRestartTimer(int i) {
		this.restart_timer = i;
	}

	public GameState getGameState() {
		return state;
	}

	public void setGameState(GameState state) {
		this.state = state;
	}

}
