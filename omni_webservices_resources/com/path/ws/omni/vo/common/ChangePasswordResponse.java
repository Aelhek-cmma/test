package com.path.ws.omni.vo.common;

public class ChangePasswordResponse extends ResponseBaseObject {

	private String response;
	private int client_id;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

}
