package jgt.asset;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

	private ArrayList<BufferedImage> images;
	private int current;
	private int loopsLeft;
	private int time;
	private int timer;
	
	public Animation() {
		this(new ArrayList<BufferedImage>(), 1);
	}
	
	public Animation(ArrayList<BufferedImage> images) {
		this(images, 1);
	}
	
	public Animation(ArrayList<BufferedImage> images, double timer) {
		setImages(images);
		loop();
		setTimer(timer);
	}
	
	public void setImages(ArrayList<BufferedImage> images) {
		this.images = images;
		current = 0;
	}
	
	public void setTimer(double timer) {
		// TODO using 60 fps currently, will need to make render thread eventually
		this.time = this.timer = (int)(60.0 * timer);
	}
	
	public int count() {
		return images.size();
	}
	
	public int place() {
		return current;
	}
	
	public BufferedImage currentImage() {
		if (images.size() <= current) {
			return null;
		}
		return images.get(current);
	}
	
	public BufferedImage play() {
		if (loopsLeft != 0) {
			if (time-- <= 0) {
				time = timer;
				BufferedImage image = images.get(current);
				if (++current >= count()) {
					current = 0;
					if (loopsLeft > 0) {
						loopsLeft--;
					}
				}
				return image;
			}
		}
		return currentImage();
	}
	
	public void start() {
		loop(1);
	}
	
	public void loop() {
		loop(-1);
	}
	
	public void loop(int times) {
		loopsLeft = times;
	}
	
	
}
