package com.path.dbmaps.vo;

import java.sql.Time;

public class Machine_driverCO {

	private int machine_driver_id;
	private int machine_id;
	private int driver_id;
	private String machine_model;
	private int machine_plate_number;
	private String driver_mobile_number;
	private String driver_name;
	private String pic;
	private int machine_driver_status;
	private Time timeToReachClient;
	private double distance;
	private Time timeOfTrip;
	private double timeInSec;

	public String getMachine_model() {
		return machine_model;
	}

	public void setMachine_model(String machine_model) {
		this.machine_model = machine_model;
	}

	public int getMachine_plate_number() {
		return machine_plate_number;
	}

	public void setMachine_plate_number(int machine_plate_number) {
		this.machine_plate_number = machine_plate_number;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getDriver_mobile_number() {
		return driver_mobile_number;
	}

	public void setDriver_mobile_number(String driver_mobile_number) {
		this.driver_mobile_number = driver_mobile_number;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getMachine_driver_id() {
		return machine_driver_id;
	}

	public void setMachine_driver_id(int machine_driver_id) {
		this.machine_driver_id = machine_driver_id;
	}

	public int getMachine_id() {
		return machine_id;
	}

	public void setMachine_id(int machine_id) {
		this.machine_id = machine_id;
	}

	public int getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	public int getMachine_driver_status() {
		return machine_driver_status;
	}

	public void setMachine_driver_status(int machine_driver_status) {
		this.machine_driver_status = machine_driver_status;
	}

	public Time getTimeToReachClient() {
		return timeToReachClient;
	}

	public void setTimeToReachClient(Time timeToReachClient) {
		this.timeToReachClient = timeToReachClient;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Time getTimeOfTrip() {
		return timeOfTrip;
	}

	public void setTimeOfTrip(Time timeOfTrip) {
		this.timeOfTrip = timeOfTrip;
	}

	public double getTimeInSec() {
		return timeInSec;
	}

	public void setTimeInSec(double timeInSec) {
		this.timeInSec = timeInSec;
	}


}
