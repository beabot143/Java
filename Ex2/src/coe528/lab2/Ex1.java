/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

/**
 *
 * @author basantos
 */
public class Ex1 {
    
    //Requires: Input must be integers and cannot be empty.
    //Modifies: Modifies array a.     
    //Effects:  Determines the index of the first max integer in array a and  
    //          sets it to the max int value from array b.
    
    public static void substituteMax(int[] a, int[] b) {        
	int maxOfA = a[0];        
	int index = 0;        
	for (int i = 0; i < a.length; i++) {            
		if(a[i] > maxOfA) {                
			maxOfA = a[i];                
			index = i;            
		}        
	}        
	int maxOfB = b[0];        
	for (int i = 0; i < b.length; i++) {            
		if(b[i] > maxOfB) {                
			maxOfB = b[i];            
		}        
	}        
	a[index] = maxOfB;    
}
    
    public static void main (String [] args) {
        int [] a = {34,34,1};
        int [] b = {1, 10, 2};
        
        substituteMax(a, b);
        
        for(int i : a) {
            System.out.println(i);
        }
        for(int i : b) {
            System.out.println(i);
        }
        
    }
    
}


