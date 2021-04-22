package com.path.bo.omni.common.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.KeyPair;
import java.security.PublicKey;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.path.bo.common.MessageCodes;
import com.path.bo.omni.common.OmniCommonBO;
import com.path.bo.omni.common.OmniCommonConstants;
import com.path.bo.omni.common.OmniCommonMethods;
import com.path.bo.omni.common.base.OmniBaseBO;
import com.path.bo.omni.common.push.OmniCommonPushBO;
import com.path.dao.omni.common.OmniCommonDAO;
import com.path.dao.omni.common.pull.OmniCommonPullDAO;
import com.path.dao.omni.common.push.OmniCommonPushDAO;
import com.path.dbmaps.vo.ClientCO;
import com.path.dbmaps.vo.ClientDeviceKeyCO;
import com.path.dbmaps.vo.ClientVO;
import com.path.dbmaps.vo.Client_deviceVO;
import com.path.dbmaps.vo.DeviceVO;
import com.path.dbmaps.vo.DriverCO;
import com.path.dbmaps.vo.DriverVO;
import com.path.dbmaps.vo.Driver_deviceVO;
import com.path.dbmaps.vo.ErrorVO;
import com.path.dbmaps.vo.List_destinationsVO;
import com.path.dbmaps.vo.MachineCO;
import com.path.dbmaps.vo.MachineDriverSC;
import com.path.dbmaps.vo.MachineDriverVO;
import com.path.dbmaps.vo.MachineVO;
import com.path.dbmaps.vo.Machine_driverCO;
import com.path.dbmaps.vo.RateVO;
import com.path.dbmaps.vo.ReservationCO;
import com.path.dbmaps.vo.ReservationListVO;
import com.path.dbmaps.vo.ReservationSC;
import com.path.dbmaps.vo.ReservationVO;
import com.path.dbmaps.vo.SimVO;
import com.path.dbmaps.vo.StoreVO;
import com.path.dbmaps.vo.TemporaryReservationVO;
import com.path.dbmaps.vo.WorkingHoursVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.SecurityUtilsExt;
import com.path.lib.common.util.StringUtil;
import com.path.vo.omni.common.OmniCommonCO;
import com.path.vo.omni.common.base.OmniBaseSC;
import com.path.vo.omni.common.base.OmniBaseVO;
import com.path.vo.omni.common.omniuser.OmniCommonUserSC;
import com.path.ws.omni.vo.common.AddDestinationResponse;
import com.path.ws.omni.vo.common.AddDriverResponse;
import com.path.ws.omni.vo.common.AddMachineResponse;
import com.path.ws.omni.vo.common.AddStoreResponse;
import com.path.ws.omni.vo.common.AuthenticateDriverResponse;
import com.path.ws.omni.vo.common.AuthenticateResponse;
import com.path.ws.omni.vo.common.CancelReservationResponse;
import com.path.ws.omni.vo.common.ChangePasswordResponse;
import com.path.ws.omni.vo.common.ChangeProfileResponse;
import com.path.ws.omni.vo.common.CheckTempRecurringReservationResponse;
import com.path.ws.omni.vo.common.CheckUsernameResponse;
import com.path.ws.omni.vo.common.ConfirmReservationResponse;
import com.path.ws.omni.vo.common.CostResponse;
import com.path.ws.omni.vo.common.CreateReservationResponse;
import com.path.ws.omni.vo.common.DriverDeviceCO;
import com.path.ws.omni.vo.common.ForgetPasswordResponse;
import com.path.ws.omni.vo.common.GenerateOTPResponse;
import com.path.ws.omni.vo.common.GetClientInfosResponse;
import com.path.ws.omni.vo.common.GetDiscountResponse;
import com.path.ws.omni.vo.common.GetDriverInfosResponse;
import com.path.ws.omni.vo.common.GetListDevicesResponse;
import com.path.ws.omni.vo.common.GetListOfDestinaitonsResponse;
import com.path.ws.omni.vo.common.GetListOfMachinesResponse;
import com.path.ws.omni.vo.common.GetMachineInfosResponse;
import com.path.ws.omni.vo.common.HandShakeRequest;
import com.path.ws.omni.vo.common.HandShakeResponse;
import com.path.ws.omni.vo.common.LoginResponse;
import com.path.ws.omni.vo.common.LogoutResponse;
import com.path.ws.omni.vo.common.RatingTripResponse;
import com.path.ws.omni.vo.common.RegisterUserResponse;
import com.path.ws.omni.vo.common.RejectReservationResponse;
import com.path.ws.omni.vo.common.RememberDeviceResponse;
import com.path.ws.omni.vo.common.ResetPasswordResponse;
import com.path.ws.omni.vo.common.ReturnReservationDetailsResponse;
import com.path.ws.omni.vo.common.ReturnReservationsListResponse;
import com.path.ws.omni.vo.common.UnregisterDeviceResponse;
import com.path.ws.omni.vo.common.UpdateClientInfosResponse;
import com.path.ws.omni.vo.common.UpdateDriverInfosResponse;
import com.path.ws.omni.vo.common.UpdateDriverWorkingHoursResponse;
import com.path.ws.omni.vo.common.UpdateMachineInfosResponse;
import com.path.ws.omni.vo.common.UpdateReservationStatusResponse;
import com.path.ws.omni.vo.common.ValidateOTPRequest;
import com.path.ws.omni.vo.common.ValidateOTPResponse;
import com.path.ws.omni.vo.common.ValidateRecurringReservationResponse;

/**
 * @author Alaa Al Hek
 *
 *         OmniCommonBOImpl.java used to
 */
public class OmniCommonBOImpl extends OmniBaseBO implements OmniCommonBO {

	protected static Logger pathlog;

	protected OmniCommonDAO omniCommonDAO;
	protected OmniCommonPushBO omniCommonPushBO;
	protected OmniCommonPullDAO omniCommonPullDAO;
	protected OmniCommonPushDAO omniCommonPushDAO;
	protected OmniCommonMethods omniCommonMethods;

	SecurityUtilsExt securityUtilsExt;
	Properties prop = new Properties();
	private static String PRODUCT_TABLE_NAME = "products";
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public void setOmniCommonPullDAO(OmniCommonPullDAO omniCommonPullDAO) {
		this.omniCommonPullDAO = omniCommonPullDAO;
	}

	public OmniCommonDAO getOmniCommonDAO() {
		return omniCommonDAO;
	}

	public void setOmniCommonDAO(OmniCommonDAO omniCommonDAO) {
		this.omniCommonDAO = omniCommonDAO;
	}

	public void setOmniCommonPushDAO(OmniCommonPushDAO omniCommonPushDAO) {
		this.omniCommonPushDAO = omniCommonPushDAO;
	}

	/**
	 * Method that returns Next value of sequence of a table
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public BigDecimal returnNextValOfSequence(Object objParam) throws BaseException {
		String className = objParam.getClass().getSimpleName();
		if (className.lastIndexOf("VO") < 0) {
			throw new BOException("Class Name should be VO Object");
		}

		Field[] fields;
		if (objParam.getClass().getName().contains("WithBLOBs")) {
			fields = objParam.getClass().getSuperclass().getSuperclass().getDeclaredFields();
		} else {
			fields = objParam.getClass().getSuperclass().getDeclaredFields();
		}

		if (className.lastIndexOf("VOKey") != -1) {
			fields = objParam.getClass().getDeclaredFields();
		}
		if (fields.length != 1) {
			throw new BOException("Class Name should be one column and sequnetial Primary key");
		}
		Field pkField = fields[0];
		pkField.setAccessible(true);

		OmniBaseSC omniBaseSC = new OmniBaseSC();
		omniBaseSC.setPkColName(pkField.getName());
		omniBaseSC.setTableName(className.substring(0, className.lastIndexOf("VO")));
		return new BigDecimal(omniCommonDAO.returnNextValOfSequence(omniBaseSC));
	}

	/**
	 * return Sequence of Original Record
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public BigDecimal returnRelatedSequence(Object objParam, String pkColName, BigDecimal refCode)
			throws BaseException {
		OmniBaseSC omniBaseSC = new OmniBaseSC();
		omniBaseSC.setPkColName(pkColName);
		String className = objParam.getClass().getSimpleName();
		if (className.lastIndexOf("VO") < 0) {
			throw new BOException("Class Name should be VO Object");
		}
		omniBaseSC.setTableName(className.substring(0, className.lastIndexOf("VO")));
		omniBaseSC.setRefCode(refCode);
		return new BigDecimal(omniCommonDAO.returnRelatedSequence(omniBaseSC));
	}

	/**
	 * update Ref Code of Table even if it's null
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public int updateRefCode(Object objParam) throws BaseException {
		try {
			String className = objParam.getClass().getSimpleName();
			if (className.lastIndexOf("VO") < 0) {
				throw new BOException("Class Name should be VO Object");
			}

			Field[] fields;
			if (objParam.getClass().getName().contains("WithBLOBs")) {
				fields = objParam.getClass().getSuperclass().getSuperclass().getDeclaredFields();
			} else {
				fields = objParam.getClass().getSuperclass().getDeclaredFields();
			}
			if (className.lastIndexOf("VOKey") != -1) {
				fields = objParam.getClass().getDeclaredFields();
			}
			if (fields.length != 1) {
				throw new BOException("Class Name should be one column and sequnetial Primary key");
			}

			OmniBaseSC omniBaseSC = new OmniBaseSC();
			Field pkField = fields[0];
			pkField.setAccessible(true);
			omniBaseSC.setPkColName(pkField.getName());
			if (null != pkField.get(objParam)) {
				omniBaseSC.setPkColValue(new BigDecimal(StringUtil.nullEmptyToValue(pkField.get(objParam), "")));
			}

			Field refCodeField;
			if (objParam.getClass().getName().contains("WithBLOBs")) {
				refCodeField = objParam.getClass().getSuperclass().getDeclaredField(OmniCommonConstants.REFERENCE_CODE);
			} else {
				refCodeField = objParam.getClass().getDeclaredField(OmniCommonConstants.REFERENCE_CODE);
			}

			refCodeField.setAccessible(true);
			if (null != refCodeField.get(objParam)) {
				omniBaseSC.setRefCode(new BigDecimal(StringUtil.nullEmptyToValue(refCodeField.get(objParam), "")));
			}
			omniBaseSC.setTableName(className.substring(0, className.lastIndexOf("VO")));
			return omniCommonDAO.updateRefCode(omniBaseSC);
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException
				| NullPointerException e) {
			throw new BOException(MessageCodes.INVALID_ACTION);
		}
	}

	/*
	 * @Override public OmniCommonCO executePWSService(OmniCommonUserSC sc) throws
	 * BaseException { OmniCommonCO omniCommonCO =
	 * omniCommonPushBO.callingPWSService(sc); if
	 * (OmniCommonConstants.SUBMIT_ACTION_TYPE.equals(sc.getActionType()) ) {
	 * omniCommonCO = omniCommonPushBO.saveScreenFields(sc,omniCommonCO); } return
	 * omniCommonCO; }
	 */

	public void setOmniCommonPushBO(OmniCommonPushBO omniCommonPushBO) {
		this.omniCommonPushBO = omniCommonPushBO;
	}

	@Override
	public Object fillUserAndDate(OmniBaseVO omniBaseVO, Object objParam, String action) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal returnOmniCounter(OmniCommonCO omniCommonCO) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OmniCommonCO> returnAppChannels(OmniBaseSC omniBaseSC) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int returnApplicationListCount(OmniBaseSC omniBaseSC) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List returnApplicationList(OmniBaseSC omniBaseSC) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object checkConcurrentDate(Object objParam) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateRecordScreen(Object obj, String action) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object saveService(Object objToInsert) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateRecordScreen(String recordActionSave, OmniBaseVO omniBaseVO, Object obj) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isAllowedChannelApp(OmniBaseSC omniBaseSc) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyMakerCheckerValidation(String creater, String modifier, String userId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> getVOAttributes(Object vo) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object insertIntoDB(Object vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> returnETLCode(Object voName, String listOfIds, String codeColumnName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectRecord(Object vo, String... columnNames) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OmniCommonCO returnLanguagesList(OmniBaseSC sc) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OmniCommonCO executePWSService(OmniCommonUserSC sc) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * method that cache the frontEnd publicKey , generate and cache pair key ,
	 * 
	 * @param ClientRequest
	 * @return
	 * @throws Exception
	 * 
	 */

	@Override
	public HandShakeResponse handShake(HandShakeRequest handShakeRequest) throws Exception {

		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			java.util.Date d = new java.util.Date();
			String now = format.format(d);
//			PublicKey frontEndPublicKey = SecurityUtilsExt
//					.convertStringToPublicKey(handShakeRequest.getFrontEndPublicKey());
			// generate private and public key of backEnd
			log.info("debut generate key :" + now);
			KeyPair keyPair = SecurityUtilsExt.generatePairKey();
			log.info("fin generate key :" + format.format(new java.util.Date()));

			// saving backEnd private and public key by frontEnd public Key
			log.info("debut hashmap :" + format.format(new java.util.Date()));
			backEndKeyHashMap.put(SecurityUtilsExt.convertStringToPublicKey(handShakeRequest.getFrontEndPublicKey()),
					keyPair);
			log.info("fin hashmap :" + format.format(new java.util.Date()));
			return new HandShakeResponse(keyPair.getPublic());

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	/**
	 * method that check the combination of sim serial and device serial in th db
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public AuthenticateResponse authenticate(ClientCO clientCO) throws Exception { //
		String secretKey;
		try {
			AuthenticateResponse response = new AuthenticateResponse();

			// check the combination of sim_serial and device_serial if exist login , if not
			// exist return error, then login by username and pass
			Client_deviceVO client_deviceVO = omniCommonPullDAO.returnCombinationUsernameDevice(clientCO);

			/*
			 * the combination exist in db and the hashmap contains the key,
			 */
			if (client_deviceVO != null
//					&& backEndKeyHashMap.containsKey(frontEndPublicKey)
					&& client_deviceVO.getClient_status() == 0) {
//				PublicKey frontEndPublicKey = SecurityUtilsExt.convertStringToPublicKey(clientCO.getFrontEndPublicKey());

				ClientDeviceKeyCO client = getTokenAndKeys(clientCO);

				clientHashMap.put(clientCO.getDevice_UUID(), client);

				response.setToken(client.getToken());
				response.setResponse("success");

			} else if (client_deviceVO != null
//					&& backEndKeyHashMap.containsKey(frontEndPublicKey)
					&& !clientHashMap.containsKey(clientCO.getDevice_UUID())) {
				response.setErrorCode(9021);
				response.setErrorDesc(
						getError(clientCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());


			}

			else {
				response.setErrorCode(9001);
				response.setErrorDesc(
						getError(clientCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override

	public GenerateOTPResponse generateOTP(SimVO simVO) throws Exception {
		try {
			GenerateOTPResponse response = new GenerateOTPResponse();
			/*
			 * generate secretKey then generate totp
			 */
			String secretKey = SecurityUtilsExt.generateSecretKeyTOTP();
			String totp = SecurityUtilsExt.getTOTPCode(secretKey);
			/*
			 * cache the secret key in hashmap with mobile number key
			 */
			otpHashMap.put(simVO.getMobile_number(), secretKey);
			response.setOtp(totp);
			return response;

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	/**
	 * method that validate the OTP
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public ValidateOTPResponse validateOTP(ValidateOTPRequest validateOTPRequest) throws Exception {
		ValidateOTPResponse response = new ValidateOTPResponse();
		try {
			String secretKey = otpHashMap.get(validateOTPRequest.getMobile_number());
			boolean valid = SecurityUtilsExt.validateOTP(secretKey, validateOTPRequest.getOtp());
			if (valid)
				response.setResponse("valid");
			else {
				response.setErrorCode(9002);
				response.setErrorDesc(
						getError(validateOTPRequest.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public CheckUsernameResponse checkUsername(ClientVO clientVO) throws Exception {

		CheckUsernameResponse response = new CheckUsernameResponse();
		ClientVO client = new ClientVO();
		try {

			// check if the username exist in db or not , if not return valid
			log.info("debut select username " + format.format(new java.util.Date()));

			client = omniCommonPullDAO.returnUsername(clientVO);

//			int i  = omniCommonPullDAO.returnUsernameExists(clientVO);
			log.info("fin select username " + format.format(new java.util.Date()));

			if (client == null) {

//			if (i==0) {
				response.setResponse("valid");

				// username exist , so put another one
			} else {
				response.setErrorCode(9003);
//				response.setErrorDesc("invalid");
//				listErrors = listErrors.stream().filter(l -> l.getError_code() == 9003)
//						.filter(l -> l.getLanguage_id() == clientVO.getLanguage_id()).collect(Collectors.toList());

//				response.setErrorDesc(languageErrorHashmap.get(clientVO.getLanguage_id()).get(9003));
				response.setErrorDesc(
						getError(clientVO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

			}
			log.info("fin method " + format.format(new java.util.Date()));

			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public RegisterUserResponse registerUser(ClientCO clientCO) throws Exception {
		RegisterUserResponse response = new RegisterUserResponse();

		try {
			ClientVO clientVO = new ClientVO();
			clientVO.setUsername(clientCO.getUsername());
			ClientVO c = omniCommonPullDAO.returnUsername(clientVO);
			if (c != null) {
				response.setErrorCode(9022);
				response.setErrorDesc(
						getError(clientCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());
				return response;
			} else {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				log.info("debut register " + format.format(new java.util.Date()));
				/*
				 * get from the properties file the value needed for password
				 */
				prop = PropertiesLoaderUtils.loadAllProperties("HashPassword.properties");
				String value = prop.getProperty("value");
				/*
				 * salt and hash the pass based on username, password and value
				 */
				String pass = clientCO.getUsername() + clientCO.getPassword() + value;
				String salt = SecurityUtilsExt.getNextSalt();
				String hash = SecurityUtilsExt.hash(pass, salt);

				/*
				 * insert the device in db in case not exist , then insert the combination
				 */
				log.info("debut return device " + format.format(new java.util.Date()));
				DeviceVO deviceVO = omniCommonPullDAO.returnDevice(clientCO);
				if (deviceVO == null) {
					omniCommonPushDAO.insertDevice(clientCO);
				}
				log.info("fin return device " + format.format(new java.util.Date()));
				/*
				 * insert into client table the hashed password
				 */
				clientCO.setPassword(hash);
				clientCO.setSalt(salt);
				log.info("debut insert username " + format.format(new java.util.Date()));
				omniCommonPushDAO.insertUsernamePass(clientCO);
				log.info("debut insert combination " + format.format(new java.util.Date()));
				omniCommonPushDAO.insertCombination(clientCO);
				log.info("fin insert  combination " + format.format(new java.util.Date()));
				/*
				 * put the client in the hashmap of keys
				 * 
				 */
				ClientDeviceKeyCO client = getTokenAndKeys(clientCO);
				clientHashMap.put(clientCO.getDevice_UUID(), client);
				java.util.Date d6 = new java.util.Date();
				log.info("fin get token  " + format.format(d6));
				clientCO.setLast_login_user(new java.util.Date(System.currentTimeMillis()));
				omniCommonPushDAO.updateLastLoginUser(clientCO);
				return new RegisterUserResponse(clientCO.getClient_id(), client.getToken(), "done",
						clientCO.getGender());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	public ClientDeviceKeyCO getTokenAndKeys(ClientCO clientCO) throws Exception {
		String secretKey;
		/*
		 * put in the hashmap the mobile_number , device_serial, frontEndPublicKey ,
		 * backEndPublicKey, backEndPrivateKey
		 */
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		java.util.Date d = new java.util.Date();
		log.info("debut convert publickey " + format.format(d));
		PublicKey frontEndPublicKey = SecurityUtilsExt.convertStringToPublicKey(clientCO.getFrontEndPublicKey());
		java.util.Date d1 = new java.util.Date();
		log.info("fin convert publickey " + format.format(d1));
//		PublicKey backEndPublicKey = getBackEndKeyHashMap().get(frontEndPublicKey).getPublic();
//		PrivateKey backEndPrivateKey = getBackEndKeyHashMap().get(frontEndPublicKey).getPrivate();

		/*
		 * generate secretKey then generate token
		 */
		log.info("debut generate secret key " + format.format(new java.util.Date()));
		secretKey = SecurityUtilsExt.generateSecretKeyAsString();
		// to be sure each device has its own secret key , if the secret key exist in
		// the hashmap generate new one
		log.info("fin convert publickey " + format.format(new java.util.Date()));
		while (clientHashMap.values().contains(secretKey)) {
			secretKey = SecurityUtilsExt.generateSecretKeyAsString();
		}
		log.info("debut generate token " + format.format(new java.util.Date()));
		String token = SecurityUtilsExt.generateToken(secretKey, clientCO.getDevice_UUID(), clientCO.getUsername());
		log.info("fin generate token " + format.format(new java.util.Date()));
		/*
		 * put in the hashmap the sim serial , frontEndPublicKey, backEndPublicKey,
		 * backEndPrivateKey
		 */
		ClientDeviceKeyCO client = new ClientDeviceKeyCO(frontEndPublicKey,
				getBackEndKeyHashMap().get(frontEndPublicKey).getPublic(),
				getBackEndKeyHashMap().get(frontEndPublicKey).getPrivate(), secretKey, token);

//		clientHashMap.put(clientCO.getDevice_UUID(), client);
//		response.setToken(token);
//		response.setResponse("done");
		return client;
	}

	@Override
	public LoginResponse login(ClientCO clientCO) throws Exception {
		LoginResponse response = new LoginResponse();
		java.util.Date d = new java.util.Date();
		String now = format.format(d);

		log.info("debut login " + now);
		try {
			// return the password and salt from db for this username
			log.info("debut return username pass " + now);
			ClientVO clientVO = omniCommonPullDAO.returnUsernamePassword(clientCO);
			log.info("fin return username pass " + format.format(new java.util.Date()));
			/* check if the username exist */
			if (clientVO == null) { // the username is invalid , does not exist in bd
				response.setErrorCode(9004);
				response.setErrorDesc(
						getError(clientCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());
			} else { // username valid
				prop = PropertiesLoaderUtils.loadAllProperties("HashPassword.properties");
				String value = prop.getProperty("value");
				String pass = clientCO.getUsername() + clientCO.getPassword() + value;
				/* validate the requested password */
				log.info("fin validate pass " + format.format(new java.util.Date()));
				if (SecurityUtilsExt.validatePassword(pass, clientVO.getSalt(), clientVO.getPassword())) {
					log.info("debut check combination " + format.format(new java.util.Date()));
					// the password valid put the client in the hashmap
					log.info("debut put hashmap " + format.format(new java.util.Date()));
					ClientDeviceKeyCO client = getTokenAndKeys(clientCO);
					clientHashMap.put(clientCO.getDevice_UUID(), client);
					Client_deviceVO client_deviceVO = omniCommonPullDAO.returnCombination(clientCO);
					log.info("fin check combination " + format.format(new java.util.Date()));
					// check the combination of sim and device
					java.util.Date last_login = new java.util.Date(System.currentTimeMillis());
					clientCO.setClient_id(clientVO.getClient_id());
					if (client_deviceVO == null) {
						response.setResponseCode(10001);
						response.setResponseDesc("the combinatiom client device not exist");
						/* check if device or sim exist */
//						DeviceVO deviceVO = omniCommonPullDAO.returnDevice(clientCO);
//						if (deviceVO == null) {
//							response.setErrorCode(9016);
//							response.setErrorDesc("device not exist");
//						}
					}
					/*
					 * if the combination exist in db set the client status 0 "login"
					 */
					else {
						log.info("debut upadate status " + format.format(new java.util.Date()));
						clientCO.setClient_status(0);
						
						omniCommonPushDAO.updateClientStatus(clientCO);
//						response.setCheckCombination("username  and device exist");
						log.info("fin update status " + format.format(new java.util.Date()));
						clientCO.setLast_login(last_login);
						omniCommonPushDAO.updateLastLoginUserDevice(clientCO);

					}

					response.setLast_login_user(omniCommonPullDAO.returnLastLogin(clientCO).getLast_login_user());
					clientCO.setLast_login_user(last_login);
					omniCommonPushDAO.updateLastLoginUser(clientCO);
					response.setGender(omniCommonPullDAO.returnGender(clientCO).getGender());
					log.info("fin put hashmap " + format.format(new java.util.Date()));
					response.setClient_id(clientVO.getClient_id());
					response.setToken(client.getToken());
					response.setResponse("done");
					log.info("fin login" + format.format(new java.util.Date()));
				} else { // password invalid, return a msg the password is incorrect
					response.setErrorCode(9005);
					response.setErrorDesc(
							getError(clientCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

				}
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public RememberDeviceResponse rememberDevice(ClientCO clientCO) throws Exception {
		RememberDeviceResponse response = new RememberDeviceResponse();
		try {
			DeviceVO deviceVO = omniCommonPullDAO.returnDevice(clientCO);
			if (deviceVO == null) {
				omniCommonPushDAO.insertDevice(clientCO);
			}
			omniCommonPushDAO.insertCombination(clientCO);
			clientCO.setLast_login(new java.util.Date(System.currentTimeMillis()));
			omniCommonPushDAO.updateLastLoginUserDevice(clientCO);
			response.setResponse("saved");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	int countStatus;

	@SuppressWarnings("unused")
	@Override
	public CreateReservationResponse createReservation(ReservationCO reservationCO) throws Exception {
		CreateReservationResponse response = new CreateReservationResponse();

		List<ReservationCO> listLastReservations;

		try {
			int count = 0;
			countStatus = 0;
			prop = PropertiesLoaderUtils.loadAllProperties("Reservations.properties");
			String nbString = prop.getProperty("numberOfReservations");
			int nb = Integer.parseInt(nbString);
			long now = System.currentTimeMillis();
			Time time = new Time(now);

			/*
			 * if the reservation is future , the client can not create more than 3
			 * reservation;
			 *
			 */
			reservationCO.setCounter(nb);

			listLastReservations = omniCommonPullDAO.returnLast3Reservations(reservationCO);
			/*
			 * check if the last reservations are done or not yet, if no return error , the
			 * client can not create reservation now
			 */
			listLastReservations.stream().filter(l -> l.getReservation_list_status() != 2).forEach(l -> countStatus++);
			if (countStatus == nb) {
				response.setErrorCode(9023);
				response.setErrorDesc(
						getError(reservationCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

			} else if (countStatus < 3) {
				if (reservationCO.getDate() != null && reservationCO.getTime() != null) {

//				for (int i = 0; i < listLastReservations.size(); i++) {
//					int status = listLastReservations.get(i).getReservation_list_status();
//					if (status != 2) {
//						++countStatus;
//					}
//				}

					/*
					 * if done , create new reservation
					 */

					/*
					 * insert the reservation in the db
					 */
					reservationCO.setReservation_list_status(0);
					omniCommonPushDAO.insertReservation(reservationCO);
					omniCommonPushDAO.insertReservationList(reservationCO);

				}

				/*
				 * if the reservation is immediate , the date and time in request is null , set
				 * them the date and time of the server and set the status of machine_driver to
				 * unavailable
				 */
				if (reservationCO.getDate() == null && reservationCO.getTime() == null) {

					Date today = new Date(now);
					reservationCO.setDate(today);
					reservationCO.setTime(time);
					reservationCO.setReservation_type(0);
					reservationCO.setOccurrence_type(0);
					Machine_driverCO mdCO = new Machine_driverCO();
					mdCO.setMachine_driver_status(1);
					mdCO.setMachine_driver_id(reservationCO.getMachine_driver_id());
					omniCommonPushDAO.updateMachineDriverStatus(mdCO);
					/*
					 * insert the reservation in the db
					 */
					omniCommonPushDAO.insertReservation(reservationCO);
					omniCommonPushDAO.insertReservationList(reservationCO);

					/*
					 * put in the hashmap the client id , the client can't cancel the reservation
					 * after 5 min
					 */
					long timeReservation = System.currentTimeMillis();
					cancelTimerHashMap.put(reservationCO.getClient_id(), timeReservation);

				}
			}
			response.setReservation_id(reservationCO.getReservation_id());
			response.setReservation_list_id(reservationCO.getReservation_list_id());
			return response;

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public GetListOfMachinesResponse getListOfMachinesNearestMostFar(ReservationCO reservationCO) throws Exception {
		GetListOfMachinesResponse response = new GetListOfMachinesResponse();
		Machine_driverCO machine_driverCO = new Machine_driverCO();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		java.util.Date d = new java.util.Date();
		log.info("debut get listmethode" + format.format(d));

		try {
			prop = PropertiesLoaderUtils.loadAllProperties("Velocity.properties");
			String velocityString = prop.getProperty("velocity");
			int velocity = Integer.parseInt(velocityString);
			long now = System.currentTimeMillis();
			Date today = new Date(now);
			reservationCO.setDate(today);
			if (reservationCO.getTime() == null) {
				Time time = new Time(now);
				reservationCO.setTime(time);
			}
			reservationCO.setVelocity(velocity);
			log.info("debut get available" + format.format(new java.util.Date()));
			List<Machine_driverCO> maList = omniCommonPullDAO.returnListAvailableMachinesNearestMostFar(reservationCO);
			log.info("debut get unavailable" + format.format(new java.util.Date()));

			List<Machine_driverCO> unavList = omniCommonPullDAO.returnListUnavailableMachines(reservationCO);
			maList.addAll(unavList);
			log.info("fin get list method" + format.format(new java.util.Date()));

			maList = maList.stream()
//					.filter(l -> l.getTimeInSec() <= 1800)
					.sorted(Comparator.comparing(Machine_driverCO::getTimeToReachClient)).collect(Collectors.toList());
			log.info("fin stream" + format.format(new java.util.Date()));

			if (!maList.isEmpty()) {
				response.setList(maList);
			} else {
				response.setErrorCode(9011);
				response.setErrorDesc(
						getError(reservationCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

			}

			log.info("fin get list" + format.format(new java.util.Date()));
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

//	@Override
//	public GetListOfMachinesFromNearestToMostFarResponse GetListOfMachinesFromNearestToMostFar(
//			ReservationCO reservationCO) {
//		GetListOfMachinesFromNearestToMostFarResponse response = new GetListOfMachinesFromNearestToMostFarResponse();
//		List<Machine_driverCO> listOfMachines;
//		try {
//			TimeZone zone = TimeZone.getDefault();
//			String name = zone.getDisplayName();
//			System.out.println("Display name for default time zone: " + name);
//
//			long d = System.currentTimeMillis();
//			java.util.Date date = new java.util.Date(d);
//			prop = PropertiesLoaderUtils.loadAllProperties("Velocity.properties");
//			String velocityString = prop.getProperty("velocity");
//			int velocity = Integer.parseInt(velocityString);
//			long now = System.currentTimeMillis();
//			Date today = new Date(now);
//			Time time = new Time(now);
//			reservationCO.setVelocity(velocity);
//
//			if (reservationCO.getReservation_type() == 0) {
//				listOfMachines = omniCommonPullDAO.returnListOfMachinesFromNearestToMostFarTrip(reservationCO);
//				response.setList(listOfMachines);
//			} else {
//				listOfMachines = omniCommonPullDAO.returnListOfMachinesFromNearestToMostFarMachine(reservationCO);
//				response.setList(listOfMachines);
//			}
//			List<Machine_driverCO> listAvailable = omniCommonPullDAO
//					.returnListAvailableMachinesNearestMostFar(reservationCO);
//			listAvailable.addAll(listOfMachines);
//			listAvailable.stream().sorted(Comparator.comparing(Machine_driverCO::getTimeToReachClient))
//					.collect(Collectors.toList()).forEach(l -> System.out.println(l));

//			final Map<String, Long> tableMap = new HashMap<String, Long>();
//			BinaryLogClient client = new BinaryLogClient("localhost", 3306, "root", "123456");
//
//			Pusher pusher = new Pusher("1166138", "044c0754bec6c190b7c6", "e8904c7eb0a8516bb970");
//			pusher.setCluster("eu");
//			pusher.setEncrypted(true);
//
//			client.registerEventListener(event -> {
//				EventData data = event.getData();
//				System.out.println(event);
//
//				if (data instanceof TableMapEventData) {
//					TableMapEventData tableData = (TableMapEventData) data;
//					if(tableData.getTable().equals("reservation_list") ) {
//						tableMap.put(tableData.getTable(), tableData.getTableId());
//					}
//				}
//				else if(data instanceof WriteRowsEventData) {
//                    WriteRowsEventData eventData = (WriteRowsEventData)data;
//                    
//                    if(eventData.getTableId() == tableMap.get(PRODUCT_TABLE_NAME)                 	                   	) {
//                        for(Object[] product: eventData.getRows()) {
//                            pusher.trigger(
//                               PRODUCT_TABLE_NAME, "insert", getProductMap(product)
//                            );
//                        }
//                    }
//                }
//			});
////			client.connect();
//			return response;
//		} catch (Exception e) {
//			log.info(e.getMessage());
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}

	static Map<String, String> getProductMap(Object[] product) {
		Map<String, String> map = new HashMap<>();
		map.put("id", java.lang.String.valueOf(product[0]));
		map.put("name", java.lang.String.valueOf(product[1]));
		map.put("price", java.lang.String.valueOf(product[2]));

		return map;
	}

	public ValidateRecurringReservationResponse validateRecurringReservation(ReservationCO reservationCO)
			throws DAOException, IOException {

		ValidateRecurringReservationResponse response = new ValidateRecurringReservationResponse();
		prop = PropertiesLoaderUtils.loadAllProperties("Velocity.properties");
		String velocityString = prop.getProperty("velocity");
		int velocity = Integer.parseInt(velocityString);
		int count = 0;
		CostResponse cost = new CostResponse();
		ReservationCO res = new ReservationCO();
		try {
			reservationCO.setVelocity(velocity);
			/*
			 * get the temp_reservation_id from the cache value , if the server is reseted ,
			 * get the value from the temporary table , then add 1
			 *
			 */
			int r = getTemp_reservation_id();
			if (r == 0) {
				TemporaryReservationVO maxID = omniCommonPullDAO.returnMaxTemporaryReservation(reservationCO);
				/*
				 * if the value of reservation_id is null , so no reservation in the database ,
				 * this is the first one
				 */
				if (maxID == null) {
					setTemp_reservation_id(1);
				} else {
					int i = maxID.getTemp_reservation_id();
					setTemp_reservation_id(++i);
				}

			} else {

				setTemp_reservation_id(++r);
			}

			TemporaryReservationVO tempReservVO = new TemporaryReservationVO();

			/*
			 * check if the reservation is recurring
			 */
			if (reservationCO.getOccurrence_type() == 1) {
				List<ReservationListVO> list = reservationCO.getListDate();

				/*
				 * loop to check available machine at all date mentioned in list by the client
				 */
				for (int s = 0; s < list.size(); s++) {

					ReservationCO tempres = new ReservationCO();
					tempres.setDate(reservationCO.getListDate().get(s).getDate());
					tempres.setTime(reservationCO.getListDate().get(s).getTime());
					tempres.setTime_slot(reservationCO.getListDate().get(s).getTime_slot());
					tempres.setClient_id(reservationCO.getClient_id());
					tempres.setTemp_reservation_id(getTemp_reservation_id());
					tempres.setVelocity(velocity);

					/*
					 * insert in the temporary reservation the available machine find at each date
					 * in order to reserve it temporary until the client confirm the reservation
					 * then insert into the main tables
					 */
					try {
						if (reservationCO.getReservation_type() == 0) {
							omniCommonPushDAO.insertTempReservationTrip(tempres);
						} else if (reservationCO.getReservation_type() == 1) {
							omniCommonPushDAO.insertTempReservationMachine(tempres);
						}

						/*
						 * if no available machine at this time , the insertTemoReservation will get
						 * exception
						 */
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("no available machine at this time");
						/*
						 * the client choose a machine ealier
						 */
						try {
							if (reservationCO.getNew_time() == 0) {
								if (reservationCO.getReservation_type() == 0) {
									omniCommonPushDAO.insertTempReservationTripBefore(tempres);
								} else if (reservationCO.getReservation_type() == 1) {
									omniCommonPushDAO.insertTempReservationMachineBefore(reservationCO);

								}
								/*
								 * the client choose a machine later
								 */
							} else {
								if (reservationCO.getReservation_type() == 0) {
									omniCommonPushDAO.insertTempReservationTripAfter(reservationCO);
								} else if (reservationCO.getReservation_type() == 1) {
									omniCommonPushDAO.insertTempReservationMachineAfter(reservationCO);
								}
							}
							count++;
							/*
							 * no available machines at this date
							 */
						} catch (Exception ex) {
							log.info(ex.getMessage());
							log.info("no available machine at " + tempres.getDate());
						}
					}

				}
				/*
				 * we have available machines at all date , so auto confirm the reservation
				 * insert into the main tables the reservations , then delete from the
				 * temprorary_reservation
				 */
				if (count == 0) {
					reservationCO.setTemp_reservation_id(getTemp_reservation_id());
					omniCommonPushDAO.insertReservation(reservationCO);
					omniCommonPushDAO.insertRecurring_template(reservationCO);
					omniCommonPushDAO.insertListReservationList(reservationCO);
					omniCommonPushDAO.deleteTemporaryReservation(reservationCO);
					cost = getCost(reservationCO);
					reservationCO.setTotal_cost(cost.getTotalCost());
					reservationCO.setCost_after_discount(cost.getCostAfterDiscount());
					reservationCO.setDiscount(cost.getDiscount());
					omniCommonPushDAO.insertFacture(reservationCO);

				}
				response.setCount(count);
				response.setTemp_reservation_id(getTemp_reservation_id());
			}
			/*
			 * the type of reservation is one time in the future
			 */
			else if (reservationCO.getOccurrence_type() == 2) {
				/*
				 * we have an available machine at this date and time so insert into temproary
				 * reservation then auto confirm , insert into main tables, then delete from
				 * temproray reservation
				 */

				try {
					reservationCO.setTemp_reservation_id(getTemp_reservation_id());

					if (reservationCO.getReservation_type() == 0) {
						omniCommonPushDAO.insertTempReservationTrip(reservationCO);
						res = omniCommonPullDAO.returnDistance(reservationCO);
						reservationCO.setDistance(res.getDistance());
					} else if (reservationCO.getReservation_type() == 1) {
						omniCommonPushDAO.insertTempReservationMachine(reservationCO);
					}

					omniCommonPushDAO.insertReservation(reservationCO);
					omniCommonPushDAO.insertListReservationList(reservationCO);
					omniCommonPushDAO.deleteTemporaryReservation(reservationCO);

					cost = getCost(reservationCO);
					response.setCost(cost.getCost());
					omniCommonPushDAO.insertFacture(reservationCO);

					response.setResponse("the reservation at " + reservationCO.getDate() + " is confirmed");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					/*
					 * no available machine at this time so if new time = 0 check a machine before
					 * if new time = 1 check a machine after
					 */
					try {
						if (reservationCO.getNew_time() == 0) {
							if (reservationCO.getReservation_type() == 0) {
								omniCommonPushDAO.insertTempReservationTripBefore(reservationCO);
							} else if (reservationCO.getReservation_type() == 1) {
								omniCommonPushDAO.insertTempReservationMachineBefore(reservationCO);
							}

							response.setErrorCode(9013);
							response.setResponseDesc("no available machine at future date , reserve one ealier");
						} else if (reservationCO.getNew_time() == 1) {
							if (reservationCO.getReservation_type() == 0) {
								omniCommonPushDAO.insertTempReservationTripAfter(reservationCO);
							} else if (reservationCO.getReservation_type() == 1) {
								omniCommonPushDAO.insertTempReservationMachineAfter(reservationCO);
							}
							response.setErrorCode(9014);
							response.setErrorDesc("no available machine at future date, reserve one later");
						}
					} catch (Exception e1) {
						/*
						 * no available machines
						 */
						log.info(e1.getMessage());
						log.info("no available machine at " + reservationCO.getDate());
					}
				}
				if (reservationCO.getReservation_type() == 0) {
					res = omniCommonPullDAO.returnDistance(reservationCO);
					reservationCO.setDistance(res.getDistance());
				}

				cost = getCost(reservationCO);

			}
			response.setCost(cost.getCost());
			response.setTotalCost(cost.getTotalCost());
			response.setDiscount(cost.getDiscount());
			response.setCost_after_discount(cost.getCostAfterDiscount());
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unused")
	@Override
	public ConfirmReservationResponse confirmReservation(ReservationCO reservationCO) throws Exception {
		try {
			ConfirmReservationResponse response = null;

			/*
			 * if the reservation is one time now and one time in future
			 */
			if (reservationCO.getOccurrence_type() == 0 || reservationCO.getOccurrence_type() == 2) {
				/*
				 * insert into the reservation table the main details for reservation
				 */
				omniCommonPushDAO.insertReservation(reservationCO);
				/*
				 * insert into the reservation_list table the details for reservation as date
				 * time and machine_driver_id
				 */
				omniCommonPushDAO.insertReservationList(reservationCO);

				/*
				 * get the details of machine and driver reserved to return to the client
				 */
				Machine_driverCO machine = omniCommonPullDAO.returnMachineDriverDetails(reservationCO);
				response = new ConfirmReservationResponse(machine.getMachine_plate_number(), machine.getDriver_name(),
						machine.getDriver_mobile_number(), machine.getPic());

				/*
				 * get the current time for reservation and cache it ,to use when the client
				 * want to cancel the reservation
				 */

				long timeReservation = System.currentTimeMillis();
				cancelTimerHashMap.put(reservationCO.getClient_id(), timeReservation);

			} else if (reservationCO.getOccurrence_type() == 1) { // recurring reservation
				/*
				 * insert into reservation table the main details for the reservation
				 */
				omniCommonPushDAO.insertReservation(reservationCO);
				/*
				 * insert into recurring template the details for recurring reservation as
				 * peridicity , start and end date , and how many times repeat
				 */
				omniCommonPushDAO.insertRecurring_template(reservationCO);

				/*
				 * insert into the reservation_list table the list of reservations with date
				 * time and machine_driver_id , then delete from temporary_reservation
				 */
				omniCommonPushDAO.insertListReservationList(reservationCO);
				omniCommonPushDAO.deleteTemporaryReservation(reservationCO);
				response.setResponse("the reservation is confirmed");

			}
			/*
			 * insert the facture in db
			 */
			omniCommonPushDAO.insertFacture(reservationCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public CheckTempRecurringReservationResponse checkTempRecurringReservation(
			TemporaryReservationVO temporaryReservationVO) throws Exception {
		CheckTempRecurringReservationResponse response = new CheckTempRecurringReservationResponse();
		try {
			List<TemporaryReservationVO> listOfReservations = omniCommonPullDAO
					.returnListOfTmeporaryReservation(temporaryReservationVO);
			response.setList(listOfReservations);
			return response;
		} catch (Exception e) {
			return null;
		}

	}

	@Override

	public CancelReservationResponse cancelReservation(ReservationCO reservationCO) throws Exception {
		CancelReservationResponse response = new CancelReservationResponse();
		try {
			prop = PropertiesLoaderUtils.loadAllProperties("cancelReservation.properties");
			String counterPerDayString = prop.getProperty("Cancelation_counter");
			int counterPerDay = Integer.parseInt(counterPerDayString);

			long now = System.currentTimeMillis();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = new java.util.Date();
			String today = format.format(d);

			long endDate = getCancelTimerHashMap().get(reservationCO.getClient_id()) + TimeUnit.MINUTES.toMillis(30);

			ReservationListVO reservationListVO = new ReservationListVO();
			reservationListVO.setReservation_id(reservationCO.getReservation_id());

			ReservationCO c = omniCommonPullDAO.returnReservationDetails(reservationListVO);
			Machine_driverCO machineDriverCO = new Machine_driverCO();
			machineDriverCO.setMachine_driver_status(0);
			machineDriverCO.setMachine_driver_id(c.getMachine_driver_id());

			if (endDate > now) {
				System.out.println(cancelCounterHashMap.containsKey(reservationCO.getClient_id()));
				if (cancelCounterHashMap.containsKey(reservationCO.getClient_id())) {
					System.out.println(cancelCounterHashMap.get(reservationCO.getClient_id()));
					if (cancelCounterHashMap.get(reservationCO.getClient_id()).containsKey(today)) {
						int count = cancelCounterHashMap.get(reservationCO.getClient_id()).get(today);

						if (count < counterPerDay) {
							HashMap<String, Integer> map = new HashMap<String, Integer>();
							map.put(today, ++count);
							cancelCounterHashMap.replace(reservationCO.getClient_id(), map);

							omniCommonPushDAO.updateMachineDriverStatus(machineDriverCO);
							omniCommonPushDAO.deleteReservation(reservationCO);

						} else {
							response.setErrorCode(9015);
							response.setErrorDesc(
									getError(reservationCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

							return response;
						}
					}
				} else {
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					map.put(today, 0);
					cancelCounterHashMap.put(reservationCO.getClient_id(), map);

					omniCommonPushDAO.updateMachineDriverStatus(machineDriverCO);
					omniCommonPushDAO.deleteReservation(reservationCO);
				}

				response.setResponse("reservation canceled");

				return response;
			} else {
				response.setErrorCode(9004);
				response.setErrorDesc(
						getError(reservationCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

				return response;
			}

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public UpdateReservationStatusResponse updateReservationStatus(DriverCO driverCO) throws Exception {
		UpdateReservationStatusResponse response = new UpdateReservationStatusResponse();
		try {
			omniCommonPushDAO.updateReservationStatus(driverCO);
			if (driverCO.getReservation_list_status() == 2) {
				omniCommonPushDAO.updateMachineLocation(driverCO);
			}
			response.setResponse("status updated");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public RatingTripResponse ratingTrip(RateVO rateVO) throws Exception {
		RatingTripResponse response = new RatingTripResponse();
		try {
			omniCommonPushDAO.insertRating(rateVO);
			response.setResponse("thank you for using our app");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public LogoutResponse logout(ClientCO clientCO) throws Exception {
		LogoutResponse response = new LogoutResponse();
		try {
//			PublicKey k = clientHashMap.get(clientCO.getDevice_UUID()).getFrontEndPublicKey();
			clientHashMap.remove(clientCO.getDevice_UUID());
			clientCO.setClient_status(1);
			omniCommonPushDAO.updateClientStatus(clientCO);
			response.setResponse("logout successfuly");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public GetDriverInfosResponse getDriverInfos(DriverVO driverVO) throws Exception {
		GetDriverInfosResponse response = new GetDriverInfosResponse();
		try {
			DriverVO driverInfos = omniCommonPullDAO.returnDriverInfos(driverVO);
			if (driverInfos != null) {
				response.setDriver_id(driverInfos.getDriver_id());
				response.setName(driverInfos.getName());
				response.setAddress(driverInfos.getAddress());
				response.setType(driverInfos.getType());
				response.setMobile_number(driverInfos.getMobile_number());
				response.setDriver_status(driverInfos.getDriver_status());
				response.setPic(driverInfos.getPic());
				response.setPic_of_id(driverInfos.getPic_of_id());
			} else {
				response.setErrorCode(9006);
				response.setErrorDesc("no driver");
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public AddDriverResponse addDriver(DriverVO driverVO) throws Exception {
		AddDriverResponse response = new AddDriverResponse();
		DriverVO driver = new DriverVO();
		try {// check if the driver is already exist
			driver = omniCommonPullDAO.returnDriver(driverVO);
			if (driver == null) { // driver not exist
				omniCommonPushDAO.insertDriver(driverVO);
				response.setResponse("driver added successfuly");
			} else {
				response.setErrorCode(9009);
				response.setErrorDesc("the driver is already exist");
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public AddMachineResponse addMachine(MachineVO machineVO) throws Exception {
		AddMachineResponse response = new AddMachineResponse();
		MachineVO machine = new MachineVO();
		try {
			// check if machine exist in db
			machine = omniCommonPullDAO.returnMachineByPlateNumber(machineVO);
			if (machine == null) { // machine not exist
				omniCommonPushDAO.insertMachine(machineVO);
				response.setResponse("machine added successfuly");
			} else {
				response.setErrorCode(9010);
				response.setErrorDesc("the machine is already exist");
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public GetClientInfosResponse getClientInfos(ClientVO clientVO) throws Exception {
		ClientVO cliVo = new ClientVO();
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			java.util.Date d = new java.util.Date();
			log.info("debut" + format.format(d));
			cliVo = omniCommonPullDAO.returnClientInfos(clientVO);
			java.util.Date d1 = new java.util.Date();
			log.info("fin" + format.format(d1));
			return new GetClientInfosResponse(cliVo.getName(), cliVo.getProfile());
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateClientInfosResponse updateClientInfos(ClientVO clientVO) {
		UpdateClientInfosResponse response = new UpdateClientInfosResponse();
		try {
			/*
			 * update client infos
			 */
			omniCommonPushDAO.updateClientInfos(clientVO);
			response.setResponse("done");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ChangePasswordResponse changePassword(ClientCO clientCO) throws Exception {
		ChangePasswordResponse response = new ChangePasswordResponse();
		ClientVO client = new ClientVO();
		ClientCO newClient = new ClientCO();

		try {
			// get the username and password from db for this user by id
			client = omniCommonPullDAO.returnUsernamePasswordById(clientCO);

			// password hashing is on "concatenation and salting for username and
			// password and a static value to be defined in property file.
			prop = PropertiesLoaderUtils.loadAllProperties("HashPassword.properties");
			String value = prop.getProperty("value");
			String oldPass = client.getUsername() + clientCO.getOldpassword() + value;
			String newPass = client.getUsername() + clientCO.getPassword() + value;

			// check if the old password in request is the same password in db
			if (SecurityUtilsExt.validatePassword(oldPass, client.getSalt(), client.getPassword())) {

				// hash the new password to save in db
				String salt = SecurityUtilsExt.getNextSalt();
				String hash = SecurityUtilsExt.hash(newPass, salt);
				newClient.setPassword(hash);
				newClient.setSalt(salt);
				newClient.setClient_id(clientCO.getClient_id());
				omniCommonPushDAO.updatePassword(newClient);
				response.setResponse("password changed");
				response.setClient_id(clientCO.getClient_id());
			} else {
				// incorrect password
				response.setErrorCode(9008);
				response.setErrorDesc(
						getError(clientCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

			}

			return response;
		} catch (

		Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ChangeProfileResponse changeProfile(ClientVO clientVO) throws Exception {
		ChangeProfileResponse response = new ChangeProfileResponse();
		try {
			omniCommonPushDAO.updateProfile(clientVO);
			response.setResponse("done");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public GetMachineInfosResponse getMachineInfos(MachineVO machineVO) throws Exception {
		GetMachineInfosResponse response = new GetMachineInfosResponse();
		MachineVO vo = new MachineVO();
		try {
			vo = omniCommonPullDAO.returnMachineInfos(machineVO);
			response.setModel(vo.getModel());
			response.setPlate_number(vo.getPlate_number());
			response.setMachine_status(vo.getMachine_status());
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateMachineInfosResponse updateMachineInfos(MachineCO machineCO) throws Exception {
		UpdateMachineInfosResponse response = new UpdateMachineInfosResponse();
		MachineDriverVO machineDriverVO = new MachineDriverVO();
		Machine_driverCO machineDriverCO = new Machine_driverCO();
		try {
			omniCommonPushDAO.updateMachineInfos(machineCO);

			/**
			 * check if the machine status is not available (inMaintenance, suspended)
			 */
			if (machineCO.getMachine_status() != 0) {
				/*
				 * update the status of machine_driver , set unavailable
				 */
				machineDriverCO.setMachine_id(machineCO.getMachine_id());
				machineDriverCO.setMachine_driver_status(1);
				omniCommonPushDAO.updateMachineDriverStatus(machineDriverCO);
				/*
				 * if the inMaintenance
				 */
				if (machineCO.getMachine_status() == 2)
					omniCommonPushDAO.insertMachineMnt(machineCO);
				/*
				 * check the reservation of this machine in date and time after the time to
				 * change the machine status
				 */
				machineDriverVO.setMachine_id(machineCO.getMachine_id());
				getNewMachine(machineDriverVO);

				response.setErrorCode(9018);
				response.setErrorDesc(
						getError(machineCO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());


			}
			response.setResponse("machine updated successfully");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	public void getNewMachine(MachineDriverVO machineDriverVO) throws DAOException {

		ReservationCO reservationCO = new ReservationCO();

		List<ReservationListVO> list = checkMachineDriverReservation(machineDriverVO);

		/**
		 * the list is not null, the machine has reservations
		 */
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				/**
				 * update the status of reservation list, set it 4 (the machine driver is
				 * unavailable)
				 */
				reservationCO.setReservation_list_status(4);
				reservationCO.setReservation_list_id(list.get(i).getReservation_list_id());
				omniCommonPushDAO.updateReservationListStatus(reservationCO);

				/**
				 * get the details as locations and type of each reservation
				 */
				reservationCO = omniCommonPullDAO.returnReservationDetails(list.get(i));

				/**
				 * set the status of reservation machine driver is unavailable
				 */
				reservationCO.setReservation_status(1);
				omniCommonPushDAO.updateReservStatus(reservationCO);

				/**
				 * check the occurrence type of the reservation , if the reservation is one time
				 * if recurring
				 */
				if (reservationCO.getOccurrence_type() == 1) {
					reservationCO.setStart_date(reservationCO.getDate());
					reservationCO.setStart_time(reservationCO.getTime());
				}

				/**
				 * search an available machine and insert into temporary reservation
				 */
				reservationCO.setTime_slot(list.get(i).getTime_slot());
				reservationCO.setMachine_driver_id(list.get(i).getMachine_driver_id());
				int TempReservationId = getTempReservationId(reservationCO);
				reservationCO.setTemp_reservation_id(TempReservationId);

				try {
					reservationCO.setReservation_status(0);
					// omniCommonPushDAO.insertTempReservation(reservationCO);

					/**
					 * we have an available machine so auto confirm the reservation and insert into
					 * the main tables
					 */

					omniCommonPushDAO.insertReservation(reservationCO);
					omniCommonPushDAO.insertReservationListMachineInfos(reservationCO);
				} catch (Exception e) {

					try {
						omniCommonPushDAO.insertTempReservationTripBefore(reservationCO);
					} catch (Exception e1) {
						omniCommonPushDAO.insertTempReservationTripAfter(reservationCO);
					}
				}

			}
		}
	}

	@Override
	public UpdateDriverInfosResponse updateDriverInfos(DriverVO driverVO) throws Exception {
		UpdateDriverInfosResponse response = new UpdateDriverInfosResponse();
		MachineDriverVO machineDriverVO = new MachineDriverVO();
		try {

			omniCommonPushDAO.updateDriverInfos(driverVO);
			if (driverVO.getDriver_status() != 0) {

				/**
				 * check the reservation of this machine in date and time after the time to
				 * change the machine status , reserve another one
				 */
				machineDriverVO.setDriver_id(driverVO.getDriver_id());
				getNewMachine(machineDriverVO);

				response.setErrorCode(9018);
				response.setErrorDesc(
						getError(driverVO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());

			}
			response.setResponse("driver updated successfully");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<ReservationListVO> checkMachineDriverReservation(MachineDriverVO machineDriverVO) {
		ReservationListVO reservationListVO = new ReservationListVO();
		MachineDriverSC machineDriverSC = new MachineDriverSC();
		try {
			long now = System.currentTimeMillis();
			Date today = new Date(now);
			Time time = new Time(now);
			machineDriverSC.setMachine_id(machineDriverVO.getMachine_id());
			machineDriverSC.setDriver_id(machineDriverVO.getDriver_id());
			machineDriverSC.setDate(today);
			machineDriverSC.setTime(time);
			List<ReservationListVO> list = omniCommonPullDAO.returnIfMachineDriverIsReserved(machineDriverSC);
			return list;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public ReturnReservationsListResponse returnReservationsList(ReservationVO reservationVO) throws Exception {
		ReturnReservationsListResponse response = new ReturnReservationsListResponse();

		try {
			/*
			 * return the list of reservations for client
			 */
			List<ReservationSC> listOfReservations = omniCommonPullDAO.returnReservationsList(reservationVO);
			/*
			 * if list empty so return no reservation
			 */
			if (listOfReservations.isEmpty()) {
				response.setErrorCode(9012);
				response.setErrorDesc(
						getError(reservationVO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());
			} else {
				response.setListOfReservations(listOfReservations);
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ReturnReservationDetailsResponse returnReservationDetails(ReservationVO reservationVO) throws Exception {
		ReturnReservationDetailsResponse response = new ReturnReservationDetailsResponse();
		ReservationVO reservationOccurrenceType = new ReservationVO();
		ReservationListVO reservationListVO = new ReservationListVO();
		try {
			/*
			 * check if the reservation is recurring or one time
			 */
			reservationOccurrenceType = omniCommonPullDAO.returnReservationOccurrenceType(reservationVO);
			/*
			 * the type of reservation is one time
			 */
			if (reservationOccurrenceType.getOccurrence_type() == 0) {
				/*
				 * return details of the reservation from reservation_list table
				 */
				reservationListVO = omniCommonPullDAO.returnOneTimeReservationDetails(reservationVO);
				response.setReservationListVO(reservationListVO);
			}
			/*
			 * the reservation is recurring
			 */
			else {
				/*
				 * return the details from reservation , reservation_list and recurring template
				 * tables
				 */
				List<ReservationCO> listOfReservations = omniCommonPullDAO
						.returnRecurringReservationDetails(reservationVO);
				response.setListReservationsDetails(listOfReservations);
			}
			return response;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public RejectReservationResponse rejectReservation(ReservationCO reservationCO) throws Exception {
		RejectReservationResponse response = new RejectReservationResponse();
		try {
			omniCommonPushDAO.deleteTemporaryReservation(reservationCO);
			response.setResponse("reservation rejected");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateDriverWorkingHoursResponse updateDriverWorkingHours(WorkingHoursVO workingHoursVO) throws Exception {
		UpdateDriverWorkingHoursResponse response = new UpdateDriverWorkingHoursResponse();
		try {
			omniCommonPushDAO.updateDriverWorkingHours(workingHoursVO);
			response.setResponse("done");
			return response;
		} catch (Exception e) {
			return null;
		}

	}

	public int getTempReservationId(ReservationCO reservationCO) {
		try {
			/*
			 * get the temp_reservation_id from the cache value , if the server is reseted ,
			 * get the value from the temporary table , then add 1
			 *
			 */
			int r = getTemp_reservation_id();
			if (r == 0) {
				TemporaryReservationVO maxID = omniCommonPullDAO.returnMaxTemporaryReservation(reservationCO);
				/*
				 * if the value of reservation_id is null , so no reservation in the database ,
				 * this is the first one
				 */
				if (maxID == null) {
					setTemp_reservation_id(1);
				} else {
					int i = maxID.getTemp_reservation_id();
					setTemp_reservation_id(++i);
				}

			} else {

				setTemp_reservation_id(++r);
			}
			return temp_reservation_id;
		} catch (Exception e) {
			log.info(e.getMessage());
			return 0;
		}

	}

	@Override
	public CostResponse getCost(ReservationCO reservationCO) throws Exception {
		CostResponse response = new CostResponse();
		double totalCost = 0;
		GetDiscountResponse getDiscount;
		try {
			prop = PropertiesLoaderUtils.loadAllProperties("Cost.properties");
			String costOf100mString = prop.getProperty("Cost_of_100_m");
			int costOf100m = Integer.parseInt(costOf100mString);
			String costOf10minString = prop.getProperty("Cost_of_10_min");
			int costOf10min = Integer.parseInt(costOf10minString);
			HashMap<Date, Double> listOfCost = new HashMap<Date, Double>();

			prop = PropertiesLoaderUtils.loadAllProperties("Discount.properties");

			double cost = 0;

			/**
			 * check if the type of reservation if trip or machine
			 */
			if (reservationCO.getReservation_type() == 0) {
				/**
				 * the type is trip
				 */
				cost = (reservationCO.getDistance() * costOf100m) / 100;
				if (reservationCO.getOccurrence_type() == 0 || reservationCO.getOccurrence_type() == 2) {
					response.setCost((reservationCO.getDistance() * costOf100m) / 100);
				} else if (reservationCO.getOccurrence_type() == 1) {
					response.setCostOfEachReserv(cost);
					totalCost = cost * reservationCO.getRecur_count();
					response.setTotalCost(cost * reservationCO.getRecur_count());
					getDiscount = getDiscount(reservationCO.getRecur_count(), totalCost);
					response.setDiscount(getDiscount.getDiscount());
					response.setCostAfterDiscount(getDiscount.getCost_after_discount());
				}
			}
			/**
			 * type is machine
			 */
			else if (reservationCO.getReservation_type() == 1) {
				String stringDate = reservationCO.getTime_slot().toString();
				String[] hAndm = stringDate.split(":");
				int time_slot = Integer.parseInt(hAndm[0]) * 60 + Integer.parseInt(hAndm[1]);
				cost = ((time_slot * costOf10min) / 10);
				if (reservationCO.getOccurrence_type() == 0 || reservationCO.getOccurrence_type() == 2) {
					response.setCost(cost);
				} else if (reservationCO.getOccurrence_type() == 1) {
					response.setCostOfEachReserv(cost);
					totalCost = cost * reservationCO.getRecur_count();
					response.setTotalCost(cost * reservationCO.getRecur_count());
					getDiscount = getDiscount(reservationCO.getRecur_count(), totalCost);
					response.setDiscount(getDiscount.getDiscount());
					response.setCostAfterDiscount(getDiscount.getCost_after_discount());
				}
			}

			return response;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public GetDiscountResponse getDiscount(int recur_count, double totalCost) throws Exception {
		GetDiscountResponse response = new GetDiscountResponse();
		double cost_after_discount = 0;
		int discount = 0;

		prop = PropertiesLoaderUtils.loadAllProperties("Discount.properties");
		if (recur_count <= 10) {
			String costOf100mString = prop.getProperty("10");
			discount = Integer.parseInt(costOf100mString);
			cost_after_discount = totalCost - ((totalCost * discount) / 100);
		} else if (recur_count <= 30 && recur_count >= 10) {
			String costOf100mString = prop.getProperty("30");
			discount = Integer.parseInt(costOf100mString);
			cost_after_discount = totalCost - ((totalCost * discount) / 100);
		} else if (recur_count <= 50 && recur_count >= 30) {
			String costOf100mString = prop.getProperty("50");
			discount = Integer.parseInt(costOf100mString);
			cost_after_discount = totalCost - ((totalCost * discount) / 100);
		} else if (recur_count <= 100 && recur_count >= 50) {
			String costOf100mString = prop.getProperty("100");
			discount = Integer.parseInt(costOf100mString);
			cost_after_discount = totalCost - ((totalCost * discount) / 100);
		}
		response.setCost_after_discount(cost_after_discount);
		response.setDiscount(discount);
		return response;
	}

	@Override
	public AddStoreResponse addStore(StoreVO storeVO) throws Exception {
		AddStoreResponse response = new AddStoreResponse();
		StoreVO vo = new StoreVO();
		try {
			vo = omniCommonPullDAO.returnStore(storeVO);
			if (vo == null) {
				omniCommonPushDAO.insertStore(storeVO);
				response.setResponse("store added successfully");
			} else if (vo != null) {
				response.setErrorCode(9020);
				response.setErrorDesc(
						getError(storeVO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override

	public AddDestinationResponse addDestination(List_destinationsVO list_destinationsVO) throws Exception {
		AddDestinationResponse response = new AddDestinationResponse();
		try {
			omniCommonPushDAO.insertDestination(list_destinationsVO);
			response.setResponse("done");
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public GetListOfDestinaitonsResponse getListOfDestinaitons(List_destinationsVO list_destinationsVO)
			throws Exception {
		GetListOfDestinaitonsResponse response = new GetListOfDestinaitonsResponse();
		try {
			List<List_destinationsVO> list = omniCommonPullDAO.returnListOfDestination(list_destinationsVO);
			response.setList(list);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ForgetPasswordResponse forgetPassword(ClientVO clientVO) throws Exception {
		ForgetPasswordResponse response = new ForgetPasswordResponse();
		try {

			ClientVO clientVO2 = omniCommonPullDAO.returnMobileNumber(clientVO);
			if (clientVO2 == null) {
				response.setErrorCode(9017);
				response.setErrorDesc(
						getError(clientVO.getLanguage_id(), response.getErrorCode()).get(0).getError_desc());
			} else {
				char[] mask = Arrays.copyOfRange(clientVO2.getMobile_number().toCharArray(), 9,
						clientVO2.getMobile_number().toCharArray().length);
				for (int i = 0; i < mask.length - 2; i++) {
					mask[i] = '*';
				}
				String secretKey = SecurityUtilsExt.generateSecretKeyAsString();
				String otp = SecurityUtilsExt.getTOTPCode(secretKey);
				otpHashMap.put(clientVO2.getMobile_number(), secretKey);
				response.setMask(String.valueOf(mask));
				response.setMobile_number(clientVO2.getMobile_number());
				response.setOtp(otp);
			}
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ResetPasswordResponse resetPassword(ClientVO clientVO) throws Exception {
		try {
			prop = PropertiesLoaderUtils.loadAllProperties("HashPassword.properties");
			String value = prop.getProperty("value");
			String pass = clientVO.getUsername() + clientVO.getPassword() + value;
			String salt = SecurityUtilsExt.getNextSalt();
			clientVO.setPassword(SecurityUtilsExt.hash(pass, salt));
			clientVO.setSalt(salt);
			omniCommonPushDAO.resetPassword(clientVO);
			return new ResetPasswordResponse("done");
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public GetListDevicesResponse getListDevices(ClientVO clientVO) throws Exception {
		try {
			List<ClientCO> list = omniCommonPullDAO.returnListDevices(clientVO);
			return new GetListDevicesResponse(list);
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UnregisterDeviceResponse unregisterDevice(ClientCO clientCO) throws Exception {

		try {
			omniCommonPushDAO.deleteCombinationDeviceUsername(clientCO);
			return new UnregisterDeviceResponse("done");
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	@PostConstruct
	public void getErrors() throws Exception {
		ErrorVO errorVO = new ErrorVO();
		listErrors = omniCommonPullDAO.returnLanguageError(errorVO);
		for(ErrorVO list : listErrors) {
			System.out.println(list.getError_desc());
		}
	}

	public List<ErrorVO> getError(int language_id, int errorCode) {
		List<ErrorVO> list = listErrors.stream().filter(l -> l.getError_code() == errorCode)
				.filter(l -> l.getLanguage_id() == language_id).collect(Collectors.toList());
		return list;
	}

	@Override
	public AuthenticateDriverResponse authenticateDriverResponse(DriverDeviceCO driverDeviceCO) throws Exception {
		AuthenticateDriverResponse response;
		try {
			Driver_deviceVO driver_deviceVO = OmniCommonPullDAO.returnCombinationDriverDevice(driverDeviceCO);
			
			return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	
}