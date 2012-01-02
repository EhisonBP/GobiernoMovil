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
import static gob.movil.info.Constants.POWERS;
import static gob.movil.info.Constants.STATES;
import gob.movil.R;
import gob.movil.info.Show;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Directory extends Main {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.directory);

		String[] powersArray = getResources().getStringArray(R.array.powers);

		final String[] statesArray = getResources().getStringArray(
				R.array.states);

		insertValues(this, POWERS, powersArray);
		insertValues(this, STATES, statesArray);

		Spinner spinner = (Spinner) findViewById(R.id.spinner_directory);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, powersArray);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					android.view.View v, int position, long id) {
				String[] agencies = getListItems(Directory.this, AGENCIES
						+ " WHERE power = " + (position + 1));
				switch (position) {
				case 5:
					addItems(statesArray, 5);
					break;
				case 6:
					addItems(statesArray, 6);
					break;
				default:
					addItems(agencies, position);
					break;
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void addItems(String[] items, final int power) {

		final ListView list = (ListView) findViewById(R.id.list_directory);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items); // Test simple
																// checked!!
		list.setAdapter(listAdapter);

		list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				itemAction(power, position, list.getItemAtPosition(position)
						.toString());
			}
		});
	}

	private void itemAction(int power, int position, String item) {
		switch (power) {
		case 5:
			String[] officers = getArrayFromCursor(this, "SELECT * FROM "
					+ AGENCIES + " WHERE power = 6 AND state = "
					+ (position + 1));
			Show.setDialog(this, officers);
			break;
		case 6:
			showActivity(Mayoralties.class, position + 1);
			break;
		default:
			String[] agencies = getArrayFromCursor(this, "SELECT * FROM "
					+ AGENCIES + " WHERE name = '" + item + "' AND power = "
					+ (power + 1));
			Show.setDialog(this, agencies);
			break;
		}
	}
}