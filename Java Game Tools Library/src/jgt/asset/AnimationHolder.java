package jgt.asset;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationHolder {

	private ArrayList<BufferedImage> images;
	AnimationHolder(ArrayList<BufferedImage> images) {
		setImages(images);
	}
	
	public void setImages(ArrayList<BufferedImage> images) {
		this.images = images;
	}
	
	public int count() {
		return images.size();
	}
	
	public BufferedImage getImage(int i) {
		if (count() <= i) {
			return null;
		}
		return images.get(i);
	}
	
	
}
