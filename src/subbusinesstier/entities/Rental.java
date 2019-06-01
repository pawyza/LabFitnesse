/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

/**
 *
 * @author kamil
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rental {

    private String condition;
    private Reservation reservation;
    private double cost;

    public Rental(String condition, Reservation reservation, double cost) {
        this.condition = condition;
        this.reservation = reservation;
        this.cost = cost;
    }

    
    
    public Reservation getReservation() {
        return reservation;
    }

    public Rental() {
    }
    
    /**
     *
     * @param reservation
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return -reservation.getNumber();
    }

    /**
     *
     * @param obj
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (getReservation().getNumber() == ((Rental) o).getReservation().getNumber()) {
                result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return reservation.toString() + " Cost: " + getCost() + " Condition: " + getCondition();
    }
}
