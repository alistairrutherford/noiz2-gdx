/**
 * Copyright (C) 2009 Alistair Rutherford, Glasgow, Scotland, UK, www.netthreads.co.uk
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


public class ApplicationPreferences
{
	public static final String NAME = "preferences";

	public static final String SOUND_TEXT = "Sound on/off";
	public static final boolean SOUND_DEFAULT = true;

	public static final String RANK_KEY = "Difficulty";
	public static final int RANK_DEFAULT = 0;
	public static final int RANK_MAX = 10;

	public static final String LINE_WIDTH_KEY = "Line Width";
	public static final int LINE_WIDTH_DEFAULT = 0;
	public static final int LINE_WIDTH_MAX = 4;

	public static final String FIGHTER_OFFSET_KEY = "Fighter Offset";
	public static final int FIGHTER_OFFSET_DEFAULT = 10;
	public static final int FIGHTER_OFFSET_MAX = 20;

	public static final String TRACKBALL_VELOCITY_KEY = "Trackball Velocity";
	public static final int TRACKBALL_VELOCITY_DEFAULT = 10;
	public static final int TRACKBALL_VELOCITY_MAX = 30;

	public static final String SHOW_PROFILE_KEY = "Show Profile";
	public static final boolean SHOW_PROFILE_DEFAULT = false;

	public static final String RENDER_KEY = "OpenGL";
	public static final boolean RENDER_DEFAULT = true;

	public static final String PLAY_MODE_KEY = "Mode";
	public static String PLAY_MODE_DEFAULT = "";

	// Preferences
	private static ApplicationPreferences instance = null;

	/**
	 * Singleton access.
	 * 
	 * @param context
	 * 
	 * @return The preferences object.
	 */
	public static ApplicationPreferences getInstance()
	{
		if (instance == null)
		{
			instance = new ApplicationPreferences();
		}

		return instance;
	}

	/**
	 * Initialise preference context
	 * 
	 * @param context
	 */
	public void init()
	{
		// Initialise default play mode.
		ApplicationPreferences.PLAY_MODE_DEFAULT = "Original";
	}

	/**
	 * Return Rank
	 * 
	 * @return Rank value
	 */
	public int getRank()
	{
		int value = RANK_DEFAULT;

		// get: RANK_KEY, RANK_DEFAULT;

		return value;
	}

	/**
	 * Set the rank
	 * 
	 * @param The
	 *            value string
	 */
	public void setRank(int value)
	{
		// Put: RANK_KEY, value;
	}

	/**
	 * Return line width
	 * 
	 * @return value
	 */
	public int getLineWidth()
	{
		int value = LINE_WIDTH_DEFAULT;

		// Get : LINE_WIDTH_KEY, LINE_WIDTH_DEFAULT;

		return value;
	}

	/**
	 * Set the line width
	 * 
	 * @param The
	 *            value
	 */
	public void setLineWidth(int value)
	{
		// Set: LINE_WIDTH_KEY, value);
	}

	/**
	 * Return fighter finger offset
	 * 
	 * @return value
	 */
	public int getFighterOffset()
	{
		int value = FIGHTER_OFFSET_DEFAULT;

		// Get: FIGHTER_OFFSET_KEY, FIGHTER_OFFSET_DEFAULT;

		return value;
	}

	/**
	 * Set the finger fighter offset
	 * 
	 * @param The
	 *            value
	 */
	public void setFighterOffset(int value)
	{
		// Set: FIGHTER_OFFSET_KEY, value);
	}

	/**
	 * Return trackball velocity
	 * 
	 * @return value
	 */
	public int getTrackballVelocity()
	{
		int value = TRACKBALL_VELOCITY_DEFAULT;

		// Get : TRACKBALL_VELOCITY_KEY, TRACKBALL_VELOCITY_DEFAULT);

		return value;
	}

	/**
	 * Set the trackball velocity
	 * 
	 * @param The
	 *            value
	 */
	public void setTrackballVelocity(int value)
	{
		// Set: TRACKBALL_VELOCITY_KEY, value);
	}

	/**
	 * Return profiler setting
	 * 
	 * @return value
	 */
	public boolean getSound()
	{
		boolean value = SOUND_DEFAULT;
		// GET :SOUND_TEXT, SOUND_DEFAULT);

		return value;
	}

	/**
	 * Return profiler setting
	 * 
	 * @return value
	 */
	public boolean getShowProfile()
	{
		boolean value = SHOW_PROFILE_DEFAULT;

		// Get : SHOW_PROFILE_KEY, SHOW_PROFILE_DEFAULT);

		return value;
	}

	/**
	 * Set the profiler setting
	 * 
	 * @param The
	 *            value
	 */
	public void setSound(boolean value)
	{
		// Set : SOUND_TEXT, value);
	}

	/**
	 * Set the profiler setting
	 * 
	 * @param The
	 *            value
	 */
	public void setShowProfile(boolean value)
	{
		// Set SHOW_PROFILE_KEY, value);
	}

	/**
	 * Return renderer setting
	 * 
	 * @return value
	 */
	public boolean getRenderer()
	{
		boolean value = RENDER_DEFAULT;

		// get RENDER_KEY, RENDER_DEFAULT);

		return value;
	}

	/**
	 * Set the renderer setting
	 * 
	 * @param The
	 *            value
	 */
	public void setRenderer(boolean value)
	{
		// Set : RENDER_KEY, value);
	}

	/**
	 * Return play mode
	 * 
	 * @return value
	 */
	public String getPlayMode()
	{
		String value = PLAY_MODE_DEFAULT;

		// Get :PLAY_MODE_KEY, PLAY_MODE_DEFAULT);

		return value;
	}

	/**
	 * Set the play mode
	 * 
	 * @param The
	 *            value
	 */
	public void setPlayMode(String value)
	{
		// Set :PLAY_MODE_KEY, value);
	}

}
