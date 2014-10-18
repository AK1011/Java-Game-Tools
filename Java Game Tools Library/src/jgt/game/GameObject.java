package jgt.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jgt.asset.Assets;
import jgt.util.MathUtil;

public class GameObject {
	
	public State state;
	public String name;
	public int id;
	public Color color;
	public BufferedImage image;
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public GameObject() {
		this(0, 0, 40, 40);
	}
	
	public GameObject(int x, int y, int width, int height) {
		Assets.loadAssets();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = Color.red;
	}
	
	public GameObject(int x, int y, int width, int height, Color color) {
		this(x, y, width, height);
		this.color = color;
	}
	
	public GameObject(int x, int y, int width, int height, BufferedImage image) {
		this(x, y, width, height);
		this.image = image;
	}
	
	public GameObject(int x, int y, int width, int height, BufferedImage image, State state) {
		this(x, y, width, height, image);
		this.state = state;
	}
	
	public GameObject(int x, int y, int width, int height, Color color, State state) {
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
	
	public boolean collides(GameObject other) {
		return collidesHorizontallyWith(other) && collidesVerticallyWith(other);
	}
	
	// ** Horizontal Collision ** //
	
	public boolean isCompletelyRightOf(GameObject other) {
		return x > other.x + other.width;
	}
	
	public boolean isCompletelyLeftOf(GameObject other) {
		return x + width < other.x;
	}
	
	public boolean isRightOf(GameObject other) {
		return MathUtil.average(x, width) > MathUtil.average(other.x, other.width);
	}
	
	public boolean isLeftOf(GameObject other) {
		return MathUtil.average(x, width) < MathUtil.average(other.x, other.width);
	}
	
	public boolean isHorizontallyCentredWith(GameObject other) {
		return MathUtil.average(x, width) == MathUtil.average(other.x, other.width);
	}
	
	public boolean collidesHorizontallyWith(GameObject other) {
		return !(isCompletelyLeftOf(other) || isCompletelyRightOf(other));
	}
	
	// ** Vertical Collision ** //
	
	public boolean isCompletelyUpOf(GameObject other) {
		return y > other.y + other.height;
	}
	
	public boolean isCompletelyDownOf(GameObject other) {
		return y + height < other.y;
	}
	
	public boolean isUpOf(GameObject other) {
		return MathUtil.average(y, height) > MathUtil.average(other.y, other.height);
	}
	
	public boolean isDownOf(GameObject other) {
		return MathUtil.average(y, height) < MathUtil.average(other.y, other.height);
	}
	
	public boolean isVerticallyCentredWith(GameObject other) {
		return MathUtil.average(y, height) == MathUtil.average(other.y, other.height);
	}
	
	public boolean collidesVerticallyWith(GameObject other) {
		return !(isCompletelyUpOf(other) || isCompletelyDownOf(other));
	}
	
	// *** Position *** //
	
	public double distance(GameObject other) {
		return MathUtil.distance(x, y, other.x, other.y);
	}
	
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
}
