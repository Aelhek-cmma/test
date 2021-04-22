package com.path.ws.omni.vo.common;

import java.sql.Date;
import java.sql.Time;

public class ReturnReservationsListRequest extends OmniCommonRequest {

	private int client_id;
	private Date date;
	private Time time;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
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

}
