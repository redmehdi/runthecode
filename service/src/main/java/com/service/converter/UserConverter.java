package com.service.converter;

import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import com.base.converter.BaseConverter;
import com.base.exception.ValidationException;
import com.base.util.UtilProcess;
import com.persistence.entities.impl.ContactEntity;
import com.persistence.entities.impl.UserEntity;
import com.service.entities.dto.UserDto;

/**
 * @author RMehdi
 * 
 *
 */
@ComponentScan({ "com.*" })
public final class UserConverter extends BaseConverter<UserEntity, UserDto> {

	private static final Logger log = LoggerFactory.getLogger(UserConverter.class);

	@Override
	public UserDto getDto(UserEntity e) {
		final ContactEntity contacto = e.getContact();
		String email = null;
		String telefono = null;
		final String nombre = e.getNombre();
		final String apellido = e.getApellido();
		final Long edad = e.getEdad();
		final Date inscriptionDate = e.getInscriptionDate();
		final String modifiedNameBy = e.getModifiedNameBy();
		log.debug("create new user: " + apellido);
		if (contacto != null) {
			telefono = contacto.getTelefono();
			try {
				email = UtilProcess.validateEmail(contacto.getEmail());
				log.debug("create new user with contact data" + contacto.getEmail());
			} catch (ValidationException e1) {
				log.error("the email is " + email + "inscription date is incorrect", e1);
			}
		}

		return new UserDto(e.getIdExt(), nombre, apellido, edad.toString(), inscriptionDate.toString(), telefono, email,
				modifiedNameBy);
	}

	@Override
	public UserEntity getEntity(UserDto t) {
		log.debug("create new user" + t.getEmail());
		final String nombre = t.getNombre();
		final String apellido = t.getApellido();
		final String telefono = t.getTelefono();
		final Long edad = UtilProcess.stringToLong(t.getEdad());
		final String modifiedNameBy = t.getChangeBy();
		String email = null;
		Date inscriptionDate = null;

		try {
			email = UtilProcess.validateEmail(t.getEmail());
			inscriptionDate = UtilProcess.stringToDate(t.getInscriptionDate());
		} catch (ValidationException | ParseException e) {
			log.error("the email is " + t.getEmail() + "inscription date is incorrect" + t.getInscriptionDate(), e);
		}

		final ContactEntity contact = t.getId() == null
				? new ContactEntity(modifiedNameBy, modifiedNameBy, telefono, email)
				: new ContactEntity(modifiedNameBy, telefono, email);

		return t.getId() == null
				? new UserEntity(modifiedNameBy, modifiedNameBy, contact, nombre, apellido, edad, inscriptionDate)
				: new UserEntity(modifiedNameBy, contact, nombre, apellido, edad, inscriptionDate);
	}

}
