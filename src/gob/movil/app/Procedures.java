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
import gob.movil.info.Preferences;
import gob.movil.info.Show;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Módulo de trámites del Estado venezolano.
 * 
 * @author Richard Ricciardelli
 * 
 */
public class Procedures extends Main {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.procedures);
		Intent receive = getIntent();
		final int procedure = receive.getIntExtra("item", 0);
		String[] items = getListItems(this, PROCEDURES);
		final Spinner spinner = (Spinner) findViewById(R.id.spinner_procedures);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(procedure - 1);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				try {
					String[] procedures = getArrayFromCursor(
							getApplicationContext(), "SELECT * FROM "
									+ PROCEDURES + " WHERE nombre = '"
									+ spinner.getItemAtPosition(position) + "'");
					setTextProcedure(procedures);
				} catch (Exception e) {
					if (Preferences.getVibration(getApplicationContext())) {
						setVibration(VIBRATION_ERROR);
					}
					Show.setToast(getApplicationContext(),
							getString(R.string.error_db));
				}
			}

			public void onNothingSelected(AdapterView<?> v) {
			}
		});
	}

	public void setTextProcedure(String[] data) {
		TextView text = (TextView) findViewById(R.id.text_procedures);
		text.setText(getString(R.string.requirements) + ":\n" + data[2]
				+ "\n\n" + getString(R.string.address) + ": " + data[8]
				+ "\n\n" + getString(R.string.phones) + ": " + data[7] + "\n\n"
				+ getString(R.string.hours) + ": " + data[3] + "\n\n"
				+ getString(R.string.cost) + ": " + data[4] + "\n\n"
				+ getString(R.string.info) + ": " + data[5] + "\n\n"
				+ getString(R.string.organism) + ": " + data[6]);
	}
}