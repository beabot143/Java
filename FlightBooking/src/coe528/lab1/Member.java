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
public class Member extends Passenger {
    
    protected int yearsOfMembership;

    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) {
            return (p*0.5);
        }
        if(yearsOfMembership > 1 && yearsOfMembership <=5) {
            return (p*0.1);
        }
        else
            return p;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    
    
}
