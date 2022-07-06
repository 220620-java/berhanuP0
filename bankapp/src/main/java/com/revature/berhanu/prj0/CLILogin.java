package com.revature.berhanu.prj0;

import java.io.InputStream;
import java.util.Scanner;

 public class CLILogin{


    public void verifyLogin() {
           

        
     

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Login Page of the Bank of Happy Land  ");
        System.out.println("=======================================================");
        System.out.println("Enter User Name  ");
        String userName = sc.nextLine();
        System.out.println("Enter Password  ");
        String password = sc.nextLine();
        

         
        if ("Berhanu".equals(userName) && "password".equals(password))
         
        {
            System.out.println("User Succesfully logged in.....");

        CLIFrontView objDrawFrontPage = new CLIFrontView();
        objDrawFrontPage.welcome("Employee");
        

        }else 
        {
       
            System.out.println("Invalid User Name or Password ");

       
       
       
        }
   
        sc.close();  
 }
    
     
 }





    

 
