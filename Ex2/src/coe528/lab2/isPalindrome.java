/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

import com.sun.istack.internal.Nullable;
import java.util.Scanner;

/**
 *
 * @author basantos
 */
public class isPalindrome {
    
    //Requires: String a to not be empty    
    //Modifies: n/a    
    //Effects:  Determines if a string is a palindrome(true) or not(false)   
    
    public static boolean isPalindrome( String a) {
        char [] letter = a.toCharArray();
        
        //TEST (REMOVE LATER)
//        for (char chars : letter) {
//            System.out.println(chars);
//        }

        if(letter.length == 0 || a == null) {
            return false;
        }
        int split = letter.length / 2;
        int counter = 0;
        for(int i = 0; i<split; i++) {
            if(letter[i] == letter[letter.length - (i+1)]) {
                counter++;
            }
        }
        return (counter  == split);
    }
    
    public static void main(String[] args) {
        System.out.print("Waiting for input: ");
        boolean state = true;
        while (state) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            
            switch(input) {

                case "1":
                    System.out.println(isPalindrome(null));
                    break;
                case "2":
                    System.out.println(isPalindrome(""));
                    break;
                case "3":
                    System.out.println(isPalindrome("deed"));
                    break;
                case "4":
                    System.out.println(isPalindrome("abdc"));
                    break;
                case "e":
                    state = false;
                    break;
            }
            System.out.print("Waiting for input: ");            
        }
            
        
        
        
        
        
        
        
//        if(args.length == 1) {            
//            if (args[0].equals("1")) {                
//                System.out.println(isPalindrome(null));
//            }
//        }            
//        else if (args[0].equals("2"))                 
//            System.out.println(isPalindrome(""));            
//        else if (args[0].equals("3"))                 
//            System.out.println(isPalindrome("deed"));            
//        else if (args[0].equals("4"))                
//            System.out.println(isPalindrome("abcd"));        
    }
}

// Expected Input and Output of program:
    // Command Line Argument            Output
    //          1                       False
    //          2                       False
    //          3                       True
    //          4                       False