package com.path.dbmaps.vo;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.util.List;

import com.path.lib.vo.BaseVO;

public class ReservationCO extends BaseVO{

	private int reservation_id;
	private int reservation_list_id;
	private int client_id;
	private int machine_driver_id;
	private int reservation_type;
	private int occurrence_type;
	private Time time_slot;
	private Date date;
	private Time time;
	private Time start_time;
//	private String time;

	private String location_from;
	private String location_to;
	private double latitude_from;
	private double longitude_from;
	private double latitude_to;
	private double longitude_to;
	private int reservation_status;
	private List<ReservationListVO> listDate;

	private int periodicity_type;
	private Date start_date;
	private Date end_date;
	private int recur_count;

	private int reservation_list_status;

	private double total_cost;
	private int discount;
	private double cost_after_discount;

	private int velocity;

	/*
	 * if no available machine in time mentioned , we can reserve another one ealier
	 * or later the mentioned time , so 0 if the client need before, 1 if after
	 */
	private int new_time;
	private int temp_reservation_id;

	private String mobile_number;

	private double distance;

	private int counter;

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

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getMachine_driver_id() {
		return machine_driver_id;
	}

	public void setMachine_driver_id(int machine_driver_id) {
		this.machine_driver_id = machine_driver_id;
	}

	public int getReservation_type() {
		return reservation_type;
	}

	public void setReservation_type(int reservation_type) {
		this.reservation_type = reservation_type;
	}

	public int getOccurrence_type() {
		return occurrence_type;
	}

	public void setOccurrence_type(int occurrence_type) {
		this.occurrence_type = occurrence_type;
	}

	public Time getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(Time time_slot) {
		this.time_slot = time_slot;
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

	public String getLocation_from() {
		return location_from;
	}

	public void setLocation_from(String location_from) {
		this.location_from = location_from;
	}

	public String getLocation_to() {
		return location_to;
	}

	public void setLocation_to(String location_to) {
		this.location_to = location_to;
	}

	public double getLatitude_from() {
		return latitude_from;
	}

	public void setLatitude_from(double latitude_from) {
		this.latitude_from = latitude_from;
	}

	public double getLongitude_from() {
		return longitude_from;
	}

	public void setLongitude_from(double longitude_from) {
		this.longitude_from = longitude_from;
	}

	public double getLatitude_to() {
		return latitude_to;
	}

	public void setLatitude_to(double latitude_to) {
		this.latitude_to = latitude_to;
	}

	public double getLongitude_to() {
		return longitude_to;
	}

	public void setLongitude_to(double longitude_to) {
		this.longitude_to = longitude_to;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public int getPeriodicity_type() {
		return periodicity_type;
	}

	public void setPeriodicity_type(int periodicity_type) {
		this.periodicity_type = periodicity_type;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getRecur_count() {
		return recur_count;
	}

	public void setRecur_count(int recur_count) {
		this.recur_count = recur_count;
	}

	public List<ReservationListVO> getListDate() {
		return listDate;
	}

	public void setListDate(List<ReservationListVO> listDate) {
		this.listDate = listDate;
	}

	public int getNew_time() {
		return new_time;
	}

	public void setNew_time(int new_time) {
		this.new_time = new_time;
	}

	public int getTemp_reservation_id() {
		return temp_reservation_id;
	}

	public void setTemp_reservation_id(int temp_reservation_id) {
		this.temp_reservation_id = temp_reservation_id;
	}

	public int getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(int reservation_status) {
		this.reservation_status = reservation_status;
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

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getCost_after_discount() {
		return cost_after_discount;
	}

	public void setCost_after_discount(double cost_after_discount) {
		this.cost_after_discount = cost_after_discount;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public ReservationCO(int machine_driver_id, int reservation_type, int occurrence_type, Date date, Time time) {
		super();
		this.machine_driver_id = machine_driver_id;
		this.reservation_type = reservation_type;
		this.occurrence_type = occurrence_type;
		this.date = date;
//		this.time = time;
	}

	public ReservationCO() {
		super();
	}

//	public String getTime() {
//		return time;
//	}
//
//	public void setTime(String time) {
//		this.time = time;
//	}

}
