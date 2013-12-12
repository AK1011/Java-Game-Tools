package jgt.asset;

import java.awt.image.BufferedImage;

public class Animation {

	private AnimationHolder animation;
	private int current;
	private int loopsLeft;
	private int time;
	private int timer;
	
	public Animation(AnimationHolder animation) {
		this(animation, 1);
	}
	
	public Animation(AnimationHolder animation, double timer) {
		loop();
		current = 0;
		this.animation = animation;
		setTimer(timer);
	}
	
	public void setTimer(double timer) {
		// TODO using 60 fps currently, will need to make render thread eventually
		this.time = this.timer = (int)(60.0 * timer);
	}
	
	public int place() {
		return current;
	}
	
	public BufferedImage currentImage() {
		return animation.getImage(current);
	}
	
	public BufferedImage play() {
		if (loopsLeft != 0) {
			if (time-- <= 0) {
				time = timer;
				BufferedImage image = currentImage();
				if (++current >= animation.count()) {
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
