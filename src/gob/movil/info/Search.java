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

package gob.movil.info;

import gob.movil.R;
import gob.movil.app.Tramites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Search extends ListActivity {
	private static final String WHERE = " WHERE ";
	private static final String OR = " OR ";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		Intent queryIntent = getIntent();
		String queryAction = queryIntent.getAction();

		if (Intent.ACTION_SEARCH.equalsIgnoreCase(queryAction)) {
			String searchKeywords = queryIntent
					.getStringExtra(SearchManager.QUERY);
			Cursor searchAgencies = db.rawQuery(
					dbHelper.SELECT + dbHelper.AGENCIES + WHERE
							+ replace("name", searchKeywords) + OR
							+ replace("officer", searchKeywords) + OR
							+ replace("office", searchKeywords) + OR
							+ replace("twitter", searchKeywords), null);

			Cursor searchMayoralties = db.rawQuery(
					dbHelper.SELECT + dbHelper.MAYORALTIES + WHERE
							+ replace("name", searchKeywords) + OR
							+ replace("mayor", searchKeywords) + OR
							+ replace("office", searchKeywords) + OR
							+ replace("twitter", searchKeywords), null);

			Cursor searchProcedures = db.rawQuery(
					dbHelper.SELECT + dbHelper.PROCEDURES + WHERE
							+ replace("name", searchKeywords), null);

			if (!searchAgencies.moveToFirst()
					&& !searchMayoralties.moveToFirst()
					&& !searchProcedures.moveToFirst()) {
				Resources res = getResources();
				String text = String.format(
						res.getString(R.string.search_none), searchKeywords);
				CharSequence styledText = Html.fromHtml(text);

				TextView noFound = (TextView) findViewById(R.id.search_result);
				noFound.setText(styledText);
				noFound.setVisibility(0);
			} else {
				String[] resultsAgencies = listResults(searchAgencies);
				String[] resultsMayoralties = listResults(searchMayoralties);
				String[] resultsProcedures = listResults(searchProcedures);

				String[] results = mergeArrays(resultsAgencies,
						resultsMayoralties, resultsProcedures);

				onResultClick(results);
			}
		}
	}

	public String replace(String column, String keyword) {
		String replacement = "REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE("
				+ column.toLowerCase()
				+ ",'á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),'ñ','n') LIKE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE('%"
				+ keyword.toLowerCase()
				+ "%','á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),'ñ','n')";
		return replacement;
	}

	public String[] listResults(Cursor list) {
		int i = 0;
		String[] items = new String[list.getCount()];
		if (list.moveToFirst()) {
			do {
				items[i] = list.getString(1);
				i++;
			} while (list.moveToNext());
		}
		return items;
	}

	private String[] mergeArrays(String[] a, String[] b, String[] c) {
		List<String> all = new ArrayList<String>(a.length + b.length + c.length);
		Collections.addAll(all, a);
		Collections.addAll(all, b);
		Collections.addAll(all, c);
		return all.toArray(new String[] {});
	}

	public void onResultClick(String[] results) {
		final DatabaseHelper dbHelper = new DatabaseHelper(this);
		final ListView resultsList = (ListView) findViewById(R.id.list_result);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, results);
		resultsList.setAdapter(listAdapter);

		resultsList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Show widgets = new Show();
				String itemClicked = resultsList.getItemAtPosition(position)
						.toString();
				Cursor queryAgencies = queryItemClicked(dbHelper.AGENCIES,
						itemClicked);
				Cursor queryMayoralties = queryItemClicked(
						dbHelper.MAYORALTIES, itemClicked);
				Cursor queryProcedures = queryItemClicked(dbHelper.PROCEDURES,
						itemClicked);
				
				// widgets.setDialog(Search.this, queryAgencies);
				// widgets.setDialog(Search.this, queryMayoralties);

				if (itemClicked.equalsIgnoreCase(queryProcedures.getString(1)
						.toString())) {
					showIntent(queryProcedures.getInt(0));
				}
			}
		});
	}

	public void showIntent(int item) {
		Intent i = new Intent();
		i.setComponent(new ComponentName(this, Tramites.class));
		i.putExtra("item", item);
		startActivity(i);
	}

	private Cursor queryItemClicked(String table, String item) {
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor query = db.rawQuery(dbHelper.SELECT + table + WHERE + "name = '"
				+ item + "'", null);
		query.moveToFirst();
		return query;
	}
}