package jgt.applet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class JGTCanvas extends Canvas {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	public JGTApplet applet;
	public Color background;
	public BufferedImage screen;
	
	public JGTCanvas(JGTApplet applet) {
		this(applet, Color.blue);
	}
	
	public JGTCanvas(JGTApplet applet, Color background) {
		this.applet = applet;
		this.background = background;
		screen = new BufferedImage(applet.width, applet.height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void render(JGTState state) {
		Graphics g = screen.getGraphics();
		g.setColor(background);
		g.fillRect(0, 0, applet.width, applet.height);
		
		state.render(g);
		
		if (getGraphics() != null) {
			getGraphics().drawImage(screen, 0, 0, this);
		}
	}

}
