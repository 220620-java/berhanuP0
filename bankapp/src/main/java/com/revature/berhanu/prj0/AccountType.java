package com.revature.berhanu.prj0;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class AccountType {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
   
    public String AccountTypeId, AccountTypeName, InterestRate;
     
    public void createAccountType( String AccountTypeName,Double InterestRate){
        
         
        String insertAccountType= "INSERT INTO public.tblAccountType AccountTypeId, AccountTypeName, InterestRate  VALUES (default, ?, ?)";
   
        try{
            // use excuteUpdate for staments that do not return rows
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(insertAccountType);
            objPreparedStatement.setString(1,AccountTypeName);
            objPreparedStatement.setDouble(2,InterestRate );
             
            int  Result =   objPreparedStatement.executeUpdate();
            System.out.println("New Account Type has been added ");
            
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public void readAccountType(){
    
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
            try{
                // objStatement.executeQuery(strInsertUser);
                String  readAccountTypeQuery =  "SELECT * FROM public.tblAccountType ";
                PreparedStatement objPreparedStatement = objConnection.prepareStatement(readAccountTypeQuery);
               
                ResultSet Result = objPreparedStatement.executeQuery();
                System.out.println("List of Account Types");
                System.out.println("-----------------------------------------------------------------------------------");
                while(Result.next()){
                    
                    String AccountTypeName =Result.getString("AccountTypeName");
                    String InterestRate = Result.getString("Interest");
                    System.out.println("___________________________________________________________________________________");
                    System.out.println("Account Type : "+AccountTypeName);
                    System.out.println("Interest Rate : "+InterestRate);
                    System.out.println("___________________________________________________________________________________");
                }
            } catch(SQLException e){
                throw (new Error(e));
            }
              
    }
    // list out the account types to be collected in list Object 
    public List<AccountType> getAccountType()
    {   
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();

        List<AccountType> AccountTypeList = new ArrayList<AccountType>();
        AccountType objAccountType = new AccountType();
         
        try{
            // objStatement.executeQuery(strInsertUser);
            String  listAccountTypeQuery =  "SELECT * FROM public.tblAccountType ";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(listAccountTypeQuery);
           
            ResultSet Result = objPreparedStatement.executeQuery();
            
            while(Result.next()){
                AccountType objAccountTypeL = new AccountType();
                objAccountTypeL.AccountTypeId = Result.getString("AccountTypeID");
                objAccountTypeL.AccountTypeName =Result.getString("AccountTypeName");
                objAccountTypeL.InterestRate = Result.getString("InterestRate");
              
                AccountTypeList.add(objAccountTypeL);
            }
        } catch(SQLException e){
            throw (new Error(e));
        }
        return AccountTypeList;
                
    }
    public void updateAccountType(String ID, String AccountTypeName, String interestRate){
        /*
         * step 1. instantiate the server connect class
         * step 2. create a connection object
         * step 3. create a query string 
         * step 4. create a preparedstatement object and pass the query string 
         * step 5. set string to every question mark that you have in your query string
         *          you should use :
         *          setstring() for string types 
         *          setlong() for bigint types
         *          setdouble() for double types 
         * step 6. call the execute update or the executequery method of the prepared statement object 
         *          execute update for queries that do not return rows 
         *          execute query for queries that return multiple rows
         * NB: you need to convert the string ID to long using the following code 
         * Long objID = Long.parseLong(ID); // for converting string to long
         * Double objInterestRate = Double.parseDouble(interestRate); // for converting string to double 
         * 
        */
        ServerConnect objServerConnection = new ServerConnect();// step 1
        Connection objConnection = objServerConnection.connectToServer();// step 2
        Long objID = Long.parseLong(ID); 
        Double objInterestRate = Double.parseDouble(interestRate);

        try{
            String updateAccountTypeQuery =  "UPDATE public.tblaccounttype" + //step 3
            "SET accounttypename=?, interestrate=?:"+
            "WHERE accounttypeid = ?;";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateAccountTypeQuery); // step 4
            objPreparedStatement.setString(1,AccountTypeName); //setp 5
            objPreparedStatement.setDouble(2,objInterestRate);
            objPreparedStatement.setLong(3,objID);
            objPreparedStatement.executeUpdate(); //setp 6
        }
        catch (SQLException e){
            throw  (new Error(e));
        }
       

    }
    public void deleteAccountType( String ID){
        //
        ServerConnect objServerConnection = new ServerConnect();   // step 1
        Connection objConnection = objServerConnection.connectToServer();// step 2
        Long objID = Long.parseLong(ID); 
        try {
            
            String deleteQuery = "DELETE FROM public.tblaccounttype" +  // step 3
            " WHERE id = ?;";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);// step 4
            objPreparedStatement.setLong(3,objID); // step 5
            objPreparedStatement.executeUpdate();


        } catch (Exception e) {
            throw  (new Error(e));
        }

      
    }
    ///the user has to be given option which account type wants to delete
    // this method chooses account type based on the parameter String ID
     
    
    public Object getSingleAccountType (String ID){
        
        AccountType objAccountType = new AccountType(); 
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        Long objID = Long.parseLong(ID);
 
       
        try{
            // objStatement.executeQuery(strInsertUser);
            String getAccountTypeQuery= "SELECT * FROM public.tblAccountType "
                                         + " Where ID = ?";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(getAccountTypeQuery);
            objPreparedStatement.setLong(1, objID);
            ResultSet Result = objPreparedStatement.executeQuery();
            
           
            while(Result.next()){
                // here we are retierving data and send it to the calling method based on ID 
                  objAccountType.AccountTypeId = Result.getString("accountypeid");
                  objAccountType.AccountTypeName = Result.getString("accounttypename");
                  objAccountType.InterestRate = Result.getString("interestrate");
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
        return objAccountType ;
    }




}

