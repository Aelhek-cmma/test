package com.path.dbmaps.vo;

import java.sql.Date;

import com.path.lib.vo.BaseVO;

public class MachineCO extends BaseVO {

	private int machine_id;
	private int plate_number;
	private String model;
	private int machine_status;

	private int machine_mnt_id;
	private String issue_type;
	private int store_id;
	private Date date;
	private double cost;

	public int getMachine_id() {
		return machine_id;
	}

	public void setMachine_id(int machine_id) {
		this.machine_id = machine_id;
	}

	public int getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(int plate_number) {
		this.plate_number = plate_number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMachine_status() {
		return machine_status;
	}

	public void setMachine_status(int machine_status) {
		this.machine_status = machine_status;
	}

	public int getMachine_mnt_id() {
		return machine_mnt_id;
	}

	public void setMachine_mnt_id(int machine_mnt_id) {
		this.machine_mnt_id = machine_mnt_id;
	}

	public String getIssue_type() {
		return issue_type;
	}

	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
