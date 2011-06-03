package gob.movil.app;

import gob.movil.R;
import gob.movil.info.About;
import gob.movil.info.Help;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class GobiernoMovil extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			showActivity(About.class);
			return true;
		case R.id.help:
			showActivity(Help.class);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void showActivity(Class<?> c) {
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, c));
		startActivity(intent);
	}

	public void onQuitClick(View button) {
		finish();
	}
}