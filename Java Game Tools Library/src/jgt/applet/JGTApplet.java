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
	
	public JGTCanvas canvas;
	public JGTState currentState;
	
	public JGTInputHandler inputHandler;
	
	
	public JGTApplet() {
		this(800, 600);
	}
	
	public JGTApplet(int width, int height) {
		this(width, height, new JGTState());
	}
	
	public JGTApplet(int width, int height, JGTState state) {
		this(width, height, state, null);
	}
	
	public JGTApplet(int width, int height, JGTState state,
			JGTInputHandler inputHandler) {
		this.width = width;
		this.height = height;
		this.currentState = state;
		this.inputHandler = inputHandler;
		this.canvas = new JGTCanvas(this);
		
		this.ticksPerSecond = 60;   //TODO make this a parameter later
	}
	
	public void init() {
		setSize(width, height);
		setLayout(new BorderLayout());
		tick = 0;
		
		canvas.addMouseListener(inputHandler.getMouseHandler());
		canvas.addMouseMotionListener(inputHandler.getMouseMotionHandler());
		canvas.addMouseWheelListener(inputHandler.getMouseWheelHandler());
		canvas.addKeyListener(inputHandler.getKeyboardHandler());
		
		System.out.println("Hello");
	}
	
	public void loop() {
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
	
	public void step() {
		tick++;
		currentState.step();
		inputHandler.step();
	}
	
	public void render() {
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
	
}
