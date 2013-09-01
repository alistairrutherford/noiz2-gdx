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

package com.netthreads.gdx.app.platform;

/**
 * This is a shadow of the preferences manager from the original game.
 * 
 * Preference management is a handy way to persist the game state.
 * 
 */
public class GameState
{
	public static final String NAME = "gamestate";

	public static final String STAGE_SCORE_TXT = "score_";
	public static final String SCENE_SCORE_TXT = "scene_";
	public static final String STAGE_OPENED_TXT = "opened_";
	public static final String STAGE_CLEARED_TXT = "cleared_";

	// Preferences
	private static GameState instance = null;

	/**
	 * Singleton access.
	 * 
	 * @param context
	 * 
	 * @return The preferences object.
	 */
	public static GameState getInstance()
	{
		if (instance == null)
		{
			instance = new GameState();
		}

		return instance;
	}

	/**
	 * Store stage score.
	 * 
	 * @param Score
	 *            index
	 * @param Score
	 *            value
	 */
	public void setStageScore(int index, int value)
	{
		// Store: STAGE_SCORE_TXT+index, value;
	}

	/**
	 * Return stage score.
	 * 
	 * @return value
	 */
	public int getStageScore(int index)
	{
		int value = 0; // Get: STAGE_SCORE_TXT+index, 0);

		return value;
	}

	/**
	 * Store stage score.
	 * 
	 * @param Score
	 *            index
	 * @param Score
	 *            value
	 */
	public void setSceneScore(int index, int value)
	{
		// Store: SCENE_SCORE_TXT+index, value
	}

	/**
	 * Return stage score.
	 * 
	 * @return value
	 */
	public int getSceneScore(int index)
	{
		int value = 0; // Get: SCENE_SCORE_TXT+index, 0

		return value;
	}

	/**
	 * Store stage status.
	 * 
	 * @param Score
	 *            index
	 * @param Score
	 *            value
	 */
	public void setStageOpened(int index, boolean status)
	{
		// Store: STAGE_OPENED_TXT+index, status
	}

	/**
	 * Return stage score.
	 * 
	 * @return value
	 */
	public boolean getStageOpened(int index)
	{
		boolean value = true; // Get: STAGE_OPENED_TXT+index, false;

		return value;
	}

	/**
	 * Store stage status.
	 * 
	 * @param Score
	 *            index
	 * @param Score
	 *            value
	 */
	public void setStageCleared(int index, boolean status)
	{
		// Store: STAGE_CLEARED_TXT+index, status
	}

	/**
	 * Return stage score.
	 * 
	 * @return value
	 */
	public boolean getStageCleared(int index)
	{
		boolean value = true; // Get : STAGE_CLEARED_TXT+index, false;

		return value;
	}
}
