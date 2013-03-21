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

import gob.movil.R;
import gob.movil.app.Main;
import gob.movil.database.DatabaseHelper;
import gob.movil.model.Alcaldia;
import gob.movil.model.Institucion;
import gob.movil.model.Tramite;
import gob.movil.service.SoapClient;

import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Clase de actualización de los datos de la aplicación conforme a los otorgados
 * por el servicio web.
 * 
 * @author Ehison Pérez
 * @author Richard Ricciardelli
 * 
 */
public class Update extends Main {
	/**
	 * Diálogo de progreso de actualización de los datos.
	 */
	ProgressDialog progressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		updateConfirmation();
	}

	/**
	 * Muestra mensaje de confirmación al usuario final sobre si realmente desea
	 * actualizar la base de datos.
	 */
	public void updateConfirmation() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.confirm);
		builder.setMessage(R.string.message_update);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.yes,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						startUpdatingProcess();
					}
				});
		builder.setNegativeButton(R.string.no,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						finish();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * Comienza el proceso de actualización de los datos, iniciando el diálogo
	 * de progreso y el proceso asíncrono de actualización de los datos en
	 * segundo plano.
	 */
	public void startUpdatingProcess() {
		final ProgressTask progressTask = new ProgressTask();
		progressDialog = ProgressDialog.show(this,
				getString(R.string.updating), getString(R.string.please_wait));
		// TODO Si se permitirá al usuario cancelar el proceso de actualización,
		// colocar el valor de la siguiente sentencia en true.
		progressDialog.setCancelable(false);
		progressDialog.setOnCancelListener(new OnCancelListener() {
			public void onCancel(DialogInterface dialog) {
				Toast.makeText(getApplicationContext(),
						getString(R.string.update_canceled), Toast.LENGTH_SHORT)
						.show();
				progressTask.cancel(true);
				new DatabaseHelper(getApplicationContext()).rollback();
			}
		});
		progressTask.execute((Void) null);
	}

	/**
	 * Clase asíncrona de progreso para la actualización de los datos con todos
	 * los parámetros vacíos debido a que no se está usando una barra de
	 * progreso con números sino un Spinner indeterminado.
	 * 
	 * @author Ehison Pérez
	 * @author Richard Ricciardelli
	 * 
	 */
	class ProgressTask extends AsyncTask<Void, Void, Void> {
		/**
		 * Contador de errores de conexión y red.
		 */
		private int errorConnection = 0;
		/**
		 * Contador de excepciones durante la actualización de los datos.
		 */
		private int errorException = 0;

		/**
		 * Sobreescribiendo el método para tarea asíncrona en segundo plano de
		 * actualización de datos.
		 */
		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(WAITING_PERIOD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (isOnline())
				update();
			return null;
		}

		/**
		 * Sobreescribiendo el método para realizar comprobaciones de variables
		 * de errores y mostrar el mensaje adecuado conforme la situación y el
		 * resultado.
		 */
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			progressDialog.dismiss();
			if (!isOnline())
				showAlertDialog(R.string.connection_error,
						R.string.connection_unavailable, R.string.try_again,
						R.string.cancel, true);
			else if (errorException == 3)
				showAlertDialog(R.string.warning,
						R.string.message_updated_version, R.string.ok,
						R.string.cancel, false);
			else if (errorConnection > 0)
				showAlertDialog(R.string.warning,
						R.string.message_connection_error, R.string.try_again,
						R.string.cancel, true);
			else
				Toast.makeText(Update.this, getString(R.string.full_update),
						Toast.LENGTH_LONG).show();
		}

		/**
		 * Lógica del negocio del método de actualización de datos.
		 * 
		 * @author Ehison Pérez
		 */
		private void update() {
			String fecha;
			try {
				fecha = helper.fechaActualizacion(PROCEDURES_ID);
				List<Tramite> resultado = SoapClient.listarTramites(fecha, 1);
				updateProcedures(resultado);
				// helper.updateFecha();
				// resultado.clear();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				if (e.getMessage().equals("Exception"))
					errorException++;
				else {
					errorConnection++;
					Log.i("CONNECTION ERROR", "ERROR DE CONEXIÓN EN TRÁMITE");
				}

			}
			try {
				fecha = helper.fechaActualizacion(INSTITUTION_ID);
				List<Institucion> resultado = SoapClient.listarInstituciones(
						fecha, 1);
				updateAgencies(resultado);
				// helper.updateFecha();
				// resultado.clear();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				if (e.getMessage().equals("Exception"))
					errorException++;
				else {
					errorConnection++;
					Log.i("CONNECTION ERROR",
							"ERROR DE CONEXIÓN EN INSTITUCIÓN");
				}
			}
			try {
				fecha = helper.fechaActualizacion(MAYORALTIES_ID);
				List<Alcaldia> resultado = SoapClient.listarAlcaldias(fecha, 1);
				updateMayoralties(resultado);
				// helper.updateFecha();
				// resultado.clear();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				if (e.getMessage().equals("Exception"))
					errorException++;
				else {
					errorConnection++;
					Log.i("CONNECTION ERROR", "ERROR DE CONEXIÓN ALCALDÍAS");
					e.printStackTrace();
				}
			}
		}

		/**
		 * Método que actualiza las instituciones.
		 * 
		 * @param resultado
		 *            Listado de instituciones
		 * @author Ehison Pérez
		 * 
		 */
		private void updateAgencies(List<Institucion> resultado) {
			if (resultado != null) {
				for (int i = 0; i < resultado.size(); i++) {
					if (helper.seekRegistration(resultado.get(i)
							.getIdInstitucion(), AGENCIES)) {
						helper.updateDatabaseAgencies(resultado.get(i)
								.getNombreSector(), resultado.get(i)
								.getDirector(), resultado.get(i)
								.getNombreInstitucion(), resultado.get(i)
								.getDireccion(),
								resultado.get(i).getTelefono(), resultado
										.get(i).getPaginatWeb(),
								resultado.get(i).getCorreoElect(), resultado
										.get(i).getPoder(), resultado.get(i)
										.getIdInstitucion());
					} else {
						helper.insertDatabaseAgencies(resultado.get(i)
								.getNombreSector(), resultado.get(i)
								.getDirector(), resultado.get(i)
								.getNombreInstitucion(), resultado.get(i)
								.getDireccion(),
								resultado.get(i).getTelefono(), resultado
										.get(i).getPaginatWeb(),
								resultado.get(i).getCorreoElect(), resultado
										.get(i).getPoder(), resultado.get(i)
										.getIdInstitucion());
					}
				}
				Log.v("FECHA INSTITUCIONES", resultado
						.get(resultado.size() - 1).getFecha());
				helper.updateFecha(INSTITUTION_ID,
						resultado.get(resultado.size() - 1).getFecha());
				resultado.clear();
			}
		}

		/**
		 * Método que actualiza las alcaldías.
		 * 
		 * @param resultado
		 *            Listado de alcaldías
		 * @author Ehison Pérez
		 * 
		 */
		private void updateMayoralties(List<Alcaldia> resultado) {
			if (resultado != null) {
				for (int i = 0; i < resultado.size(); i++) {
					if (helper.seekRegistration(resultado.get(i)
							.getIdAlcaldia(), MAYORALTIES)) {
						helper.updateDatabaseMayoralties(resultado.get(i)
								.getNombreAlcaldia(), resultado.get(i)
								.getDirectorALcaldia(), resultado.get(i)
								.getNombreMunicipio(), resultado.get(i)
								.getDireccionALcaldia(), resultado.get(i)
								.getTelefonoAlcaldia(), resultado.get(i)
								.getWebAlcaldia(), resultado.get(i)
								.getCorreoAlcaldia(), resultado.get(i)
								.getIdAlcaldia());
					} else {
						helper.insertDatabaseMayoralties(resultado.get(i)
								.getNombreAlcaldia(), resultado.get(i)
								.getDirectorALcaldia(), resultado.get(i)
								.getNombreMunicipio(), resultado.get(i)
								.getDireccionALcaldia(), resultado.get(i)
								.getTelefonoAlcaldia(), resultado.get(i)
								.getWebAlcaldia(), resultado.get(i)
								.getCorreoAlcaldia(), resultado.get(i)
								.getEstado(), resultado.get(i).getIdAlcaldia());
					}
				}
				Log.v("FECHA ALCALDÍAS", resultado.get(resultado.size() - 1)
						.getFecha());
				helper.updateFecha(MAYORALTIES_ID,
						resultado.get(resultado.size() - 1).getFecha());
				resultado.clear();
			}
		}

		/**
		 * Método que actualiza los trámites.
		 * 
		 * @param resultado
		 *            Listado de trámites
		 * @author Ehison Pérez
		 * 
		 */
		private void updateProcedures(List<Tramite> resultado) {
			if (resultado != null) {
				for (int i = 0; i < resultado.size(); i++) {
					if (helper.seekRegistration(
							resultado.get(i).getIdTramite(), PROCEDURES)) {
						helper.updateDatabaseProcedures(resultado.get(i)
								.getNombreTramite(), resultado.get(i)
								.getRequisitos(), resultado.get(i)
								.getHorarios(), resultado.get(i).getCosto(),
								resultado.get(i).getDescripcion(), resultado
										.get(i).getTelefono(), resultado.get(i)
										.getDireccion(), resultado.get(i)
										.getIdTramite(), resultado.get(i)
										.getIPerfil());
					} else {
						helper.insertDatabaseProcedures(resultado.get(i)
								.getNombreTramite(), resultado.get(i)
								.getRequisitos(), resultado.get(i)
								.getHorarios(), resultado.get(i).getCosto(),
								resultado.get(i).getDescripcion(), resultado
										.get(i).getTelefono(), resultado.get(i)
										.getDireccion(), resultado.get(i)
										.getIdTramite(), resultado.get(i)
										.getIPerfil());
					}
				}
				Log.v("FECHA TRÁMITES", resultado.get(resultado.size() - 1)
						.getFecha());
				helper.updateFecha(PROCEDURES_ID,
						resultado.get(resultado.size() - 1).getFecha());
				resultado.clear();
			}
		}

		/**
		 * Método optimizado para mostrar mensajes de error en un diálogo.
		 * 
		 * @param title
		 *            Título del diálogo
		 * @param message
		 *            Mensaje del diálogo
		 * @param positive
		 *            Botón positivo
		 * @param negative
		 *            Botón negativo
		 * @param error
		 *            <code>true</code> si se está mostrando un error
		 * 
		 * @author Richard Ricciardelli
		 * 
		 */
		private void showAlertDialog(int title, int message, int positive,
				int negative, final boolean error) {
			AlertDialog.Builder builder = new AlertDialog.Builder(Update.this);
			builder.setTitle(title);
			builder.setMessage(message);
			builder.setCancelable(false);
			builder.setPositiveButton(positive,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							// Si es un diálogo de error, permitir generar
							// nuevamente el proceso de actualización para
							// intentar otra vez.
							if (error) {
								progressDialog = ProgressDialog.show(
										Update.this,
										getString(R.string.updating),
										getString(R.string.please_wait));
								new ProgressTask().execute((Void) null);
							} else
								finish();
						}
					});
			builder.setNegativeButton(negative,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							finish();
						}
					});
			AlertDialog alert = builder.create();
			alert.show();
		}
	}

	/**
	 * Permite conocer si el dispositivo se encuentra conectado a Internet.
	 * 
	 * @return <code>true</code> si está conectado, <code>false</code> de lo
	 *         contrario.
	 * @author Richard Ricciardelli
	 * 
	 */
	public boolean isOnline() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		return networkInfo != null && networkInfo.isConnectedOrConnecting();
	}

}