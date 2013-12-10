package jgt.asset;

import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import jgt.applet.JGTApplet;
import jgt.applet.JGTPreferences;

public class JGTAssets {
	
	private Map<String, BufferedImage> images;
	private Map<String, AudioClip> audio;
	
	JGTApplet applet;
	
	public JGTAssets(JGTApplet applet) {		
		images = new HashMap<String, BufferedImage>();
		audio = new HashMap<String, AudioClip>();
		
		this.applet = applet;
		
		loadAssets();
	}
	
	public void loadAssets() {
		loadImages();
		loadAudio();
	}
	
	public BufferedImage getImage(String name) {
		return images.get(name);
	}
	
	public AudioClip getAudio(String name) {
		return audio.get(name);
	}
	
	public void loadImages() {
		File f = new File(JGTPreferences.IMAGE_PATH);
		String[] files = f.list();
		
		if (files != null) {
			BufferedImage readImage;
			for (String s : files) {
				readImage = null;
				try {
					readImage = ImageIO.read(new File(JGTPreferences.IMAGE_PATH + "/" + s));
				} catch (IOException e) {
						e.printStackTrace();
				}
				if (readImage != null) {
					images.put(s, readImage);
				}
			}
		}
	}
	
	public void loadAudio() {
		File f = new File(JGTPreferences.AUDIO_PATH);
		String[] files = f.list();
		
		if (files != null) {
			AudioClip readAudio;
			for (String s : files) {
				readAudio = applet.getAudioClip(applet.getCodeBase(), JGTPreferences.AUDIO_PATH + "/" + s);
				if (readAudio != null) {
					audio.put(s, readAudio);
				}
			}
		}
	}
	
}
