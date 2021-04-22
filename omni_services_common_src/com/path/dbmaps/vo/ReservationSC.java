package com.path.dbmaps.vo;

public class ReservationSC {

	private int reservation_id;
	private int reservation_list_id;
	private int machine_plate_number;
	private String driver_name;
	private String driver_mobile_number;
	private String pic;
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public int getReservation_list_id() {
		return reservation_list_id;
	}
	public void setReservation_list_id(int reservation_list_id) {
		this.reservation_list_id = reservation_list_id;
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
	
	
}
