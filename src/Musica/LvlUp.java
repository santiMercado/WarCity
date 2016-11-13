package Musica;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class LvlUp implements Runnable {
	
	protected Thread t;
	protected PlaySound LvlUp;
	
	public LvlUp() {
		t= new Thread(this,"Musica");
		LvlUp = new PlaySound(getClass().getResource("/Musica/LvlUp.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		LvlUp.playTheSound();
	}
	
	public void stop() {
		LvlUp.stopTheSound();
	}

}