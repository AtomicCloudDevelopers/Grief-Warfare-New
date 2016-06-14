package net.dynamicjk.main.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.dynamicjk.game.gamemanager.GameState;
import net.dynamicjk.main.TntWars;
import net.dynamicjk.main.util.TabChanger;

public class PlayerBlockBreakListener implements Listener {

	private TntWars tnt;

	public PlayerBlockBreakListener(TntWars tnt) {
		this.tnt = tnt;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if (tnt.getGameManager().getGameState().equals(GameState.LOBBY) || tnt.getGameManager().getGameState().equals(GameState.LOBBY_START)) {
			if (!tnt.getPlayerBuildMode().getBuilders().contains(e.getPlayer().getName())) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}
		if (tnt.getGameManager().getGameState().equals(GameState.RESTART)) {
			if (!tnt.getPlayerBuildMode().getBuilders().contains(e.getPlayer().getName())) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}
		if(tnt.getGameManager().getGameState().equals(GameState.INGAME)){
			e.setCancelled(false);
			tnt.getGamePlayers().getPlayers().put(e.getPlayer().getName(), tnt.getGamePlayers().getPlayers().get(e.getPlayer().getName()) + 1);
			if(tnt.getConfig().getBoolean("GameManager.Server.Tab.Enabled")){
				TabChanger tab = new TabChanger(tnt);
				tab.ChangeTab(e.getPlayer());
			}
		}
	}
}
