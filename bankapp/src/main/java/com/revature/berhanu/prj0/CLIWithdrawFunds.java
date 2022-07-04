package com.revature.berhanu.prj0;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CLIWithdrawFunds {
    public void withdrawFunds(){
        Account objAccount = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Account number you want to withdraw from");
        String AccountNumber = sc.nextLine();
        System.out.println("How much money do you want to withdraw? ");
        String withdraw= sc.nextLine();
        Double objWithdraw = Double.parseDouble(withdraw);
        objAccount = (Account)objAccount.getSingleAccount(AccountNumber);
        Double objBalance = Double.parseDouble(objAccount.accountbalance);
        Double objNewBalance  = objBalance - objWithdraw;
        if(objNewBalance>= 0){
            objAccount.updateAccount(objAccount.accountid, objAccount.aaccounttypeid, objNewBalance.toString(), objAccount.accountownershiptype, objAccount.accountnumber, objAccount.accountstatus, "You have withdrawn funds from the account");
            System.out.println("Current Balance :"+"$"+ objNewBalance);
         } 
         else if(objNewBalance < 0){

            System.out.println("Insufficient Funds ");

         }


         
    
       


            sc.close();


        }
}
