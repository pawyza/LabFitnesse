package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import subbusinesstier.Factory;

/**
 * PU: Wyszukaj_wypo�yczenia, Wyszukaj_rezerwacji, Zwrot_pojazdu,
 * Anulowanie_rezerwacji, Wypo�yczenie_rezerwacji,
 * Skontatkuj_si�_z_klientem,Rezerwacja
 */
public class Reservation {


    private int number;
    private RegisteredVehicle registeredVehicle;
    private int clientIdNumber;
    private String surname;
    private String forename;
    private int phoneNumber;
    private LocalDate rentingDate;
    private LocalDate returnDate;
    private Rental rental;

    public Reservation() {
    }

    public Reservation(String clientIdNumber, String surname, String forename, String phoneNumber,LocalDate rentingDate, LocalDate returnDate) {
        this.clientIdNumber = Integer.parseInt(clientIdNumber);
        this.surname = surname;
        this.forename = forename;
        this.phoneNumber = Integer.parseInt(phoneNumber);
        this.rentingDate = rentingDate;
        this.returnDate = returnDate;
    }

    public RegisteredVehicle getRegisteredVehicle() {
        return this.registeredVehicle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRegisteredVehicle(RegisteredVehicle registeredVehicle) {
        this.registeredVehicle = registeredVehicle;
    }

    public int getClientIdNumber() {
        return this.clientIdNumber;
    }

    public void setClientIdNumber(int clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return this.forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getRentingDate() {
        return this.rentingDate;
    }

    public void setRentingDate(LocalDate date) {
        this.rentingDate = date;
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    public Rental getRental() {
        return rental;
    }
    public void setRental(Rental rental) {
        this.rental = rental;
    }
        
    public String addRental(Reservation reservation, String condition, Double cost){
        Factory factory = new Factory();
        Rental newRental;
        newRental = factory.creatRental(reservation, condition, cost);
        rental = newRental;
        return newRental.toString();
    }
        

    public int hashCode() {
        return number;
    }

    /**
     *
     * @param obj
     */
    public boolean equals(Object obj) {
        boolean result = false;
        if (getNumber() == ((Reservation) obj).getNumber()) {
            result = true;
        }
        return result;
    }

    public String toString() {
        return  registeredVehicle.toString() + "Forename: " + getForename() + " Surname: " + getSurname() + " Number: " + getNumber() + " Renting Date: " + getRentingDate() + " Return Date: " + getReturnDate();
    }

    /**
     *
     * @param date
     */
    public boolean isFree(LocalDate rentingDate) {
        if(getReturnDate() != null){
            if (getReturnDate().isBefore(rentingDate))
                return true;
            else
                return false;
        } else {
            System.out.println("nope");
            return true;
        }
    }

}
