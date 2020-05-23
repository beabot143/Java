/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappgui;

/**
 *
 * @author Bethany
 */
public class Account extends Customer{
 /**
 * OVERVIEW.
 * Mutable Class and represents a bank account of a customer
 * An account can be credited or debited a specified amount
 */
    
    public double accountBalance;
    public String accountName; 
    
    public Account() {
        this.accountBalance = 0.0;
    }
    
    public void debit(double amount) {
    /**
     * EFFECTS: removes money to this account
     * MODIFES: account balance
     * REQUIRES: positive amount
    */
        this.accountBalance = this.accountBalance - amount;
    }
    
    public void credit(double amount) {
    /**
     * EFFECTS: adds money to this account
     * MODIFES: account balance
     * REQUIRES: positive amount
    */
        this.accountBalance = this.accountBalance + amount;
    }

    public void setAccountName(String accountName) {
    /**
     * REQUIRES: any String parameter must not be empty
    */
        this.accountName = accountName;
    }
    
    public double getAccountBalance() {
        return this.accountBalance;
    }

    public String getAccountName() {
        return this.accountName;
    }
    
    @Override
    public String toString() {
        return "Account{" + "accountBalance=" + this.accountBalance + ", accountName=" + this.accountName + '}';
    }
}
