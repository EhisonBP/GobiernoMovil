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
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.SearchRecentSuggestions;
import android.widget.Toast;

public class Preferences extends PreferenceActivity {
	private static final String OPT_VIBRATION = "vibration";
	private static final boolean OPT_VIBRATION_DEF = true;
	private static final String OPT_SEARCH = "search";
	private static final boolean OPT_SEARCH_DEF = false;
	private static final String OPT_SUGGESTIONS = "suggestions";
	private static final boolean OPT_SUGGESTIONS_DEF = true;
	private static final String OPT_RESULTS = "results";
	private static final boolean OPT_RESULTS_DEF = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		getPreferenceManager().findPreference(OPT_SEARCH)
				.setOnPreferenceClickListener(new OnPreferenceClickListener() {
					@Override
					public boolean onPreferenceClick(Preference preference) {
						alertDialog();
						return false;
					}
				});
	}

	/** Obtenemos el valor actual de la opción de vibración. */
	public static boolean getVibration(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_VIBRATION, OPT_VIBRATION_DEF);
	}

	public static boolean getResults(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_RESULTS, OPT_RESULTS_DEF);
	}

	/** Obtenemos el valor actual de la opción de sugerencias. */
	public static boolean getSuggestions(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_SUGGESTIONS, OPT_SUGGESTIONS_DEF);
	}

	private void alertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(getString(R.string.clear_history_dialog))
				.setCancelable(false)
				.setPositiveButton(getString(R.string.yes),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								clearSuggestions();
								Toast.makeText(getApplicationContext(),
										getString(R.string.cleared),
										Toast.LENGTH_SHORT).show();
								getPreferenceManager().findPreference(
										OPT_SEARCH).setEnabled(OPT_SEARCH_DEF);
							}
						})
				.setNegativeButton(getString(R.string.no),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}

	/** Borra el historial de búsquedas realizadas. */
	public void clearSuggestions() {
		SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
				SuggestionProvider.AUTHORITY, SuggestionProvider.MODE);
		suggestions.clearHistory();
	}
}