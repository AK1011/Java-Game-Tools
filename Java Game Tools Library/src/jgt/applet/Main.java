package jgt.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import jgt.asset.Assets;
import jgt.game.State;

public class Main extends Applet implements Runnable {

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
	
	private RenderEngine canvas;
	private State currentState;
	private ArrayList<State> states;
	
	private KeyboardHandler keyboardHandler;
	private MouseHandler mouseHandler;
	
	
	public Main() {
		this(800, 600);
	}
	
	public Main(int width, int height) {
		this(width, height, 60);
	}
	
	public Main(int width, int height, int ticksPerSecond) {
		this(width, height, ticksPerSecond, new State());
	}
	
	public Main(int width, int height, State state) {
		this(width, height, 60, state);
	}
	
	public Main(int width, int height, int ticksPerSecond, State state) {
		this(width, height, ticksPerSecond, new ArrayList<State>(Arrays.asList(state)));
	}
	
	public Main(int width, int height, int ticksPerSecond, ArrayList<State> states) {
		this.width = width;
		this.height = height;
		Assets.loadAssets();
		this.keyboardHandler = new KeyboardHandler(this);
		this.mouseHandler = new MouseHandler(this);
		this.canvas = new RenderEngine(this);		
		this.ticksPerSecond = ticksPerSecond;
		addStatesAsCurrent(states);
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
		double currentTime = System.nanoTime() / 1000000.0;
		if (currentTime - previousTime < 1000.0 / (double)(ticksPerSecond)) {
			try {
				Thread.sleep((long) (1000.0 / (double)(ticksPerSecond) - (currentTime - previousTime)));
			} catch (InterruptedException e) {
				//do nothing with the stack trace
			}
		}
		previousTime = currentTime;
		step();
		render();
	}
	
	private void step() {
		tick++;
		if (currentState != null) {
			currentState.step();
		}
		if (mouseHandler != null) {
			mouseHandler.step(currentState);
		}
		if (keyboardHandler != null) {
			keyboardHandler.step(currentState);
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
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public State getState() {
		return currentState;
	}
	
	public void addStates(ArrayList<State> newStates) {
		if (this.states == null) {
			this.states = new ArrayList<State>();
		}
		this.states.addAll(newStates);
		for (State newState : newStates) {
			newState.setApplet(this);
		}
	}
	
	public void addState(State newState) {
		if (this.states == null) {
			this.states = new ArrayList<State>();
		}
		this.states.add(newState);
		newState.setApplet(this);
	}
	
	public void addStatesAsCurrent(ArrayList<State> newStates) {
		addStates(newStates);
		this.currentState = newStates.get(0);
	}
	
	public void addStateAsCurrent(State newState) {
		addState(newState);
		this.currentState = newState;
	}
}
