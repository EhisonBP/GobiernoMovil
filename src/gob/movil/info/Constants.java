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

import android.provider.BaseColumns;

/**
 * Interfaz de constantes.
 * 
 * @author Richard Ricciardelli
 * @author Ehison Pérez
 * 
 */
public interface Constants extends BaseColumns {
	public static final String POWERS = "poder";
	public static final String STATES = "estado";
	public static final String MUNICIPALITIES = "municipios";
	public static final String AGENCIES = "institucion";
	public static final String PROCEDURES = "tramites";
	public static final String MAYORALTIES = "alcaldias";
	public static final String WHERE = " WHERE ";
	public static final String OR = " OR ";
	public static final int VIBRATION_ERROR = 80;
	public static final int VIBRATION_INTENT = 30;
	public static final String NAMESPACE = "http://www.cnti.gob.ve/servicio/ServicioDirectorioEstadoVenezolano";
	public static final String WEB_SERVICE_URL = "http://10.16.17.101:8080/Directorio/ServicioDirectorioEstadoVenezolano?WSDL";
	public static final String DB_PATH = "/data/data/gob.movil/databases/";

}