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

package gob.movil.app;

import static gob.movil.info.Constants.VIBRATION_INTENT;
import gob.movil.R;
import gob.movil.info.About;
import gob.movil.info.Help;
import gob.movil.info.Preferences;
import gob.movil.twitter.TwitterActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	/** Creamos el menú de opciones. */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	/** Opción seleccionada. */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			showActivity(About.class);
			return true;
		case R.id.help:
			showActivity(Help.class);
			return true;
		case R.id.preferences:
			showActivity(Preferences.class);
			return true;
		case R.id.twitter:
			showActivity(TwitterActivity.class);
			return true;
		case R.id.quit:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/** Vista seleccionada. */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_dir:
			showActivity(Directory.class);
			break;
		case R.id.main_tra:
			showActivity(Tramites.class);
			break;
		case R.id.main_gob:
			showActivity(Government.class);
			break;
		}
	}

	/** Mostramos la opción seleccionada. */
	public void showActivity(Class<?> c) {
		if (Preferences.getVibration(getApplicationContext())) {
			setVibration(VIBRATION_INTENT);
		}
		Intent i = new Intent(this, c);
		startActivity(i);
	}

	/** Utilizamos la alerta vibrante. */
	public void setVibration(int miliSeconds) {
		Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		v.vibrate(miliSeconds);
	}
}