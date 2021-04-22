package com.path.ws.omni.rest.services.common.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.path.bo.omni.common.ChannelLoginBO;
import com.path.bo.omni.common.OmniCommonBO;
import com.path.bo.omni.common.pull.OmniCommonPullBO;
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
import com.path.lib.common.base.OmniBaseServices;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.vo.omni.oadm.omniuser.OmniUserSC;
import com.path.ws.omni.rest.client.common.OmniCommonServices;
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
import com.path.ws.omni.vo.common.DriverDeviceCO;
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
// @Monitor
//OmniCommonWebServices.xml
public class OmniCommonServicesImpl extends OmniBaseServices implements OmniCommonServices {

	private ChannelLoginBO channelLoginBO;
	private OmniCommonPullBO omniCommonPullBO;
	private OmniCommonBO omniCommonBO;
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public void setOmniCommonBO(OmniCommonBO omniCommonBO) {
		this.omniCommonBO = omniCommonBO;
	}

	public void setOmniCommonPullBO(OmniCommonPullBO omniCommonPullBO) {
		this.omniCommonPullBO = omniCommonPullBO;
	}

	public void setChannelLoginBO(ChannelLoginBO channelLoginBO) {
		this.channelLoginBO = channelLoginBO;
	}

	public boolean authenticateUser_service(ChannelLoginRequest request) {

		OmniUserSC omniUserSC = new OmniUserSC();
		boolean response = false;
		try {
			response = channelLoginBO.authenticateUser(request);
			PathPropertyUtil.copyProperties(request, omniUserSC);

			System.out.println(response);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return response;
	}

	/**
	 * handShake service for exchanging the keys
	 */
//done
	public HandShakeResponse handShake_service(HandShakeRequest handShakeRequest) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		java.util.Date d = new java.util.Date();
		String now = format.format(d);
		try {
			log.info("debut service" + now);
			HandShakeResponse response = omniCommonBO.handShake(handShakeRequest);
			log.info("fin service" + now);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	/**
	 * authenticate service that check if the combination of sim serial and device
	 * serial exist if not exist put in hashMap of frontEndPublicKey key , and
	 * values of sim id device id and backEnd keys
	 */
	// done
	public AuthenticateResponse authenticate_service(AuthenticateRequest authenticateRequest) {

		AuthenticateResponse response;

		try {
			ClientCO clientCO = new ClientCO();
			PathPropertyUtil.copyProperties(authenticateRequest, clientCO);
			response = omniCommonBO.authenticate(clientCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	/**
	 * 
	 */
	@Override
	public GenerateOTPResponse generateOTP_service(GenerateOTPRequest generateOTPRequest) {
		GenerateOTPResponse response;
		SimVO simVO = new SimVO();
		try {

			PathPropertyUtil.copyProperties(generateOTPRequest, simVO);
			response = omniCommonBO.generateOTP(simVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override // done
	public ValidateOTPResponse validateOTP_service(ValidateOTPRequest validationRequest) {
		ValidateOTPResponse response;
		try {
			response = omniCommonBO.validateOTP(validationRequest);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public CheckUsernameResponse checkUsername_service(CheckUsernameRequest checkUsernameRequest) {
		CheckUsernameResponse response = new CheckUsernameResponse();
		ClientVO clientVO = new ClientVO();
		try {
			log.info("debut service " + format.format(new java.util.Date()));

			PathPropertyUtil.copyProperties(checkUsernameRequest, clientVO);
			response = omniCommonBO.checkUsername(clientVO);
			log.info("fin service" + format.format(new java.util.Date()));

			return response;

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public RegisterUserResponse registerUser_service(RegisterUserRequest registerUserRequest) {

		RegisterUserResponse response;
		ClientCO clientCO = new ClientCO();
		try {
			PathPropertyUtil.copyProperties(registerUserRequest, clientCO);
			response = omniCommonBO.registerUser(clientCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	/*
	 * @Override // pending public List<MachineVO>
	 * availableMachines_service(ClientRequest request) { List<MachineVO>
	 * machineList = new ArrayList<MachineVO>(); List<MachineVO> availableMachine =
	 * new ArrayList<MachineVO>(); try { Date date = request.getDate();
	 * System.out.println(date); // double latitude =
	 * request.getLocation().getLatitude(); // double longitude =
	 * request.getLocation().getLongitude(); machineList =
	 * omniCommonBO.returnListOfMachine(request); return machineList; } catch
	 * (Exception e) { System.out.println(e.getMessage()); return null; } }
	 */

	@Override // pending
	public ConfirmReservationResponse ConfirmReservation_service(ConfirmReservationRequest createReservationRequest) {
		ConfirmReservationResponse response = null;
		ReservationCO reservationCO = new ReservationCO();
		try {
			PathPropertyUtil.copyProperties(createReservationRequest, reservationCO);
			response = omniCommonBO.confirmReservation(reservationCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public GetListOfMachinesResponse getListOfMachinesNearestMostFar_service(
			GetListOfMachinesRequest listOfMachinesRequest) {
		GetListOfMachinesResponse response;
		ReservationCO reservationCO = new ReservationCO();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		try {
			log.info("debut service" + format.format(new java.util.Date()));
			PathPropertyUtil.copyProperties(listOfMachinesRequest, reservationCO);
			response = omniCommonBO.getListOfMachinesNearestMostFar(reservationCO);
			log.info("fin service" + format.format(new java.util.Date()));
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override // pending
	public CancelReservationResponse cancelReservation_service(CancelReservationRequest cancelReservationRequest) {
		CancelReservationResponse response;
		ReservationCO reservationCO = new ReservationCO();
		try {
			PathPropertyUtil.copyProperties(cancelReservationRequest, reservationCO);
			response = omniCommonBO.cancelReservation(reservationCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override // done
	public UpdateReservationStatusResponse updateReservationStatus_service(
			UpdateReservationStatusRequest reservationStatusRequest) {
		UpdateReservationStatusResponse response;
		try {
			DriverCO driverCO = new DriverCO();
			PathPropertyUtil.copyProperties(reservationStatusRequest, driverCO);
			response = omniCommonBO.updateReservationStatus(driverCO);
			return response;

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override // done
	public RatingTripResponse ratingTrip_service(RateRequest rateRequest) {
		RatingTripResponse response;
		RateVO rateVO = new RateVO();
		try {

			PathPropertyUtil.copyProperties(rateRequest, rateVO);
			response = omniCommonBO.ratingTrip(rateVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public LogoutResponse logout_service(LogoutRequest logoutRequest) {
		LogoutResponse response = new LogoutResponse();
		ClientCO clientCO = new ClientCO();
		try {
			PathPropertyUtil.copyProperties(logoutRequest, clientCO);
			response = omniCommonBO.logout(clientCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public LoginResponse login_service(LoginRequest loginRequest) {
		LoginResponse response = new LoginResponse();
		ClientCO clientCO = new ClientCO();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		java.util.Date d = new java.util.Date();
		String now = format.format(d);

		try {
			log.info("debut login service" + now);
			PathPropertyUtil.copyProperties(loginRequest, clientCO);
			response = omniCommonBO.login(clientCO);
			java.util.Date d1 = new java.util.Date();
			log.info("fin login service" + format.format(d1));
			return response;

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public RememberDeviceResponse rememberDevice_service(RememberDeviceRequest rememberDeviceRequest) {
		RememberDeviceResponse response = new RememberDeviceResponse();
		ClientCO clientCO = new ClientCO();
		try {
			PathPropertyUtil.copyProperties(rememberDeviceRequest, clientCO);
			response = omniCommonBO.rememberDevice(clientCO);

			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public AddDriverResponse addDriver_service(AddDriverRequest addDriverRequest) {
		AddDriverResponse response = new AddDriverResponse();
		DriverVO driverVO = new DriverVO();
		try {
			PathPropertyUtil.copyProperties(addDriverRequest, driverVO);
			response = omniCommonBO.addDriver(driverVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public AddMachineResponse addMachine_service(AddMachineRequest addMachineRequest) {
		AddMachineResponse response = new AddMachineResponse();
		MachineVO machineVO = new MachineVO();
		try {
			PathPropertyUtil.copyProperties(addMachineRequest, machineVO);
			response = omniCommonBO.addMachine(machineVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public GetDriverInfosResponse getDriverInfos_service(GetDriverInfosRequest getDriverInfosRequest) {
		GetDriverInfosResponse response = new GetDriverInfosResponse();
		DriverVO driverVO = new DriverVO();
		try {
			PathPropertyUtil.copyProperties(getDriverInfosRequest, driverVO);
			response = omniCommonBO.getDriverInfos(driverVO);
			return response;

		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateClientInfosResponse updateClientInfos_service(UpdateClientInfosRequest updateClientInfosRequest) {
		UpdateClientInfosResponse response = new UpdateClientInfosResponse();
		ClientVO clientVO = new ClientVO();
		try {
			PathPropertyUtil.copyProperties(updateClientInfosRequest, clientVO);
			response = omniCommonBO.updateClientInfos(clientVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ChangePasswordResponse changePassword_service(ChangePasswordRequest changePasswordRequest) {
		ChangePasswordResponse response = new ChangePasswordResponse();
		ClientCO clientCO = new ClientCO();
		try {
			PathPropertyUtil.copyProperties(changePasswordRequest, clientCO);
			response = omniCommonBO.changePassword(clientCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public GetMachineInfosResponse getMachineInfos_service(GetMachineInfosRequest getMachineInfosRequest) {
		GetMachineInfosResponse response = new GetMachineInfosResponse();
		MachineVO machineVO = new MachineVO();
		try {
			PathPropertyUtil.copyProperties(getMachineInfosRequest, machineVO);
			response = omniCommonBO.getMachineInfos(machineVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateMachineInfosResponse updateMachineInfos_service(UpdateMachineInfosRequest updateMachineInfosRequest) {
		UpdateMachineInfosResponse response = new UpdateMachineInfosResponse();
		MachineCO machineCO = new MachineCO();
		try {
			PathPropertyUtil.copyProperties(updateMachineInfosRequest, machineCO);
			response = omniCommonBO.updateMachineInfos(machineCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateDriverInfosResponse updateDriverInfos_service(UpdateDriverInfosRequest updateDriverInfosRequest) {
		UpdateDriverInfosResponse response = new UpdateDriverInfosResponse();
		DriverVO driverVO = new DriverVO();
		try {
			PathPropertyUtil.copyProperties(updateDriverInfosRequest, driverVO);
			response = omniCommonBO.updateDriverInfos(driverVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ReturnReservationsListResponse returnReservationsList_service(
			ReturnReservationsListRequest returnReservationsListRequest) {
		ReturnReservationsListResponse response = new ReturnReservationsListResponse();
		ReservationVO reservationVO = new ReservationVO();
		try {
			PathPropertyUtil.copyProperties(returnReservationsListRequest, reservationVO);
			response = omniCommonBO.returnReservationsList(reservationVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ReturnReservationDetailsResponse returnReservationDetails_service(
			ReturnReservationDetailsRequest returnReservationDetailsRequest) {
		ReturnReservationDetailsResponse response = new ReturnReservationDetailsResponse();
		ReservationVO reservationVO = new ReservationVO();
		try {
			PathPropertyUtil.copyProperties(returnReservationDetailsRequest, reservationVO);
			response = omniCommonBO.returnReservationDetails(reservationVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public ValidateRecurringReservationResponse validateRecurringReservationResponse_service(
			ValidateRecurringReservationRequest validateRecurringReservationRequest) {
		ValidateRecurringReservationResponse response = new ValidateRecurringReservationResponse();
		ReservationCO reservationCO = new ReservationCO();
		try {
			PathPropertyUtil.copyProperties(validateRecurringReservationRequest, reservationCO);
			response = omniCommonBO.validateRecurringReservation(reservationCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public CheckTempRecurringReservationResponse checkTempRecurringReservation_service(
			CheckTempRecurringReservationRequest checkTempRecurringReservationRequest) {
		CheckTempRecurringReservationResponse response = new CheckTempRecurringReservationResponse();
		TemporaryReservationVO temporaryReservationVO = new TemporaryReservationVO();
		try {
			PathPropertyUtil.copyProperties(checkTempRecurringReservationRequest, temporaryReservationVO);
			response = omniCommonBO.checkTempRecurringReservation(temporaryReservationVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}

	}

	@Override
	public RejectReservationResponse rejectReservation_service(RejectReservationRequest rejectReservationRequest) {
		RejectReservationResponse response = new RejectReservationResponse();
		ReservationCO reservationCO = new ReservationCO();
		try {
			PathPropertyUtil.copyProperties(rejectReservationRequest, reservationCO);
			response = omniCommonBO.rejectReservation(reservationCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UpdateDriverWorkingHoursResponse updateDriverWorkingHours_service(
			UpdateDriverWorkingHoursRequest driverWorkingHoursRequest) {
		UpdateDriverWorkingHoursResponse response = new UpdateDriverWorkingHoursResponse();
		WorkingHoursVO workingHoursVO = new WorkingHoursVO();
		try {
			PathPropertyUtil.copyProperties(driverWorkingHoursRequest, workingHoursVO);
			response = omniCommonBO.updateDriverWorkingHours(workingHoursVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public AddStoreResponse addStore_service(AddStoreRequest addStoreRequest) {
		AddStoreResponse response = new AddStoreResponse();
		StoreVO storeVO = new StoreVO();
		try {
			PathPropertyUtil.copyProperties(addStoreRequest, storeVO);
			response = omniCommonBO.addStore(storeVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public GetClientInfosResponse getClientInfos_service(GetClientInfosRequest getDriverInfosRequest) {
		GetClientInfosResponse response;
		ClientVO clientVO = new ClientVO();
		try {
			PathPropertyUtil.copyProperties(getDriverInfosRequest, clientVO);
			response = omniCommonBO.getClientInfos(clientVO);
			return response;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public CreateReservationResponse createReservation_service(CreateReservationRequest createReservationRequest) {
		CreateReservationResponse response;
		ReservationCO reservationCO = new ReservationCO();
		try {
			PathPropertyUtil.copyProperties(createReservationRequest, reservationCO);
			response = omniCommonBO.createReservation(reservationCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

//	@Override
//	public GetListOfMachinesFromNearestToMostFarResponse GetListOfMachinesFromNearestToMostFar_service(
//			GetListOfMachinesFromNearestToMostFarRequest nearestToMostFarRequest) {
//		GetListOfMachinesFromNearestToMostFarResponse response;
//		ReservationCO reservationCO = new ReservationCO();
//		try {
//
//			PathPropertyUtil.copyProperties(nearestToMostFarRequest, reservationCO);
//			response = omniCommonBO.GetListOfMachinesFromNearestToMostFar(reservationCO);
//			return response;
//		} catch (Exception e) {
//			log.info(e.getMessage());
//			return null;
//		}
//	}

	@Override
	public AddDestinationResponse addDestination_service(AddDestinationRequest addDestinationRequest) {
		AddDestinationResponse response = new AddDestinationResponse();
		List_destinationsVO list_destinationsVO = new List_destinationsVO();
		try {
			PathPropertyUtil.copyProperties(addDestinationRequest, list_destinationsVO);
			response = omniCommonBO.addDestination(list_destinationsVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public GetListOfDestinaitonsResponse getListOfDestinaitons_service(
			GetListOfDestinationsRequest listOfDestinationsRequest) {
		GetListOfDestinaitonsResponse response = new GetListOfDestinaitonsResponse();
		List_destinationsVO list_destinationsVO = new List_destinationsVO();
		try {
			PathPropertyUtil.copyProperties(listOfDestinationsRequest, list_destinationsVO);
			response = omniCommonBO.getListOfDestinaitons(list_destinationsVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ChangeProfileResponse changeProfile_service(ChangeProfileRequest changeProfileRequest) {
		ChangeProfileResponse response = new ChangeProfileResponse();
		ClientVO clientVO = new ClientVO();
		try {
			PathPropertyUtil.copyProperties(changeProfileRequest, clientVO);
			response = omniCommonBO.changeProfile(clientVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ForgetPasswordResponse forgetPassword_service(ForgetPasswordRequest forgetPasswordRequest) {
		ForgetPasswordResponse response;
		ClientVO clientVO = new ClientVO();
		try {
			PathPropertyUtil.copyProperties(forgetPasswordRequest, clientVO);
			response = omniCommonBO.forgetPassword(clientVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public ResetPasswordResponse resetPassword_service(ResetPasswordRequest resetPasswordRequest) {
		ResetPasswordResponse response;
		ClientVO clientVO = new ClientVO();
		try {
			PathPropertyUtil.copyProperties(resetPasswordRequest, clientVO);
			response = omniCommonBO.resetPassword(clientVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public GetListDevicesResponse getListDevices_service(GetListDevicesRequest getListDeviceRequest) {
		GetListDevicesResponse response;
		ClientVO clientVO = new ClientVO();
		try {
			PathPropertyUtil.copyProperties(getListDeviceRequest, clientVO);
			response = omniCommonBO.getListDevices(clientVO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public UnregisterDeviceResponse unregitserDevice_service(UnregisterDeviceRequest unregisterDeviceRequest) {
		UnregisterDeviceResponse response;
		ClientCO clientCO = new ClientCO();
		try {
			PathPropertyUtil.copyProperties(unregisterDeviceRequest, clientCO);
			response = omniCommonBO.unregisterDevice(clientCO);
			return response;
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
//	@PersistenceContext
//	EntityManager em;
//
//	@Override
//	public List<DeviceVO> getDevicesTest() {
//		return em.createNamedQuery("asd", DeviceVO.class).getResultList();
//	}

	@Override
	public AuthenticateDriverResponse authenticateDriver_service(AuthenticateDriverRequest authenticateDriverRequest) {
		AuthenticateDriverResponse response;
		DriverDeviceCO driverDeviceCO = new DriverDeviceCO();
		try {PathPropertyUtil.copyProperties(authenticateDriverRequest, driverDeviceCO);
		response = omniCommonBO.authenticateDriver(driverDeviceCO);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	
		
	}

}
