/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import coe528.lab1.Flight;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author basantos
 */
public class FlightTest {
    
    Flight flight = new Flight(1, "a", "b", "2:00pm", 100, 100.00);    

    /**
     * Test of the constructor, of class Flight.
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testInvalidConstructor() {
        System.out.println("* FlightJUnit4Test: invalidConstructor");
        Flight flight = new Flight(1, "a", "a", "2:00pm", 100, 100.00);
    }
    
    /**
     * Test of the constructor, of class Flight.
     */
    @Test
    public void testConstructor() {
        System.out.println("* FlightJUnit4Test: validConstructor");
        Flight flight = new Flight(1, "a", "b", "2:00pm", 100, 100.00);
        String expResult = "Flight 1, a to b, 2:00pm, originalPrice: $100.0";
        assertEquals(expResult, flight.toString());
    }
    
    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("* FlightJUnit4Test: bookASeat()");
        assertEquals(true, flight.bookASeat());
        flight.setNumberOfSeatsLeft(0);
        assertEquals(false, flight.bookASeat());
    }
     
    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("* FlightJUnit4Test: toString()");
        String expResult = "Flight 1, a to b, 2:00pm, originalPrice: $100.0";
        assertEquals(expResult, flight.toString());
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("* FlightJUnit4Test: getFlightNumber()");
        assertEquals(1, flight.getFlightNumber());
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("* FlightJUnit4Test: setFlightNumber()");
        int flightNumber = 0;
        flight.setFlightNumber(flightNumber);
        assertEquals(0, flight.getFlightNumber());
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("* FlightJUnit4Test: getOrigin()");
        assertEquals("a", flight.getOrigin());
        String newOrigin = "c";
        flight.setOrigin(newOrigin);
        assertEquals(newOrigin, flight.getOrigin());
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("* FlightJUnit4Test: setOrigin()");
        String newOrigin = "originA";
        flight.setOrigin(newOrigin);
        assertEquals(newOrigin, flight.getOrigin());
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("* FlightJUnit4Test: getDestination()");
        assertEquals("b", flight.getDestination());
        String newDestination = "d";
        flight.setDestination(newDestination);
        assertEquals(newDestination, flight.getDestination());
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("* FlightJUnit4Test: setDestination()");
        String destination = "e";
        flight.setDestination(destination);
        assertEquals(destination,flight.getDestination());
        }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("* FlightJUnit4Test: getDepartureTime()");
        assertEquals("2:00pm", flight.getDepartureTime());
        }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("* FlightJUnit4Test: setDepartureTime()");
        String departureTime = "3:00pm";
        flight.setDepartureTime(departureTime);
        assertEquals("3:00pm", flight.getDepartureTime());
        }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("* FlightJUnit4Test: getCapacity()");
        assertEquals(100, flight.getCapacity());
        }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("* FlightJUnit4Test: setCapacity()");
        int capacity = 10;
        flight.setCapacity(capacity);
        assertEquals(capacity,flight.getCapacity());
        }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("* FlightJUnit4Test: getNumberOfSeatsLeft()");
        assertEquals(100, flight.getNumberOfSeatsLeft());
        }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("* FlightJUnit4Test: setNumberOfSeatsLeft()");
        int numberOfSeatsLeft = 99;
        flight.setNumberOfSeatsLeft(numberOfSeatsLeft);
        assertEquals(99, flight.getNumberOfSeatsLeft());
        }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("* FlightJUnit4Test: getOriginalPrice()");
        assertEquals(100.00, flight.getOriginalPrice(),0.0);
        }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("* FlightJUnit4Test: setOriginalPrice()");
        double originalPrice = 90.0;
        flight.setOriginalPrice(originalPrice);
        assertEquals(90.0, flight.getOriginalPrice(),0.0);
        }
    
}
