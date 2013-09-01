package com.netthreads.gdx.app.platform;

import com.badlogic.gdx.graphics.Color;

/**
 * Color Helper class.
 * 
 *
 */
public class ColorHelper extends Color
{
	public Color set(int rgba)
	{
		rgb888ToColor(this, rgba);
		
		return this;
	}
}
