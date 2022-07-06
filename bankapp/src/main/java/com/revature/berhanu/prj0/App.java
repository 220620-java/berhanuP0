package com.revature.berhanu.prj0;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;


public class App 
{
    public static void main( String[] args )
    {
      
       // Display Login Page
        CLILogin objCliLogin= new CLILogin();
        objCliLogin.verifyLogin();
    }
}
