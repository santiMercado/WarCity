
package Musica;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica implements Runnable {
	
	protected Thread t;
	protected PlaySound musica;
	protected boolean loop; 
	
	public Musica() {
		t= new Thread(this,"Musica");
		musica = new PlaySound(getClass().getResource("/Musica/musica.wav"));
		loop = true;
		t.start();
	}
	
	@Override
	public void run() {
		while(loop) {
			musica.playTheSound();
			try {
				Thread.sleep(97000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		loop = false;
		musica.stopTheSound();
	}
	
	public void reactivate() {
		loop = true;
		this.run();
	}

}



