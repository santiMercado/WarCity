
package Musica;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Explosion implements Runnable {
	
	protected Thread t;
	protected PlaySound explosion;
	
	public Explosion() {
		t= new Thread(this,"Musica");
		explosion = new PlaySound(getClass().getResource("/Musica/explosion.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		explosion.playTheSound();
	}
	
	public void stop() {
		explosion.stopTheSound();
	}

}
