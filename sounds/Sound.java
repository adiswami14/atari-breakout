package dev.adiswami.finalproject.sounds;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip brickHit = Applet.newAudioClip(Sound.class.getResource("ross.wav")); 
	public static final AudioClip bounce = Applet.newAudioClip(Sound.class.getResource("bounce.wav")); 
}
