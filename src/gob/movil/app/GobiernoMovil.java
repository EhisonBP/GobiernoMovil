package gob.movil.app;

import gob.movil.R;
import gob.movil.info.About;
import gob.movil.info.Help;
import gob.movil.info.Preferences;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class GobiernoMovil extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	/** Creamos el menú de opciones. */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	/** Opción seleccionada. */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			showActivity(About.class);
			return true;
		case R.id.help:
			showActivity(Help.class);
			return true;
		case R.id.preferences:
			showActivity(Preferences.class);
			return true;
		case R.id.twitter:
			finish();
			return true;
		case R.id.quit:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/** Vista seleccionada. */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_dir:
			showActivity(Directorio.class);
			break;
		case R.id.main_tra:
			showActivity(Tramites.class);
			break;
		case R.id.main_gob:
			showActivity(Gobierno.class);
			break;
		}
	}

	/** Mostramos la opción seleccionada. */
	public void showActivity(Class<?> c) {
		if (Preferences.getVibration(getApplicationContext())) {
			setVibration(300);
		}
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, c));
		startActivity(intent);
	}

	/** Utilizamos la alerta vibrante. */
	public void setVibration(int miliSeconds) {
		Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		v.vibrate(miliSeconds);
	}
}