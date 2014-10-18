package jgt.applet;

public class KeyAction {
	
	public enum Action {
		pressed, released, typed
	};
	
	public int key;
	public Action action;
	
	public KeyAction(int key, Action action) {
		this.key = key;
		this.action = action;
	}
	
	public KeyAction(KeyAction action) {
		this.key = action.key;
		this.action = action.action;
	}
	
	public boolean pressed() {
		return action == Action.pressed;
	}
	
	public boolean released() {
		return action == Action.released;
	}
	
	public boolean typed() {
		return action == Action.typed;
	}
	
}
