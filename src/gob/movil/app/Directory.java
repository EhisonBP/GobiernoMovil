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

import static gob.movil.info.Constants.AGENCIES;
import static gob.movil.info.Constants.INSERT;
import static gob.movil.info.Constants.POWERS;
import static gob.movil.info.Constants.SELECT;
import static gob.movil.info.Constants.STATES;
import static gob.movil.info.Constants.VIBRATION_ERROR;
import gob.movil.R;
import gob.movil.info.DatabaseHelper;
import gob.movil.info.Show;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Directory extends Main {
	private int POS = 1;
	private int powerPosition = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.directory);

		helper = new DatabaseHelper(this);
		db = helper.getReadableDatabase();

		String[] powersArray = getResources().getStringArray(R.array.powers);

		for (String power : powersArray)
			db.execSQL(INSERT + POWERS + " (name) VALUES (\"" + power + "\")");

		String[] statesArray = getResources().getStringArray(R.array.states);
		for (String state : statesArray)
			db.execSQL(INSERT + STATES + " (name) VALUES (\"" + state + "\")");

		Spinner spinner = (Spinner) findViewById(R.id.spinner_directory);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, powersArray);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		/** Mostramos los poderes. */
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				// Consultamos las instituciones del poder elegido.
				Cursor agencies = db.rawQuery(SELECT + AGENCIES
						+ " WHERE power = " + (position + POS), null);
				powerPosition = position + POS;
				// Consultamos las entidades estatales.
				Cursor states = db.rawQuery(SELECT + STATES, null);
				if (position == 5) {
					// Poder Estatal.
					addItems(helper, db, states, 0);
				} else if (position == 6) {
					// Poder Municipal.
					addItems(helper, db, states, -1);
				} else {
					// Poder Nacional.
					addItems(helper, db, agencies, 1);
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	public void addItems(final DatabaseHelper help, final SQLiteDatabase sql,
			Cursor list, final int type) {
		String[] items = new String[list.getCount()];
		int i = 0;
		if (list.moveToFirst()) {
			do {
				items[i] = list.getString(POS);
				i++;
			} while (list.moveToNext());
		}

		final ListView lv = (ListView) findViewById(R.id.list_directory);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(listAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Show widgets = new Show();
				if (type > 0) {
					// Mostramos el listado de instituciones del Poder Nacional.
					Cursor agencies = sql.rawQuery(
							SELECT + AGENCIES + " WHERE name = '"
									+ lv.getItemAtPosition(position)
									+ "' AND power = " + powerPosition, null);
					agencies.moveToFirst();
					widgets.setDialog(Directory.this, agencies);
				} else if (type < 0) {
					// Mostramos los municipios.
					showActivity(Mayoralties.class, position + POS);
				} else {
					try {
						// Mostramos las gobernaciones.
						Cursor officers = sql.rawQuery(SELECT + AGENCIES
								+ " WHERE power = 6 AND state = "
								+ (position + POS), null);
						widgets.setDialog(Directory.this, officers);
					} catch (Exception e) {
						setVibration(VIBRATION_ERROR);
						widgets.setToast(getApplicationContext(),
								getString(R.string.error_db));
					}
				}
			}
		});
	}
}