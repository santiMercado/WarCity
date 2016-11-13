package Musica;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Interfaz.GUI;

public class Clock implements Runnable {
	
	protected Thread t;
	protected PlaySound clock;
	protected GUI gui;
	
	public Clock(GUI g) {
		t= new Thread(this,"Musica");
		gui = g;
		clock = new PlaySound(getClass().getResource("/Musica/Clock.wav"));
		t.start();
	}
	
	@Override
	public void run() {
		gui.getMusic().stop();
		clock.playTheSound();
		try {
			Thread.sleep(20000);
			gui.getMusic().reactivate();;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		clock.stopTheSound();
	}

}
