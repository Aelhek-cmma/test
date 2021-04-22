package com.path.dbmaps.vo;

public class MachineVO {

	private int machine_id;
	private int plate_number;
	private String model;
	private int machine_status;

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

}
