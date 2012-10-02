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

/**
 * Clase para actualizar la base de datos realizando una conexión al servicio
 * web de Gobierno en Línea.
 * 
 * @author Ehison Pérez
 * 
 */
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

	// TODO What's this?
	/**
	 * Mensaje que mostrara mientras los usuarios espera que se carguen los
	 * nuevos datos
	 */

	/**
	 * Mensaje usado al presionar el botón actualizar del menú principal
	 */
	private void UpdateMessage() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.confirm);
		builder.setMessage(R.string.message_update);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.yes,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						update();
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
	 * Procedimiento para la actualización de la tabla de trámites.
	 * 
	 * @param resultado
	 *            Listado de trámites
	 */
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

	/**
	 * Separación de la lógica de la actualización.
	 */
	private void update() {
		String fecha = helper.fechaActualizacion();
		int errorException = 0;
		int errorConection = 0;
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
				errorConection++;
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
				errorConection++;
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
				errorConection++;
			}
		}
		if (errorException == 3)
			messageUpdateComplete();
		if (errorConection > 0)
			updateMessageError();
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

	/**
	 * Mensaje en caso de que la base de datos ya se encuentre actualizada a la
	 * fecha.
	 */
	private void messageUpdateComplete() {
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
	 * Mensaje usado en caso de no existir conexión con el servicio web o falla
	 * en la señal del dispositivo.
	 */
	private void updateMessageError() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.warning);
		builder.setMessage(R.string.message_connection_error);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.try_again,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						update();
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