package com.revature.berhanu.prj0.Utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

/// This is the connection class > the method connectToServer returns a statement,
// This is the method to be called in this project to connect
public class ServerConnect {
    public Connection connectToServer()
    {
        String dbURL ="jdbc:postgresql://postgressdbinstance1.c5a1xliscqxz.us-east-2.rds.amazonaws.com:5432/BankSystemDB";
        String UserName = "postgresAdmin";
        String Password = "PG1234567890.";

        try{
            Connection objConnection = DriverManager.getConnection(dbURL, UserName, Password);
            return objConnection;
        }
        catch(SQLException e)
        {
            throw new Error(e);
        }
         
    }
    // this one is another option just to work with Statement eventhough it is vulnerable for  SQL injection --> but another option to preparestatement
    public Statement getStatement(){
        String dbURL ="jdbc:postgresql://postgressdbinstance1.c5a1xliscqxz.us-east-2.rds.amazonaws.com:5432/BankSystemDB";
        String UserName = "postgresAdmin";
        String Password = "PG1234567890.";
        try{
            Connection objConnection = DriverManager.getConnection(dbURL, UserName, Password);
            Statement objStatement = objConnection.createStatement();
            return objStatement;
        }catch(SQLException e)
        {
            throw new Error(e);
        }
    }
}
