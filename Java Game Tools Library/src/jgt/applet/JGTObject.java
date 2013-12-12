package jgt.applet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jgt.asset.JGTAssets;
import jgt.util.MathUtil;

public class JGTObject {
	
	public JGTState state;
	public String name;
	public int id;
	public Color color;
	public BufferedImage image;
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public JGTObject() {
		this(0, 0, 40, 40);
	}
	
	public JGTObject(int x, int y, int width, int height) {
		JGTAssets.loadAssets();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = Color.red;
	}
	
	public JGTObject(int x, int y, int width, int height, Color color) {
		this(x, y, width, height);
		this.color = color;
	}
	
	public JGTObject(int x, int y, int width, int height, BufferedImage image) {
		this(x, y, width, height);
		this.image = image;
	}
	
	public JGTObject(int x, int y, int width, int height, BufferedImage image, JGTState state) {
		this(x, y, width, height, image);
		this.state = state;
	}
	
	public JGTObject(int x, int y, int width, int height, Color color, JGTState state) {
		this(x, y, width, height, color);
		this.state = state;
	}
	
	public void step() {
		
	}
	
	public void render(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y, null);
		} else {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}
	
	/// *** COLLISION *** ///
	
	public boolean collides(JGTObject other) {
		return collidesHorizontallyWith(other) && collidesVerticallyWith(other);
	}
	
	// ** Horizontal Collision ** //
	
	public boolean isCompletelyRightOf(JGTObject other) {
		return x > other.x + other.width;
	}
	
	public boolean isCompletelyLeftOf(JGTObject other) {
		return x + width < other.x;
	}
	
	public boolean isRightOf(JGTObject other) {
		return MathUtil.average(x, width) > MathUtil.average(other.x, other.width);
	}
	
	public boolean isLeftOf(JGTObject other) {
		return MathUtil.average(x, width) < MathUtil.average(other.x, other.width);
	}
	
	public boolean isHorizontallyCentredWith(JGTObject other) {
		return MathUtil.average(x, width) == MathUtil.average(other.x, other.width);
	}
	
	public boolean collidesHorizontallyWith(JGTObject other) {
		return !(isCompletelyLeftOf(other) || isCompletelyRightOf(other));
	}
	
	// ** Vertical Collision ** //
	
	public boolean isCompletelyUpOf(JGTObject other) {
		return y > other.y + other.height;
	}
	
	public boolean isCompletelyDownOf(JGTObject other) {
		return y + height < other.y;
	}
	
	public boolean isUpOf(JGTObject other) {
		return MathUtil.average(y, height) > MathUtil.average(other.y, other.height);
	}
	
	public boolean isDownOf(JGTObject other) {
		return MathUtil.average(y, height) < MathUtil.average(other.y, other.height);
	}
	
	public boolean isVerticallyCentredWith(JGTObject other) {
		return MathUtil.average(y, height) == MathUtil.average(other.y, other.height);
	}
	
	public boolean collidesVerticallyWith(JGTObject other) {
		return !(isCompletelyUpOf(other) || isCompletelyDownOf(other));
	}
	
	// *** Position *** //
	
	public double distance(JGTObject other) {
		return MathUtil.distance(x, y, other.x, other.y);
	}
	
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
}
