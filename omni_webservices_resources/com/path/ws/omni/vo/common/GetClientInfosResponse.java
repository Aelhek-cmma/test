package com.path.ws.omni.vo.common;

public class GetClientInfosResponse extends ResponseBaseObject {

	private String name;
	private String profile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public GetClientInfosResponse(String name, String profile) {
		super();
		this.name = name;
		this.profile = profile;
	}

	public GetClientInfosResponse() {
		super();
	}

}
