package com.path.ws.omni.vo.common;

public class ResetPasswordResponse extends ResponseBaseObject{

	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ResetPasswordResponse(String response) {
		super();
		this.response = response;
	}

}
