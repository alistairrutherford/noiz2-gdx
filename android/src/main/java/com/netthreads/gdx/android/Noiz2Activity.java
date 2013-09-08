package com.netthreads.gdx.android;

import com.netthreads.gdx.app.core.Noiz2GDX;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class Noiz2Activity extends AndroidApplication
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useGL20 = true;
		initialize(new Noiz2GDX(), config);
	}
}
