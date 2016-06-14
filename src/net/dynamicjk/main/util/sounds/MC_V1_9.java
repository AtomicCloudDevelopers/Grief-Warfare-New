package net.dynamicjk.main.util.sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.dynamicjk.main.util.Sounds;

public class MC_V1_9 implements Sounds {

	@Override
	public void playNotePling(Player p) {

		playSound(p, "BLOCK_NOTE_PLING", 100f, 5f);

	}

	@Override
	public void playNoteDrum(Player p) {

		playSound(p, "BLOCK_NOTE_BASEDRUM", 100f, 5f);

	}

	@Override
	public void playNoteSticks(Player p) {

		playSound(p, "BLOCK_NOTE_SNARE", 100f, 5f);

	}

	@Override
	public void playNoteBass(Player p) {

		playSound(p, "BLOCK_NOTE_BASS", 100f, 5f);

	}

	@Override
	public void playLevelUP(Player p) {
		playSound(p, "ENTITY_PLAYER_LEVELUP", 100f, 5f);

	}

	@Override
	public void playFuse(Player p) {

		playSound(p, "ENTITY_TNT_PRIMED", 100f, 5f);

	}

	@Override
	public void playChest(Player p) {

		playSound(p, "BLOCK_CHEST_OPEN", 100f, 5f);

	}

	public void playSound(Player p, String sound, float volume, float pitch) {
		p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
	}

}
