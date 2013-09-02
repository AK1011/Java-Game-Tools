package jgt.applet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class JGTKeyboardHandler implements KeyListener {
	
	public ArrayList<JGTKeyAction> keyActions;
	
	public JGTApplet applet;
	
	public JGTKeyboardHandler(JGTApplet applet) {
		keyActions = new ArrayList<JGTKeyAction>();
		this.applet = applet;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyActions.add(new JGTKeyAction(e.getKeyCode(), JGTKeyAction.Action.pressed));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyActions.add(new JGTKeyAction(e.getKeyCode(), JGTKeyAction.Action.released));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyActions.add(new JGTKeyAction(e.getKeyCode(), JGTKeyAction.Action.typed));
	}
	
	public void step() {
		ArrayList<JGTKeyAction> currentActions = new ArrayList<JGTKeyAction>();
		currentActions.addAll(keyActions);
		keyActions.clear();
		applet.getState().keyAction(currentActions);
	}

}
