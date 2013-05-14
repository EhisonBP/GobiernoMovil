/*
 * Licencia GPL v3
 * 
 * Copyright (C) 2012 Centro Nacional de Tecnologías de Información.
 * Gobierno Móvil es un producto de Gobierno en Línea Venezuela.
 * 
 * Copyright (C) 2012 Richard Ricciardelli. All Rights Reserved.
 * 
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

import gob.movil.R;
import gob.movil.database.DatabaseHelper;
import gob.movil.info.Constants;
import gob.movil.info.Preferences;
import gob.movil.info.Update;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Módulo principal de la aplicación que muestra la pantalla de bienvenida y las
 * opciones para los módulos.
 * 
 * @author Richard Ricciardelli
 * @author Ehison Pérez
 * 
 */
public class Main extends Activity implements Constants {

	public static DatabaseHelper helper;
	private static SQLiteDatabase db;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		crearBBDD();
		closeDatabase();
	}

	/**
	 * Crea el menú de opciones.
	 * 
	 * @author Richard Ricciardelli
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	/**
	 * Método que ejecuta las acciones según la opción escogida.
	 * 
	 * @author Richard Ricciardelli
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.update:
			Intent update = new Intent(this, Update.class);
			startActivity(update);
			break;
		case R.id.preferences:
			Intent preferences = new Intent(this, Preferences.class);
			startActivity(preferences);
			break;
		case R.id.search:
			onSearchRequested();
			break;
		}
		return false;
	}

	/**
	 * Método para abrir la conexión a la base de datos.
	 * 
	 * @param context
	 *            Contexto del Activity donde se ejecuta
	 * 
	 * @author Richard Ricciardelli
	 */
	public static void openDatabase(Context context) {
		helper = new DatabaseHelper(context);
		db = helper.getWritableDatabase();
	}

	/**
	 * Método para cerrar la conexión a la base de datos.
	 * 
	 * @author Richard Ricciardelli
	 */
	public void closeDatabase() {
		helper.close();
	}

	public String[] getListItems(Context context, String query) {
		openDatabase(context);
		Cursor cursor = db.rawQuery("SELECT nombre FROM " + query, null);
		String[] items = new String[cursor.getCount()];
		short i = 0;
		if (cursor.moveToFirst())
			do {
				items[i] = cursor.getString(0);
				i++;
			} while (cursor.moveToNext());
		cursor.close();
		closeDatabase();
		return items;
	}

	public String[] getArrayFromCursor(Context context, String query) {
		openDatabase(context);
		Cursor cursor = db.rawQuery(query.toString(), null);
		String[] data = new String[cursor.getColumnCount()];
		if (cursor.moveToFirst())
			for (short i = 0; i < cursor.getColumnCount(); i++)
				data[i] = cursor.getString(i);
		else
			return null;
		cursor.close();
		closeDatabase();
		return data;
	}

	/**
	 * Implementando la interfaz para escuchar los clicks del usuario en la
	 * Activity.
	 * 
	 * @param v
	 *            Vista que recibió el click
	 * 
	 * @author Richard Ricciardelli
	 */
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

	/**
	 * Muestra la pantalla seleccionada.
	 * 
	 * @param c
	 *            Clase a activar en Activity
	 * @param item
	 *            Información que pasa a través de las Activity
	 * 
	 * @author Richard Ricciardelli
	 */
	public void showActivity(Class<?> c, int item) {
		if (Preferences.getVibration(getApplicationContext()))
			setVibration(VIBRATION_INTENT);
		startActivity(new Intent(this, c).putExtra("item", item));
		overridePendingTransition(R.anim.fade, R.anim.hold);
	}

	/**
	 * Coloca el valor de vibración.
	 * 
	 * @param ms
	 *            Milisegundos
	 * 
	 * @author Richard Ricciardelli
	 */
	public void setVibration(int ms) {
		((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(ms);
	}

	public void onMainClick(View button) {
		finish();
	}

	/**
	 * Método para crear la base de datos dentro de la Activity principal.
	 * 
	 * @author Ehison Pérez
	 */
	public void crearBBDD() {
		try {
			helper = new DatabaseHelper(this);
			helper.crearDataBase();
		} catch (IOException ioe) {
		}
	}
}