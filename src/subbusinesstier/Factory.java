package subbusinesstier;

import subbusinesstier.entities.Vehicle;
import subbusinesstier.entities.Reservation;
import subbusinesstier.entities.RegisteredVehicle;

import java.time.LocalDate;
import java.util.IllegalFormatCodePointException;
import subbusinesstier.entities.Rental;

/**
 * PU:
 * Dodawanie_pojazdu,Rezerwacja
 */
public class Factory {

    /**
     * @param data
     */
    public Vehicle createVehicle(String[] data) {
        // TODO - implement Factory.createVehicle
        Vehicle vehicle = null;
        switch (Integer.parseInt(data[0])) {
            case 0:
                vehicle = new Vehicle();
                vehicle.setBrand(data[1]);
                vehicle.setModel(data[2]);
                break;
            case 1:
                vehicle = new Vehicle();
                vehicle.setBrand(data[1]);
                vehicle.setModel(data[2]);
                vehicle.setColor(data[3]);
                vehicle.setSeatsNumber(Integer.parseInt(data[4]));
                vehicle.setDoorsNumber(Integer.parseInt(data[5]));
                vehicle.setCarType(data[6]);
                break;
            case 2:
                vehicle = new Vehicle();
                vehicle.setBrand(data[1]);
                vehicle.setModel(data[2]);
                vehicle.setEngineType(data[3]);
                vehicle.setEngineCapacity(Double.parseDouble(data[4]));
                break;
            case 3:
                vehicle = new Vehicle();
                vehicle.setBrand(data[1]);
                vehicle.setModel(data[2]);
                vehicle.setColor(data[3]);
                vehicle.setSeatsNumber(Integer.parseInt(data[4]));
                vehicle.setDoorsNumber(Integer.parseInt(data[5]));
                vehicle.setEngineType(data[6]);
                vehicle.setEngineCapacity(Double.parseDouble(data[7]));
                vehicle.setCarType(data[8]);
                break;
                default:
                       throw new IllegalFormatCodePointException(0);

        }
        return vehicle;
    }

    /**
     * @param data
     * @return 
     */
    public RegisteredVehicle createRegisteredVehicle(String[] data) {

        RegisteredVehicle registeredVehicle = null;
        switch (Integer.parseInt(data[0])) {
            case 0:
                registeredVehicle = new RegisteredVehicle();
                registeredVehicle.setRegistrationNumber(data[1]);
                                break;
                default:
                       throw new IllegalFormatCodePointException(0);


        }
        return registeredVehicle;
    }

    /**
     * @param data
     * @param number
     * @param date
     * @return 
     */
    public Reservation createReservation(String[] data, LocalDate rentingDate, LocalDate returnDate) {
         
        Reservation reservation = null;
        reservation = new Reservation();
        reservation.setNumber(Integer.parseInt(data[0])+Integer.parseInt(data[3]));
        reservation.setRentingDate(rentingDate);
        reservation.setReturnDate(returnDate);
        reservation.setClientIdNumber(Integer.parseInt(data[0]));
        reservation.setForename(data[1]);
        reservation.setSurname(data[2]);
        reservation.setPhoneNumber(Integer.parseInt(data[3]));
        return reservation;
    
    }

    
     /**
     * @param reservation
     * @param returnDate
     */

   

    public Rental creatRental(Reservation reservation,String condition, Double cost){
        Rental rental = null;
        rental = new Rental();
        rental.setCondition(condition);
        rental.setCost(cost);
        rental.setReservation(reservation);
        return rental;
    }
}
