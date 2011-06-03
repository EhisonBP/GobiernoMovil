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
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Alcaldias extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alcaldias);

		Intent receive = getIntent();
		final int state = receive.getIntExtra("item", 0);

		TextView pathStart = (TextView) findViewById(R.id.start);
		TextView pathEnd = (TextView) findViewById(R.id.end);
		pathStart.setText(getString(R.string.directorio));
		pathEnd.setText(getString(R.string.alcaldias));

		final DatabaseHelper helper = new DatabaseHelper(this);
		final SQLiteDatabase db = helper.getReadableDatabase();

		Cursor municipalities = db.rawQuery(helper.SELECT
				+ helper.MUNICIPALITIES + " WHERE state = " + state, null);

		String[] items = new String[municipalities.getCount()];
		int i = 0;
		if (municipalities.moveToFirst()) {
			do {
				items[i] = municipalities.getString(1);
				i++;
			} while (municipalities.moveToNext());
		}

		final ListView lv = (ListView) findViewById(R.id.list_mayor);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(listAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Show widgets = new Show();
				try {
					Cursor query = db.rawQuery(helper.SELECT
							+ helper.MAYORALTIES + " WHERE municipality = "
							+ (position + 1) + " AND state = " + state, null);
					query.moveToFirst();

					widgets.setDialog(Alcaldias.this, query);

				} catch (Exception e) {
					widgets.setToast(getApplicationContext(),
							getString(R.string.error_db));
				}
			}
		});
	}

	public void onMainClick(View button) {
		finish();
	}
}