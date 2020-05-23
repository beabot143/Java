/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingappgui;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class BankingAppGUI extends Application {
 /**
 * OVERVIEW.
 * Graphic User Interface for the Banking application. Customers login, logout, 
 * and perform transactions such as deposit, withdraw, or purchase. Managers can
 * login, logout, and create, or delete customers from the system.
 */
    
    Stage window;
    Scene loginPage;
    Scene customerHomePage, depositPage, withdrawPage, purchasePage;
    Scene managerHomePage;
    Customer currentCustomer;
    
    public static void main (String[] args) throws IOException {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Manager manager = new Manager("Bethany", "Santos");
      
        // Setup Existing Customer Billy
        Customer billy = new Customer();
        Account billyCheckings = new Account();        
        Account billySavings = new Account();
        manager.addCustomer(billy,"Billy", "Jean", "billy.jean", "billypass", billyCheckings, "Checkings");
        manager.openAccount(billy, billySavings, "Savings");
        billy.deposit(billyCheckings, 10000);
        billy.deposit(billySavings, 40000.00);
        billy.update();
        
        // Setup existone cutomer Mark
        Customer mark = new Customer();
        Account markCheckings = new Account();
        Account markSavings = new Account();
        manager.addCustomer(mark, "Mark", "Stevens", "mark.stevens", "markpass", markCheckings, "Checkings");
        manager.openAccount(mark, markSavings, "Savings");        
        mark.deposit(markCheckings,5000.00);
        mark.deposit(markSavings, 10000.00);
        mark.update();
        
        // Setup existing cutomer Ann
        Customer ann = new Customer();
        Account annCheckings = new Account();
        Account annSavings = new Account();
        manager.addCustomer(ann, "Ann", "Smith", "ann.smiths", "annpass", annCheckings, "Checkings");
        manager.openAccount(ann, annSavings, "Savings");
        ann.deposit(annCheckings, 1000);
        ann.deposit(annSavings, 2000);
        ann.update();
              
        //TESTS//
        Account acc = (Account)ann.accounts.get("Savings");
        System.out.println(acc);
        //manager.listAllCustomers();
        
        
        window = new Stage();
        window = primaryStage;
        
        // Components of Login page
        Label userLabel = new Label("Username");
        TextField userInput = new TextField();
        userInput.setPromptText("Enter Username");
        Label passLabel = new Label("Password");
        TextField passInput = new TextField();
        passInput.setPromptText("Enter Password");
        Button loginBtn = new Button("LOGIN");
        
        GridPane loginLayout = new GridPane();
        loginLayout.setPadding(new Insets(20, 20, 20, 20));
        loginLayout.setVgap(8);
        loginLayout.setHgap(10);
        loginLayout.getChildren().addAll(userLabel, userInput, passLabel, passInput, loginBtn);
        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(userInput, 2, 0);
        GridPane.setConstraints(passLabel, 0, 1);
        GridPane.setConstraints(passInput, 2, 1);
        GridPane.setConstraints(loginBtn, 2, 3);
        
        loginPage = new Scene(loginLayout, 300, 150);
        
        loginBtn.setOnAction(e -> {
            String username = userInput.getText();
            String password = passInput.getText();
            Profile profile = new Profile();
          
            try {
                profile.readFile(username);
            } catch (IOException ex) {
                Logger.getLogger(BankingAppGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(username.equals(profile.fileUser) && password.equals(profile.filePass)) {
                this.currentCustomer = manager.customers.get(username);
                window.setScene(customerHomePage);
            } else if ("admin".equals(username) && "admin".equals(password)) {
                window.setScene(managerHomePage);
            } else {
                AlertBox invalidCredentialsAlert = new AlertBox();
                invalidCredentialsAlert.display("Username or Password Error", "The username or password you have entered \ndoes not exist or is incorrect. \nPlease re-enter credentials");  
            }
        });
     
        // Components of customer home page
        Label amount = new Label("Amount");
        TextField amountInput = new TextField();
        Label sourceAcc = new Label("From Account/To Account");
        ComboBox<String> accounts = new ComboBox<>();
        accounts.setPromptText("Select Account");  
        accounts.getItems().addAll("Checkings","Savings");
        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");
        Button purchaseBtn = new Button("Purchase");
        Button showBalanceBtn = new Button("Show Account Balances");
        Button logoutBtn = new Button("LOGOUT");
        
        
        GridPane customerHomePageLayout = new GridPane();
        customerHomePageLayout.setPadding(new Insets(20, 20, 20, 20));
        customerHomePageLayout.setVgap(8);
        customerHomePageLayout.setHgap(10);
        customerHomePageLayout.getChildren().addAll(depositBtn, withdrawBtn, purchaseBtn, accounts,amount,amountInput,sourceAcc,showBalanceBtn, logoutBtn);
        GridPane.setConstraints(depositBtn, 4, 0);
        GridPane.setConstraints(withdrawBtn, 4, 1);
        GridPane.setConstraints(purchaseBtn, 4, 2);
        GridPane.setConstraints(amount, 0, 0);
        GridPane.setConstraints(amountInput, 1, 0);
        GridPane.setConstraints(sourceAcc, 0, 1);
        GridPane.setConstraints(accounts, 1, 1);
        GridPane.setConstraints(showBalanceBtn, 4, 4);
        GridPane.setConstraints(logoutBtn, 4 , 7);
        
        customerHomePage = new Scene(customerHomePageLayout, 600, 250);
        
        depositBtn.setOnAction(e -> {
            double amt = Double.parseDouble(amountInput.getText());
            String depToAcc = accounts.getValue();
            Account account = currentCustomer.accounts.get(depToAcc);
            System.out.println(currentCustomer.accounts.get(depToAcc));
            System.out.println(amt);
            currentCustomer.deposit(account, amt);
            System.out.println(account);
        });
        
        withdrawBtn.setOnAction(e -> {
            double amt = Double.parseDouble(amountInput.getText());
            String depToAcc = accounts.getValue();
            Account account = currentCustomer.accounts.get(depToAcc);
            System.out.println(currentCustomer.accounts.get(depToAcc));
            System.out.println(amt);
            currentCustomer.withdraw(account, amt);
            System.out.println(account);
        });
        
        purchaseBtn.setOnAction(e -> {
            double amt = Double.parseDouble(amountInput.getText());
            String depToAcc = accounts.getValue();
            Account account = currentCustomer.accounts.get(depToAcc);
            System.out.println(currentCustomer.accounts.get(depToAcc));
            System.out.println(amt);
            currentCustomer.purchase(account, amt);
            System.out.println(account);
        });
        
        showBalanceBtn.setOnAction (e -> {
            currentCustomer.update();
            currentCustomer.getTotalBalance();
            currentCustomer.listAllAccounts();
            manager.listAllCustomers();
        });
        
        logoutBtn.setOnAction(e -> {
            window.setScene(loginPage);
        });
        
              
        // Components of manager home page
        Label addCustomerLabel = new Label("Enter Infromation of \nnew customer below.");
        Label deleteCustomerLabel = new Label("Enter username of customer \nto be deleted below.");
        Button addBtn = new Button("ADD CUSTOMER");
        Button deleteBtn = new Button("DELETE CUSTOMER");
        Label firstNameLabel = new Label("First Name");
        TextField firstNameInput = new TextField();
        Label lastNameLabel = new Label("Last Name");
        TextField lastNameInput = new TextField();
        Label usernameLabel = new Label("Username");
        TextField usernameInput = new TextField();
        Label passwordLabel = new Label("Password");
        TextField passwordInput = new TextField();
        Label accountLabel = new Label("Account Name");
        ComboBox<String> accountDropDown = new ComboBox<>();
        accountDropDown.setPromptText("Select Account");  
        accountDropDown.getItems().addAll("Checkings","Savings");
        Label deleteUsernameLabel = new Label("Username");
        TextField deleteUsernameInput = new TextField();
        Button logoutButton = new Button("LOGOUT");
        
        GridPane managerHomePageLayout = new GridPane();
        managerHomePageLayout.setPadding(new Insets(20, 20, 20, 20));
        managerHomePageLayout.setVgap(8);
        managerHomePageLayout.setHgap(10);
        managerHomePageLayout.getChildren().addAll(addCustomerLabel, deleteCustomerLabel, addBtn, deleteBtn,firstNameLabel,firstNameInput,lastNameLabel,lastNameInput, logoutButton);
        managerHomePageLayout.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput,accountLabel,accountDropDown,deleteUsernameLabel,deleteUsernameInput);
        GridPane.setConstraints(addCustomerLabel, 0, 0);
        GridPane.setConstraints(firstNameLabel, 0, 1);
        GridPane.setConstraints(firstNameInput, 0, 2);
        GridPane.setConstraints(lastNameLabel, 0, 3);
        GridPane.setConstraints(lastNameInput, 0, 4);
        GridPane.setConstraints(usernameLabel, 0, 5);
        GridPane.setConstraints(usernameInput, 0, 6);
        GridPane.setConstraints(passwordLabel, 0, 7);
        GridPane.setConstraints(passwordInput, 0, 8);
        GridPane.setConstraints(accountLabel, 0, 9);
        GridPane.setConstraints(accountDropDown, 0, 10);
        GridPane.setConstraints(addBtn, 0, 12);
        GridPane.setConstraints(deleteCustomerLabel, 1, 0);
        GridPane.setConstraints(deleteUsernameLabel, 1, 1);
        GridPane.setConstraints(deleteUsernameInput, 1, 2);
        GridPane.setConstraints(deleteBtn, 1, 4);
        GridPane.setConstraints(logoutButton, 3, 12);

        
        managerHomePage = new Scene(managerHomePageLayout, 450, 450);
        
        addBtn.setOnAction(e -> {
            String firstName = firstNameInput.getText();
            String lastName = lastNameInput.getText();
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            String accountName = accountDropDown.getValue();
            Account newAccount = new Account();
            Customer newCustomer = new Customer();
            manager.addCustomer(newCustomer, firstName, lastName, username, password, newAccount, accountName);
            newCustomer.update();
            manager.listAllCustomers();
        });
       
        deleteBtn.setOnAction(e -> {
            String deleteUsername = deleteUsernameInput.getText();
            manager.deleteCustomer(deleteUsername);
            manager.listAllCustomers();
        });
        
        logoutButton.setOnAction(e -> {
            window.setScene(loginPage);
        });
        
        window.setTitle("COE Banking Application");
        window.setScene(loginPage);
        window.show();
    }
    
    
}





