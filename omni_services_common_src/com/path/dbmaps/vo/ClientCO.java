package com.path.dbmaps.vo;

import java.math.BigInteger;
import java.sql.Date;

import com.path.lib.vo.BaseVO;

public class ClientCO extends BaseVO {

	private String device_UUID;
	private String device_name;

	private String mobile_number;

	private int client_id;
	private String username;
	private String password;
	private String new_password;
	private String confirm_password;
	private String salt;

	private String name;
	private String address;

	private String frontEndPublicKey;

	private int client_status;

	private String profile;
	private int gender;
	private String oldpassword;

	private java.util.Date last_login_user;
	private java.util.Date last_login;

	public String getDevice_UUID() {
		return device_UUID;
	}

	public void setDevice_UUID(String device_UUID) {
		this.device_UUID = device_UUID;
	}

	public int getClient_status() {
		return client_status;
	}

	public void setClient_status(int client_status) {
		this.client_status = client_status;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public ClientCO() {
		super();
	}

	public String getFrontEndPublicKey() {
		return frontEndPublicKey;
	}

	public void setFrontEndPublicKey(String frontEndPublicKey) {
		this.frontEndPublicKey = frontEndPublicKey;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public java.util.Date getLast_login_user() {
		return last_login_user;
	}

	public void setLast_login_user(java.util.Date last_login_user) {
		this.last_login_user = last_login_user;
	}

	public java.util.Date getLast_login() {
		return last_login;
	}

	public void setLast_login(java.util.Date last_login) {
		this.last_login = last_login;
	}

}
