package com.path.ws.omni.vo.common;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.path.dbmaps.vo.ClientCO;

public class LoginResponse extends ResponseBaseObject {

	private String response;
	private String token;
	private String checkCombination;
	private int client_id;
	private int gender;
	private java.util.Date last_login_user;

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

	public String getCheckCombination() {
		return checkCombination;
	}

	public void setCheckCombination(String checkCombination) {
		this.checkCombination = checkCombination;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public java.util.Date getLast_login_user() {
		return last_login_user;
	}

	public void setLast_login_user(java.util.Date last_login_user) {
		this.last_login_user = last_login_user;
	}

}
