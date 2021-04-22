package com.path.dbmaps.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.SecretKey;

public class ClientDeviceKeyCO implements Serializable {

	private String mobile_number;
	private String device_UUID;
	private PublicKey frontEndPublicKey;
	private PublicKey backEndPublicKey;
	private PrivateKey backEndPrivateKey;
	private String secretKey;
	private String token;

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getDevice_UUID() {
		return device_UUID;
	}

	public void setDevice_UUID(String device_UUID) {
		this.device_UUID = device_UUID;
	}

	public PublicKey getFrontEndPublicKey() {
		return frontEndPublicKey;
	}

	public void setFrontEndPublicKey(PublicKey frontEndPublicKey) {
		this.frontEndPublicKey = frontEndPublicKey;
	}

	public PublicKey getBackEndPublicKey() {
		return backEndPublicKey;
	}

	public void setBackEndPublicKey(PublicKey backEndPublicKey) {
		this.backEndPublicKey = backEndPublicKey;
	}

	public PrivateKey getBackEndPrivateKey() {
		return backEndPrivateKey;
	}

	public void setBackEndPrivateKey(PrivateKey backEndPrivateKey) {
		this.backEndPrivateKey = backEndPrivateKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ClientDeviceKeyCO(PublicKey frontEndPublicKey, PublicKey backEndPublicKey, PrivateKey backEndPrivateKey,
			String secretKey, String token) {
		super();
		this.frontEndPublicKey = frontEndPublicKey;
		this.backEndPublicKey = backEndPublicKey;
		this.backEndPrivateKey = backEndPrivateKey;
		this.secretKey = secretKey;
		this.token = token;
	}

	public ClientDeviceKeyCO() {
		super();
	}

}
