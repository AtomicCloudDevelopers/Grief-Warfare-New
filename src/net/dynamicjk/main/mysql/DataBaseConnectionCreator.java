package net.dynamicjk.main.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;

public class DataBaseConnectionCreator {

	public static Connection connection = null;
	
	private String ip = TntWars.getInstance.getMySQL().getIp();
	private String database = TntWars.getInstance.getMySQL().getDatabase();
	private String username = TntWars.getInstance.getMySQL().getUsername(); 
	private String password = TntWars.getInstance.getMySQL().getPassword();

	PreparedStatement preparedStmt;

	public DataBaseConnectionCreator() throws ClassNotFoundException, SQLException {
		connection = getConnection("jdbc:mysql://" + ip + "/" + database, username, password);
		System.out.println("[GWR - Database connected successfully]");

		System.out.println("[GWR - Database Creating MySQL Tables]");
		System.out.println("Creating table in given database...");

		preparedStmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS PlayerData (playerName varchar(300),Name varchar(300),Blocks FLOAT, Wins FLOAT, Looses FLOAT, Coins FLOAT, Active FLOAT)");

		preparedStmt.executeUpdate();
	}

	public Connection getCurrentConnection() throws ClassNotFoundException, SQLException {
		if (connection != null) {
			
			if(connection.isValid(100)){
			
			return connection;
			}else{
				connection = getConnection("jdbc:mysql://" + ip + "/" + database, username, password);
				return connection;
			}
		} else {
			
			System.out.println("[GWR - Database connection failure]");
			System.out.println("[GWR - Connecting to database...]");
			connection = getConnection("jdbc:mysql://" + ip + "/" + database, username, password);
			System.out.println("[GWR - Database connected successfully]");
			return connection;
		}
	}

	public void close() throws SQLException {
		connection.close();
		System.out.println("[GWR - Database connection closed forcibly]");
	}

	public static Connection getConnection(String dbURL, String user, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(dbURL, user, password);
	}

	public void createUserStatements(Player p) throws ClassNotFoundException, SQLException {

		if (getActive(p) != 0) {

			System.out.println("[GWR - DATABASE LOADING PLAYER DATA...]");

		} else {
			String query = "INSERT INTO PlayerData ( playerName, Name , Blocks, Wins, Looses, Coins, Active) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, p.getUniqueId().toString());
			st.setString(2, p.getName());
			st.setDouble(3, 0);
			st.setDouble(4, 0);
			st.setDouble(5, 0.0);
			st.setDouble(6, 0.0);
			st.setDouble(7, 1.0);
			System.out.println("[GWR - DATABASE Updating information]");
			st.executeUpdate();
			st.close();
		}
	}

	public void addBlocks(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Blocks='" + (getBlocks(p) + amount) + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Block information]");

	}
	
	public void addActive(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Active='" + amount + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Active information]");

	}
	
	public void addWins(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Wins='" + (getWins(p) + amount) + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Win information]");

	}
	
	public void addLooses(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Looses='" + (getLooses(p) + amount) + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Loose information]");

	}
	
	public void addCoins(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Coins='" + (getCoins(p) + amount) + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Coins information]");

	}
	
	public void removeCoins(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Coins='" + (getBlocks(p) - amount) + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Block information]");

	}

	public void removeBlocks(Player p, float amount) throws ClassNotFoundException, SQLException {
		Statement posted = getCurrentConnection().createStatement();
		posted.executeUpdate("UPDATE PlayerData SET Blocks='" + (getBlocks(p) - amount) + "' WHERE playerName='"
				+ p.getUniqueId().toString() + "'");
		System.out.println("[GWR - DATABASE " + p.getUniqueId().toString() + " Block information]");

	}

	public float getWins(Player p) throws ClassNotFoundException, SQLException {
		PreparedStatement posted = getCurrentConnection()
				.prepareStatement("SELECT * FROM PlayerData WHERE playerName='" + p.getUniqueId().toString() + "'");
		ResultSet rst = posted.executeQuery();
		if (!rst.next()) {
			return 0;
		} else
			return rst.getFloat("Wins");

	}
	
	public float getActive(Player p) throws ClassNotFoundException, SQLException {
		PreparedStatement posted = getCurrentConnection()
				.prepareStatement("SELECT * FROM PlayerData WHERE playerName='" + p.getUniqueId().toString() + "'");
		ResultSet rst = posted.executeQuery();
		if (!rst.next()) {
			return 0;
		} else
			return rst.getFloat("Active");

	}
	
	public float getLooses(Player p) throws ClassNotFoundException, SQLException {
		PreparedStatement posted = getCurrentConnection()
				.prepareStatement("SELECT * FROM PlayerData WHERE playerName='" + p.getUniqueId().toString() + "'");
		ResultSet rst = posted.executeQuery();
		if (!rst.next()) {
			return 0;
		} else
			return rst.getFloat("Looses");

	}
	
	public float getCoins(Player p) throws ClassNotFoundException, SQLException {
		PreparedStatement posted = getCurrentConnection()
				.prepareStatement("SELECT * FROM PlayerData WHERE playerName='" + p.getUniqueId().toString() + "'");
		ResultSet rst = posted.executeQuery();
		if (!rst.next()) {
			return 0;
		} else
			return rst.getFloat("Coins");

	}
	
	public float getBlocks(Player p) throws ClassNotFoundException, SQLException {
		PreparedStatement posted = getCurrentConnection()
				.prepareStatement("SELECT * FROM PlayerData WHERE playerName='" + p.getUniqueId().toString() + "'");
		ResultSet rst = posted.executeQuery();
		if (!rst.next()) {
			return 0;
		} else
			return rst.getFloat("Blocks");

	}
}
