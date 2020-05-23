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
public class PlatinumMember extends Customer {
 /**
 * OVERVIEW.
 * Implements the conditions for purchasing transaction of a platinum member
 */
    
    private final int fee = 0;
    public String membershipType = "Platinum";

    public PlatinumMember() {
    }
    
    @Override
    public void purchase(Account account, double amount){
    /**
     * EFFECTS: removes money from specified account with an added fee based on 
     *          the membership state of the customer
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
    public String toString() {
        return "{" + "membershipType=" + membershipType + '}';
    }
    
    
}
