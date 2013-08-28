package jgt.applet;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class JGTInputHandler {
	
	public JGTMouseHandler mouseHandler;
	public JGTMouseMotionHandler mouseMotionHandler;
	public JGTMouseWheelHandler mouseWheelHandler;
	public JGTKeyboardHandler keyboardHandler;
	
	public JGTInputHandler() {
		mouseHandler = null;
		mouseMotionHandler = null;
		mouseWheelHandler = null;
		keyboardHandler = null;
	}
	
	public JGTInputHandler(JGTMouseHandler mouseHandler, JGTMouseMotionHandler mouseMotionHandler, JGTMouseWheelHandler mouseWheelHandler, JGTKeyboardHandler keyboardHandler) {
		this.mouseHandler = mouseHandler;
		this.mouseMotionHandler = mouseMotionHandler;
		this.mouseWheelHandler = mouseWheelHandler;
		this.keyboardHandler = keyboardHandler;
	}
	
	public void step() {
		if (mouseHandler != null) {
			mouseHandler.step();
		}
		if (mouseMotionHandler != null) {
			mouseHandler.step();
		}
		if (mouseWheelHandler != null) {
			mouseWheelHandler.step();
		}
		if (keyboardHandler != null) {
			keyboardHandler.step();
		}
	}
	
	public MouseListener getMouseHandler() {
		return mouseHandler;
	}
	
	public MouseMotionListener getMouseMotionHandler() {
		return mouseMotionHandler;
	}
	
	public MouseWheelListener getMouseWheelHandler() {
		return mouseWheelHandler;
	}
	
	public KeyListener getKeyboardHandler() {
		return keyboardHandler;
	}
	
}
