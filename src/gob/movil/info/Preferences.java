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
import gob.movil.service.Notifications;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.SearchRecentSuggestions;
import android.widget.Toast;

/**
 * Clase de preferencias de la aplicación.
 * 
 * @author Richard Ricciardelli
 * @author Ehison Perez
 * 
 */
public class Preferences extends PreferenceActivity implements
		SharedPreferences.OnSharedPreferenceChangeListener {
	private static final String OPT_VIBRATION = "vibration";
	private static final boolean OPT_VIBRATION_DEF = true;
	private static final String OPT_SEARCH = "search";
	private static final boolean OPT_SEARCH_DEF = false;
	private static final String OPT_SUGGESTIONS = "suggestions";
	private static final boolean OPT_SUGGESTIONS_DEF = true;
	private static final String OPT_RESULTS = "results";
	private static final boolean OPT_RESULTS_DEF = true;
	private static final String OPT_ABOUT = "about";
	private static final boolean OPT_ABOUT_DEF = true; // WTF?
	private static final String OPT_HELP = "help";
	private static final boolean OPT_HELP_DEF = true; // WTF?
	private static final String OPT_UPDATE = "automatic_update";
	private static final boolean OPT_UPDATE_DEF = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		PreferenceManager.getDefaultSharedPreferences(this)
				.registerOnSharedPreferenceChangeListener(this);
		getPreferenceManager().findPreference(OPT_SEARCH)
				.setOnPreferenceClickListener(new OnPreferenceClickListener() {
					public boolean onPreferenceClick(Preference preference) {
						alertDialog();
						return false;
					}
				});
		Preference about = getPreferenceManager().findPreference(OPT_ABOUT);
		about.setTitle(getString(R.string.about_title,
				getString(R.string.version)));
		about.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				Intent about = new Intent(preference.getContext(), About.class);
				startActivity(about);
				return !OPT_ABOUT_DEF;
			}
		});
		Preference help = getPreferenceManager().findPreference(OPT_HELP);
		help.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			public boolean onPreferenceClick(Preference preference) {
				startActivity(new Intent(preference.getContext(), Help.class));
				return !OPT_HELP_DEF;
			}
		});
	}

	/**
	 * Actualiza el servicio dependiendo del estado de la preferencia de
	 * actualización.
	 * 
	 * @author Richard Ricciardelli
	 */
	private void updateService() {
		if (Preferences.getUpdate(getApplicationContext()))
			startService();
		else
			stopService();
	}

	/**
	 * Inicia el servicio de notificaciones.
	 * 
	 * @author Ehison Pérez
	 */
	private void startService() {
		startService(new Intent(this, Notifications.class));
	}

	/**
	 * Destruye el servicio de notificaciones.
	 * 
	 * @author Ehison Pérez
	 */
	private void stopService() {
		stopService(new Intent(this, Notifications.class));
	}

	/**
	 * Obtiene si la preferencia de actualización está activada o no.
	 * 
	 * @param context
	 *            where the method is called
	 * @return <code>true</code> or <code>false</code>
	 * 
	 * @author Richard Ricciardelli
	 */
	public static boolean getUpdate(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_UPDATE, OPT_UPDATE_DEF);
	}

	/**
	 * Obtiene si la preferencia de vibración está activada o no.
	 * 
	 * @param context
	 *            where the method is called
	 * @return <code>true</code> or <code>false</code>
	 * 
	 * @author Richard Ricciardelli
	 */
	public static boolean getVibration(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_VIBRATION, OPT_VIBRATION_DEF);
	}

	/**
	 * Obtiene si la preferencia de mostrar resultados previos está activada o
	 * no.
	 * 
	 * @param context
	 *            where the method is called
	 * @return <code>true</code> or <code>false</code>
	 * 
	 * @author Richard Ricciardelli
	 */
	public static boolean getResults(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_RESULTS, OPT_RESULTS_DEF);
	}

	/**
	 * Obtiene si la preferencia de mostrar sugerencias está activada o no.
	 * 
	 * @param context
	 *            where the method is called
	 * @return <code>true</code> or <code>false</code>
	 * 
	 * @author Richard Ricciardelli
	 */
	public static boolean getSuggestions(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_SUGGESTIONS, OPT_SUGGESTIONS_DEF);
	}

	private void alertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(getString(R.string.clear_history_dialog))
				.setTitle(getString(R.string.confirm))
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

	/**
	 * Elimina las sugerencias de búsquedas previas.
	 * 
	 * @author Richard Ricciardelli
	 */
	public void clearSuggestions() {
		SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
				SuggestionProvider.AUTHORITY, SuggestionProvider.MODE);
		suggestions.clearHistory();
	}

	/**
	 * Se ejecuta cuando se realiza cualquier cambio en la preferencia
	 * registrada.
	 * 
	 * @param sharedPreferences
	 *            Preferencia registrada
	 * @param key
	 *            Identificador de la preferencia que ha sufrido un cambio de
	 *            parte del usuario
	 * 
	 * @author Richard Ricciardelli
	 */
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		if (key.equals(OPT_UPDATE))
			updateService();
	}
}