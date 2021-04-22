package com.path.ws.omni.rest.client.common;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.path.ws.omni.vo.common.AddDestinationRequest;
import com.path.ws.omni.vo.common.AddDestinationResponse;
import com.path.ws.omni.vo.common.AddDriverRequest;
import com.path.ws.omni.vo.common.AddDriverResponse;
import com.path.ws.omni.vo.common.AddMachineRequest;
import com.path.ws.omni.vo.common.AddMachineResponse;
import com.path.ws.omni.vo.common.AddStoreRequest;
import com.path.ws.omni.vo.common.AddStoreResponse;
import com.path.ws.omni.vo.common.AuthenticateDriverRequest;
import com.path.ws.omni.vo.common.AuthenticateDriverResponse;
import com.path.ws.omni.vo.common.AuthenticateRequest;
import com.path.ws.omni.vo.common.AuthenticateResponse;
import com.path.ws.omni.vo.common.CancelReservationRequest;
import com.path.ws.omni.vo.common.CancelReservationResponse;
import com.path.ws.omni.vo.common.ChangePasswordRequest;
import com.path.ws.omni.vo.common.ChangePasswordResponse;
import com.path.ws.omni.vo.common.ChangeProfileRequest;
import com.path.ws.omni.vo.common.ChangeProfileResponse;
import com.path.ws.omni.vo.common.ChannelLoginRequest;
import com.path.ws.omni.vo.common.CheckTempRecurringReservationRequest;
import com.path.ws.omni.vo.common.CheckTempRecurringReservationResponse;
import com.path.ws.omni.vo.common.CheckUsernameRequest;
import com.path.ws.omni.vo.common.CheckUsernameResponse;
import com.path.ws.omni.vo.common.ConfirmReservationRequest;
import com.path.ws.omni.vo.common.ConfirmReservationResponse;
import com.path.ws.omni.vo.common.CreateReservationRequest;
import com.path.ws.omni.vo.common.CreateReservationResponse;
import com.path.ws.omni.vo.common.ForgetPasswordRequest;
import com.path.ws.omni.vo.common.ForgetPasswordResponse;
import com.path.ws.omni.vo.common.GenerateOTPRequest;
import com.path.ws.omni.vo.common.GenerateOTPResponse;
import com.path.ws.omni.vo.common.GetClientInfosRequest;
import com.path.ws.omni.vo.common.GetClientInfosResponse;
import com.path.ws.omni.vo.common.GetDriverInfosRequest;
import com.path.ws.omni.vo.common.GetDriverInfosResponse;
import com.path.ws.omni.vo.common.GetListDevicesRequest;
import com.path.ws.omni.vo.common.GetListDevicesResponse;
import com.path.ws.omni.vo.common.GetListOfDestinaitonsResponse;
import com.path.ws.omni.vo.common.GetListOfDestinationsRequest;
import com.path.ws.omni.vo.common.GetListOfMachinesRequest;
import com.path.ws.omni.vo.common.GetListOfMachinesResponse;
import com.path.ws.omni.vo.common.GetMachineInfosRequest;
import com.path.ws.omni.vo.common.GetMachineInfosResponse;
import com.path.ws.omni.vo.common.HandShakeRequest;
import com.path.ws.omni.vo.common.HandShakeResponse;
import com.path.ws.omni.vo.common.LoginRequest;
import com.path.ws.omni.vo.common.LoginResponse;
import com.path.ws.omni.vo.common.LogoutRequest;
import com.path.ws.omni.vo.common.LogoutResponse;
import com.path.ws.omni.vo.common.RateRequest;
import com.path.ws.omni.vo.common.RatingTripResponse;
import com.path.ws.omni.vo.common.RegisterUserRequest;
import com.path.ws.omni.vo.common.RegisterUserResponse;
import com.path.ws.omni.vo.common.RejectReservationRequest;
import com.path.ws.omni.vo.common.RejectReservationResponse;
import com.path.ws.omni.vo.common.RememberDeviceRequest;
import com.path.ws.omni.vo.common.RememberDeviceResponse;
import com.path.ws.omni.vo.common.ResetPasswordRequest;
import com.path.ws.omni.vo.common.ResetPasswordResponse;
import com.path.ws.omni.vo.common.ReturnReservationDetailsRequest;
import com.path.ws.omni.vo.common.ReturnReservationDetailsResponse;
import com.path.ws.omni.vo.common.ReturnReservationsListRequest;
import com.path.ws.omni.vo.common.ReturnReservationsListResponse;
import com.path.ws.omni.vo.common.UnregisterDeviceRequest;
import com.path.ws.omni.vo.common.UnregisterDeviceResponse;
import com.path.ws.omni.vo.common.UpdateClientInfosRequest;
import com.path.ws.omni.vo.common.UpdateClientInfosResponse;
import com.path.ws.omni.vo.common.UpdateDriverInfosRequest;
import com.path.ws.omni.vo.common.UpdateDriverInfosResponse;
import com.path.ws.omni.vo.common.UpdateDriverWorkingHoursRequest;
import com.path.ws.omni.vo.common.UpdateDriverWorkingHoursResponse;
import com.path.ws.omni.vo.common.UpdateMachineInfosRequest;
import com.path.ws.omni.vo.common.UpdateMachineInfosResponse;
import com.path.ws.omni.vo.common.UpdateReservationStatusRequest;
import com.path.ws.omni.vo.common.UpdateReservationStatusResponse;
import com.path.ws.omni.vo.common.ValidateOTPRequest;
import com.path.ws.omni.vo.common.ValidateOTPResponse;
import com.path.ws.omni.vo.common.ValidateRecurringReservationRequest;
import com.path.ws.omni.vo.common.ValidateRecurringReservationResponse;

@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public interface OmniCommonServices {

	@POST
	@Path("/authenticateUser/")
	public boolean authenticateUser_service(ChannelLoginRequest request);

	@POST
	@Path("/handShake/")
	public HandShakeResponse handShake_service(HandShakeRequest handShakeRequest);

	@POST
	@Path("/authenticate/")
	public AuthenticateResponse authenticate_service(AuthenticateRequest authenticateRequest);

	@POST
	@Path("/generateOTP/")
	public GenerateOTPResponse generateOTP_service(GenerateOTPRequest registrationRequest);

	@POST
	@Path("/checkUsername/")
	public CheckUsernameResponse checkUsername_service(CheckUsernameRequest checkUsernameRequest);

	@POST
	@Path("/registerUser/")
	public RegisterUserResponse registerUser_service(RegisterUserRequest registerUserRequest);

	@POST
	@Path("/validateOTP/")
	public ValidateOTPResponse validateOTP_service(ValidateOTPRequest validationRequest);

	/**
	 * login service if the client want to login from another device
	 * 
	 * @param logoutRequest
	 * @return
	 */
	@POST
	@Path("/login/")
	public LoginResponse login_service(LoginRequest loginRequest);

	/**
	 * service that reserve the nearest available machine to the client if the
	 * reservation is immediate
	 * 
	 * @param createReservationRequest
	 * @return
	 */
	@POST
	@Path("/createReservation/")
	public CreateReservationResponse createReservation_service(CreateReservationRequest createReservationRequest);

	/**
	 * service that return the list of available machines from the nearest to the
	 * most far one
	 * 
	 * @param availableMachinesNearestMostFarRequest
	 * @return
	 */
	@POST
	@Path("/getListOfMachinesNearestMostFar/")
	public GetListOfMachinesResponse getListOfMachinesNearestMostFar_service(
			GetListOfMachinesRequest availableMachinesNearestMostFarRequest);

	/**
	 * service that return list of machines from the nearest to the most far one
	 * 
	 * @param nearestToMostFarRequest
	 * @return
	 */
//	@POST
//	@Path("/GetListOfMachinesFromNearestToMostFar/")
//	public GetListOfMachinesFromNearestToMostFarResponse GetListOfMachinesFromNearestToMostFar_service(
//			GetListOfMachinesFromNearestToMostFarRequest nearestToMostFarRequest);

	/**
	 * service that reserve a machine and return to the client the model and plate
	 * number of machine and the name and mobile number of driver
	 * 
	 * @param request return list
	 * @return
	 */
	@POST
	@Path("/confirmReservation/")
	public ConfirmReservationResponse ConfirmReservation_service(ConfirmReservationRequest createReservationRequest);

	/**
	 * service to cancel the reservation
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("/cancelReservation/")
	public CancelReservationResponse cancelReservation_service(CancelReservationRequest cancelReservationRequest);

	/**
	 * service to track the reservation status , the driver change the status
	 * 
	 * @param driverRequest
	 * @return
	 */
	@POST
	@Path("/updateReservationStatus/")
	public UpdateReservationStatusResponse updateReservationStatus_service(
			UpdateReservationStatusRequest driverRequest);

	/**
	 * service to rating the trip
	 * 
	 * @param rateRequest
	 * @return
	 */
	@POST
	@Path("/rating/")
	public RatingTripResponse ratingTrip_service(RateRequest rateRequest);

	/**
	 * service to logout
	 * 
	 * @param logoutRequest
	 * @return
	 */
	@POST
	@Path("/logout/")
	public LogoutResponse logout_service(LogoutRequest logoutRequest);

	/**
	 * service that save the username and password and rememeber the device
	 * 
	 * @param rememberDeviceRequest
	 * @return
	 */
	@POST
	@Path("/rememberDevice/")
	public RememberDeviceResponse rememberDevice_service(RememberDeviceRequest rememberDeviceRequest);

	/**
	 * service to get all infos of driver
	 * 
	 * @param getDriverInfosRequest
	 * @return
	 */
	@POST
	@Path("/getDriverInfos/")
	public GetDriverInfosResponse getDriverInfos_service(GetDriverInfosRequest getDriverInfosRequest);

	/**
	 * service to get client infos
	 * 
	 * @param getDriverInfosRequest
	 * @return
	 */
	@POST
	@Path("/getClientInfos/")
	public GetClientInfosResponse getClientInfos_service(GetClientInfosRequest getClientInfosRequest);

	/**
	 * service to get machine infos
	 * 
	 * @param getMachineInfosRequest
	 * @return
	 */
	@POST
	@Path("/getMachineInfos/")
	public GetMachineInfosResponse getMachineInfos_service(GetMachineInfosRequest getMachineInfosRequest);

	/**
	 * service to add driver
	 * 
	 * @param addDriverRequest
	 * @return
	 */
	@POST
	@Path("/addDriver/")
	public AddDriverResponse addDriver_service(AddDriverRequest addDriverRequest);

	/**
	 * service to add new machine
	 * 
	 * @param addMachineRequest
	 * @return
	 */
	@POST
	@Path("/addMachine/")
	public AddMachineResponse addMachine_service(AddMachineRequest addMachineRequest);

	/**
	 * service to update the client infos
	 * 
	 * @param updateClientInfosRequest
	 * @return
	 */
	@POST
	@Path("/updateClientInfos/")
	public UpdateClientInfosResponse updateClientInfos_service(UpdateClientInfosRequest updateClientInfosRequest);

	/**
	 * service to change the password
	 * 
	 * @param changePasswordRequest
	 * @return
	 */
	@POST
	@Path("/changePassword/")
	public ChangePasswordResponse changePassword_service(ChangePasswordRequest changePasswordRequest);

	/**
	 * service that change the profile of client
	 * 
	 * @param changeProfileRequest
	 * @return
	 */
	@POST
	@Path("/changeProfile/")
	public ChangeProfileResponse changeProfile_service(ChangeProfileRequest changeProfileRequest);

	/**
	 * service to update the machine infos
	 * 
	 * @param updateMachineInfosRequest
	 * @return
	 */
	@POST
	@Path("/updateMachineInfos/")
	public UpdateMachineInfosResponse updateMachineInfos_service(UpdateMachineInfosRequest updateMachineInfosRequest);

	/**
	 * service to update the driver infos
	 * 
	 * @param updateDriverInfosRequest
	 * @return
	 */
	@POST
	@Path("/updateDriverInfos/")
	public UpdateDriverInfosResponse updateDriverInfos_service(UpdateDriverInfosRequest updateDriverInfosRequest);

	/**
	 * service to get the history of the client
	 * 
	 * @param reservationListRequest
	 * @return
	 */
	@POST
	@Path("/returnReservationsList/")
	public ReturnReservationsListResponse returnReservationsList_service(
			ReturnReservationsListRequest reservationListRequest);

	/**
	 * service return the details for reservation
	 * 
	 * @param returnReservationDetailsRequest
	 * @return
	 */
	@POST
	@Path("/returnReservationDetails/")
	public ReturnReservationDetailsResponse returnReservationDetails_service(
			ReturnReservationDetailsRequest returnReservationDetailsRequest);

	/**
	 * service that validate if we have available machines at all date requested
	 * 
	 * @param validateRecurringReservationRequest
	 * @return
	 */
	@POST
	@Path("/validateRecurringReservation/")
	public ValidateRecurringReservationResponse validateRecurringReservationResponse_service(
			ValidateRecurringReservationRequest validateRecurringReservationRequest);

	/**
	 * service that return the list of temporary reservations
	 * 
	 * @param checkTempRecurringReservationRequest
	 * @return
	 */
	@POST
	@Path("/chechTempRecurringReservation/")
	public CheckTempRecurringReservationResponse checkTempRecurringReservation_service(
			CheckTempRecurringReservationRequest checkTempRecurringReservationRequest);

	/**
	 * if the client reject the reservation , this service delete the reservation
	 * from temporary_reservation table
	 * 
	 * @param rejectReservationRequest
	 * @return
	 */
	@POST
	@Path("/rejectReservation/")
	public RejectReservationResponse rejectReservation_service(RejectReservationRequest rejectReservationRequest);

	/**
	 * service to save the working hours for the drivers
	 * 
	 * @param driverWorkingHoursRequest
	 * @return
	 */
	@POST
	@Path("/updateDriverWorkingHours/")
	public UpdateDriverWorkingHoursResponse updateDriverWorkingHours_service(
			UpdateDriverWorkingHoursRequest driverWorkingHoursRequest);

	/**
	 * service to add store
	 * 
	 * @param addStoreRequest
	 * @return
	 */
	@POST
	@Path("/addStore/")
	public AddStoreResponse addStore_service(AddStoreRequest addStoreRequest);

	/**
	 * service to add destination
	 * 
	 * @param addDestinationRequest
	 * @return
	 */
	@POST
	@Path("/addDestination/")
	public AddDestinationResponse addDestination_service(AddDestinationRequest addDestinationRequest);

	/**
	 * service that return the saved destinations of client
	 * 
	 * @param listOfDestinationsRequest
	 * @return
	 */
	@POST
	@Path("returnlistOfDestination")
	public GetListOfDestinaitonsResponse getListOfDestinaitons_service(
			GetListOfDestinationsRequest listOfDestinationsRequest);

	/**
	 * service that reset the password
	 * 
	 * @param forgetPasswordRequest
	 * @return
	 */
	@POST
	@Path("/forgetPassword/")
	public ForgetPasswordResponse forgetPassword_service(ForgetPasswordRequest forgetPasswordRequest);

	/**
	 * service that reset the password
	 * 
	 * @param resetPasswordRequest
	 * @return
	 */
	@POST
	@Path("/resetPassword/")
	public ResetPasswordResponse resetPassword_service(ResetPasswordRequest resetPasswordRequest);

	/**
	 * service that return the list of devices that registred for a username
	 * 
	 * @param getListDeviceRequest
	 * @return
	 */
	@POST
	@Path("/GetListDevices/")
	public GetListDevicesResponse getListDevices_service(GetListDevicesRequest getListDeviceRequest);

	/**
	 * service that unregister a device
	 * 
	 * @param unregisterDeviceRequest
	 * @return
	 */
	@POST
	@Path("/UnregisterDevice/")
	public UnregisterDeviceResponse unregitserDevice_service(UnregisterDeviceRequest unregisterDeviceRequest);

//	@POST
//	@Path("/deviceTest/")
//	public List<DeviceVO> getDevicesTest ();
//
//	
	@POST
	@Path("/authenticateDriver/")
	public AuthenticateDriverResponse authenticateDriver_service (AuthenticateDriverRequest authenticateDriverRequest);
}
