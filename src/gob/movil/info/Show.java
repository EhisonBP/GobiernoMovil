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
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show extends Activity {

	public void setDialog(Context context, Cursor query) {
		query.moveToFirst();
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.show);
		dialog.setTitle(query.getString(2));
		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);
		TextView text = (TextView) dialog.findViewById(R.id.public_official);
		text.setText(query.getString(3) + ".\n"
				+ context.getString(R.string.address) + ": "
				+ query.getString(4) + ".\n"
				+ context.getString(R.string.phone) + ": " + query.getString(5)
				+ "\n" + context.getString(R.string.web) + ": "
				+ query.getString(6) + "\n");
		Button ok = (Button) dialog.findViewById(R.id.ok);
		ok.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		if (!query.getString(7).equals("")) {
			Button twitter = (Button) dialog.findViewById(R.id.twitter);
			twitter.setVisibility(0);
			twitter.setText(query.getString(7));
			twitter.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
		}
		dialog.show();
	}

	public void setToast(Context context, String message) {
		CharSequence text = message;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}