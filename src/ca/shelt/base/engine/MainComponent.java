// Copyright (c) 2014 Sam Shelton

package ca.shelt.base.engine;

public class MainComponent
{
	public static final int WIDTH  = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "3MEngine";
	public static final double FRAME_CAP = 5000.0;
	
	private boolean isRunning;
	private Game game;
	
	// Constructor
	public MainComponent()
	{
		isRunning = false;
		game = new Game();
	}
	
	// Called externally
	public void start()
	{
		if(isRunning)
			return;
		
		run();
	}
	
	// Called externally
	public void stop()
	{
		if(!isRunning)
			return;
		isRunning = false;
	}
	
	private void run()
	{
		isRunning = true;
		
		int frames = 0;
		int frameCounter = 0;
		
		final double FRAME_TIME = 1.0 / FRAME_CAP;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0;

		while(isRunning)
		{
			boolean render = false;
			
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			
			lastTime = startTime;
			unprocessedTime += passedTime / (double)Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > FRAME_TIME)
			{
				render = true;
				
				unprocessedTime -= FRAME_TIME;
				
				if(Window.isCloseRequested())
					stop();
				
				Time.setDelta(FRAME_TIME);
				
				////////////////
				game.input();
				game.update();
				////////////////
				
				if(frameCounter >= Time.SECOND)
				{
					System.out.println(frames);
					frames = 0;
					frameCounter = 0;
				}
			}
			if(render)
			{
				render();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		cleanUp();
	}
	
	private void render()
	{
		game.render();
		Window.render();
	}
	
	private void cleanUp()
	{
		Window.dispose();
	}
	
	public static void main(String[] args)
	{
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		
		MainComponent game = new MainComponent();
		game.start();
	}
}
