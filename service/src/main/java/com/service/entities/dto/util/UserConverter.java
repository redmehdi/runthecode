package com.service.entities.dto.util;

import java.text.ParseException;
import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.persistence.entities.impl.ContactEntity;
import com.persistence.entities.impl.UserEntity;
import com.service.entities.dto.UserDto;
import com.util.UtilProcess;

@ComponentScan({"com.*"})
public final class UserConverter {

	public static UserEntity getUserEntity(UserDto dto) throws ParseException {
		final String modifiedNameBy = dto.getChangeBy();
		final Date inscriptionDate = UtilProcess.stringToDate(dto.getInscriptionDate());
		final ContactEntity contact = new ContactEntity(modifiedNameBy, modifiedNameBy, dto.getTelefono(),
				dto.getEmail());
		return new UserEntity(modifiedNameBy, modifiedNameBy, contact, dto.getNombre(), dto.getApellido(),
				dto.getEdad(), inscriptionDate);
	}

	public static UserDto getUserDto(UserEntity entity) {
		final ContactEntity contact = entity.getContact();
		String email = "";
		String telefono = "";
		if (contact != null) {
			telefono = contact.getTelefono();
			email = contact.getEmail();

		}
		return new UserDto(entity.getIdExt(), entity.getNombre(), entity.getApellido(), entity.getEdad(),
				entity.getInscriptionDate().toString(), telefono, email, null);
	}

}
