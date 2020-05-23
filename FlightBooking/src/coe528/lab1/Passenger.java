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
public abstract class Passenger {
    
    protected String name;
    protected int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract double applyDiscount(double p);
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
