package com.path.ws.omni.vo.common;

import java.util.List;

import com.path.dbmaps.vo.ClientCO;

public class GetListDevicesResponse extends ResponseBaseObject {

	private List<ClientCO> list;

	public List<ClientCO> getList() {
		return list;
	}

	public void setList(List<ClientCO> list) {
		this.list = list;
	}

	public GetListDevicesResponse(List<ClientCO> list) {
		super();
		this.list = list;
	}

	
}
