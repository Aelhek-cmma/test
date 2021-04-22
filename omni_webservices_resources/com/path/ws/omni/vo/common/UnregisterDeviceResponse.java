package com.path.ws.omni.vo.common;

public class UnregisterDeviceResponse extends ResponseBaseObject {

	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public UnregisterDeviceResponse(String response) {
		super();
		this.response = response;
	}

}
