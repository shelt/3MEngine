// Copyright (c) 2014 Sam Shelton

package ca.shelt.base.engine;

import static org.lwjgl.opengl.GL11.*;

public class Render
{
	public static void clearScreen()
	{
		//TODO: Stencil Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
}
