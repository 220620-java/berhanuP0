package com.revature.berhanu.prj0;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CLIAccountOpening {
    public void drawCreatAccountPage(){
        Account objAccount = new Account();
        AccountType objAccountType =  new AccountType();
        AccountUser objAccountUser = new AccountUser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Account Management page of the Bank Of Happy Land");
        System.out.println("--------------------------------------------- ");
        System.out.println("What Kind Of Account Do you want to Create? ");
        // We are going to list Kinds of account
        // Debit /Saving 
        // retieve Id from account Type and list the available account types
        // is it single or Joint account? Based on the response if selected customer ID is one 
        // or Multiple User Id is more than one ownership
        
        /// we are going to hold an object List to hold the kind of account 
        
        List <AccountType> AccountTypeList =objAccountType.getAccountType();
        /// Create a for loop to itereate  the list 
        System.out.println("List of Account Types");
        System.out.println("-----------------------------------------------------------------------------------");
         
        for(int i=0; i< AccountTypeList.size(); i++){
            System.out.println("___________________________________________________________________________________");
            System.out.println("Press "+ i + " for :");
            System.out.println("Account Type : "+AccountTypeList.get(i).AccountTypeName);
            System.out.println("Interest Rate : "+AccountTypeList.get(i).InterestRate);
            System.out.println("___________________________________________________________________________________");
        }
        String accTypechoice= sc.nextLine();
        // Took the choice eneterd 
        int index = Integer.parseInt(accTypechoice);
        // Parsed into integer to get the index 
        objAccountType = (AccountType)AccountTypeList.get(index);// Get the Account type Id and save it to a variable
        //  Now we got the Connection with Account! We got the Foreign Key

        //We Use this data  Select From tblAccount .....Where tbleAccountTYpeID = AccountTypeID

        System.out.println("How much money do you want to open the Account with? ");
        String openingBalance= sc.nextLine();
        System.out.println("What kind of Ownership Account do you want to open? Single or Joint ? ");
        System.out.println("1. For Single Account");
        System.out.println("2. For Joint Account");
        String ownershiptype = sc.nextLine();
        if(ownershiptype.equals("1")){
          ownershiptype = "Single";
          System.out.println("For whom do you want this account , Please enter User ID");
          String userId= sc.nextLine();
          String lastID = objAccount.getLastDataEntry();
       
          Long objLastID = Long.parseLong(lastID);/// we are going to generate a unique number here
          objLastID = objLastID +1 ;
          String AccountNumber = "1000111-4444-" + objLastID.toString();
         
          System.out.println("___________________________________________________________________________________");
          System.out.println("Account Number : "+AccountNumber);
          System.out.println("Ownership type : "+ownershiptype);
          System.out.println("Opening Balance: "+openingBalance);
          System.out.println("Account Type: "+ objAccountType.AccountTypeName + " | Interest Rate: "+objAccountType.InterestRate +"%" );
          System.out.println("___________________________________________________________________________________");
          System.out.println("Are you sure you want to create this Account? y/n");
  
          String answer = sc.nextLine();
         
          if(answer.equals("y") || answer.equals("Y"))
          {
              objAccount.createAccount(objAccountType.AccountTypeId, openingBalance, ownershiptype, AccountNumber, "Active");
              objAccountUser.createAccountUser(userId, objLastID.toString());
          
          }
          else if (answer.equals("n") || answer.equals("N"))
          {
  
          }

          
        }
        else if (ownershiptype.equals("2")){
          ownershiptype = "Joint";
          System.out.print("Who will be the owners of this account , Please enter their IDs");
          System.out.print(" Please enter their IDs separated with commas");
          String userIds= sc.nextLine();
        }
        
        

      
  

        sc.close();

         

    }

}
