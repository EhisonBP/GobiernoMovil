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
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show extends Activity {

	public static void setDialog(Context context, String[] data) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.show);
		dialog.setTitle(data[2]);
		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);
		TextView text = (TextView) dialog.findViewById(R.id.public_official);
		text.setText(data[3] + ".\n" + context.getString(R.string.address)
				+ ": " + data[4] + ".\n" + context.getString(R.string.phones)
				+ ": " + data[5] + "\n" + context.getString(R.string.web)
				+ ": " + data[6] + "\n");
		Button ok = (Button) dialog.findViewById(R.id.ok);
		ok.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		// if (!data[7].equals("")) {
		// Button twitter = (Button) dialog.findViewById(R.id.twitter);
		// twitter.setVisibility(0);
		// twitter.setText(data[7]);
		// twitter.setOnClickListener(new OnClickListener() {
		// public void onClick(View v) {
		// dialog.dismiss();
		// }
		// });
		// }
		dialog.show();
	}

	public static void setToast(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
}