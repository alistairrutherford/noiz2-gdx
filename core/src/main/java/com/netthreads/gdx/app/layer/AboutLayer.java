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
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.netthreads.gdx.app.core.Noiz2GDX;
import com.netthreads.gdx.app.definition.AppEvents;
import com.netthreads.gdx.app.definition.AppTextureDefinitions;
import com.netthreads.libgdx.director.AppInjector;
import com.netthreads.libgdx.director.Director;
import com.netthreads.libgdx.scene.Layer;
import com.netthreads.libgdx.texture.TextureCache;
import com.netthreads.libgdx.texture.TextureDefinition;

/**
 * Scene layer.
 * 
 */
public class AboutLayer extends Layer
{
	private static final String UI_FILE = "data/uiskin.json";
	private static final String URL_LABEL_FONT = "default-font";

	private Table table;
	private TextureRegion logo;
	private Skin skin;
	private Label urlLabel;
	private Label versionLabel;
	private Label helpTextLabel;

	private static final String instructionsText = "Control your ship and avoid the barrage.\n" +
			"To destroy enemies, position your ship on the front of an enemy. \n" +
			"A laser locks the enemy and destroy it.\n" +
			"A green star is the bonus item. \n"+"" +
			"A score of the item(displayed at the right-up corner) \n" +
			"increases if you get items continuously.";
	
	/**
	 * The one and only director.
	 */
	private Director director;

	/**
	 * Singletons.
	 */
	private TextureCache textureCache;

	/**
	 * About layer.
	 * 
	 * @param stage
	 */
	public AboutLayer(float width, float height)
	{
		setWidth(width);
		setHeight(height);

		director = AppInjector.getInjector().getInstance(Director.class);

		textureCache = AppInjector.getInjector().getInstance(TextureCache.class);

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

		TextureDefinition definition = textureCache.getDefinition(AppTextureDefinitions.TEXTURE_LIBGDX_LOGO);
		logo = textureCache.getTexture(definition);
	}

	/**
	 * Build view elements.
	 * 
	 */
	private void buildElements()
	{
		
		helpTextLabel = new Label(instructionsText, skin, URL_LABEL_FONT, Color.WHITE);
		helpTextLabel.setWrap(true);
		
		Table topTable = new Table();
		topTable.setWidth(getWidth());
		topTable.add(helpTextLabel);
		
		topTable.pack();

		topTable.setFillParent(true);		
		addActor(topTable);
		
		// ---------------------------------------------------------------
		// Background.
		// ---------------------------------------------------------------
		Image image = new Image(logo);

		image.setWidth(getWidth());
		image.setHeight(getHeight());

		// ---------------------------------------------------------------
		// Labels
		// ---------------------------------------------------------------
		urlLabel = new Label("www.netthreads.co.uk", skin, URL_LABEL_FONT, Color.WHITE);

		versionLabel = new Label(Noiz2GDX.VERSION_TEXT, skin, URL_LABEL_FONT, Color.WHITE);
				
		// ---------------------------------------------------------------
		// Table
		// ---------------------------------------------------------------
		table = new Table();

		table.size(getWidth(), getHeight());

		table.row();
		table.add(urlLabel);
		table.row();
		table.add(image);
		table.row();
		table.add(versionLabel);
		
		table.pack();

		table.setFillParent(true);

		addActor(table);
	}

	/**
	 * Catch escape key.
	 * 
	 */
	@Override
	public boolean keyUp(int keycode)
	{
		boolean handled = false;

		if (keycode == Keys.BACK || keycode == Keys.ESCAPE)
		{
			director.sendEvent(AppEvents.EVENT_TRANSITION_TO_MENU_SCENE, this);

			handled = true;
		}

		return handled;
	}

}
