package com.revature.berhanu.prj0;

import java.util.Scanner;
public class CLIBalanceView {
      public void  viewBalance(){

        Account objAccount = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Account number you want to check the balance of");
        String AccountNumber = sc.nextLine();
        objAccount = (Account)objAccount.getSingleAccount(AccountNumber);
        System.out.println("Current Balance : " + "$ "+objAccount.accountbalance);
        

    }
    
}
