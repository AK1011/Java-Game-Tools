package jgt.applet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class JGTMouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	public JGTApplet applet;
	public ArrayList<JGTMouseAction> mouseActions;
	
	public JGTMouseHandler(JGTApplet applet) {
		mouseActions = new ArrayList<JGTMouseAction>();
		this.applet = applet;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.click, e.getX(), e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.enter, e.getX(), e.getY()));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.exit, e.getX(), e.getY()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.press, e.getX(), e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.release, e.getX(), e.getY()));
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() > 0) {
			mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.wheelDown, e.getX(), e.getY()));
		}
		if (e.getWheelRotation() < 0) {
			mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.wheelUp, e.getX(), e.getY()));
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.drag, e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseActions.add(new JGTMouseAction(e.getButton(), JGTMouseAction.Action.move, e.getX(), e.getY()));
	}
	
	public void step() {
		ArrayList<JGTMouseAction> currentActions = new ArrayList<JGTMouseAction>();
		currentActions.addAll(mouseActions);
		mouseActions.clear();
		applet.getState().mouseActions(currentActions);
	}

}
