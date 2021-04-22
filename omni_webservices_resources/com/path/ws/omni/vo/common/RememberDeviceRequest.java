package com.path.ws.omni.vo.common;

import java.math.BigInteger;

public class RememberDeviceRequest extends OmniCommonRequest {

	private String device_UUID;
	private int client_id;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getDevice_UUID() {
		return device_UUID;
	}

	public void setDevice_UUID(String device_UUID) {
		this.device_UUID = device_UUID;
	}

}
