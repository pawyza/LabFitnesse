package subbusinesstier.entities;


import java.time.LocalDate;
import java.util.*;

/**
 * PU:
 * Modyfikacja_stanu_pojazdu, Dodawanie_pojazdu, Usuwanie_pojazdu, Wyszukaj_pojazd, Operacje_na_pojazdach, Wyszukaj_wypo?yczenia, Wyszukaj_rezerwacje, Rezerwacja
 */
public class RegisteredVehicle {

    private String registrationNumber;
    private ArrayList<Reservation> reservations = new ArrayList();
    private Vehicle vehicle;

    public RegisteredVehicle(String registrationNumber, Vehicle vehicle) {
        this.registrationNumber = registrationNumber;
        this.vehicle = vehicle;
    }

    public RegisteredVehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    
    
    public String getRegistrationNumber() {
            return this.registrationNumber;
    }

    public ArrayList<Reservation> getReservations() {
            return this.reservations;
    }

    /**
     * 
     * @param reservations
     */
    public void setReservations(ArrayList<Reservation> reservations) {
            this.reservations = reservations;
    }

    public RegisteredVehicle() {
    }

    @Override
    public int hashCode() {
            return Integer.parseInt(registrationNumber);
    }

    public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
            if (getRegistrationNumber().equals(((RegisteredVehicle) obj).getRegistrationNumber())) {
                            return true;
            }
            return false;
    }

    @Override
    public String toString() {
            return String.format("Registration number: %s ",registrationNumber+" "+ vehicle.toString());
    }
    
    /**
     * 
     * @param date
     * @return 
     */
    public boolean isFree(LocalDate date) {
    Reservation reservation;
    boolean result = true;
    for (int i = 0; i < reservations.size(); i++) {
        reservation = reservations.get(i);
        if (!reservation.isFree(date)) {
            result = false;
        }
    }
    return result;
    }

    /**
     * 
     * @param reservation
     */
    public void addReservation(Reservation reservation) {
        reservation.setRegisteredVehicle(this);
        reservations.add(reservation);
    }
    
    public Reservation searchReservation(Reservation reservation){
        Reservation result = null;
        int index;
        if((index = reservations.indexOf(reservation)) != -1){
            result = reservations.get(index);
        }
        return result;
    }

    public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
    }
    
    public ArrayList<String> getReservationsStringList(){
        ArrayList<String> helpReservations = new ArrayList<>();
        for(Reservation reservation : reservations){
            helpReservations.add(reservation.toString());
        }
        return helpReservations;
    }

    public String printReservations() {
    String result = "";
    for(Reservation reservation : reservations)
        result += reservation.toString()+"\n";
    return result;
    }
}