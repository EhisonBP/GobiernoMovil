/*
 * Licencia GPL v3
 * "Gobierno Móvil" es un producto de "Gobierno en Línea".
 * Copyright (C) 2011 Richard Ricciardelli. Centro Nacional de Tecnologías de Información. All Rights Reserved.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses
 */

package gob.movil.twitter;

import gob.movil.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Twitter extends TabActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twitter);
		tabSpec("timeline", getString(R.string.timeline), R.drawable.twitter,
				Timeline.class);
		tabSpec("mentions", getString(R.string.mentions), R.drawable.twitter,
				Mentions.class);
		tabSpec("retweets", getString(R.string.retweets), R.drawable.twitter,
				Retweets.class);
	}

	private void tabSpec(String tag, String tab, int resId, Class<?> c) {
		Resources res = getResources();
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent i = new Intent().setClass(this, c);
		spec = tabHost.newTabSpec(tag)
				.setIndicator(tab, res.getDrawable(resId)).setContent(i);
		tabHost.addTab(spec);
		tabHost.setCurrentTab(0);
	}
}