package com.path.ws.omni.vo.common;

import java.util.List;

import com.path.dbmaps.vo.TemporaryReservationVO;

public class ValidateRecurringReservationResponse extends ResponseBaseObject {

	private List<TemporaryReservationVO> listOfTemporaryReservation;
	private int temp_reservation_id;
	private int count;
	private String response;
	
	private double cost;
	private double totalCost;
	private int discount;
	private double cost_after_discount;

	public List<TemporaryReservationVO> getListOfTemporaryReservation() {
		return listOfTemporaryReservation;
	}

	public void setListOfTemporaryReservation(List<TemporaryReservationVO> listOfTemporaryReservation) {
		this.listOfTemporaryReservation = listOfTemporaryReservation;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTemp_reservation_id() {
		return temp_reservation_id;
	}

	public void setTemp_reservation_id(int temp_reservation_id) {
		this.temp_reservation_id = temp_reservation_id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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

	
}
