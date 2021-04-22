package com.path.bo.omni.common.base;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.PublicKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.bo.omni.common.OmniCommonBO;
import com.path.dao.omni.common.pull.OmniCommonPullDAO;
import com.path.dao.omni.common.pull.impl.OmniCommonPullDAOImpl;
import com.path.dbmaps.vo.ClientDeviceKeyCO;
import com.path.dbmaps.vo.ErrorVO;
import com.path.dbmaps.vo.MachineVO;
import com.path.lib.log.Log;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: ChadiAssaf
 *
 *          OmniBaseBO.java used to
 */
public class OmniBaseBO

{
	protected OmniCommonPullDAO omniCommonPullDAO;
	public static final String CANCEL_RESERVATION = "cancelReservation.properties";

	public static HashMap<String, Key> KeyHashMap = new HashMap<String, Key>();

	public static HashMap<String, ClientDeviceKeyCO> clientHashMap = new HashMap<String, ClientDeviceKeyCO>();

	public static HashMap<PublicKey, KeyPair> backEndKeyHashMap = new HashMap<PublicKey, KeyPair>();

	public static HashMap<String, String> otpHashMap = new HashMap<String, String>();

	public static HashMap<Integer, Long> cancelTimerHashMap = new HashMap<Integer, Long>();

	public static HashMap<Integer, HashMap<String, Integer>> cancelCounterHashMap = new HashMap<Integer, HashMap<String, Integer>>();

	public static HashMap<Integer, Integer> counterClientReservation = new HashMap();

	public static List<ErrorVO> listErrors ;
	
	public static HashMap<Integer, HashMap<Integer, String>> languageErrorHashmap = new HashMap<Integer, HashMap<Integer,String>>();
	
//	public static HashMap<Integer, ErrorVO> languageErrorHashmap= new HashMap<Integer, ErrorVO>();

	public static int temp_reservation_id = 0;

	protected final static Log log = Log.getInstance();

	protected OmniCommonBO omniCommonBO;

	public static HashMap<String, Key> getKeyHashMap() {
		return KeyHashMap;
	}

	public static void setKeyHashMap(HashMap<String, Key> keyHashMap) {
		KeyHashMap = keyHashMap;
	}

	public static HashMap<String, ClientDeviceKeyCO> getClientHashMap() {
		return clientHashMap;
	}

	public static void setClientHashMap(HashMap<String, ClientDeviceKeyCO> clientHashMap) {
		OmniBaseBO.clientHashMap = clientHashMap;
	}

	public static HashMap<String, String> getOtpHashMap() {
		return otpHashMap;
	}

	public static void setOtpHashMap(HashMap<String, String> otpHashMap) {
		OmniBaseBO.otpHashMap = otpHashMap;
	}

	public static String getCancelReservation() {
		return CANCEL_RESERVATION;
	}

	public static HashMap<PublicKey, KeyPair> getBackEndKeyHashMap() {
		return backEndKeyHashMap;
	}

	public static void setBackEndKeyHashMap(HashMap<PublicKey, KeyPair> backEndKeyHashMap) {
		OmniBaseBO.backEndKeyHashMap = backEndKeyHashMap;
	}

	public static HashMap<Integer, Long> getCancelTimerHashMap() {
		return cancelTimerHashMap;
	}

	public static void setCancelTimerHashMap(HashMap<Integer, Long> cancelTimerHashMap) {
		OmniBaseBO.cancelTimerHashMap = cancelTimerHashMap;
	}

	public static HashMap<Integer, Integer> getCounterClientReservation() {
		return counterClientReservation;
	}

	public static void setCounterClientReservation(HashMap<Integer, Integer> counterClientReservation) {
		OmniBaseBO.counterClientReservation = counterClientReservation;
	}

	public static int getTemp_reservation_id() {
		return temp_reservation_id;
	}

	public static void setTemp_reservation_id(int temp_reservation_id) {
		OmniBaseBO.temp_reservation_id = temp_reservation_id;
	}

	public static Log getLog() {
		return log;
	}

	public OmniCommonBO getOmniCommonBO() {
		return omniCommonBO;
	}

	public void setOmniCommonBO(OmniCommonBO omniCommonBO) {
		this.omniCommonBO = omniCommonBO;
	}

	public static HashMap<Integer, HashMap<String, Integer>> getCancelCounterHashMap() {
		return cancelCounterHashMap;
	}

	public static void setCancelCounterHashMap(HashMap<Integer, HashMap<String, Integer>> cancelCounterHashMap) {
		OmniBaseBO.cancelCounterHashMap = cancelCounterHashMap;
	}

	public static List<ErrorVO> getListErrors() {
		return listErrors;
	}

	public static void setListErrors(List<ErrorVO> listErrors) {
		OmniBaseBO.listErrors = listErrors;
	}

//	public static HashMap<Integer, ErrorVO> getLanguageErrorHashmap() {
//		return languageErrorHashmap;
//	}
//
//	public static void setLanguageErrorHashmap(HashMap<Integer, ErrorVO> languageErrorHashmap) {
//		OmniBaseBO.languageErrorHashmap = languageErrorHashmap;
//	}

	public static HashMap<Integer, HashMap<Integer, String>> getLanguageErrorHashmap() {
		return languageErrorHashmap;
	}

	public static void setLanguageErrorHashmap(HashMap<Integer, HashMap<Integer, String>> languageErrorHashmap) {
		OmniBaseBO.languageErrorHashmap = languageErrorHashmap;
	}

	
	
}
