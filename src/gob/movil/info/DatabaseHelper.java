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
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Clase para la conexión y modelado de la base de datos de la aplicación.
 * 
 * @author Richard Ricciardelli
 * @author Ehison Pérez
 * 
 */
public class DatabaseHelper extends SQLiteOpenHelper implements Constants {

	private static String DB_NAME = "GobiernoMovil.db";
	private SQLiteDatabase db;
	private final Context context;

	/**
	 * Guarda una referencia al contexto para acceder a la carpeta assets y los
	 * recursos de la aplicación
	 * 
	 * @param contexto
	 *            Contexto de la aplicación
	 * @author Ehison Pérez
	 */
	public DatabaseHelper(Context contexto) {
		super(contexto, DB_NAME, null, 1);
		this.context = contexto;
	}

	/**
	 * Crea una base de datos vacía en el sistema y la sobreescribe con la que
	 * está colocada en la carpeta assets.
	 * 
	 * @throws IOException
	 * @author Ehison Pérez
	 */
	public void crearDataBase() throws IOException {
		boolean dbExist = comprobarBaseDatos();
		if (!dbExist) {
			try {
				this.getReadableDatabase();
				copiarBaseDatos();
			} catch (IOException e) {
				// TODO Este mensaje debe estar internacionalizado.
				throw new Error("Error al copiar la Base de Datos");
			}
		}
	}

	/**
	 * Comprobamos que la base de datos exista.
	 * 
	 * @return true si existe, false de lo contrario.
	 */
	private boolean comprobarBaseDatos() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);
		} catch (SQLiteException e) {
			// TODO Se debe escribir en alguna parte que no existe esta base de
			// datos.
		}
		if (checkDB != null)
			checkDB.close();
		return checkDB != null;
	}

	/**
	 * Copia la base de datos desde la carpeta assets hasta la base de datos
	 * vacía recién creada en la carpeta del sistema, desde donde es accesible.
	 * 
	 * @throws IOException
	 * @author Ehison Pérez
	 */
	private void copiarBaseDatos() throws IOException {
		/**
		 * Abrimos la base de datos de la carpeta assets con un objeto de la
		 * clase InputStream.
		 */
		InputStream myInput = context.getAssets().open(DB_NAME);
		/**
		 * Carpeta de destino donde hemos creado la base de datos vacía.
		 */
		String outFileName = DB_PATH + DB_NAME;
		/**
		 * Abrimos la base de datos vacía con un objeto de la clase
		 * OutputStream.
		 */
		OutputStream myOutput = new FileOutputStream(outFileName);
		/**
		 * Transfiere los bytes entre el stream de entrada y el de salida.
		 */
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		/**
		 * Cerramos los ficheros abiertos.
		 */
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	/**
	 * Abre la base de datos.
	 * 
	 * @throws SQLException
	 */
	public void abrirBaseDatos() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		db = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);
	}

	/**
	 * Cierra la conexión a la base de datos.
	 */
	@Override
	public synchronized void close() {
		if (db != null)
			db.close();
		super.close();
	}

	/**
	 * Método obligatorio en la clase DatabaseHelper.
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	/**
	 * Método obligatorio en la clase DatabaseHelper.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	/**
	 * Método para insertar datos de los trámites y servicios dentro de la
	 * aplicación en caso de que no exista.
	 * 
	 * @param nombre
	 *            Nombre que identifica al trámite.
	 * @param requisitos
	 *            Requisitos para llevar a cabo el trámite.
	 * @param horarios
	 *            Horarios de atención de la oficina o ente para atender el
	 *            trámite.
	 * @param costo
	 *            Costo monetario que tiene el trámite.
	 * @param descripcion
	 *            Descripción del trámite o los pasos para llevarlo a cabo.
	 * @param telefono
	 *            Teléfono de contacto donde se puede pedir más información
	 *            sobre el trámite.
	 * @param direccion
	 *            Dirección a la que se puede acudir para llevar a cabo el
	 *            trámite.
	 * @param identificador
	 *            Identificador único de este contenido.
	 * @param perfil
	 *            Tipo de perfil al que está asociado el trámite.
	 */
	public void insertDatabaseProcedures(String nombre, String requisitos,
			String horarios, String costo, String descripcion, String telefono,
			String direccion, int identificador, int perfil) {
		db = getWritableDatabase();
		db.execSQL(" INSERT INTO " + PROCEDURES + " VALUES (null, '" + nombre
				+ "'," + " '" + requisitos + "'," + " '" + horarios + "', "
				+ " '" + costo + "', " + " '" + descripcion + "', "
				+ " 'Información no disponible.', " + " '" + telefono + "', '"
				+ direccion + "'," + " '" + identificador + "', '" + perfil
				+ "')");
		db.close();
	}

	/**
	 * Método para insertar datos de las instituciones dentro de la aplicación
	 * en caso de que no exista.
	 * 
	 * @param nombre
	 *            Nombre de la institución en forma resumida.
	 * @param director
	 *            Representante público de la entidad.
	 * @param institucion
	 *            Nombre completo de la institución.
	 * @param direccion
	 *            Dirección física de la institución.
	 * @param telefono
	 *            Teléfonos de contacto de la institución.
	 * @param web
	 *            Página web de la institución.
	 * @param correo
	 *            Correo electrónico de la institución.
	 * @param poder
	 *            Poder público al cual pertenece.
	 * @param identificador
	 *            Identificador único de este contenido.
	 */
	public void insertDatabaseAgencies(String nombre, String director,
			String institucion, String direccion, String telefono, String web,
			String correo, int poder, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" INSERT INTO " + AGENCIES + " VALUES (null, '" + nombre
				+ "'," + " '" + director + "'," + " '" + institucion + "',"
				+ " '" + direccion + "'," + " '" + telefono + "'," + " '" + web
				+ "'," + " '" + correo + "'," + " '" + poder + "'," + " '"
				+ identificador + "')");
		db.close();
	}

	/**
	 * Método para insertar datos de las alcaldías dentro de la aplicación en
	 * caso de que no exista.
	 * 
	 * @param municipio
	 *            Municipio al cual pertenece esta alcaldía.
	 * @param director
	 *            Representante público de la entidad.
	 * @param alcaldia
	 *            Nombre de la alcaldía.
	 * @param direccion
	 *            Dirección física de la alcaldía.
	 * @param telefono
	 *            Teléfono de la alcaldía.
	 * @param web
	 *            Página web de la alcaldía.
	 * @param correo
	 *            Correo electrónico de la alcaldía.
	 * @param estado
	 *            Entidad estatal a la que pertenece esta alcaldía.
	 * @param identificador
	 *            Identificador único de este contenido.
	 */
	public void insertDatabaseMayoralties(String municipio, String director,
			String alcaldia, String direccion, String telefono, String web,
			String correo, int estado, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" INSERT INTO " + MAYORALTIES + " VALUES (null, '"
				+ municipio + "'," + " '" + director + "'," + " '" + alcaldia
				+ "'," + " '" + direccion + "'," + " '" + telefono + "',"
				+ " '" + web + "'," + " '" + correo + "'," + " '" + estado
				+ "'," + " '" + identificador + "')");
		db.close();
	}

	/**
	 * Método para actualizar la fecha de actualización de la base de datos.
	 * 
	 * @author Ehison Pérez
	 */
	public void updateFecha() {
		String date = new SimpleDateFormat(DATE_FORMAT).format(new Date());
		db = getWritableDatabase();
		db.execSQL("UPDATE fecha_actualizacion SET fecha='" + date
				+ "' WHERE _id = 1");
		db.close();
		Log.v("UP TO DATE", date);
	}

	/**
	 * Método que será llamado al momento de cancelar el proceso de descarga, se
	 * encargará de actualizar la fecha en la base de datos colocando un día
	 * menos para que la notificación de actualización vuelva a mostrarse.
	 * 
	 * @author Richard Ricciardelli
	 */
	public void rollback() {
		String date = new SimpleDateFormat(DATE_FORMAT).format(new Date());
		int today = Integer.parseInt(date.substring(8, 10));
		int yesterday = today - 1;
		date = date.replace(date.substring(7, 11),
				
				"-" + String.valueOf(yesterday) + " ");
		db = getWritableDatabase();
		db.execSQL("UPDATE fecha_actualizacion SET fecha='" + date
				+ "' WHERE _id = 1");
		db.close();
		Log.v("ROLLBACK", date);
	}

	/**
	 * Método para actualizar los datos de los trámites y servicios dentro de la
	 * aplicación en caso de que no exista.
	 * 
	 * @param nombre
	 *            Nombre que identifica al trámite.
	 * @param requisitos
	 *            Requisitos para llevar a cabo el trámite.
	 * @param horarios
	 *            Horarios de atención de la oficina o ente para atender el
	 *            trámite.
	 * @param costo
	 *            Costo monetario que tiene el trámite.
	 * @param descripcion
	 *            Descripción del trámite o los pasos para llevarlo a cabo.
	 * @param telefono
	 *            Teléfono de contacto donde se puede pedir más información
	 *            sobre el trámite.
	 * @param direccion
	 *            Dirección a la que se puede acudir para llevar a cabo el
	 *            trámite.
	 * @param identificador
	 *            Identificador único de este contenido.
	 * @param perfil
	 *            Tipo de perfil al que está asociado el trámite.
	 */
	public void updateDatabaseProcedures(String nombre, String requisitos,
			String horarios, String costo, String descripcion, String telefono,
			String direccion, int identificador, int perfil) {
		db = getWritableDatabase();
		db.execSQL(" UPDATE " + PROCEDURES + " SET nombre='" + nombre + "', "
				+ " requisitos = '" + requisitos + "'," + " horario = '"
				+ horarios + "'," + " costo = '" + costo + "',"
				+ " informacion = '" + descripcion + "'," + " telefono = '"
				+ telefono + "'," + " direccion = '" + direccion + "',"
				+ " perfil = '" + perfil + "'" + " WHERE identificador = "
				+ identificador + "");
		db.close();
	}

	/**
	 * Método para actualizar los datos de las instituciones dentro de la
	 * aplicación en caso de que no exista.
	 * 
	 * @param nombre
	 *            Nombre de la institución en forma resumida.
	 * @param director
	 *            Representante público de la entidad.
	 * @param institucion
	 *            Nombre completo de la institución.
	 * @param direccion
	 *            Dirección física de la institución.
	 * @param telefono
	 *            Teléfonos de contacto de la institución.
	 * @param web
	 *            Página web de la institución.
	 * @param correo
	 *            Correo electrónico de la institución.
	 * @param poder
	 *            Poder público al cual pertenece.
	 * @param identificador
	 *            Identificador único de este contenido.
	 */
	public void updateDatabaseAgencies(String nombre, String director,
			String institucion, String direccion, String telefono, String web,
			String correo, int poder, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" UPDATE " + AGENCIES + " SET nombre='" + nombre + "', "
				+ " director = '" + director + "'," + " institucion ='"
				+ institucion + "', direccion = '" + direccion + "',"
				+ " telefono = '" + telefono + "'," + " web = '" + web + "',"
				+ " twitter = '" + correo + "'," + " poder = '" + poder + "'"
				+ " WHERE identificador = " + identificador + "");
		db.close();
	}

	/**
	 * Método para actualizar los datos de las alcaldías dentro de la aplicación
	 * en caso de que no exista.
	 * 
	 * @param municipio
	 *            Municipio al cual pertenece esta alcaldía.
	 * @param director
	 *            Representante público de la entidad.
	 * @param alcaldia
	 *            Nombre de la alcaldía.
	 * @param direccion
	 *            Dirección física de la alcaldía.
	 * @param telefono
	 *            Teléfono de la alcaldía.
	 * @param web
	 *            Página web de la alcaldía.
	 * @param correo
	 *            Correo electrónico de la alcaldía.
	 * @param estado
	 *            Entidad estatal a la que pertenece esta alcaldía.
	 * @param identificador
	 *            Identificador único de este contenido.
	 */
	public void updateDatabaseMayoralties(String nombre, String director,
			String alcaldia, String direccion, String telefono, String web,
			String correo, int identificador) {
		db = getWritableDatabase();
		db.execSQL(" UPDATE " + MAYORALTIES + " SET nombre='" + nombre + "', "
				+ " director = '" + director + "'," + " alcaldia = '"
				+ alcaldia + "'," + " direccion = '" + direccion + "',"
				+ " telefono = '" + telefono + "'," + " web = '" + web + "',"
				+ " twitter = '" + correo + "'" + " WHERE identificador = "
				+ identificador + "");
		db.close();
	}

	// TODO ¿Qué hace este método?
	// TODO Observación: La misma lógica parece repetirse tres veces, se puede
	// optimizar para usar un único método e incrementar la cantidad de
	// parámetros.
	public boolean seekRegistration(int identifier, String table) {
		db = getWritableDatabase();
		int i = 0;
		Cursor c = db.rawQuery("SELECT identificador FROM " + table
				+ " WHERE identificador = " + identifier + "", null);
		if (c.moveToFirst())
			do {
				i = c.getInt(0);
			} while (c.moveToNext());
		c.close();
		db.close();
		return i == identifier;
	}

	/**
	 * Método para enviar el parámetro de fecha de actualización almacenada en
	 * la base de datos al objeto tipo servicio.
	 * 
	 * @return Fecha de actualización en String.
	 */
	public String fechaActualizacion() {
		String fecha = null;
		db = getWritableDatabase();
		Cursor c = db.rawQuery("SELECT fecha FROM fecha_actualizacion", null);
		if (c.moveToFirst())
			do {
				fecha = c.getString(0);
			} while (c.moveToNext());
		c.close();
		db.close();
		return fecha;
	}
}