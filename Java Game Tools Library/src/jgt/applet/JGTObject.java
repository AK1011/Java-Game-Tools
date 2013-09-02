package jgt.applet;

import java.awt.Graphics;

import jgt.util.MathUtil;

public class JGTObject {
	
	public JGTState state;
	public String name;
	public int id;
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public JGTObject() {
		
	}
	
	public JGTObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void step() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public boolean collides(JGTObject other) {
		return false; //collidesHorizontal(other) && collidesVertical(other);
	}
	
	public boolean isRightOf(JGTObject other) {
		return x > other.x + other.width;
	}
	
	public boolean isLeftOf(JGTObject other) {
		return x + width < other.x;
	}
	
	public double distance(JGTObject other) {
		return MathUtil.distance(x, y, other.x, other.y);
	}
	
}
