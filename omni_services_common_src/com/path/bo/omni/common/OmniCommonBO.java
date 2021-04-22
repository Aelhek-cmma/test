package com.path.bo.omni.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.ClientCO;
import com.path.dbmaps.vo.ClientVO;
import com.path.dbmaps.vo.DriverCO;
import com.path.dbmaps.vo.DriverVO;
import com.path.dbmaps.vo.List_destinationsVO;
import com.path.dbmaps.vo.MachineCO;
import com.path.dbmaps.vo.MachineVO;
import com.path.dbmaps.vo.RateVO;
import com.path.dbmaps.vo.ReservationCO;
import com.path.dbmaps.vo.ReservationVO;
import com.path.dbmaps.vo.SimVO;
import com.path.dbmaps.vo.StoreVO;
import com.path.dbmaps.vo.TemporaryReservationVO;
import com.path.dbmaps.vo.WorkingHoursVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
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
 * 
 * this source code
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * 
 * @author: ChadiAssaf
 *
 *          OmniCommonBO.java used to
 */
public interface OmniCommonBO {

	/**
	 * method that cache the public key of frontEnd, and Pair Key of backEnd
	 * 
	 * @param frontEndPublicKey
	 * @return
	 * @throws Exception
	 */
	public HandShakeResponse handShake(HandShakeRequest handShakeRequest) throws Exception;

	/**
	 * method that authenticate the user ,
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public AuthenticateResponse authenticate(ClientCO clientCO) throws Exception;

	/**
	 * method that generate the otp ,
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public GenerateOTPResponse generateOTP(SimVO simVO) throws Exception;

	/**
	 * method that check the validation of OTP the user ,
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ValidateOTPResponse validateOTP(ValidateOTPRequest validationRequest) throws Exception;

	/**
	 * method that get the username and password if valid return valid , if invalid
	 * return error
	 * 
	 * @param loginRequest
	 * @return
	 * @throws Exception
	 */
	public LoginResponse login(ClientCO clientCO) throws Exception;

	/**
	 * method to save the username and password with this device
	 * 
	 * @param clientCO
	 * @return
	 * @throws Exception
	 */
	public RememberDeviceResponse rememberDevice(ClientCO clientCO) throws Exception;

	/**
	 * method that check if the username is already exist , if exist send msg to
	 * choose another one
	 * 
	 * @param checkUsernameRequest
	 * @return
	 * @throws Exception
	 */
	public CheckUsernameResponse checkUsername(ClientVO clientVO) throws Exception;

	/**
	 * method that registre a client , insert the username and password in bd and
	 * mobile_number
	 * 
	 * @param registrationRequest
	 * @throws Exception
	 */
	public RegisterUserResponse registerUser(ClientCO clientCO) throws Exception;

	/**
	 * method that reserve the nearest available machine
	 * 
	 * @param reservationCO
	 * @return
	 * @throws Exception
	 */
	public CreateReservationResponse createReservation(ReservationCO reservationCO) throws Exception;

	/**
	 * method that return the list of available machines from the nearest to the most far
	 * @param reservationCO
	 * @return
	 * @throws Exception
	 */
	public GetListOfMachinesResponse getListOfMachinesNearestMostFar(
			ReservationCO reservationCO) throws Exception;

	/**
	 * method return list of machines from the nearsest to the most far one
	 * 
	 * @param reservationCO
	 * @return
	 */
//	public GetListOfMachinesFromNearestToMostFarResponse GetListOfMachinesFromNearestToMostFar(
//			ReservationCO reservationCO);

	/**
	 * method that confirm the reservation
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ConfirmReservationResponse confirmReservation(ReservationCO reservationCO) throws Exception;

	/**
	 * method that check the available machines at all date , and reserve them , if
	 * no reserve ealier or later temporarly
	 * 
	 * @param reservationCO
	 * @return
	 * @throws Exception
	 */
	public ValidateRecurringReservationResponse validateRecurringReservation(ReservationCO reservationCO)
			throws Exception;

	/**
	 * method that return the list of temporary reservation
	 * 
	 * @param temporaryReservationVO
	 * @return
	 * @throws Exception
	 */
	public CheckTempRecurringReservationResponse checkTempRecurringReservation(
			TemporaryReservationVO temporaryReservationVO) throws Exception;

	/**
	 * method to cancel the reservation
	 * 
	 * @param request
	 * @throws Exception
	 */
	public CancelReservationResponse cancelReservation(ReservationCO reservationCO) throws Exception;

	/**
	 * method that track the trip
	 * 
	 * @param driverRequest
	 * @throws Exception
	 */
	public UpdateReservationStatusResponse updateReservationStatus(DriverCO driverCO) throws Exception;

	/**
	 * method to rating the trip
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public RatingTripResponse ratingTrip(RateVO rateVO) throws Exception;

	/**
	 * method to logout
	 * 
	 * @param deviceVO
	 * @return
	 * @throws Exception
	 */
	public LogoutResponse logout(ClientCO clientCO) throws Exception;

	/**
	 * method to get all infos fo driver
	 * 
	 * @param driverVO
	 * @return
	 * @throws Exception
	 */
	public GetDriverInfosResponse getDriverInfos(DriverVO driverVO) throws Exception;

	/**
	 * method to get client infos
	 * 
	 * @param clientVO
	 * @return
	 * @throws Exception
	 */
	public GetClientInfosResponse getClientInfos(ClientVO clientVO) throws Exception;

	/**
	 * method to get machine infos
	 * 
	 * @param machineVO
	 * @return
	 * @throws Exception
	 */
	public GetMachineInfosResponse getMachineInfos(MachineVO machineVO) throws Exception;

	/**
	 * method to add a driver
	 * 
	 * @param driverVO
	 * @return
	 * @throws Exception
	 */
	public AddDriverResponse addDriver(DriverVO driverVO) throws Exception;

	/**
	 * meethod to add new machine
	 * 
	 * @param machineVO
	 * @return
	 * @throws Exception
	 */
	public AddMachineResponse addMachine(MachineVO machineVO) throws Exception;

	/**
	 * method to update the client infos
	 * 
	 * @param updateClientInfosRequest
	 * @return
	 */
	public UpdateClientInfosResponse updateClientInfos(ClientVO clientVO) throws Exception;

	/**
	 * method to change the password
	 * 
	 * @param clientVO
	 * @return
	 * @throws Exception
	 */
	public ChangePasswordResponse changePassword(ClientCO clientCO) throws Exception;
	
	/**
	 * method to change the profile 
	 * @param clientVO
	 * @return
	 * @throws Exception
	 */
	public ChangeProfileResponse changeProfile(ClientVO clientVO) throws Exception;

	/**
	 * method to update the machine infos
	 * 
	 * @param machineVO
	 * @return
	 * @throws Exception
	 */
	public UpdateMachineInfosResponse updateMachineInfos(MachineCO machineCO) throws Exception;

	/**
	 * method to update the driver infos
	 * 
	 * @param driverVO
	 * @return
	 * @throws Exception
	 */
	public UpdateDriverInfosResponse updateDriverInfos(DriverVO driverVO) throws Exception;

	/**
	 * method that return the list of reservations
	 * 
	 * @return
	 * @throws Exception
	 */
	public ReturnReservationsListResponse returnReservationsList(ReservationVO reservationVO) throws Exception;

	/**
	 * method return reservation details
	 * 
	 * @param reservationVO
	 * @return
	 * @throws Exception
	 */
	public ReturnReservationDetailsResponse returnReservationDetails(ReservationVO reservationVO) throws Exception;

	/**
	 * method that delete from temporary_reservation table if the client reject the
	 * reservation
	 * 
	 * @param reservationCO
	 * @return
	 * @throws Exception
	 */
	public RejectReservationResponse rejectReservation(ReservationCO reservationCO) throws Exception;

	/**
	 * method that update the working hours of drivers
	 * 
	 * @param workingHoursVO
	 * @return
	 * @throws Exception
	 */
	public UpdateDriverWorkingHoursResponse updateDriverWorkingHours(WorkingHoursVO workingHoursVO) throws Exception;

	/**
	 * method to calculate the cost of reservation
	 * 
	 * @param reservationCO
	 * @return
	 * @throws Exception
	 */
	public CostResponse getCost(ReservationCO reservationCO) throws Exception;

	/**
	 * method to add a store
	 * 
	 * @param storeVO
	 * @return
	 * @throws Exception
	 */
	public AddStoreResponse addStore(StoreVO storeVO) throws Exception;

	/**
	 * method that save the destinations of client
	 * 
	 * @param list_destinationsVO
	 * @return
	 * @throws Exception
	 */
	public AddDestinationResponse addDestination(List_destinationsVO list_destinationsVO) throws Exception;

	/**
	 * method that return the destinations of client
	 * 
	 * @param list_destinationsVO
	 * @return
	 * @throws Exception
	 */
	public GetListOfDestinaitonsResponse getListOfDestinaitons(List_destinationsVO list_destinationsVO)
			throws Exception;

	/**
	 * method that return the masked mobile number for the requested username and generate otp
	 * @param clientVO
	 * @return
	 * @throws Exception
	 */
	public ForgetPasswordResponse forgetPassword(ClientVO clientVO) throws Exception;
	
	/**
	 * method that reset the password 
	 * @param clientVO
	 * @return
	 * @throws Exception
	 */
	public ResetPasswordResponse resetPassword(ClientVO clientVO) throws Exception;
	
	/**
	 * method that return the list of devices 
	 * @param clientVO
	 * @return
	 * @throws Exception
	 */
	public GetListDevicesResponse getListDevices (ClientVO clientVO) throws Exception;
	
	/**
	 * method that unregister device
	 * @param deviceVO
	 * @return
	 * @throws Exception
	 */
	public UnregisterDeviceResponse unregisterDevice (ClientCO clientCO) throws Exception;
	
	public AuthenticateDriverResponse authenticateDriverResponse (DriverDeviceCO  driverDeviceCO) throws Exception; 
	
	public void getErrors () throws Exception;
	
	/**
	 * Method that returns Next value of sequence of a table
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public BigDecimal returnNextValOfSequence(Object objParam) throws BaseException;

	/**
	 * return Sequence of Original Record
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public BigDecimal returnRelatedSequence(Object objParam, String pkColName, BigDecimal codeRef) throws BaseException;

	/**
	 * fill User that apply the action And running Date
	 */
	public Object fillUserAndDate(OmniBaseVO omniBaseVO, Object objParam, String action) throws BaseException;

	/**
	 * update Ref Code of Table even if it's null
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public int updateRefCode(Object objParam) throws BaseException;

	/*****************************
	 * END RICHIE FOR TESTING PURPOSE ONLY
	 ************************/

	/**
	 * returnOmniCounter
	 * 
	 * @param omniCommonCO
	 * @return
	 * @throws BaseException
	 */
	public BigDecimal returnOmniCounter(OmniCommonCO omniCommonCO) throws BaseException;

	/**
	 * return Application and Channel
	 * 
	 * @param omniBaseSC
	 * @return
	 * @throws BaseException
	 */
	public List<OmniCommonCO> returnAppChannels(OmniBaseSC omniBaseSC) throws BaseException;

	/**
	 * Added by NEENA Method that returns Application Count
	 * 
	 * @param criteria
	 * @return int number of records
	 * @throws BaseException
	 */
	public int returnApplicationListCount(OmniBaseSC omniBaseSC) throws BaseException;

	/**
	 * Method that saves Application List
	 * 
	 * @param AuthenticationMatrixSC
	 * @return authenticationMatrixCO the record that saved
	 * @throws BaseException
	 */
	public List returnApplicationList(OmniBaseSC omniBaseSC) throws BaseException;

	/**
	 * check Concurrent Date Possibility for existing object
	 * 
	 * @param objParam
	 * @return
	 * @throws BaseException
	 */
	public Object checkConcurrentDate(Object objParam) throws BaseException;

	/**
	 * Method that do actions related to a page
	 * 
	 * @param object is the VO , and all actions
	 * @return int
	 * @throws BaseException
	 */
	public Object updateRecordScreen(Object obj, String action) throws BaseException;

	/**
	 * @author gilbertandary Method that saves service into designated table
	 * @throws Exception
	 * @throws BaseException
	 */
	public Object saveService(Object objToInsert) throws Exception;

	public Object updateRecordScreen(String recordActionSave, OmniBaseVO omniBaseVO, Object obj) throws BaseException;

	/**
	 * @author KhaledAlTimany
	 * @param obj
	 * @return
	 */
	public Boolean isAllowedChannelApp(OmniBaseSC omniBaseSc) throws BaseException;

	/**
	 * @author Suhail.Shoukathali
	 * @param creater
	 * @param modifier
	 * @param userId
	 * @throws BaseException
	 */
	public void applyMakerCheckerValidation(String creater, String modifier, String userId) throws BaseException;

	/**
	 * @author gilbertandary
	 * @throws DAOException
	 */
	public ArrayList<String> getVOAttributes(Object vo) throws DAOException;

	public Object insertIntoDB(Object vo) throws Exception;

	public HashMap<String, Object> returnETLCode(Object voName, String listOfIds, String codeColumnName)
			throws Exception;

	public Object selectRecord(Object vo, String... columnNames) throws BaseException;

	public OmniCommonCO returnLanguagesList(OmniBaseSC sc) throws BaseException;

	public OmniCommonCO executePWSService(OmniCommonUserSC sc) throws BaseException;

}
