package ve.gob.cnti.info;


import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import ve.gob.cnti.app.Main;
import ve.gob.cnti.app.R;
import ve.gob.cnti.model.Alcaldia;
import ve.gob.cnti.model.Institucion;
import ve.gob.cnti.model.Tramite;
import ve.gob.cnti.service.SoapClient;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class Update extends Main{

	@Override
	public void crearBBDD() {
		super.crearBBDD();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UpdateMessage();
	}

	/**
	 * Mensaje que mostrara mientras los usuarios espera que se carguen los nuevos datos
	 */
	
			
	
	/**
	 * Mensaje y metodos usados al usar el botos de actualizar del menu principal
	 */
	private void UpdateMessage() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.confirm);
		builder.setMessage(R.string.message_update);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				String fecha = helper.fechaActualizacion();
				int errorException = 0;
				int errorConection = 0;
				try {
					List<Tramite> resultado = SoapClient.ListarTramites(fecha);
					updateProcedures(resultado);
					helper.updateFecha();
					resultado.clear();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					if (e.getMessage().equals("Exception")){
						errorException++;
					}else{
						errorConection++;
					}
				}
				try {
					List<Institucion> resultado = SoapClient.ListarInstituciones(fecha);
					updateAgencies(resultado);
					helper.updateFecha();
					resultado.clear();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					if (e.getMessage().equals("Exception")){
						errorException++;
					}else{
						errorConection++;
					}
				}

				try {
					List<Alcaldia> resultado = SoapClient.ListarAlcaldias(fecha);
					updateMayoralties(resultado);
					helper.updateFecha();
					resultado.clear();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					if (e.getMessage().equals("Exception")){
						errorException++;
					}else{
						errorConection++;
					}
				}
				dialog.dismiss();

				if (errorException == 3)
					MessageUpdateComplete();
				if (errorConection > 0)
					UpdateMessageError();
			}
		});
		
		builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				finish();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
		
	}
	
	
	/**
	 * Proceso para la actualizacion de la tabla tramite
	 * @param  resultado
	 */
	public void updateProcedures(List<Tramite> resultado){
				if(resultado != null){
					
					for (int i = 0; i<resultado.size(); i++){
						boolean a = helper.updateDatabaseProcedures(resultado.get(i).getIdTramite());
						if (a == true){
						helper.updateDatabaseProcedures(
								
								resultado.get(i).getNombreTramite(), 
								resultado.get(i).getRequisitos(),
								resultado.get(i).getHorarios(), 
								resultado.get(i).getCosto(), 
								resultado.get(i).getDescripcion(), 
								resultado.get(i).getTelefono(),
								resultado.get(i).getDireccion(),
								resultado.get(i).getIdTramite());
						}else{
							helper.insertDatabaseProcedures(
									resultado.get(i).getNombreTramite(), 
									resultado.get(i).getRequisitos(),
									resultado.get(i).getHorarios(), 
									resultado.get(i).getCosto(), 
									resultado.get(i).getDescripcion(), 
									resultado.get(i).getTelefono(),
									resultado.get(i).getDireccion(),
									resultado.get(i).getIdTramite());
						}
					}
					resultado.clear();

				}
	}
	
	public void updateAgencies(List<Institucion> resultado){
		if(resultado != null){
			for (int i = 0; i<resultado.size(); i++){
				boolean a = helper.updateDatabaseAgencies(resultado.get(i).getIdInstitucion());
				if (a == true){
				helper.updateDatabaseAgencies(resultado.get(i).getNombreInstitucion(),
						resultado.get(i).getDirector(),
						resultado.get(i).getDireccion(),
						resultado.get(i).getTelefono(),
						resultado.get(i).getPaginatWeb(),
						resultado.get(i).getCorreoElect(),
						resultado.get(i).getPoder(),
						resultado.get(i).getIdInstitucion());
				}else{
					helper.insertDatabaseAgencies(resultado.get(i).getNombreInstitucion(), 
							resultado.get(i).getDirector(), 
							resultado.get(i).getDireccion(),
							resultado.get(i).getTelefono(),
							resultado.get(i).getPaginatWeb(),
							resultado.get(i).getCorreoElect(),
							resultado.get(i).getPoder(), 
							resultado.get(i).getIdInstitucion());
				}
			}
			resultado.clear();

		}
	}	
	
	public void updateMayoralties(List<Alcaldia> resultado){
		if(resultado != null){
			for (int i = 0; i<resultado.size(); i++){
				boolean a = helper.updateDatabaseMayoralties(resultado.get(i).getIdAlcaldia());
				if (a == true){
				helper.updateDatabaseMayoralties(resultado.get(i).getNombreAlcaldia(),
						resultado.get(i).getDirectorALcaldia(),
						resultado.get(i).getDireccionALcaldia(),
						resultado.get(i).getTelefonoAlcaldia(),
						resultado.get(i).getWebAlcaldia(),
						resultado.get(i).getCorreoAlcaldia(),
						resultado.get(i).getIdAlcaldia());
				}else{
					helper.insertDatabaseMayoralties(resultado.get(i).getNombreAlcaldia(), 
							resultado.get(i).getDirectorALcaldia(), 
							resultado.get(i).getDireccionALcaldia(), 
							resultado.get(i).getTelefonoAlcaldia(), 
							resultado.get(i).getWebAlcaldia(), 
							resultado.get(i).getCorreoAlcaldia(), 
							resultado.get(i).getEstado(), 
							resultado.get(i).getIdAlcaldia());
				}
			}
			resultado.clear();

		}
	}	
	
	/**
	 * Mensaje en caso de que la base de datos ya se encuentre actualizada a la fecha 
	 */
	private void MessageUpdateComplete() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.warning);
		builder.setMessage(R.string.message_updated_version);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				finish();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	/**
	 * Mensaje usado en caso de no haber conexión con el servicio o falla en la señal del dispositivo
	 */
	private void UpdateMessageError() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.warning);
		builder.setMessage(R.string.message_connection_error);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.tryAgain, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				UpdateMessage();
			}
		});
		
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				finish();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
