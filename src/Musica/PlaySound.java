package Musica;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySound{

    private Clip clip;
    private URL url;
    public PlaySound(URL urlAux) {
       url = urlAux;
    }

    private void SoundEffect(URL url) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (LineUnavailableException e) {
        e.printStackTrace();
    }
}

    public void playTheSound() {

    
    SoundEffect(url);// Carga el sonido

    if (clip.isRunning())
        clip.stop();   // Para el sonido si se esta reproduciendo
    clip.setFramePosition(0); // Rebobina al principio
    clip.start();     // Reproducir

    }
    
    public void stopTheSound() {
    	clip.stop();
    }

}