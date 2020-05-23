/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappgui;

import java.util.HashMap;
import java.io.*;

/**
 *
 * @author Bethany
 */
public class Customer implements MembershipState{
    
 /**
 * OVERVIEW.
 * Mutable Class and represents a customer with an existing bank account, 
 * profile, and a type of membership. Customer is able to deposit, withdraw and 
 * purchase using funds from existing accounts.
 */
    
    private String firstName;
    private String lastName;
    private double totalBalance;
    MembershipState membershipState;
    HashMap <String, Account> accounts;
    private String username;
    private String password;
    private String role;
    
    
    public Customer() {
        this.accounts = new HashMap<>();
    }
    
    public void deposit(Account account, double amount) {
    /**
     * EFFECTS: Adds money to specified account
     * MODIFES: account balance
     * REQUIRES: positive amount
    */
        account.credit(amount);
    }
    
    public void withdraw(Account account, double amount) {
    /**
     * EFFECTS: Removes money to specified account
     * MODIFES: account balance
     * REQUIRES: positive amount
    */
        if (enoughFunds(account, amount)) {
            account.debit(amount);
        } else {
            System.out.println("Not enough funds to perform transaction.");
        }
    }
    
    @Override
    public void purchase(Account account, double amount) {
    /**
     * EFFECTS: Removes money to specified account
     * MODIFES: account balance
     * REQUIRES: positive amount
    */
        membershipState.purchase(account, amount);
    }
      
    public boolean enoughFunds(Account account, double amount) {
    /**
     * EFFECTS: Returns true if there is enough money in an account before a
     * withdrawal or purchase, returns false otherwise
     * MODIFES: none
     * REQUIRES: positive amount
    */
        return (account.getAccountBalance() - amount >= 0);
    }
    
    public double getTotalBalance() {
    /**
     * EFFECTS: adds all account balances
     * MODIFES: total balance
     * REQUIRES: 
    */
        double sum = 0.0;
        for(Account acc : accounts.values()){
            sum = sum + acc.getAccountBalance();   
        }
        this.totalBalance = sum;
        return (this.totalBalance);
    }

    public void listAllAccounts() {
         for(Account acc : this.accounts.values()) {
            System.out.println(acc);
        }
    }
    
    public void update() {
    /**
     * EFFECTS: Updates the customers membership status based on total Balance
     * MODIFES: Membership State
     * REQUIRES: 
    */
        getTotalBalance();        
        if(this.totalBalance <= 10000.00) {
            this.membershipState = new SilverMember();
        } else if (this.totalBalance > 10000.00 && this.totalBalance <= 20000.00) {
            this.membershipState = new GoldMember();
        } else {
            this.membershipState = new PlatinumMember();
        }
    }
    
    public void setFirstName(String firstName) {
    /**
     * REQUIRES: any String parameter must not be empty
    */
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
    /**
     * REQUIRES: any String parameter must not be empty
    */
        this.lastName = lastName;
    }

    public void setUsername(String username) {
    /**
     * REQUIRES: any String parameter must not be empty
    */
        this.username = username;
        
    }

    public void setPassword(String password) {
    /**
     * REQUIRES: any String parameter must not be empty
    */
        this.password = password;
    }
    
    public void setRole(String role) {
    /**
     * REQUIRES: any String parameter must not be empty
    */
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", totalBalance=" + totalBalance + ", membershipState=" + this.membershipState + ", accounts=" + accounts + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
  
    
}
