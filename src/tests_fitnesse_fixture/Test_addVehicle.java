package tests_fitnesse_fixture;
import fit.ColumnFixture;

public class Test_addVehicle extends ColumnFixture{
 String datainvehicles[], data, result;
 int number1, number2;

 public boolean addVehicle_()
 { result=null;
 result=SetUp.facade.addVehicle(datainvehicles);
 data=SetUp.data.datavehicles[number1][number2];
 return data.equals(result);
 }
}