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

import gob.movil.R;
import gob.movil.info.Preferences;
import gob.movil.info.Show;
import android.content.Intent;
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

		Intent receive = getIntent();
		final int state = receive.getIntExtra("item", 0);

		String[] items = getListItems(this, MUNICIPALITIES + " WHERE estado = "
				+ state);

		final ListView lv = (ListView) findViewById(R.id.list_mayor);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(listAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {

				try {
					String[] mayoralties = getArrayFromCursor(
							getApplicationContext(),
							"SELECT " + MAYORALTIES + ".* FROM " + MAYORALTIES
									+ ", " + MUNICIPALITIES + " WHERE "
									+ MUNICIPALITIES + ".nombre = '"
									+ lv.getItemAtPosition(position) + "' AND "
									+ MUNICIPALITIES + "._id" + " = "
									+ MAYORALTIES + ".municipio AND "
									+ MAYORALTIES + ".estado = " + state);
					Show.setDialog(Mayoralties.this, mayoralties);
				} catch (Exception e) {
					if (Preferences.getVibration(getApplicationContext())) {
						setVibration(VIBRATION_ERROR);
					}
					Show.setToast(getApplicationContext(),
							getString(R.string.error_db));
				}
			}
		});
	}
}