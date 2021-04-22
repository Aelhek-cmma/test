package com.path.lib.common.util;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

import de.taimos.totp.TOTP;

public class Otp {

	/**
	 * method that valid the otp
	 * @param
	 * @return
	 */
	public boolean validateOTP(String secretKey, String otp) {
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(secretKey);
		String hexKey = Hex.encodeHexString(bytes);
		return TOTP.validate(hexKey, otp);
	}
}
