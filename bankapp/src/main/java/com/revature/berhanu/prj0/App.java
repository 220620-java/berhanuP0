package com.revature.berhanu.prj0;
import com.revature.berhanu.prj0.Interface.CLILogin;


public class App 
{
    public static void main( String[] args )
    {
      
       // Display Login Page
        CLILogin objCliLogin= new CLILogin();
        objCliLogin.verifyLogin();
    }
}
