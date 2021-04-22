package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedNativeQueries({
	@NamedNativeQuery(name = "asd",query = "select * from device")
})
public class DeviceVO {

	/**
	 * This field corresponds to the database column device.id_device
	 */
	private int device_id;
	private String device_UUID;
	private String device_name;

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public String getDevice_UUID() {
		return device_UUID;
	}

	public void setDevice_UUID(String device_UUID) {
		this.device_UUID = device_UUID;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

}
