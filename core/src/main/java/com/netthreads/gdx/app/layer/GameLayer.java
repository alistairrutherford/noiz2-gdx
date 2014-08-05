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

import jp.gr.java_conf.abagames.bulletml.BulletmlPlayer;
import jp.gr.java_conf.abagames.noiz2.AttractManager;
import jp.gr.java_conf.abagames.noiz2.BarrageManager;
import jp.gr.java_conf.abagames.noiz2.LetterRender;
import jp.gr.java_conf.abagames.noiz2.PrefManager;
import jp.gr.java_conf.abagames.noiz2.Ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.netthreads.gdx.app.core.Noiz2GDX;
import com.netthreads.gdx.app.definition.AppEvents;
import com.netthreads.gdx.app.definition.AppSoundDefinitions;
import com.netthreads.gdx.app.platform.GameState;
import com.netthreads.gdx.app.platform.ScreenGDX;
import com.netthreads.gdx.app.platform.StateData;
import com.netthreads.gdx.app.platform.StateManager;
import com.netthreads.gdx.app.properties.ApplicationProperties;
import com.netthreads.libgdx.director.AppInjector;
import com.netthreads.libgdx.director.Director;
import com.netthreads.libgdx.event.ActorEvent;
import com.netthreads.libgdx.event.ActorEventObserver;
import com.netthreads.libgdx.scene.Layer;
import com.netthreads.libgdx.sound.SoundCache;

/**
 * Main Game layer.
 * 
 * Good luck figuring out Kentas code. LOL.
 * 
 */
public class GameLayer extends Layer implements ActorEventObserver
{
	private static final String TEXT_NOIZ2 = "NOIZ2";
	
	private static final String UI_FILE = "data/uiskin.json";
	private static final String URL_LABEL_FONT_SMALL = "medium-font";
	
	/**
	 * The one and only director.
	 */
	private Director director;
	
	private SoundCache soundCache;
	
	private ApplicationProperties preferences;
	
	private GameState gameState;
	
	private ScreenGDX screen = null;
	
	private StateData state = null;
	private StateManager stateManager = null;
	private PrefManager prefManager = null;
	
	private BarrageManager barrageManager = null;
	private BulletmlPlayer bulletmlPlayer = null;
	private AttractManager attractManager = null;
	private Ship ship = null;
	
	private Skin skin;
	private Label titleLabel;
	
	/**
	 * Create asteroid layer.
	 * 
	 * @param stage
	 */
	public GameLayer(float width, float height)
	{
		setWidth(width);
		setHeight(height);
		
		// ---------------------------------------------------------------
		// Singletons.
		// ---------------------------------------------------------------
		director = AppInjector.getInjector().getInstance(Director.class);
		soundCache = AppInjector.getInjector().getInstance(SoundCache.class);
		preferences = AppInjector.getInjector().getInstance(ApplicationProperties.class);
		gameState = AppInjector.getInjector().getInstance(GameState.class);
		
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
		int width = Math.round(getWidth());
		int height = Math.round(getHeight());
		
		titleLabel = new Label(TEXT_NOIZ2, skin, URL_LABEL_FONT_SMALL, Color.YELLOW);
		titleLabel.setX(0);
		titleLabel.setY(32);
		
		// ---------------------------------------------------------------
		// Screen
		// ---------------------------------------------------------------
		screen = new ScreenGDX(width, height);
		
		// ---------------------------------------------------------------
		// Digital letter renderer (crazy stuff).
		// ---------------------------------------------------------------
		LetterRender.setScreen(screen);
		
		// ---------------------------------------------------------------
		// ---------------------------------------------------------------
		state = new StateData(width, height);
		stateManager = new StateManager(state, preferences.getFighterOffset());
		
		// ---------------------------------------------------------------
		// Good luck figuring any of Kenta code out.
		// ---------------------------------------------------------------
		prefManager = new PrefManager(gameState);
		
		barrageManager = new BarrageManager(state, preferences);
		bulletmlPlayer = new BulletmlPlayer(screen);
		
		ship = new Ship(barrageManager, bulletmlPlayer, prefManager, state);
		
		attractManager = new AttractManager(screen, barrageManager, ship, prefManager, state, Noiz2GDX.VERSION_TEXT);
		
		// ---------------------------------------------------------------
		// Load assets
		// ---------------------------------------------------------------
		
		attractManager.loadImages();
		
		// ---------------------------------------------------------------
		// Initialise Game elements
		// ---------------------------------------------------------------
		bulletmlPlayer.init(barrageManager, ship, attractManager);
		
		prefManager.init();
		
		prefManager.load();
		
		ship.init();
		
		attractManager.initTitle();
	}
	
	/**
	 * Called when layer is part of visible view but not yet displayed.
	 * 
	 */
	@Override
	public void enter()
	{
		// Add this as an event observer.
		director.registerEventHandler(this);
	}
	
	/**
	 * Called when layer is no longer part of visible view.
	 * 
	 */
	@Override
	public void exit()
	{
		cleanup();
		
		// Remove this as an event observer.
		director.deregisterEventHandler(this);
	}
	
	/**
	 * Reset game screen.
	 * 
	 */
	public void reset()
	{
		// This will reset the last game.
		attractManager.initTitle();
	}
	
	/**
	 * Draw layer.
	 * 
	 * Note, our vector graphics live outside the sprite batch begin..end. You
	 * can't nest sprite batch and shape renderer.
	 * 
	 */
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		if (attractManager.state == AttractManager.TITLE)
		{
			titleLabel.setY(getHeight() - 34);
			titleLabel.draw(batch, parentAlpha);
		}
		
		batch.end();
		
		screen.setSpriteBatch(batch);
		
		stateManager.update();
		
		// Update view elements
		bulletmlPlayer.update();
		
		// Draw view elements
		bulletmlPlayer.draw();
		
		batch.begin();
	}
	
	/**
	 * Pooled layers need cleanup view elements.
	 * 
	 */
	private void cleanup()
	{
		int size = getChildren().size;
		while (size > 0)
		{
			Actor actor = getChildren().get(--size);
			
			removeActor(actor);
		}
		
	}
	
	/**
	 * Handle events.
	 * 
	 */
	@Override
	public boolean handleEvent(ActorEvent event)
	{
		boolean handled = false;
		
		switch (event.getId())
		{
			case AppEvents.EVENT_PLAY_EXPLOSION_A:
				if (preferences.getSound())
				{
					soundCache.get(AppSoundDefinitions.SOUND_EXPLOSION_1).play(preferences.getVolume());
				}
				handled = true;
				break;
			case AppEvents.EVENT_PLAY_EXPLOSION_B:
				if (preferences.getSound())
				{
					soundCache.get(AppSoundDefinitions.SOUND_EXPLOSION_2).play(preferences.getVolume());
				}
				handled = true;
				break;
			case AppEvents.EVENT_PLAY_ZAP:
				if (preferences.getSound())
				{
					soundCache.get(AppSoundDefinitions.SOUND_ZAP).play(preferences.getVolume());
				}
				handled = true;
				break;
			default:
				break;
		}
		
		return handled;
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button)
	{
		float touchX = (x * director.getScaleFactorX());
		float touchY = (y * director.getScaleFactorY());
		
		state.controlX = touchX;
		state.controlY = touchY;
		
		state.touched = true;
		
		return true;
	}
	
	@Override
	public boolean touchDragged(int x, int y, int pointer)
	{
		float touchX = (x * director.getScaleFactorX());
		float touchY = (y * director.getScaleFactorY());
		
		state.controlX = touchX;
		state.controlY = touchY;
		
		state.touched = true;
		
		return true;
	}
	
}
