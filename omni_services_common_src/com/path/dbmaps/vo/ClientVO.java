package com.path.dbmaps.vo;

import java.util.Date;

import com.path.lib.vo.BaseVO;

public class ClientVO extends BaseVO {

	private int client_id;
	private String name;
	private String address;
	private String mobile_number;
	private String username;
	private String password;
	private String salt;
	private String profile;
	private Date last_login_user;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getLast_login_user() {
		return last_login_user;
	}

	public void setLast_login_user(Date last_login_user) {
		this.last_login_user = last_login_user;
	}

}
