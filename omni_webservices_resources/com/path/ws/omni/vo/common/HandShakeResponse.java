package com.path.ws.omni.vo.common;

import java.security.PublicKey;

public class HandShakeResponse extends ResponseBaseObject {

	private PublicKey backEndPublicKey;

	public PublicKey getBackEndPublicKey() {
		return backEndPublicKey;
	}

	public void setBackEndPublicKey(PublicKey backEndPublicKey) {
		this.backEndPublicKey = backEndPublicKey;
	}

	public HandShakeResponse(PublicKey backEndPublicKey) {
		super();
		this.backEndPublicKey = backEndPublicKey;
	}
	
	
	
}
