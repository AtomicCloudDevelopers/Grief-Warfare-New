package net.dynamicjk.game.coins;

import java.sql.SQLException;

import net.dynamicjk.main.TntWars;

public class Coins {

	private TntWars tnt;

	public Coins(TntWars tnt) {
		this.tnt = tnt;
	}

	public void giveWinnerCoins() throws ClassNotFoundException, SQLException {
		if (tnt.getGameStats().getWinner() != null) {

			if (tnt.getMySQL().isEnabled()) {

				if (tnt.getConfig().getBoolean("GameManager.Server.onWinForMYSQL.UseCoins")) {
					tnt.getConnection().addCoins(tnt.getGameStats().getWinner(),
							tnt.getConfig().getInt("GameManager.Server.onWinForMYSQL.CoinsOnWin"));
				}
			}

		}
	}

}
