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

import static gob.movil.info.Constants.PROCEDURES;
import static gob.movil.info.Constants.SELECT;
import static gob.movil.info.Constants.VIBRATION_ERROR;
import gob.movil.R;
import gob.movil.info.DatabaseHelper;
import gob.movil.info.Preferences;
import gob.movil.info.Show;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Procedures extends Activity {
	private DatabaseHelper helper;
	private SQLiteDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.procedures);

		Intent receive = getIntent();
		final int procedure = receive.getIntExtra("item", 0);

		helper = new DatabaseHelper(this);
		db = helper.getReadableDatabase();

		Cursor procedures = db.rawQuery(SELECT + PROCEDURES, null);

		String[] items = new String[procedures.getCount()];
		int i = 0;
		if (procedures.moveToFirst()) {
			do {
				items[i] = procedures.getString(1);
				i++;
			} while (procedures.moveToNext());
		}

		final Spinner spinner = (Spinner) findViewById(R.id.spinner_procedures);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setSelection(procedure - 1);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				Show widgets = new Show();
				try {
					Cursor procedures = db.rawQuery(
							SELECT + PROCEDURES + " WHERE name = '"
									+ spinner.getItemAtPosition(position) + "'",
							null);
					procedures.moveToFirst();
					setTextProcedure(procedures);
				} catch (Exception e) {
					if (Preferences.getVibration(getApplicationContext())) {
						setVibration(VIBRATION_ERROR);
					}
					widgets.setToast(getApplicationContext(),
							getString(R.string.error_db));
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

	}

	public void setTextProcedure(Cursor query) {
		TextView text = (TextView) findViewById(R.id.text_procedures);
		text.setText("Trámite: " + query.getString(1) + ".\n\n"
				+ getString(R.string.requirements) + ":\n" + query.getString(2)
				+ ".\n\n" + getString(R.string.hours) + ": "
				+ query.getString(3) + ".\n\n" + getString(R.string.cost)
				+ ": " + query.getString(4) + ".\n\n"
				+ getString(R.string.info) + ": " + query.getString(5)
				+ ".\n\n" + getString(R.string.organism) + ": "
				+ query.getString(6) + ".");
	}

	public void onMainClick(View button) {
		finish();
	}

	/** Alerta vibrante. */
	public void setVibration(int miliSeconds) {
		Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		v.vibrate(miliSeconds);
	}
}