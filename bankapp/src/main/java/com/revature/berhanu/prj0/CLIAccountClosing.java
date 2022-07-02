package com.revature.berhanu.prj0;

import java.math.BigInteger;
import java.util.*;
// . Here we are deleting a customer 
// 1. Get Data from Employee user the customer Id sought to delete
// 2. Display the full information of the selected Cusomer based on ID
// 3. Ask if this is the user the employee wants to delete
// 4. if yes delete the user (customer) this is ony possible for new customers not associated with any account 

public class CLIAccountClosing {
    void closeAccount(){
        AccountType objAccountType = new AccountType();
        Account objAccount = new Account();
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Input the Account number you want to close ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Account number ?");
        String AccountNumber = objScanner.nextLine();
        objAccount = (Account)objAccount.getSingleAccount(AccountNumber);
        String AccountTypeID =  objAccount.aaccounttypeid;
        
        // User objUser = new User();
        //objUser = (User)objUser.getSingleUser(CustomerID);
        objAccountType = (AccountType)objAccountType.getSingleAccountType(AccountTypeID);
        
        //tblAccount , tblAccountType
        System.out.println("___________________________________________________________________________________");
                System.out.println(objAccountType.AccountTypeName +" "+ objAccountType.InterestRate + "%");
                System.out.println("AccountNumber : "+objAccount.accountnumber);
                System.out.println("Balance : " + objAccount.accountbalance);
                System.out.println("___________________________________________________________________________________");
        System.out.println("Are you sure you want to delete this customer ? y/n");
        String answer = objScanner.nextLine();
        /// have the employee see which customer data he/she is deleting
        // here we 
       
        if(answer.equals("y") || answer.equals("Y"))
        {
            //objUser.deleteUser(CustomerID);
        }
        else if (answer.equals("n") || answer.equals("N"))
        {

        }
        
        objScanner.close();
        
    }
}
