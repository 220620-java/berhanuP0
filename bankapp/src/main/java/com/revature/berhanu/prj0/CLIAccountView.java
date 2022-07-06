package com.revature.berhanu.prj0;

import java.util.Scanner;

// Bank employee User has the following pages available 
    // 1. Welcome Page --with Main page
    // 2.login page
    // 3.User create and update page
    // 4.User read and Delete 
    // Customer has the Followinhg pages
    // 1. Welcome page
    // 2. login page/logout 
    // 3.View Balance 
    // 4.Deposit
    // 5.withdraw
public class CLIAccountView {
    
        public void accountopenedView(){
        
            System.out.println(" List Of Active Accounts");
            System.out.println("___________________________________________________________________________________");

        Account objAccountsee = new Account();
        objAccountsee.readOpenedAccount();



        }


     
}
