package net.dynamicjk.main.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.entity.Player;

import net.dynamicjk.main.TntWars;

public class SendPlayerToHub {

	private TntWars tnt;

	public SendPlayerToHub(TntWars tnt) {
		this.tnt = tnt;
	}

	public void sendToServer(Player p) {
		if (tnt.getConfig().getBoolean("GameManager.BungeeCord.UseLobbyServer")) {
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(b);
			String server = tnt.getConfig().getString("GameManager.BungeeCord.LobbyServer");
			try {
				out.writeUTF("Connect");
				out.writeUTF(server);
			} catch (Exception e) {
			}
			p.sendPluginMessage(tnt, "BungeeCord", b.toByteArray());
		}
	}
}
