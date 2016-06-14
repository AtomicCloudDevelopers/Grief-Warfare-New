package net.dynamicjk.game.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import net.dynamicjk.main.TntWars;

public class LobbyScoreBoard {

	private TntWars tnt;

	public LobbyScoreBoard(TntWars tnt){
		this.tnt = tnt;
	}

	public Scoreboard setupScoreboard(Player p) {

		Scoreboard LobbyBoard = p.getServer().getScoreboardManager().getNewScoreboard();
		final Objective objective = LobbyBoard.registerNewObjective(p.getName(), "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(tnt.getConfig().getString("GameManager.Scoreboards.Lobby.ScoreTitle").replaceAll("&", "§"));

		Score score = objective.getScore(
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.0").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score1 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.1").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score2 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.2").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score3 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.3").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score4 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.4").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score5 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.5").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score6 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.6").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score7 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.7").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score8 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Lobby.8").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		score.setScore(9);
		score1.setScore(8);
		score2.setScore(7);
		score3.setScore(6);
		score4.setScore(5);
		score5.setScore(4);
		score6.setScore(3);
		score7.setScore(2);
		score8.setScore(1);

		return LobbyBoard;
	}
	
	public void updateBoardForPlayer(Player p){
		p.setScoreboard(setupScoreboard(p));
	}
	
	public void updateBoardForAllPlayers(){
		for(Player p : Bukkit.getOnlinePlayers()){
		p.setScoreboard(setupScoreboard(p));
		}
	}

}
