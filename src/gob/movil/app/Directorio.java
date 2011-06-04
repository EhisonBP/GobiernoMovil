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
import gob.movil.info.DatabaseHelper;
import gob.movil.info.Show;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Directorio extends Activity {
	public final int POS = 1;
	public int powerPosition = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.directorio);

		TextView pathStart = (TextView) findViewById(R.id.start);
		TextView pathEnd = (TextView) findViewById(R.id.end);
		pathStart.setText(getString(R.string.app_name));
		pathEnd.setText(getString(R.string.directorio));

		Resources res = getResources();
		String[] items = res.getStringArray(R.array.powers);

		final DatabaseHelper helper = new DatabaseHelper(this);
		final SQLiteDatabase db = helper.getReadableDatabase();

		for (int i = 0; i < items.length; i++) {
			db.execSQL(helper.INSERT + helper.POWERS + " (name) VALUES ('"
					+ items[i] + "')");
		}

		Spinner spinner = (Spinner) findViewById(R.id.spinner_dir);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				Cursor agencies = db.rawQuery(helper.SELECT + helper.AGENCIES
						+ " WHERE power = " + (position + POS), null);
				powerPosition = position + POS;
				Cursor states = db
						.rawQuery(helper.SELECT + helper.STATES, null);
				if (position == 5) {
					// Poder Estadal
					addItems(helper, db, states, 0);
				} else if (position == 6) {
					// Poder Municipal
					addItems(helper, db, states, -1);
				} else {
					addItems(helper, db, agencies, 1);
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

	}

	public void onMainClick(View button) {
		finish();
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

		final ListView lv = (ListView) findViewById(R.id.list_dir);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(listAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Show widgets = new Show();
				if (type > 0) {
					Cursor agencies = sql.rawQuery(
							help.SELECT + help.AGENCIES + " WHERE name = '"
									+ lv.getItemAtPosition(position)
									+ "' AND power = " + powerPosition, null);
					agencies.moveToFirst();
					widgets.setDialog(Directorio.this, agencies);
				} else if (type < 0) {
					showIntent(position + POS);
				} else {
					try {
						Cursor officers = sql.rawQuery(help.SELECT
								+ help.AGENCIES
								+ " WHERE power = 6 AND state = "
								+ (position + POS), null);
						widgets.setDialog(Directorio.this, officers);
					} catch (Exception e) {
						widgets.setToast(getApplicationContext(),
								getString(R.string.error_db));
					}

				}
			}
		});
	}

	public void showIntent(int item) {
		Intent i = new Intent();
		i.setComponent(new ComponentName(this, Alcaldias.class));
		i.putExtra("item", item);
		startActivity(i);
	}
}