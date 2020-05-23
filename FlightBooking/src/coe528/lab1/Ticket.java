/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author basantos
 */
public class Ticket {
    
    protected Passenger passenger;
    protected Flight flight;
    protected double price;
    protected static int number = 0;

    public Ticket(Passenger passenger, Flight flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        number++;
    }
    
    @Override
    public String toString() {
        return(flight.toString() + " ticket price: $" 
                + Double.toString(price));
    }
    
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }
    
}
