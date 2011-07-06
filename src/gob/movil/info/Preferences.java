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
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Preferences extends PreferenceActivity {
	private static final String OPT_VIBRATION = "vibration";
	private static final boolean OPT_VIBRATION_DEF = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}

	/** Obtenemos el valor actual de la opción de vibración */
	public static boolean getVibration(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getBoolean(OPT_VIBRATION, OPT_VIBRATION_DEF);
	}
}