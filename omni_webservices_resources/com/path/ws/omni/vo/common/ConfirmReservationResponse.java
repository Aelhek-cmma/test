package com.path.ws.omni.vo.common;

public class ConfirmReservationResponse extends ResponseBaseObject {

	private int plate_number;
	private String driver_name;
	private String driver_mobile_number;
	private String pic;
	private String response;

	public int getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(int plate_number) {
		this.plate_number = plate_number;
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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public ConfirmReservationResponse(int plate_number, String driver_name, String i, String pic) {
		super();
		this.plate_number = plate_number;
		this.driver_name = driver_name;
		this.driver_mobile_number = i;
		this.pic = pic;
	}

	
	

}
