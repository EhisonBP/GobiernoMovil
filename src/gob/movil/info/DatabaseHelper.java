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
	private static final int DB_VERSION = 1;
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + POWERS + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL("CREATE TABLE " + STATES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
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
		
		db.execSQL("CREATE TABLE " + MUNICIPALITIES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, state INTEGER NOT NULL, FOREIGN KEY(state) REFERENCES states(_id))");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Baruta', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Chacao', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Distrito Metropolitano', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('El Hatillo', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '1')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '1')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Alto Orinoco', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Atabapo', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Atures', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Autana', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guainía', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Manapiare', '2')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Río Negro', '2')");

		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Anaco', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Aragua', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bruzual', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cajigal', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Carvajal', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Freites', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guanta', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertad', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Lic. Diego Bautista Urbaneja', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('McGregor', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Monagas', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Peñalver', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San José de Guanipa', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Juan de Capistrano', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santa Ana', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Simón Rodríguez', '3')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sotillo', '3')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Achaguas', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Alto Apure', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Biruaca', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Muñoz', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Páez', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pedro Camejo', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rómulo Gallegos', '4')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Fernando', '4')");

		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Antonio José de Sucre', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Atanasio Girardot', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Camatagua', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ezequiel Zamora', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Francisco Linares Alcántara', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José Ángel Lamas', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José Félix Ribas', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José Rafael Revenga', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mario Briceño Iragorry', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ocumare de la Costa de Oro', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rafael Guillermo Urdaneta', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Casimiro', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Sebastián de los Reyes', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santiago Mariño', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santos Michelena', '5')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tovar', '5')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Alberto Arvelo Torrealba', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Eloy Blanco', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Antonio José de Sucre', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Arismendi', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Barinas', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cruz Paredes', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Obispos', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pedraza', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rojas', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sosa', '6')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Zamora', '6')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Caroní', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cedeño', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('El Callao', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Gran Sabana', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Heres', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Padre Pedro Chien', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Piar', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Raúl Leoni', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Roscio', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sifontes', '7')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '7')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bejuma', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Carlos Arvelo', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Diego Ibarra', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guacara', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Juan José Mora', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Los Guayos', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Miranda', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Montalbán', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Naguanagua', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Puerto Cabello', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Diego', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Joaquín', '8')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Valencia', '8')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Falcón', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Lima Blanco', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ricaurte', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rómulo Gallegos', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Carlos', '9')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tinaco', '9')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Antonio Díaz', '10')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Casacoima', '10')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pedernales', '10')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tucupita', '10')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Acosta', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Buchivacoa', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cacique Manaure', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Carirubana', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Colina', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Dabajuro', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Democracia', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Falcón', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Federación', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Jacura', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Los Taques', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mauroa', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Monseñor Iturriza', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Palmasola', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Petit', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Píritu', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Francisco', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Silva', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tocópero', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Urumaco', '11')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Zamora', '11')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Camaguán', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Chaguaramas', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('El Socorro', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Infante', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Las Mercedes', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mellado', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Miranda', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Monagas', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ortíz', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ribas', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Roscio', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Gerónimo de Guayabal', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San José de Guaribe', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santa María de Ipire', '12')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Zaraza', '12')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Crespo', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Iribarren', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Jiménez', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Morán', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Palavecino', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Simón Planas', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Torres', '13')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Urdaneta', '13')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Acarigua', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Bello', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Antonio Pinto Salinas', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Arzobispo Chacón', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Campo Elías', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Caracciolo Parra', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cardenal Quintero', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guaraque', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Julio César Salas', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Miranda', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Obismo Ramos de Lora', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Padre Noguera', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pueblo Llano', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rangel', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rivas Dávila', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santos Marquina', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tovar', '14')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tulio Febres Cordero', '14')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Acevedo', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Bello', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Baruta', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Brión', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Buroz', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Chacao', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cristóbal Rojas', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('El Hatillo', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guaicaipuro', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Independencia', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Los Salias', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Páez', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Paz Castillo', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pedro Gual', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Plaza', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Simón Bolívar', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tomás Lander', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Urdaneta', '15')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Zamora', '15')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Acosta', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Aguasay', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Caripe', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cedeño', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ezequiel Zamora', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Maturín', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Piar', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Punceres', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santa Bárbara', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sotillo', '16')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Uracoa', '16')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Antolín del Campo', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Arismendi', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Díaz', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('García', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Gómez', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Maneiro', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Marcano', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mariño', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Península de Macanao', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Tubores', '17')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Villalba', '17')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Agua Blanca', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Araure', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Boconoíto', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Esteller', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guanare', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guanarito', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Monseñor José Vicente de Unda', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ospino', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Papelón', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Rafael de Onoto', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santa Rosalía', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '18')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Turén', '18')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Eloy Blanco', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Mata', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Arismendi', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Benítez', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bermúdez', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cajigal', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cruz Salmerón Acosta', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mariño', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mejías', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Montes', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ribero', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '19')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Valdés', '19')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Bello', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Antonio Acosta', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Ayacucho', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cárdenas', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Córdova', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Fernández Feo', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Francisco Miranda', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('García de Hevia', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Guásimos', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Independencia', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Jáuregui', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José María Vargas', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Junín', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Libertador', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Lobatera', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Michelena', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Panamericano', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pedro María de Ureña', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rafael Urdaneta', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Samuel Darío Maldonado', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Cristóbal', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Judas Tadeo', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Seboruco', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Simón Rodríguez', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Torbes', '20')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Uribante', '20')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Andrés Bello', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Boconó', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Campo Elías', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Candelaria', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Carache', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Escuque', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José Felipe Márquez Cañizalez', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('La Ceiba', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Monte Carmelo', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pampán', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Pampanito', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Rafael', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Rafael de Carvajal', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Trujillo', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Urdaneta', '21')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Valera', '21')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Vargas', '22')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Arístides Bastidas', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bolívar', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Bruzual', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cocorote', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Independencia', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José Antonio Páez', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('La Trinidad', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Manuel Monge', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Nirgua', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Peña', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Felipe', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Urachiche', '23')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Veroes', '23')");
		
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Baralt', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Cabimas', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Colón', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Francisco Javier Pulgar', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('José María Semprum', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('La Cañada de Urdaneta', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Lagunillas', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Machique de Perijá', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Mara', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Maracaibo', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Páez', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Rosario de Perijá', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('San Francisco', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Santa Rita', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Simón Bolívar', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Sucre', '24')");
		db.execSQL(INSERT + MUNICIPALITIES + " (name, state) VALUES ('Valmore Rodríguez', '24')");
		
		db.execSQL("CREATE TABLE " + AGENCIES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, officer STRING, office STRING, address TEXT, phone STRING, web STRING, twitter STRING, power INTEGER NOT NULL, state INTEGER NOT NULL, FOREIGN KEY(power) REFERENCES powers(_id), FOREIGN KEY(state) REFERENCES states(_id))");
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Presidencia de la República', 'Hugo Rafael Chávez Frías', 'Presidente de la República', 'Palacio de Miraflores', 'No disponible.', 'http://www.chavez.org.ve', '@chavezcandanga', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Vicepresidencia de la República', 'Elías José Jaua Milano', 'Vicepresidente de la República', 'Av. Urdaneta. Esquina de Carmelitas. Caracas', '(0212)8603335 / (0212)8608822', 'http://www.vicepresidencia.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Asuntos de la Mujer e Igualdad de Género', 'Nancy Pérez Sierra', 'Ministra de Estado para Asuntos de la Mujer e Igualdad de Género', 'Av. Lecuna, Parque Central, Torre Este Piso 4, Caracas', 'No disponible.', 'http://www.minmujer.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Agricultura y Tierras', 'Juan Carlos Loyo', 'Ministro del Poder Popular de Agricultura y Tierras', 'Av. Urdaneta entre esquina Platanal a Candilito a media cuadra de la Plaza La Candelaria, parroquia La Candelaria', '(0800)2474285', 'http://www.mat.gob.ve\nCorreo: atencionintegralalsoberano@gmail.com', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Alimentación', 'Félix Osorio Guzmán', 'Ministro del Poder Popular para la Alimentación', 'No disponible', 'No disponible.', 'http://www.minpal.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Ambiente', 'Alejandro Hitcher', 'Ministro del Poder Popular para el Ambiente', 'Centro Simón Bolivar, Torre Sur, Plaza Caracas', '(0212)4081111', 'http://www.minamb.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Banca Pública', 'Humberto Rafael Ortega Díaz', 'Ministro de Estado para la Banca Pública', 'No disponible', 'No disponible.', 'No disponible.', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Ciencia, Tecnología e Industrias Intermedias', 'Ricardo Menéndez', 'Ministro del Poder Popular para la Ciencia, Tecnología e Industrias Intermedias', 'Av. Universidad. Esquina El Chorro. Torre Ministerial. La Hoyada, Caracas', '(0212)5557401 / (0212)5557402 / (0212)5557403 / (0212)5557404 / (0212)5557405 / (0212)5557406 / (0212)5557407 / (0212)5557408 / (0212)5557409 / (0212)5557410 / Fax: (0212)5557504', 'http://www.mct.gob.ve\nCorreo: mcti@mcti.gob.ve', '@mcti', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Comercio', 'Richard Canan', 'Ministro del Poder Popular para el Comercio', 'Av. Lecuna, Torre Oeste de Parque Central, Entrada por el Nivel Lecuna', '(0212)5096861', 'http://www.mincomercio.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Comunas', 'Isis Ochoa', 'Ministra del Poder Popular para las Comunas', 'Av. Nueva Granada. Edificio INCES, Sede. Caracas - Venezuela', '(0212)6032396 / (0212)6032397', 'http://www.mpcomunas.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Comunicación y la Información', 'Andrés Izarra', 'Ministro del Poder Popular para la Comunicación y la Información', 'Av. Universidad, Torre Ministerial, pisos 9 y 10', '(0212)5053322', 'http://www.minci.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Cultura', 'Francisco Sesto', 'Ministro del Poder Popular para la Cultura', 'Av. Panteón, Foro Libertador, Edif. Archivo General de la Nación, PB', '(0212)5095600', 'http://www.ministeriodelacultura.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Defensa', 'Carlos Mata Figueroa', 'Ministro del Poder Popular de la Defensa', 'Fuerte Tiuna. Caracas', 'No disponible.', 'http://www.mindefensa.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Deporte', 'Hector Rodríguez Castro', 'Ministro del Poder Popular para el Deporte', 'Av. Teherán, Sede Principal del Ministerio del Poder Popular para el Deporte, S/N, Urbanización Montalbán, La Vega, Caracas, Distrito Capital', '(0212)4432682 / (0212)4723224', 'http://www.mindeporte.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Despacho de la Presidencia', 'Francisco José Ameliach Orta', 'Ministro del Poder Popular para el Despacho de la Presidencia', 'Final Av. Urdaneta, Esq. de Bolero, Palacio de Miraflores, Caracas', '(0212)8063111 / (0212)8063229', 'http://www.presidencia.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Educación Universitaria', 'Yadira Córdova', 'Ministra del Poder Popular para la Educación Universitaria', 'Av. Universidad. Esq. El Chorro, Torre Ministerial, pisos: 1-7, Caracas', '(0212)5965270 / (0212)5965274 / Fax: (0212)5965261', 'http://www.mes.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Educación', 'Maryann Hanson', 'Ministra del Poder Popular para la Educación', 'Esq. de Salas a Caja de Agua, Edif. Sede del MPPE Parroquia Altagracia, Caracas', '(0212)5964111', 'http://www.me.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Energía Eléctrica', 'Alí Rodríguez Araque', 'Ministro del Poder Popular para la Energía Eléctrica', 'Av Tamanaco, Urb. El Rosal, Municipio Chacao, Código Postal 1060, Estado Miranda', 'No disponible.', 'http://www.mppee.gob.ve', '', '1', '15')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Energía y Petróleo', 'Rafael Ramírez', 'Ministro del Poder Popular de Energía y Petróleo', 'Edificio Pétroleos de Venezuela, Torre Oeste, Av. Libertador con Av. Empalme, Urbanización La Campiña, Parroquia El Recreo. Caracas', '(0212)7087631 / (0212)7087338 / Fax: (0212)7087598', 'http://www.pdvsa.com', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Industrias Básicas y la Minería', 'José Khan Fernández', 'Ministro del Poder Popular para las Industrias Básicas y la Minería', 'Av. La Estancia, Torre las Mercedes, piso 9, Urb. Chuao, Caracas', '(0212)9500311', 'http://www.mibam.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Obras Públicas y Vivienda', 'Ricardo Colina', 'Ministro del Poder Popular para las Obras Públicas y Vivienda', 'Av. Francisco de Miranda, Torre de Los Dos Ministerios, Municipio Chacao, Edo. Miranda', '(0212)2668625 / (0212)2069517 / (0212)2069519 / Fax: (0212)2654644', 'http://www.mvh.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Planificación y Desarrollo', 'Jorge Giordani', 'Ministro del Poder Popular para la Planificación y Desarrollo', 'Av. Urdaneta, con esquina de Carmelitas, Edificio Sede del Ministerio del Poder Popular de Planificación y Finanzas. Caracas', '(0212)8021000', 'http://www.mf.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Pueblos Indígenas', 'Nicia Maldonado', 'Ministra del Poder Popular para los Pueblos Indígenas', 'Av. Universidad Esq. Traposos, Antiguo Edificio Sudeban, Piso 8. Caracas', '(0212)5431599', 'http://www.minpi.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Relaciones Exteriores', 'Nicolás Maduro Moros', 'Ministro del Poder Popular para las Relaciones Extranjeras', 'No disponible', 'No disponible.', 'No disponible.', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Relaciones Interiores y Justicia', 'Tareck El Aissami', 'Ministro del Poder Popular para las Relaciones de Interior y Justicia', 'Av. Urdaneta, Esquina Platanal', '(0212)5061111', 'http://www.mij.gov.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Salud', 'Eugenia Sader Castellanos', 'Ministra del Poder Popular para la Salud', 'Av. Baralt, Centro Simón Bolívar, Edif. Sur, El Silencio, Caracas', '(0212)4080000', 'http://www.mpps.gob.ve/\nCorreo: mpps@mpps.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Trabajo y Seguridad Social', 'María Cristina Iglesias', 'Ministra del Poder Popular del Trabajo y Seguridad Social', 'Centro Simón Bolívar. Torre Sur. Piso 5. Caracas', '(0212)4084222 / (0212)4084229 / (0212)4084234', 'http://www.minpptrass.gob.ve\nCorreo: maria.cristina@minpptrass.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Transporte y Comunicaciones', 'Francisco Garcés', 'Ministro del Poder Popular para Transporte y Comunicaciones', 'Torre MTC, Municipio Chacao. Distrito Capital', '(0212)2015042', 'http://www.mtc.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Turismo', 'Alejandro Fleming', 'Ministro del Poder Popular para el Turismo', 'Av. Francisco de Miranda con Av. Principal la Floresta Edif. MINTUR, Municipio Chacao', '(0212)2084651 / (0212)2084652', 'http://www.mintur.gob.ve/', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Procuraduría General de la República', 'Dra. Margarita Luisa Mendola Sánchez', 'Procuradora General de la República', 'Av. Los Ilustres, cruce con calle Francisco Lazo Martí, Edif. Sede Procuraduría General de la República, Urb. Santa Mónica - Caracas', '(0212)5973300 / (0212)5973903', 'http://www.pgr.gob.ve', '', '1', '1')");
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Presidencia', 'Luis Fernando Soto Rojas', 'Presidente de la Asamblea Nacional', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Primera Vicepresidencia', 'Aristóbulo Isturiz', 'Primer Vicepresidente', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Segunda Vicepresidencia', 'Blanca Eekhout', 'Segunda Vicepresidenta', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Secretaría', 'Iván Zerpa', 'Secretario', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Subsecretaría', 'Victor Clark', 'Subsecretario', 'Av. Este 6, Esq. de Pajaritos, Edif. José María Vargas. Caracas', 'No disponible.', 'No disponible.', '', '2', '1')");
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Presidencia', 'Luisa Estella Morales Lamuño', 'Presidenta del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019932', 'http://www.tsj.gov.ve\nCorreo: luisa.morales@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Primera Vicepresidencia', 'Omar Mora Díaz', 'Primer Vicepresidente del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019223', 'http://www.tsj.gov.ve\nCorreo: omar.mora@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Segunda Vicepresidencia', 'Jhannett María Madríz Sotillo', 'Segunda Vicepresidenta del Tribunal Supremo de Justicia', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019633', 'http://www.tsj.gov.ve\nCorreo: jhannett.madriz@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Sala Político-Administrativa', 'Evelyn Margarita Marrero Ortíz', 'Magistrada Presidenta de la Sala Político-Administrativa', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019823', 'http://www.tsj.gov.ve\nCorreo: evelyn.marrero@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Sala de Casación Civil', 'Yris Armenia Peña de Andueza', 'Magistrada Presidenta de la Sala de Casación Civil', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019620', 'http://www.tsj.gov.ve\nCorreo: iris.pena@tsj.gov.ve', '', '3', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Sala de Casación Penal', 'Ninoska Queipo Briceño', 'Magistrada Presidenta de la Sala de Casación Penal', 'Final Av. Baralt, Esq. de Dos Pilitas. Caracas', '(0212)8019419', 'http://www.tsj.gov.ve\nCorreo: ninoska.queipo@tsj.gov.ve', '', '3', '1')");
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Presidencia', 'Tibisay Lucena', 'Presidenta del Consejo Nacional Electoral\nPresidenta de la Junta Nacional Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Vicepresidencia', 'Sandra Oblitas Ruzza', 'Vicepresidenta del Consejo Nacional Electoral\nPresidenta de la Comisión de Registro Civil y Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Presidencia de la Comisión de Participación Política y Financiamiento', 'Vicente José Gregorio Díaz Silva', 'Presidente de la Comisión de Participación Política y Financiamiento', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Comisión de Participación Política y Financiamiento', 'Socorro Elizabeth Hernández Hernández', 'Miembro de la Comisión de Participación Política y Financiamiento', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Junta Nacional Electoral', 'Tania D´ Amelio Cardiet', 'Miembro de la Junta Nacional Electoral\nMiembro de la Comisión de Registro Civil y Electoral', 'Centro Simón Bolívar, Edif. Sede del Consejo Nacional Electoral, frente a la Plaza Caracas. Caracas', '(0212)4085200', 'http://www.cne.gov.ve', '', '4', '1')");
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Contraloría General de la República', 'Clodosbaldo Russián Uzcátegui', 'Contralor General de la República', 'Av. Andrés Bello. Edif. Contraloría General de la República, Caracas', '(0212)5083111 / (0212)5083000', 'http://www.cgr.gob.ve', '', '5', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Defensoría del Pueblo', 'Gabriela Ramírez', 'Defensora del Pueblo', 'Av. México, Plaza Morelos, Edif. Defensoría del Pueblo, piso 8, frente al Ateneo. Caracas', '(0212)5754703 / (0212)5755103 / Fax: (0212)5754467', 'http://www.defensoria.gob.ve', '', '5', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Fiscalía - Ministerio Público', 'Dra. Luisa Ortega Díaz', 'Fiscal General de la República', 'Edificio Sede del Despacho de la Fiscal General de la República, esquina de Misericordia a Pele El Ojo, Av. México, Caracas', '(0212)5097211 / (0212)5097464', 'No disponible.', '', '5', '1')");
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Armada', 'Almirante Carlos Máximo Aniasi Turchio', 'Comandante General de la Armada', 'Meseta de Mamo, Catia La Mar, La Guaira, Vargas', '(0212)3512151', 'http://www.armada.mil.ve', '', '8', '22')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('CICPC', 'Wilmer Flores Trocel', 'Director General del Cuerpo de Investigaciones Científicas, Penales y Criminalísticas', 'Sede Principal - Av. Urdaneta, de Pelota a Punceres Edif. CICPC', '(0800)2427224', 'http://www.cicpc.gov.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Cuerpo de Bomberos D.C.', 'Cdmte. Gral. (B) Ángel William Martínez', 'Primer Comandante de la Institución', 'Avenida Lecuna con Esquina El Rosario, Edificio Cuartel Central de Bomberos \"Victoriano Jordán Pestana\", Municipio Libertador, Distrito Capital', '(0212)5422512 / (0212)5450066', 'http://www.bomberoscaracas.gov.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Cuerpo de Policía Nacional Bolivariana', 'Luis Ramón Fernández Delgado', 'Director General del Cuerpo de Policía Nacional Bolivariana', 'Sede Principal - Edif. Radio City, Bulevar de Sabana Grande, Caracas', '(0800)7654622', 'http://www.policianacional.gob.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Ejército', 'Euclides Amador Campos Aponte', 'Comandante General del Ejército', 'El Valle, Fuerte Tiuna, Caracas', '(0212)6055454 / (0212)6055107', 'http://www.ejercito.mil.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Fuerza Aérea', 'Mayor General Jorge Arevalo Oropeza Pernalete', 'Comandante General de la Aviación Militar Nacional Bolivariana', 'Carretera Nacional vía Maracay - Mariara, sector Boca de Río, Escuela de Aviación Militar Bolivariana, Maracay, Aragua', '(0243)5118710', 'http://www.aviacion.mil.ve', '', '8', '5')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Guardia Nacional Bolivariana', 'Mayor General Luis Alfredo Motta Domínguez', 'Comandante General de la Guardia Nacional Bolivariana', 'Quinta las Acacias, el Paraíso, Caracas', '(0212)4063001 / (0212)4063002 / (0212)4063004', 'http://www.guardia.mil.ve', '', '8', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Policía Metropolitana', 'Carlos Meza', 'Director de la Policía Metropolitana', 'Sector San José, Comandancia General, Cotiza', '171', 'http://www.policianacional.gob.ve', '', '8', '1')");
		
		//Gobernaciones
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Distrito Capital', 'Jackeline Farías', 'Gobernadora del Distrito Capital', 'Esq. Principal, frente a la Plaza Bolívar, Edif. Palacio de Gobierno, El Silencio, Caracas', '(0212)8632998', 'http://www.gdc.gob.ve', '', '6', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Amazonas', 'Lobirio Guarulla', 'Gobernador del Estado Amazonas', 'Av. Río Negro, Casa de Gobierno. Puerto Ayacucho. Edo. Amazonas', '(0248)5210249 / (0248)5212859', 'No disponible.\nCorreo: sprivada@amazonas.gob.ve', '', '6', '2')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Anzóategui', 'Tarek William Saab', 'Gobernador del Estado Anzóategui', 'Palacio de Gobierno Piso N° 4. Barcelona, Edo. Anzoátegui', '(0281)2701401 / (0281)2701402 / (0281)2701403 / (0281)2701404 / Fax: (0281)2751671 / (0281)2701401 / (0281)2701402 / (0281)2701403 / (0281)2701404', 'No disponible.\nCorreo: tarek@gobernaciondeanzoategui.com', '', '6', '3')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Apure', 'Ramón Carrizales', 'Secretario General del Gobierno de Apure', 'Edificio Administrativo del Ejecutivo, calle Comerico, entre Piar y Madariaga, San Fernando de Apure', '(0247)3410156 / (0247)3411114 / (0247)3413048 / (0247)3413865', 'No disponible.\nCorreo: gobernacionapure@yahoo.com', '', '6', '4')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Aragua', 'Rafael Isea', 'Gobernador del Estado Aragua', 'Av. Miranda frente a la Plaza Bolívar Palacio de Gobierno. Maracay. Edo. Aragua', '(0243)2335646 / (0243)2331134 / Fax: (0234)2337767 / (0234)2337002', 'No disponible.', '', '6', '5')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Barinas', 'Adán Coromoto Chávez', 'Gobernador del Estado Barinas', 'Palacio del Marqués, frente a la Plaza Bolívar, Barinas, Edo. Barinas', '(0273)5301111 / (0273)5301131', 'No disponible.', '', '6', '6')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Bolívar', 'Francisco Rangel Gómez', 'Gobernador del Estado Bolívar', 'Calle Constitución. Palacio de Gobierno frente a la Plaza Bolívar. Ciudad Bolívar. Edo. Bolívar', '(0285)6002110 / (0285)6002111 / (0285)6002126 / (0285)6002127 / Fax: (0285)6002285 / (0285)6002356', 'http://www.e-bolivar.gov.ve', '', '6', '7')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Carabobo', 'Henrique Salas Feo', 'Gobernador del Estado Carabobo', 'Calle Páez entre Av. Montes de Oca y Av. Díaz Moreno, Capitolio de Valencia. Edo. Carabobo', '(0241)8742951 / Fax: (0241)8570783', 'http://www.carabobo.gob.ve', '', '6', '8')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Cojedes', 'Teodoro Bolívar', 'Gobernador del Estado Cojedes', 'Av. Sucre. Palacio de Gobierno. San Carlos. Edo. Cojedes', '(0258)4330969 / (0258)4330207 / (0258)4330533 / Fax: (0258)4336704', 'No disponible.', '', '6', '9')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Delta Amacuro', 'Lizeta Hernández', 'Gobernadora del Estado Delta Amacuro', 'Calle Bolívar. Casa de Gobierno. Tucupita. Edo. Delta Amacuro', 'No disponible.', 'http://www.deltamacuro.gob.ve', '', '6', '10')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Falcón', 'Stella Lugo', 'Gobernadora del Estado Falcón', 'Calle Ampíes. Palacio de Gobierno. Coro. Edo. Falcón', '(0268)2530513 / (0268)2511822 / (0268)2512511 / Fax: (0268)2518004', 'http://www.falcon.gob.ve', '', '6', '11')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Guárico', 'Luis Enrique Gallardo', 'Gobernador del Estado Guárico', 'Av. Monseñor Sendrea, Palacio de Gobierno, frente a la Plaza Bolívar, San Juan de Los Morros, Edo. Guárico', '(0246)4311253 / (0246)4312922 / (0246)4313533 / (0246)4310444 / (0246)4314493 / (0246)4316294 / (0246)4318055', 'http://www.guarico.gob.ve', '', '6', '12')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Lara', 'Henry Falcón', 'Gobernador del Estado Lara', 'Carrera 19. Esq. Calle 25, Barquisimeto, Edo. Lara', '(0251)2317420 / Fax: (0251)2324631', 'http://www.lara.gob.ve', '', '6', '13')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Mérida', 'Marcos Díaz Orellana', 'Gobernador del Estado Mérida', 'Av. 4, Palacio de Gobierno, Mérida, Edo. Mérida', '(0274)2510731 / (0274)2510936 / (0274)2512713 / (0274)2510936 / (0274)2510731 / (0274)2522511 / (0274)2522713', 'http://www.merida.gob.ve', '', '6', '14')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Miranda', 'Henrique Capriles Radonski', 'Gobernador del Estado Miranda', 'Calle Guaicaipuro frente a la Plaza Bolívar, Residencia Oficial del Gobernador, Los Teques', '(0212)3213979 / (0212)3217497 / (0212)3231232', 'http://www.miranda.gov.ve', '', '6', '15')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Monagas', 'José Gregorio Briceño', 'Gobernador del Estado Monagas', 'Av. Bolívar, frente a la Plaza Bolívar, Maturín, Edo. Monagas', '(0291)6411191 / (0291)6410934 / (0291)6410791 / (0291)6411396 / (0291)6411163 / (0291)6428797', 'http://www.monagas.gob.ve', '', '6', '16')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Nueva Esparta', 'Morel Rodríguez', 'Gobernador del Estado Nueva Esparta', 'Av. Constitución - La Asunción - Municipio Arismendi. Sede Ejecutiva, Piso 1', '(0295)2659983 / (0295)2659984 / (0295)2422008 / Fax: (0295)2422503', 'http://www.nuevaesparta.gob.ve', '', '6', '17')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Portuguesa', 'Wilmar Castro Soteldo', 'Gobernador del Estado Portuguesa', 'Carrera 5ta entre calles 15 y 16, frente a la Plaza Bolívar. Guanare. Edo. Portuguesa', '(0257)2515864', 'http://www.portuguesa.gob.ve', '', '6', '18')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Sucre', 'Enrique José Maestre', 'Gobernador del Estado Sucre', 'Calle Bolívar, Casa de Gobierno, Cumaná, Edo. Sucre', '(0293)4312945 / (0293)4310103 / (0239)4320381 / (0239)4671563 / Fax: (0293)4671563', 'http://www.edosucre.gov.ve', '', '6', '19')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Táchira', 'César Pérez Vivas', 'Gobernador del Estado Táchira', 'Carrera 10, entre calles 4 y 5, Frente a la Plaza Sucre, San Cristóbal, Edo. Táchira', '(0276)5102934 / (0276)5102827 / (0276)5102828 / (0276)5102876 / (0276)5102800 / Fax: (0276)5102811 / (0276)5102800', 'http://www.tachira.gob.ve', '', '6', '20')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Trujillo', 'Hugo Cabezas', 'Gobernador del Estado Trujillo', 'Av. Independencia, Palacio de Gobierno, Trujillo, Edo. Trujillo', '(0272)2362666 / (0272)2364590 / (0272)2363555 / (0272)2366466', 'No disponible.', '', '6', '21')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Vargas', 'Jorge Luis García Carneiro', 'Gobernador del Estado Vargas', 'Av. Soublette, Casa Guipuzcoana, La Guaira, Edo. Vargas', '(0212)3310372 / (0212)3310272 / (0212)3310678 / (0212)3324743 / Fax: (0212)3311266 / (0212)3321128', 'http://www.estadovargas.gob.ve', '', '6', '22')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Yaracuy', 'Julio León', 'Gobernador del Estado Yaracuy', 'Frente a la plaza Bolívar San Felipe, Palacio de Gobierno, Edo. Yaracuy', '(0254)2313276 / (0254)2312597 / (0254)2343028', 'http://www.yaracuy.gob.ve', '', '6', '23')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Estado Zulia', 'Pablo Pérez', 'Gobernador del Estado Zulia', 'Palacio de Gobierno, calle A-5 frente a Plaza Bolívar. Maracaibo, Edo. Zulia', '(0261)7251090 / (0261)7921111 / (0261)7921150 / Fax: (0261)7251087 / (0261)7922622', 'http://www.gobernaciondelzulia.gov.ve', '', '6', '24')");
				
		db.execSQL("CREATE TABLE " + PROCEDURES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, requeriments TEXT, schedule TEXT, cost STRING, info TEXT, organism STRING)");
		
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, organism) VALUES ('Conformación de Comunas', '1. Notificar a los ciudadanos la constitución de la Comisión Promotora que conformará la comuna.\n2. Elegir la Asamblea Constitutiva.\n3. Consejo electoral Provisional.\n4. Conformar la Comisión Redactora.\n5. Realizar un referendo aprobatorio', 'No aplica', 'No aplica', 'Debe tener en cuenta las siguientes definiciones:\n\nBanco de las Comunas:\nOrganización económico-financiera de carácter social que gestiona y administra los recursos financieros, impulsando políticas económicas con la participación democrática y protagónica del pueblo.\n\nCartas Comunales:\nInstrumento donde se establecen las normas elaboradas por los habitantes de la comuna en Parlamento Comunal con el propósito de regular la vida social y comunitaria de conformidad con la Constitución Bolivariana de Venezuela.\n\nCarta Fundacional:\nInstrumento aprobado en referendo popular, donde las comunidades expresan su voluntad de constituirse en comuna.\n\nEstado Comunal:\nForma de organización político-social, fundada en el estado social de derecho y justicia establecido en la constitución, en la cual se le otorga poder al pueblo, con un modelo de propiedad social y de desarrollo endógeno sustentable.\n\nParlamento Comunal:\nMáxima instancia del autogobierno en la comuna, constituido por asambleas de ciudadanos, establecidos en cada uno de sus respectivos ámbitos territoriales', 'Ministerio del Poder Popular para las Comunas y Protección Social')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, organism) VALUES ('Legalización de Títulos Universitarios', '1. Título Original debidamente firmado y sellado por el Registro Público correspondiente (Ver Registro de Títulos Universitarios).\n2. Original del Acta de grado o Notas Certificadas.\n3. Copia de la Cédula de Identidad del titular (Si el titular no es quien entrega la documentación, deberá traer autorización por escrito y copia de CI de ambas partes)', 'Lapso de un día hábil para retirar', 'Cancelar, en timbres fiscales, Bs. 27,50 en la taquilla autorizada ubicada en dicho Ministerio, o en los siguientes bancos:\n\nBanco de Venezuela, Cuenta Corriente, N° 0102-0552-21-0000024439, a nombre de GOB. DTTO. CAPITAL ING. TIMBRES FISCALES.\n\nBanco del Tesoro, Cuenta Corriente, N° 0163-0903-62-9032000282, a nombre del GOBIERNO DEL DISTRITO CAPITAL.\n\nSi el titular posee varios documentos, puede depositar el total de los mismos en un solo depósito', 'NOTA: LOS TÍTULOS DE LAS UNIVERSIDADES PRIVADAS NO NECESITAN REALIZAR ESTE TRÁMITE YA QUE TIENEN LA FIRMA DEL MINISTRO', 'Ministerio del Poder Popular para la Educación Universitaria')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, organism) VALUES ('Licencia de Turismo', '1. Formulario de Solicitud de Trámite de Licencia de Turismo Persona Jurídica, establecido por el Ministerio del Poder Popular con competencia en Turismo, en original y dos (2) fotocopias legibles.\n2. Fotocopia legible del Oficio del Registro Turístico Nacional (RTN).\n3. Fotocopia legible de la Patente de Industria y Comercio, esto aplica en caso de haber consignado la solicitud al momento de la inscripción en el Registro Turístico Nacional.\n4. Fotocopia legible de la Póliza de Responsabilidad Civil contra daños a terceros vigente, a nombre del prestador de servicios turísticos, anexando las condiciones generales y particulares del contrato de la póliza vigente.\n5. Si el establecimiento se encuentra ubicado en un Área Bajo Régimen de Administración Especial (ABRAE), fotocopia legible del permiso o contrato de concesión correspondiente, emitida por la autoridad competente.\n6. Si el capital de la persona jurídica tiene inversión extranjera, fotocopia legible de la Constancia de Calificación de Empresas, emitidas por la Superintendencia de Inversiones Extranjeras (SIEX).\n7. Y cualquier otro documento que el Ministerio del Poder Popular con competencia en Turismo, considere necesario.\n8. Los Prestadores de Servicios Turísticos, además de los Requisitos Generales exigidos, deberán consignar los requisitos específicos para cada Tipo de Prestador (Empresas de Alojamiento Turístico, Administradoras de Empresas Turísticas, Agencias de Turismo, Transporte Turístico, Transporte Turístico Terrestre, Transporte Turístico Acuático, Transporte Turístico Aéreo, Representantes de Turismo, Representante de Transporte Turístico Terrestre, Representante de Transporte Turístico Acuático (Nacional o Internacional), Representante de Transporte Turístico Aéreo, Establecimientos Turísticos de Alimentos y Bebidas, Empresas de Recreación Turística, Empresas de Información, Promoción Publicidad y Propaganda Turística). Los requisitos específicos y formularios pueden descargarse en el vínculo del Ministerio de Turismo.\n9. La documentación se presenta en original y fotocopia. Las Fotocopias deben estar completas, visibles y legibles. Una vez confrontado y verificado el original contra la fotocopia, se devuelve el original', 'Lunes a viernes en horario de 8:30am a 12:00pm y de 1:00pm a 4:30pm', 'Gratuito', 'En Caracas puede acudir a la sede del Ministerio de Turismo en la Avenida Francisco de Miranda, Av. principal de La Floresta, frente al Colegio Universitario de Caracas. En el interior del país debe llamar antes al 0500 TURISMO (05008874766) para que le indiquen la sede a la cual debe presentar los requisitos del trámite', 'Ministerio del Poder Popular para el Turismo')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, organism) VALUES ('Mi casa bien equipada', '1. Fotocopia de la cédula de identidad.\n2. Constancia de trabajo con emisión no mayor a tres meses.\n3. Tres referencias personales con dirección, números telefónicos y copia de la cédula del emisor.\n4. Copia de un recibo de servicio (agua, electricidad, teléfono)', 'Lunes a viernes en horario de 9:00am a 5:00pm', 'Los productos de línea blanca son de la empresa china Haier Electric Appliances. Existen varios modelos. Los precios varían desde cocinas por Bs. 600 hasta neveras de 12 pies cúbicos por Bs. 1600. Se recomienda asistir al Mercal Hogar o Abasto Bicentenario de su preferencia, consultar los modelos en existencia y sus precios para iniciar el trámite', 'Para mayor información debe dirigirse, en horario de oficina, a las oficinas de atención al usuario de los establecimientos: Mercal Hogar y Bicentenario', 'Corporación de Mercados Socialistas (COMERSO) ente adscrito al Ministerio del Poder Popular para el Comercio')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, organism) VALUES ('Registro de Títulos Universitarios', '1. Título original.\n2. Si el título tiene enmiendas (notas certificadas).\n3. Cédula de identidad laminada de la persona que realiza el trámite.\n4. Firmas de los profesores en el título', 'Lunes a viernes en horario de 8:00am a 1:00pm', 'Ordinario (3 días hábiles): Bs. 285,16', 'Para registrar su título universitario deberá dirigirse a las Oficinas del Registro Principal, consignar su Título debidamente firmado y sellado (Hacer firmar el título por dos profesores de la Facultad, tomar nota del nombre completo de cada uno y su No. de Cédula de Identidad), posteriormente será verificado por un registrador quien le suministrará la planilla de depósito bancario. Usted consignará: planilla con su depósito bancario ya realizado y timbres fiscales por el monto de (trece) Bs. 13,00', 'Registro Principal de Caracas')");
		
		db.execSQL("CREATE TABLE " + MAYORALTIES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, mayor STRING, office STRING, address TEXT, phone STRING, web STRING, twitter STRING, state INTEGER NOT NULL, municipality INTEGER NOT NULL, FOREIGN KEY(state) REFERENCES states(_id), FOREIGN KEY(municipality) REFERENCES municipalities(_id))");
		
		db.execSQL(INSERT + MAYORALTIES + " (name, mayor, office, address, phone, web, twitter, state, municipality) VALUES ('Alcaldía de Baruta', 'Gerardo Blyde', 'Alcalde de Baruta', 'Edif. Sede, entre Av. Principal de Colinas de Bello Monte y Av. Beethoven, Caracas', '(0212)7017455 / (0212)7017456 / (0212)7017431', 'http://www.alcaldiadebaruta.gob.ve', '', '1', '1')");
//		db.execSQL(INSERT + MAYORALTIES + " (name, mayor, office, address, phone, web, twitter, state, municipality) VALUES ('Alcaldía de ', '', '', '', '', '', '', '1', '1')");
		
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