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
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Update extends Main {
	// Static so that the thread access the latest attribute
	private static ProgressDialog progressDialog;
	private static Handler handler;
	private Thread thread;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		// create a handler to update the ui
		handler = new Handler();
		// check if the thread is already running
		thread = (Thread) getLastNonConfigurationInstance();
		if (thread != null && thread.isAlive()) {
			showProgressDialog();
		}
		updateConfirmation(this);
	}

	public void updateConfirmation(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(R.string.confirm);
		builder.setMessage(R.string.message_update);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.yes,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
						startThread();
						update();
					}
				});
		builder.setNegativeButton(R.string.no,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
						finish();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	@Override
	public void crearBBDD() {
		super.crearBBDD();
	}

	public void startThread() {
		showProgressDialog();
		thread = new MyThread();
		thread.start();
	}

	public void showProgressDialog() {
		progressDialog = ProgressDialog.show(this, "Download", "downloading",
				true);
	}

	// Save the thread
	@Override
	public Object onRetainNonConfigurationInstance() {
		return thread;
	}

	// dismiss dialog if activity is destroyed
	@Override
	protected void onDestroy() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
			progressDialog = null;
		}
		super.onDestroy();
	}

	private void update() {
		// TODO Update logic here!
		Log.i("UPDATING...", "PLEASE WAIT...");
		String fecha = helper.fechaActualizacion();
		int errorException = 0;
		int errorConnection = 0;
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
			List<Institucion> resultado = SoapClient.ListarInstituciones(fecha);
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
		// TODO Va tan rápido que no hay tiempo para que aparezca la barra de
		// progreso.
		if (errorException == 3) {
			handler.post(new MyRunnable());
			Log.i("EXCEPTION", "ERROR EXCEPTION => " + errorException);
			// messageUpdateComplete();
		}
		if (errorConnection > 0) {
			handler.post(new MyRunnable());
			Log.i("CONNECTION", "ERROR CONNECTION => " + errorConnection);
			// updateMessageError();
		}
	}

	public void updateAgencies(List<Institucion> resultado) {
		if (resultado != null) {
			for (int i = 0; i < resultado.size(); i++) {
				if (helper.updateDatabaseAgencies(resultado.get(i)
						.getIdInstitucion())) {
					helper.updateDatabaseAgencies(resultado.get(i)
							.getNombreSector(), resultado.get(i).getDirector(),
							resultado.get(i).getNombreInstitucion(), resultado
									.get(i).getDireccion(), resultado.get(i)
									.getTelefono(), resultado.get(i)
									.getPaginatWeb(), resultado.get(i)
									.getCorreoElect(), resultado.get(i)
									.getPoder(), resultado.get(i)
									.getIdInstitucion());
				} else {
					helper.insertDatabaseAgencies(resultado.get(i)
							.getNombreSector(), resultado.get(i).getDirector(),
							resultado.get(i).getNombreInstitucion(), resultado
									.get(i).getDireccion(), resultado.get(i)
									.getTelefono(), resultado.get(i)
									.getPaginatWeb(), resultado.get(i)
									.getCorreoElect(), resultado.get(i)
									.getPoder(), resultado.get(i)
									.getIdInstitucion());
				}
			}
			resultado.clear();
		}
	}

	public void updateMayoralties(List<Alcaldia> resultado) {
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
							.getCorreoAlcaldia(), resultado.get(i).getEstado(),
							resultado.get(i).getIdAlcaldia());
				}
			}
			resultado.clear();
		}
	}

	public void updateProcedures(List<Tramite> resultado) {
		if (resultado != null) {
			for (int i = 0; i < resultado.size(); i++) {
				if (helper.updateDatabaseProcedures(resultado.get(i)
						.getIdTramite())) {
					helper.updateDatabaseProcedures(resultado.get(i)
							.getNombreTramite(), resultado.get(i)
							.getRequisitos(), resultado.get(i).getHorarios(),
							resultado.get(i).getCosto(), resultado.get(i)
									.getDescripcion(), resultado.get(i)
									.getTelefono(), resultado.get(i)
									.getDireccion(), resultado.get(i)
									.getIdTramite(), resultado.get(i)
									.getIPerfil());
				} else {
					helper.insertDatabaseProcedures(resultado.get(i)
							.getNombreTramite(), resultado.get(i)
							.getRequisitos(), resultado.get(i).getHorarios(),
							resultado.get(i).getCosto(), resultado.get(i)
									.getDescripcion(), resultado.get(i)
									.getTelefono(), resultado.get(i)
									.getDireccion(), resultado.get(i)
									.getIdTramite(), resultado.get(i)
									.getIPerfil());
				}
			}
			resultado.clear();
		}
	}

	public class MyThread extends Thread {
		@Override
		public void run() {
			// Simulate a slow network
			// try {
			// update();
			// new Thread().sleep(true);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// update();
			// handler.post(new MyRunnable());
		}
	}

	static public class MyRunnable implements Runnable {
		public void run() {
			progressDialog.dismiss();
		}
	}
}