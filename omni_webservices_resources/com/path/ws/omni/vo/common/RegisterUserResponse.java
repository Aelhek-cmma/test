package com.path.ws.omni.vo.common;

public class RegisterUserResponse extends ResponseBaseObject {

	private int client_id;
	private String response;
	private String token;
	private int gender;
	

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public RegisterUserResponse(int client_id, String response, String token, int gender) {
		super();
		this.client_id = client_id;
		this.response = response;
		this.token = token;
		this.gender = gender;
	}

	public RegisterUserResponse() {
		super();
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	
}
