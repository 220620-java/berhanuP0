package com.revature.berhanu.prj0;

import java.util.Scanner;

public class CLICustomerCreation {
    public void drawAddCustomerPage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Customer Management page of the Bank Of Happy Land");
        System.out.println("--------------------------------------------- ");
        System.out.println("Cusomer First Name ");
        String fname= sc.nextLine();
        System.out.println("Cusomer Middle Name ");
        String mName= sc.nextLine();
        System.out.println("Cusomer  Last Name ");
        String lName= sc.nextLine();
        System.out.println("Cusomer Social Security Number");
        String SSN= sc.nextLine();
        System.out.println("Cusomer  Date of Birth");
        String DOB= sc.nextLine();
        System.out.println("Cusomer Gender "); 
        String gender= sc.nextLine();
        System.out.println("Cusomer Email ");
        String email= sc.nextLine();
        System.out.println("Cusomer Phone Number ");
        String phoneNumber= sc.nextLine();
        System.out.println("Password ");
        String password= sc.nextLine();
        User objUser = new User();
        objUser.createUser(SSN, fname, mName, lName,DOB, gender, phoneNumber, email, password);


        sc.close();

         

    }

}
