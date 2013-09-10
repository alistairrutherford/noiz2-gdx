/*
 * -----------------------------------------------------------------------
 * Copyright 2012 - Alistair Rutherford - www.netthreads.co.uk
 * -----------------------------------------------------------------------
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.netthreads.gdx.app.layer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.netthreads.gdx.app.definition.AppEvents;
import com.netthreads.libgdx.director.AppInjector;
import com.netthreads.libgdx.director.Director;
import com.netthreads.libgdx.scene.Layer;

/**
 * Scene layer.
 * 
 */
public class MenuLayer extends Layer
{
	private static final String UI_FILE = "data/uiskin.json";
	private static final String URL_LABEL_FONT = "large-font";
	
	private Skin skin;
	
	/**
	 * The one and only director.
	 */
	private Director director;
	
	/**
	 * Construct the screen.
	 * 
	 * @param stage
	 */
	public MenuLayer(float width, float height)
	{
		setWidth(width);
		setHeight(height);
		
		director = AppInjector.getInjector().getInstance(Director.class);
		
		Gdx.input.setCatchBackKey(true);
		
		loadTextures();
		
		buildElements();
	}
	
	/**
	 * Load view textures.
	 * 
	 */
	private void loadTextures()
	{
		skin = new Skin(Gdx.files.internal(UI_FILE));
	}
	
	/**
	 * Build view elements.
	 * 
	 */
	private void buildElements()
	{
		
		Table tableContainer = new Table();
		
		// ---------------------------------------------------------------
		// ---------------------------------------------------------------
		// Table
		// ---------------------------------------------------------------
		// ---------------------------------------------------------------
		Table tableTop = new Table();

		// Title
		final Label titleLabelA = new Label("Noiz2", skin, URL_LABEL_FONT, Color.YELLOW);
		final TextButton startButton = new TextButton("Start", skin.get("large", TextButtonStyle.class));
		
		tableTop.add(titleLabelA);
		tableTop.row();
		tableTop.add(startButton);

		tableTop.pack();
		tableTop.setFillParent(false);

		// ---------------------------------------------------------------
		// ---------------------------------------------------------------
		// Table
		// ---------------------------------------------------------------
		// ---------------------------------------------------------------
		Table tableBottom = new Table();

		final TextButton settingsButton = new TextButton("Settings", skin);
		final TextButton aboutButton = new TextButton("About", skin);
		
		tableBottom.setSize(getWidth(), getHeight());
		
		tableBottom.row();
		tableBottom.add(settingsButton);
		tableBottom.row();
		tableBottom.add(aboutButton);
		
		tableBottom.pack();
		tableBottom.setFillParent(false);
		
		// ---------------------------------------------------------------
		// ---------------------------------------------------------------

		tableContainer.add(tableTop);
		tableContainer.row();
		tableContainer.add(tableBottom);

		tableContainer.setFillParent(true);

		addActor(tableContainer);
		
		// ---------------------------------------------------------------
		// Listeners
		// ---------------------------------------------------------------
		
		// Listener.
		startButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				director.sendEvent(AppEvents.EVENT_TRANSITION_TO_GAME_SCENE, event.getRelatedActor());
			}
			
		});
		
		// Listener.
		settingsButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				director.sendEvent(AppEvents.EVENT_TRANSITION_TO_SETTINGS_SCENE, event.getRelatedActor());
			}
			
		});
		
		// Listener.
		aboutButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				director.sendEvent(AppEvents.EVENT_TRANSITION_TO_ABOUT_SCENE, event.getRelatedActor());
			}
			
		});
		
	}
	
}
