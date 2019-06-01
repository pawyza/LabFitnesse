/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests_fitnesse_fixture;

import fit.ColumnFixture;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Test_addRental extends ColumnFixture{
 String datainvehicles[],datainregisteredvehicle[],datainreservation[],condition, data, result;
 double cost;
 int daterenting[], datereturn[], number, numid;

 public boolean addRental_()
 { result=null;
 SetUp.facade.addVehicle(datainvehicles);
 SetUp.facade.addRegisteredVehicle(datainvehicles,datainregisteredvehicle);
 SetUp.facade.addReservation(datainvehicles,datainreservation,LocalDate.of(daterenting[0],daterenting[1],daterenting[2]),LocalDate.of(datereturn[0],datereturn[1],datereturn[2]));
 result = SetUp.facade.addRental(datainvehicles,datainregisteredvehicle,datainreservation,LocalDate.of(daterenting[0],daterenting[1],daterenting[2]),LocalDate.of(datereturn[0],datereturn[1],datereturn[2]),condition,numid,cost);
 data = SetUp.data.reservationData[number];
 return data.equals(result);
 }
}
