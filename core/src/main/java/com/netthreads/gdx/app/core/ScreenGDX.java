/**
 * Copyright (C) 2013 Alistair Rutherford, Glasgow, Scotland, UK, www.netthreads.co.uk
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.netthreads.gdx.app.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * Implements screen drawing routines.
 * 
 */
public class ScreenGDX implements IScreen
{
    private static final int ONE = 0x10000;

    private int lineWidth = 1;

	private int screenWidth = 0;
	private int screenHeight = 0;

	private SpriteBatch spriteBatch;
	private ShapeRenderer shapeRenderer;

	/**
	 * Construct GDX screen.
	 * 
	 * @param screenWidth
	 * @param screenHeight
	 */
	public ScreenGDX(int screenWidth, int screenHeight)
	{
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		shapeRenderer = new ShapeRenderer();
	}

	public int getScreenWidth()
	{
		return screenWidth;
	}

	public int getScreenHeight()
	{
		return screenHeight;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, int color)
	{
		shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
		
        int red = ((color&0x00FF0000))/255;
        int green = ((color&0x0000FF00)<<8)/255;
        int blue = ((color&0x000000FF)<<16)/255;
        
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(red, green, blue, ONE);
		shapeRenderer.line(x1, screenHeight-y1, x2, screenHeight-y2);
        shapeRenderer.end();
	}

	@Override
	public void drawThickLine(int x1, int y1, int x2, int y2, int color1, int color2)
	{
		shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
		
        int red = ((color1&0x00FF0000))/255;
        int green = ((color1&0x0000FF00)<<8)/255;
        int blue = ((color1&0x000000FF)<<16)/255;
		
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(red, green, blue, ONE);
		shapeRenderer.line(x1, screenHeight-y1, x2, screenHeight-y2);
        shapeRenderer.end();
	}

	@Override
	public void drawDot(int x1, int y1, int color)
	{
		shapeRenderer.setProjectionMatrix(spriteBatch.getProjectionMatrix());
		
        int red = ((color&0x00FF0000))/255;
        int green = ((color&0x0000FF00)<<8)/255;
        int blue = ((color&0x000000FF)<<16)/255;
		
        shapeRenderer.begin(ShapeType.Point);
        shapeRenderer.setColor(red, green, blue, ONE);
		shapeRenderer.circle(x1, screenHeight-y1, 2);
        shapeRenderer.end();
	}

	public int getLineWidth()
	{
		return lineWidth;
	}

	public void setLineWidth(int lineWidth)
	{
		this.lineWidth = lineWidth;
	}

	public SpriteBatch getSpriteBatch()
	{
		return spriteBatch;
	}

	public void setSpriteBatch(SpriteBatch spriteBatch)
	{
		this.spriteBatch = spriteBatch;
	}

	public void setScreenWidth(int screenWidth)
	{
		this.screenWidth = screenWidth;
	}

	public void setScreenHeight(int screenHeight)
	{
		this.screenHeight = screenHeight;
	}

	@Override
	public void drawBitmap(String name, int left, int top)
	{
		// TODO Auto-generated method stub
		
	}

}
