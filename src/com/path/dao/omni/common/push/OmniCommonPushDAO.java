/**
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Alaa Al Hek
 *
 * OmniCommonPushDAOImpl.java
 *
 * 
 */
package com.path.dao.omni.common.push;


import org.apache.catalina.connector.ClientAbortException;

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

public interface OmniCommonPushDAO {

	/**
	 * method to insert the username and password in client table
	 * 
	 * @param clientCO
	 * @throws DAOException
	 */
	public void insertUsernamePass(ClientCO clientCO) throws DAOException;

	/**
	 * Method insert sim into database
	 * 
	 * @param ClientRequest
	 * @throws DAOException
	 */
	public void insertSim(ClientCO clientCO) throws DAOException;

	/**
	 * Method insert device into database
	 * 
	 * @param ClientRequest
	 * @throws DAOException
	 */
	public void insertDevice(ClientCO clientCO) throws DAOException;

	/**
	 * Method insert combination sim and device and client into database
	 * 
	 * @param ClientRequest
	 * @throws DAOException
	 */
	public void insertCombination(ClientCO clientCO) throws DAOException;

	/**
	 * method that update the status of client 0:login , 1:logout
	 * 
	 * @param deviceVO
	 * @throws DAOException
	 */
	public void updateClientStatus(ClientCO clientCO) throws DAOException;

	/**
	 * method that insert into reservation where type is trip
	 * 
	 * @param request
	 * @throws DAOException
	 */
	public void insertReservation(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to insert list of reservations in reservation_list table with all
	 * details from temporary reservation table when the reservation is recurrent
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertListReservationList(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to insert reservation in reservation_list table when the reservation
	 * is one time
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertReservationList(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that update the name of client in client table
	 * 
	 * @param request
	 * @throws DAOException
	 */

	public void updateClient(ClientCO clientCO) throws DAOException;

	/**
	 * method that delete the reservation
	 * 
	 * @param request
	 * @throws DAOException
	 */
	public void deleteReservation(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that the driver update the reservation status
	 * 
	 * @param driverRequest
	 * @throws DAOException
	 * 
	 */
	public void updateReservationStatus(DriverCO driverCO) throws DAOException;

	/**
	 * when the driver reach the destination and the reservation is done , insert in
	 * the db the current location of the machine
	 * 
	 * @param driverCO
	 * @throws DAOException
	 */
	public void updateMachineLocation(DriverCO driverCO) throws DAOException;

	/**
	 * method that update the reservation status , used in update machine and driver
	 * infos
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void updateReservStatus(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to insert the rating in the db
	 * 
	 * @param request
	 * @throws DAOException
	 */
	public void insertRating(RateVO rateVO) throws DAOException;

	/**
	 * method to insert into recurring template table the recuring reservation
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertRecurring_template(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that insert into temporary table the available machine to reserve it ,
	 * in order to avoid conflict reservation in processing time if the reservation
	 * type is trip
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertTempReservationTrip(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that insert into temporary table the available machine to reserve it ,
	 * in order to avoid conflict reservation in processing time if the reservation
	 * type is machine (the client determine the time_slot )
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertTempReservationMachine(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that reserve a machine temporarly , in case no available machine at
	 * this time insert into temporary table to reserve a machine before the time
	 * reservation is trip
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertTempReservationTripBefore(ReservationCO reservationCO) throws DAOException;

	/**
	 * method that reserve a machine temporarly , in case no available machine at
	 * this time insert into temporary table to reserve a machine before the time
	 * reservation is machine
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertTempReservationMachineBefore(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to insert into temporary reservation , in order to reserve a machine
	 * later than the time mentioned and the reservation is trip
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertTempReservationTripAfter(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to insert into temporary reservation , in order to reserve a machine
	 * later than the time mentioned and the reservation is machine
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertTempReservationMachineAfter(ReservationCO reservationCO) throws DAOException;

	/**
	 * after confirm the reservation , delete a temprorary reservation from
	 * temporary_reservation table
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void deleteTemporaryReservation(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to update the combination for saving the device
	 * 
	 * @param clientCO
	 * @throws DAOException
	 */
	public void updateCombination(ClientCO clientCO) throws DAOException;

	/**
	 * method to insert a new driver
	 * 
	 * @param driverVO
	 * @throws DAOException
	 */
	public void insertDriver(DriverVO driverVO) throws DAOException;

	/**
	 * method to insert a new machine
	 * 
	 * @param machineVO
	 * @throws DAOException
	 */
	public void insertMachine(MachineVO machineVO) throws DAOException;

	/**
	 * method to update client infos
	 * 
	 * @param clientVO
	 * @throws DAOException
	 */
	public void updateClientInfos(ClientVO clientVO) throws DAOException;

	/**
	 * method to update the password
	 * 
	 * @param clientCO
	 * @throws DAOException
	 */
	public void updatePassword(ClientCO clientCO) throws DAOException;

	/**
	 * method to update the profile of the {@link ClientAbortException} in db
	 * 
	 * @param clientVO
	 * @throws DAOException
	 */
	public void updateProfile(ClientVO clientVO) throws DAOException;

	/**
	 * method to update machine infos
	 * 
	 * @param machineVO
	 * @throws DAOException
	 */
	public void updateMachineInfos(MachineCO machineCO) throws DAOException;

	/**
	 * method that update the machine_driver_status , used in update driver status
	 * and update machine status , if one not available,so the machine_driver is not
	 * available
	 * 
	 * @param machine_driverCO
	 * @throws DAOException
	 */
	public void updateMachineDriverStatus(Machine_driverCO machine_driverCO) throws DAOException;

	/**
	 * method to update driver infos
	 * 
	 * @param driverVO
	 * @throws DAOException
	 */
	public void updateDriverInfos(DriverVO driverVO) throws DAOException;

	/**
	 * method that update the working hours of drivers
	 * 
	 * @param workingHoursVO
	 * @throws DAOException
	 */
	public void updateDriverWorkingHours(WorkingHoursVO workingHoursVO) throws DAOException;

	/**
	 * method that insert the facture into facture table
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertFacture(ReservationCO reservationCO) throws DAOException;

	/**
	 * method to update the status of reservation list
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void updateReservationListStatus(ReservationCO reservationCO) throws DAOException;

	/**
	 * insert into the reservation list the new machine reserved
	 * 
	 * @param reservationCO
	 * @throws DAOException
	 */
	public void insertReservationListMachineInfos(ReservationCO reservationCO) throws DAOException;

	/**
	 * insert into the store table in db
	 * 
	 * @param storeVO
	 * @throws DAOException
	 */
	public void insertStore(StoreVO storeVO) throws DAOException;

	/**
	 * method to insert into machine maintenance table
	 * 
	 * @param machineCO
	 * @throws DAOException
	 */
	public void insertMachineMnt(MachineCO machineCO) throws DAOException;

	/**
	 * method that add destination for client
	 * 
	 * @param list_destinationsVO
	 * @throws DAOException
	 */
	public void insertDestination(List_destinationsVO list_destinationsVO) throws DAOException;

	/**
	 * method that reset the password
	 * 
	 * @param clientCO
	 * @throws DAOException
	 */
	public void resetPassword(ClientVO clientVO) throws DAOException;
	
	/**
	 * method that delete the combination of device and username
	 * @param clientCO
	 * @throws DAOException
	 */
	public void deleteCombinationDeviceUsername(ClientCO clientCO) throws DAOException;
	
	/**
	 * method that insert in the db the last login date in client table 
	 * @param clientCO
	 * @throws DAOException
	 */
	public void updateLastLoginUser(ClientCO clientCO) throws DAOException;
	
	/**
	 * method that update the last login date for the combination username and device
	 * @param clientCO
	 * @throws DAOException
	 */
	public void updateLastLoginUserDevice (ClientCO clientCO) throws DAOException;
}
