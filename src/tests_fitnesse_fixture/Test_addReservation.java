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
public class Test_addReservation extends ColumnFixture{
 String datainvehicles[],datainregisteredvehicle[],datainreservation[], data, result;
 int daterenting[], datereturn[];
 int number;

 public boolean addReservation_()
 { result=null;
 SetUp.facade.addVehicle(datainvehicles);
 SetUp.facade.addRegisteredVehicle(datainvehicles,datainregisteredvehicle);
 result=SetUp.facade.addReservation(datainvehicles,datainreservation,LocalDate.of(daterenting[0],daterenting[1],daterenting[2]),LocalDate.of(datereturn[0],datereturn[1],datereturn[2]));
 
 data=SetUp.data.reservationData[number];
 return data.equals(result);
 }
}