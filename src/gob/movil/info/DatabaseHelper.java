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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "test.db";
	private static final int DB_VERSION = 1;
	public final String POWERS = "powers";
	public final String STATES = "states";
	public final String MUNICIPALITIES = "municipalities";
	public final String AGENCIES = "agencies";
	public final String PROCEDURES = "procedures";
	public final String MAYORALTIES = "mayoralties";
	
	public final String INSERT = "INSERT INTO ";
	public final String SELECT = "SELECT * FROM ";
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + POWERS + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL("CREATE TABLE " + STATES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING)");
		
		db.execSQL(INSERT + STATES + " (name) VALUES ('Distrito Capital')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Amazonas')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Anzoátegui')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Apure')"); 
		db.execSQL(INSERT + STATES + " (name) VALUES ('Aragua')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Barinas')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Bolívar')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Carabobo')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Cojedes')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Delta Amacuro')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Falcón')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Guárico')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Lara')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Mérida')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Miranda')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Monagas')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Nueva Esparta')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Portuguesa')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Sucre')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Táchira')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Trujillo')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Vargas')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Yaracuy')");
		db.execSQL(INSERT + STATES + " (name) VALUES ('Zulia')");
		
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
		
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Presidencia de la República', 'Hugo Chávez', 'Presidente de la República', 'Palacio de Miraflores', 'No disponible.', 'http://www.chavez.org.ve', '@chavezcandanga', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Vicepresidencia de la República', 'Elías Jaua', 'Vicepresidente de la República', 'Av. Urdaneta. Esquina de Carmelitas. Caracas', '(0212)8603335 / (0212)8608822', 'http://www.vicepresidencia.gob.ve', '', '1', '1')");
		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('Gobernación del Distrito Capital', 'Jackeline Farías', 'Gobernadora del Distrito Capital', 'Esq. Principal, frente a la Plaza Bolívar, Edif. Palacio de Gobierno, El Silencio, Caracas', '(0212)8632998', 'http://www.gdc.gob.ve', '', '6', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
//		db.execSQL(INSERT + AGENCIES + " (name, officer, office, address, phone, web, twitter, power, state) VALUES ('', '', '', '', '', '', '', '1', '1')");
		
		db.execSQL("CREATE TABLE " + PROCEDURES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRNIG, requeriments TEXT, schedule TEXT, cost STRING, info TEXT, agency INTEGER NOT NULL, FOREIGN KEY(agency) REFERENCES agencies(_id))");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, agency) VALUES ('Conformación de Comunas', '1. Notificar a los ciudadanos la constitución de la Comisión Promotora que conformará la comuna.\n2. Elegir la Asamblea Constitutiva.\n3. Consejo electoral Provisional.\n4. Conformar la Comisión Redactora.\n5. Realizar un referendo aprobatorio', 'No aplica', 'No aplica', 'Debe tener en cuenta las siguientes definiciones:\n\nBanco de las Comunas:\nOrganización económico-financiera de carácter social que gestiona y administra los recursos financieros, impulsando políticas económicas con la participación democrática y protagónica del pueblo.\n\nCartas Comunales:\nInstrumento donde se establecen las normas elaboradas por los habitantes de la comuna en Parlamento Comunal con el propósito de regular la vida social y comunitaria de conformidad con la Constitución Bolivariana de Venezuela.\n\nCarta Fundacional:\nInstrumento aprobado en referendo popular, donde las comunidades expresan su voluntad de constituirse en comuna.\n\nEstado Comunal:\nForma de organización político-social, fundada en el estado social de derecho y justicia establecido en la constitución, en la cual se le otorga poder al pueblo, con un modelo de propiedad social y de desarrollo endógeno sustentable.\n\nParlamento Comunal:\nMáxima instancia del autogobierno en la comuna, constituido por asambleas de ciudadanos, establecidos en cada uno de sus respectivos ámbitos territoriales', '1')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, agency) VALUES ('Legalización de Títulos Universitarios', '1. Título Original debidamente firmado y sellado por el Registro Público correspondiente (Ver Registro de Títulos Universitarios).\n2. Original del Acta de grado o Notas Certificadas.\n3. Copia de la Cédula de Identidad del titular (Si el titular no es quien entrega la documentación, deberá traer autorización por escrito y copia de CI de ambas partes)', 'Lapso de un día hábil para retirar', 'Cancelar, en timbres fiscales, Bs. 27,50 en la taquilla autorizada ubicada en dicho Ministerio, o en los siguientes bancos:\n\nBanco de Venezuela, Cuenta Corriente, N° 0102-0552-21-0000024439, a nombre de GOB. DTTO. CAPITAL ING. TIMBRES FISCALES.\n\nBanco del Tesoro, Cuenta Corriente, N° 0163-0903-62-9032000282, a nombre del GOBIERNO DEL DISTRITO CAPITAL.\n\nSi el titular posee varios documentos, puede depositar el total de los mismos en un solo depósito', 'NOTA: LOS TÍTULOS DE LAS UNIVERSIDADES PRIVADAS NO NECESITAN REALIZAR ESTE TRÁMITE YA QUE TIENEN LA FIRMA DEL MINISTRO', '1')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, agency) VALUES ('Licencia de Turismo', '1. Formulario de Solicitud de Trámite de Licencia de Turismo Persona Jurídica, establecido por el Ministerio del Poder Popular con competencia en Turismo, en original y dos (2) fotocopias legibles.\n2. Fotocopia legible del Oficio del Registro Turístico Nacional (RTN).\n3. Fotocopia legible de la Patente de Industria y Comercio, esto aplica en caso de haber consignado la solicitud al momento de la inscripción en el Registro Turístico Nacional.\n4. Fotocopia legible de la Póliza de Responsabilidad Civil contra daños a terceros vigente, a nombre del prestador de servicios turísticos, anexando las condiciones generales y particulares del contrato de la póliza vigente.\n5. Si el establecimiento se encuentra ubicado en un Área Bajo Régimen de Administración Especial (ABRAE), fotocopia legible del permiso o contrato de concesión correspondiente, emitida por la autoridad competente.\n6. Si el capital de la persona jurídica tiene inversión extranjera, fotocopia legible de la Constancia de Calificación de Empresas, emitidas por la Superintendencia de Inversiones Extranjeras (SIEX).\n7. Y cualquier otro documento que el Ministerio del Poder Popular con competencia en Turismo, considere necesario.\n8. Los Prestadores de Servicios Turísticos, además de los Requisitos Generales exigidos, deberán consignar los requisitos específicos para cada Tipo de Prestador (Empresas de Alojamiento Turístico, Administradoras de Empresas Turísticas, Agencias de Turismo, Transporte Turístico, Transporte Turístico Terrestre, Transporte Turístico Acuático, Transporte Turístico Aéreo, Representantes de Turismo, Representante de Transporte Turístico Terrestre, Representante de Transporte Turístico Acuático (Nacional o Internacional), Representante de Transporte Turístico Aéreo, Establecimientos Turísticos de Alimentos y Bebidas, Empresas de Recreación Turística, Empresas de Información, Promoción Publicidad y Propaganda Turística). Los requisitos específicos y formularios pueden descargarse en el vínculo del Ministerio de Turismo.\n9. La documentación se presenta en original y fotocopia. Las Fotocopias deben estar completas, visibles y legibles. Una vez confrontado y verificado el original contra la fotocopia, se devuelve el original', 'Lunes a viernes en horario de 8:30am a 12:00pm y de 1:00pm a 4:30pm', 'Gratuito', 'En Caracas puede acudir a la sede del Ministerio de Turismo en la Avenida Francisco de Miranda, Av. principal de La Floresta, frente al Colegio Universitario de Caracas. En el interior del país debe llamar antes al 0500 TURISMO (05008874766) para que le indiquen la sede a la cual debe presentar los requisitos del trámite', '1')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, agency) VALUES ('Mi casa bien equipada', '1. Fotocopia de la cédula de identidad.\n2. Constancia de trabajo con emisión no mayor a tres meses.\n3. Tres referencias personales con dirección, números telefónicos y copia de la cédula del emisor.\n4. Copia de un recibo de servicio (agua, electricidad, teléfono)', 'Lunes a viernes en horario de 9:00am a 5:00pm', 'Los productos de línea blanca son de la empresa china Haier Electric Appliances. Existen varios modelos. Los precios varían desde cocinas por Bs. 600 hasta neveras de 12 pies cúbicos por Bs. 1600. Se recomienda asistir al Mercal Hogar o Abasto Bicentenario de su preferencia, consultar los modelos en existencia y sus precios para iniciar el trámite', 'Para mayor información debe dirigirse, en horario de oficina, a las oficinas de atención al usuario de los establecimientos: Mercal Hogar y Bicentenario', '1')");
		db.execSQL(INSERT + PROCEDURES + " (name, requeriments, schedule, cost, info, agency) VALUES ('Registro de Títulos Universitarios', '1. Título original.\n2. Si el título tiene enmiendas (notas certificadas).\n3. Cédula de identidad laminada de la persona que realiza el trámite.\n4. Firmas de los profesores en el título', 'Lunes a viernes en horario de 8:00am a 1:00pm', 'Ordinario (3 días hábiles): Bs. 285,16', 'Para registrar su título universitario deberá dirigirse a las Oficinas del Registro Principal, consignar su Título debidamente firmado y sellado (Hacer firmar el título por dos profesores de la Facultad, tomar nota del nombre completo de cada uno y su No. de Cédula de Identidad), posteriormente será verificado por un registrador quien le suministrará la planilla de depósito bancario. Usted consignará: planilla con su depósito bancario ya realizado y timbres fiscales por el monto de (trece) Bs. 13,00', '1')");
		
		db.execSQL("CREATE TABLE " + MAYORALTIES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING, mayor STRING, office STRING, address TEXT, phone STRING, web STRING, twitter STRING, state INTEGER NOT NULL, municipality INTEGER NOT NULL, FOREIGN KEY(state) REFERENCES states(_id), FOREIGN KEY(municipality) REFERENCES municipalities(_id))");
		db.execSQL(INSERT + MAYORALTIES + " (name, mayor, office, address, phone, web, twitter, state, municipality) VALUES ('Alcaldía de Baruta', 'Gerardo Blyde', 'Alcalde de Baruta', 'Edif. Sede, entre Av. Principal de Colinas de Bello Monte y Av. Beethoven, Caracas', '(0212)7017455 / (0212)7017456 / (0212)7017431', 'http://www.alcaldiadebaruta.gob.ve', '', '1', '1')");
		
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