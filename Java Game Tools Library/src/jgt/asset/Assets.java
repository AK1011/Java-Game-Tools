package jgt.asset;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import jgt.applet.Preferences;

public class Assets {
	
	private static Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	private static Map<String, Clip> audio = new HashMap<String, Clip>();
	private static Map<String, AnimationHolder> animations = new HashMap<String, AnimationHolder>();
	
	private static boolean loaded = false;
	
	public static void loadAssets() {
		if (!loaded) {
			loadImages();
			loadAnimations();
			loadAudio();
			loaded = true;
		}
	}
	
	public static BufferedImage getImage(String name) {
		return images.get(name);
	}
	
	public static Clip getAudio(String name) {
		return audio.get(name);
	}
	
	public static Animation getAnimation(String name) {
		return new Animation(animations.get(name));
	}
	
	public static Animation getAnimation(String name, double timer) {
		return new Animation(animations.get(name), timer);
	}
	
	private static void loadAnimations() {
		File f = new File(Preferences.ANIMATION_PATH);
		String[] folders = f.list();
		String[] files;
		
		if (folders != null) {
			for (String s : folders) {
				f = new File(Preferences.ANIMATION_PATH + "/" + s);
				files = f.list();
				if (files != null) {
					ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
					for (String ss : files) {
						try {
							BufferedImage readImage = ImageIO.read(new File(Preferences.ANIMATION_PATH + "/" + s + "/" + ss));
							if (readImage != null) {
								images.add(readImage);
							}
						} catch (IOException e) {
								e.printStackTrace();
						}
					}
					animations.put(s, new AnimationHolder(images));
				}
			}
		}
	}
	
	private static void loadImages() {
		File f = new File(Preferences.IMAGE_PATH);
		String[] files = f.list();
		
		if (files != null) {
			for (String s : files) {
				try {
					BufferedImage readImage = ImageIO.read(new File(Preferences.IMAGE_PATH + "/" + s));
					if (readImage != null) {
						images.put(s, readImage);
					}
				} catch (IOException e) {
						e.printStackTrace();
				}
			}
		}
	}
	
	private static void loadAudio() {
		File f = new File(Preferences.AUDIO_PATH);
		String[] files = f.list();
		
		if (files != null) {
			for (String s : files) {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(Preferences.AUDIO_PATH + "/" + s));
					clip.open(inputStream);
				} catch (Exception e) {
					System.err.println("Couldn't load audio: " + s);
				}				
			}
			
			// Deprecated for the Applet audio API
			/*
			AudioClip readAudio;
			for (String s : files) {
				readAudio = applet.getAudioClip(applet.getCodeBase(), Preferences.AUDIO_PATH + "/" + s);
				if (readAudio != null) {
					audio.put(s, readAudio);
				}
			}
			*/
		}
	}
	
}
