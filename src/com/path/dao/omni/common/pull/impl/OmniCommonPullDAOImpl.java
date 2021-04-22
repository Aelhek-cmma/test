/**
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: gilbertandary
 *
 * OmniCommonPullDAOImpl.java
 *
 * 
 */
package com.path.dao.omni.common.pull.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.omni.common.base.OmniBaseDAO;
import com.path.dao.omni.common.pull.OmniCommonPullDAO;
import com.path.dbmaps.vo.ClientCO;
import com.path.dbmaps.vo.ClientVO;
import com.path.dbmaps.vo.Client_deviceVO;
import com.path.dbmaps.vo.DeviceVO;
import com.path.dbmaps.vo.DriverVO;
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

public class OmniCommonPullDAOImpl extends OmniBaseDAO implements OmniCommonPullDAO {

	public int returnLastRecordId() throws DAOException {
		return (int) getSqlMap().queryForObject("omniCommonPullMapper.returnLastRecordId", null);
	}

	public String returnAppCustomerStatus(OmniBaseSC criteria) {
		String result = "";
		try {
			result = (String) getSqlMap().queryForObject("omniCommonPullMapper.returnAppCustomerStatus", criteria);
		} catch (DAOException e) {
			// pathlog.error(e,"Message " + e.getMessage());
		}
		return result;
	}

	public String returnAppCustomerName(OmniBaseSC criteria) {
		String result = "";
		try {
			result = (String) getSqlMap().queryForObject("omniCommonPullMapper.returnAppCustomerName", criteria);
		} catch (DAOException e) {
			// pathlog.error(e,"Message " + e.getMessage());
		}
		return result;
	}

	@Override
	public OmniCommonCO returnMappingId(OmniCommonUserSC criteria) throws DAOException {
		return (OmniCommonCO) getSqlMap().queryForObject("omniCommonPullMapper.returnMappingId", criteria);
	}

	@Override
	public OmniCommonCO returnPackageId(OmniUserSC userSC) throws DAOException {
		return (OmniCommonCO) getSqlMap().queryForObject("omniCommonPullMapper.returnPackageId", userSC);
	}

	/**
	 * @author mohammadshour added for services having same oper with different
	 *         mapping id
	 */

	@Override
	public OmniCommonCO returnCommonOperMappingId(OmniCommonUserSC criteria) throws DAOException {
		return (OmniCommonCO) getSqlMap().queryForObject("omniCommonPullMapper.returnCommonOperMappingId", criteria);
	}

	@Override
	public BigDecimal returnAppChnlId(OmniBaseSC omniBaseSC) throws DAOException {
		return (BigDecimal) getSqlMap().queryForObject("omniCommonPullMapper.returnAppChnlId", omniBaseSC);
	}

	@Override
	public OC_APP_CHNLVO returnAppChnlVO(ChannelLoginRequest omniBaseSC) throws DAOException {
		return (OC_APP_CHNLVO) getSqlMap().queryForObject("omniCommonPullMapper.returnAppChnlVO", omniBaseSC);
	}

	@Override
	public SimVO returnSimVO(ClientCO clientCO) throws DAOException {
		// TODO Auto-generated method stub
		return (SimVO) getSqlMap().queryForObject("omniCommonPullMapper.returnSimVO", clientCO);
	}

	@Override
	public SimVO returnSimSerial(ClientCO clientCO) throws DAOException {
		return (SimVO) getSqlMap().queryForObject("omniCommonPullMapper.returnSimSerial", clientCO);
	}

	@Override
	public DeviceVO returnDevice(ClientCO clientCO) throws DAOException {
		return (DeviceVO) getSqlMap().queryForObject("omniCommonPullMapper.returnDevice", clientCO);
	}

	@Override
	public Client_deviceVO returnCombinationUsernameDevice(ClientCO clientCO) throws DAOException {
		return (Client_deviceVO) getSqlMap().queryForObject("omniCommonPullMapper.returnCombinationUsernameDevice",
				clientCO);
	}

	@Override
	public Machine_driverCO returnMachineDriverDetails(ReservationCO reservationCO) throws DAOException {
		return (Machine_driverCO) getSqlMap().queryForObject("omniCommonPullMapper.returnMachineDriverDetails",
				reservationCO);
	}

	@Override
	public ClientVO returnUsernamePassword(ClientCO clientCO) throws DAOException {
		return (ClientVO) getSqlMap().queryForObject("omniCommonPullMapper.returnUsernamePassword", clientCO);
	}

	@Override
	public ClientVO returnUsername(ClientVO clientVO) throws DAOException {
		return (ClientVO) getSqlMap().queryForObject("omniCommonPullMapper.returnUsername", clientVO);
	}

	@Override
	public Client_deviceVO returnCombination(ClientCO clientCO) throws DAOException {
		return (Client_deviceVO) getSqlMap().queryForObject("omniCommonPullMapper.returnCombination", clientCO);
	}

	@Override
	public DriverVO returnDriverInfos(DriverVO driverVO) throws DAOException {
		return (DriverVO) getSqlMap().queryForObject("omniCommonPullMapper.returnDriverInfos", driverVO);
	}

	@Override
	public ClientVO returnClientInfos(ClientVO clientVO) throws DAOException {
		return (ClientVO) getSqlMap().queryForObject("omniCommonPullMapper.returnClientInfos", clientVO);
	}

	@Override
	public MachineVO returnMachineInfos(MachineVO machineVO) throws DAOException {
		return (MachineVO) getSqlMap().queryForObject("omniCommonPullMapper.returnMachineInfos", machineVO);

	}

	@Override
	public ClientVO returnUsernamePasswordById(ClientCO clientCO) throws DAOException {
		return (ClientVO) getSqlMap().queryForObject("omniCommonPullMapper.returnUsernamePasswordById", clientCO);
	}

	@Override
	public DriverVO returnDriver(DriverVO driverVO) throws DAOException {
		return (DriverVO) getSqlMap().queryForObject("omniCommonPullMapper.returnDriver", driverVO);
	}

	@Override
	public MachineVO returnMachineByPlateNumber(MachineVO machineVO) throws DAOException {
		return (MachineVO) getSqlMap().queryForObject("omniCommonPullMapper.returnMachineByPlateNumber", machineVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MachineVO> returnAvailableMachines(MachineVO machineVO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnAvailableMachines", machineVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationSC> returnReservationsList(ReservationVO reservationVO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnReservationsList", reservationVO);
	}

	@Override
	public TemporaryReservationVO returnMaxTemporaryReservation(ReservationCO reservationCO) throws DAOException {
		return (TemporaryReservationVO) getSqlMap().queryForObject("omniCommonPullMapper.returnMaxTemporaryReservation",
				reservationCO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TemporaryReservationVO> returnListOfTmeporaryReservation(TemporaryReservationVO temporaryReservationVO)
			throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListOfTmeporaryReservation",
				temporaryReservationVO);
	}

	@Override
	public ReservationVO returnReservationOccurrenceType(ReservationVO reservationVO) throws DAOException {
		return (ReservationVO) getSqlMap().queryForObject("omniCommonPullMapper.returnReservationOccurrenceType",
				reservationVO);
	}

	@Override
	public ReservationListVO returnOneTimeReservationDetails(ReservationVO reservationVO) throws DAOException {
		return (ReservationListVO) getSqlMap().queryForObject("omniCommonPullMapper.returnOneTimeReservationDetails",
				reservationVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationCO> returnRecurringReservationDetails(ReservationVO reservationVO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnRecurringReservationDetails", reservationVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationListVO> returnIfMachineDriverIsReserved(MachineDriverSC machineDriverSC)
			throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnIfMachineDriverIsReserved", machineDriverSC);
	}

	@Override
	public ReservationCO returnReservationDetails(ReservationListVO reservationListVO) throws DAOException {
		return (ReservationCO) getSqlMap().queryForObject("omniCommonPullMapper.returnReservationDetails",
				reservationListVO);
	}

	@Override
	public StoreVO returnStore(StoreVO storeVO) throws DAOException {
		return (StoreVO) getSqlMap().queryForObject("omniCommonPullMapper.returnStore", storeVO);
	}

	@Override
	public Machine_driverCO returnNearestAvailableMachine(ReservationCO reservationCO) throws DAOException {
		return (Machine_driverCO) getSqlMap().queryForObject("omniCommonPullMapper.returnNearestAvailableMachine",
				reservationCO);
	}

	@Override
	public Machine_driverCO returnNearestUnavailableMachineTypeTrip(ReservationCO reservationCO) throws DAOException {
		return (Machine_driverCO) getSqlMap()
				.queryForObject("omniCommonPullMapper.returnNearestUnavailableMachineTypeTrip", reservationCO);
	}

	@Override
	public Machine_driverCO returnNearestUnavailableMachineTypeMachine(ReservationCO reservationCO)
			throws DAOException {
		return (Machine_driverCO) getSqlMap()
				.queryForObject("omniCommonPullMapper.returnNearestUnavailableMachineTypeMachine", reservationCO);
	}

	@Override
	public ReservationCO returnDistance(ReservationCO reservationCO) throws DAOException {
		return (ReservationCO) getSqlMap().queryForObject("omniCommonPullMapper.returnDistance", reservationCO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Machine_driverCO> returnListOfMachinesFromNearestToMostFarTrip(ReservationCO reservationCO)
			throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListOfMachinesFromNearestToMostFarTrip",
				reservationCO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Machine_driverCO> returnListOfMachinesFromNearestToMostFarMachine(ReservationCO reservationCO)
			throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListOfMachinesFromNearestToMostFarMachine",
				reservationCO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<List_destinationsVO> returnListOfDestination(List_destinationsVO list_destinationsVO)
			throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListOfDestination", list_destinationsVO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Machine_driverCO> returnListAvailableMachinesNearestMostFar(ReservationCO reservationCO)
			throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListAvailableMachinesNearestMostFar",
				reservationCO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservationCO> returnLast3Reservations(ReservationCO reservationCO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnLast3Reservations", reservationCO);
	}

	@Override
	public ClientVO returnMobileNumber(ClientVO clientVO) throws DAOException {
		return (ClientVO) getSqlMap().queryForObject("omniCommonPullMapper.returnMobileNumber", clientVO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Machine_driverCO> returnListUnavailableMachines(ReservationCO reservationCO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListUnavailableMachines", reservationCO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientCO> returnListDevices(ClientVO clientVO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnListDevices", clientVO);

	}

	@Override
	public int returnUsernameExists(ClientVO clientVO) throws DAOException {
		return (int) getSqlMap().queryForObject("omniCommonPullMapper.returnUsernameExists", clientVO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ErrorVO> returnLanguageError(ErrorVO errorVO) throws DAOException {
		return getSqlMap().queryForList("omniCommonPullMapper.returnLanguageError", errorVO);

	}

	@Override
	public ClientCO returnGender(ClientCO clientCO) throws DAOException {
		return (ClientCO) getSqlMap().queryForObject("omniCommonPullMapper.returnGender", clientCO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public ClientCO returnLastLogin(ClientCO clientCO) throws DAOException {
		return (ClientCO) getSqlMap().queryForObject("omniCommonPullMapper.returnLastLogin", clientCO);
	}

}
