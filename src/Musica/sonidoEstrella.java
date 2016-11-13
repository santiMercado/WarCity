package Musica;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sonidoEstrella implements Runnable {
	
	protected Thread t;
	protected PlaySound musica;
	
	public sonidoEstrella() {
		t= new Thread(this,"Musica");
		musica = new PlaySound(getClass().getResource("/Musica/sonidoEstrella.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			musica.playTheSound();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		musica.stopTheSound();
	}

}