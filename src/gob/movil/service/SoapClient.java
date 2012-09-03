package gob.movil.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

public class SoapClient {

	/**
	 * Metodo para la conectar con el Servicio web Directorio del Estado
	 * Venezolano con el webMetodo listarInstitucionesPorPoder
	 * 
	 * @param fecha
	 * @return
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static List<Institucion> ListarInstituciones(String fecha)
			throws XmlPullParserException, IOException {
		final String Metodo = "listarInstitucionesPorPoder";
		final String accionSoap = namespace + Metodo;
		// request
		SoapObject request = new SoapObject(namespace, Metodo);
		PropertyInfo pi1 = new PropertyInfo();
		pi1.setName("fecha");
		pi1.setValue(fecha);
		request.addProperty(pi1);

		// Modelo Sobre
		SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		sobre.dotNet = false;
		sobre.setOutputSoapObject(request);

		// Modelo Trasporte
		HttpTransportSE transporte = new HttpTransportSE(url);
		// llamada
		transporte.call(accionSoap, sobre);
		// Resultado

		ArrayList<Institucion> instituciones = new ArrayList<Institucion>();
		List<SoapObject> resultado = (List<SoapObject>) sobre.getResponse();

		for (SoapObject miresultado : resultado) {
			Institucion institucion = new Institucion(
					Integer.parseInt(miresultado.getProperty("idInstitucion")
							.toString()), miresultado.getProperty(
							"nombreInstitucion").toString(), miresultado
							.getProperty("director").toString(), miresultado
							.getProperty("direccion").toString(), miresultado
							.getProperty("telefono").toString(), miresultado
							.getProperty("paginaWeb").toString(), miresultado
							.getProperty("correoElect").toString(),
					Integer.parseInt(miresultado.getProperty("poder")
							.toString()), miresultado.getProperty("fecha")
							.toString());
			instituciones.add(institucion);

		}
		return instituciones;
	}

	/**
	 * Metodo para la conectar con el Servicio web Directorio del Estado
	 * Venezolano con el webMetodo listarAlcaldia
	 * 
	 * @param fecha
	 * @return
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static List<Alcaldia> ListarAlcaldias(String fecha)
			throws XmlPullParserException, IOException {
		final String Metodo = "listarAlcaldia";
		final String accionSoap = namespace + Metodo;
		// request
		SoapObject request = new SoapObject(namespace, Metodo);
		PropertyInfo pi1 = new PropertyInfo();
		pi1.setName("fecha");
		pi1.setValue(fecha);
		request.addProperty(pi1);

		// Modelo Sobre
		SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		sobre.dotNet = false;
		sobre.setOutputSoapObject(request);

		// Modelo Trasporte
		HttpTransportSE transporte = new HttpTransportSE(url);
		// llamada
		transporte.call(accionSoap, sobre);
		// Resultado

		ArrayList<Alcaldia> alcaldias = new ArrayList<Alcaldia>();
		List<SoapObject> resultado = (List<SoapObject>) sobre.getResponse();

		for (SoapObject miresultado : resultado) {
			Alcaldia alcaldia = new Alcaldia(Integer.parseInt(miresultado
					.getProperty("idAlcaldia").toString()), miresultado
					.getProperty("nombreAlcaldia").toString(), miresultado
					.getProperty("directorAlcaldia").toString(), miresultado
					.getProperty("direccionAlcaldia").toString(), miresultado
					.getProperty("telefonoAlcaldia").toString(), miresultado
					.getProperty("webAlcaldia").toString(), miresultado
					.getProperty("correoAlcaldia").toString(), miresultado
					.getProperty("fecha").toString(),
					Integer.parseInt(miresultado.getProperty("estado")
							.toString()));
			alcaldias.add(alcaldia);

		}
		return alcaldias;
	}

	/**
	 * Metodo para la conectar con el Servicio web Directorio del Estado
	 * Venezolano con el webMetodo listarTramitesPorInstitucion
	 * 
	 * @param fecha
	 * @return
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static List<Tramite> ListarTramites(String fecha)
			throws XmlPullParserException, IOException {
		final String Metodo = "listarTramitesPorInstitucion";
		final String accionSoap = namespace + Metodo;
		// request
		SoapObject request = new SoapObject(namespace, Metodo);
		PropertyInfo pi1 = new PropertyInfo();
		pi1.setName("fecha");
		pi1.setValue(fecha);
		request.addProperty(pi1);

		// Modelo Sobre
		SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		sobre.dotNet = false;
		sobre.setOutputSoapObject(request);

		// Modelo Trasporte
		HttpTransportSE transporte = new HttpTransportSE(url);
		// llamada
		transporte.call(accionSoap, sobre);
		// Resultado

		ArrayList<Tramite> tramites = new ArrayList<Tramite>();
		List<SoapObject> resultado = (List<SoapObject>) sobre.getResponse();

		for (SoapObject miresultado : resultado) {
			Tramite tramite = new Tramite(Integer.parseInt(miresultado
					.getProperty("idTramite").toString()), miresultado
					.getProperty("nombreTramite").toString(), miresultado
					.getProperty("telefono").toString(), miresultado
					.getProperty("horarios").toString(), miresultado
					.getProperty("direccion").toString(), miresultado
					.getProperty("descripcion").toString(), miresultado
					.getProperty("costo").toString(), miresultado.getProperty(
					"requisitos").toString(), miresultado.getProperty("fecha")
					.toString());
			tramites.add(tramite);

		}
		return tramites;
	}

}
