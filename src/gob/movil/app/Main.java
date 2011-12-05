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

import static gob.movil.info.Constants.TWITTER_PREFERENCES;
import static gob.movil.info.Constants.VIBRATION_INTENT;
import gob.movil.R;
import gob.movil.info.About;
import gob.movil.info.DatabaseHelper;
import gob.movil.info.Help;
import gob.movil.info.Preferences;
import gob.movil.twitter.OAuthTwitter;
import gob.movil.twitter.TwitterActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main extends Activity {
	private static DatabaseHelper helper;
	private static SQLiteDatabase db;

	public static void openDatabase(Context context) {
		helper = new DatabaseHelper(context);
		db = helper.getWritableDatabase();
	}

	public void closeDatabase() {
		helper.close();
		db.close();
	}

	public String[] getListItems(Context context, String query) {
		openDatabase(context);
		Cursor cursor = db.rawQuery(query, null);
		String[] items = new String[cursor.getCount()];
		short i = 0;
		if (cursor.moveToFirst())
			do {
				items[i] = cursor.getString(1);
				i++;
			} while (cursor.moveToNext());
		cursor.close();
		closeDatabase();
		return items;
	}

	public void execQuery(Context context, String query) {
		openDatabase(context);
		db.execSQL(query, null);
		closeDatabase();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	/** Creating the menu. */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	/** Option selected. */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			showActivity(About.class, 0);
			return true;
		case R.id.help:
			showActivity(Help.class, 0);
			return true;
		case R.id.search:
			onSearchRequested();
			return true;
		case R.id.preferences:
			showActivity(Preferences.class, 0);
			return true;
		case R.id.twitter:
			SharedPreferences preferences = getSharedPreferences(
					TWITTER_PREFERENCES, MODE_PRIVATE);
			if (!preferences.getString("access", "").equalsIgnoreCase("")
					|| !preferences.getString("secret", "")
							.equalsIgnoreCase("")) {
				showActivity(TwitterActivity.class, 0);
			} else {
				showActivity(OAuthTwitter.class, 0);
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/** Selected view. */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.directory_main:
			showActivity(Directory.class, 0);
			break;
		case R.id.procedures_main:
			showActivity(Procedures.class, 0);
			break;
		case R.id.government_main:
			showActivity(Government.class, 0);
			break;
		}
	}

	/** Show the activity. */
	public void showActivity(Class<?> c, int item) {
		if (Preferences.getVibration(getApplicationContext())) {
			setVibration(VIBRATION_INTENT);
		}
		Intent i = new Intent(this, c);
		i.putExtra("item", item);
		startActivity(i);
	}

	/** Set vibrate. */
	public void setVibration(int miliSeconds) {
		Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		v.vibrate(miliSeconds);
	}

	public void onMainClick(View button) {
		finish();
	}
}