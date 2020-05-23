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
public class Flight {
    
    protected int flightNumber;
    protected String origin;
    protected String destination;
    protected String departureTime;
    protected int capacity;
    protected int numberOfSeatsLeft;
    protected double originalPrice;
    
    public Flight(int flightNumber, String origin, String destination, 
            String departureTime, int capacity, double originalPrice) {
        
        if (origin.equals(destination)) {
            throw new IllegalArgumentException("The destinaton is the same as "
                    + "the origin.");
        }        
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat() {
        if (numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return ("Flight " + Integer.toString(flightNumber) + ", " + origin + 
                " to " + destination + ", " + departureTime + 
                ", originalPrice: $"+ Double.toString(originalPrice));   
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    
}
