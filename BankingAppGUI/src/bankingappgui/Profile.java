/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappgui;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author Bethany
 */
public class Profile {
 /**
 * OVERVIEW.
 * Mutable Class. This class creates and reads profiles of customers
 */
    
    public String fileUser;
    public String filePass;
    
    public void makeFile(String username, String password) {
    /**
     * EFFECTS: creates a file in the project containing customers username
     *          and password
     * MODIFES: project file - adds a file to the project
     * REQUIRES: and any String parameter must not be empty
    */
        try {
            String filename = (username);
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.print(username + " " + password);
            pw.close();
            
        } catch (IOException e){
            System.out.println("ERROR!");
        }    
    }
    
    public void readFile(String filename) throws IOException {
    /**
     * EFFECTS: finds a customer profile in the project and takes username and
     *          password as individual String objects for credential validation 
     *          during login
     * MODIFES: 
     * REQUIRES: and any String parameter must not be empty
    */
        try {
            Scanner line = new Scanner(new File(filename));
            this.fileUser = line.next();
            this.filePass = line.next();
            System.out.println(fileUser + " " + filePass);
            line.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        } 
    }
    
}
    
   
