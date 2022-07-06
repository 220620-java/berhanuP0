package com.revature.berhanu.prj0;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.lang.Thread.State;
import java.math.BigInteger;
import java.sql.*;

public class User {
    
  // This class contains the CRUD for my User 
    public String UserID,SSN,FirstName,MiddleName,LastName,DOB,Gender,PhoneNumber,Email,Password;
    
      
    public void createUser(String SSN ,String  FName,String MName ,String LName ,String DOB,String Gender ,String PNumber,String Email, String PassW )
    {
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        
       
        String InsertUserQuery = "INSERT INTO tblUser"
                                +"(UserID, SSN, FirstName, MiddleName, LastName, DOB, Gender, email, phoneNumber, Password)"
                                +"VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(InsertUserQuery);
            // use excuteUpdate for staments that do not return rows
            objPreparedStatement.setString(1, SSN);
            objPreparedStatement.setString(2, FName);
            objPreparedStatement.setString(3, MName);
            objPreparedStatement.setString(4, LName);
            objPreparedStatement.setString(5, DOB);
            objPreparedStatement.setString(6, Gender);
            objPreparedStatement.setString(7, Email);
            objPreparedStatement.setString(8, PhoneNumber);
            objPreparedStatement.setString(9, PassW);
            int  Result = objPreparedStatement.executeUpdate();
            System.out.println("New Customer has been added to the Database");            
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public void updateUser(String ID, String SSN ,String  FName,String MName ,String LName,String DOB ,String Gender ,String PNumber,String Email, String PassW )
    {
        
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();;

        String updateUserQuery ="UPDATE public.tbluser "
        +"set ssn=?, " 
        +"firstname=?, "
        +"middlename=?, "
        +"lastname=?, "
        +"dob=?, "
        +"gender=?, "
        +"email=?, "
        +"phonenumber=?, "
        +"password=? "
        +"WHERE UserID=? ";
        
        Long objID = Long.parseLong(ID);
        

        try{
            // use excuteUpdate for staments that do not return rows
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateUserQuery);
            // use excuteUpdate for staments that do not return rows
            objPreparedStatement.setString(1, SSN);
            objPreparedStatement.setString(2, FName);
            objPreparedStatement.setString(3, MName);
            objPreparedStatement.setString(4, LName);
            objPreparedStatement.setString(5, DOB);
            objPreparedStatement.setString(6, Gender);
            objPreparedStatement.setString(7, Email);
            objPreparedStatement.setString(8, PhoneNumber);
            objPreparedStatement.setString(9, PassW);
            objPreparedStatement.setLong(10, objID); // the parameter recieved 
           
            
            objPreparedStatement.executeUpdate();

            System.out.println("Customer has been updated ");
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public Object getSingleUser (String ID){
        User objUser = new User(); 
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        Long objID = Long.parseLong(ID);
        try{
            // objStatement.executeQuery(strInsertUser);
            String getSingleUserQuery= "SELECT * FROM public.tblUser  where UserID = ? ";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleUserQuery);
            objPreparedStatement.setLong(1, objID);
            ResultSet Result = objPreparedStatement.executeQuery();

           
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
        Connection objConnection = objServerConnection.connectToServer();
        try{
            // 1 construcct a string of a query 
            // 2 replace the ? with setstring 

            // objStatement.executeQuery(strInsertUser);
          //  String ls = "'%"; // ls : like start 
          //  String le = "%'"; // le : like end  
            //String searchParam = "SELECT \"UserID\", \"SSN\", \"FirstName\", \"MiddleName\", \"LastName\", \"DOB\", \"Gender\", \"email\", \"phoneNumber\", \"Password\" FROM public.\"tblUser\" where \"SSN\" = " + "'"+searchTerm+"'" + " or \"FirstName\" LIKE "+ls+searchTerm+le+ " or \"MiddleName\" LIKE "+ls+searchTerm+le+" or \"LastName\" LIKE "+ls+searchTerm+le+ " or \"email\" LIKE "+ls+searchTerm+le+ " or \"phoneNumber\" LIKE "+ls+searchTerm+le+ ";";
            // Step 1.
            String searchQuery = "SELECT * FROM tblUser " +
            "Where SSN = ? or "+
            "FirstName LIKE ? or "+
            "MiddleName LIKE ? or "+
            "LastName LIKE ? or "+
            "DOB LIKE ? or "+
            "Gender LIKE ? or "+
            "email LIKE ? or "+
            "phoneNumber LIKE ?" ;

            // step 2 here we make the prepqared statemet object and pass the string 
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(searchQuery);
            // set string 
            objPreparedStatement.setString(1,searchTerm );
            objPreparedStatement.setString(2, searchTerm);
            objPreparedStatement.setString(3, searchTerm);
            objPreparedStatement.setString(4, searchTerm);
            objPreparedStatement.setString(5, searchTerm);
            objPreparedStatement.setString(6, searchTerm);
            objPreparedStatement.setString(7, searchTerm);
            objPreparedStatement.setString(8, searchTerm);
            
            
            ResultSet Result = objPreparedStatement.executeQuery();
            int count =0;
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
                 
                count = + 1;
                
            }
            if( count==0){
                System.out.println(" No Result Found");
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
        Connection objConnection = objServerConnection.connectToServer();
        
        try{
            // objStatement.executeQuery(strInsertUser);
            // get prepared statement 
            String readQuery ="SELECT * FROM public.tblUser";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(readQuery);

            ResultSet Result = objPreparedStatement.executeQuery();
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
        Connection objConnection = objServerConnection.connectToServer();

        Long objID = Long.parseLong(ID); 
       
        
        try{
            String deleteUserQueryString= "DELETE FROM public.tblUser"
                                         +" WHERE userid = ? ";

            // the following code doesn't work because preparedstatement doesn't have setbigin method 
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteUserQueryString);
            objPreparedStatement.setLong(1,objID);
           // use excuteUpdate for staments that do not return rows
            int  Result = objPreparedStatement.executeUpdate();
            System.out.println("Customer has been deleted ");
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
      
    
}
