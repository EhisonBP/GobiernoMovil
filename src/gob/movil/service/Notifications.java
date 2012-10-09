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
package gob.movil.service;

import gob.movil.info.Update;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * 
 * @author ehisonbp
 *
 */
public class Notifications extends Service {
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();                   
		Toast.makeText(this, "Servicio creado", Toast.LENGTH_LONG).show();
		int icon = android.R.drawable.stat_sys_warning;
		CharSequence alert = "Actualizacion automatica";
		long time = System.currentTimeMillis();
		Notification notification = new Notification(icon, alert, time);
		
		Context context = getApplicationContext();
		CharSequence title = "Se ha encontrado una actualizacion";
		CharSequence description = "xxxxxxxxxxxxxxxxxxxxxx";
		Intent notIntent = new Intent(context, Update.class);
		PendingIntent contIntent = PendingIntent.getActivity(context, 0, notIntent, 0);
		notification.setLatestEventInfo(context, title, description, contIntent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		
		Log.d("SERVICEBOOT", "Servicio creado");
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Servicio destruido", Toast.LENGTH_LONG).show();
		Log.d("SERVICEBOOT", "Servicio destruido");
	}

}
