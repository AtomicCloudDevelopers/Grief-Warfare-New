package net.dynamicjk.main.util.sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.dynamicjk.main.util.Sounds;

public class MC_V1_8 implements Sounds {

	@Override
	public void playNotePling(Player p) {
		playSound(p, "NOTE_PLING", 100, 5);

	}

	@Override
	public void playNoteDrum(Player p) {
		playSound(p, "NOTE_BASS_DRUM", 50, 5);

	}

	@Override
	public void playNoteSticks(Player p) {
		playSound(p, "NOTE_STICKS", 50, 5);

	}

	@Override
	public void playNoteBass(Player p) {
		playSound(p, "NOTE_BASS", 50, 5);
	}

	@Override
	public void playLevelUP(Player p) {
		playSound(p, "LEVEL_UP", 50, 5);

	}

	@Override
	public void playFuse(Player p) {
		playSound(p, "FUSE", 50, 5);

	}

	@Override
	public void playChest(Player p) {
		playSound(p, "CHEST_OPEN", 50, 5);
	}

	public void playSound(Player p, String sound, float volume, float pitch) {
		p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
	}

}
