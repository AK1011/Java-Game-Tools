package jgt.applet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import jgt.game.State;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	public Main applet;
	public ArrayList<MouseAction> mouseActions;
	
	public MouseHandler(Main applet) {
		mouseActions = new ArrayList<MouseAction>();
		this.applet = applet;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.click, e.getX(), e.getY()));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.enter, e.getX(), e.getY()));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.exit, e.getX(), e.getY()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.press, e.getX(), e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.release, e.getX(), e.getY()));
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() > 0) {
			mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.wheelDown, e.getX(), e.getY()));
		}
		if (e.getWheelRotation() < 0) {
			mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.wheelUp, e.getX(), e.getY()));
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.drag, e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseActions.add(new MouseAction(e.getButton(), MouseAction.Action.move, e.getX(), e.getY()));
	}
	
	public void step(State state) {
		ArrayList<MouseAction> currentActions = new ArrayList<MouseAction>();
		currentActions.addAll(mouseActions);
		mouseActions.clear();
		state.mouseActions(currentActions);
	}

}
