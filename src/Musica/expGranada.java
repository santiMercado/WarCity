package Musica;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class expGranada implements Runnable {
	
	protected Thread t;
	protected PlaySound bum;
	
	public expGranada() {
		t= new Thread(this,"Musica");
		bum = new PlaySound(getClass().getResource("/Musica/expGranada.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		bum.playTheSound();
	}
	
	public void stop() {
		bum.stopTheSound();
	}

}