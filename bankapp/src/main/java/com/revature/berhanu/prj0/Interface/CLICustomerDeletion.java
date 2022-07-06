package com.revature.berhanu.prj0.Interface;


import java.util.*;
// . Here we are deleting a customer 
// 1. Get Data from Employee user the customer Id sought to delete
// 2. Display the full information of the selected Cusomer based on ID
// 3. Ask if this is the user the employee wants to delete
// 4. if yes delete the user (customer) this is ony possible for new customers not associated with any account 

import com.revature.berhanu.prj0.Models.User;

public class CLICustomerDeletion {
    void DeleteCustomer(){
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Input the Customer ID you want to Delete ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Customer ID ?");
        String CustomerID =  objScanner.nextLine();
        User objUser = new User();
        objUser = (User)objUser.getSingleUser(CustomerID);
        System.out.println("___________________________________________________________________________________");
                System.out.println(objUser.FirstName+" "+objUser.MiddleName + " " + objUser.LastName);
                System.out.println("Email : "+objUser.Email);
                System.out.println("Phone : "+objUser.PhoneNumber);
                System.out.println("SSN   : "+objUser.SSN);
                System.out.println("DOB   : "+objUser.DOB +" | Gender : "+ objUser.Gender +" | Password : "+objUser.Password);
                System.out.println("___________________________________________________________________________________");
        System.out.println("Are you sure you want to delete this customer ? y/n");
        String answer = objScanner.nextLine();
        /// have the employee see which customer data he/she is deleting
        // here we 
       
        if(answer.equals("y") || answer.equals("Y"))
        {
            objUser.deleteUser(CustomerID);
        }
        else if (answer.equals("n") || answer.equals("N"))
        {

        }
        
        objScanner.close();
        
    }
}
