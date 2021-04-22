package com.path.dbmaps.vo;

import java.math.BigInteger;

public class ClientDeviceCO {

	private int client_id;
	private String device_UUID;
	private String username;
	private String frontEndPublicKey;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getFrontEndPublicKey() {
		return frontEndPublicKey;
	}

	public void setFrontEndPublicKey(String frontEndPublicKey) {
		this.frontEndPublicKey = frontEndPublicKey;
	}

	public String getDevice_UUID() {
		return device_UUID;
	}

	public void setDevice_UUID(String device_UUID) {
		this.device_UUID = device_UUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
