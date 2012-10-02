package gob.movil.info;

import gob.movil.R;
import gob.movil.app.Main;
import gob.movil.model.Alcaldia;
import gob.movil.model.Institucion;
import gob.movil.model.Tramite;
import gob.movil.service.SoapClient;

import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
		progressDialog = ProgressDialog.show(this,
				getString(R.string.updating), getString(R.string.please_wait));
		new ProgressTask().execute((Void) null);
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
			if (errorException == 3) {
				showAlertDialog(R.string.warning,
						R.string.message_updated_version, R.string.ok,
						R.string.cancel, false);
			} else if (errorConnection > 0) {
				showAlertDialog(R.string.warning,
						R.string.message_connection_error, R.string.try_again,
						R.string.cancel, true);
			} else {
				Toast.makeText(Update.this, getString(R.string.full_update),
						Toast.LENGTH_LONG).show();
			}
		}

		/**
		 * Lógica del negocio del método de actualización de datos.
		 * 
		 * @author Ehison Pérez
		 */
		private void update() {
			String fecha = helper.fechaActualizacion();
			try {
				List<Tramite> resultado = SoapClient.ListarTramites(fecha);
				updateProcedures(resultado);
				helper.updateFecha();
				resultado.clear();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				if (e.getMessage().equals("Exception"))
					errorException++;
				else
					errorConnection++;
			}
			try {
				List<Institucion> resultado = SoapClient
						.ListarInstituciones(fecha);
				updateAgencies(resultado);
				helper.updateFecha();
				resultado.clear();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				if (e.getMessage().equals("Exception"))
					errorException++;
				else
					errorConnection++;
			}
			try {
				List<Alcaldia> resultado = SoapClient.ListarAlcaldias(fecha);
				updateMayoralties(resultado);
				helper.updateFecha();
				resultado.clear();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				if (e.getMessage().equals("Exception"))
					errorException++;
				else
					errorConnection++;
			}
			progressDialog.dismiss();
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
					if (helper.updateDatabaseAgencies(resultado.get(i)
							.getIdInstitucion())) {
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
					if (helper.updateDatabaseMayoralties(resultado.get(i)
							.getIdAlcaldia())) {
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
					if (helper.updateDatabaseProcedures(resultado.get(i)
							.getIdTramite())) {
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
							Log.i("ERROR => ", "" + error);
							if (error) {
								progressDialog.show();
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
}