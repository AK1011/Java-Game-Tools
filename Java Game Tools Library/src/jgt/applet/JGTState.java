package jgt.applet;

import java.awt.Graphics;
import java.util.ArrayList;

public class JGTState {
	
	private JGTApplet applet;
	
	public JGTState() {
		
	}
	
	public JGTState(JGTApplet applet) {
		this.applet = applet;
	}
	
	public void step() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public void keyAction(ArrayList<JGTKeyAction> actions) {
		
	}
	
	public void mouseAction(ArrayList<JGTMouseAction> actions) {
		
	}
	
	public void setApplet(JGTApplet applet) {
		this.applet = applet;
	}
	
	public JGTApplet getApplet() {
		return applet;
	}
	
}
