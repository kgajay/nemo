package com.nemo.utils;

import java.util.Random;

/**
 * @author ajay.kg created on 15/05/16.
 */
public class SanityUtils {

	private static final String regHyphen = "\\-";
	private static final String vehicleRegex = "^([a-zA-Z]{1,2})([0-9]{1,2})([a-zA-Z]{1,4})([0-9]{1,7})$";
	private static final String nameInvalidRegex = "[^a-zA-Z ]+";
	private static final String whitespaceRegex = "[\\s]+";
	private static final Random random = new Random();

	public static String getLastNChars(String input, int length) {
		return input.substring(input.length() - length);
	}

	public static String sanitizeVehicleNumber(String vehicleNumber) {
		return vehicleNumber.replaceAll(regHyphen, "");
	}

	public static String sanitizeName(String name) {
		name = name.trim();
		name = name.replaceAll(nameInvalidRegex, "");
		name = name.replaceAll(whitespaceRegex, " ");
		return name;
	}

	public static String getRandomNum() {
		long ran = random.nextLong();
		ran = ran % 2000000000;
		return Long.toString((ran * ran) % 400000000000000000L);
	}

	public static String sanitizeLength(String name, int length) {
		int len = name.length() < length ? name.length() : length;
		return name.substring(0, len);
	}

	public static String removePrefixedZero(String string) {
		String patt = "^0(.*)";
		if (string.matches(patt)) {
			return string.substring(1);
		}
		return string;
	}

	public static String capitalize(String string) {
		if (string == null || string.length() == 0) {
			return string;
		}
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

//	public static void main(String []args) {
//		System.out.println(tfsToOlaVehicleType1(sanitizeVehicleNumber("DL-1RTA1355")));
//		System.out.println(tfsToOlaVehicleType2(sanitizeVehicleNumber("DL-1RTA1355")));
//		System.out.println(tfsToOlaVehicleType3(sanitizeVehicleNumber("DL-1RTA1355")));
//		System.out.println(tfsToOlaVehicleType1(sanitizeVehicleNumber("WB-050426")));
//		System.out.println(tfsToOlaVehicleType2(sanitizeVehicleNumber("WB-050426")));
//		System.out.println(tfsToOlaVehicleType3(sanitizeVehicleNumber("WB-050426")));
//	}

}
