package com.revature.berhanu.prj0;

import java.util.Scanner;

public class CLIAccountManager {
    public void accountManager(){
         
        System.out.println("Account Management page of the Bank Of Happy Land");
        System.out.println("--------------------------------------------- ");
        System.out.println("1- Open New Account" );
        System.out.println("2- View All Accounts"); 
        System.out.println("3- Close Account");
        System.out.println("4- Update Account ");
        System.out.println("5- Search Account");
        System.out.println("6- Exit"); 
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Choice: ");
        String choice = sc.nextLine();

        if(choice.equals("1")){
            CLIAccountOpening objCLIAccountCreation =new CLIAccountOpening();
            objCLIAccountCreation.drawCreatAccountPage();
        }
        else if(choice.equals("2")){
            
           CLIAccountView objCliAccountView= new CLIAccountView();
           objCliAccountView.accountopenedView();
           
        }
        else if(choice.equals("3")){
            CLIAccountClosing objCLIAccountDeletion = new CLIAccountClosing();
            objCLIAccountDeletion.closeAccount();
         }
         else if(choice.equals("4")){
            CLIAccountUpdate objCLIAccountUpdate = new  CLIAccountUpdate();
           // objCLIAccountUpdate.updateCustomer();
         }
         else if(choice.equals("5")){
             
            CLIAccountSearch  objCLIAccountSearch = new  CLIAccountSearch();
            //objCLIAccountSearch.searchAccount();
         }
         else if(choice.equals("6")){
             
           System.exit(0);
         }

        sc.close();
        
}
}


