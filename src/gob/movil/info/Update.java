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
import gob.movil.model.Alcaldia;
import gob.movil.model.Institucion;
import gob.movil.model.Tramite;
import gob.movil.service.SoapClient;

import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class Update extends Main {

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
	 * Mensaje que mostrara mientras los usuarios espera que se carguen los
	 * nuevos datos
	 */

	/**
	 * Mensaje y metodos usados al usar el botos de actualizar del menu
	 * principal
	 */
	private void UpdateMessage() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.confirm);
		builder.setMessage(R.string.message_update);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.yes,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						String fecha = helper.fechaActualizacion();
						int errorException = 0;
						int errorConection = 0;
						try {
							List<Tramite> resultado = SoapClient
									.ListarTramites(fecha);
							updateProcedures(resultado);
							helper.updateFecha();
							resultado.clear();
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							if (e.getMessage().equals("Exception")) {
								errorException++;
							} else {
								errorConection++;
							}
						}
						try {
							List<Institucion> resultado = SoapClient
									.ListarInstituciones(fecha);
							updateAgencies(resultado);
							helper.updateFecha();
							resultado.clear();
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							if (e.getMessage().equals("Exception")) {
								errorException++;
							} else {
								errorConection++;
							}
						}

						try {
							List<Alcaldia> resultado = SoapClient
									.ListarAlcaldias(fecha);
							updateMayoralties(resultado);
							helper.updateFecha();
							resultado.clear();
						} catch (XmlPullParserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							if (e.getMessage().equals("Exception")) {
								errorException++;
							} else {
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

		builder.setNegativeButton(R.string.no,
				new DialogInterface.OnClickListener() {

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
	 * 
	 * @param resultado
	 */
	public void updateProcedures(List<Tramite> resultado) {
		if (resultado != null) {

			for (int i = 0; i < resultado.size(); i++) {
				boolean a = helper.updateDatabaseProcedures(resultado.get(i)
						.getIdTramite());
				if (a == true) {
					helper.updateDatabaseProcedures(
					resultado.get(i).getNombreTramite(), 
					resultado.get(i).getRequisitos(), 
					resultado.get(i).getHorarios(),
					resultado.get(i).getCosto(), 
					resultado.get(i).getDescripcion(),
					resultado.get(i).getTelefono(), 
					resultado.get(i).getDireccion(), 
					resultado.get(i).getIdTramite());
				} else {
					helper.insertDatabaseProcedures(resultado.get(i).getNombreTramite(), 
							resultado.get(i).getRequisitos(), 
							resultado.get(i).getHorarios(),
							resultado.get(i).getCosto(), 
							resultado.get(i).getDescripcion(), 
							resultado.get(i).getTelefono(), 
							resultado.get(i).getDireccion(), 
							resultado.get(i).getIdTramite(), 
							resultado.get(i).getIPerfil());
				}
			}
			resultado.clear();

		}
	}

	public void updateAgencies(List<Institucion> resultado) {
		if (resultado != null) {
			for (int i = 0; i < resultado.size(); i++) {
				boolean a = helper.updateDatabaseAgencies(resultado.get(i)
						.getIdInstitucion());
				if (a == true) {
					helper.updateDatabaseAgencies(resultado.get(i)
							.getNombreInstitucion(), resultado.get(i)
							.getDirector(), resultado.get(i).getDireccion(),
							resultado.get(i).getTelefono(), resultado.get(i)
									.getPaginatWeb(), resultado.get(i)
									.getCorreoElect(), resultado.get(i)
									.getPoder(), resultado.get(i)
									.getIdInstitucion());
				} else {
					helper.insertDatabaseAgencies(resultado.get(i)
							.getNombreInstitucion(), resultado.get(i)
							.getDirector(), resultado.get(i).getDireccion(),
							resultado.get(i).getTelefono(), resultado.get(i)
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
				boolean a = helper.updateDatabaseMayoralties(resultado.get(i)
						.getIdAlcaldia());
				if (a == true) {
					helper.updateDatabaseMayoralties(resultado.get(i)
							.getNombreAlcaldia(), resultado.get(i)
							.getDirectorALcaldia(), resultado.get(i)
							.getDireccionALcaldia(), resultado.get(i)
							.getTelefonoAlcaldia(), resultado.get(i)
							.getWebAlcaldia(), resultado.get(i)
							.getCorreoAlcaldia(), resultado.get(i)
							.getIdAlcaldia());
				} else {
					helper.insertDatabaseMayoralties(resultado.get(i)
							.getNombreAlcaldia(), resultado.get(i)
							.getDirectorALcaldia(), resultado.get(i)
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

	/**
	 * Mensaje en caso de que la base de datos ya se encuentre actualizada a la
	 * fecha
	 */
	private void MessageUpdateComplete() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.warning);
		builder.setMessage(R.string.message_updated_version);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.ok,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						finish();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * Mensaje usado en caso de no haber conexión con el servicio o falla en la
	 * señal del dispositivo
	 */
	private void UpdateMessageError() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.warning);
		builder.setMessage(R.string.message_connection_error);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.try_again,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						UpdateMessage();
					}
				});

		builder.setNegativeButton(R.string.cancel,
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
