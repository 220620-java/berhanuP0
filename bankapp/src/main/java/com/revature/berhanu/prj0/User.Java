package com.revature.berhanu.prj0;
import java.sql.SQLException;

import javax.xml.transform.Result;

import java.sql.*;

public class User {
    

    public String UserID,SSN,FirstName,MiddleName,LastName,DOB,Gender,PhoneNumber,Email,Password;
    
      
    public void createUser(String SSN ,String  FName,String MName ,String LName ,String DOB,String Gender ,String PNumber,String Email, String PassW )
    {
        ServerConnect objServerConnection = new ServerConnect();
        Statement objStatement = objServerConnection.connectToServer();
        String q = "'";
        String insertUserQueryString= "INSERT INTO public.\"tblUser\"( \"SSN\", \"FirstName\", \"MiddleName\", \"LastName\", \"DOB\", \"Gender\", \"email\", \"phoneNumber\", \"Password\")VALUES (" 
        +q+SSN+q+","
        +q+FName+q+","
        +q+MName+q+","
        +q+LName+q+","
        +q+DOB+q+","
        +q+Gender+q+","
        +q+PNumber+q+","
        +q+Email+q+","
        +q+PassW+q+");";

        System.out.println(insertUserQueryString);
        try{
            // use excuteUpdate for staments that do not return rows
            int  Result = objStatement.executeUpdate(insertUserQueryString);
            System.out.println("New Customer has been added to the Database");
            
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public void updateUser(String ID, String SSN ,String  FName,String MName ,String LName,String DOB ,String Gender ,String PNumber,String Email, String PassW )
    {
        //System.out.println(UpdateUserQuery);
        ServerConnect objServerConnection = new ServerConnect();
        Statement objStatement = objServerConnection.connectToServer();
        String q = "'";
        String UpdateUserQuery = "UPDATE public.\"tblUser\" SET \"SSN\"=" +q+SSN+q +", \"FirstName\"=" +q+FName+q+ ", \"MiddleName\"="+q+MName+q+", \"LastName\"="+q+LName+q+", \"DOB\"="+q+DOB+q+", \"Gender\"="+q+Gender+q+", \"email\"="+q+Email+q+", \"phoneNumber\"="+q+PNumber+q+", \"Password\"="+q+PassW+q+ "WHERE \"UserID\"="+q+ID+q+";";
        
        try{
            // use excuteUpdate for staments that do not return rows
            int  Result = objStatement.executeUpdate(UpdateUserQuery);
            System.out.println("Customer has been updated ");
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public Object getSingleUser (String ID){
        User objUser = new User(); 
        ServerConnect objServerConnection = new ServerConnect();
        Statement objStatement = objServerConnection.connectToServer();
        try{
            // objStatement.executeQuery(strInsertUser);
            
            ResultSet Result = objStatement.executeQuery("SELECT * FROM public.\"tblUser\" where \"UserID\" ="+ ID +";");
            while(Result.next()){
                // here we are retierving data and send it to the calling method based on ID 
                objUser.UserID = Result.getString("USerID");
                objUser.SSN =Result.getString("SSN");
                objUser.FirstName = Result.getString("FirstName");
                objUser.MiddleName = Result.getString("MiddleName");
                objUser.LastName = Result.getString("LastName");
                objUser.DOB = Result.getString("DOB");
                objUser.Gender = Result.getString("Gender");
                objUser.Email = Result.getString("email");
                objUser.PhoneNumber = Result.getString("phoneNumber");
                objUser.Password = Result.getString("Password");
                
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
        return objUser;
    }
    public void searchUser(String searchTerm){
        ServerConnect objServerConnection = new ServerConnect();
        Statement objStatement = objServerConnection.connectToServer();
        try{
            // objStatement.executeQuery(strInsertUser);
            String ls = "'%"; // ls : like start 
            String le = "%'"; // le : like end  
            String searchParam = "SELECT \"UserID\", \"SSN\", \"FirstName\", \"MiddleName\", \"LastName\", \"DOB\", \"Gender\", \"email\", \"phoneNumber\", \"Password\" FROM public.\"tblUser\" where \"SSN\" = " + "'"+searchTerm+"'" + " or \"FirstName\" LIKE "+ls+searchTerm+le+ " or \"MiddleName\" LIKE "+ls+searchTerm+le+" or \"LastName\" LIKE "+ls+searchTerm+le+ " or \"email\" LIKE "+ls+searchTerm+le+ " or \"phoneNumber\" LIKE "+ls+searchTerm+le+ ";";
            System.out.println(searchParam);
            ResultSet Result = objStatement.executeQuery(searchParam);
            System.out.println("Search Result");
            System.out.println("-----------------------------------------------------------------------------------");
            while(Result.next()){
                //"SSN", "FirstName", "MiddleName", "LastName", "DOB", "Gender", "email", "phoneNumber", "Password"
                String SSN =Result.getString("SSN");
                String FirstName = Result.getString("FirstName");
                String MiddleName = Result.getString("MiddleName");
                String LastName = Result.getString("LastName");
                String DOB = Result.getString("DOB");
                String Gender = Result.getString("Gender");
                String email = Result.getString("email");
                String phoneNumber = Result.getString("phoneNumber");
                String Password = Result.getString("Password");
                
                System.out.println("___________________________________________________________________________________");
                System.out.println(FirstName+" "+MiddleName + " " + LastName);
                System.out.println("Email : "+email);
                System.out.println("Phone : "+phoneNumber);
                System.out.println("SSN   : "+SSN);
                System.out.println("DOB   : "+DOB +" | Gender : "+ Gender +" | Password : "+ Password);
                System.out.println("___________________________________________________________________________________");
            
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    //String ID, String SSN, String FName, String MName, String LName, String PhoneNumber, String eMail
    public void readUser( )
    {
        ServerConnect objServerConnection = new ServerConnect();
        Statement objStatement = objServerConnection.connectToServer();
        try{
            // objStatement.executeQuery(strInsertUser);
            
            ResultSet Result = objStatement.executeQuery("SELECT * FROM public.\"tblUser\"");
            System.out.println("List of Customers");
            System.out.println("-----------------------------------------------------------------------------------");
            while(Result.next()){
                //"SSN", "FirstName", "MiddleName", "LastName", "DOB", "Gender", "email", "phoneNumber", "Password"
                String SSN =Result.getString("SSN");
                String FirstName = Result.getString("FirstName");
                String MiddleName = Result.getString("MiddleName");
                String LastName = Result.getString("LastName");
                String DOB = Result.getString("DOB");
                String Gender = Result.getString("Gender");
                String email = Result.getString("email");
                String phoneNumber = Result.getString("phoneNumber");
                String Password = Result.getString("Password");
               
                System.out.println("___________________________________________________________________________________");
                System.out.println(FirstName+" "+MiddleName + " " + LastName);
                System.out.println("Email : "+email);
                System.out.println("Phone : "+phoneNumber);
                System.out.println("SSN   : "+SSN);
                System.out.println("DOB   : "+DOB +" | Gender : "+ Gender +" | Password : "+ Password);
                System.out.println("___________________________________________________________________________________");
                
                
                
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public void deleteUser(String ID)
    {
        ServerConnect objServerConnection = new ServerConnect();
        Statement objStatement = objServerConnection.connectToServer();
        String q = "'";
        String insertUserQueryString= "DELETE FROM public.\"tblUser\" WHERE \"UserID\" ="+ ID +";";
    
        try{
            // use excuteUpdate for staments that do not return rows
            int  Result = objStatement.executeUpdate(insertUserQueryString);
            System.out.println("Customer has been deleted ");
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
      
    
}
