package com.nemo.utils;

import java.util.Base64;

/**
 * @author ajay.kg created on 21/09/16.
 */
public class EncryptionUtils {

	public static String getBasicAuthorizationEncodedString(String user, String password) {
		String authString = user + ":" + password;
		String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
		return "Basic ".concat(authStringEnc);
	}

}
