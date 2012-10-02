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

public class Update extends Main {
	ProgressDialog progressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		updateConfirmation();
	}

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

	public void startUpdatingProcess() {
		progressDialog = ProgressDialog.show(this,
				getString(R.string.updating), getString(R.string.please_wait));
		new ProgressTask().execute((Void) null);
	}

	class ProgressTask extends AsyncTask<Void, Void, Void> {
		private int errorConnection = 0;
		private int errorException = 0;

		@Override
		protected Void doInBackground(Void... params) {
			update();
			return null;
		}

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

		private void update() {
			Log.i("UPDATING...", "PLEASE WAIT...");
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
				if (e.getMessage().equals("Exception")) {
					errorException++;
				} else {
					errorConnection++;
				}
			}
			progressDialog.dismiss();
		}

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
							if (error)
								update();
							else
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