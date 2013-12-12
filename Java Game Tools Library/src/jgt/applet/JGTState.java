package jgt.applet;

import java.awt.Graphics;
import java.util.ArrayList;

import jgt.asset.JGTAssets;

public class JGTState {
	
	private JGTApplet applet;
	private ArrayList<JGTObject> objects;
	
	public JGTState() {
		this(new ArrayList<JGTObject>());
	}
	
	public JGTState(ArrayList<JGTObject> objects) {
		JGTAssets.loadAssets();
		addObjects(objects);
	}
	
	public void step() {
		for (JGTObject o : objects) {
			o.step();
		}
	}
	
	public void render(Graphics g) {
		for (JGTObject o : objects) {
			o.render(g);
		}
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
	
	public void addObject(JGTObject newObject) {
		if (objects == null) {
			objects = new ArrayList<JGTObject>();
		}
		objects.add(newObject);
	}
	
	public void addObjects(ArrayList<JGTObject> newObjects) {
		if (objects == null) {
			objects = new ArrayList<JGTObject>();
		}
		objects.addAll(newObjects);
	}
	
	public ArrayList<JGTObject> getObjects() {
		return objects;
	}
	
}
