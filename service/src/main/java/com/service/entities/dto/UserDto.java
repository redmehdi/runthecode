package com.service.entities.dto;

public class UserDto {

	private String id;

	private String nombre;

	private String apellido;

	private Long edad;

	private String inscriptionDate;

	private String telefono;

	private String email;

	private String changeBy;

	public UserDto(String id, String nombre, String apellido, Long edad, String inscriptionDate, String telefono,
			String email, String changeBy) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.inscriptionDate = inscriptionDate;
		this.telefono = telefono;
		this.email = email;
		this.changeBy = changeBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getEdad() {
		return edad;
	}

	public void setEdad(long edad) {
		this.edad = edad;
	}

	public String getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (edad ^ (edad >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (edad != other.edad)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"UserDto [id=%s, nombre=%s, apellido=%s, edad=%s, inscriptionDate=%s, telefono=%s, email=%s]", id,
				nombre, apellido, edad, inscriptionDate, telefono, email);
	}

}
