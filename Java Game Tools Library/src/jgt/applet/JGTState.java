package jgt.applet;

import java.awt.Graphics;
import java.util.ArrayList;

public class JGTState {
	
	private JGTApplet applet;
	
	public JGTState() {
		
	}
	
	public void step() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	protected void keyActions(ArrayList<JGTKeyAction> actions) {
		for (JGTKeyAction action : actions) {
			keyAction(action);
		}
	}
	
	public void keyAction(JGTKeyAction action) {
		
	}
	
	protected void mouseActions(ArrayList<JGTMouseAction> actions) {
		for (JGTMouseAction action : actions) {
			mouseAction(action);
		}
	}
	
	public void mouseAction(JGTMouseAction action) {
		
	}
	
	public void setApplet(JGTApplet applet) {
		this.applet = applet;
	}
	
	public JGTApplet getApplet() {
		return applet;
	}
	
}
