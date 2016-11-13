package Musica;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoAcero implements Runnable {
	
	protected Thread t;
	protected PlaySound musica;
	
	public SonidoAcero() {
		t= new Thread(this,"Musica");
		musica = new PlaySound(getClass().getResource("/Musica/SonidoAcero.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		musica.playTheSound();
	}
	
	public void stop() {
		musica.stopTheSound();
	}

}