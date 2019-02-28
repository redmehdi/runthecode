package com.service.entities.dto.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import com.persistence.entities.impl.ContactEntity;
import com.persistence.entities.impl.UserEntity;
import com.service.entities.dto.UserDto;
import com.service.entities.exception.ValidationException;

/**
 * @author RMehdi
 * 
 *
 */
@ComponentScan({ "com.*" })
public final class UserConverter {

	private static final Logger log = LoggerFactory.getLogger(UserConverter.class);

	/**
	 * Converter for creation of new user
	 * 
	 * @param dto
	 * @return {@link UserEntity}
	 * @throws ParseException
	 * @throws ValidationException
	 */
	public static UserEntity getUserEntityNew(UserDto dto) throws ParseException, ValidationException {

		log.debug("create new user" + dto.getEmail());
		final String nombre = dto.getNombre();
		final String apellido = dto.getApellido();
		final String email = UtilProcessService.validateEmail(dto.getEmail());
		final String telefono = dto.getTelefono();
		final Long edad = UtilProcessService.stringToLong(dto.getEdad());
		final Date inscriptionDate = UtilProcessService.stringToDate(dto.getInscriptionDate());
		final String modifiedNameBy = dto.getChangeBy();
		final ContactEntity contact = new ContactEntity(modifiedNameBy, modifiedNameBy, telefono, email);

		return new UserEntity(modifiedNameBy, modifiedNameBy, contact, nombre, apellido, edad, inscriptionDate);
	}

	/**
	 * Converter for modification of existing user
	 * 
	 * @param dto
	 * @return {@link UserEntity}
	 * @throws ParseException
	 * @throws ValidationException
	 */
	public static UserEntity getUserEntityModify(UserDto dto) throws ParseException, ValidationException {

		log.debug("modify user" + dto.getEmail());
		final String nombre = dto.getNombre();
		final String apellido = dto.getApellido();
		final String email = UtilProcessService.validateEmail(dto.getEmail());
		final String telefono = UtilProcessService.validatePhone(dto.getTelefono());
		final Long edad = UtilProcessService.stringToLong(dto.getEdad());
		final Date inscriptionDate = UtilProcessService.stringToDate(dto.getInscriptionDate());
		final String modifiedNameBy = dto.getChangeBy();
		final ContactEntity contact = new ContactEntity(modifiedNameBy, telefono, email);

		return new UserEntity(modifiedNameBy, contact, nombre, apellido, edad, inscriptionDate);
	}

	/**
	 * Converter to retrieve stored user
	 * 
	 * @param dto
	 * @return {@link UserEntity}
	 * @throws ParseException
	 * @throws ValidationException
	 */
	public static UserDto getUserDto(UserEntity entity) {

		final ContactEntity contact = entity.getContact();
		String email = "";
		String telefono = "";
		if (contact != null) {
			telefono = contact.getTelefono();
			email = contact.getEmail();

		}
		return new UserDto(entity.getIdExt(), entity.getNombre(), entity.getApellido(), entity.getEdad().toString(),
				entity.getInscriptionDate().toString(), telefono, email, entity.getModifiedNameBy());
	}

	public static List<UserDto> getUserDtos(Iterable<UserEntity> findAll) {

		List<UserDto> dtos = new ArrayList<>();
		findAll.forEach(
				(k) -> dtos.add(new UserDto(k.getIdExt(), k.getNombre(), k.getApellido(), k.getEdad().toString(),
						k.getInscriptionDate().toString(), k.getContact() != null ? k.getContact().getTelefono() : "",
						k.getContact() != null ? k.getContact().getEmail() : "", k.getModifiedNameBy())));

		return dtos;
	}

}
