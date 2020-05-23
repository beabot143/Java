/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappgui;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Bethany
 */
public class Manager {
 /**
 * OVERVIEW.
 * Immutable class. Manager class creates or deleted customers, as well as 
 * opens accounts for customers
 */
    
    private final String firstName;
    private final String lastName;
    private String username;
    private String password;
    private String role;
    HashMap<String, Customer> customers = new HashMap<>();

    public Manager(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = "admin";
        this.password = "admin";
        this.role = "manager";
    }

    public void addCustomer(Customer customer, String firstName, String lastName, String username, String password, Account account, String accountName) {
    /**
     * EFFECTS: creates a new customer with a new profile and one new account
     *          with added $100 to the new account
     * MODIFES: project file - adds new profile
     *          accounts - adds a new account object to the accounts hash map
     *          Total and account balances
     * REQUIRES: When using GUI, account name only allows for "Checkings" or 
     *           "Savings" and any String parameter must not be empty
    */    
        // Set up Customer object
        customers.put(username, customer);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        
        // Set up customer profile
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setRole("customer");
        Profile profile = new Profile();
        profile.makeFile(username, password);
                
         
        // Open initial Account with $100.00 deposit
        openAccount(customer, account, accountName);
        customer.deposit(account, 100);
        customer.update();
    }
    
    public void openAccount(Customer customer, Account account, String accountName) {
    /**
     * EFFECTS: opens an account for customer
     * MODIFES: accounts - adds a new account object to the accounts hash map
     * REQUIRES: When using GUI, account name only allows for "Checkings" or 
     *           "Savings" and any String parameter must not be empty
    */
        customer.accounts.put(accountName, account);
        customer.accounts.get(accountName).setAccountName(accountName);
    }
    
    public void deleteCustomer(String username) {
    /**
     * EFFECTS: deletes customer profile and all accounts of the customer
     * MODIFES: accounts - removes account object from accounts hash map
     *          project file - removes customer profile from project file
     * REQUIRES: username must not be empty
    */
        String filename = (username);
        File file = new File(filename);
        file.delete();
        customers.get(username).accounts.clear();
        customers.remove(username);
    }
    
    public void listAllCustomers() {
        for(Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }
    

    
}
