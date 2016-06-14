package net.dynamicjk.main.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;

public class SeverPingListener implements Listener {

	private TntWars tnt;

	public SeverPingListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onPing(ServerListPingEvent e) {

		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY)) {

			if (tnt.getConfig().getBoolean("GameManager.Messages.UseMOTD")) {

				e.setMotd(tnt.getMessageManager().getLobbyMOTD());

			}

		} else if (tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {

			if (tnt.getConfig().getBoolean("GameManager.Messages.UseMOTD")) {

				e.setMotd(tnt.getMessageManager().getLobbyStartMOTD());

			}

		}else if (tnt.getGameManager().getGameState().equals(GameState.INGAME)) {

			if (tnt.getConfig().getBoolean("GameManager.Messages.UseMOTD")) {

				e.setMotd(tnt.getMessageManager().getInGameMOTD());

			}

		}else if (tnt.getGameManager().getGameState().equals(GameState.RESTART)) {

			if (tnt.getConfig().getBoolean("GameManager.Messages.UseMOTD")) {

				e.setMotd(tnt.getMessageManager().getRestartMOTD());

			}

		}

	}

}
