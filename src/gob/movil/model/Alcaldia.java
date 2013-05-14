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
package gob.movil.model;

/**
 * Modelo de datos para alcaldías.
 * 
 * @author Ehison Pérez
 * 
 */
public class Alcaldia {

	private int idAlcaldia;
	private String nombreAlcaldia;
	private String nombreMunicipio;
	private String directorAlcaldia;
	private String direccionAlcaldia;
	private String telefonoAlcaldia;
	private String webAlcaldia;
	private String fecha;
	private int estado;

	public Alcaldia() {
	}

	public Alcaldia(int idAlcaldia, String nombreAlcaldia,
			String directorAlcaldia, String nombreMunicipio,
			String direccionAlcaldia, String telefonoAlcaldia,
			String webAlcaldia, String fecha, int estado) {
		this.idAlcaldia = idAlcaldia;
		this.nombreAlcaldia = nombreAlcaldia;
		this.nombreMunicipio = nombreMunicipio;
		this.directorAlcaldia = directorAlcaldia;
		this.direccionAlcaldia = direccionAlcaldia;
		this.telefonoAlcaldia = telefonoAlcaldia;
		this.webAlcaldia = webAlcaldia;
		this.fecha = fecha;
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getWebAlcaldia() {
		return webAlcaldia;
	}

	public void setWebAlcaldia(String web) {
		this.webAlcaldia = web;
	}

	public String getTelefonoAlcaldia() {
		return telefonoAlcaldia;
	}

	public void setTelefonoAlcaldia(String telefonoAlcaldia) {
		this.telefonoAlcaldia = telefonoAlcaldia;
	}

	public String getDireccionALcaldia() {
		return direccionAlcaldia;
	}

	public void setDireccionAlcaldia(String direccionAlcaldia) {
		this.direccionAlcaldia = direccionAlcaldia;
	}

	public String getDirectorALcaldia() {
		return directorAlcaldia;
	}

	public void setDirectorAlcaldia(String director) {
		this.directorAlcaldia = director;
	}

	public int getIdAlcaldia() {
		return idAlcaldia;
	}

	public String getNombreAlcaldia() {
		return nombreAlcaldia;
	}

	public void setIdAlcaldia(int idPoder) {
		this.idAlcaldia = idPoder;
	}

	public void setNombreAlcaldia(String nombreAlcaldia) {
		this.nombreAlcaldia = nombreAlcaldia;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
}
