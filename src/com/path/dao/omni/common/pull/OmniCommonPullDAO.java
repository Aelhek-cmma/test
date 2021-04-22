/**
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: gilbertandary
 *
 * OmniCommonPullDAO.java
 *
 * 
 */
package com.path.dao.omni.common.pull;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.ClientCO;
import com.path.dbmaps.vo.ClientVO;
import com.path.dbmaps.vo.Client_deviceVO;
import com.path.dbmaps.vo.DeviceVO;
import com.path.dbmaps.vo.DriverVO;
import com.path.dbmaps.vo.Driver_deviceVO;
import com.path.dbmaps.vo.ErrorVO;
import com.path.dbmaps.vo.List_destinationsVO;
import com.path.dbmaps.vo.MachineDriverSC;
import com.path.dbmaps.vo.MachineVO;
import com.path.dbmaps.vo.Machine_driverCO;
import com.path.dbmaps.vo.OC_APP_CHNLVO;
import com.path.dbmaps.vo.ReservationCO;
import com.path.dbmaps.vo.ReservationListVO;
import com.path.dbmaps.vo.ReservationSC;
import com.path.dbmaps.vo.ReservationVO;
import com.path.dbmaps.vo.SimVO;
import com.path.dbmaps.vo.StoreVO;
import com.path.dbmaps.vo.TemporaryReservationVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.omni.common.OmniCommonCO;
import com.path.vo.omni.common.base.OmniBaseSC;
import com.path.vo.omni.common.omniuser.OmniCommonUserSC;
import com.path.vo.omni.oadm.omniuser.OmniUserSC;
import com.path.ws.omni.vo.common.ChannelLoginRequest;

public interface OmniCommonPullDAO {

	public int returnLastRecordId() throws DAOException;

	public String returnAppCustomerStatus(OmniBaseSC criteria);

	public String returnAppCustomerName(OmniBaseSC criteria);

	public OmniCommonCO returnMappingId(OmniCommonUserSC criteria) throws DAOException;

	public OmniCommonCO returnPackageId(OmniUserSC userSC) throws DAOException;

	public OmniCommonCO returnCommonOperMappingId(OmniCommonUserSC criteria) throws DAOException;

	/**
	 * @author Muhammad.Asif Method used to return appChnlId
	 * @throws DAOException
	 */
	public BigDecimal returnAppChnlId(OmniBaseSC omniBaseSC) throws DAOException;

	/**
	 * @author Muhammad.Asif Method used to return submit action data list
	 * @throws DAOException
	 */

	public OC_APP_CHNLVO returnAppChnlVO(ChannelLoginRequest omniBaseSC) throws DAOException;

	/**
	 * @author AlaaAlHek method to return the sim from database
	 * 
	 */

	public SimVO returnSimVO(ClientCO clientCO) throws DAOException;

	/**
	 * method return the sim_id by sim serial
	 * 
	 * @param clientCO
	 * @return
	 * @throws DAOException
	 */
	public SimVO returnSimSerial(ClientCO clientCO) throws DAOException;

	/**
	 * 
	 * Method return the device from database
	 * 
	 * @param ClientRequest
	 * @throws DAOException
	 */
	public DeviceVO returnDevice(ClientCO clientCO) throws DAOException;

	/**
	 * Method return the combination of sim serial and device serial from database
	 * 
	 * @param clientSimDeviceCO
	 * @return Client_sim_device_VO
	 * @throws DAOException
	 */
	public Client_deviceVO returnCombinationUsernameDevice(ClientCO clientCO) throws DAOException;

	/**
	 * method return if the username put by the client is alraedy used or not
	 * 
	 * @param clientCO
	 * @return
	 * @throws DAOException
	 */
	public ClientVO returnUsername(ClientVO clientVO) throws DAOException;

	/**
	 * method that return the username and password from db
	 * 
	 * @param clientVO
	 * @return
	 * @throws DAOException
	 */
	public ClientVO returnUsernamePassword(ClientCO clientCO) throws DAOException;

	/**
	 * method that check if the combination of mobile_number and device exist in db
	 * 
	 * @param clientCO
	 * @return
	 * @throws DAOException
	 */
	public Client_deviceVO returnCombination(ClientCO clientCO) throws DAOException;

	/**
	 * method that return the model and the plate number of machine
	 * 
	 * @param request
	 * @return
	 * @throws DAOException
	 */
	public Machine_driverCO returnMachineDriverDetails(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that return the infos of driver from db
	 * 
	 * @param driverVO
	 * @return
	 * @throws DAOException
	 */
	public DriverVO returnDriverInfos(DriverVO driverVO) throws DAOException;

	/**
	 * method return the client infos
	 * 
	 * @param clientVO
	 * @return
	 * @throws DAOException
	 */
	public ClientVO returnClientInfos(ClientVO clientVO) throws DAOException;

	/**
	 * method return the machine infos
	 * 
	 * @param machineVO
	 * @return
	 * @throws DAOException
	 */
	public MachineVO returnMachineInfos(MachineVO machineVO) throws DAOException;

	/**
	 * method return the username of client to use in change password
	 * 
	 * @param clientVO
	 * @return
	 * @throws DAOException
	 */
	public ClientVO returnUsernamePasswordById(ClientCO clientCO) throws DAOException;

	/**
	 * method return the driver id and and in order to check if the driver exist in
	 * db or no to use in addDriver service
	 * 
	 * @param driverVO
	 * @return
	 * @throws DAOException
	 */
	public DriverVO returnDriver(DriverVO driverVO) throws DAOException;

	/**
	 * method return the machine id in order to check if the machine exist in db or
	 * no to use it in addMachine service
	 * 
	 * @param machineVO
	 * @return
	 * @throws DAOException
	 */
	public MachineVO returnMachineByPlateNumber(MachineVO machineVO) throws DAOException;

	/**
	 * method that return the nearest available machine to the client location
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public Machine_driverCO returnNearestAvailableMachine(ReservationCO reservationCO) throws DAOException;

	/**
	 * return the nearest unavailable machine
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public Machine_driverCO returnNearestUnavailableMachineTypeTrip(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that return the nearest unavailable machine if the type of reservation
	 * is machine
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public Machine_driverCO returnNearestUnavailableMachineTypeMachine(ReservationCO reservationCO) throws DAOException;

	/**
	 * method return list of machines from nearest to the most far , reservation
	 * type is trip
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public List<Machine_driverCO> returnListOfMachinesFromNearestToMostFarTrip(ReservationCO reservationCO)
			throws DAOException;

	/**
	 * method return list of machines from nearest to the most far , reservation
	 * type is trip
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public List<Machine_driverCO> returnListOfMachinesFromNearestToMostFarMachine(ReservationCO reservationCO)
			throws DAOException;

	/**
	 * method that return the available machines from db
	 * 
	 * @param machineVO
	 * @return
	 * @throws DAOException
	 */
	public List<MachineVO> returnAvailableMachines(MachineVO machineVO) throws DAOException;

	/**
	 * method that return list of reservations
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ReservationSC> returnReservationsList(ReservationVO reservationVO) throws DAOException;

	/**
	 * method that return the occurrence type of the reservation
	 * 
	 * @param reservationVO
	 * @return
	 * @throws DAOException
	 */
	public ReservationVO returnReservationOccurrenceType(ReservationVO reservationVO) throws DAOException;

	/**
	 * method return the details of one time reservation
	 * 
	 * @param reservationVO
	 * @return
	 * @throws DAOException
	 */
	public ReservationListVO returnOneTimeReservationDetails(ReservationVO reservationVO) throws DAOException;

	/**
	 * method return details of reccurring reservations
	 * 
	 * @param reservationVO
	 * @return
	 * @throws DAOException
	 */
	public List<ReservationCO> returnRecurringReservationDetails(ReservationVO reservationVO) throws DAOException;

	/**
	 * method that return the available machine in recurring reservation at each
	 * date and time
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public TemporaryReservationVO returnMaxTemporaryReservation(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that return list of temporary reservations for a a specific
	 * reservation to use in validate recurring reservation
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */

	public List<TemporaryReservationVO> returnListOfTmeporaryReservation(TemporaryReservationVO temporaryReservationVO)
			throws DAOException;

	/**
	 * method that return if the machine is reserved or no , used when we need to
	 * change the status of machine to unvailable in order to reserve another one
	 * and give the client the new one
	 * 
	 * @param machineDriverSC
	 * @return
	 * @throws DAOException
	 */
	public List<ReservationListVO> returnIfMachineDriverIsReserved(MachineDriverSC machineDriverSC) throws DAOException;

	/**
	 * method that return the details of reservation, used in update machine infos
	 * and update driver infos
	 * 
	 * @param reservationListVO
	 * @return
	 * @throws DAOException
	 */
	public ReservationCO returnReservationDetails(ReservationListVO reservationListVO) throws DAOException;

	/**
	 * method to check if the store exist or no
	 * 
	 * @param storeVO
	 * @return
	 * @throws DAOException
	 */
	public StoreVO returnStore(StoreVO storeVO) throws DAOException;

	/**
	 * method to calculate the distance of trip
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public ReservationCO returnDistance(ReservationCO reservationCO) throws DAOException;

	/**
	 * return the saved destinations of client
	 * 
	 * @param list_destinationsVO
	 * @return
	 * @throws DAOException
	 */
	public List<List_destinationsVO> returnListOfDestination(List_destinationsVO list_destinationsVO)
			throws DAOException;

	/**
	 * method return list of available machines from nearest to the most far
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public List<Machine_driverCO> returnListAvailableMachinesNearestMostFar(ReservationCO reservationCO)
			throws DAOException;

	/**
	 * method that return list of unavailable machines form nearest to the most far
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public List<Machine_driverCO> returnListUnavailableMachines (ReservationCO reservationCO) throws DAOException;
	
	/**
	 *  method return list of devices for a specific username
	 * @param clientVO
	 * @return
	 * @throws DAOException
	 */
	public List<ClientCO> returnListDevices (ClientVO clientVO) throws DAOException;
	/**
	 * method that return the last 3 reservations of the client, in order to check
	 * if the reservations are done or not yet
	 * 
	 * @param reservationCO
	 * @return
	 * @throws DAOException
	 */
	public List<ReservationCO> returnLast3Reservations(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that return the mobile number from a specific username
	 * @param clientVO
	 * @return
	 * @throws DAOException
	 */
	public ClientVO returnMobileNumber(ClientVO clientVO) throws DAOException;
	
	public int returnUsernameExists(ClientVO clientVO) throws DAOException;
	
	/**
	 * method that return the errors and language from db
	 * @param errorVO
	 * @return
	 * @throws DAOException
	 */
	public List<ErrorVO> returnLanguageError(ErrorVO errorVO) throws DAOException ;
	
	/**
	 * method that return the gender of the user
	 * @param clientCO
	 * @return
	 * @throws DAOException
	 */
	public ClientCO returnGender(ClientCO clientCO) throws DAOException;
	
	/**
	 * method that return the list of last login and devices
	 * @param clientCO
	 * @return
	 * @throws DAOException
	 */
	public ClientCO returnLastLogin(ClientCO clientCO) throws DAOException;
	
	public Driver_deviceVO
}
