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

package gob.movil.app;

import gob.movil.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Government extends Main {
	EditText NAME;
	EditText EMAILTEXT;
	RadioButton SUBJECT;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.government);

		NAME = (EditText) findViewById(R.id.name);
		EMAILTEXT = (EditText) findViewById(R.id.email_text);
		SUBJECT = (RadioButton) findViewById(R.id.general);
	}

	public void onSendClick(View button) {
		String radioButtonSelected;
		if (SUBJECT.isChecked()) {
			radioButtonSelected = getString(R.string.general);
		} else {
			radioButtonSelected = getString(R.string.news);
		}
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
				new String[] { getString(R.string.email) });
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				getString(R.string.government_online) + " - "
						+ radioButtonSelected.toString());
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				EMAILTEXT.getText() + "\n\n\n" + NAME.getText() + "\n\n"
						+ getString(R.string.signature));
		Government.this.startActivity(Intent.createChooser(emailIntent,
				getString(R.string.select)));
	}
}