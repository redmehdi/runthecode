package com.rest.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserDtoRequest {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String nombre;

	private String apellido;

	private String edad;

	private String inscriptionDate;

	private String telefono;

	private String email;

	private String changeBy;

	public String getNombre() {
		return nombre;
	}

	@JsonSetter("Nombre")
	public void setNombreUpper(String nombre) {
	    this.nombre = nombre;
	}
	@JsonSetter("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@JsonSetter("apellido")
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@JsonSetter("Apellido")
	public void setApellidoUpper(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return edad;
	}

	@JsonSetter("edad")
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	@JsonSetter("Edad")
	public void setEdadUpper(String edad) {
		this.edad = edad;
	}

	public String getInscriptionDate() {
		return inscriptionDate;
	}

	@JsonSetter("inscriptionDate")
	public void setInscriptionDate(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
	
	@JsonSetter("InscriptionDate")
	public void setInscriptionDateUpper(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getTelefono() {
		return telefono;
	}

	@JsonSetter("telefono")
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@JsonSetter("Telefono")
	public void setTelefonoUpper(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	@JsonSetter("email")
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonSetter("Email")
	public void setEmailUpper(String email) {
		this.email = email;
	}

	public String getChangeBy() {
		return changeBy;
	}

	@JsonSetter("changeBy")
	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}
	
	@JsonSetter("ChangeBy")
	public void setChangeByUpper(String changeBy) {
		this.changeBy = changeBy;
	}

	

}
