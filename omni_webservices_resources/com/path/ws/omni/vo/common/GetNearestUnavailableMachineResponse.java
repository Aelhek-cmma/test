package com.path.ws.omni.vo.common;

import java.sql.Time;

public class GetNearestUnavailableMachineResponse extends ResponseBaseObject {

	private String driver_name;
	private int driver_mobile_number;
	private String pic;
	private int machine_plate_number;
	private String machine_model;
	private Time time_to_reach_client;

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public int getDriver_mobile_number() {
		return driver_mobile_number;
	}

	public void setDriver_mobile_number(int driver_mobile_number) {
		this.driver_mobile_number = driver_mobile_number;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getMachine_plate_number() {
		return machine_plate_number;
	}

	public void setMachine_plate_number(int machine_plate_number) {
		this.machine_plate_number = machine_plate_number;
	}

	public String getMachine_model() {
		return machine_model;
	}

	public void setMachine_model(String machine_model) {
		this.machine_model = machine_model;
	}

	public Time getTime_to_reach_client() {
		return time_to_reach_client;
	}

	public void setTime_to_reach_client(Time time_to_reach_client) {
		this.time_to_reach_client = time_to_reach_client;
	}

}
