package jgt.applet;

public class JGTKeyAction {
	
	public enum Action {
		pressed, released, typed
	};
	
	public int key;
	public Action action;
	
	public JGTKeyAction(int key, Action action) {
		this.key = key;
		this.action = action;
	}
	
	public JGTKeyAction(JGTKeyAction action) {
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
