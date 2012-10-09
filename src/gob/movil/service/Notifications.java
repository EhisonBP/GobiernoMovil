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

import gob.movil.R;
import gob.movil.info.Constants;
import gob.movil.info.Update;
import gob.movil.model.Alcaldia;
import gob.movil.model.Institucion;
import gob.movil.model.Tramite;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Notification;
import android.app.NotificationManager;
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
public class Notifications extends Service implements Constants {
	
	private NotificationManager mNotification;
	private static final int ID_NOTIFICATION_CREAR = 1;
	private static final long time = System.currentTimeMillis();
	private Timer timer; 
	
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();                   
		Toast.makeText(this, "Servicio creado", Toast.LENGTH_LONG).show();
		Log.d("SERVICEBOOT", "Servicio creado");
		timer = new Timer();
	}
	
	public int onStartCommand(Intent intent, int flags, int startId){
		super.onStartCommand(intent, flags, startId);
		timer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				String fecha = Update.fecha();
				Log.i("SERVICEBOOT", "El servicio se ejecuto automaticamente a las "+ time );
						int metodo = 0;
						boolean res = false;
						do{
							switch (metodo){
								case 0:
									try {
										List<Institucion> resultado = SoapClient.ListarInstituciones(fecha, 2);
										if (resultado != null){
											mNotification = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
											mNotification.notify(ID_NOTIFICATION_CREAR, showNotification("Actualizacion de Instituciones"));
											res = true;
										}
									} catch (XmlPullParserException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								case 1:
									try {
										List<Tramite> resultado1 = SoapClient.ListarTramites(fecha, 2);
										if (resultado1 != null){
											mNotification = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
											mNotification.notify(ID_NOTIFICATION_CREAR, showNotification("Actualizacion de Tramites"));
											res = true;
										}
									} catch (XmlPullParserException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								default :
									try {
										List<Alcaldia> resultado2 = SoapClient.ListarAlcaldias(fecha, 2);
										if (resultado2 != null){
											mNotification = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
											mNotification.notify(ID_NOTIFICATION_CREAR, showNotification("Actualizacion de alcaldias"));
											res = true;
										}
									} catch (XmlPullParserException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									}
							metodo++;
						}while (metodo <= 2 && res == false);
			}
		}
		, START_AUTOMATIC_UPDATE, PERIOD_AUTOMATIC_UPDATE);
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		timer.cancel();
		Toast.makeText(this, "Servicio destruido", Toast.LENGTH_LONG).show();
		Log.d("SERVICEBOOT", "Servicio destruido");
	}
	
	public Notification showNotification(CharSequence description){
		CharSequence alert = "Actualizacion automatica";
		Notification notification = new Notification(R.drawable.icon, alert, time);
		Context context = getApplicationContext();
		CharSequence title = "Se ha encontrado una actualizacion";
		Intent notIntent = new Intent(context, Update.class);
		PendingIntent contIntent = PendingIntent.getActivity(context, 0, notIntent, 0);
		notification.setLatestEventInfo(context, title, description, contIntent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		return notification;
	}

}
