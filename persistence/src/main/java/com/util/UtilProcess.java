/**
 * 
 */
package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author RMehdi
 *
 */
public final class UtilProcess {
	
	public final static String generateId(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * @param date
	 * @return {@link Date}
	 * @throws ParseException
	 */
	public final static Date stringToDate(final String date) throws ParseException{
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

}
