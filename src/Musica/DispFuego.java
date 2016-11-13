package Musica;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DispFuego implements Runnable {
	
	protected Thread t;
	protected PlaySound fire;
	
	public DispFuego() {
		t= new Thread(this,"Musica");
		fire = new PlaySound(getClass().getResource("/Musica/fuego.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		fire.playTheSound();
	}
	
	public void stop() {
		fire.stopTheSound();
	}

}
