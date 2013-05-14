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
package gob.movil.app;

import gob.movil.R;
import gob.movil.info.Preferences;
import gob.movil.info.Show;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Módulo de alcaldías pertenecientes a un estado. Se accede a través del poder
 * municipal.
 * 
 * @author Richard Ricciardelli
 * 
 */
public class Mayoralties extends Main {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mayoralties);
		Intent receive = getIntent();
		final int state = receive.getIntExtra("item", 0);
		String[] items = getListItems(this, MAYORALTIES + " WHERE estado = "
				+ state + " ORDER BY nombre");
		final ListView lv = (ListView) findViewById(R.id.list_mayor);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(listAdapter);
		AnimationSet set = new AnimationSet(true);

		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(200);
		set.addAnimation(animation);

		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				-1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(200);
		set.addAnimation(animation);

		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		lv.setLayoutAnimation(controller);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				try {
					String[] mayoralties = getArrayFromCursor(
							getApplicationContext(),
							"SELECT * FROM " + MAYORALTIES
									+ " WHERE nombre = '"
									+ lv.getItemAtPosition(position) + "' AND "
									+ " estado = " + state);
					Show.setDialog(Mayoralties.this, mayoralties);
				} catch (Exception e) {
					if (Preferences.getVibration(getApplicationContext())) {
						setVibration(VIBRATION_ERROR);
					}
					Show.setToast(getApplicationContext(),
							getString(R.string.error_db));
				}
			}
		});
	}
}