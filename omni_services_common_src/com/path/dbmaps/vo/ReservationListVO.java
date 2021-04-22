package com.path.dbmaps.vo;

import java.sql.Date;
import java.sql.Time;

public class ReservationListVO {

	private int reservation_list_id;
	private int reservation_id;
	private int machine_driver_id;
	private Date date;
	private Time time;
	private Time time_slot;
	
	private int reservation_list_status;
	
	private double distance;
	
	
	public int getReservation_list_id() {
		return reservation_list_id;
	}
	public void setReservation_list_id(int reservation_list_id) {
		this.reservation_list_id = reservation_list_id;
	}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public int getMachine_driver_id() {
		return machine_driver_id;
	}
	public void setMachine_driver_id(int machine_driver_id) {
		this.machine_driver_id = machine_driver_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Time getTime_slot() {
		return time_slot;
	}
	public void setTime_slot(Time time_slot) {
		this.time_slot = time_slot;
	}
	public int getReservation_list_status() {
		return reservation_list_status;
	}
	public void setReservation_list_status(int reservation_list_status) {
		this.reservation_list_status = reservation_list_status;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

	


}
