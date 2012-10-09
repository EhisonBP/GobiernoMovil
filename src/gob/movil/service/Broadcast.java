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


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Modulo que permite ejecutar el servico al encender el dispositivo movil 
 * 
 * @author Ehison Pérez
 * 
 */

public class Broadcast extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
			Intent serviceIntent = new Intent(context, Notifications.class);
			context.startService(serviceIntent);
		}
	}
}
