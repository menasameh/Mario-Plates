package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	
	private Clip clip;
	private AudioInputStream ais;
	private final String PATH = "FILE:/www.wav";
	
	
	public SoundPlayer(){
		try{
//	        URL url = new URL(PATH);
//		File f = new File("/shapes/www.wav");
        URL url = new File("res/www.wav").toURI().toURL();
        clip = AudioSystem.getClip();
        ais = AudioSystem.
            getAudioInputStream(url);
		}catch(Exception e){
		}
	}
	
	public void start() {
		 try {
			clip.stop();
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void stop(){
		clip.close();
	}
	
	public static void main(String[] args) throws Exception {
		new SoundPlayer().start();
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
	}
	
	
}