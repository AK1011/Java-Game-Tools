package jgt.applet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import jgt.game.State;

public class KeyboardHandler implements KeyListener {
	
	public ArrayList<KeyAction> keyActions;
	
	public Main applet;
	
	public KeyboardHandler(Main applet) {
		keyActions = new ArrayList<KeyAction>();
		this.applet = applet;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyActions.add(new KeyAction(e.getKeyCode(), KeyAction.Action.pressed));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyActions.add(new KeyAction(e.getKeyCode(), KeyAction.Action.released));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyActions.add(new KeyAction(e.getKeyCode(), KeyAction.Action.typed));
	}
	
	public void step(State state) {
		ArrayList<KeyAction> currentActions = new ArrayList<KeyAction>();
		currentActions.addAll(keyActions);
		keyActions.clear();
		state.keyActions(currentActions);
	}

}
