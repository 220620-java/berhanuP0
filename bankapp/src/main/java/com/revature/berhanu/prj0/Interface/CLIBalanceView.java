package com.revature.berhanu.prj0.Interface;

import java.util.Scanner;

import com.revature.berhanu.prj0.Models.Account;
public class CLIBalanceView {
      public void  viewBalance(){

        Account objAccount = new Account();
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Enter the Account number you want to check the balance of");
        String AccountNumber = objScanner.nextLine();
        objAccount = (Account)objAccount.getSingleAccount(AccountNumber);
        System.out.println("Current Balance : " + "$ "+objAccount.accountbalance);
        objScanner.close();

    }
    
}
