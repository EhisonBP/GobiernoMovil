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

import static android.provider.BaseColumns._ID;
import static gob.movil.info.Constants.MAYORALTIES;
import static gob.movil.info.Constants.MUNICIPALITIES;
import static gob.movil.info.Constants.SELECT;
import static gob.movil.info.Constants.VIBRATION_ERROR;
import gob.movil.R;
import gob.movil.info.DatabaseHelper;
import gob.movil.info.Preferences;
import gob.movil.info.Show;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Mayoralties extends Main {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mayoralties);

		/** Recibimos la entidad estatal. */
		Intent receive = getIntent();
		final int state = receive.getIntExtra("item", 0);

		helper = new DatabaseHelper(this);
		db = helper.getReadableDatabase();

		/** Consultamos los municipios pertenecientes a esa entidad estatal. */
		Cursor municipalities = db.rawQuery(SELECT + MUNICIPALITIES
				+ " WHERE state = " + state, null);
		String[] items = new String[municipalities.getCount()];
		int i = 0;
		if (municipalities.moveToFirst()) {
			do {
				items[i] = municipalities.getString(1);
				i++;
			} while (municipalities.moveToNext());
		}

		/** Mostramos el listado de municipios. */
		final ListView lv = (ListView) findViewById(R.id.list_mayor);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(listAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Show widgets = new Show();
				try {
					/** Consultamos la alcaldía del municipio seleccionado. */
					Cursor query = db.rawQuery(
							"SELECT " + MAYORALTIES + ".* FROM " + MAYORALTIES
									+ ", " + MUNICIPALITIES + " WHERE "
									+ MUNICIPALITIES + ".name = '"
									+ lv.getItemAtPosition(position) + "' AND "
									+ MUNICIPALITIES + "." + _ID + " = "
									+ MAYORALTIES + ".municipality AND "
									+ MAYORALTIES + ".state = " + state, null);
					widgets.setDialog(Mayoralties.this, query);
				} catch (Exception e) {
					if (Preferences.getVibration(getApplicationContext())) {
						setVibration(VIBRATION_ERROR);
					}
					widgets.setToast(getApplicationContext(),
							getString(R.string.error_db));
				}
			}
		});
	}
}