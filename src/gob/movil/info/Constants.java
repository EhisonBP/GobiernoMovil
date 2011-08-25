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

import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
	public static final String POWERS = "powers";
	public static final String STATES = "states";
	public static final String MUNICIPALITIES = "municipalities";
	public static final String AGENCIES = "agencies";
	public static final String PROCEDURES = "procedures";
	public static final String MAYORALTIES = "mayoralties";
	public static final String INSERT = "INSERT INTO ";
	public static final String SELECT = "SELECT * FROM ";
	public static final String WHERE = " WHERE ";
	public static final String OR = " OR ";
	public static final int VIBRATION_ERROR = 80;
	public static final int VIBRATION_INTENT = 30;
	public static final String CONSUMER_KEY = "Your consumer key here";
	public static final String CONSUMER_SECRET = "Your consumer secret here";
}