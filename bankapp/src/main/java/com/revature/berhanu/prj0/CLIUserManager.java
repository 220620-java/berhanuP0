package com.revature.berhanu.prj0;
import java.util.*;
public class CLIUserManager {

    public void userManager(){
         
            System.out.println("Customer Management page of the Bank Of Happy Land");
            System.out.println("--------------------------------------------- ");
            System.out.println("1- Add New Customer" );
            System.out.println("2- View All Customer"); 
            System.out.println("3- Delete Customer");
            System.out.println("4- Update Customer Data");
            System.out.println("5- Search Customer");
             
           Scanner sc = new Scanner(System.in);
            System.out.print("Enter your Choice: ");
            String choice = sc.nextLine();

            if(choice.equals("1")){
                CLICustomerCreation objDrawAddCustmerPage =new CLICustomerCreation();
                objDrawAddCustmerPage.drawAddCustomerPage();
            }
            else if(choice.equals("2")){
               User objUser = new User();
               objUser.readUser();
            }
            else if(choice.equals("3")){
                CLICustomerDeletion objCLICustomerDeletion = new CLICustomerDeletion();
                objCLICustomerDeletion.DeleteCustomer();
             }
             else if(choice.equals("4")){
                CLICustomerUpdate objCLICustomerUpdate = new CLICustomerUpdate();
                objCLICustomerUpdate.updateCustomer();
             }
             else if(choice.equals("5")){
                 
                CLICustomerSearch  objCLICustomerSearch = new CLICustomerSearch();
                objCLICustomerSearch.searchCustomer();
             }

            sc.close();
            
    }
}
