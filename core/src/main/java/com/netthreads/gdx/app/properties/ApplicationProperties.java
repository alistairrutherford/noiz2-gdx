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
package com.netthreads.gdx.app.properties;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.google.inject.Singleton;


/**
 * Application properties.
 *
 */
@Singleton
public class ApplicationProperties
{
	public static final String NAME = "noiz2-preferences";

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

	public static final String SOUND_VOLUME = "Volume";
	private static final float DEFAULT_VOLUME = 0.1f;
	
	private Preferences preferences;

	/**
	 * Construct properties.
	 * 
	 */
	public ApplicationProperties()
    {
		preferences = Gdx.app.getPreferences(NAME);
    }

	/**
	 * Return Rank
	 * 
	 * @return Rank value
	 */
	public int getRank()
	{
		int value = preferences.getInteger(RANK_KEY, RANK_DEFAULT);

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
		preferences.putInteger(RANK_KEY, value);
		preferences.flush();
	}

	/**
	 * Return line width
	 * 
	 * @return value
	 */
	public int getLineWidth()
	{
		int value = preferences.getInteger(LINE_WIDTH_KEY, LINE_WIDTH_DEFAULT);

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
		preferences.putInteger(LINE_WIDTH_KEY, value);
		preferences.flush();
	}

	/**
	 * Return fighter finger offset
	 * 
	 * @return value
	 */
	public int getFighterOffset()
	{
		int value = preferences.getInteger(FIGHTER_OFFSET_KEY, FIGHTER_OFFSET_DEFAULT);

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
		preferences.putInteger(FIGHTER_OFFSET_KEY, value);
		preferences.flush();
	}

	/**
	 * Return trackball velocity
	 * 
	 * @return value
	 */
	public int getTrackballVelocity()
	{
		int value = preferences.getInteger(TRACKBALL_VELOCITY_KEY, TRACKBALL_VELOCITY_DEFAULT);

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
		preferences.putInteger(TRACKBALL_VELOCITY_KEY, value);
		preferences.flush();
	}

	/**
	 * Return profiler setting
	 * 
	 * @return value
	 */
	public boolean getSound()
	{
		boolean value = preferences.getBoolean(SOUND_TEXT, SOUND_DEFAULT);

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
		preferences.putBoolean(SOUND_TEXT, value);
		preferences.flush();
	}

	/**
	 * Return profiler setting
	 * 
	 * @return value
	 */
	public boolean getShowProfile()
	{
		boolean value = preferences.getBoolean(SHOW_PROFILE_KEY, SHOW_PROFILE_DEFAULT);

		return value;
	}

	/**
	 * Set the profiler setting
	 * 
	 * @param The
	 *            value
	 */
	public void setShowProfile(boolean value)
	{
		preferences.putBoolean(SHOW_PROFILE_KEY, value);
		preferences.flush();
	}

	/**
	 * Return renderer setting
	 * 
	 * @return value
	 */
	public boolean getRenderer()
	{
		boolean value = preferences.getBoolean(RENDER_KEY, RENDER_DEFAULT);

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
		preferences.putBoolean(RENDER_KEY, value);
		preferences.flush();
	}

	/**
	 * Return play mode
	 * 
	 * @return value
	 */
	public String getPlayMode()
	{
		String value = preferences.getString(PLAY_MODE_KEY, PLAY_MODE_DEFAULT);

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
		preferences.putString(PLAY_MODE_KEY, value);
		preferences.flush();
	}

	/**
	 * Return sound volume.
	 *
	 * @return the volume.
	 */
	public float getVolume()
	{
		float value = preferences.getFloat(SOUND_VOLUME);
		
		return value;
	}

	/**
	 * Put volume.
	 * 
	 * @param volume
	 */
	public void setVolume(float volume)
	{
		preferences.putFloat(SOUND_VOLUME, DEFAULT_VOLUME);
		preferences.flush();
	}	
}
