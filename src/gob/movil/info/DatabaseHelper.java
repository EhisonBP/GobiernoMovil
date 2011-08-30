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
	private static final int DB_VERSION = 26;
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + POWERS + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL("CREATE TABLE " + STATES + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL(INSERT + STATES + " VALUES (null, 'Distrito Capital')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Amazonas')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Anzoátegui')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Apure')"); 
		db.execSQL(INSERT + STATES + " VALUES (null, 'Aragua')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Barinas')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Bolívar')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Carabobo')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Cojedes')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Delta Amacuro')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Falcón')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Guárico')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Lara')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Mérida')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Miranda')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Monagas')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Nueva Esparta')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Portuguesa')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Sucre')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Táchira')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Trujillo')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Vargas')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Yaracuy')");
		db.execSQL(INSERT + STATES + " VALUES (null, 'Zulia')");
		
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
		
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Alberto Arvelo Torrealba', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Andrés Eloy Blanco', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Antonio José de Sucre', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Arismendi', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " VALUES (null, 'Barinas', '6')");
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
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Alimentación', 'Félix Osorio Guzmán', 'Ministro del Poder Popular para la Alimentación', 'No disponible', 'No disponible.', 'http://www.minpal.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Ambiente', 'Alejandro Hitcher', 'Ministro del Poder Popular para el Ambiente', 'Centro Simón Bolivar, Torre Sur, Plaza Caracas', '(0212)4081111', 'http://www.minamb.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Banca Pública', 'Humberto Rafael Ortega Díaz', 'Ministro de Estado para la Banca Pública', 'No disponible', 'No disponible.', 'No disponible.', '', '1', '1')");
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
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Relaciones Exteriores', 'Nicolás Maduro Moros', 'Ministro del Poder Popular para las Relaciones Extranjeras', 'No disponible', 'No disponible.', 'No disponible.', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Relaciones Interiores y Justicia', 'Tareck El Aissami', 'Ministro del Poder Popular para las Relaciones de Interior y Justicia', 'Av. Urdaneta, Esquina Platanal', '(0212)5061111', 'http://www.mij.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Salud', 'Eugenia Sader Castellanos', 'Ministra del Poder Popular para la Salud', 'Av. Baralt, Centro Simón Bolívar, Edif. Sur, El Silencio, Caracas', '(0212)4080000', 'http://www.mpps.gob.ve/\nCorreo: mpps@mpps.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Trabajo y Seguridad Social', 'María Cristina Iglesias', 'Ministra del Poder Popular del Trabajo y Seguridad Social', 'Centro Simón Bolívar. Torre Sur. Piso 5. Caracas', '(0212)4084222 / (0212)4084229 / (0212)4084234', 'http://www.minpptrass.gob.ve\nCorreo: maria.cristina@minpptrass.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Transporte y Comunicaciones', 'Francisco Garcés', 'Ministro del Poder Popular para Transporte y Comunicaciones', 'Torre MTC, Municipio Chacao. Distrito Capital', '(0212)2015042', 'http://www.mtc.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Turismo', 'Alejandro Fleming', 'Ministro del Poder Popular para el Turismo', 'Av. Francisco de Miranda con Av. Principal la Floresta Edif. MINTUR, Municipio Chacao', '(0212)2084651 / (0212)2084652', 'http://www.mintur.gob.ve/', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Procuraduría General de la República', 'Dra. Margarita Luisa Mendola Sánchez', 'Procuradora General de la República', 'Av. Los Ilustres, cruce con calle Francisco Lazo Martí, Edif. Sede Procuraduría General de la República, Urb. Santa Mónica - Caracas', '(0212)5973300 / (0212)5973903', 'http://www.pgr.gob.ve', '', '1', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia', 'Luis Fernando Soto Rojas', 'Presidente de la Asamblea Nacional', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Primera Vicepresidencia', 'Aristóbulo Isturiz', 'Primer Vicepresidente', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Segunda Vicepresidencia', 'Blanca Eekhout', 'Segunda Vicepresidenta', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Secretaría', 'Iván Zerpa', 'Secretario', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Subsecretaría', 'Victor Clark', 'Subsecretario', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia', 'Luisa Estella Morales Lamuño', 'Presidenta del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019932', 'http://www.tsj.gov.ve\nCorreo: luisa.morales@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Primera Vicepresidencia', 'Omar Mora Díaz', 'Primer Vicepresidente del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019223', 'http://www.tsj.gov.ve\nCorreo: omar.mora@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Segunda Vicepresidencia', 'Jhannett María Madríz Sotillo', 'Segunda Vicepresidenta del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019633', 'http://www.tsj.gov.ve\nCorreo: jhannett.madriz@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Sala Político-Administrativa', 'Evelyn Margarita Marrero Ortíz', 'Magistrada Presidenta de la Sala Político-Administrativa', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019823', 'http://www.tsj.gov.ve\nCorreo: evelyn.marrero@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Sala de Casación Civil', 'Yris Armenia Peña de Andueza', 'Magistrada Presidenta de la Sala de Casación Civil', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019620', 'http://www.tsj.gov.ve\nCorreo: iris.pena@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Sala de Casación Penal', 'Ninoska Queipo Briceño', 'Magistrada Presidenta de la Sala de Casación Penal', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019419', 'http://www.tsj.gov.ve\nCorreo: ninoska.queipo@tsj.gov.ve', '', '3', '1')");
		
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Presidencia', 'Tibisay Lucena', 'Presidenta del Consejo Nacional Electoral\nPresidenta de la Junta Nacional Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " VALUES (null, 'Vicepresidencia', 'Sandra Oblitas Ruzza', 'Vicepresidenta del Consejo Nacional Electoral\nPresidenta de la Comisión de Registro Civil y Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
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
		
//		db.execSQL(INSERT + MAYORALTIES + " VALUES (null, 'Alcaldía de ', '', '', '', '', '', '', '1', '1')");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.v(POWERS, "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + POWERS);
		android.util.Log.v(STATES, "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + STATES);
		android.util.Log.v(MUNICIPALITIES, "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + MUNICIPALITIES);
		android.util.Log.v(AGENCIES, "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + AGENCIES);
		android.util.Log.v(PROCEDURES, "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + PROCEDURES);
		android.util.Log.v(MAYORALTIES, "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + MAYORALTIES);
		onCreate(db);
	}
}