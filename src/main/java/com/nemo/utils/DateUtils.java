package com.nemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ajay.kg created on 15/05/16.
 */
public class DateUtils {

	public Date stringToDate(String date, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date dateObj = formatter.parse(date);
		return dateObj;
	}

	public String dateToString(Date dateObj, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String date = formatter.format(dateObj);
		return date;
	}

	public Date addNDaysToDate(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	/**
	 * Resets milliseconds, seconds, minutes and hours from the provided date
	 *
	 * @param date
	 * @return
	 */
	public Date trim(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return calendar.getTime();
	}

}
