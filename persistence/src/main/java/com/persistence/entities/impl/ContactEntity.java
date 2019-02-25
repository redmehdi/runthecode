package com.persistence.entities.impl;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.persistence.entities.parents.BaseEntity;

@Entity
@Table(name = "contact")
public class ContactEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, unique=true)
	private String telefono;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@JoinColumn(name = "CONTACT_ID")
	@OneToOne(fetch = LAZY)
	private UserEntity user;
	
	public ContactEntity() {
	}

	/**
	 * This constructor is for new contact creation
	 * 
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param modificationDate
	 * @param id
	 * @param telefono
	 * @param email
	 */
	public ContactEntity(String createdNameBy, String modifiedNameBy, String telefono, String email) {
		super(createdNameBy, modifiedNameBy);
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * This constructor is for modification
	 * @param modifiedNameBy
	 * @param telefono
	 * @param email
	 */
	public ContactEntity(String modifiedNameBy, String telefono, String email) {
		super(modifiedNameBy);
		this.telefono = telefono;
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ContactEntity [id=" + this.getId() + ", telefono=" + telefono + ", email=" + email + "]";
	}

}
