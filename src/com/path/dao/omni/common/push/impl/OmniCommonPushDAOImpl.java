/**
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: gilbertandary
 *
 * OmniCommonPushDAOImpl.java
 *
 * 
 */
package com.path.dao.omni.common.push.impl;

import com.path.dao.omni.common.base.OmniBaseDAO;
import com.path.dao.omni.common.push.OmniCommonPushDAO;
import com.path.dbmaps.vo.ClientCO;
import com.path.dbmaps.vo.ClientVO;
import com.path.dbmaps.vo.DriverCO;
import com.path.dbmaps.vo.DriverVO;
import com.path.dbmaps.vo.List_destinationsVO;
import com.path.dbmaps.vo.MachineCO;
import com.path.dbmaps.vo.MachineVO;
import com.path.dbmaps.vo.Machine_driverCO;
import com.path.dbmaps.vo.RateVO;
import com.path.dbmaps.vo.ReservationCO;
import com.path.dbmaps.vo.StoreVO;
import com.path.dbmaps.vo.WorkingHoursVO;
import com.path.lib.common.exception.DAOException;

public class OmniCommonPushDAOImpl extends OmniBaseDAO implements OmniCommonPushDAO {

	@Override
	public void insertSim(ClientCO clientCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertSim", clientCO);
	}

	@Override
	public void insertDevice(ClientCO clientCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertDevice", clientCO);

	}

	@Override
	public void insertCombination(ClientCO clientCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertCombination", clientCO);

	}

	@Override
	public void updateClient(ClientCO clientCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateClient", clientCO);
	}

	@Override
	public void insertReservation(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertReservation", reservationCO);
	}

	@Override
	public void deleteReservation(ReservationCO reservationCO) throws DAOException {
		getSqlMap().delete("omniCommonPushMapper.deleteReservation", reservationCO);
	}

	@Override
	public void updateReservationStatus(DriverCO driverCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateReservationStatus", driverCO);

	}

	@Override
	public void insertUsernamePass(ClientCO clientCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertUsernamePass", clientCO);

	}

	@Override
	public void updateCombination(ClientCO clientCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateCombination", clientCO);

	}

	@Override
	public void insertListReservationList(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertListReservationList", reservationCO);

	}

	@Override
	public void insertRecurring_template(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertRecurring_template", reservationCO);

	}

	@Override
	public void insertRating(RateVO rateVO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertRating", rateVO);

	}

	@Override
	public void insertDriver(DriverVO driverVO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertDriver", driverVO);

	}

	@Override
	public void insertMachine(MachineVO machineVO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertMachine", machineVO);
	}

	@Override
	public void updateClientInfos(ClientVO clientVO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateClientInfos", clientVO);

	}

	@Override
	public void updatePassword(ClientCO clientCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updatePassword", clientCO);

	}

	@Override
	public void updateProfile(ClientVO clientVO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateProfile", clientVO);
		
	}

	
	@Override
	public void updateMachineInfos(MachineCO machineCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateMachineInfos", machineCO);

	}

	@Override
	public void updateDriverInfos(DriverVO driverVO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateDriverInfos", driverVO);
	}

	@Override
	public void insertTempReservationTrip(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertTempReservationTrip", reservationCO);

	}

	@Override
	public void insertTempReservationTripBefore(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertTempReservationTripBefore", reservationCO);

	}

	@Override
	public void insertReservationList(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertReservationList", reservationCO);

	}

	@Override
	public void insertTempReservationTripAfter(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertTempReservationTripAfter", reservationCO);

	}

	@Override
	public void deleteTemporaryReservation(ReservationCO reservationCO) throws DAOException {
		getSqlMap().delete("omniCommonPushMapper.deleteTemporaryReservation", reservationCO);

	}

	@Override
	public void updateDriverWorkingHours(WorkingHoursVO workingHoursVO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.updateDriverWorkingHours", workingHoursVO);

	}

	@Override
	public void updateReservStatus(ReservationCO reservationCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateReservStatus", reservationCO);

	}

	@Override
	public void insertReservationListMachineInfos(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertReservationListMachineInfos", reservationCO);

	}

	@Override
	public void updateReservationListStatus(ReservationCO reservationCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateReservationListStatus", reservationCO);

	}

	@Override
	public void insertFacture(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertfacture", reservationCO);

	}

	public void insertStore(StoreVO storeVO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertStore", storeVO);
	}

	@Override
	public void insertMachineMnt(MachineCO machineCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertMachineMnt", machineCO);
	}

	@Override
	public void updateClientStatus(ClientCO clientCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateClientStatus", clientCO);

	}

	@Override
	public void updateMachineLocation(DriverCO driverCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateMachineLocation", driverCO);

	}

	@Override
	public void updateMachineDriverStatus(Machine_driverCO machine_driverCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateMachineDriverStatus", machine_driverCO);

	}

	@Override
	public void insertTempReservationMachine(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertTempReservationMachine", reservationCO);

	}

	@Override
	public void insertTempReservationMachineAfter(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertTempReservationMachineAfter", reservationCO);

	}

	@Override
	public void insertTempReservationMachineBefore(ReservationCO reservationCO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertTempReservationMachineBefore", reservationCO);

	}

	@Override
	public void insertDestination(List_destinationsVO list_destinationsVO) throws DAOException {
		getSqlMap().insert("omniCommonPushMapper.insertDestination", list_destinationsVO);

	}

	public void resetPassword(ClientVO clientVO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.resetPassword", clientVO);

	}

	@Override
	public void deleteCombinationDeviceUsername(ClientCO clientCO) throws DAOException {
		getSqlMap().delete("omniCommonPushMapper.deleteCombinationDeviceUsername", clientCO);
	}

	@Override
	public void updateLastLoginUser(ClientCO clientCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateLastLogin", clientCO);
		
	}

	@Override
	public void updateLastLoginUserDevice(ClientCO clientCO) throws DAOException {
		getSqlMap().update("omniCommonPushMapper.updateLastLoginUserDevice", clientCO);
		
	}
}
