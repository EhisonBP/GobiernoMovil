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

package gob.movil.twitter;

import gob.movil.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class Timeline extends Activity implements ViewFactory {
	private TextSwitcher switcher;
	private TextWatcher watcher;
	private EditText status;
	private Button update;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timeline);
		switcher = (TextSwitcher) findViewById(R.id.switcher);
		switcher.setFactory(this);
		status = (EditText) findViewById(R.id.status);
		update = (Button) findViewById(R.id.update);
		switcher.setText(getString(R.string.max_length));
		watcher = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable text) {
				// TODO Auto-generated method stub
			}

			@Override
			public void beforeTextChanged(CharSequence text, int start,
					int count, int after) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence text, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				switcher.setText(String.valueOf(Integer.parseInt(getString(
						R.string.max_length).toString())
						- text.length()));
				update.setEnabled(text.length() != 0 ? true : false);
			}
		};
		status.addTextChangedListener(watcher);
	}

	/** @return Texto del TextSwitcher. */
	@Override
	public View makeView() {
		TextView text = new TextView(this);
		text.setTextSize(20);
		return text;
	}
}