package jgt.applet;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class JGTInputHandler {
	
	private JGTMouseHandler mouseHandler;
	private JGTMouseMotionHandler mouseMotionHandler;
	private JGTMouseWheelHandler mouseWheelHandler;
	private JGTKeyboardHandler keyboardHandler;
	
	private JGTApplet applet;
	
	public JGTInputHandler() {
		this(null, null, null, null, null);
	}
	
	public JGTInputHandler(JGTApplet applet) {
		this(null, null, null, null, applet);
	}
	
	public JGTInputHandler(
			JGTMouseHandler mouseHandler, JGTMouseMotionHandler mouseMotionHandler,
			JGTMouseWheelHandler mouseWheelHandler, JGTKeyboardHandler keyboardHandler) {
		this(mouseHandler, mouseMotionHandler, mouseWheelHandler, keyboardHandler, null);
	}
	
	public JGTInputHandler(
			JGTMouseHandler mouseHandler, JGTMouseMotionHandler mouseMotionHandler,
			JGTMouseWheelHandler mouseWheelHandler, JGTKeyboardHandler keyboardHandler,
			JGTApplet applet) {
		this.mouseHandler = mouseHandler;
		this.mouseMotionHandler = mouseMotionHandler;
		this.mouseWheelHandler = mouseWheelHandler;
		this.keyboardHandler = keyboardHandler;
		this.applet = applet;
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
	
	public void setApplet(JGTApplet applet) {
		this.applet = applet;
	}
	
	public JGTApplet getApplet() {
		return applet;
	}
	
}
