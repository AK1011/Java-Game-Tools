package jgt.game;

import java.awt.Graphics;
import java.util.ArrayList;

import jgt.applet.KeyAction;
import jgt.applet.Main;
import jgt.applet.MouseAction;
import jgt.asset.Assets;

public class State {
	
	private Main applet;
	private ArrayList<GameObject> objects;
	
	public State() {
		this(new ArrayList<GameObject>());
	}
	
	public State(ArrayList<GameObject> objects) {
		Assets.loadAssets();
		addObjects(objects);
	}
	
	public void step() {
		for (GameObject o : objects) {
			o.step();
		}
	}
	
	public void render(Graphics g) {
		for (GameObject o : objects) {
			o.render(g);
		}
	}
	
	public void keyActions(ArrayList<KeyAction> actions) {
		for (KeyAction action : actions) {
			keyAction(action);
		}
	}
	
	private void keyAction(KeyAction action) {
		
	}
	
	public void mouseActions(ArrayList<MouseAction> actions) {
		for (MouseAction action : actions) {
			mouseAction(action);
		}
	}
	
	private void mouseAction(MouseAction action) {
		
	}
	
	public void setApplet(Main applet) {
		this.applet = applet;
	}
	
	public Main getApplet() {
		return applet;
	}
	
	public void addObject(GameObject newObject) {
		if (objects == null) {
			objects = new ArrayList<GameObject>();
		}
		objects.add(newObject);
	}
	
	public void addObjects(ArrayList<GameObject> newObjects) {
		if (objects == null) {
			objects = new ArrayList<GameObject>();
		}
		objects.addAll(newObjects);
	}
	
	public ArrayList<GameObject> getObjects() {
		return objects;
	}
	
}
