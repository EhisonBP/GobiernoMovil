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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper implements Constants {

	private static String DB_NAME = "GobiernoMovil.db";
	private SQLiteDatabase db;
	private final Context myContext;

	/**
	 * Constructor
	 * 
	 * Guarda una referencia al contexto para acceder a la carpeta assets de la
	 * aplicaci�n y a los recursos
	 * 
	 * @param contexto
	 */
	public DatabaseHelper(Context contexto) {
		super(contexto, DB_NAME, null, 1);
		this.myContext = contexto;
	}

	/**
	 * Crea una base de datos vacia en el sistema y la sobreescribe con la que
	 * hemos puesto en Assets
	 */
	public void crearDataBase() throws IOException {
		boolean dbExist = comprobarBaseDatos();
		if (dbExist) {
			// Si ya existe no hacemos nada
		} else {
			// Si no existe, creamos una nueva Base de datos en la carpeta por
			// defecto de nuestra aplicaci�n,
			// de esta forma el Sistema nos permitir� sobreescribirla con la que
			// tenemos en la carpeta Assets
			this.getReadableDatabase();
			try {
				copiarBaseDatos();
			} catch (IOException e) {
				throw new Error("Error al copiar la Base de Datos");
			}
		}
	}

	/**
	 * Comprobamos si la base de datos existe
	 * 
	 * @return true si existe, false en otro caso
	 */
	private boolean comprobarBaseDatos() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);
		} catch (SQLiteException e) {
			// No existe
		}
		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	/**
	 * Copia la base de datos desde la carpeta Assets sobre la base de datos
	 * vac�a reci�n creada en la carpeta del sistema, desde donde es accesible
	 */
	private void copiarBaseDatos() throws IOException {

		// Abrimos la BBDD de la carpeta Assets como un InputStream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Carpeta de destino (donde hemos creado la BBDD vacia)
		String outFileName = DB_PATH + DB_NAME;

		// Abrimos la BBDD vacia como OutputStream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// Transfiere los Bytes entre el Stream de entrada y el de Salida
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Cerramos los ficheros abiertos
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	/**
	 * Abre la base de datos
	 */
	public void abrirBaseDatos() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		db = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);

	}

	/**
	 * Cierra la base de datos
	 */
	@Override
	public synchronized void close() {
		if (db != null)
			db.close();
		super.close();
	}

	/**
	 * Metodos Obligatorios en la clase BaseDatosHelper
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	/**
	 * Metodos para insertar datos de las tablas Intituciones, Tramites y
	 * servicios Dentro de la aplicacion en caso de que no exista
	 * 
	 */
	public void insertDatabaseProcedures(String nombre, String requisitos,
			String horarios, String costo, String descripcion, String telefono,
			String direccion, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" INSERT INTO " + PROCEDURES + " VALUES (null, '" + nombre
				+ "'," + " '" + requisitos + "'," + " '" + horarios + "', "
				+ " '" + costo + "', " + " '" + descripcion + "', "
				+ " 'Información no disponible.', " + " '" + telefono + "', '"
				+ direccion + "'," + " '" + identificador + "')");
	}

	public void insertDatabaseAgencies(String nombre, String director,
			String direccion, String telefono, String web, String correo,
			int poder, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" INSERT INTO " + AGENCIES + " VALUES (null, '" + nombre
				+ "'," + " '" + director + "'," + " null," + " '" + direccion
				+ "'," + " '" + telefono + "'," + " '" + web + "'," + " '"
				+ correo + "'," + " '" + poder + "'," + " '"
				+ identificador + "')");
	}

	public void insertDatabaseMayoralties(String nombre, String director,
			String direccion, String telefono, String web, String correo,
			int estado, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" INSERT INTO " + MAYORALTIES + " VALUES (null, '" + nombre
				+ "'," + " '" + director + "'," + " null," + " '" + direccion
				+ "'," + " '" + telefono + "'," + " '" + web + "'," + " '"
				+ correo + "'," + " '" + estado + "'," + " '" + identificador + "')");
	}

	/**
	 * metodos para actualizar la fecha de actualizacion de la base de datos
	 */
	public void updateFecha() {
		long time = new Date().getTime();
		java.sql.Date sqlDate = new java.sql.Date(time);
		String fecha = "" + sqlDate;
		db = getWritableDatabase();
		db.execSQL("UPDATE fecha_actualizacion SET fecha='" + fecha
				+ "' WHERE _id = 1");
	}

	/**
	 * Metodos usados para actualizar los datos de intituciones, alcaldias y
	 * tramites
	 * 
	 */
	public void updateDatabaseProcedures(String nombre, String requisitos,
			String horarios, String costo, String descripcion, String telefono,
			String direccion, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" UPDATE " + PROCEDURES + " SET nombre='" + nombre + "', "
				+ " requisitos = '" + requisitos + "'," + " horario = '"
				+ horarios + "'," + " costo = '" + costo + "',"
				+ " informacion = '" + descripcion + "'," + " telefono = '"
				+ telefono + "'," + " direccion = '" + direccion + "'"
				+ " WHERE identificador = " + identificador + "");
		db.close();

	}

	public boolean updateDatabaseProcedures(int identificador) {
		db = getWritableDatabase();
		int i = 0;
		Cursor c = db.rawQuery("SELECT identificador FROM " + PROCEDURES
				+ " WHERE identificador = " + identificador + "", null);
		if (c.moveToFirst()) {
			do {
				i = c.getInt(0);
			} while (c.moveToNext());
		}
		if (i == identificador) {
			return true;
		} else {
			return false;
		}
	}

	public void updateDatabaseAgencies(String nombre, String director,
			String direccion, String telefono, String web, String correo,
			int poder, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" UPDATE " + AGENCIES + " SET nombre='" + nombre + "', "
				+ " director = '" + director + "'," + " direccion = '"
				+ direccion + "'," + " telefono = '" + telefono + "',"
				+ " web = '" + web + "'," + " twitter = '" + correo + "',"
				+ " poder = '" + poder + "'" + " WHERE identificador = "
				+ identificador + "");
		db.close();
	}

	public boolean updateDatabaseAgencies(int identificador) {
		db = getWritableDatabase();
		int i = 0;
		Cursor c = db.rawQuery("SELECT identificador FROM " + AGENCIES
				+ " WHERE identificador = " + identificador + "", null);
		if (c.moveToFirst()) {
			do {
				i = c.getInt(0);
			} while (c.moveToNext());
		}
		if (i == identificador) {
			return true;
		} else {
			return false;
		}
	}

	public void updateDatabaseMayoralties(String nombre, String director,
			String direccion, String telefono, String web, String correo,
			int identificador) {
		db = getWritableDatabase();
		db.execSQL(" UPDATE " + MAYORALTIES + " SET nombre='" + nombre + "', "
				+ " director = '" + director + "'," + " direccion = '"
				+ direccion + "'," + " telefono = '" + telefono + "',"
				+ " web = '" + web + "'," + " twitter = '" + correo + "'"
				+ " WHERE identificador = " + identificador + "");
		db.close();
	}

	public boolean updateDatabaseMayoralties(int identificador) {
		db = getWritableDatabase();
		int i = 0;
		Cursor c = db.rawQuery("SELECT identificador FROM " + MAYORALTIES
				+ " WHERE identificador = " + identificador + "", null);
		if (c.moveToFirst()) {
			do {
				i = c.getInt(0);
			} while (c.moveToNext());
		}
		if (i == identificador) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para pasar el parametro fecha almacenado en la base de datos al
	 * objeto tipo servicio
	 * 
	 * @return
	 */
	public String fechaActualizacion() {
		String fecha = null;
		db = getWritableDatabase();
		Cursor c = db.rawQuery("SELECT fecha FROM fecha_actualizacion", null);
		// Nos aseguramos de que existe al menos un registro
		if (c.moveToFirst()) {
			// Recorremos el cursor
			do {
				fecha = c.getString(0);
			} while (c.moveToNext());
		}
		return fecha;
	}

}