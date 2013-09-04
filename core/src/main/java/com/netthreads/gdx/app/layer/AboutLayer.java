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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.netthreads.gdx.app.core.Noiz2GDX;
import com.netthreads.gdx.app.definition.AppEvents;
import com.netthreads.libgdx.director.AppInjector;
import com.netthreads.libgdx.director.Director;
import com.netthreads.libgdx.scene.Layer;

/**
 * About layer.
 * 
 */
public class AboutLayer extends Layer
{
	private static final String UI_FILE = "data/uiskin.json";
	private static final String URL_LABEL_FONT = "default-font";

	private Skin skin;

	private static final String[] helpText = 
	{ 
		"Control your ship",
		"and avoid the barrage.",
		"To destroy enemies, ", 
		"position your ship", 
		"in front of an enemy.",
		"A laser locks onto enemy", 
		"and destroys it.",
		"A green star is a bonus",
		"and shield boost"
	};
	
	
	/**
	 * The one and only director.
	 */
	private Director director;

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
		// ---------------------------------------------------------------
		// Labels
		// ---------------------------------------------------------------
		final Label urlLabel = new Label("www.netthreads.co.uk", skin, URL_LABEL_FONT, Color.YELLOW);
		final Label versionLabel = new Label(Noiz2GDX.VERSION_TEXT, skin, URL_LABEL_FONT, Color.CYAN);
		final Label copyrightLabel = new Label("Copyright", skin, URL_LABEL_FONT, Color.WHITE);
		final Label copyrightALabel = new Label("Kenta Cho 2002", skin, URL_LABEL_FONT, Color.WHITE);
		final Label copyrightBLabel = new Label("Alistair. Rutherford 2013", skin, URL_LABEL_FONT, Color.WHITE);

		final Table topTable = new Table();

		topTable.row();
		topTable.add(urlLabel);


		topTable.row();
		topTable.add(copyrightLabel).expandX();
		topTable.row();
		topTable.add(copyrightALabel).expandX();
		topTable.row();
		topTable.add(copyrightBLabel).expandX();
		topTable.row();
		topTable.add(versionLabel);
		topTable.row();
		topTable.add(new Label("-----------", skin));
		topTable.row();

		for (String text : helpText)
		{
			Label helpLabel = new Label(text, skin, URL_LABEL_FONT, Color.WHITE);
			helpLabel.setWrap(false);
			topTable.row();
			topTable.add(helpLabel);
		}


		topTable.setFillParent(true);
		
		topTable.pack();
		
		addActor(topTable);
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
