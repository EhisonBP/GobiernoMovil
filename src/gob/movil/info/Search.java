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

import static gob.movil.info.Constants.AGENCIES;
import static gob.movil.info.Constants.MAYORALTIES;
import static gob.movil.info.Constants.OR;
import static gob.movil.info.Constants.PROCEDURES;
import static gob.movil.info.Constants.SELECT;
import static gob.movil.info.Constants.WHERE;
import gob.movil.R;
import gob.movil.app.Main;
import gob.movil.app.Procedures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Search extends Main {
	private ListView resultsList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		helper = new DatabaseHelper(this);
		db = helper.getReadableDatabase();
		Intent intent = getIntent();
		if (Intent.ACTION_SEARCH.equalsIgnoreCase(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			if (Preferences.getSuggestions(getApplicationContext())) {
				SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
						this, SuggestionProvider.AUTHORITY,
						SuggestionProvider.MODE);
				suggestions.saveRecentQuery(query, null);
			}
			Cursor searchAgencies = db.rawQuery(
					SELECT + AGENCIES + WHERE + replace("name", query) + OR
							+ replace("officer", query) + OR
							+ replace("office", query) + OR
							+ replace("twitter", query), null);
			Cursor searchMayoralties = db.rawQuery(
					SELECT + MAYORALTIES + WHERE + replace("name", query) + OR
							+ replace("mayor", query) + OR
							+ replace("office", query) + OR
							+ replace("twitter", query), null);
			Cursor searchProcedures = db.rawQuery(SELECT + PROCEDURES + WHERE
					+ replace("name", query), null);
			TextView noResults = (TextView) findViewById(R.id.search_results);
			noResults.setText(Html.fromHtml(getString(R.string.search_none,
					query)));
			String[] resultsAgencies = listResults(searchAgencies);
			String[] resultsMayoralties = listResults(searchMayoralties);
			String[] resultsProcedures = listResults(searchProcedures);
			String[] results = mergeArrays(resultsAgencies, resultsMayoralties,
					resultsProcedures);
			searchAgencies.close();
			searchMayoralties.close();
			searchProcedures.close();
			onResultClick(results);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (!Preferences.getResults(this))
			finish();
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
		list.close();
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
		resultsList = (ListView) findViewById(R.id.list_result);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, results);
		resultsList.setAdapter(listAdapter);
		resultsList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Show widgets = new Show();
				String itemClicked = resultsList.getItemAtPosition(position)
						.toString();
				Cursor queryAgencies = queryItemClicked(AGENCIES, itemClicked);
				Cursor queryMayoralties = queryItemClicked(MAYORALTIES,
						itemClicked);
				Cursor queryProcedures = queryItemClicked(PROCEDURES,
						itemClicked);
				if (queryAgencies.moveToFirst()) {
					widgets.setDialog(Search.this, queryAgencies);
					queryAgencies.close();
				}
				if (queryMayoralties.moveToFirst()) {
					widgets.setDialog(Search.this, queryMayoralties);
					queryAgencies.close();
				}
				if (queryProcedures.moveToFirst()) {
					showActivity(Procedures.class, queryProcedures.getInt(0));
					queryAgencies.close();
				}
			}
		});
		resultsList.setVisibility(View.VISIBLE);
		resultsList.setEmptyView(findViewById(R.id.search_results));
	}

	private Cursor queryItemClicked(String table, String item) {
		Cursor query = db.rawQuery(SELECT + table + WHERE + "name = '" + item
				+ "'", null);
		return query;
	}
}