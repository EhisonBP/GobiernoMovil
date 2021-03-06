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

import android.annotation.SuppressLint;
import android.provider.BaseColumns;

/**
 * Interfaz de constantes.
 * 
 * @author Richard Ricciardelli
 * @author Ehison Pérez
 * 
 */
@SuppressLint("SdCardPath")
public interface Constants extends BaseColumns {
	public static final String POWERS = "poder";
	public static final String STATES = "estado";
	public static final String MUNICIPALITIES = "municipios";
	public static final String AGENCIES = "institucion";
	public static final String PROCEDURES = "tramites";
	public static final String MAYORALTIES = "alcaldias";
	public static final String WHERE = " WHERE ";
	public static final String OR = " OR ";
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	public static final int INSTITUTION_ID = 1;
	public static final int MAYORALTIES_ID = 2;
	public static final int PROCEDURES_ID = 3;
	public static final int VIBRATION_ERROR = 80;
	public static final int VIBRATION_INTENT = 30;
	public static final int WAITING_PERIOD = 2000;
	public static final int CONNECTION_TIMEOUT = 1000; // 8000
	// Reality => 120000 (2 minutes)
	public static final int START_AUTOMATIC_UPDATE = 30000;
	// Reality => 36000000 (10 hours)
	public static final int PERIOD_AUTOMATIC_UPDATE = 120000;
	public static final String NAMESPACE = "http://www.cnti.gob.ve/servicio/ServicioDirectorioEstadoVenezolano";
	// "http://10.16.17.101:8080/Directorio/ServicioDirectorioEstadoVenezolano?WSDL";
	// Laboratorio:
	// "http://10.0.207.55:8080/Directorio/ServicioDirectorioEstadoVenezolano?WSDL";
	// "http://172.26.16.55:8080/Directorio/ServicioDirectorioEstadoVenezolano?WSDL";
	// Richard's home localhost:
	// "http://192.168.1.100:8080/Directorio/ServicioDirectorioEstadoVenezolano?WSDL"
	//public static final String WEB_SERVICE_URL = "http://10.16.17.101:8080/Directorio/ServicioDirectorioEstadoVenezolano?WSDL";
	public static final String WEB_SERVICE_URL = "http://10.16.17.101:9090/Directorio/ServicioDirectorioEstadoVenezolano?WSDL";
	public static final String DB_PATH = "/data/data/gob.movil/databases/";
}
