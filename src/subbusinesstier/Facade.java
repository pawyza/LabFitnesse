package subbusinesstier;

import subbusinesstier.entities.Vehicle;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * PU:
 * Operacje_na_pojazdach, Modyfikacja_stanu_pojazdu, Usuwanie_pojazdu, Wyszukaj_pojazd, Wyszukaj_rezerwacje, Wypo�yczenie_pojazdu, Anulowanie_rezerwacji, Zwrot_pojazdu, Wyszukaj_wypo�yczenie, Skontaktuj_si�_z_klientem
 */
public class Facade {

    private ArrayList<Vehicle> vehicles;

    public Facade() {
            vehicles = new ArrayList<>();
    }


    public static void main(String[] args) {
        String [] vehicle1 = {"0","brand1","model1"};
        String [] vehicle2 = {"0","brand2","model2"};
        String [] vehicle3 = {"0","brand3","model3"};
        String [] vehicle4 = {"1","brand4","model4","black","4","5","combi"};
        
        Facade facade = new Facade();
        facade.addVehicle(vehicle1);
        facade.addVehicle(vehicle2);
        facade.addVehicle(vehicle3);
        facade.addVehicle(vehicle4);
        System.out.println(facade.printVehicles());
        
        String [] regVehicle1 = {"0","2415"};       
        String [] regVehicle2 = {"0","515"};       
        String [] regVehicle3 = {"0","512515"};       
        String [] regVehicle4 = {"0","95695"};       
        String [] regVehicle5 = {"0","2411"};      
        
        facade.addRegisteredVehicle(vehicle1, regVehicle1);
        facade.addRegisteredVehicle(vehicle1, regVehicle2);
        facade.addRegisteredVehicle(vehicle2, regVehicle3);
        facade.addRegisteredVehicle(vehicle2, regVehicle4);
        facade.addRegisteredVehicle(vehicle3, regVehicle5);
        
        System.out.println(facade.printRegisteredVehicles());
        
        
        String [] reservation1 = {"1","Forename1","Surname1","1"};
        String [] reservation2 = {"2","Forename2","Surname2","2"};
        String [] reservation3 = {"3","Forename3","Surname3","3"};
        String [] reservation4 = {"4","Forename4","Surname4","4"};
        String [] reservation5 = {"5","Forename5","Surname5","5"};
        
        String result = facade.addReservation(vehicle1, reservation1, LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 6));
        System.out.println(result);
        result =facade.addReservation(vehicle1, reservation2, LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 10));
        System.out.println(result);
        result =facade.addReservation(vehicle1, reservation3, LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 6));
        System.out.println(result);
        result =facade.addReservation(vehicle2, reservation4, LocalDate.of(2019, 5, 7),LocalDate.of(2019, 7, 16));
        System.out.println(result);
        result = facade.addReservation(vehicle3, reservation5, LocalDate.of(2019, 6, 9),LocalDate.of(2019, 7, 6));
        System.out.println(result);
        
        System.out.println(facade.printReservations());
        
        result = facade.addRental(vehicle1, regVehicle1, reservation1, LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 6), "?", 0, 0);
        System.out.println(result);
        result =facade.addRental(vehicle1, regVehicle2, reservation1, LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 10), "?", 0, 0);
        System.out.println(result);
        result =facade.addRental(vehicle1, regVehicle2, reservation2,LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 10), "?", 0, 0);
        System.out.println(result);
        result =facade.addRental(vehicle1, regVehicle2, reservation3,LocalDate.of(2019, 7, 5),LocalDate.of(2019, 7, 6), "?", 0, 0);
        System.out.println(result);
        result =facade.addRental(vehicle2, regVehicle3, reservation4, LocalDate.of(2019, 5, 7),LocalDate.of(2019, 7, 16), "?", 0, 0);
        System.out.println(result);
        result =facade.addRental(vehicle2, regVehicle4, reservation4, LocalDate.of(2019, 5, 7),LocalDate.of(2019, 7, 16), "?", 0, 0);
        System.out.println(result);
        result =facade.addRental(vehicle3, regVehicle5, reservation5, LocalDate.of(2019, 6, 9),LocalDate.of(2019, 7, 6), "?", 0, 0);
        System.out.println(result);
        
        
    }
        
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    
    /**
     * 
     * @param vehicle
     */
    public void setVehicles(List<Vehicle> vehicle) {
        vehicles = (ArrayList) vehicle;
    }

    public String printVehicles() {
    StringBuffer printout = new StringBuffer();
        for (Vehicle vehicle:
                 vehicles) {
                printout.append(vehicle.toString()+ "\n");
        }
        return printout.toString();
    }

    /**
     * 
     * @param data1
     */
    public String addVehicle(String[] data1) {
            Factory factory = new Factory();
            Vehicle vehicle = factory.createVehicle(data1);
            if (searchVehicle(vehicle) == null){
                    vehicles.add(vehicle);
                    return vehicle.toString();
            }
            return null;
    }

    /**
     * 
     * @param vehicle
     */
    public Vehicle searchVehicle(Vehicle vehicle) {
            int idx;
            if ((idx = vehicles.indexOf(vehicle)) != -1) {
                    return vehicles.get(idx);
            }
            return null;
    }

    /**
     * 
     * @param data1
     * @param data2
     * @param rentingDate
     */
    public String addReservation(String[] data1, String[] data2, LocalDate rentingDate, LocalDate returnDate) {
        String result;
        Factory factory = new Factory();
        Vehicle helpVehicle= factory.createVehicle(data1),vehicle;

        vehicle = this.searchVehicle(helpVehicle);
        if(vehicle != null){
            result = vehicle.addReservation(data2, rentingDate, returnDate);
        } else result = "no such vehicle";
    return result;
    }

    public ArrayList<String> getReservationsStringList(String[] data1, String[] data2) {
        Factory factory = new Factory();
        
        Vehicle helpVehicle = factory.createVehicle(data1),vehicle;
        
        vehicle = this.searchVehicle(helpVehicle);
        ArrayList<String> helpReservations  = new ArrayList<>();
        
        if(vehicle != null){
          return vehicle.getReservationsStringList(data2);
        }
        return null;
    }

    /**
     * 
     * @param data
     */
    public String printReservations() {
        String result = "";
        for(Vehicle vehicle : vehicles){
            result += vehicle.printReservations();
        }
        return result;
    }

    /**
     * 
     * @param data1
     * @param data2
     */
    public String addRegisteredVehicle(String[] data1, String[] data2) {
        Factory factory = new Factory();
        Vehicle vehicle = factory.createVehicle(data1);
        Vehicle vehicleReference;
        if ((vehicleReference = searchVehicle(vehicle)) != null){
                return vehicleReference.addRegisteredVehicle(data2);
        }
        return null;
    }

    public ArrayList<String> getRegisteredVehicleModel() {
            // TODO - implement Facade.getRegisteredVehicleModel
            throw new UnsupportedOperationException();
    }

    public String printRegisteredVehicles() {
        String result = "";
        for(Vehicle vehicle : vehicles){
            result += vehicle.printRegisteredVehicles();
        }
        return result;
    }

    /**
     * @param data1
     * @param data
     * @return 
     */
    public ArrayList<String> getRegisteredVehicleStringList(String[] data1) {
        Factory factory = new Factory();
        
        Vehicle helpVehicle = factory.createVehicle(data1),vehicle;
        
        vehicle = this.searchVehicle(helpVehicle);
        ArrayList<String> helpReservations  = new ArrayList<>();
        
        if(vehicle != null){
          return vehicle.getRegisteredVehicleStringList();
        }
        return null;
    }
    
     public String addRental(String[] data1, String[] data2, String[] data3, LocalDate rentingDate, LocalDate returnDate , String condition,int number, double cost) {
        String result;
        Factory factory = new Factory();
        
        Vehicle helpVehicle = factory.createVehicle(data1),vehicle;
        
        vehicle = this.searchVehicle(helpVehicle);
        if(vehicle != null){
            result = vehicle.addRental(data2, data3, rentingDate, returnDate, condition, number, cost);
        } else result = "no such vehicle";
        return result;
    }
}
