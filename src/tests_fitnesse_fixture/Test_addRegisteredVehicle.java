/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests_fitnesse_fixture;

import fit.ColumnFixture;

/**
 *
 * @author User
 */
public class Test_addRegisteredVehicle extends ColumnFixture{
 String datainvehicles[],datainregisteredvehicles[], data, result;
 int number;

 public boolean addRegisteredVehicle_()
 { result=null;
 SetUp.facade.addVehicle(datainvehicles);
 result=SetUp.facade.addRegisteredVehicle(datainvehicles, datainregisteredvehicles).toString();
 data=SetUp.data.registeredVehicleData[number];
 return data.equals(result);
 }
}