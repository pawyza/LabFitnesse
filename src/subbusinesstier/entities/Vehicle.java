package subbusinesstier.entities;



import subbusinesstier.Factory;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PU:
 * Modyfikacja_stanu_pojazdu, Dodawanie_pojazdu, Usuwanie_pojazdu, Wyszukaj_pojazd, Operacje_na_pojazdach
 */
public class Vehicle {

    private String brand;
    private String model;
    private String color;
    private int seatsNumber;
    private int doorsNumber;
    private String engineType;
    private double engineCapacity;
    private String carType;
    private List<RegisteredVehicle> registeredVehicles = new ArrayList();

    public Vehicle(String brand, String model, String color, int seatsNumber, int doorsNumber, String engineType, double engineCapacity, String carType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.seatsNumber = seatsNumber;
        this.doorsNumber = doorsNumber;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.carType = carType;
    }

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

     

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoorsNumber() {
        return this.doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getEngineCapacity() {
        return this.engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Vehicle() {	}

    public List<RegisteredVehicle> getRegisteredVehicles() {
        return  registeredVehicles;
    }

    /**
     * 
     * @param registeredVehicles
     */
    public void setRegisteredVehicles(List<RegisteredVehicle> registeredVehicles) {
        this.registeredVehicles =  registeredVehicles;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(getBrand()+getModel());
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (getBrand().equals(((Vehicle) obj).getBrand())) {
                if (getModel().equals(((Vehicle) obj).getModel())) {
                        return true;
                }
        }
        return false;
    }

    /**
     * 
     * @param data
     * @return 
     */
    public String addRegisteredVehicle(String[] data) {
        Factory factory = new Factory();
        RegisteredVehicle registeredVehicle = factory.createRegisteredVehicle(data);
        if (searchRegisteredVehicle(registeredVehicle) == null){
                registeredVehicles.add(registeredVehicle);
                registeredVehicle.setVehicle(this);
                return registeredVehicle.toString();
        }
        return null;
    }

    private ArrayList<String> getRegisteredVehiclesModel() {
        ArrayList<String> registeredVehiclesModel = new ArrayList<>();
        Iterator<RegisteredVehicle> help = registeredVehicles.iterator();
        while (help.hasNext()) {
                RegisteredVehicle next = help.next();
                registeredVehiclesModel.add(next.toString());
        }
        return registeredVehiclesModel;
    }

    /**
     * 
     * @param registeredVehicle
     * @return 
     */
    public RegisteredVehicle searchRegisteredVehicle(RegisteredVehicle registeredVehicle) {
        int idx;
        if ((idx = registeredVehicles.indexOf(registeredVehicle)) != -1) {
                return registeredVehicles.get(idx);
        }
        return null;
    }

    /**
     * 
     * @param date
     * @return 
     */
    private RegisteredVehicle freeRegisteredVehicle;
    
    public boolean searchFreeRegisteredVehicle(LocalDate date) {
    RegisteredVehicle registeredVehicle= null;
    for (int i = 0; i < registeredVehicles.size(); i++) {
        registeredVehicle = registeredVehicles.get(i);
        if (registeredVehicle.isFree(date)){
            freeRegisteredVehicle = registeredVehicle;
            return true;
        }
    }
    return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Brand:").append(brand).append(" ");
        stringBuffer.append("Model:").append(model).append(" ");
        if (color != null)
                stringBuffer.append("Color:").append(color).append(" ");
        if (seatsNumber!= 0)
                stringBuffer.append("seatsNumber:").append(seatsNumber).append(" ");
        if (doorsNumber!=0 )
                stringBuffer.append("doorsNumber:").append(doorsNumber).append(" ");
        if (engineType != null)
                stringBuffer.append("engineType:").append(engineType).append(" ");
        if (engineCapacity != 0)
                stringBuffer.append("engineCapacity:").append(engineCapacity).append(" ");
        if (carType != null)
                stringBuffer.append("carType:").append(carType).append(" ");
        return stringBuffer.toString();
    }

    public String[] toString_() {
        String help[] = new String[9];
        help[0] = getBrand();
        help[1] = getModel();
        help[2] = getColor();
        help[3] = String.valueOf(seatsNumber);
        help[4] = String.valueOf(doorsNumber);
        help[5] = getEngineType();
        help[6] = String.valueOf(engineCapacity);
        help[7] = getCarType();
    return help;
    }
    
    public String addRental(String[] data1, String[] data2, LocalDate rentingDate, LocalDate returnDate, String condition,int number , double cost) {
        String result;
        Factory factory = new Factory();
        RegisteredVehicle helpRegisteredVehicle = factory.createRegisteredVehicle(data1),registeredVehicle;
        registeredVehicle = searchRegisteredVehicle(helpRegisteredVehicle);
        if(registeredVehicle != null){
            Reservation helpReservation = factory.createReservation(data2, rentingDate, returnDate),reservation;
            reservation = registeredVehicle.searchReservation(helpReservation);
                if(reservation != null){
                    reservation.addRental(reservation, condition, cost);
                    result = "rented";} else result = "no such reservation";
        } else result = "no such registered vehicle";
        return result;
    }
    
    public String addReservation(String[] data1, LocalDate rentingDate, LocalDate returnDate) {
        String result;
        Factory factory = new Factory();
            if(searchFreeRegisteredVehicle(rentingDate)){
                   Reservation reservation = factory.createReservation(data1, rentingDate, returnDate);
                   if (reservation!=null){
                       System.out.println(freeRegisteredVehicle.toString());
                        freeRegisteredVehicle.addReservation(reservation);
                        result = "reserved";
                   } else result = "wrong reservation";
            } else result = "no such free registered vehicle";
    return result;
    }
    
    public ArrayList<String> getReservationsStringList(String[] data1) {
        String result;
        Factory factory = new Factory();
        RegisteredVehicle helpRegisteredVehicle = factory.createRegisteredVehicle(data1),registeredVehicle;
        registeredVehicle = searchRegisteredVehicle(helpRegisteredVehicle);

        if (searchRegisteredVehicle(registeredVehicle) != null) {
            return registeredVehicle.getReservationsStringList();
        }
        return null;
    }
    
    public String printRegisteredVehicles() {
        String result = "";
        for(RegisteredVehicle registeredVehicle : registeredVehicles){
            result += registeredVehicle.toString()+"\n";
        }
        return result;
    }
    
    public String printReservations() {
    String result = "";
    for(RegisteredVehicle registeredVehicle : registeredVehicles)
        result += registeredVehicle.printReservations();
    return result;
    }
    
    public ArrayList<String> getRegisteredVehicleStringList() {
    String result;
    ArrayList<String> helpRegisteredVehicleList  = new ArrayList<>();

    for (RegisteredVehicle registeredVehicle : registeredVehicles) {
        helpRegisteredVehicleList.add(registeredVehicle.toString());
    }
    return null;
    }
    /*
    private RegisteredVehicle earchReservedRegisteredVehicle(String[] data2, LocalDate rentingDate, LocalDate returnDate){
        Factory factory = new Factory();
        Reservation helpReservation = factory.createReservation(data2, rentingDate, returnDate);
        for(RegisteredVehicle registeredVehicle : registeredVehicles){
            if (registeredVehicle.searchReservation(helpReservation) != null);
                return registeredVehicle;
        }
        return null;
    }*/
}
