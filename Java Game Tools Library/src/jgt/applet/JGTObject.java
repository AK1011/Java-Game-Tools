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
	
}
