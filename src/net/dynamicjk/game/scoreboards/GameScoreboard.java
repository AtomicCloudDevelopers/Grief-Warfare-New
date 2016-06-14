package net.dynamicjk.game.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import net.dynamicjk.main.TntWars;

public class GameScoreboard {

	private TntWars tnt;

	public GameScoreboard(TntWars tnt){
		this.tnt = tnt;
	}

	public Scoreboard setupScoreboard(Player p) {

		Scoreboard GameBoard = p.getServer().getScoreboardManager().getNewScoreboard();
		final Objective objective = GameBoard.registerNewObjective(p.getName(), "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(tnt.getConfig().getString("GameManager.Scoreboards.Game.ScoreTitle").replaceAll("&", "§"));

		Score score = objective.getScore(
				tnt.getConfig().getString("GameManager.Scoreboards.Game.0").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score1 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.1").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score2 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.2").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score3 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.3").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score4 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.4").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score5 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.5").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score6 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.6").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score7 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.7").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		
		Score score8 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.8").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		Score score9 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.9").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		Score score10 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.10").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));
		Score score11 = objective.getScore(				
				tnt.getConfig().getString("GameManager.Scoreboards.Game.11").replaceAll("&", "§")				
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
		        .replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
		        .replaceAll("%player%", p.getName())
		        .replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName())))
		        .replaceAll("%map%", tnt.getConfig().getString("GameManager." + tnt.getMapSystem().getArenaName() + ".Name"))
		        .replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()))
		        .replaceAll("%prefix%", tnt.getMessageManager().getPrefix()).replaceAll("&", "§"));

		score.setScore(11);
		score1.setScore(10);
		score2.setScore(9);
		score3.setScore(8);
		score4.setScore(7);
		score5.setScore(6);
		score6.setScore(5);
		score7.setScore(4);
		score8.setScore(3);
		score9.setScore(2);
		score10.setScore(1);
		score11.setScore(0);

		return GameBoard;
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
