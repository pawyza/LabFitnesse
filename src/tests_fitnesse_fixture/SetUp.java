/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests_fitnesse_fixture;

import fit.Fixture;
import subbusinesstier.Facade;
import testdata.Data1;
/**
 *
 * @author User
 */
public class SetUp extends Fixture{
 static Facade facade;
 static Data1 data;
 
 public SetUp() {
 facade = new Facade();
 data=new Data1(); 
 }
}