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

import static android.provider.BaseColumns._ID;
import static gob.movil.info.Constants.AGENCIES;
import static gob.movil.info.Constants.INSERT;
import static gob.movil.info.Constants.MAYORALTIES;
import static gob.movil.info.Constants.MUNICIPALITIES;
import static gob.movil.info.Constants.POWERS;
import static gob.movil.info.Constants.PROCEDURES;
import static gob.movil.info.Constants.STATES;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "gm.db";
	private static final int DB_VERSION = 43;
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + POWERS + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL("CREATE TABLE " + STATES + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL("CREATE TABLE " + MUNICIPALITIES + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, state INTEGER NOT NULL, FOREIGN KEY(state) REFERENCES states(" + _ID + "))");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Baruta', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Chacao', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Distrito Metropolitano', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'El Hatillo', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '1')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Alto Orinoco', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Atabapo', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Atures', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Autana', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guainía', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Manapiare', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Río Negro', '2')");

		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Anaco', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Aragua', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bruzual', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cajigal', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Carvajal', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Freites', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guanta', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertad', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Lic. Diego Bautista Urbaneja', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'McGregor', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Monagas', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Peñalver', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San José de Guanipa', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Juan de Capistrano', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santa Ana', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Simón Rodríguez', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sotillo', '3')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Achaguas', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Alto Apure', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Biruaca', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Muñoz', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Páez', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pedro Camejo', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rómulo Gallegos', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Fernando', '4')");

		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antonio José de Sucre', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Atanasio Girardot', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Camatagua', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ezequiel Zamora', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Francisco Linares Alcántara', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José Ángel Lamas', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José Félix Ribas', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José Rafael Revenga', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mario Briceño Iragorry', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ocumare de la Costa de Oro', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rafael Guillermo Urdaneta', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Casimiro', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Sebastián de los Reyes', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santiago Mariño', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santos Michelena', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tovar', '5')");
		
		// TODO Fix this block.
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Alberto Arvelo Torrealba', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Eloy Blanco', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antonio José de Sucre', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Arismendi', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Barinas', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Barinitas', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cruz Paredes', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Obispos', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pedraza', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rojas', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sosa', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Zamora', '6')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Caroní', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cedeño', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'El Callao', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Gran Sabana', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Heres', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Padre Pedro Chien', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Piar', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Raúl Leoni', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Roscio', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sifontes', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '7')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bejuma', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Carlos Arvelo', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Diego Ibarra', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guacara', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Juan José Mora', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Los Guayos', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Miranda', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Montalbán', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Naguanagua', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Puerto Cabello', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Diego', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Joaquín', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Valencia', '8')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Falcón', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Lima Blanco', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ricaurte', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rómulo Gallegos', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Carlos', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tinaco', '9')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antonio Díaz', '10')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Casacoima', '10')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pedernales', '10')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tucupita', '10')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Acosta', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Buchivacoa', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cacique Manaure', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Carirubana', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Colina', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Dabajuro', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Democracia', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Falcón', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Federación', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Jacura', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Los Taques', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mauroa', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Monseñor Iturriza', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Palmasola', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Petit', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Píritu', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Francisco', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Silva', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tocópero', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Urumaco', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Zamora', '11')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Camaguán', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Chaguaramas', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'El Socorro', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Infante', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Las Mercedes', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mellado', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Miranda', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Monagas', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ortíz', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ribas', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Roscio', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Gerónimo de Guayabal', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San José de Guaribe', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santa María de Ipire', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Zaraza', '12')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Crespo', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Iribarren', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Jiménez', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Morán', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Palavecino', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Simón Planas', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Torres', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Urdaneta', '13')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Acarigua', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Bello', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antonio Pinto Salinas', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Arzobispo Chacón', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Campo Elías', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Caracciolo Parra', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cardenal Quintero', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guaraque', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Julio César Salas', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Miranda', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Obismo Ramos de Lora', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Padre Noguera', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pueblo Llano', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rangel', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rivas Dávila', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santos Marquina', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tovar', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tulio Febres Cordero', '14')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Acevedo', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Bello', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Baruta', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Brión', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Buroz', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Chacao', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cristóbal Rojas', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'El Hatillo', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guaicaipuro', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Independencia', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Los Salias', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Páez', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Paz Castillo', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pedro Gual', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Plaza', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Simón Bolívar', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tomás Lander', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Urdaneta', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Zamora', '15')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Acosta', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Aguasay', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Caripe', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cedeño', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ezequiel Zamora', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Maturín', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Piar', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Punceres', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santa Bárbara', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sotillo', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Uracoa', '16')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antolín del Campo', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Arismendi', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Díaz', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'García', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Gómez', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Maneiro', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Marcano', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mariño', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Península de Macanao', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Tubores', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Villalba', '17')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Agua Blanca', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Araure', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Boconoíto', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Esteller', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guanare', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guanarito', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Monseñor José Vicente de Unda', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ospino', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Papelón', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Rafael de Onoto', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santa Rosalía', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Turén', '18')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Eloy Blanco', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Mata', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Arismendi', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Benítez', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bermúdez', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cajigal', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cruz Salmerón Acosta', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mariño', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mejías', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Montes', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ribero', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Valdés', '19')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Bello', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antonio Acosta', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Ayacucho', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cárdenas', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Córdova', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Fernández Feo', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Francisco Miranda', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'García de Hevia', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Guásimos', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Independencia', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Jáuregui', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José María Vargas', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Junín', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Libertador', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Lobatera', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Michelena', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Panamericano', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pedro María de Ureña', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rafael Urdaneta', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Samuel Darío Maldonado', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Cristóbal', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Judas Tadeo', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Seboruco', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Simón Rodríguez', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Torbes', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Uribante', '20')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Bello', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Boconó', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Campo Elías', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Candelaria', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Carache', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Escuque', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José Felipe Márquez Cañizalez', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'La Ceiba', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Monte Carmelo', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pampán', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Pampanito', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Rafael', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Rafael de Carvajal', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Trujillo', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Urdaneta', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Valera', '21')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Vargas', '22')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Arístides Bastidas', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bolívar', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Bruzual', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cocorote', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Independencia', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José Antonio Páez', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'La Trinidad', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Manuel Monge', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Nirgua', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Peña', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Felipe', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Urachiche', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Veroes', '23')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Baralt', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Cabimas', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Colón', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Francisco Javier Pulgar', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'José María Semprum', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'La Cañada de Urdaneta', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Lagunillas', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Machique de Perijá', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Mara', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Maracaibo', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Páez', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Rosario de Perijá', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'San Francisco', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Santa Rita', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Simón Bolívar', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Sucre', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Valmore Rodríguez', '24')");
		
		db.execSQL("CREATE TABLE " + AGENCIES + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, officer STRING, office STRING, address TEXT, phone STRING, web STRING, twitter STRING, power INTEGER NOT NULL, state INTEGER NOT NULL, FOREIGN KEY(power) REFERENCES powers(" + _ID + "), FOREIGN KEY(state) REFERENCES states(" + _ID + "))");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia de la República', 'Hugo Rafael Chávez Frías', 'Presidente de la República', 'Palacio de Miraflores', 'No disponible.', 'http://www.chavez.org.ve', '@chavezcandanga', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Vicepresidencia de la República', 'Elías José Jaua Milano', 'Vicepresidente de la República', 'Av. Urdaneta. Esquina de Carmelitas. Caracas', '(0212)8603335 / (0212)8608822', 'http://www.vicepresidencia.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Asuntos de la Mujer e Igualdad de Género', 'Nancy Pérez Sierra', 'Ministra de Estado para Asuntos de la Mujer e Igualdad de Género', 'Av. Lecuna, Parque Central, Torre Este Piso 4, Caracas', 'No disponible.', 'http://www.minmujer.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Agricultura y Tierras', 'Juan Carlos Loyo', 'Ministro del Poder Popular de Agricultura y Tierras', 'Av. Urdaneta entre esquina Platanal a Candilito a media cuadra de la Plaza La Candelaria, parroquia La Candelaria', '(0800)2474285', 'http://www.mat.gob.ve\nCorreo: atencionintegralalsoberano@gmail.com', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Alimentación', 'Félix Osorio Guzmán', 'Ministro del Poder Popular para la Alimentación', 'No disponible.', 'No disponible.', 'http://www.minpal.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Ambiente', 'Alejandro Hitcher', 'Ministro del Poder Popular para el Ambiente', 'Centro Simón Bolivar, Torre Sur, Plaza Caracas', '(0212)4081111', 'http://www.minamb.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Banca Pública', 'Humberto Rafael Ortega Díaz', 'Ministro de Estado para la Banca Pública', 'No disponible.', 'No disponible.', 'No disponible.', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Ciencia, Tecnología e Industrias Intermedias', 'Ricardo Menéndez', 'Ministro del Poder Popular para la Ciencia, Tecnología e Industrias Intermedias', 'Av. Universidad. Esquina El Chorro. Torre Ministerial. La Hoyada, Caracas', '(0212)5557401 / (0212)5557402 / (0212)5557403 / (0212)5557404 / (0212)5557405 / (0212)5557406 / (0212)5557407 / (0212)5557408 / (0212)5557409 / (0212)5557410 / Fax: (0212)5557504', 'http://www.mct.gob.ve\nCorreo: mcti@mcti.gob.ve', '@mcti', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Comercio', 'Richard Canan', 'Ministro del Poder Popular para el Comercio', 'Av. Lecuna, Torre Oeste de Parque Central, Entrada por el Nivel Lecuna', '(0212)5096861', 'http://www.mincomercio.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Comunas', 'Isis Ochoa', 'Ministra del Poder Popular para las Comunas', 'Av. Nueva Granada. Edificio INCES, Sede. Caracas - Venezuela', '(0212)6032396 / (0212)6032397', 'http://www.mpcomunas.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Comunicación y la Información', 'Andrés Izarra', 'Ministro del Poder Popular para la Comunicación y la Información', 'Av. Universidad, Torre Ministerial, pisos 9 y 10', '(0212)5053322', 'http://www.minci.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Cultura', 'Francisco Sesto', 'Ministro del Poder Popular para la Cultura', 'Av. Panteón, Foro Libertador, Edif. Archivo General de la Nación, PB', '(0212)5095600', 'http://www.ministeriodelacultura.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Defensa', 'Carlos Mata Figueroa', 'Ministro del Poder Popular de la Defensa', 'Fuerte Tiuna. Caracas', 'No disponible.', 'http://www.mindefensa.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Deporte', 'Hector Rodríguez Castro', 'Ministro del Poder Popular para el Deporte', 'Av. Teherán, Sede Principal del Ministerio del Poder Popular para el Deporte, S/N, Urbanización Montalbán, La Vega, Caracas, Distrito Capital', '(0212)4432682 / (0212)4723224', 'http://www.mindeporte.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Despacho de la Presidencia', 'Francisco José Ameliach Orta', 'Ministro del Poder Popular para el Despacho de la Presidencia', 'Final Av. Urdaneta, Esq. de Bolero, Palacio de Miraflores, Caracas', '(0212)8063111 / (0212)8063229', 'http://www.presidencia.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Educación Universitaria', 'Yadira Córdova', 'Ministra del Poder Popular para la Educación Universitaria', 'Av. Universidad. Esq. El Chorro, Torre Ministerial, pisos: 1-7, Caracas', '(0212)5965270 / (0212)5965274 / Fax: (0212)5965261', 'http://www.mes.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Educación', 'Maryann Hanson', 'Ministra del Poder Popular para la Educación', 'Esq. de Salas a Caja de Agua, Edif. Sede del MPPE Parroquia Altagracia, Caracas', '(0212)5964111', 'http://www.me.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Energía Eléctrica', 'Alí Rodríguez Araque', 'Ministro del Poder Popular para la Energía Eléctrica', 'Av Tamanaco, Urb. El Rosal, Municipio Chacao, Código Postal 1060, Estado Miranda', 'No disponible.', 'http://www.mppee.gob.ve', '', '1', '15')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Energía y Petróleo', 'Rafael Ramírez', 'Ministro del Poder Popular de Energía y Petróleo', 'Edificio Pétroleos de Venezuela, Torre Oeste, Av. Libertador con Av. Empalme, Urbanización La Campiña, Parroquia El Recreo. Caracas', '(0212)7087631 / (0212)7087338 / Fax: (0212)7087598', 'http://www.pdvsa.com', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Industrias Básicas y la Minería', 'José Khan Fernández', 'Ministro del Poder Popular para las Industrias Básicas y la Minería', 'Av. La Estancia, Torre las Mercedes, piso 9, Urb. Chuao, Caracas', '(0212)9500311', 'http://www.mibam.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Obras Públicas y Vivienda', 'Ricardo Colina', 'Ministro del Poder Popular para las Obras Públicas y Vivienda', 'Av. Francisco de Miranda, Torre de Los Dos Ministerios, Municipio Chacao, Edo. Miranda', '(0212)2668625 / (0212)2069517 / (0212)2069519 / Fax: (0212)2654644', 'http://www.mvh.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Planificación y Desarrollo', 'Jorge Giordani', 'Ministro del Poder Popular para la Planificación y Desarrollo', 'Av. Urdaneta, con esquina de Carmelitas, Edificio Sede del Ministerio del Poder Popular de Planificación y Finanzas. Caracas', '(0212)8021000', 'http://www.mf.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Pueblos Indígenas', 'Nicia Maldonado', 'Ministra del Poder Popular para los Pueblos Indígenas', 'Av. Universidad Esq. Traposos, Antiguo Edificio Sudeban, Piso 8. Caracas', '(0212)5431599', 'http://www.minpi.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Relaciones Exteriores', 'Nicolás Maduro Moros', 'Ministro del Poder Popular para las Relaciones Extranjeras', 'No disponible.', 'No disponible.', 'No disponible.', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Relaciones Interiores y Justicia', 'Tareck El Aissami', 'Ministro del Poder Popular para las Relaciones de Interior y Justicia', 'Av. Urdaneta, Esquina Platanal', '(0212)5061111', 'http://www.mij.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Salud', 'Eugenia Sader Castellanos', 'Ministra del Poder Popular para la Salud', 'Av. Baralt, Centro Simón Bolívar, Edif. Sur, El Silencio, Caracas', '(0212)4080000', 'http://www.mpps.gob.ve/\nCorreo: mpps@mpps.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Trabajo y Seguridad Social', 'María Cristina Iglesias', 'Ministra del Poder Popular del Trabajo y Seguridad Social', 'Centro Simón Bolívar. Torre Sur. Piso 5. Caracas', '(0212)4084222 / (0212)4084229 / (0212)4084234', 'http://www.minpptrass.gob.ve\nCorreo: maria.cristina@minpptrass.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Transporte y Comunicaciones', 'Francisco Garcés', 'Ministro del Poder Popular para Transporte y Comunicaciones', 'Torre MTC, Municipio Chacao. Distrito Capital', '(0212)2015042', 'http://www.mtc.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Turismo', 'Alejandro Fleming', 'Ministro del Poder Popular para el Turismo', 'Av. Francisco de Miranda con Av. Principal la Floresta Edif. MINTUR, Municipio Chacao', '(0212)2084651 / (0212)2084652', 'http://www.mintur.gob.ve/', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Procuraduría General de la República', 'Dra. Margarita Luisa Mendola Sánchez', 'Procuradora General de la República', 'Av. Los Ilustres, cruce con calle Francisco Lazo Martí, Edif. Sede Procuraduría General de la República, Urb. Santa Mónica - Caracas', '(0212)5973300 / (0212)5973903', 'http://www.pgr.gob.ve', '', '1', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia - Asamblea Nacional', 'Luis Fernando Soto Rojas', 'Presidente de la Asamblea Nacional', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Primera Vicepresidencia - Asamblea Nacional', 'Aristóbulo Isturiz', 'Primer Vicepresidente', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Segunda Vicepresidencia - Asamblea Nacional', 'Blanca Eekhout', 'Segunda Vicepresidenta', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Secretaría  - Asamblea Nacional', 'Iván Zerpa', 'Secretario', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Subsecretaría  - Asamblea Nacional', 'Victor Clark', 'Subsecretario', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia - TSJ', 'Luisa Estella Morales Lamuño', 'Presidenta del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019932', 'http://www.tsj.gov.ve\nCorreo: luisa.morales@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Primera Vicepresidencia - TSJ', 'Omar Mora Díaz', 'Primer Vicepresidente del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019223', 'http://www.tsj.gov.ve\nCorreo: omar.mora@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Segunda Vicepresidencia - TSJ', 'Jhannett María Madríz Sotillo', 'Segunda Vicepresidenta del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019633', 'http://www.tsj.gov.ve\nCorreo: jhannett.madriz@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Sala Político-Administrativa', 'Evelyn Margarita Marrero Ortíz', 'Magistrada Presidenta de la Sala Político-Administrativa', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019823', 'http://www.tsj.gov.ve\nCorreo: evelyn.marrero@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Sala de Casación Civil', 'Yris Armenia Peña de Andueza', 'Magistrada Presidenta de la Sala de Casación Civil', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019620', 'http://www.tsj.gov.ve\nCorreo: iris.pena@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Sala de Casación Penal', 'Ninoska Queipo Briceño', 'Magistrada Presidenta de la Sala de Casación Penal', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019419', 'http://www.tsj.gov.ve\nCorreo: ninoska.queipo@tsj.gov.ve', '', '3', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia - CNE', 'Tibisay Lucena', 'Presidenta del Consejo Nacional Electoral\nPresidenta de la Junta Nacional Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Vicepresidencia - CNE', 'Sandra Oblitas Ruzza', 'Vicepresidenta del Consejo Nacional Electoral\nPresidenta de la Comisión de Registro Civil y Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia de la Comisión de Participación Política y Financiamiento', 'Vicente José Gregorio Díaz Silva', 'Presidente de la Comisión de Participación Política y Financiamiento', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Comisión de Participación Política y Financiamiento', 'Socorro Elizabeth Hernández Hernández', 'Miembro de la Comisión de Participación Política y Financiamiento', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Junta Nacional Electoral', 'Tania D´ Amelio Cardiet', 'Miembro de la Junta Nacional Electoral\nMiembro de la Comisión de Registro Civil y Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Contraloría General de la República', 'Clodosbaldo Russián Uzcátegui', 'Contralor General de la República', 'Av. Andrés Bello. Edif. Contraloría General de la República, Caracas', '(0212)5083111 / (0212)5083000', 'http://www.cgr.gob.ve', '', '5', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Defensoría del Pueblo', 'Gabriela Ramírez', 'Defensora del Pueblo', 'Av. México, Plaza Morelos, Edif. Defensoría del Pueblo, piso 8, frente al Ateneo. Caracas', '(0212)5754703 / (0212)5755103 / Fax: (0212)5754467', 'http://www.defensoria.gob.ve', '', '5', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Fiscalía - Ministerio Público', 'Dra. Luisa Ortega Díaz', 'Fiscal General de la República', 'Edificio Sede del Despacho de la Fiscal General de la República, esquina de Misericordia a Pele El Ojo, Av. México, Caracas', '(0212)5097211 / (0212)5097464', 'No disponible.', '', '5', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Armada', 'Almirante Carlos Máximo Aniasi Turchio', 'Comandante General de la Armada', 'Meseta de Mamo, Catia La Mar, La Guaira, Vargas', '(0212)3512151', 'http://www.armada.mil.ve', '', '8', '22')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'CICPC', 'Wilmer Flores Trocel', 'Director General del Cuerpo de Investigaciones Científicas, Penales y Criminalísticas', 'Sede Principal - Av. Urdaneta, de Pelota a Punceres Edif. CICPC', '(0800)2427224', 'http://www.cicpc.gov.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Cuerpo de Bomberos D.C.', 'Cdmte. Gral. (B) Ángel William Martínez', 'Primer Comandante de la Institución', 'Avenida Lecuna con Esquina El Rosario, Edificio Cuartel Central de Bomberos \"Victoriano Jordán Pestana\", Municipio Libertador, Distrito Capital', '(0212)5422512 / (0212)5450066', 'http://www.bomberoscaracas.gov.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Cuerpo de Policía Nacional Bolivariana', 'Luis Ramón Fernández Delgado', 'Director General del Cuerpo de Policía Nacional Bolivariana', 'Sede Principal - Edif. Radio City, Bulevar de Sabana Grande, Caracas', '(0800)7654622', 'http://www.policianacional.gob.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Ejército', 'Euclides Amador Campos Aponte', 'Comandante General del Ejército', 'El Valle, Fuerte Tiuna, Caracas', '(0212)6055454 / (0212)6055107', 'http://www.ejercito.mil.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Fuerza Aérea', 'Mayor General Jorge Arevalo Oropeza Pernalete', 'Comandante General de la Aviación Militar Nacional Bolivariana', 'Carretera Nacional vía Maracay - Mariara, sector Boca de Río, Escuela de Aviación Militar Bolivariana, Maracay, Aragua', '(0243)5118710', 'http://www.aviacion.mil.ve', '', '8', '5')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Guardia Nacional Bolivariana', 'Mayor General Luis Alfredo Motta Domínguez', 'Comandante General de la Guardia Nacional Bolivariana', 'Quinta las Acacias, el Paraíso, Caracas', '(0212)4063001 / (0212)4063002 / (0212)4063004', 'http://www.guardia.mil.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Policía Metropolitana', 'Carlos Meza', 'Director de la Policía Metropolitana', 'Sector San José, Comandancia General, Cotiza', '171', 'http://www.policianacional.gob.ve', '', '8', '1')");
		
		//Gobernaciones
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Distrito Capital', 'Jackeline Farías', 'Gobernadora del Distrito Capital', 'Esq. Principal, frente a la Plaza Bolívar, Edif. Palacio de Gobierno, El Silencio, Caracas', '(0212)8632998', 'http://www.gdc.gob.ve', '', '6', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Amazonas', 'Lobirio Guarulla', 'Gobernador del Estado Amazonas', 'Av. Río Negro, Casa de Gobierno. Puerto Ayacucho. Edo. Amazonas', '(0248)5210249 / (0248)5212859', 'No disponible.\nCorreo: sprivada@amazonas.gob.ve', '', '6', '2')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Anzóategui', 'Tarek William Saab', 'Gobernador del Estado Anzóategui', 'Palacio de Gobierno Piso N° 4. Barcelona, Edo. Anzoátegui', '(0281)2701401 / (0281)2701402 / (0281)2701403 / (0281)2701404 / Fax: (0281)2751671 / (0281)2701401 / (0281)2701402 / (0281)2701403 / (0281)2701404', 'No disponible.\nCorreo: tarek@gobernaciondeanzoategui.com', '', '6', '3')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Apure', 'Ramón Carrizales', 'Secretario General del Gobierno de Apure', 'Edificio Administrativo del Ejecutivo, calle Comerico, entre Piar y Madariaga, San Fernando de Apure', '(0247)3410156 / (0247)3411114 / (0247)3413048 / (0247)3413865', 'No disponible.\nCorreo: gobernacionapure@yahoo.com', '', '6', '4')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Aragua', 'Rafael Isea', 'Gobernador del Estado Aragua', 'Av. Miranda frente a la Plaza Bolívar Palacio de Gobierno. Maracay. Edo. Aragua', '(0243)2335646 / (0243)2331134 / Fax: (0234)2337767 / (0234)2337002', 'No disponible.', '', '6', '5')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Barinas', 'Adán Coromoto Chávez', 'Gobernador del Estado Barinas', 'Palacio del Marqués, frente a la Plaza Bolívar, Barinas, Edo. Barinas', '(0273)5301111 / (0273)5301131', 'No disponible.', '', '6', '6')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Bolívar', 'Francisco Rangel Gómez', 'Gobernador del Estado Bolívar', 'Calle Constitución. Palacio de Gobierno frente a la Plaza Bolívar. Ciudad Bolívar. Edo. Bolívar', '(0285)6002110 / (0285)6002111 / (0285)6002126 / (0285)6002127 / Fax: (0285)6002285 / (0285)6002356', 'http://www.e-bolivar.gov.ve', '', '6', '7')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Carabobo', 'Henrique Salas Feo', 'Gobernador del Estado Carabobo', 'Calle Páez entre Av. Montes de Oca y Av. Díaz Moreno, Capitolio de Valencia. Edo. Carabobo', '(0241)8742951 / Fax: (0241)8570783', 'http://www.carabobo.gob.ve', '', '6', '8')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Cojedes', 'Teodoro Bolívar', 'Gobernador del Estado Cojedes', 'Av. Sucre. Palacio de Gobierno. San Carlos. Edo. Cojedes', '(0258)4330969 / (0258)4330207 / (0258)4330533 / Fax: (0258)4336704', 'No disponible.', '', '6', '9')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Delta Amacuro', 'Lizeta Hernández', 'Gobernadora del Estado Delta Amacuro', 'Calle Bolívar. Casa de Gobierno. Tucupita. Edo. Delta Amacuro', 'No disponible.', 'http://www.deltamacuro.gob.ve', '', '6', '10')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Falcón', 'Stella Lugo', 'Gobernadora del Estado Falcón', 'Calle Ampíes. Palacio de Gobierno. Coro. Edo. Falcón', '(0268)2530513 / (0268)2511822 / (0268)2512511 / Fax: (0268)2518004', 'http://www.falcon.gob.ve', '', '6', '11')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Guárico', 'Luis Enrique Gallardo', 'Gobernador del Estado Guárico', 'Av. Monseñor Sendrea, Palacio de Gobierno, frente a la Plaza Bolívar, San Juan de Los Morros, Edo. Guárico', '(0246)4311253 / (0246)4312922 / (0246)4313533 / (0246)4310444 / (0246)4314493 / (0246)4316294 / (0246)4318055', 'http://www.guarico.gob.ve', '', '6', '12')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Lara', 'Henry Falcón', 'Gobernador del Estado Lara', 'Carrera 19. Esq. Calle 25, Barquisimeto, Edo. Lara', '(0251)2317420 / Fax: (0251)2324631', 'http://www.lara.gob.ve', '', '6', '13')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Mérida', 'Marcos Díaz Orellana', 'Gobernador del Estado Mérida', 'Av. 4, Palacio de Gobierno, Mérida, Edo. Mérida', '(0274)2510731 / (0274)2510936 / (0274)2512713 / (0274)2510936 / (0274)2510731 / (0274)2522511 / (0274)2522713', 'http://www.merida.gob.ve', '', '6', '14')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Miranda', 'Henrique Capriles Radonski', 'Gobernador del Estado Miranda', 'Calle Guaicaipuro frente a la Plaza Bolívar, Residencia Oficial del Gobernador, Los Teques', '(0212)3213979 / (0212)3217497 / (0212)3231232', 'http://www.miranda.gov.ve', '', '6', '15')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Monagas', 'José Gregorio Briceño', 'Gobernador del Estado Monagas', 'Av. Bolívar, frente a la Plaza Bolívar, Maturín, Edo. Monagas', '(0291)6411191 / (0291)6410934 / (0291)6410791 / (0291)6411396 / (0291)6411163 / (0291)6428797', 'http://www.monagas.gob.ve', '', '6', '16')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Nueva Esparta', 'Morel Rodríguez', 'Gobernador del Estado Nueva Esparta', 'Av. Constitución - La Asunción - Municipio Arismendi. Sede Ejecutiva, Piso 1', '(0295)2659983 / (0295)2659984 / (0295)2422008 / Fax: (0295)2422503', 'http://www.nuevaesparta.gob.ve', '', '6', '17')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Portuguesa', 'Wilmar Castro Soteldo', 'Gobernador del Estado Portuguesa', 'Carrera 5ta entre calles 15 y 16, frente a la Plaza Bolívar. Guanare. Edo. Portuguesa', '(0257)2515864', 'http://www.portuguesa.gob.ve', '', '6', '18')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Sucre', 'Enrique José Maestre', 'Gobernador del Estado Sucre', 'Calle Bolívar, Casa de Gobierno, Cumaná, Edo. Sucre', '(0293)4312945 / (0293)4310103 / (0239)4320381 / (0239)4671563 / Fax: (0293)4671563', 'http://www.edosucre.gov.ve', '', '6', '19')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Táchira', 'César Pérez Vivas', 'Gobernador del Estado Táchira', 'Carrera 10, entre calles 4 y 5, Frente a la Plaza Sucre, San Cristóbal, Edo. Táchira', '(0276)5102934 / (0276)5102827 / (0276)5102828 / (0276)5102876 / (0276)5102800 / Fax: (0276)5102811 / (0276)5102800', 'http://www.tachira.gob.ve', '', '6', '20')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Trujillo', 'Hugo Cabezas', 'Gobernador del Estado Trujillo', 'Av. Independencia, Palacio de Gobierno, Trujillo, Edo. Trujillo', '(0272)2362666 / (0272)2364590 / (0272)2363555 / (0272)2366466', 'No disponible.', '', '6', '21')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Vargas', 'Jorge Luis García Carneiro', 'Gobernador del Estado Vargas', 'Av. Soublette, Casa Guipuzcoana, La Guaira, Edo. Vargas', '(0212)3310372 / (0212)3310272 / (0212)3310678 / (0212)3324743 / Fax: (0212)3311266 / (0212)3321128', 'http://www.estadovargas.gob.ve', '', '6', '22')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Yaracuy', 'Julio León', 'Gobernador del Estado Yaracuy', 'Frente a la plaza Bolívar San Felipe, Palacio de Gobierno, Edo. Yaracuy', '(0254)2313276 / (0254)2312597 / (0254)2343028', 'http://www.yaracuy.gob.ve', '', '6', '23')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Gobernación del Estado Zulia', 'Pablo Pérez', 'Gobernador del Estado Zulia', 'Palacio de Gobierno, calle A-5 frente a Plaza Bolívar. Maracaibo, Edo. Zulia', '(0261)7251090 / (0261)7921111 / (0261)7921150 / Fax: (0261)7251087 / (0261)7922622', 'http://www.gobernaciondelzulia.gov.ve', '', '6', '24')");
		
		db.execSQL("CREATE TABLE " + PROCEDURES + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, requeriments TEXT, schedule TEXT, cost STRING, info TEXT, organism STRING)");
		
		db.execSQL(INSERT + PROCEDURES + " VALUES (null, 'Conformación de Comunas', '1. Notificar a los ciudadanos la constitución de la Comisión Promotora que conformará la comuna.\n2. Elegir la Asamblea Constitutiva.\n3. Consejo electoral Provisional.\n4. Conformar la Comisión Redactora.\n5. Realizar un referendo aprobatorio', 'No aplica', 'No aplica', 'Debe tener en cuenta las siguientes definiciones:\n\nBanco de las Comunas:\nOrganización económico-financiera de carácter social que gestiona y administra los recursos financieros, impulsando políticas económicas con la participación democrática y protagónica del pueblo.\n\nCartas Comunales:\nInstrumento donde se establecen las normas elaboradas por los habitantes de la comuna en Parlamento Comunal con el propósito de regular la vida social y comunitaria de conformidad con la Constitución Bolivariana de Venezuela.\n\nCarta Fundacional:\nInstrumento aprobado en referendo popular, donde las comunidades expresan su voluntad de constituirse en comuna.\n\nEstado Comunal:\nForma de organización político-social, fundada en el estado social de derecho y justicia establecido en la constitución, en la cual se le otorga poder al pueblo, con un modelo de propiedad social y de desarrollo endógeno sustentable.\n\nParlamento Comunal:\nMáxima instancia del autogobierno en la comuna, constituido por asambleas de ciudadanos, establecidos en cada uno de sus respectivos ámbitos territoriales', 'Ministerio del Poder Popular para las Comunas y Protección Social')");
		db.execSQL(INSERT + PROCEDURES + " VALUES (null, 'Legalización de Títulos Universitarios', '1. Título Original debidamente firmado y sellado por el Registro Público correspondiente (Ver Registro de Títulos Universitarios).\n2. Original del Acta de grado o Notas Certificadas.\n3. Copia de la Cédula de Identidad del titular (Si el titular no es quien entrega la documentación, deberá traer autorización por escrito y copia de CI de ambas partes)', 'Lapso de un día hábil para retirar', 'Cancelar, en timbres fiscales, Bs. 27,50 en la taquilla autorizada ubicada en dicho Ministerio, o en los siguientes bancos:\n\nBanco de Venezuela, Cuenta Corriente, N° 0102-0552-21-0000024439, a nombre de GOB. DTTO. CAPITAL ING. TIMBRES FISCALES.\n\nBanco del Tesoro, Cuenta Corriente, N° 0163-0903-62-9032000282, a nombre del GOBIERNO DEL DISTRITO CAPITAL.\n\nSi el titular posee varios documentos, puede depositar el total de los mismos en un solo depósito', 'NOTA: LOS TÍTULOS DE LAS UNIVERSIDADES PRIVADAS NO NECESITAN REALIZAR ESTE TRÁMITE YA QUE TIENEN LA FIRMA DEL MINISTRO', 'Ministerio del Poder Popular para la Educación Universitaria')");
		db.execSQL(INSERT + PROCEDURES + " VALUES (null, 'Licencia de Turismo', '1. Formulario de Solicitud de Trámite de Licencia de Turismo Persona Jurídica, establecido por el Ministerio del Poder Popular con competencia en Turismo, en original y dos (2) fotocopias legibles.\n2. Fotocopia legible del Oficio del Registro Turístico Nacional (RTN).\n3. Fotocopia legible de la Patente de Industria y Comercio, esto aplica en caso de haber consignado la solicitud al momento de la inscripción en el Registro Turístico Nacional.\n4. Fotocopia legible de la Póliza de Responsabilidad Civil contra daños a terceros vigente, a nombre del prestador de servicios turísticos, anexando las condiciones generales y particulares del contrato de la póliza vigente.\n5. Si el establecimiento se encuentra ubicado en un Área Bajo Régimen de Administración Especial (ABRAE), fotocopia legible del permiso o contrato de concesión correspondiente, emitida por la autoridad competente.\n6. Si el capital de la persona jurídica tiene inversión extranjera, fotocopia legible de la Constancia de Calificación de Empresas, emitidas por la Superintendencia de Inversiones Extranjeras (SIEX).\n7. Y cualquier otro documento que el Ministerio del Poder Popular con competencia en Turismo, considere necesario.\n8. Los Prestadores de Servicios Turísticos, además de los Requisitos Generales exigidos, deberán consignar los requisitos específicos para cada Tipo de Prestador (Empresas de Alojamiento Turístico, Administradoras de Empresas Turísticas, Agencias de Turismo, Transporte Turístico, Transporte Turístico Terrestre, Transporte Turístico Acuático, Transporte Turístico Aéreo, Representantes de Turismo, Representante de Transporte Turístico Terrestre, Representante de Transporte Turístico Acuático (Nacional o Internacional), Representante de Transporte Turístico Aéreo, Establecimientos Turísticos de Alimentos y Bebidas, Empresas de Recreación Turística, Empresas de Información, Promoción Publicidad y Propaganda Turística). Los requisitos específicos y formularios pueden descargarse en el vínculo del Ministerio de Turismo.\n9. La documentación se presenta en original y fotocopia. Las Fotocopias deben estar completas, visibles y legibles. Una vez confrontado y verificado el original contra la fotocopia, se devuelve el original', 'Lunes a viernes en horario de 8:30am a 12:00pm y de 1:00pm a 4:30pm', 'Gratuito', 'En Caracas puede acudir a la sede del Ministerio de Turismo en la Avenida Francisco de Miranda, Av. principal de La Floresta, frente al Colegio Universitario de Caracas. En el interior del país debe llamar antes al 0500 TURISMO (05008874766) para que le indiquen la sede a la cual debe presentar los requisitos del trámite', 'Ministerio del Poder Popular para el Turismo')");
		db.execSQL(INSERT + PROCEDURES + " VALUES (null, 'Mi casa bien equipada', '1. Fotocopia de la cédula de identidad.\n2. Constancia de trabajo con emisión no mayor a tres meses.\n3. Tres referencias personales con dirección, números telefónicos y copia de la cédula del emisor.\n4. Copia de un recibo de servicio (agua, electricidad, teléfono)', 'Lunes a viernes en horario de 9:00am a 5:00pm', 'Los productos de línea blanca son de la empresa china Haier Electric Appliances. Existen varios modelos. Los precios varían desde cocinas por Bs. 600 hasta neveras de 12 pies cúbicos por Bs. 1600. Se recomienda asistir al Mercal Hogar o Abasto Bicentenario de su preferencia, consultar los modelos en existencia y sus precios para iniciar el trámite', 'Para mayor información debe dirigirse, en horario de oficina, a las oficinas de atención al usuario de los establecimientos: Mercal Hogar y Bicentenario', 'Corporación de Mercados Socialistas (COMERSO) ente adscrito al Ministerio del Poder Popular para el Comercio')");
		db.execSQL(INSERT + PROCEDURES + " VALUES (null, 'Registro de Títulos Universitarios', '1. Título original.\n2. Si el título tiene enmiendas (notas certificadas).\n3. Cédula de identidad laminada de la persona que realiza el trámite.\n4. Firmas de los profesores en el título', 'Lunes a viernes en horario de 8:00am a 1:00pm', 'Ordinario (3 días hábiles): Bs. 285,16', 'Para registrar su título universitario deberá dirigirse a las Oficinas del Registro Principal, consignar su Título debidamente firmado y sellado (Hacer firmar el título por dos profesores de la Facultad, tomar nota del nombre completo de cada uno y su No. de Cédula de Identidad), posteriormente será verificado por un registrador quien le suministrará la planilla de depósito bancario. Usted consignará: planilla con su depósito bancario ya realizado y timbres fiscales por el monto de (trece) Bs. 13,00', 'Registro Principal de Caracas')");
		
		db.execSQL("CREATE TABLE " + MAYORALTIES + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, mayor STRING, office STRING, address TEXT, phone STRING, web STRING, twitter STRING, state INTEGER NOT NULL, municipality INTEGER NOT NULL, FOREIGN KEY(state) REFERENCES states(" + _ID + "), FOREIGN KEY(municipality) REFERENCES municipalities(" + _ID + "))");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Baruta', 'Gerardo Blyde', 'Alcalde de Baruta', 'Edif. Sede, entre Av. Principal de Colinas de Bello Monte y Av. Beethoven, Caracas', '(0212)7017455 / (0212)7017456 / (0212)7017431', 'http://www.alcaldiadebaruta.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chacao', 'Emilio Graterón', 'Alcalde de Chacao', 'Final Av. Venezuela, cruce con calle Sorocaima, Edif. Atrium. Piso 6, El Rosal, Edo. Miranda', '(0212)9057077 / (0212)9057057 / (0212)9057007 / Fax: (0212)9533560', 'http://www.chacao.gov.ve', '', '1', '2')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía Mayor', 'Antonio Ledezma', 'Alcalde Mayor', 'Esq. Principal. Frente a la Plaza Bolívar, Edif. Palacio de Gobierno, El Silencio, Caracas - Distrito Capital', '(0212)8603460 / (0212)8606540', 'http://www.alcaldiamayor.gob.ve', '', '1', '3')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Hatillo', 'Myriam Do Nascimento', 'Alcaldesa de El Hatillo', 'Calle Bolívar con calle Escalona, frente a la Plaza Bolívar, El Hatillo, Edo. Miranda', '(0212)9634848 / (0212)9634175 / (0212)9637414', 'http://www.alcaldiaelhatillo.gob.ve', '', '1', '4')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Caracas', 'Jorge Rodríguez', 'Alcalde de Caracas', 'Palacio Municipal, Esquina Las Monjas, Frente a la Plaza Bolívar, Caracas - Distrito Capital', '(0212)5454513 / (0212)5421711 / (0212)4098632', 'http://www.caracas.gob.ve/', '', '1', '5')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sucre', 'Carlos Ocaríz', 'Alcalde de Sucre', 'Plaza Sucre, Zona Colonial de Petare, Edo. Miranda', '(0212)2376343 / (0212)2710253 / (0212)2723360', 'http://www.alcaldiamunicipiosucre.gov.ve', '', '1', '6')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía del Alto Orinoco', 'Mara Chamanare', 'Alcalde del Alto Orinoco', 'La Esmeralda, Municipio Alto Orinoco, Edo. Amazonas', '(0248)5214520', 'No disponible.', '', '2', '7')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Atabapo', 'Nelson Cayupare', 'Alcalde de Atabapo', 'San Fernando de Atabapo 7101, Municipio Atabapo. Edo. Amazonas', '(0248)5411001 / (0248)5213775', 'No disponible.', '', '2', '8')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Atures', 'Mireya Labrador', 'Alcaldesa de Atures', 'Calle Bolívar con Evelio Roa, Edif. Hipolito Cuevas, sede del Poder Público Municipal', '(0248)5214042', 'No disponible.', '', '2', '9')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Autana', 'Bernabé Arana', 'Alcalde de Autana', 'Calle Primero de mayo, diagonal con la calle Francisco de Miranda frente a la Plaza Bolívar', '(0248)5214520 / (0248)5211993', 'No disponible.', '', '2', '10')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guainía', 'Thaimir Briceño', 'Alcalde de Guainía', 'Avenida Bolívar, frente a la Plaza Bolívar, Municipio Guanía', '(0248)2125032 / Fax: (0248)5211542', 'No disponible.', '', '2', '11')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Manapiare', 'Pastor Rodríguez', 'Alcalde de Manapiare', 'San Juan de Manapiare. Calle principal Padre Jesús González. Municipio Manapiare', '(0248)5211742 / (0248)5213783', 'No disponible.', '', '2', '12')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Río Negro', 'Richard Camico', 'Alcalde de Río Negro', 'San Carlos de Río Negro, Av. Amazonas con Av. Aguerrevere. Qta. Valper. Edo. Amazonas', '(0248)5213857 / (0414)4867973', 'No disponible.', '', '2', '13')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Anaco', 'Francisco Solorzano', 'Alcalde de Anaco', 'Avenida Zulia, Edificio Municipal. Anaco, Edo. Anzoátegui', '(0282)4145111 / (0282)4145112 / Fax: (0282)4240252', 'No disponible.', '', '3', '14')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Aragua de Barcelona', 'Juan Figueredo', 'Alcalde de Aragua de Barcelona', 'Calle Sucre, Edif. Municipal Aragua de Barcelona, Edo. Anzoátegui', '(0282)8281282 / (0282)8281281', 'No disponible.', '', '3', '15')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barcelona', 'Inés Sifontes', 'Alcaldesa de Barcelona', 'Paseo 27 de Abril, Entre calle Bolívar y Juncal, Frente a la Catedral Barcelona, Edif. Alcaldía de Bolívar, Boyacá, Barcelona. Edo. Anzoátegui', '(0281)2772409 / (0281)2772498 / Fax: (0281)2743958', 'No disponible.', '', '3', '16')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Clarines', 'Leobardo Canache', 'Alcalde de Clarines', 'Calle Tornás Fernández, Edif. Municipal, Clarines, Edo. Anzoátegui', '(0282)4552719 / (0282)4552925 / (0282)4552967 / Fax: (0282)4552745', 'No disponible.', '', '3', '17')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Onoto', 'Antonio Goffin', 'Alcalde de Onoto', 'Calle El Comercio N° 50, Edif. Municipal Onoto, Anzoátegui', '(0281)4189072', 'No disponible.', '', '3', '18')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guanape', 'Franklyn Guillén', 'Alcalde de Guanape', 'Calle Sucre con calle Bolívar frente a la Plaza Bolívar, Valle de Guanape, Edo. Anzoátegui', '(0416)4822429', 'No disponible.', '', '3', '19')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cantaura', 'Evelin Urdaneta', 'Alcaldesa de Cantaura', 'Calle Freites frente a la Plaza Bolívar, Edificio Municipal, Cantaura, Edo. Anzoátegui', '(0282)4552719 / (0282)4552925 / (0282)4552967 / Fax: (0282)4552745', 'No disponible.', '', '3', '20')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guanta', 'Jhonnathan Peñalver', 'Alcalde de Guanta', 'Avenida Arizaleta frente a la Plaza Bolívar, Guanta, Edo. Anzoátegui', '(0281)6832154 / Fax: (0281)2683230', 'No disponible.', '', '3', '21')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Mateo', 'Edgar Maestre', 'Alcalde de San Mateo', 'Calle El Cementerio, Edif. Municipal, San Mateo, Edo. Anzoátegui', '(0414)8172380', 'No disponible.', '', '3', '22')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Lechería', 'Victor H. Figueredo', 'Alcalde de Lechería', 'Avenida Principal de Lechería, Centro Comercial Forum Plaza, Oficina 1. Puerto La Cruz, Edo. Anzoátegui', '(0281)4187004 / (0281)4187006 / Fax: (0281)4187003', 'No disponible.', '', '3', '23')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Chaparro', 'Mara De Salazar', 'Alcalde de El Chaparro', 'Calle Peñalver, El Chaparro, Edo. Anzoátegui', '(0283)8886354', 'No disponible.', '', '3', '24')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mapire', 'Cruz Ojeda', 'Alcalde de Mapire', 'Calle Sucre, frente a la Plaza Bolívar. Mapire, Edo. Anzoátegui', '(0283)2358816 / Fax: (0283)2314953', 'No disponible.', '', '3', '25')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Puerto Píritu', 'Axel Rodríguez', 'Alcalde de Puerto Píritu', 'Av. Fernando Peñalver, Palacio Municipal, Pto. Píritu, Edo. Anzoátegui', '(0414)8256030', 'No disponible.', '', '3', '26')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San José de Guanipa', 'Pedro Martínez', 'Alcalde de San José de Guanipa', 'Av. Fernández Padilla, Palacio Municipal. San José de Guanipa. Edo. Anzoátegui', '(0283)2550291 / (0283)2551451 / Fax: (0283)2550291', 'No disponible.', '', '3', '27')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de boca de Uchire', 'Asdrubal Méndez', 'Alcalde de boca de Uchire', 'Av. Autopista al lado del Comando Policial, Boca de Uchire, Edo. Anzoátegui', '(0414)931035', 'No disponible.', '', '3', '28')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa', 'Gerson Martínez', 'Alcalde de Santa', 'Carretera Negra, Barrio Los Algarrobos, Concejo Municipal, Santa Ana. Edo. Anzoátegui', '(0285)710260 / (0285)710312', 'No disponible.', '', '3', '29')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Tigre', 'Carlos Hernández', 'Alcalde de El Tigre', 'Avenida Francisco de Miranda, entre el Callejón Soublette y 2da calle Norte - Edificio Sede, El Tigre, Municipio Autónomo Simón Rodríguez , Edo. Anzoátegui', '(0414)1902157 / (0412)8634190 / Fax: (0283)2310415', 'No disponible.', '', '3', '30')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Puerto La Cruz', 'Stalin Fuentes', 'Alcalde de Puerto La Cruz', 'Av. Principal, Edif. Municipio Pto. La Cruz, Edo. Anzoátegui', '(0414)8238543', 'No disponible.', '', '3', '31')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Achaguas', 'Clariza Jiménez De Garbi', 'Alcaldesa de Achaguas', 'Av. Bolívar, frente a la Plaza Bolívar Achaguas, Edo. Apure', '(0414)4869897 / (0414)4751138', 'No disponible.', '', '4', '32')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía del Alto Apure', 'Jorge Rodríguez', 'Alcalde del Alto Apure', 'Avenida Las Carpas, antiguo Hotel Arleyón, Guasdualito - Guasdualito, Edo. Apure', '(0278)4146578 / (0278)4145291', 'No disponible.', '', '4', '33')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Biruaca', 'Daniel Blanco', 'Alcalde de Biruaca', 'Calle Carlos Agrinzonez, 3ra. Transversal, Sede Alcaldía Biruaca, Edo. Apure', '(0247)3645019 / (0247)3645241', 'No disponible.', '', '4', '34')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Muñoz', 'Jesús Bona', 'Alcalde de Muñoz', 'Av. Negro Primero frente a la Escuela Bolivariana José Antonio Páez. Mantecal, Municipio Muñoz, Edo. Apure', '(0240)9961150 / (0240)9940259', 'No disponible.', '', '4', '35')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Páez', 'José Alvarado', 'Alcalde de Páez', 'Cruce Av. Miranda con Av. Marquez del Pumar Frente al Edif. de PDVSA Guasdualito, Edo. Apure', '(0278)4145285', 'No disponible.', '', '4', '36')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pedro Camejo', 'Pedro Leal', 'Alcalde de Pedro Camejo', 'Calle Bolívar cruce con calle Rómulo Gallegos Diagonal a la Plaza Bolívar Quinta Municipal, San Juan de Payara. Edo. Apure', '(0247)5147692 / (0247)5590045 / (0416)6763512', 'No disponible.', '', '4', '37')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Rómulo Gallegos', 'Leopoldo Estrada', 'Alcalde de Rómulo Gallegos', 'Calle Pollito de Orichuna Frente a la Plaza Bolívar Elorza, Municipio Rómulo Gallegos, Edo. Apure', '(0240)9291191 / Fax: (0240)9291191', 'No disponible.', '', '4', '38')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Fernando', 'Jhon Guerra', 'Alcalde de San Fernando', 'Av. Miranda cruce calle Nanaipolita y Municipal Edif. Alcaldía San Fernando. Edo. Apure', '(0247)3412398', 'No disponible.', '', '4', '39')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Antonio José de Sucre', 'Luis Zambrano', 'Alcalde de Antonio José de Sucre', 'Calle Froilan Correa, entre Bolívar y Miranda, frente a la Plaza Sucre, Cagua, Edo. Aragua', '(0244)4004733 / (0244)4004734', 'No disponible. Correo: alcaldiasucrearagua@hotmail.com', '', '5', '40')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Atanasio Girardot', 'Pedro Bastidas', 'Alcalde de Atanasio Girardot', 'Av. Principal las Delicias. Palacio Municipal frente al C.C. Paseo las Delicias 2', '(0243)2335434 / (0243)2379410', 'http://www.alcaldiagirardot.gob.ve', '', '5', '41')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Bolívar', 'Freddy Arenas', 'Alcalde de Bolívar', 'Calle Ricaute frente a la Plaza Bolívar, Junta Comunal San Mateo, Edo. Aragua', '(0244)3520036 / (0416)5437663', 'No disponible.', '', '5', '42')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Camatagua', 'Rafael González', 'Alcalde de Camatagua', 'Calle Comercio con calle Bolívar, Edo. Aragua', '(0246)5291958', 'No disponible. Correo: alcamatagua@hotmail.com', '', '5', '43')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ezequiel Zamora', 'Aldo Lovera', 'Alcalde de Ezequiel Zamora', 'Calle Dr. Rangel, Centro Consejo Municipal frente Plaza Miranda, Villa de Cura, Edo. Aragua', '(0244)5116628', 'http://www.alcaldiadezamora-aragua.gob.ve', '', '5', '44')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Francisco Linares Alcántara', 'Raiza Márquez', 'Alcaldesa de Francisco Linares Alcántara', 'Avda. Generalísimo Francisco de Miranda, final Sur, N° 246-B, Sector 18 de Mayo, Santa Rita, Edo. Aragua', '(0243)2714552 / (0243)2715080', 'No disponible. Correo: alcaldiafla@hotmail.com', '', '5', '45')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de José Ángel Lamas', 'Ybis Pérez', 'Alcaldesa de José Ángel Lamas', 'Calle Hernández Nadal, cruce con calle Sucre, Palacio Municipal, frente a la Plaza Bolivar, Santa Cruz de Aragua, Edo. Aragua', '(0243)2618261 / (0243)2611038 / (0243)2616460', 'No disponible.', '', '5', '46')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de José Féliz Ribas', 'Juan Carlos Sánchez', 'Alcalde de José Féliz Ribas', 'Calle Campo Elías, Av. Francisco de Loreto, Palacio Municipal de Gobierno Vicente Campo Elías, La Victoria, Edo. Aragua', '(0244)4174118 / (0244)4174455 / (0244)4174415 / (0244)4174474', 'No disponible. Correos: secretaria_despacho@hotmail.es / fregus1@hotmail.com', '', '5', '47')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de José Rafael Revenga', 'Francisco Martínez', 'Alcalde de José Rafael Revenga', 'Av. Principal Las Rosas, N° 73 Urbanización Bosque Lindo, frente a la Cooperativa Basconcelo', '(0412)4222847 / (0412)4624009', 'No disponible.', '', '5', '48')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Libertador', 'Carmen Plaza', 'Alcaldesa de Libertador', 'Calle Gran Democrata con Rivas Dávila Nº 7. Sector Centro-Parroquia, Palo Negro. Edo. Aragua', '(0243)2671959 / (0243)2672017', 'No disponible. Correos: alcaldiabolivarianalibertador@gmail.com / alcaldiabolivarianalibertador@hotmail.com', '', '5', '49')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mario Briceño Iragorry', 'Belquis Portes', 'Alcaldesa de Mario Briceño Iragorry', 'Calle Leonardo Ruiz Pineda, N° 30-1, Concejo Municipal, Urb. Las Mayas, El Limón, Maracay, Edo. Aragua', '(0243)2173997', 'No disponible.', '', '5', '50')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ocumare de la Costa de Oro', 'Saida García', 'Alcaldesa de Ocumare de la Costa de Oro', 'Calle Comercio N° 19', '(0243)9931787', 'No disponible. Correos: saidagarcia39@hotmail.com / salazarguerra@hotmail.com', '', '5', '51')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Rafael Guillermo Urdaneta', 'Antonio Lugo', 'Alcalde de Rafael Guillermo Urdaneta', 'Calle Trinidad frente a la Plaza Bolívar de Barbacoas', '(0426)6267021', 'No disponible. Correo: alugo.urdaneta@gmail.com', '', '5', '52')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Casimiro', 'Iris Guzmán', 'Alcaldesa de San Casimiro', 'Calle Miranda, Casa N° 4, Sector Centro, San Casimiro, Edo. Aragua', '(0246)5271932', 'No disponible. Correos: alcaldiasancasimiro@hotmail.com', '', '5', '53')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Sebastián de los Reyes', 'Pablo Carruido', 'Alcalde de San Sebastián de los Reyes', 'Centro Cívico entre calle Bolívar y Tovar Ponte S/N, San Sebastián de los Reyes, Edo. Aragua', '(0246)5210066', 'No disponible. Correos: alcaldiasansebastian.despacho@gmail.com', '', '5', '54')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santiago Mariño', 'Tibisay Guevara', 'Alcaldesa de Santiago Mariño', 'Av. Principal de Valle Lindo, cruce con calle Urdaneta, Sector Valle Lindo, Edif. Sede Alcaldía de Mariño, Turmero, Edo. Aragua', '(0244)6631800', 'No disponible. Correo: asmdirinformatica@gmail.com', '', '5', '55')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santos Michelena', 'José Gregorio Díaz', 'Alcalde de Santos Michelena', 'Calle 19 de Abril, número 1, Casco Central Las Tejerías, Edo. Aragua', '(0244)5116224', 'No disponible. Correo: prensaalcaldiasantosmichelena@gmail.com', '', '5', '56')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tovar', 'Alfredo Durr', 'Alcalde de Tovar', 'Sector El Calvario, Vía principal Colonia Tovar. La Victoria, frente al Hotel Edelweiss', '(0424)3559771 / (0414)4928072', 'No disponible. Correo: psuvtovar@hotmail.com', '', '5', '57')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sabaneta', 'Anibal Chávez', 'Alcalde de Sabaneta', 'Calle 8, Entre Av. Antonio María Bayón y Obispo, Edif. Municipal, Sabaneta, Edo. Barinas', '(0273)7755780 / (0273)7755131', 'No disponible.', '', '6', '58')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Cantón', 'Arismedi Berbesi', 'Alcalde de El Cantón', 'Calle 1 con carrera 3, frente a la Plaza Bolívar. Parroquia el Cantón, Municipio Andrés Eloy Blanco', '(0278)2625144 / (0278)2625211', 'No disponible.', '', '6', '59')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Socopó', 'Salvador Guerrero', 'Alcalde de Socopó', 'Concejo Municipal Antonio José de Sucre, Socopó, Edo. Barinas', '(0414)3443301', 'No disponible.', '', '6', '60')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Arismendi', 'José Zapata', 'Alcalde de Arismendi', 'Av. Bolívar, Concejo Municipal de Arismendi, Frente a la Plaza Bolívar, Edo. Barinas', '(0414)5681027 / (0414)5719907', 'No disponible.', '', '6', '61')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barinas', 'Abundio Sánchez', 'Alcalde de Barinas', 'Edif. Municipal, Av. Páez entre calles 5 de Julio y Plaza (Frente a la Plaza Razetti)', '(0273)5321466 / (0273)5520953 / Fax: (0273)5528753', 'http://alcaldiabarinas.gob.ve', '', '6', '62')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barinitas', 'Ana Lucía Escalona', 'Alcalde de Barinitas', 'Calle 6, Casa Municipal, Frente a la Plaza Bolívar, Barinitas, Edo. Barinas', '(0273)8711707', 'No disponible.', '', '6', '63')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barrancas', 'Guadalupe Fernández', 'Alcaldesa de Barrancas', 'Avenida Sucre con calle Andrés Eloy Blanco, Edif. Alcaldía de Cruz Paredes, frente a la Plaza Bolívar', '(0273)7711387 / Fax: (0273)7711387', 'No disponible.', '', '6', '64')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Obispos', 'Alexis Avendaño', 'Alcalde de Obispos', 'Carrera Bolívar, Edif. Municipal', '(0273)4142895 / (0273)4154266', 'No disponible.', '', '6', '65')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ciudad Bolivia', 'Yusein Silva', 'Alcalde de Ciudad Bolivia', 'Av. 5 Palacio Municipal frente a la Plaza Bolívar', '(0273)4153052 / (0273)4153054 / Fax: (0273)4153053', 'No disponible.', '', '6', '66')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Libertad', 'Joel Meneses', 'Alcalde de La Libertad', 'Calle Concordia con Guzmán Blanco, Edif. Municipal Libertad. Edo. Barinas', '(0273)6630450 / Fax: (0273)6630450', 'No disponible.', '', '6', '67')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ciudad de Nutrias', 'Wilfredo Guevara', 'Alcalde de Ciudad de Nutrias', 'Calle Julián Pino entre avenida Cruz Paredes y Rodríguez Domínguez, frente a la Plaza Bolívar', '(0273)4146185 / (0273)4154595 / Fax: (0273)4146185', 'No disponible.', '', '6', '68')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Bárbara', 'Francisco Hurtado', 'Alcalde de Santa Bárbara', 'Carretera 5 con Esquina calle 11, frente a la plaza Bolívar, Edif. Concejo Municipal Santa Bárbara, Edo. Barinas', '(0273)5521444', 'No disponible.', '', '6', '69')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Félix', 'José Ramón López', 'Alcalde de San Félix', 'Calle Bolívar Diagonal Plaza Bolívar. Palacio Municipal. San Félix, Edo. Bolívar', '(0286)9711223 / (0286)9711655 / Fax: (0286)9711223', 'No disponible.', '', '7', '70')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Caicara del Orinoco', 'Milthon Tovar', 'Alcalde de Caicara del Orinoco', 'Prolongación Paseo Orinoco con calle Av. Carabobo, Edif. Alma-Cedeño. Caicara del Orinoco, Edo. Bolívar', '(0284)6667728 / Fax: (0284)6667728', 'No disponible.', '', '7', '71')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Callao', 'Orlenia Scipio', 'Alcaldesa de El Callao', 'Boulevard Carlos Manuel Piar con calle Ricaurte, Palacio Municipal, El Callao. Edo. Bolívar', '(0288)7620806 / (0288)7620808 / Fax: (0288)7620280', 'No disponible.', '', '7', '72')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Elena de Uairén', 'Manuel de Jesús Valles', 'Alcalde de Santa Elena de Uairén', 'Calle Ikabarú, Casco Central. Santa Elena de Uairén, Edo. Bolívar', '(0289)4160831 / (0289)9951148 / Fax: (0289)9951148', 'No disponible.', '', '7', '73')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ciudad Bolívar', 'Victor Fuenmayor', 'Alcalde de Ciudad Bolívar', 'Calle Igualdad con calle Libertad, Casa Histórica, Ciudad Bolívar, Edo. Bolívar', '(0285)6324690 / Fax: (0285)6324690', 'No disponible.', '', '7', '74')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Palmar', 'Aquilino Márquez', 'Alcalde de El Palmar', 'Calle Dalla Costa de El Palmar, Plaza Bolívar, El Palmar. Edo. Bolívar', '(0288)8811157 / Fax: (0288)8811157', 'No disponible.', '', '7', '75')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Upata', 'Gustavo Muñoz', 'Alcalde de Upata', 'Calle Urdaneta, edificio Centro Cívico frente a la Plaza Bolívar. Upata, Edo. Bolívar', '(0288)2216587 / (0288)2210514 / Fax: (0288)2216211', 'No disponible.', '', '7', '76')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ciudad Piar', 'Yusleibi Ramírez', 'Alcaldesa de Ciudad Piar', 'Calle Principal, Módulo de Servicio, Frente a la Plaza Bolívar, Maripas, Edo. Bolívar', 'No disponible.', 'No disponible.', '', '7', '77')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guasipati', 'José Martínez', 'Alcalde de Guasipati', 'Calle Bolívar al lado de la prefectura, sede del Palacio Municipal. Guasipati. Edo. Bolívar', '+(0288)7671973 / Fax: (0288)7671708', 'No disponible.', '', '7', '78')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tumeremo', 'Carlos Chancellor', 'Alcalde de Tumeremo', 'Calle Roscio, A una cuadra de la Plaza Bolívar, Casa Municipal, Tumeremo, Edo. Bolívar', '(0414)3035107', 'No disponible.', '', '7', '79')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Maripas', 'Amelia Falcón', 'Alcaldesa de Maripas', 'Calle Bolívar frente Plaza Sucre. Maripa, Edo. Bolívar', '(0285)8081504 / (0285)8081505 / Fax: (0285)8081504', 'No disponible.', '', '7', '80')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Bejuma', 'Lorenzo Remedios', 'Alcalde de Bejuma', 'Av. Sucre, Edif. Municipal frente a la Plaza Bolívar. Bejuma, Edo. Carabobo', '(0249)7934583 / (0249)7934370', 'No disponible.', '', '8', '81')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Güigüe', 'Marisol Castillo', 'Alcaldesa de Güigüe', 'Palacio Municipal Carlos Arvelo, Av. Miranda entre calles Ávila y Arvelo. Güigüe, Edo. Carabobo', '(0241)6189724 / (0414)4322994 / Fax: (0241)6189724', 'No disponible.', '', '8', '82')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mariara', 'Roger Martínez', 'Alcalde de Mariara', 'Av. Bolívar, N° 31, Diego Ibarra, Mariara, Edo. Carabobo', '(0414)5907956 / Fax: (0243)2631135', 'No disponible.', '', '8', '83')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guacara', 'Gerardo Sánchez', 'Alcalde de Guacara', 'Calle Sucre con calle Arévalo González, Casa Municipal, Guacara', '(0414)1420639 / (0245)5717066 / Fax: (0245)5645456', 'No disponible.', '', '8', '84')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Morón', 'José Gregorio Frías', 'Alcalde de Morón', 'Av. La Paz, Casa Municipal, Morón. Edo. Carabobo', '(0242)3720337', 'No disponible.', '', '8', '85')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tocuyito', 'Carmen Álvares', 'Alcaldesa de Tocuyito', 'Calle Sucre, diagonal a la Plaza Bolívar de Tocuyito. Tocuyito, Edo. Carabobo', '(0241)8941631 / (0241)8942016 / Fax: (0241)8941831', 'No disponible.', '', '8', '86')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Los Guayos', 'Aníbal Dose', 'Alcalde de Los Guayos', 'Carretera Nacional Los Guayos - Valencia, Edif. Mencey. Los Guayos, Edo. Carabobo', '(0241)8384142 / (0241)8389790 / Fax: (0241)8389790', 'No disponible.', '', '8', '87')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Miranda', 'Ángel Arráez', 'Alcalde de Miranda', 'Calle Sucre, entre Córdoba y Plaza, Edif. Municipal, Miranda, Edo. Carabobo', '(0249)7881113', 'No disponible.', '', '8', '88')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Montalbán', 'Luis Sánchez', 'Alcalde de Montalbán', 'Av. Pérez Carreño, Edif. Municipal frente a la Plaza Bolívar, Montalbán. Edo. Carabobo', '(0249)7985681', 'No disponible.', '', '8', '89')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Naguanagua', 'Alejandro Feo', 'Alcalde de Naguanagua', 'Concejo Municipal, diagonal a la Iglesia La Begoña, Naguanagua', '(0241)6170390 / (0241)6170391 / (0241)6170392 / Fax: (0241)6170394', 'No disponible.', '', '8', '90')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Puerto Cabello', 'Rafael Lacava', 'Alcalde de Puerto Cabello', 'Final Calle Bolívar con Calle Ricaurte, Puerto Cabello', '(0242)4151386 / (0242)4151116 / Fax: (0242)3646046', 'No disponible.', '', '8', '91')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Diego', 'Scarano Vicencio', 'Alcalde de San Diego', 'Vía Los Arales, al lado del Hotel La Pirámide. San Diego, Edo. Carabobo', '(0241)7000837 / (0241)7000760', 'No disponible.', '', '8', '92')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Joaquín', 'Luis Aguiar', 'Alcalde de San Joaquín', 'Calle Vargas con Calle Sucre, Casa Municipal, San Joaquín', '(0245)4154271 / Fax: (0245)4154272', 'No disponible.', '', '8', '93')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Valencia', 'Edgardo Parra', 'Alcalde de Valencia', 'Av. Henry Ford, al lado del C.C. Paseo Las Industrias, Valencia', '(0241)8395503 / (0241)8395447 / (0241)8395580', 'No disponible.', '', '8', '94')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tinaquillo', 'Carlos Añes', 'Alcalde de Tinaquillo', 'Calle El Socorro entre la Av. Principal y la Bolívar, frente a la Plaza Bolívar, Tinaquillo', '(0258)7661211 / Fax: (0258)7661211', 'No disponible.', '', '9', '95')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Macapo', 'Zaddi Pérez', 'Alcaldesa de Macapo', 'Calle Lima Blanco, Centro Comercial Negro Primero. Macapo, Edo. Cojedes', '(0258)4147830 / Fax: (0258)7660800', 'No disponible.', '', '9', '96')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ricaurte', 'Hilcriy Martínez', 'Alcalde de Ricaurte', 'Edificio Municipal, Av. Bolívar entre calles: Tomás Araujo y Juan José Calles, frente a la Plaza Bolívar. Libertad, Edo. Cojedes', '(0414)9586782', 'No disponible.', '', '9', '97')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Rómulo Gallegos', 'Jesús Oviedo', 'Alcalde de Rómulo Gallegos', 'Calle Leonardo Ruíz Pineda entre Av. Bolívar y Manuel Manrique. Las Vegas, Edo. Cojedes', '(0258)2510230 / Fax: (0258)2510230', 'No disponible.', '', '9', '98')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Carlos', 'Ramón Moncada', 'Alcalde de San Carlos', 'Calle Manrique cruce con calle Páez, diagonal a la Plaza Bolívar, Edif. Palacio Municipal, San Carlos, Edo. Cojedes', '(0258)5811019', 'No disponible.', '', '9', '99')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tinaco', 'Francisco Ojeda', 'Alcalde de Tinaco', 'Calle Flores entre Urdaneta y Silva, frente a la Plaza Bolívar. Tinaco, Edo. Cojedes', '(0258)7271220 / Fax: (0258)7271220', 'No disponible.', '', '9', '100')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Curiapo', 'Digna Sucre', 'Alcaldesa de Curiapo', 'Concejo Municipal Curiapo. Edo. Delta Amacuro', '(0287)7211133', 'No disponible.', '', '10', '101')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Casacoima', 'José Santaella', 'Alcalde de Casacoima', 'Concejo Municipal en la Sierra de Imataca. Edo. Delta Amacuro', '(0286)9323484', 'No disponible.', '', '10', '102')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pedernales', 'Doris Martínez', 'Alcaldesa de Pedernales', 'Calle Marina Al Lado del Safec Edf. Alcaldía. Edo. Delta Amacuro', '(0416)8972001 / (0416)7915920', 'No disponible.', '', '10', '103')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tucupita', 'Alexis Gonzáles', 'Alcalde de Tucupita', 'Calle Amacuro, S/N a 50 metros de la Policía del Estado, Tucupita', '(0414)8781941 / Fax: (0414)8781941', 'No disponible.', '', '10', '104')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Juan de Los Cayos', 'Henrry Estrada', 'Alcalde de San Juan de Los Cayos', 'Av. Bolívar, Edif. Municipal, San Juan de Los Cayos, Edo. Falcón', '(0242)9325244', 'No disponible.', '', '11', '105')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Luis', 'Evarista Jiménez', 'Alcaldesa de San Luis', 'Calle Principal, Edif. Municipal, al lado de la Guardia Nacional, San Luis', '(0268)6663086', 'No disponible.', '', '11', '106')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Capatárida', 'Tony Tigrera', 'Alcalde de Capatárida', 'Calle Zamora, frente a la Casa Parroquial, Edif. Alcaldía, Capatárida', '(0279)8231053 / Fax: (0279)8231086', 'No disponible.', '', '11', '107')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Yaracal', 'Dimaris de Henríquez', 'Alcaldesa de Yaracal', 'Consejo Municipal Mirimire. Yaracal, Edo. Falcón', '(0412)7676803', 'No disponible.', '', '11', '108')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Punto Fijo', 'Alcides José Goitía Chirinos', 'Alcalde de Punto Fijo', 'Av. Táchira, entre Av. Los Caobos y Av. Las Acacias, Punto Fijo, Edo. Falcón', '(0269)2458511 / (0269)2452365 / (0269)2450501 / (0269)2451401 / Fax: (0269)2452365', 'No disponible.', '', '11', '109')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Vera de Coro', 'Juan Manaure', 'Alcalde de La Vera de Coro', 'Calle Briceño, entre Falcón y Zamora, Edif. Municipal, frente a la Plaza Bolívar. La Vela de Coro, Edo. Falcón', '(0268)8083697', 'No disponible.', '', '11', '110')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Dabajuro', 'Francisca Oberto', 'Alcaldesa de Dabajuro', 'Edificio Municipal, Calle vía aeropuerto al final. Dabajuro, Edo. Falcón', '(0279)8281331 / Fax: (0279)8281632', 'No disponible.', '', '11', '111')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pedregal', 'Gregoria Crespo', 'Alcaldesa de Pedregal', 'Calle Comercio, Concejo Municipal, Pedregal, Edo. Falcón', '(0268)8811087', 'No disponible.', '', '11', '112')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pueblo Nuevo', 'Américo Antonio Parra Ulacio', 'Alcalde de Pueblo Nuevo', 'Calle de 5 Julio, con calle Bolívar y Falcón, frente a la Plaza Mayor, Pueblo Nuevo de Paraguaná', '(0269)4156360 / (0269)4156361 / Fax: (0269)4156370', 'No disponible.', '', '11', '113')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Churuguara', 'Argenis Arcaya Romero', 'Alcalde de Churuguara', 'Calle Municipal con calle Monagas Frente a la Plaza Bolívar, Edo. Falcón', '(0268)8084626', 'No disponible.', '', '11', '114')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Jacura', 'Onofre Jiménez', 'Alcalde de Jacura', 'Edif. Municipal, Calle Principal, Jacura', '(0414)5817234', 'No disponible.', '', '11', '115')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Los Taques', 'José Luis Iglesias', 'Alcalde de Los Taques', 'Calle Briceño entre Falcón y Zamora, Edif. Municipal, Los Taques. Edo. Falcón', '(0269)2770150 / (0269)2770835', 'No disponible.', '', '11', '116')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mauroa', 'Doris Gutiérrez', 'Alcaldesa de Mauroa', 'Calle Bolívar, Edif. Municipal, Frente a la Plaza Mene de Mauroa', '(0279)8920479 / 8920067 / 8920141', 'No disponible.', '', '11', '117')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chichiriviche', 'Nawal El Bacha', 'Alcalde de Chichiriviche', 'Calle Páez. Edif. Municipal, Chichiriviche', '(0242)86461 / (0412)5030639', 'No disponible.', '', '11', '118')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Palmasola', 'Giuseppe Adam Palmieri Ingleses', 'Alcalde de Palmasola', 'Calle los Almendrones diagonal al Comando MVR. Palmasola', '(0259)4160824', 'No disponible.', '', '11', '119')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cabudare', 'Rafael López', 'Alcalde de Cabudare', 'Edif. Municipal. Sector Pueblo Abajo, Cabure', '(0268)611180', 'No disponible.', '', '11', '120')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Píritu', 'María Lastra', 'Alcaldesa de Píritu', 'Calle San José, Junta Comunal, Píritu, Edo. Falcón', '(0279)8920479 / (0279)8920067 / (0279)8920141', 'No disponible.', '', '11', '121')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mirimire', 'Moisés Aguilar', 'Alcalde de Mirimire', 'Calle Bolívar, Edif. Municipal, frente a la Plaza Bolívar, San Francisco, Edo. Falcón', '(0259)9915756', 'No disponible.', '', '11', '122')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tucaca', 'Alberto Zreik', 'Alcalde de Tucaca', 'Av. Libertador, frente a la Plaza Bolívar, Tucacas', '(0416) 742.68.16 / Fax: (0259) 8120332', 'No disponible.', '', '11', '123')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Cruz de Taratara', 'Felipe Romero', 'Alcalde de La Cruz de Taratara', 'Consejo Municipal, Sector la Plaza, al lado de la Prefectura de la Cruz de Taratara, Edo. Falcón', '(0268)4163448 / (0268)6565063', 'No disponible.', '', '11', '124')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tocópero', 'Julio Rojas', 'Alcalde de Tocópero', 'Calle Bolívar, Edif. Municipal, frente a la Plaza Bolívar, San Francisco, Edo. Falcón', '(0259)9915756', 'No disponible.', '', '11', '125')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Urumaco', 'Martin Perozo', 'Alcalde de Urumaco', 'Calle Comercio, Concejo Municipal. Urumaco, Edo. Falcón', '(0268)5520600', 'No disponible.', '', '11', '126')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Puerto Cumarebo', 'Alejandro Reyes Alcalá', 'Alcalde de Puerto Cumarebo', 'Calle Municipal. Edif. Municipal, Cumarebo', '(0268)72794', 'No disponible.', '', '11', '127')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Camaguán', 'José Vásquez', 'Alcalde de Camaguán', 'Calle Miranda. Cruce con Girardot, Camaguán, Edo. Guárico', '(0247)710147', 'No disponible.', '', '12', '128')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chaguaramas', 'José Manuel Vásquez', 'Alcalde de Chaguaramas', 'Calle Zaraza al lado de puesto policial número 22. Chaguaramas, Edo. Guárico', '(0235)7755151 / (0414)2968150 / Fax: (0235)7755151', 'No disponible.', '', '12', '129')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Socorro', 'Hilda Ruíz', 'Alcaldesa de El Socorro', 'Calle Principal. Edif. Municipal. Al lado de la Guardia Nacional, San Luis', '(0238)5580992 / (0238)5580930', 'No disponible.', '', '12', '130')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Valle de la Pascua', 'José Rafael Ortega', 'Alcalde de Valle de la Pascua', 'Calle Guasco cruce con calle Retumbo y Atarralla, Concejo Municipal, Valle de la Pascua, Edo. Guárico', '(0235)3412155 / (0235)3415412', 'No disponible.', '', '12', '131')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Las Mercedes', 'Marcos Herrera', 'Alcalde de Las Mercedes', 'Calle Mata Palo. Frente al Hotel Las Mercedes, Edo. Guárico', '(0414)6457252', 'No disponible.', '', '12', '132')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Sombrero', 'Rafael Gil', 'Alcalde de El Sombrero', 'Calle Fraternidad, frente a la Plaza Bolívar. El Sombrero, Edo. Guárico', '(0246)6163653 / (0246)6163437 / Fax: (0246)6163653', 'No disponible.', '', '12', '133')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Calabozo', 'Porfirio Fajardo', 'Alcalde de Calabozo', 'Calle 5, entre Carreras 9 y 10, Concejo Municipal, Calabozo, Edo. Guárico', '(0246)8713539 / (0246)8711706 / (0246)8712834', 'No disponible.', '', '12', '134')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Altagracia de Orituco', 'María Chacín', 'Alcaldesa de Altagracia de Orituco', 'Calle Julián Mellado, Edif. Junta Municipal, Altagracia de Orituco, Edo. Guárico', '(0238)3341531 / (0238)3343963 / (0238)3343547', 'No disponible.', '', '12', '135')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ortíz', 'Elías Nederr', 'Alcalde de Ortíz', 'Calle Sucre, Concejo Municipal, Ortiz, Edo. Guárico', '(0416)4350465 / (0416)8447474', 'No disponible.', '', '12', '136')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tucupido', 'Jesús Aguilar', 'Alcalde de Tucupido', 'Calle San Pablo cruce con Calle Salón. Concejo Municipal, Tucupido, Edo. Guárico', '(0238)5522965 / (0238)5146555  / Fax: (0238)5522965', 'No disponible.', '', '12', '137')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Juan de los Morros', 'Franco Gerratana', 'Alcalde de San Juan de los Morros', 'Av. Cedeño, frente a la Plaza Bolívar, Edif. Municipal, San Juan de los Morros, Edo. Guárico', '(0246)4310654 / (0246)4310553 / (0246)4313457', 'No disponible.', '', '12', '138')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guayabal', 'José Morales', 'Alcalde de Guayabal', 'Calle Miguel Salazar, cruce con Calle Miranda, Quinta Crucar, Edo. Guárico', 'No disponible.', 'No disponible.', '', '12', '139')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guaribe', 'Roberto Brito', 'Alcalde de Guaribe', 'Calle Sucre, frente a la Plaza Bolívar. Guaribe, Edo. Guárico', '(0238)4441154 / (0238)4441211', 'No disponible.', '', '12', '140')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ipire', 'Denal Lamas', 'Alcalde de Ipire', 'Calle Candelaria, Junta Comunal Santa María de Ipire, Edo. Guárico', '(0238)7781095 / (0238)7781182 / (0238)7781454', 'No disponible.', '', '12', '141')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Zaraza', 'Freddy Alí Gómez', 'Alcalde de Zaraza', 'Calle El Comercio, Edif. Municipal, Zaraza, Edo. Guárico', '(0238)7624107 / (0238)7620252 / (0238)7620970', 'No disponible.', '', '12', '142')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Duaca', 'Elizabeth Valecillos', 'Alcaldesa de Duaca', 'Carrera 6, entre 13 y 14. Casa Municipal, Freitez, Edo. Lara', '(0253)2221181 / (0253)2221272 / (0253)2221065', 'No disponible.', '', '13', '143')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barquisimeto', 'Amalia Sáez', 'Alcaldesa de Barquisimeto', 'Carrera 25, entre 17 y 18, Barquisimeto, Edo. Lara', '(0251)2331080 / (0251)7101800 / (0251)7101801', 'No disponible.', '', '13', '144')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Quíbor', 'Luis Plaza', 'Alcalde de Quíbor', 'Av. 7. Esq. Calle 11. Consejo Municipal, Quibor. Edo. Lara', '(0253)5140058 / (0253)5145006', 'No disponible.', '', '13', '145')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Tocuyo', 'Fidel Palma', 'Alcalde de El Tocuyo', '18 con Av. Lisandro Alvarado, Edif. Concejo Municipal, El Tocuyo, Edo. Lara', '(0253)6632372 / (0253)6632065', 'No disponible.', '', '13', '146')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cabudare', 'Richard Córdova', 'Alcalde de Cabudare', 'Calle Juan de Dios Ponte, Edif. de los Poderes Públicos, Cabudare, Edo. Lara', '(0251)2633908 / (0251)2632416 / Fax: (0251)2633680', 'No disponible.', '', '13', '147')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sanare', 'Fermín Marín', 'Alcalde de Sanare', 'Calle San Felipe entre Av. Libertador y Miranda, al frente de la Plaza Bolívar. Sarare, Edo. Lara', '(0251)9921626 / (0251)9921112 / Fax: (0251)9921332', 'No disponible.', '', '13', '148')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Carora', 'Edgar Carrasco', 'Alcalde de Carora', 'Av. Francisco de Miranda con calle Riera Silva, Palacio Municipal, Carora. Edo. Lara', '(0252)4215527 / (0252)4215066 / (0252)4216124', 'No disponible.', '', '13', '149')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Siquesique', 'Luis Ladino', 'Alcalde de Siquesique', 'Av. Urdaneta, entre calle 5 y 6, Edif. Poderes Públicos, Siquisique, Edo. Lara', '(0253)3231655 / (0253)3231466 / (0253)3231050', 'No disponible.', '', '13', '150')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Acarigua', 'Reyes Cadena', 'Alcalde de Acarigua', 'Vía Santa María, Calle Principal, Edo. Mérida', '(0274)4441013', 'No disponible.', '', '14', '151')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Azulita', 'Ramón Domínguez', 'Alcalde de Azulita', 'Calle 3, cruce con Av. Bolívar, Edif. Municipal, La Azulita, Edo. Mérida', '(0275)9997047 / (0275)9979778 / Fax: (0275)9997125', 'No disponible.', '', '14', '152')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Cruz de Mora', 'Oscar Garrido', 'Alcalde de Santa Cruz de Mora', 'Calle Ayacucho, frente a la Plaza Bolívar y el Colegio Sra. del Carmen, Edo. Mérida', '(0275)8670025', 'No disponible.', '', '14', '153')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Canagua', 'Carlos Chacón', 'Alcalde de Canagua', 'Calle 5 de Julio, Edif. Municipal. Frente a la Plaza Bolívar, Canagua, Edo. Mérida', 'No disponible.', 'No disponible.', '', '14', '154')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ejido', 'Pedro Álvarez', 'Alcalde de Ejido', 'Av. Bolívar, Edif. Municipal, Frente a la Plaza Bolívar, Ejido. Edo. Mérida', '(0274)2213056 / (0274)2212256 / (0274)2211824', 'No disponible.', '', '14', '155')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tucaní', 'Omar Ditta', 'Alcalde de Tucaní', 'Casa Municipal, frente a la Plaza Bolívar, Aricagua, Edo. Mérida', '', 'No disponible.', '', '14', '156')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santo Domingo', 'Hilda Ramírez', 'Alcaldesa de Santo Domingo', 'Vereda Urdaneta, frente a la Plaza Bolívar, Edo. Mérida', '(0274)8988322 / Fax: (0274)8988355', 'No disponible.', '', '14', '157')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guaraque', 'Carlos Alí Guerrero', 'Alcalde de Guaraque', 'Casa Municipal, frente a la Plaza Bolívar, Guaraque, Edo. Mérida', '(0275)8816400 / Fax: (0275)8816400', 'No disponible.', '', '14', '158')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Arapuey', 'Silvio Torres', 'Alcalde de Arapuey', 'Frente a la Plaza Bolívar, al lado de la Prefectura, Edo. Mérida', '(0271)7781201', 'No disponible.', '', '14', '159')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mérida', 'Lester Rodríguez', 'Alcalde de Mérida', 'Av. Urdaneta, al lado del Colegio de Médicos, Mérida', '(0274)2631977 / (0274)2525390', 'No disponible.', '', '14', '160')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Timotes', 'José Olmos', 'Alcalde de Timotes', 'Av. Bolívar, Edif. Municipal, frente a la Plaza Bolívar, Timotes, Edo. Mérida', '(0271)8289045 / (0271)8289156 / (0271)8289394', 'No disponible.', '', '14', '161')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Elena de Arenales', 'Moisés Pereira', 'Alcalde de Santa Elena de Arenales', 'Calle Principal, Qta. Profesor Don Santiago, Santa Elena de Arenales, Edo. Mérida', '(0274)9991358 / (0274)9991251 / Fax: (0274)9991358', 'No disponible.', '', '14', '162')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa María de Caparo', 'Omar Contreras', 'Alcalde de Santa María de Caparo', 'Frente a la Plaza Bolívar, Caparo, Edo. Mérida', '(0274)2442199 / Fax: (0274)2441510', 'No disponible.', '', '14', '163')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pueblo Llano', 'Edgar Villamizar', 'Alcalde de Pueblo Llano', 'Av. Bolívar a media cuadra de la Plaza Bolívar, Pueblo Llano, Edo. Mérida', 'No disponible.', 'No disponible.', '', '14', '164')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mucuchíes', 'Oscar Albarrán', 'Alcalde de Mucuchíes', 'Calle Bolívar, Concejo Municipal, frente al Colegio Cardenal Quintero, Mucuchíes, Edo. Mérida', '(0274)8720050 / (0274)8720136 / Fax: (0274)8720931', 'No disponible.', '', '14', '165')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Bailadores', 'Milton Ramírez', 'Alcalde de Bailadores', 'Edif. Municipal, Carrera 2 frente la Plaza Bolívar, Edo. Mérida', '(0275)8750081', 'No disponible.', '', '14', '166')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tabay', 'José Otálora', 'Alcalde de Tabay', 'Junta Comunal de Tabay, Tabay, Edo. Mérida', '(0274)2830194 / (0274)2830198 / Fax: (0274)2830194', 'No disponible.', '', '14', '167')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Lagunillas', 'Aron Varela', 'Alcalde de Lagunillas', 'Calle las Palmas. Concejo Municipal, Frente a la Plaza Bolívar. Edo. Mérida', '(0274)9961082 / (0274)9961057', 'No disponible.', '', '14', '168')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tovar', 'Lizandro Morales', 'Alcalde de Tovar', 'Calle 6, entre Carreras 3 y 4, Esq. de la Plaza Bolívar. Tovar, Edo. Mérida', '(0275)8730476 / (0275)8730473 / (0275)8733906', 'No disponible.', '', '14', '169')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Nueva Bolivia', 'William Díaz', 'Alcalde de Nueva Bolivia', 'Av. Principal, al lado del cuerpo de bomberos, módulo de servicio Nueva Bolivia, Edo. Mérida', '(0271) 7722241 / (0271)7722791 / (0271)7721334 / Fax: (0271)7722241', 'No disponible.', '', '14', '170')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Caucagua', 'Juan Aponte', 'Alcalde de Caucagua', 'Casa Municipal, frente a la Plaza Bolívar, Caucagua, Edo. Miranda', '(0234)6621436 / (0234)6621380', 'No disponible.', '', '15', '171')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barlovento', 'Albaro Hidalgo', 'Alcalde de Barlovento', 'Frente a la Plaza Bolívar de San José de Barlovento, Edo. Miranda', '(0234)8721151 / (0234)8721930 / (0234)8721050', 'No disponible.', '', '15', '172')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Baruta', 'Gerardo Blyde', 'Alcalde de Baruta', 'Edif. Sede, entre Av. Principal de Colinas de Bello Monte y Av. Beethoven, Caracas', '(0212)7017455 / (0212)7017456 / (0212)7017431', 'No disponible.', '', '15', '173')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Higuerote', 'Liliana González', 'Alcaldesa de Higuerote', 'Av. Uno, Edif. Municipal, Higuerote, Edo. Miranda', '(0234)3230218 / (0234)3230880', 'No disponible.', '', '15', '174')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Mamporal', 'Deivis Cáceres', 'Alcalde de Mamporal', 'Concejo Municipal, Mamporal, Edo. Miranda', '(0234)3421036 / (0234)3421953 / (0234)2341453', 'No disponible.', '', '15', '175')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chacao', 'Emilio Graterón', 'Alcalde de Chacao', 'Final Av. Venezuela, cruce con calle Sorocaima, Edif. Atrium. Piso 6, El Rosal, Edo. Miranda', '(0212)9057077 / (0212)9057057 / (0212)9057007 / Fax: (0212)9533560', 'No disponible.', '', '15', '176')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Charallave', 'José Ramírez', 'Alcalde de Charallave', 'Final Av. Cristóbal Rojas, Centro Comercial Residencial El Campito, planta baja y Mezzaninas de las Torres C y D. Charallave, Edo. Miranda', '(0239)2200511', 'No disponible.', '', '15', '177')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Hatillo', 'Myrian Do Nascimento', 'Alcaldesa de El Hatillo', 'Calle Bolívar con calle Escalona, frente a la Plaza Bolívar, El Hatillo, Edo. Miranda', '(0212)9634848 / (0212)9634175 / (0212)9637414', 'No disponible.', '', '15', '178')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Los Teques', 'Alirio Mendoza', 'Alcalde de Los Teques', 'Av. Bolívar, Palacio Municipal, Los Teques, Edo. Miranda', '(0212)3214379 / (0212)3213560 / (0212)3214339 / Fax: (0212)3216262', 'No disponible.', '', '15', '179')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Teresa del Tuy', 'Ramón Malavé', 'Alcalde de Santa Teresa del Tuy', 'Urb. Las Flores, Calle Las Margaritas, Qta. Crismara, No. 5, Sta. Teresa del Tuy, Edo. Miranda', '(0239)2310537 / (0239)2310657 / (0239)2310142', 'No disponible.', '', '15', '180')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Antonio', 'Ovidio Lozada', 'Alcalde de San Antonio', 'Distribuidor San Antonio de Los Altos, Concejo Municipal, Edo. Miranda', '(0212)3729711', 'No disponible.', '', '15', '181')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Río Chico', 'Jesús Monterola', 'Alcalde de Río Chico', 'Calle Las Mercedes, Casa Municipal, Río Chico, Edo. Miranda', '(0234)8774490 / (0234)8774663 / (0234)8774468', 'No disponible.', '', '15', '182')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Lucía', 'Víctor González', 'Alcalde de Santa Lucía', 'Av. Bolívar, Edif. El Gobierno, Frente a la Plaza Bolívar, Sta. Lucía, Edo. Miranda', '(0239)2181864 / (0239)2181654', 'No disponible.', '', '15', '183')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cúpira', 'Manuel Álvarez', 'Alcalde de Cúpira', 'Calle Gual, Concejo Municipal, Cúpira, Edo. Miranda', '(0234)8879190', 'No disponible.', '', '15', '184')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guarenas', 'Freddy Rodríguez', 'Alcalde de Guarenas', 'Calle Bolívar, frente a la Plaza Bolívar, Pueblo Arriba, Guarenas, Edo. Miranda', '(0212)3621890 / (0212)3628665', 'No disponible.', '', '15', '185')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Francisco de Yare', 'Saúl Yánez', 'Alcalde de San Francisco de Yare', 'San Francisco de Yare, suroeste del Edo. Miranda', '(0239)2229876 / (0239)2229976 / (0239)2229722', 'No disponible.', '', '15', '186')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Petare', 'Carlos Ocaríz', 'Alcalde de Petare', 'Plaza Sucre, Zona Colonial de Petare, Edo. Miranda', '(0212)2376343 / (0212)2710253 / (0212)2723360', 'No disponible.', '', '15', '187')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ocumare del Tuy', 'Julio Marcano', 'Alcalde de Ocumare del Tuy', 'Av. Miranda cruce con Av. Bolívar, Concejo Municipal, Ocumare del Tuy, Edo. Miranda', '(0239)2250910 / (0239)2251040 / (0239)2257352', 'No disponible.', '', '15', '188')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cúa', 'Edicson Sarmientos', 'Alcalde de Cúa', 'Calle José María Carreño, diagonal a la Plaza Bolívar, Cúa, Edo. Miranda', '(0239)2126415 / (0239)2120501 / (0239)2120147', 'No disponible.', '', '15', '189')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guatire', 'Oswaldo Sifontes', 'Alcalde de Guatire', 'Edif. Centro Cívico, al lado de la Iglesia, Guatire, Edo. Miranda', '(0212)3444624 / (0212)3415644', 'No disponible.', '', '15', '190')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Antonio de Capayacur', 'Edgar Gutiérrez', 'Alcalde de San Antonio de Capayacur', 'Calle Bolívar, Edif. Rental, San Antonio de Capayacur, Edo. Monagas', '(0292)5581178 / (0292)5581166', 'No disponible.', '', '16', '191')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Aguasay', 'José Galindo', 'Alcalde de Aguasay', 'Calle Principal, Casa de la Cultura, Aguasay, Edo. Monagas', 'No disponible.', 'No disponible.', '', '16', '192')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Caripito', 'Carlos Betancourt', 'Alcalde de Caripito', 'Calle Sucre, Edif. del Concejo, Caripito. Edo. Monagas', '(0291)7721137 / (0291)7721461', 'No disponible.', '', '16', '193')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Caripe', 'Alirio Amundaray', 'Alcalde de Caripe', 'Av. Enrique Chaumer, Edif. Concejo Municipal, Caripe, Edo. Monagas', '(0292)5451069 / (0292)5451070', 'No disponible.', '', '16', '194')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Caicara de Maturín', 'Pedro E. Briceño', 'Alcalde de Caicara de Maturín', 'Calle Cedeño, Concejo Municipal, Frente a la Plaza Bolívar, Caicara de Maturín, Edo. Monagas', '(0292)3311020 / (0292)3310117', 'No disponible.', '', '16', '195')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Punta de Mata', 'Ángel Guzmán', 'Alcalde de Punta de Mata', 'Sede de la Alcaldía. Calle San Martín cruce con Calle Andrés Bello, frente a la Plaza Bolívar, Punta de Mata, Edo. Monagas', '(0292)3370945 / (0292)3370263 / (0292)3371734', 'No disponible.', '', '16', '196')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Temblador', 'José Figuera', 'Alcalde de Temblador', 'Calle Andrés Pérez, Sede de la Alcaldía, Temblador, Edo. Monagas', '(0287)7920712', 'No disponible.', '', '16', '197')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Maturín', 'José Maicavares', 'Alcalde de Maturín', 'Sede de la Alcaldía, entre calle Azcúe y Av. Bolívar, Maturín, Edo. Monagas', '(0291)6411514', 'No disponible.', '', '16', '198')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Aragua de Maturín', 'Miguel Fuentes', 'Alcalde de Aragua de Maturín', 'Sede de la Alcaldía, Calle Piar, Cruce con Bolívar, Aragua de Maturín, Edo. Monagas', 'No disponible.', 'No disponible.', '', '16', '199')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Quiriquire', 'Jesús Mata', 'Alcalde de Quiriquire', 'Calle Punceres, Sede de la Alcaldía, Quiriquire, Edo. Monagas', '(0291)7787154', 'No disponible.', '', '16', '200')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Bárbara', 'José Trujillo', 'Alcalde de Santa Bárbara', 'Calle Magdalena, Casa de la Cultura, Santa Bárbara, Edo. Monagas', '(0292)3345007 / Fax: (0292)3345105', 'No disponible.', '', '16', '201')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Barrancas del Orinoco', 'José Berroterán', 'Alcalde de Barrancas del Orinoco', 'Calle Bolívar, Edif. Municipal, Barrancas del Orinoco, Edo. Monagas', 'No disponible.', 'No disponible.', '', '16', '202')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Uracoa', 'Luis Vicuña', 'Alcalde de Uracoa', 'Calle Urdaneta, Junta Parroquial de Uracoa, Edo. Monagas', '(0287)7790150 / (0287)7790760', 'No disponible.', '', '16', '203')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Paraguachí', 'Olga Zulay Pérez', 'Alcaldesa de Paraguachí', 'Av. 24 de Julio, Sector Los Mangos, Plaza de Paraguachí Isla de Margarita, Edo. Nueva Esparta', '(0295)2348366 / (0295)2348659', 'No disponible.', '', '17', '204')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Asunción', 'Francisco Torcat', 'Alcalde de La Asunción', 'Calle Matasiete, Palacio Municipal, La Asunción, Edo. Nueva Esparta', '(0295)2423440 / (0295)2423178 / (0295)2422616 / Fax: (0295) 2423440 / (0295)2423178 / (0295)2422616', 'No disponible. Correos: asuncion@arismendi-nuevaesparta.gob.ve / alcalde@arismendi-nuevaesparta.gob.ve', '', '17', '205')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Juan Bautista', 'Marisel Velásquez', 'Alcaldesa de San Juan Bautista', 'Calle Páez con calle Sucre, San Juan Bautista, Edo. Nueva Esparta', '(0295)2590223 / (0295)2590395', 'No disponible.', '', '17', '206')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Valle', 'Freddy Hernández', 'Alcalde de El Valle', 'Calle Concepción Mariño, diagonal a la plaza Bolívar. El Valle, Edo. Nueva Esparta', '(0295)2870577 / (0295)2870425', 'No disponible.', '', '17', '207')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Ana', 'Yannelys Patiño', 'Alcaldesa de Santa Ana', 'Palacio Municipal, Calle El Bronce, Santa Ana, Edo. Nueva Esparta', '(0295)2570093 / (0295)2570017', 'No disponible.', '', '17', '208')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Maneiro', 'Darvelis De Ávila', 'Alcaldesa de Maneiro', 'Palacio Municipal, Calle San Martín, Pampatar, Edo. Nueva Esparta', '(0295)2630311 / (0295)2631144', 'No disponible.', '', '17', '209')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Juan Griego', 'Ibrahin Velásquez', 'Alcalde de Juan Griego', 'Calle Rísquez, entre calle Colón y Bolívar, Juan Griego, Edo. Nueva Esparta', '(0295)2531248 / (0295)2532328 / (0295)2531913', 'No disponible.', '', '17', '210')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Porlamar', 'Alfredo Díaz', 'Alcalde de Porlamar', 'Calle Maneiro, cruce con calle Arismendi, Porlamar, Edo. Nueva Esparta', '(0295)2640387', 'No disponible.', '', '17', '211')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Boca de Río', 'Miguel Ángel Vásquez', 'Alcalde de Boca de Río', 'Concejo Municipal Calle Nueva Esparta con Calle Boca del Río, Edo. Nueva Esparta', '(0295)2913930 / (0295)2913910', 'No disponible.', '', '17', '212')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Punta de Piedras', 'Ventura Salazar', 'Alcalde de Punta de Piedras', 'Calle Bolívar, Concejo Municipal, Punta de Piedras, Edo. Nueva Esparta', '(0295)2398126 / (0295)2398230', 'No disponible.', '', '17', '213')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Coche', 'José Fermín', 'Alcalde de Coche', 'Concejo Municipal Calle Nueva Esparta con Calle Boca del Río, Edo. Nueva Esparta', '(0295)2913930 / (0295)2913910 / (0295)2913269', 'No disponible.', '', '17', '214')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Agua Blanca', 'Primitivo Cedeño', 'Alcalde de Agua Blanca', 'Carrera 14, frente a la Plaza Bolívar, Edif. Municipal, Agua Blanca, Edo. Portuguesa', '(0255)7921064 / (0255)7921269', 'No disponible.', '', '18', '215')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Araure', 'José Rafael Vásquez', 'Alcalde de Araure', 'Calle 6, Esq. Av. 23, Palacio Municipal, Araure, Edo. Portuguesa', '(0255)6652837 / (0255)6651198 / (0255)6652502', 'No disponible.', '', '18', '216')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Boconoíto', 'Evelio Montilla', 'Alcalde de Boconoíto', 'Frente a la Plaza Bolívar. Boconoito. Edo. Portuguesa', '(0257)2631064', 'No disponible.', '', '18', '217')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Píritu', 'Lucidia Ruíz', 'Alcaldesa de Píritu', 'Calle 10, entre carreras 8 y 9, Edif. Municipal, Píritu, Edo. Portuguesa', '(0256)3361357 / (0256)3361879 / (0256)3361329', 'No disponible.', '', '18', '218')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guanare', 'Rafael Calles', 'Alcalde de Guanare', 'Calle 23, Edif. Rental, Guanare Edo. Portuguesa', '(0257)2511666 / (0257)2517507 / (0257)2512187', 'No disponible.', '', '18', '219')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guanarito', 'Abél Villalba', 'Alcalde de Guanarito', 'Calle 5, entre carrera 8 y 9, Casa Municipal, Guanarito, Edo. Portuguesa', '(0257)7711866 / (0257)7711644', 'No disponible.', '', '18', '220')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chabasquén', 'Oswaldo Zerpa', 'Alcalde de Chabasquén', 'Calle Rondón, frente a la Plaza Bolívar, Concejo Municipal, Chabasquén, Edo. Portuguesa', '(0257)4154333', 'No disponible.', '', '18', '221')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ospino', 'Geremías Colmenares', 'Alcalde de Ospino', 'Calle Lisandro Alvarado con Av. Páez, Edif. Municipal, Ospino, Edo. Portuguesa', '(0256)3282502 / Fax: (0256)3282666', 'No disponible.', '', '18', '222')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Papelón', 'José María Arias', 'Alcalde de Papelón', 'Junta Municipal, frente a la Plaza Bolívar, Papelón, Edo. Portuguesa', '(0257)2570032', 'No disponible.', '', '18', '223')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Rafael de Onoto', 'Wasim Abousaada', 'Alcalde de San Rafael de Onoto', 'Calle Principal, frente a la Plaza Bolívar, Junta Comunal, San Rafael de Onoto, Edo. Portuguesa', '(0255)7789096', 'No disponible.', '', '18', '224')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Playón', 'Otoniel Meléndez', 'Alcalde de El Playón', 'Calle Bolívar, frente a la Plaza Bolívar, Concejo Municipal, Santa Rosalía, Edo. Portuguesa', '(0256)3384290 / (0256)3384223', 'No disponible.', '', '18', '225')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Biscucuy', 'Alfredo Mendoza', 'Alcalde de Biscucuy', 'Carrera 3, frente a la Plaza Bolívar, Edif. Concejo Municipal, Bicucuy, Edo. Portuguesa', '(0257)8821847 / (0257)8821069', 'No disponible.', '', '18', '226')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Villa Bruzual', 'Onofrio Cavallo Ruseo', 'Alcalde de Villa Bruzual', 'Av. 3, Frente a la Plaza Bolívar, Concejo Municipal, Edo. Portuguesa', 'No disponible.', 'No disponible.', '', '18', '227')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Casanay', 'Pablo Tineo', 'Alcalde de Casanay', 'Calle Venezuela, Concejo Municipal, Casanay, Edo. Sucre', '(0294)3410397', 'No disponible.', '', '19', '228')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Aerocuar', 'María Hurtado', 'Alcaldesa de Aerocuar', 'Calle Bolívar, No. 10, San José de Aerocuar, Edo. Sucre', 'No disponible.', 'No disponible.', '', '19', '229')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Río Caribe', 'José Ramón Guerra', 'Alcalde de Río Caribe', 'Calle Rivero, No. 42, Río Caribe, Edo. Sucre', '(0294)6461355 / (0294)6461387 / (0294)6461318', 'No disponible.', '', '19', '230')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Piar', 'Evaristo Pino', 'Alcalde de El Piar', 'Calle Las Mercedes, Concejo Municipal, El Pilar, Edo. Sucre', '(0294)6567115 / (0294)6567248 / (0294)6567259', 'No disponible.', '', '19', '231')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Carupano', 'Julio Rodríguez', 'Alcalde de Carupano', 'Calle Carabobo, Palacio Municipal, Carúpano, Edo. Sucre', '(0294)3322056 / (0294)4164205', 'No disponible.', '', '19', '232')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Marigüitar', 'Carmen Villegas', 'Alcaldesa de Marigüitar', 'Calle Sucre, Edif. Municipio Marigüitar, Edo. Sucre', '(0293)8391384 / (0293)8931422', 'No disponible.', '', '19', '233')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Yaguaraparo', 'Carlos Rodríguez', 'Alcalde de Yaguaraparo', 'Calle Carabobo, frente a la Plaza de San Juan Yaguaraparo, Edo. Sucre', '(0294)4164573 / (0294)7751065', 'No disponible.', '', '19', '234')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Araya', 'Wilfredo Rivero', 'Alcalde de Araya', 'Av. Principal Concejo Municipal, Araya. Edo. Sucre', '(0293)4371131 / (0293)4371340 / (0293)4371137', 'No disponible.', '', '19', '235')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tenepui', 'Israel Arroyo', 'Alcalde de Tenepui', 'Calle Sta. Lucía, frente a la Plaza Bolívar. Edo. Sucre', '(0294)4164568', 'No disponible.', '', '19', '236')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Irapa', 'Luis Villegas', 'Alcalde de Irapa', 'Calle Carabobo Concejo Municipal Irapa. Edo. Sucre', '(0294)4165405 / (0294)9897798', 'No disponible.', '', '19', '237')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Antonio del Golfo', 'Martha Patiño', 'Alcalde de San Antonio del Golfo', 'Calle Páez cruce con calle Santa Teresa, Junta Municipal, frente a la Plaza Bolívar, San Antonio del Golfo. Edo. Sucre', 'No disponible.', 'No disponible.', '', '19', '238')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cumanacoa', 'Rafael Barrios', 'Alcalde de Cumanacoa', 'Av. Sucre, Frente a la Plaza Bolívar, Edif. Palacio Municipal, Cumanacoa, Edo. Sucre', 'No disponible.', 'No disponible.', '', '19', '239')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cariaco', 'Juan Carlos Rojas', 'Alcalde de Cariaco', 'Calle Congresillo, Concejo Municipal, frente a la Plaza Bermúdez, Cariaco, Edo. Sucre', '(0294)5551413 / (0294)5511136 / (0294)5551629', 'No disponible.', '', '19', '240')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cumaná', 'Rafael Acuña', 'Alcalde de Cumaná', 'Av. Universidad, al lado de Eleoriente, Cumaná, Edo. Sucre', '(0293)4519666 / (0293)4521480 / (0293)4521914', 'No disponible.', '', '19', '241')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Güiria', 'Jesús Ramírez', 'Alcalde de Güiria', 'Calle Papagayos, Concejo Municipal, Güiria, Edo. Sucre', '(0294)9821280 / (0294)9821009', 'No disponible.', '', '19', '242')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cordero', 'Valmore Velasco', 'Alcalde de Cordero', 'Av. Eleuterio Chacón, Casa Municipal, al lado de la Policía, Cordero, Edo. Táchira', '(0276)3960414', 'No disponible.', '', '20', '243')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Las Mesas', 'Jesús Duque', 'Alcalde de Las Mesas', 'Carrera 14, entre calle 4 y 5, Concejo Municipal, Las Mesas, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '244')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Colón', 'Miguel Chacón', 'Alcalde de Colón', 'Carrera 10, entre calles 8 y 9, Edif. Rental, Colón, Edo. Táchira', '(0277)2913035 / (0277)2913296', 'No disponible.', '', '20', '245')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Antonio del Táchira', 'Vicente Cañas', 'Alcalde de San Antonio del Táchira', 'Av. Primero de Mayo, Edif. Centro Cívico, Piso 3, San Antonio del Táchira, Edo. Táchira', '(0276)7715190 / (0276)7713301 / (0276)7714655', 'No disponible.', '', '20', '246')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Táriba', 'Maryury Pernía', 'Alcaldesa de Táriba', 'Calle 3 entre carreras 4 y 5, Casa Municipal, Táriba, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '247')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Ana del Táchira', 'Virginia Vivas', 'Alcaldesa de Santa Ana del Táchira', 'Calle 10, frente al Parque Bolívar, Edif. Municipal, Santa Ana, Edo. Táchira', '(0276)7667134 / (0276)7667856', 'No disponible.', '', '20', '248')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Rafael del Peñal', 'Williams Pulido', 'Alcalde de San Rafael del Peñal', 'No disponible.', '(0277)2347390 / (0277)2347388', 'No disponible.', '', '20', '249')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San José de Bolívar', 'Yordi Sánchez', 'Alcalde de San José de Bolívar', 'Calle 3, entre carreras 2 y 3, Casa Junta Municipal, El Arbejal, San José de Bolívar, Edo. Táchira', '(0276)3573055', 'No disponible.', '', '20', '250')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Fría', 'Willington Vivas B.', 'Alcalde de La Fría', 'Final Calle 2, Edif. Municipal, La Fría, Edo. Táchira', '(0277)5411914 / (0277)5412441', 'No disponible.', '', '20', '251')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Palmira', 'Evaristo Zambrano', 'Alcalde de Palmira', 'Antiguo Local de la Junta Comunal, diagonal a la Plaza Bolívar, Palmira, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '252')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Capacho Nuevo', 'Onésimo Duarte', 'Alcalde de Capacho Nuevo', 'Carrera 6, frente a la Plaza Bolívar de Capacho, Edo. Táchira', '(0276)7883471 / (0276)7883464 / (0276)7883657', 'No disponible.', '', '20', '253')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Grita', 'Belkis Camargo', 'Alcaldesa de La Grita', 'Carrera 5, entre calles 3 y 2, Edif. Casa Municipal, La Grita, Edo. Táchira', '(0277)8812341 / (0277)4147001 Ext. 22 / (0277)8812322', 'No disponible.', '', '20', '254')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Cobre', 'Pablo Moncada', 'Alcalde de El Cobre', 'Junta Comunal, El Cobre, Edo. Táchira', '(0277)2917061', 'No disponible.', '', '20', '255')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Rubio', 'Mercedes Chapeta', 'Alcaldesa de Rubio', 'Calle 13 con Av. 11, Rubio, Edo. Táchira', '(0276)7623312 / (0276)7624001', 'No disponible.', '', '20', '256')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Capacho Viejo', 'Erasmo Gómez', 'Alcalde de Capacho Viejo', 'Carrera 3 con Calle 3, frente a la Plaza Bolívar, Capacho, Edo. Táchira', '(0276)7883054 / (0276)7880835', 'No disponible.', '', '20', '257')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Abejales', 'Ezequiel Pérez', 'Alcalde de Abejales', 'Calle 4 con Carrera 4, Casa Municipal, No. 3-37, Abejales, Edo. Táchira', '(0277)4146309 / (0277)4146308 / Fax: (0277)7576026', 'No disponible.', '', '20', '258')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Lobatera', 'Natalia Chacón', 'Alcaldesa de Lobatera', 'Calle 6, No. 222-26, Concejo Municipal, Lobatera, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '259')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Michelena', 'Fernando Andrade', 'Alcalde de Michelena', 'Calle 7, No. 1-78, Michelena, Edo. Táchira', '(0277)2230067 / (0277)2230818 / (0277)2230936', 'No disponible.', '', '20', '260')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Coloncito', 'Lluvane Álvares', 'Alcalde de Coloncito', 'Carrera 6 con calle 6 y 5, Casa Municipal, No. 516, Coloncito, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '261')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ureña', 'Nelson Becerra', 'Alcalde de Ureña', 'Carrera 4, Concejo Municipal, No. 2-21, Ureña, Edo. Táchira', '(0276)7871319 / (0276)7872192 / (0276)7872258', 'No disponible.', '', '20', '262')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Las Delicias', 'Alonso Fajardo', 'Alcalde de Las Delicias', 'Concejo Municipal, Las Delicias de Junín, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '263')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tendida', 'José Luis Marcano', 'Alcalde de Tendida', 'Calle 3, Parte Baja, frente al módulo de Fundacomun, Concejo Municipal de La Tendida, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '264')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Cristóbal', 'Mónica de Méndez', 'Alcaldesa de San Cristóbal', 'Urb. Mérida, Concejo Municipal, San Cristóbal, Edo. Táchira', '(0276)5165569 / (0276)5169916', 'No disponible.', '', '20', '265')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Umuquena', 'Berzabeth Gandica', 'Alcaldesa de Umuquena', 'Casa de la Junta Parroquial, Umuquena, Edo. Táchira', '(0277)5465131 / Fax: (0277)5470252', 'No disponible.', '', '20', '266')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Seboruco', 'Luis Pulido', 'Alcalde de Seboruco', 'Calle 5, Concejo Municipal, Seboruco, Edo. Táchira', '(0277)8486208 / (0277)4147074', 'No disponible.', '', '20', '267')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Simón', 'Carlos Apolinar', 'Alcalde de San Simón', 'Junta Parroquial de San Simón, Edo. Táchira', '(0277)4148034 / (0277)4148034', 'No disponible.', '', '20', '268')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Queniquea', 'José Gregorio Araque', 'Alcalde de Queniquea', 'Calle 2, Esq. carrera 4, Queniquea, Edo. Táchira', 'No disponible.', 'No disponible.', '', '20', '269')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Josecito', 'Gustavo Canelones', 'Alcalde de San Josecito', 'Entrada a San Josecito, Concejo Municipal, San Cristóbal, Edo. Táchira', '(0276)7640772 / (0276)7640857', 'No disponible.', '', '20', '270')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pregonero', 'Oswaldo Moreno', 'Alcalde de Pregonero', 'Carrera 2, Edif. Rentable, Frente a la Plaza Bolívar, Pregonero, Edo. Táchira', '(0277)7471007 / (0277)7471176 / (0277)7471092', 'No disponible.', '', '20', '271')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Isabel', 'Rafael Pérez', 'Alcalde de Santa Isabel', 'Santa Isabel, Vía Principal, antes de llegar al poblado, Casa Municipal, Santa Isabel, Edo. Trujillo', '(0271)2216641', 'No disponible.', '', '21', '272')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Boconó', 'Luis Cabezas', 'Alcalde de Boconó', 'Calle Bolívar, Edif. Municipal, frente a la Plaza Bolívar, Boconó, Edo. Trujillo', '(0272)6523097', 'No disponible.', '', '21', '273')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sabana Grande', 'José Gregorio Díaz', 'Alcalde de Sabana Grande', 'Sabana Grande, calle principal, sector El Campamento, municipio Bolívar, Edo. Trujillo', '(0271)4700038 / Fax: (0271)4700516', 'No disponible.', '', '21', '274')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Campo Elías', 'José Luis Torrealba', 'Alcalde de Campo Elías', 'Calle Comercio, frente a la Plaza Bolívar, Edif. Municipal, Campo Elías, Edo. Trujillo', '(0272)8685118', 'No disponible.', '', '21', '275')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chejendé', 'Carmen Benítez', 'Alcaldesa de Chejendé', 'Calle Comercio, Concejo Municipal, frente a la Plaza Candelaria, Chejendé, Edo. Trujillo', '(0272)4183688', 'No disponible.', '', '21', '276')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Carache', 'Sogel Sallam', 'Alcalde de Carache', 'Av. San Juan, Concejo Municipal, frente a la Plaza Bolívar, Carache, Edo. Trujillo', '(0272)9991211', 'No disponible.', '', '21', '277')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Escuque', 'José Antonio Puche', 'Alcalde de Escuque', 'Calle Mismote, Edif. Municipal, Escuque, Edo. Trujillo', '(0271)4150809 / (0271)4154581', 'No disponible.', '', '21', '278')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Paradero', 'Denny Lameda', 'Alcalde de El Paradero', 'Calle Principal, Sede de la Prefectura, El Paradero, Edo. Trujillo', 'No disponible.', 'No disponible.', '', '21', '279')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Polonia', 'Tulio Carrillo', 'Alcalde de Santa Polonia', 'Calle La Misión, Concejo Municipal, Santa Polonia, Edo. Trujillo', 'No disponible.', 'No disponible.', '', '21', '280')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Monte Carmelo', 'Alexis Linares', 'Alcalde de Monte Carmelo', 'Calle Principal, Concejo Municipal, Monte Carmelo, Edo. Trujillo', '(0271)4152555 / (0271)4152550', 'No disponible.', '', '21', '281')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pampan', 'Oswaldo Marín', 'Alcalde de Pampan', 'Av. El Pensil, Casa El Pensil, Pampán, Edo. Trujillo', '(0272)6781903 / (0272)6781272', 'No disponible.', '', '21', '282')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Pampanito', 'Leonel Ruíz', 'Alcalde de Pampanito', 'Av. Bolívar con Calle Colón, Casa No. 03, frente a la Plaza Bolívar, Pampanito, Edo. Trujillo', '(0272)6711759', 'No disponible.', '', '21', '283')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Carvajal', 'Marcos Montilla', 'Alcalde de Carvajal', 'Av. Principal Amparo, Casa Municipal, San Rafael de Carvajal, Edo. Trujillo', 'No disponible.', 'No disponible.', '', '21', '284')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Betijoque', 'Marcos Montilla', 'Alcalde de Betijoque', 'Av. 5 de Julio, Edif. Centro Administrativo, Betijoque, Edo. Trujillo', '(0271)6632138 / (0271)6632607', 'No disponible.', '', '21', '285')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sabana de Mendoza', 'Edubijes Torres', 'Alcalde de Sabana de Mendoza', 'Calle Bolívar, Junta Comunal, Sabana de Mendoza, Edo. Trujillo', 'No disponible.', 'No disponible.', '', '21', '286')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Trujillo', 'Luz Castillo', 'Alcaldesa de Trujillo', 'Av. Bolívar con calle Miranda, Edif. Concejo Municipal, Trujillo, Edo. Trujillo', '(0272)2364445 / (0272)4146366', 'No disponible.', '', '21', '287')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de La Quebrada', 'Hugo Andara', 'Alcalde de La Quebrada', 'Calle Sucre, Concejo Municipal, frente a la Plaza Bolívar, La Quebrada, Edo. Trujillo', '(0271)8851083 / (0271)8851074', 'No disponible.', '', '21', '288')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Valera', 'Temistocles Cabezas', 'Alcalde de Valera', 'Av. 11, Palacio Municipal, Valera, Edo. Trujillo', '(0271)2214971 / (0271)2210857', 'No disponible.', '', '21', '289')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Vargas', 'Alexis Toledo', 'Alcalde de Vargas', 'Casa Guipuzcoana, Av. Soublette, La Guaira', '(0212)3323014 / (0212)3316365 / Fax: (0212)3219205', 'No disponible.', '', '22', '290')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Pablo', 'Francisco Daza', 'Alcalde de San Pablo', '2da. Av. con calle 7, Concejo Municipal, San Pablo, Edo. Yaracuy', '(0254)5565052', 'No disponible.', '', '23', '291')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Aroa', 'Nicolás Rivas', 'Alcalde de Aroa', 'Entrada Principal de Aroa, Concejo Municipal, Aroa, Edo. Yaracuy', '(0253)2271213 / (0253)2271266', 'No disponible.', '', '23', '292')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Chivacoa', 'Henry González', 'Alcalde de Chivacoa', 'Av. 8. Entre calle 10 y 11, frente a la Plaza Chivacoa, Edo. Yaracuy', '(0251)8515201 / (0251)8515200', 'No disponible.', '', '23', '293')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cocorote', 'Marcial Valenzuela', 'Alcalde de Cocorote', 'Av. Páez, entre calle 9 y 10, Edif. Doña Tula, Edo. Yaracuy', '(0254)2323566 / (0254)2323466 / (0254)2321710', 'No disponible.', '', '23', '294')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Independencia', 'Argenis Alvarado', 'Alcalde de Independencia', 'Calle 29 con Esquina de la Avenida 04, frente a la Plaza Antonio José de Sucre, Municipio Independencia, Edo. Yaracuy', '(0264)2320301 / (0416)6540286', 'No disponible.', '', '23', '295')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sabana de Parra', 'Carlos Puerta', 'Alcalde de Sabana de Parra', 'Av. Principal, Casa Municipal, frente a la Iglesia, Sabana de Parra, Edo. Yaracuy', '(0251)8881061', 'No disponible.', '', '23', '296')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Boraure', 'Yosmary Guevara', 'Alcaldesa de Boraure', 'Av. Páez, con calle Cementerio, frente a la Escuela Básica José Antonio Páez, Boraure, Edo. Yaracuy', '(0254)5670711 / Fax: (0254)5670014', 'No disponible.', '', '23', '297')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Yumare', 'Dilsio Scott', 'Alcalde de Yumare', 'Cruce vía San Felipe-Aroa, frente a la Farmacia La Nueva, Yumare, Edo. Yaracuy', '(0254)5781119 / (0254)5781158', 'No disponible.', '', '23', '298')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Nirgua', 'Ricardo Capella', 'Alcalde de Nirgua', 'Av. 6, entre Calles 8 y 9, frente a la Plaza Bolívar, Nirgua. Edo. Yaracuy', '(0254)5721782', 'No disponible.', '', '23', '299')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Yaritagua', 'Giovanni Parra', 'Alcalde de Yaritagua', 'Calle 10, entre carreras 19 y 20, Concejo Municipal, frente a la Plaza Bolívar, Yaritagua, Edo. Yaracuy', '(0251)4824231 / (0251)4822545 / (0251)4824080', 'No disponible.', '', '23', '300')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Felipe', 'Francisco Capdevielle', 'Alcalde de San Felipe', 'Av. 6 entre calle 10 y 11, diagonal a la Plaza Bolívar, San Felipe, Edo. Yaracuy', '(0254)2314857 / (0254)2343419 / (0254)2317656', 'No disponible.', '', '23', '301')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Guama', 'Luis Duque', 'Alcalde de Guama', 'Av. 6, entre Calles 8 y 9, frente a la Plaza Bolívar, Nirgua. Edo. Yaracuy', '(0254)5721782', 'No disponible.', '', '23', '302')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Urachiche', 'Douglas Sánchez', 'Alcalde de Urachiche', 'Carrera 3, entre calles 6 y 7, frente a la Plaza Bolívar, Urachiche, Edo. Yaracuy', 'No disponible.', 'No disponible.', '', '23', '303')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Farriar', 'César Silva', 'Alcalde de Farriar', 'Calle Principal, El Farrial, Al lado de la prefectura, San Felipe, Edo. Yaracuy', '(0254)5621050 / (0254)5621054 / (0254)5621031', 'No disponible.', '', '23', '304')");
		
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Timoteo', 'Jarvis Rondón', 'Alcalde de San Timoteo', 'Av. Bolívar, frente a la plaza Urdaneta. San Timoteo. Edo. Zulia', '(0267)9703051', 'No disponible.', '', '24', '305')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Cabimas', 'Félix Bracho', 'Alcalde de Cabimas', 'Centro Cívico, Edif. El Rosario, Cabimas, Edo. Zulia', '(0264)2412769 / (0264)2613840 / (0264)2411808', 'No disponible.', '', '24', '306')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Carlos del Zulia', 'María Malpica', 'Alcaldesa de San Carlos del Zulia', 'Centro Cívico de San Carlos del Zulia. Diagonal a la Iglesia de San Carlos Borromeo, Edo. Zulia', '(0275)5551292 / (0275)5552381 / Fax: (0275)5552667', 'No disponible.', '', '24', '307')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de El Chivo', 'Luis Ruda', 'Alcalde de El Chivo', 'Calle Santa Rosa, al lado de la Iglesia de Pueblo Nuevo, El Chivo, Edo. Zulia', '(0275)4146849 / Fax: (0275)4431135', 'No disponible.', '', '24', '308')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Casigua el Cubo', 'Lucia Mavarez', 'Alcaldesa de Casigua el Cubo', 'Calle Campo Rojo, Casa Carmen Salas, Casigua el Cubo, Edo. Zulia', '(0275)3534430 / (0275)3534431 / (0275)3534253', 'No disponible.', '', '24', '309')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Concepción', 'Maira Zamora', 'Alcaldesa de Concepción', 'Calle Principal, Casa Comunal, Mun. Jesús Enrique Lossada, La Concepción. Edo Zulia', '(0262)2432528 / (0262)2432376', 'No disponible.', '', '24', '310')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Ciudad Ojeda', 'Eduin Pirela', 'Alcalde de Ciudad Ojeda', 'Edif. Canaima, Concejo Municipal, Frente a la Plaza Bolívar, Ciudad Ojeda, Edo. Zulia', '(0265)6313526', 'No disponible.', '', '24', '311')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Machiques', 'Vidal Espluga', 'Alcalde de Machiques', 'Calle San Martín, Esq. Plaza Urdaneta, Edif. Concejo Municipal, Machiques, Edo. Zulia', '(0263)4513824', 'No disponible.', '', '24', '312')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Rafael del Moján', 'Luis Caldera', 'Alcalde de San Rafael del Moján', 'Av. 2, Concejo Municipal, San Rafael del Moján, Edo. Zulia', '(0262)8720129 / (0262)8720364 / (0262)8720146', 'No disponible.', '', '24', '313')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Maracaibo', 'Eveling Coromoto Trejo Álvarez', 'Alcaldesa de Maracaibo', 'Calle 96 con Av. 4 Edif. Alcaldía de Maracaibo Frente Plaza Bolívar, Maracaibo, Edo. Zulia', '(0261)7210561 / (0261)7005711 / (0261)7005736', 'http://www.alcaldiademaracaibo.gob.ve/', '', '24', '314')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Sinamaica', 'Hebert Chacón', 'Alcalde de Sinamaica', 'Av. Principal, Edif. Concejo Municipal, Frente a la Plaza Bolívar, Sinamaica, Edo. Zulia', '(0262)9593022 / (0262)9593133', 'No disponible.', '', '24', '315')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Villa del Rosario', 'Olegario Martínez', 'Alcalde de Villa del Rosario', 'Av. El Muro, Casa Municipal, Al lado de la Inspectoría de Tránsito, Bachaquero, Edo. Zulia', '(0267)4147678 / Fax: (0267)3521718', 'No disponible.', '', '24', '316')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de San Francisco', 'Omar Prieto', 'Alcalde de San Francisco', 'Urb. San Francisco, Calle No. 158, al lado de la Farmacia Canaima, San Francisco, Edo. Zulia', '(0261)7363498', 'No disponible.', '', '24', '317')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Santa Rita', 'Andry Oviedo', 'Alcalde de Santa Rita', 'Av. Principal, Edif. El Concejo, Santa Rita, Edo. Zulia', '(0264)9340460', 'No disponible.', '', '24', '318')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Tía Juana', 'Gustavo Torres', 'Alcalde de Tía Juana', 'Av. Intercomunal, Sector Las Palmas, al lado de la Tasca Bergel, Tía Juana, Edo. Zulia', 'No disponible.', 'No disponible.', '', '24', '319')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Bobures', 'Jorge Barboza', 'Alcalde de Bobures', 'Av. Principal, Edif. Sede Poderes Públicos, frente a la Plaza Sucre, Bobures, Edo. Zulia', '(0271)7791064', 'No disponible.', '', '24', '320')");
		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de Bachaquero', 'Javier Briceño', 'Alcalde de Bachaquero', 'Av. El Muro, Casa Municipal, al lado de la Inspectoría de Tránsito, Bachaquero, Edo. Zulia', '(0267)4147678 / Fax: (0267)3521718', 'No disponible.', '', '24', '321')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + POWERS);
		db.execSQL("DROP TABLE IF EXISTS " + STATES);
		db.execSQL("DROP TABLE IF EXISTS " + MUNICIPALITIES);
		db.execSQL("DROP TABLE IF EXISTS " + AGENCIES);
		db.execSQL("DROP TABLE IF EXISTS " + PROCEDURES);
		db.execSQL("DROP TABLE IF EXISTS " + MAYORALTIES);
		onCreate(db);
	}
}