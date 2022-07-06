package com.revature.berhanu.prj0.Interface;

import java.util.Scanner;

import com.revature.berhanu.prj0.Models.Account;



public class CLIDepositfunds{ 
    public void deposit(){
        Account objAccount = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Account number you want to deposit into");
        String AccountNumber = sc.nextLine();
        System.out.println("How much money do you want to deposit? ");
        String deposit= sc.nextLine();
        Double objDeposit = Double.parseDouble(deposit);
        objAccount = (Account)objAccount.getSingleAccount(AccountNumber);
        Double objBalance = Double.parseDouble(objAccount.accountbalance);
        Double objNewBalance  = objDeposit + objBalance;
        objAccount.updateAccount(objAccount.accountid, objAccount.aaccounttypeid, objNewBalance.toString(), objAccount.accountownershiptype, objAccount.accountnumber, objAccount.accountstatus, "You have deposited funds into the account");
        System.out.println("Current Balance : "+ "$" + objNewBalance);
        sc.close();
  } 
}

