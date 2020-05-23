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
public interface MembershipState {
 /**
 * OVERVIEW.
 * Interface class that depicts the different fees involved with purchasing
 * depending on the customers membership states
 */
    public void purchase(Account account, double amount);
    
}
