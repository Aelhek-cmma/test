package com.path.dbmaps.vo;

public class FactureVO {

	private int facture_id;
	private int reservation_id;
	private double cost;
	private int discount;
	private double costAfterDiscount;

	public int getFacture_id() {
		return facture_id;
	}
	public void setFacture_id(int facture_id) {
		this.facture_id = facture_id;
	}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCostAfterDiscount() {
		return costAfterDiscount;
	}
	public void setCostAfterDiscount(double costAfterDiscount) {
		this.costAfterDiscount = costAfterDiscount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
