package com.revature.berhanu.prj0;
import java.sql.*;
import java.sql.DriverManager;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String dbURL ="jdbc:postgresql://postgressdbinstance1.c5a1xliscqxz.us-east-2.rds.amazonaws.com:5432/BankSystemDB";
        String UserName = "postgresAdmin";
        String Password = "PG1234567890.";

        String SSN,FName,MName,LName,Gender,PNumber,Email,PassW ;
        //Date DOB = DateFormat.parse("2018-05-05");
        SSN = "1212121";
        FName = "Tom";
        MName = "Jones";
        LName = "Ed";
        Gender = "M";
        PNumber="2063722938";
        Email ="jones@Revature.net";
        PassW = "2345678";
        
        String q = "\"";

        //dbc:driver://hostname:port/dbName?user=userName&password=password 
        System.out.println("DB Connection using jdbc to aws rds  ");
          
       //  String strInsertUser= "INSERT INTO public.\"tblUser\"(\"UserID\", \"SSN\", \"FirstName\", \"MiddleName\", \"LastName\", \"DOB\", \"Gender\", \"email\", \"phoneNumber\", \"Password\")VALUES (?," +q+SSN+q+","+ q+ FName+q+","+MName+","+LName+","+null+","+Gender+","+PNumber+","+Email+","+PassW+");";
        // System.out.print(strInsertUser);
        try{
            
            Connection objConnection = DriverManager.getConnection(dbURL, UserName, Password);
            Statement objStatement = objConnection.createStatement();
            try{
               // objStatement.executeQuery(strInsertUser);
               ResultSet Result = objStatement.executeQuery("select * from \"tblUser\"");
               while(Result.next()){
                String firstName = Result.getString("FirstName");
                System.out.println(firstName);
               }

            }
            catch (SQLException e){
                throw new Error(e);
            }
            objConnection.close();
            System.out.println("Connected to DB !!!!");
        }
        catch (SQLException e){
            throw new Error(e);
        }        



    }
}
