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
import gob.movil.info.DatabaseHelper;
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

/**
 * Clase para el servicio de notificaciones de actualizaciones para la base de
 * datos de Gobierno en Línea.
 * 
 * @author Ehison Pérez
 * 
 */
public class Notifications extends Service implements Constants {

	private NotificationManager mNotification;
	private static final int ID_NOTIFICATION_CREATE = 1;
	private static final long time = System.currentTimeMillis();
	public Context context;
	public DatabaseHelper helper;
	private Timer timer;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		timer = new Timer();
		// Toast.makeText(this, "Servicio creado", Toast.LENGTH_LONG).show();
		Log.d("NOTIFICATION SERVICE", "El servicio ha sido creado");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		respuesta(timer);
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		timer.cancel();
		// Toast.makeText(this, "Servicio destruido", Toast.LENGTH_LONG).show();
		Log.d("NOTIFICATION SERVICE", "El servicio ha sido destruido");
	}

	public void respuesta(Timer timer) {
		crearBBDD();
		helper.abrirBaseDatos();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				String fecha = helper.fechaActualizacion();
				try {
					Log.i("NOTIFICATION SERVICE", "El valor ingresado es "
							+ fecha);
				} catch (Exception w) {
					Log.w("NOTIFICATION SERVICE",
							"Error en la carga de la fecha");
				}
				Log.i("NOTIFICATION SERVICE",
						"El servicio se ejecutó automáticamente a las " + time);
				int metodo = 0;
				boolean res = false;
				do {
					switch (metodo) {
					case 0:
						try {
							List<Institucion> resultado = SoapClient
									.listarInstituciones(fecha, 2);
							if (resultado != null) {
								mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
								mNotification
										.notify(ID_NOTIFICATION_CREATE,
												showNotification(getString(R.string.institutions_update)));
								res = true;
								resultado.clear();
							}
						} catch (XmlPullParserException e) {
							e.printStackTrace();
						} catch (IOException e) {
							// e.printStackTrace();
							Log.w("NOTIFICATION EXCEPTION",
									"No hay instituciones nuevas");
						}
						break;
					case 1:
						try {
							List<Tramite> resultado = SoapClient
									.listarTramites(fecha, 2);
							if (resultado != null) {
								mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
								mNotification
										.notify(ID_NOTIFICATION_CREATE,
												showNotification(getString(R.string.procedures_update)));
								res = true;
								resultado.clear();
							}
						} catch (XmlPullParserException e) {
							e.printStackTrace();
						} catch (IOException e) {
							// e.printStackTrace();
							Log.w("NOTIFICATION EXCEPTION",
									"No hay trámites nuevos");
						}
						break;
					default:
						try {
							List<Alcaldia> resultado = SoapClient
									.listarAlcaldias(fecha, 2);
							if (resultado != null) {
								mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
								mNotification
										.notify(ID_NOTIFICATION_CREATE,
												showNotification(getString(R.string.mayoralties_update)));
								res = true;
								resultado.clear();
							}
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							Log.w("NOTIFICATION EXCEPTION",
									"No hay alcaldías nuevas");
						}
					}
					metodo++;
				} while (metodo <= 2 && !res);
			}
		}, START_AUTOMATIC_UPDATE, PERIOD_AUTOMATIC_UPDATE);
		helper.close();
	}

	public Notification showNotification(CharSequence description) {
		CharSequence alert = getString(R.string.notification_alert);
		Notification notification = new Notification(R.drawable.icon, alert,
				time);
		Context context = getApplicationContext();
		CharSequence title = getString(R.string.notification_title);
		Intent notIntent = new Intent(context, Update.class);
		PendingIntent contIntent = PendingIntent.getActivity(context, 0,
				notIntent, 0);
		notification
				.setLatestEventInfo(context, title, description, contIntent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		return notification;
	}

	public void crearBBDD() {
		try {
			helper = new DatabaseHelper(this);
			helper.crearDataBase();
		} catch (IOException ioe) {
			Log.w("NOTIFICATION SERVICE",
					"Error en el copiado de la base de datos");
		}
	}
}