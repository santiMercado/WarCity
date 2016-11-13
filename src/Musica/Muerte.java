
package Musica;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Muerte implements Runnable {
	
	protected Thread t;
	protected PlaySound muerte;
	
	public Muerte() {
		t= new Thread(this,"Musica");
		muerte = new PlaySound(getClass().getResource("/Musica/muerte.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		muerte.playTheSound();
	}
	
	public void stop() {
		muerte.stopTheSound();
	}

}
