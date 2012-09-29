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
package gob.movil.info;

import gob.movil.R;
import gob.movil.app.Main;
import gob.movil.app.Procedures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Módulo de búsqueda aplicable a cualquier contexto de la aplicación.
 * 
 * @author Richard Ricciardelli
 * 
 */
public class Search extends Main {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		Intent intent = getIntent();
		if (Intent.ACTION_SEARCH.equalsIgnoreCase(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			if (Preferences.getSuggestions(getApplicationContext())) {
				SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
						this, SuggestionProvider.AUTHORITY,
						SuggestionProvider.MODE);
				suggestions.saveRecentQuery(query, null);
			}
			String[] agencies = getListItems(
					this,
					AGENCIES + WHERE + replace("nombre", query) + OR
							+ replace("director", query) + OR
							+ replace("institucion", query) + OR
							+ replace("twitter", query));
			String[] mayoralties = getListItems(
					this,
					MAYORALTIES + WHERE + replace("nombre", query) + OR
							+ replace("director", query) + OR
							+ replace("alcaldia", query) + OR
							+ replace("twitter", query));

			String[] procedures = getListItems(this, PROCEDURES + WHERE
					+ replace("nombre", query));

			TextView noResults = (TextView) findViewById(R.id.search_results);
			noResults.setText(Html.fromHtml(getString(R.string.search_none,
					query)));
			String[] results = mergeArrays(agencies, mayoralties, procedures);
			inflateList(results);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (!Preferences.getResults(this))
			finish();
	}

	private String replace(String column, String keyword) {
		String replacement = "REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE("
				+ column.toLowerCase()
				+ ",'á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),'ñ','n') LIKE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE('%"
				+ keyword.toLowerCase()
				+ "%','á','a'), 'é','e'),'í','i'),'ó','o'),'ú','u'),'ñ','n')";
		return replacement;
	}

	private String[] mergeArrays(String[] a, String[] b, String[] c) {
		List<String> all = new ArrayList<String>(a.length + b.length + c.length);
		Collections.addAll(all, a);
		Collections.addAll(all, b);
		Collections.addAll(all, c);
		return all.toArray(new String[] {});
	}

	private void inflateList(String[] results) {
		final ListView resultsList = (ListView) findViewById(R.id.list_result);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, results);
		resultsList.setAdapter(adapter);
		resultsList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				String[] agenciesResults = getArrayFromCursor(Search.this,
						"SELECT * FROM "
								+ AGENCIES
								+ WHERE
								+ "nombre = '"
								+ resultsList.getItemAtPosition(position)
										.toString() + "'");
				String[] mayoraltiesResults = getArrayFromCursor(Search.this,
						"SELECT * FROM "
								+ MAYORALTIES
								+ WHERE
								+ "nombre = '"
								+ resultsList.getItemAtPosition(position)
										.toString() + "'");
				String[] proceduresResults = getArrayFromCursor(Search.this,
						"SELECT * FROM "
								+ PROCEDURES
								+ WHERE
								+ "nombre = '"
								+ resultsList.getItemAtPosition(position)
										.toString() + "'");
				if (agenciesResults != null)
					Show.setDialog(Search.this, agenciesResults);

				if (mayoraltiesResults != null)
					Show.setDialog(Search.this, mayoraltiesResults);

				if (proceduresResults != null)
					showActivity(Procedures.class,
							Integer.parseInt(proceduresResults[0]));
			}
		});
		resultsList.setVisibility(View.VISIBLE);
		resultsList.setEmptyView(findViewById(R.id.search_results));
	}
}