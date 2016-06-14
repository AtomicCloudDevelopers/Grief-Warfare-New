package net.dynamicjk.game.messages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;

public class MessageManager {

	private TntWars tnt;

	private String prefix;

	public MessageManager(TntWars tnt) {
		this.tnt = tnt;
		this.prefix = tnt.getConfig().getString("GameManager.Messages.prefix").replaceAll("&", "§");
	}

	public String getPrefix() {
		return prefix;
	}

	public void sendJoinMessage(Player p) {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.JoinMessage")) {
			s = s.replace("%player%", p.getName());
			s = s.replaceAll("&", "§");
			p.sendMessage(s);

		}
	}

	public void sendNotEnoughPlayersMessage() {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.NotEnoughPlayers")) {
			s = s.replaceAll("&", "§");
			Bukkit.broadcastMessage(s);

		}
	}

	public void sendGameIsStartingMessage() {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.GameStarting")) {
			s = s.replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()));
			s = s.replaceAll("&", "§");
			Bukkit.broadcastMessage(s);

		}
	}

	public void sendGameHasEnded() {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.GameHasEnded")) {
			s = s.replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()));
			s = s.replaceAll("%winner%", String.valueOf(tnt.getGameStats().getStringWinner()));
			s = s.replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(tnt.getGameStats().getStringWinner())));
			s = s.replaceAll("&", "§");
			Bukkit.broadcastMessage(s);

		}
	}

	public void sendGameHasStarted() {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.GameHasStarted")) {
			s = s.replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer()));
			s = s.replaceAll("&", "§");
			Bukkit.broadcastMessage(s);

		}
	}

	public void sendGameRestarting() {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.GameRestarting")) {
			s = s.replaceAll("%time%", String.valueOf(tnt.getGameManager().getRestartTimer()));
			s = s.replaceAll("&", "§");
			Bukkit.broadcastMessage(s);

		}
	}

	public void sendGameEnding() {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.GameIsEnding")) {
			s = s.replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer()));
			s = s.replaceAll("&", "§");
			Bukkit.broadcastMessage(s);

		}
	}
	
	public String getTntName(){
		return tnt.getConfig().getString("GameManager.Kit.Default.Tnt").replaceAll("&", "§");
	}
	
	public String getShopGUI(){
		return tnt.getConfig().getString("GameManager.Messages.Shop.Name").replaceAll("&", "§");
	}
	
	public String getShopName(){
		return tnt.getConfig().getString("GameManager.Kit.Default.Shop").replaceAll("&", "§");
	}
	
	public String getExtraName(){
		return tnt.getConfig().getString("GameManager.Kit.Default.LobbyItem").replaceAll("&", "§");
	}
	
	public String getLobbyMOTD(){
		return tnt.getConfig().getString("GameManager.Messages.LobbyMOTD").replaceAll("&", "§");
	}
	
	public String getLobbyStartMOTD(){
		return tnt.getConfig().getString("GameManager.Messages.LobbyStartMOTD").replaceAll("%time%", String.valueOf(tnt.getGameManager().getLobbyTimer())).replaceAll("&", "§");
	}
	
	public String getTierTwoName(){
		return tnt.getConfig().getString("GameManager.Messages.Shop.TierTwo").replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer())).replaceAll("&", "§");
	}
	
	public String getTierTwoLore(){
		return tnt.getConfig().getString("GameManager.Messages.Shop.TierTwoLore").replaceAll("%blockreq%", String.valueOf(tnt.getConfig().getInt("GameManager.Server.Shop.TierTwoUnlock"))).replaceAll("&", "§");
	}
	
	public String getNotEnoughBlocks(String lore, String item){
		return tnt.getConfig().getString("GameManager.Messages.Shop." + lore).replaceAll("%blockreq%", String.valueOf(tnt.getConfig().getInt("GameManager.Server.Shop." + item))).replaceAll("&", "§");
	}
	
	public String getItemPurchased(){
		return tnt.getConfig().getString("GameManager.Messages.Shop.Unlock").replaceAll("%blockreq%", String.valueOf(tnt.getConfig().getInt("GameManager.Server.Shop.TierTwoUnlock"))).replaceAll("&", "§");
	}
	
	public String getInGameMOTD(){
		return tnt.getConfig().getString("GameManager.Messages.NotEnoughBlocks").replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer())).replaceAll("&", "§");
	}
	
	public String getRestartMOTD(){
		return tnt.getConfig().getString("GameManager.Messages.RestartMOTD").replaceAll("%time%", String.valueOf(tnt.getGameManager().getRestartTimer())).replaceAll("&", "§");
	}

	public void sendNoPermissionMessage(Player p) {
		for (String s : tnt.getConfig().getStringList("GameManager.Messages.Permission")) {
			s = s.replace("%player%", p.getName());
			s = s.replaceAll("&", "§");
			p.sendMessage(s);

		}
	}

	public String playerJoinMessage(Player p) {

		String message = tnt.getConfig().getString("GameManager.Messages.PlayerJoin").replaceAll("&", "§")
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
				.replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%player%", p.getName())
				.replaceAll("%map%", tnt.getConfig().getString("GameManager.Server.MapName"))
				.replaceAll("%prefix%", prefix).replaceAll("&", "§");

		return message;

	}

	public String playerQuitMessage(Player p) {

		String message = tnt.getConfig().getString("GameManager.Messages.PlayerQuit").replaceAll("&", "§")
				.replaceAll("%maxPlayers%", String.valueOf(tnt.getGameManager().getMaxPlayers()))
				.replaceAll("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%player%", p.getName())
				.replaceAll("%map%", tnt.getConfig().getString("GameManager.Server.MapName"))
				.replaceAll("%prefix%", prefix).replaceAll("&", "§");

		return message;

	}
	
	public String getJoinTitle(Player p){
		String title = tnt.getConfig().getString("GameManager.Messages.Title.JoinTitle.Title").replaceAll("&", "§").replaceAll("%player%", p.getName());
		return title;
	}
	
	public String getPlayerListName(Player p){
		String title = tnt.getConfig().getString("GameManager.Messages.Tab").replaceAll("&", "§").replaceAll("%player%", p.getName()).replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(p.getName()))).replaceAll("&", "§");
		return title;
	}
	
	public String getJoinSubTitle(Player p){
		String title = tnt.getConfig().getString("GameManager.Messages.Title.JoinTitle.subTitle").replaceAll("&", "§").replaceAll("%player%", p.getName());
		return title;
	}
	
	public String getWinTitle(Player p){
		String title = tnt.getConfig().getString("GameManager.Messages.Title.WinTitle.Title").replaceAll("%winner%", String.valueOf(tnt.getGameStats().getStringWinner())).replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(tnt.getGameStats().getStringWinner()))).replaceAll("&", "§");
		return title;
	}
	
	public String getWinSubTitle(Player p){
		String title = tnt.getConfig().getString("GameManager.Messages.Title.WinTitle.subTitle").replaceAll("%winner%", String.valueOf(tnt.getGameStats().getStringWinner())).replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(tnt.getGameStats().getStringWinner()))).replaceAll("&", "§");
		return title;
	}

	public String getWinKickMessage(){
		String title = tnt.getConfig().getString("GameManager.Messages.WinKick").replaceAll("%winner%", String.valueOf(tnt.getGameStats().getStringWinner())).replaceAll("%block%", String.valueOf(tnt.getGamePlayers().getPlayers().get(tnt.getGameStats().getStringWinner()))).replaceAll("&", "§");
		return title;
	}

	public String getTierThreeName(){
		return tnt.getConfig().getString("GameManager.Messages.Shop.TierThree").replaceAll("%time%", String.valueOf(tnt.getGameManager().getGameTimer())).replaceAll("&", "§");
	}
	
	public String getTierThreeLore(){
		return tnt.getConfig().getString("GameManager.Messages.Shop.TierThreeLore").replaceAll("%blockreq%", String.valueOf(tnt.getConfig().getInt("GameManager.Server.Shop.TierThreeUnlock"))).replaceAll("&", "§");
	}

	
}
