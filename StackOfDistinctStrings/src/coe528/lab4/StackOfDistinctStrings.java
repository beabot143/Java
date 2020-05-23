/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab4;

import java.util.ArrayList;

/**
 *
 * @author Bethany
 */
public class StackOfDistinctStrings {
    // Overview: StackOfDistinctStrings are mutable, bounded collection of 
    //           distinct strings that operate in LIFO (Last-In-First-Out) order.
    
    // Abbstraction function:
        // AF(stringElement) = {Strings} belonging to String Space Set where each 
        //               element is unique
        // stringArray.top = stringArray.get(stringArray.size() -1)
    
    // Rep Invariant:
        // stringElement != null
        // stringElement.top = stringArray[length -1]
        // push(stringElement) = true iff stringElement does not already exist 
        //                          in the stringArray
    
    // The rep
    private ArrayList<String> items;

    public StackOfDistinctStrings() {
        items = new ArrayList<String>();
    }
    
    public void push(String element) throws Exception {
        // MODIFIES: this
        // EFFECTS: Appends the element at the top of the stack         
        //          if the element is not in the stack, otherwise        
        //          does nothing.        
        if(element == null) throw new Exception();        
        if(false == items.contains(element))             
            items.add(element);
    }      
    
    public String pop() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the top of the stack 
        if (items.size() == 0) throw  new Exception();
        return items.remove(items.size()-1);
    }
              
    public boolean repOK() {
        // EFFECTS: Returns true if the rep invariant holds for this object
        //         otherwise returns false
        
        for (int i=0; i<items.size(); i++) {
            for (int j=1; j<items.size(); j++) {
                if (items.get(i).equals(items.get(i+j))) {
                    return false;
                }
            }
        }
    }
    
    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the stack and
        //          and the top element. Implememnts the abstraction function.
        System.out.println(items.get(0) + " <== TOP"); 
        
        for (int i=0; i<items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
    
}


