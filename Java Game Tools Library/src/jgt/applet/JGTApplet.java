package jgt.applet;

import java.applet.Applet;

public class JGTApplet extends Applet {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	public int width = 800;
	public int height = 600;
	
	public JGTApplet() {
		
	}
	
	public JGTApplet(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void init() {
		resize(width, height);
		System.out.println("Hello");
	}
	
}
