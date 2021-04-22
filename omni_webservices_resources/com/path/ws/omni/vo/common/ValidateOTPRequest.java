package com.path.ws.omni.vo.common;

import java.math.BigInteger;

import com.path.dbmaps.vo.ClientVO;
import com.path.dbmaps.vo.DeviceVO;
import com.path.dbmaps.vo.SimVO;

public class ValidateOTPRequest extends OmniCommonRequest {

	private String otp;
	private String mobile_number;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

}