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
package gob.movil.service;

import gob.movil.info.Constants;
import gob.movil.model.Alcaldia;
import gob.movil.model.Institucion;
import gob.movil.model.Tramite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

/**
 * Clase que se encarga de la conexión del cliente mediante SOAP.
 * 
 * @author Ehison Pérez
 * @author Richard Ricciardelli
 * 
 */
public class SoapClient implements Constants {
	private static final String SOAP_OPERATION_INSTITUTIONS = "listarInstitucionesPorFecha";
	private static final String SOAP_OPERATION_MAYORALTIES = "listarAlcaldiaPorFecha";
	private static final String SOAP_OPERATION_PROCEDURES = "listarTramitesPorFecha";

	public static List<Institucion> listarInstituciones(String date, int method)
			throws IOException, XmlPullParserException {
		ArrayList<Institucion> instituciones = new ArrayList<Institucion>();
		switch (method) {
		case 1:
			instituciones = getInstitutionList(date, false);
			break;
		case 2:
			instituciones = getInstitutionList(date, true);
		default:
			break;
		}
		return instituciones;
	}

	public static List<Alcaldia> listarAlcaldias(String date, int method)
			throws NumberFormatException, IOException, XmlPullParserException {
		ArrayList<Alcaldia> alcaldias = new ArrayList<Alcaldia>();
		switch (method) {
		case 1:
			alcaldias = getMayoraltiesList(date, false);
			break;
		case 2:
			alcaldias = getMayoraltiesList(date, true);
		default:
			break;
		}
		return alcaldias;
	}

	public static List<Tramite> listarTramites(String date, int method)
			throws NumberFormatException, IOException, XmlPullParserException {
		ArrayList<Tramite> tramites = new ArrayList<Tramite>();
		switch (method) {
		case 1:
			Log.i("Metodo", "Entrando en el prime case");
			tramites = getProceduresList(date, false);
			break;
		case 2:
			Log.i("Metodo", "Entrando en el segundo case");
			tramites = getProceduresList(date, true);
		default:
			break;
		}
		return tramites;
	}

	private static ArrayList<Institucion> getInstitutionList(String date,
			boolean confirmation) throws NumberFormatException, IOException,
			XmlPullParserException {
		ArrayList<Institucion> institutions = new ArrayList<Institucion>();
		for (SoapObject result : getResponse(SOAP_OPERATION_INSTITUTIONS, date)) {
			Institucion institution = new Institucion(Integer.parseInt(result
					.getProperty("idInstitucion").toString()), result
					.getProperty("nombreSector").toString(), result
					.getProperty("nombreInstitucion").toString(), result
					.getProperty("director").toString(), result.getProperty(
					"direccion").toString(), result.getProperty("telefono")
					.toString(), result.getProperty("paginaWeb").toString(),
					Integer.parseInt(result.getProperty("poder").toString()),
					result.getProperty("fecha").toString());
			institutions.add(institution);
			if (confirmation && institutions != null)
				break;
		}
		return institutions;
	}

	private static ArrayList<Alcaldia> getMayoraltiesList(String date,
			boolean confirmation) throws NumberFormatException, IOException,
			XmlPullParserException {
		ArrayList<Alcaldia> mayoralties = new ArrayList<Alcaldia>();
		for (SoapObject result : getResponse(SOAP_OPERATION_MAYORALTIES, date)) {
			Alcaldia mayoralty = new Alcaldia(
					Integer.parseInt(result.getProperty("idAlcaldia").toString()), 
					result.getProperty("nombreMunicipio").toString(), 
					result.getProperty("nombreAlcaldia").toString(), 
					result.getProperty("directorAlcaldia").toString(),
					result.getProperty("direccionAlcaldia").toString(), 
					result.getProperty("telefonoAlcaldia").toString(), 
					result.getProperty("webAlcaldia").toString(), 
					result.getProperty("fecha").toString(), 
					Integer.parseInt(result.getProperty("estado").toString()));
			mayoralties.add(mayoralty);
			if (confirmation && mayoralties != null)
				break;
		}
		return mayoralties;
	}

	private static ArrayList<Tramite> getProceduresList(String date,
			boolean confirmation) throws NumberFormatException, IOException,
			XmlPullParserException {
		ArrayList<Tramite> procedures = new ArrayList<Tramite>();
		Log.i("Metodo", "Ingresando al ciclo for para llenar los datos");
		for (SoapObject result : getResponse(SOAP_OPERATION_PROCEDURES, date)) {
			Tramite procedure = new Tramite(Integer.parseInt(result
					.getProperty("idTramite").toString()), result.getProperty(
					"nombreTramite").toString(), result.getProperty("telefono")
					.toString(), result.getProperty("horarios").toString(),
					result.getProperty("direccion").toString(), result
							.getProperty("descripcion").toString(), result
							.getProperty("requisitos").toString(), result
							.getProperty("fecha").toString());
			procedures.add(procedure);
			if (confirmation && procedures != null)
				break;
		}
		return procedures;
	}

	@SuppressWarnings("unchecked")
	private static List<SoapObject> getResponse(final String method, String date)
			throws IOException, XmlPullParserException {
		final String soapAction = NAMESPACE + method;
		Log.i("Metodo", "Valor del soap accion es: " + soapAction);
		SoapObject soapObject = new SoapObject(NAMESPACE, method);
		Log.i("Metodo", "soapObject a sido creado ");
		PropertyInfo propertyInfo = new PropertyInfo();
		propertyInfo.setName("fecha");
		Log.i("Metodo", "fecha a enviar al metodo del WS: " + date);
		propertyInfo.setValue(date);
		soapObject.addProperty(propertyInfo);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = false;
		envelope.setOutputSoapObject(soapObject);
		HttpTransportSE transport = new HttpTransportSE(WEB_SERVICE_URL);
		transport.call(soapAction, envelope);
		Log.i("Metodo", "Se logro el trasporte y llamado");
		List<SoapObject> list = new ArrayList<SoapObject>();
		try {
			list = (List<SoapObject>) envelope.getResponse();
			Log.i("Metodo", "Se lleno la lista con la respuesta");
		} catch (Exception e) {
			list.add((SoapObject) envelope.getResponse());
		}
		return list;
	}
}