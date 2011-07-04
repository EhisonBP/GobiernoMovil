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