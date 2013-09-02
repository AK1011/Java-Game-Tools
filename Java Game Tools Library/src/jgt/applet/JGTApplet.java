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
	
	private JGTInputHandler inputHandler;
	
	
	public JGTApplet() {
		this(800, 600);
	}
	
	public JGTApplet(int width, int height) {
		this(width, height, 60);
	}
	
	public JGTApplet(int width, int height, int ticksPerSecond) {
		this.width = width;
		this.height = height;
		this.currentState = new JGTState();
		this.inputHandler = new JGTInputHandler();
		this.canvas = new JGTCanvas(this);
		
		this.ticksPerSecond = ticksPerSecond;
	}
	
	public void init() {
		setSize(width, height);
		setLayout(new BorderLayout());
		tick = 0;
		
		add(canvas, BorderLayout.CENTER);
		if (inputHandler.getMouseHandler() != null) {
			canvas.addMouseListener(inputHandler.getMouseHandler());
		}
		if (inputHandler.getMouseMotionHandler() != null) {
			canvas.addMouseMotionListener(inputHandler.getMouseMotionHandler());
		}
		if (inputHandler.getMouseWheelHandler() != null) {
			canvas.addMouseWheelListener(inputHandler.getMouseWheelHandler());
		}
		if (inputHandler.getKeyboardHandler() != null) {
			canvas.addKeyListener(inputHandler.getKeyboardHandler());
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
		currentState.step();
		inputHandler.step();
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
	
	public void setInputHandler(JGTInputHandler inputHandler) {
		this.inputHandler = inputHandler;
	}
	
	public JGTState getState() {
		return currentState;
	}
	
	public JGTInputHandler getInputHandler() {
		return inputHandler;
	}
	
	public void setup(JGTState state, JGTInputHandler inputHandler) {
		setState(state);
		setInputHandler(inputHandler);
	}
}
