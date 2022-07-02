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
    

    public void welcome(String userType){
        if (userType=="Employee"){
            System.out.println("WELCOME Employee to the Bank Of Happy Land");
            System.out.println("--------------------------------------------- ");
            System.out.println("1- Manage User");
            System.out.println("2- Manage Account");/// Separate items 3,4,5,6, 7 to make it easily accesible 
            System.out.println("3- Deposit Funds");
            System.out.println("4- Withdraw Funds");
            System.out.println("5- Transfer Funds");
            System.out.println("6- View Balance ");
            System.out.println("7- View Transaction History");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your Choice: ");
            String choice = sc.nextLine();
            
            if (choice.equals("1"))// Manage User Creates new Customer,Read /Update/Delete User
            {
                    CLIUserManager objUserManagerPage= new CLIUserManager();
                    objUserManagerPage.userManager();
            }
            else if (choice.equals("2"))
            {
                
            }
            else if (choice == "3")
            {
                
            }
            else if (choice == "4")
            {
                
            }

            else if (choice == "5")
            {
                
            }

            else if (choice == "6")
            {
                
            }
            else if (choice == "7")
            {
                
            }


            sc.close();
            

        }

    }

}
