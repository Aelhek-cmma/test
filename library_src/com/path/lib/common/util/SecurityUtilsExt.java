package com.path.lib.common.util;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Base64Utils;

import de.taimos.totp.TOTP;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//import de.taimos.totp.TOTP;

/**
 * DENISK_LATEST_VERS_UPDATED Copyright 2013, Path Solutions Path Solutions
 * retains all ownership rights to this source code
 * 
 * @author: deniskhaddad
 * 
 *          SecurityUtilsExt.java used to provide methods for security Used By
 *          PB code, and within Java aslo
 */
public final class SecurityUtilsExt {
	public final static String ALGORITHM = "AES";
	public final static String ALGORITHM_CBC_NOPADDING = "AES/CBC/NoPadding";
	private final static String ALGORITHM_CBC_NOPADDING_PWD = "PATHSOLUTIONS123";
	private final static String ALGORITHM_SESSION_TOKEN_PWD = "123PATHSOLUTIONS";
	public final static String DEFAULT_ENCODING = "UTF-8";
	public final static String SESSION_TOKEN_KEY = "PATH_SESSION_TOKEN";
	public final static String PATH_ENC_PWD = "PATH_ENC_PWD";
	private final static int ITERATIONS = 20 * 1000;
	private final static int saltLen = 32;
	private final static int DESIREDKEYLEN = 256;
	private static final Random RANDOM = new SecureRandom();
	static Properties prop = new Properties();

	/**
	 * Private constructor to prevent class from instantiation
	 */
	private SecurityUtilsExt() {
		// no need to include anything since this class is used for PB to call
		// security encryption process
	}

	/**
	 * 
	 * Used for encryption using AES Java Algorithm
	 * 
	 * @param theKey
	 * @param theValue
	 * @return
	 */
	public static String encryptAES(String theKey, String theValue) throws Exception {
		if (theKey != null && theKey.length() != 16) {
			throw new Exception("ERROR: Key should be exact of 16 Character Length");
		}
		Cipher c = Cipher.getInstance(ALGORITHM);
		Key aesKey = new SecretKeySpec(theKey.getBytes(DEFAULT_ENCODING), ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, aesKey);
		byte[] encVal = c.doFinal(theValue.getBytes(DEFAULT_ENCODING));
		return encodeB64(encVal);
	}

	/**
	 * Method that perform Cypher Java standard encryption
	 * 
	 * @param theAlgorithm the Algorithm used for Encryption Example AES,
	 *                     AES/CBC/PKCS5Padding
	 * @param theKey       The secret Key to encrypt with
	 * @param theIv        THe Initialization Vector to use in encryption
	 * @param theValue     Value to encrypt
	 * @return encrypted value
	 * @throws Exception
	 */
	public static String encryptCustom(String theAlgorithm, String theKey, String theIv, String theValue)
			throws Exception {
		Cipher cipher = Cipher.getInstance(theAlgorithm);
		cipher.init(Cipher.ENCRYPT_MODE, generateKey(theKey), generateIv(theIv));
		return encodeB64(cipher.doFinal(theValue.getBytes()));
	}

	/**
	 * Method that perform Cypher Java standard encryption
	 * 
	 * @param theAlgorithm the Algorithm used for Encryption Example AES,
	 *                     AES/CBC/PKCS5Padding
	 * @param theKey       The secret Key to encrypt with
	 * @param theIv        THe Initialization Vector to use in encryption
	 * @param theValue     Value to encrypt
	 * @return encrypted value
	 * @throws Exception
	 */
	public static String encryptCustom(String theAlgorithm, byte[] theKey, byte[] theIv, byte[] theValue)
			throws Exception {
		Cipher cipher = Cipher.getInstance(theAlgorithm);
		cipher.init(Cipher.ENCRYPT_MODE, generateKey(theKey), generateIv(theIv));
		return encodeB64(cipher.doFinal(theValue));
	}

	/**
	 * Method that perform Cypher Java standard decryption
	 * 
	 * @param theAlgorithm the Algorithm used for decryption Example AES,
	 *                     AES/CBC/PKCS5Padding
	 * @param theKey       The secret Key to derypt with
	 * @param theIv        THe Initialization Vector to use in decryption
	 * @param theValue     Value to derypt
	 * @return decrypted value
	 * @throws Exception
	 */
	public static String decryptCustom(String theAlgorithm, String theKey, String theIv, String theValue)
			throws Exception {
		Cipher cipher = Cipher.getInstance(theAlgorithm);
		cipher.init(Cipher.DECRYPT_MODE, generateKey(theKey), generateIv(theIv));
		return new String(cipher.doFinal(decodeB64(theValue)));
	}

	/**
	 * Method that perform Cypher Java standard decryption
	 * 
	 * @param theAlgorithm the Algorithm used for decryption Example AES,
	 *                     AES/CBC/PKCS5Padding
	 * @param theKey       The secret Key to derypt with
	 * @param theIv        THe Initialization Vector to use in decryption
	 * @param theValue     Value to derypt
	 * @return decrypted value
	 * @throws Exception
	 */
	public static String decryptCustom(String theAlgorithm, byte[] theKey, byte[] theIv, byte[] theValue)
			throws Exception {
		Cipher cipher = Cipher.getInstance(theAlgorithm);
		cipher.init(Cipher.DECRYPT_MODE, generateKey(theKey), generateIv(theIv));
		return new String(cipher.doFinal(SecurityUtils.decodeB64NoCharEncoding(theValue)));
	}

	private static Key generateKey(String theKeyValue) throws Exception {
		return generateKey(theKeyValue.getBytes(DEFAULT_ENCODING));

	}

	private static Key generateKey(byte[] theKeyValue) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] key = md.digest(theKeyValue);
		return new SecretKeySpec(key, ALGORITHM);

	}

	private static AlgorithmParameterSpec generateIv(String theIv) throws Exception {
		return generateIv(theIv.getBytes(DEFAULT_ENCODING));
	}

	private static AlgorithmParameterSpec generateIv(byte[] theIv) throws Exception {
		return new IvParameterSpec(theIv);
	}

	/**
	 * 
	 * Used for Base 64 encoding
	 * 
	 * @param theBytes
	 * @return
	 */
	public static String encodeB64(byte[] theBytes) throws Exception {
		String result = "";
		if (theBytes != null) {
			result = new String(Base64Utils.encode(theBytes), DEFAULT_ENCODING);
		}
		return result;
	}

	/**
	 * Method to decode BAse64 encoded String as UTF-8 encoding and return related
	 * bytes
	 * 
	 * @param theEncodedValue, the Encoded Values
	 * @return Byte array of the decoded result
	 * @throws Exception
	 */
	public static byte[] decodeB64(String theEncodedValue) throws Exception {
		byte[] result = null;
		if (theEncodedValue != null) {
			result = Base64Utils.decode(theEncodedValue.getBytes(DEFAULT_ENCODING));
		}
		return result;
	}

	/**
	 * 
	 * Used for decryption of encrypted Data using particular Key
	 * 
	 * @param theKey
	 * @param encryptedData
	 * @return
	 * @throws Exception
	 */
	public static String decryptAES(String theKey, String encryptedData) throws Exception {
		if (theKey != null && theKey.length() != 16) {
			throw new Exception("ERROR: Key should be of 16 Character Length");
		}
		Key aesKey = new SecretKeySpec(theKey.getBytes(DEFAULT_ENCODING), ALGORITHM);
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, aesKey);
		byte[] decodedValue = Base64Utils.decode(encryptedData.getBytes(DEFAULT_ENCODING));
		byte[] decValue = c.doFinal(decodedValue);
		return new String(decValue, DEFAULT_ENCODING);
	}

	/**
	 * generate the secret key for decryption
	 * 
	 * @return
	 * 
	 */
	public static byte[] generateSecretKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256);
		SecretKey secretKey = keyGen.generateKey();
		System.out.println(secretKey);
		byte[] byteSecretKey = secretKey.getEncoded();
		System.out.println("the secret key in byte is " + byteSecretKey);
		return byteSecretKey;
	}

	/**
	 * encrypt the secret key using the public key of the front end
	 * 
	 * @param frontEndPublicKey
	 * @param secretKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSecretKey(PublicKey frontEndPublicKey, byte[] secretKey) throws Exception {
		Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		c.init(Cipher.ENCRYPT_MODE, frontEndPublicKey);
		byte[] cipherSecretKey = c.doFinal(secretKey);
		System.out.println(encodeB64(cipherSecretKey));
		return cipherSecretKey;

	}

	/**
	 * generate public key and secret key for back end
	 * 
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	public static KeyPair generatePairKey() throws NoSuchAlgorithmException {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(1024);
		return kpg.generateKeyPair();
	}

	/**
	 * method that convert bigInteger to public key
	 * 
	 * @param publicKey as BigInteger
	 * @return publicKey
	 * @throws InvalidKeySpecException ,NoSuchAlgorithmException
	 * 
	 */

	public static PublicKey convertToPublicKey(BigInteger publicKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		byte[] publicKeyAsByte = publicKey.toByteArray();
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyAsByte);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey pubKey = keyFactory.generatePublic(keySpec);
		return pubKey;
	}

	public static PublicKey convertStringToPublicKey(String frontEndPublicKey)
			throws Exception {

//		System.out.println(Base64.class.getProtectionDomain().getCodeSource().getLocation());
		byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(frontEndPublicKey);
		org.bouncycastle.asn1.pkcs.RSAPublicKey pkcs1PublicKey = org.bouncycastle.asn1.pkcs.RSAPublicKey
				.getInstance(decoded);
//		BigInteger modulus = pkcs1PublicKey.getModulus();
//		BigInteger publicExponent = pkcs1PublicKey.getPublicExponent();
		RSAPublicKeySpec keySpec = new RSAPublicKeySpec(pkcs1PublicKey.getModulus(),
				pkcs1PublicKey.getPublicExponent());
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(keySpec);
	}

	/**
	 * method that encrypt an object @param secretKey
	 * 
	 * @param secretKey
	 * @param object
	 * @throws IOException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * 
	 * 
	 */

	public static void EncryptObject(byte[] secretKey, Object object) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException {

		SecretKey originalKey = new SecretKeySpec(secretKey, 0, secretKey.length, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, originalKey);
		SealedObject sealedObject = new SealedObject((Serializable) object, cipher);
		System.out.println(sealedObject);
	}

	/**
	 * method that encrypt a String with secret key
	 * 
	 * @param secretKey
	 * @param message
	 * @return
	 * @throws IOException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String EncryptWithSecretKey(SecretKey secretKey, String message) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException, BadPaddingException {

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] byteMessage = message.getBytes("UTF-8");
		byte[] encrypted = cipher.doFinal(byteMessage);
		return new String(encrypted);

	}

	/**
	 * method that decrypt a string with secret key
	 * 
	 * @param secretKey
	 * @param encryptedMessage
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * 
	 */
	public static String decryptWithSecretKey(SecretKey secretKey, String encryptedMessage)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException {

		byte[] decodedBytesEncryptedText = Base64.getDecoder().decode(encryptedMessage.getBytes());
		Cipher cipher2 = Cipher.getInstance("AES");
		cipher2.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] bytedecrepted = cipher2.doFinal(decodedBytesEncryptedText);
		return new String(bytedecrepted);

	}

	/**
	 * method that decrypt a front end secret key (encrypted with back end public
	 * key) with back end private key
	 * 
	 * @param backEndPrivateKey
	 * @param
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] decryptSecretKey(PrivateKey backEndPrivateKey, byte[] encryptedSecretKey)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.PRIVATE_KEY, backEndPrivateKey);
		byte[] decryptedKey = cipher.doFinal(encryptedSecretKey);
		return decryptedKey;
	}

	/**
	 * method that generate a secret key as string used in generation of OTP , and
	 * generate token
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateSecretKeyAsString() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secretKey = keyGen.generateKey();
		String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		return encodedSecretKey;
	}

	public static String generateSecretKeyTOTP() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);
		Base32 base32 = new Base32();
		return base32.encodeToString(bytes);
	}

	/**
	 * method that generate OTP
	 * 
	 * @param secretKey
	 * @return
	 */
	public static String getTOTPCode(String secretKey) {
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(secretKey);
		String hexKey = Hex.encodeHexString(bytes);
		return TOTP.getOTP(hexKey);
	}

	/**
	 * method that valid the otp
	 * 
	 * @param
	 * @return
	 */
	public static boolean validateOTP(String secretKey, String otp) {
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(secretKey);
		String hexKey = Hex.encodeHexString(bytes);
		return TOTP.validate(hexKey, otp);
	}

	/**
	 * method to get salt Returns a random salt to be used to hash a password.
	 * 
	 * @return a 16 bytes random salt
	 */

	public static String getNextSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return new String(salt);
	}

	public static String hash(String password, String salt) {
		char[] pass = password.toCharArray();
		byte[] saltByte = salt.getBytes();
		PBEKeySpec spec = new PBEKeySpec(pass, saltByte, ITERATIONS, DESIREDKEYLEN);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return new String(skf.generateSecret(spec).getEncoded());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}

	/**
	 * 
	 * method to verify the password ,returns true if the given password and salt
	 * match the hashed value, false otherwise
	 * 
	 * @param password     the password to check
	 * @param salt         the salt used to hash the password
	 * @param expectedHash the expected hashed value of the password
	 * @return
	 */
	public static boolean validatePassword(String passwordRequest, String salt, String expectedHash) {
		return hash(passwordRequest, salt).equals(expectedHash);
	}

	public static String hashPassword(String username, String password) throws IOException {
		prop = PropertiesLoaderUtils.loadAllProperties("HashPassword.properties");
		String value = prop.getProperty("value");
		String pass = username + password + value;
		String salt = SecurityUtilsExt.getNextSalt();
		String hash = SecurityUtilsExt.hash(pass, salt);
		return hash;
	}

	/**
	 * method that generate a token
	 * 
	 * @param secretKey
	 * @param device_serial
	 * @param sim_serial
	 * @return
	 */

	public static String generateToken(String secretKey, String device_serial, String username) {
		try {

			return Jwts.builder().claim("device_serial", device_serial).claim("username", username)
					.signWith(SignatureAlgorithm.HS256, secretKey.getBytes()).compact();

		} catch (Exception e) {
			return null;
		}
	}

	public static Claims validateToken(String secretKey, String token) {

		Claims jwt = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
		return jwt;

	}

	/**
	 * return the ALGORITHM_CBC_NOPADDING_PWD
	 * 
	 * @return
	 */

	public static String returnAlgorithmCbcNopaddingPwd() {
		return ALGORITHM_CBC_NOPADDING_PWD;
	}

	/**
	 * return the ALGORITHM_SESSION_TOKEN_PWD
	 * 
	 * @return
	 */
	public static String returnAlgorithmSessionTokenPwd() {
		return ALGORITHM_SESSION_TOKEN_PWD;
	}

}
