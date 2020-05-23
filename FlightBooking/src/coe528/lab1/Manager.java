/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author basantos
 */
public class Manager {
    
    ArrayList <Flight> flights = new ArrayList <>();
    ArrayList <Ticket> tickets = new ArrayList <>();
    
    Scanner in = new Scanner(System.in);
    
    public void createFlights() {
        // Preset mode
//        Flight flight1 = new Flight(1030, "Toronto", "Kolkata", 
//                "03/02/99 7:50 pm", 100, 1000);
//        Flight flight2 = new Flight(1040, "Tokyo", "Tokyo", 
//                "01/01/20 10:00 am", 200, 1000);
//        Flight flight3 = new Flight(1050, "London", "Manila",
//                "12/12/20 3:00 pm", 0, 1000);
        
        System.out.println("Please Input the Flight Information");
        System.out.print("Flight Number: ");
        int flightNumber = in.nextInt();
        in.nextLine();
        System.out.print("Origin: ");
        String origin = in.nextLine();
        System.out.print("Destination: ");
        String destination = in.nextLine();
        System.out.print("Departure time (format: DD/MM/YYYY hh:mm am/pm): ");
        String departureTime = in.nextLine();
        System.out.print("Capacity of Plane: ");
        int capacity = in.nextInt();
        in.nextLine();
        System.out.print("Original Ticket Price: ");
        double originalPrice = in.nextDouble();
    
        flights.add(new Flight(flightNumber, origin, destination, departureTime,
        capacity, originalPrice));
        
        System.out.println("\n\t **Flight has been added to system**");
    }
    
    public void displayAvailableFlights(String origin, String destination) {
        for (Flight i : flights) {
            if (i.getOrigin().equals(origin) 
                    && i.getDestination().equals(destination)
                    && i.getNumberOfSeatsLeft() != 0 ) {
                System.out.println("\n\t" + i.toString());
            }
        }
    }
    
    public Flight getFlight (int flightNumber) {
        Flight flight = null;
        for (Flight i : flights) {
            if (i.getFlightNumber() == flightNumber) {
                flight = i;
                break;
            }
        }    
        if (flight == null) {
            System.out.println("There are no flights under this flight number.");
        }
        return (flight);
    }
    
    public void bookSeat(int flightNumber, Passenger p) {
        Flight flight = getFlight(flightNumber);
        double price = p.applyDiscount(flight.getOriginalPrice());
        tickets.add(new Ticket(p, flight, price));
        System.out.println("\nTicket Price for " + p.getName() + " : $" + price);
        System.out.println("\n\t **Ticket has been added to system**");
    }
  
    public static void main(String [] args) {
      
        boolean enableGUI = true;
        
        Manager manager = new Manager();
        System.out.println("Enter one of the following options:\n\t"
                + "a - Create a Flight\n\t"
                + "b - Display all available flights of a trip\n\t"
                + "c - Book a seat for a passeger\n\t"
                + "e - Exit");
        
        while (enableGUI) {
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();
            
            switch(option) {
                case "a":
                    System.out.println("---CREATE A FLIGHT---");
                    manager.createFlights();
                    break;
                
                case "b":
                    System.out.println("---DISPLAY AVAILABLE FLIGHTS---");
                    System.out.print("Enter Flight Origin: ");
                    String origin = input.nextLine();
                    System.out.print("Enter flight Desitnation: ");
                    String destination = input.nextLine();
                    manager.displayAvailableFlights(origin, destination);
                    break;
                
                case "c":
                    Flight bookFlight = null;
                    System.out.println("---BOOK A SEAT---");
                    System.out.print("Enter flight number: ");
                    int flightNumber = input.nextInt();
                    input.nextLine();
                    bookFlight = manager.getFlight(flightNumber);

                    if (bookFlight != null && bookFlight.bookASeat() == false) {
                        System.out.println("Flight is full. Cannot book a seat");
                        break;
                    }
                    if (bookFlight == null) {
                        break;
                    }
                    else {
                        System.out.print("Enter Passenger Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter passenger age: ");
                        int age = input.nextInt();
                        input.nextLine();
                        System.out.print("Is the passenger a member? (y/n): ");
                        String isMember = input.nextLine();

                        if (isMember.equals("y")){
                            System.out.print("Enter years of membership: ");
                            int yearsOfMembership = input.nextInt();
                            manager.bookSeat(flightNumber, new Member(name,age,yearsOfMembership));
                        }
                        else {
                            manager.bookSeat(flightNumber, new NonMember(name, age));
                        }
                    }
                    break;
                case "e":
                    System.out.println("Exitting...");
                    enableGUI = false;  
                    break;
            }
            System.out.print("\nPlease enter new option: ");
        }
    }
}
