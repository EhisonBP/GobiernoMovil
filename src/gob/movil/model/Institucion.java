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
 * Modelo de datos para las instituciones.
 * 
 * @author Ehison Pérez
 * 
 */
public class Institucion {

	private int idInstitucion;
	private String nombreInstitucion;
	private String nombreSector;
	private String director;
	private String direccion;
	private String telefono;
	private String paginaWeb;
	private String correoElect;
	private int poder;
	private String fecha;

	public Institucion() {
	}

	public Institucion(int idInstituto, String nombreSector,
			String nombreInstituto, String director, String direccion,
			String telefono, String web, String correoElect, int poder,
			String fecha) {
		this.idInstitucion = idInstituto;
		this.nombreInstitucion = nombreInstituto;
		this.nombreSector = nombreSector;
		this.director = director;
		this.direccion = direccion;
		this.telefono = telefono;
		this.paginaWeb = web;
		this.correoElect = correoElect;
		this.poder = poder;
		this.fecha = fecha;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCorreoElect() {
		return correoElect;
	}

	public void setCorreoElect(String correoElect) {
		this.correoElect = correoElect;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(int idInstituto) {
		this.idInstitucion = idInstituto;
	}

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstituto) {
		this.nombreInstitucion = nombreInstituto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPaginatWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String web) {
		this.paginaWeb = web;
	}

	public String getNombreSector() {
		return nombreSector;
	}

	public void setNombreSector(String nombreSector) {
		this.nombreSector = nombreSector;
	}
}