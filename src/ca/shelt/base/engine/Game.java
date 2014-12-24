// Copyright (c) 2014 Sam Shelton

package ca.shelt.base.engine;

import org.lwjgl.input.Keyboard;

public class Game
{
	public void Game()
	{
		
	}
	
	public void input()
	{
		if(Input.getKeyDown(Keyboard.KEY_UP))
			System.out.println("down");
		if(Input.getKeyUp(Keyboard.KEY_UP))
			System.out.println("up");
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
}
