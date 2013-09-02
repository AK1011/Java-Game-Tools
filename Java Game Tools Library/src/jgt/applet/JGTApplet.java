package jgt.applet;

import java.applet.Applet;
import java.awt.BorderLayout;

public class JGTApplet extends Applet implements Runnable {

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	public int width;
	public int height;
	public int tick;
	
	public boolean running;
	private double previousTime;
	private int ticksPerSecond;
	
	private JGTCanvas canvas;
	private JGTState currentState;
	
	private JGTKeyboardHandler keyboardHandler;
	private JGTMouseHandler mouseHandler;
	
	
	public JGTApplet() {
		this(800, 600);
	}
	
	public JGTApplet(int width, int height) {
		this(width, height, 60);
	}
	
	public JGTApplet(int width, int height, int ticksPerSecond) {
		this(width, height, ticksPerSecond, new JGTState());
	}
	
	public JGTApplet(int width, int height, int ticksPerSecond, JGTState state) {
		this.width = width;
		this.height = height;
		this.currentState = state;
		this.keyboardHandler = new JGTKeyboardHandler(this);
		this.mouseHandler = new JGTMouseHandler(this);
		this.canvas = new JGTCanvas(this);
		
		this.ticksPerSecond = ticksPerSecond;
	}
	
	public void init() {
		setSize(width, height);
		setLayout(new BorderLayout());
		tick = 0;
		
		if (canvas != null) {
			add(canvas, BorderLayout.CENTER);
		}
		if (mouseHandler != null) {
			canvas.addMouseListener(mouseHandler);
		}
		if (keyboardHandler != null) {
			canvas.addKeyListener(keyboardHandler);
		}
		
		System.out.println("Initialized Applet.");
	}
	
	private void loop() {
		double currentTime = System.nanoTime() / 100000.0;
		if (currentTime - previousTime < 1000.0 / (double)(ticksPerSecond)) {
			try {
				Thread.sleep((long) (1000.0 / (double)(ticksPerSecond) - (currentTime - previousTime)));
			} catch (InterruptedException e) {
				//do nothing with the stack trace
			}
		}
		previousTime = System.nanoTime() / 1000000.0;
		step();
		render();
	}
	
	private void step() {
		tick++;
		if (currentState != null) {
			currentState.step();
		}
		if (mouseHandler != null) {
			mouseHandler.step();
		}
		if (keyboardHandler != null) {
			keyboardHandler.step();
		}
	}
	
	private void render() {
		canvas.render(currentState);
	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
	
	@Override
	public void run() {
		while (running) {
			loop();
		}
	}
	
	public void setState(JGTState state) {
		this.currentState = state;
	}
	
	public JGTState getState() {
		return currentState;
	}
}
