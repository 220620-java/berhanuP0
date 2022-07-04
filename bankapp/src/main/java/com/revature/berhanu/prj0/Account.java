package com.revature.berhanu.prj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.main.Main.Result;

import java.sql.*;
public class Account {
    // this models the database table properties
    String accountid, aaccounttypeid, accountbalance, accountownershiptype, accountnumber, accountstatus;
    public void createAccount(String AccountTypeID, String  AccountBalance, String AccountOwnershipType, String AccountNumber, String AccountStatus){
        
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        String insertAccountType= "INSERT INTO public.tblaccount"+
            "(accountid, aaccounttypeid, accountbalance, accountownershiptype, accountnumber, accountstatus)"+
            "VALUES (default, ?, ?, ?, ?, ?)";
        
        Long ojbATID = Long .parseLong(AccountTypeID);
        Double objABLC = Double.parseDouble(AccountBalance);
        try{
            // use excuteUpdate for staments that do not return rows
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(insertAccountType);
            objPreparedStatement.setLong(1,ojbATID );
            objPreparedStatement.setDouble(2,objABLC);
            objPreparedStatement.setString(3,AccountOwnershipType );
            objPreparedStatement.setString(4,AccountNumber);
            objPreparedStatement.setString(5,AccountStatus );
             
            int  Result =   objPreparedStatement.executeUpdate();
            System.out.println("New Account has been added ");
            
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    
    public void readAccount(){
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
            try{
                
                String  readAccountQuery =  "SELECT * FROM public.tblAccount ";
                PreparedStatement objPreparedStatement = objConnection.prepareStatement(readAccountQuery);
               
                ResultSet Result = objPreparedStatement.executeQuery();
                System.out.println("List of Accounts");
                System.out.println("-----------------------------------------------------------------------------------");
                while(Result.next()){
                    
                    System.out.println("___________________________________________________________________________________");
                    System.out.println("Account Number : "+Result.getString("accountnumber"));
                    System.out.println("Ownership Type : "+Result.getString("ownershiptype"));
                    System.out.println("Balance : "+Result.getString("Balance"));
                    System.out.println("Status : "+Result.getString("Status"));
                    System.out.println("___________________________________________________________________________________");
                }
            } catch(SQLException e){
                throw (new Error(e));
            }
    }
    public void updateAccount(String AccountID, String AccountTypeID, String  AccountBalance, String AccountOwnershipType, String AccountNumber, String AccountStatus, String msg){
        ServerConnect objServerConnection = new ServerConnect();// step 1
        Connection objConnection = objServerConnection.connectToServer();// step 2
        Long objAID = Long.parseLong(AccountID); 
        Long ojbATID = Long .parseLong(AccountTypeID);
        Double objABLC = Double.parseDouble(AccountBalance);

        try{
            String updateAccountTypeQuery = "UPDATE public.tblaccount " + //step 3
                                            "SET aaccounttypeid=?, accountbalance=?, accountownershiptype=?, accountnumber=?, accountstatus=? "+
                                            "WHERE accountid = ?;";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateAccountTypeQuery); 
            objPreparedStatement.setLong(1,ojbATID); 
            objPreparedStatement.setDouble(2,objABLC);
            objPreparedStatement.setString(3,AccountOwnershipType);
            objPreparedStatement.setString(4,AccountNumber);
            objPreparedStatement.setString(5,AccountStatus);
            objPreparedStatement.setLong(6,objAID); 
            objPreparedStatement.executeUpdate();
            System.out.println(msg);
        }
        catch (SQLException e){
            System.out.println(e.toString());
            throw  (new Error(e));
            
        }
    }
    public void deleteAccount(String ID){
        ServerConnect objServerConnection = new ServerConnect();   // step 1
        Connection objConnection = objServerConnection.connectToServer();// step 2
        Long objID = Long.parseLong(ID); 
        try {
            String deleteQuery = "DELETE FROM public.tblaccount" +  // step 3
            " WHERE id = ?;";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);// step 4
            objPreparedStatement.setLong(1,objID); // step 5
            objPreparedStatement.executeUpdate();
            System.out.println("New Account has been deleted ");
        } catch (Exception e) {
            throw  (new Error(e));
        }
    }
    public Object getSingleAccount(String AccountNumber){
        Account objAccount = new Account();
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
       
        try{
            // objStatement.executeQuery(strInsertUser);
            String getAccountQuery= "SELECT * FROM public.tblaccount "
                                         + " Where accountnumber = ?";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(getAccountQuery);
            objPreparedStatement.setString(1, AccountNumber);
            ResultSet Result = objPreparedStatement.executeQuery();
            
            //accountid, aaccounttypeid, accountbalance, accountownershiptype, accountnumber, accountstatus
           
            while(Result.next()){
                // here we are retierving data and send it to the calling method based on ID 
                objAccount.accountid = Result.getString("accountid");
                objAccount.aaccounttypeid = Result.getString("aaccounttypeid");
                objAccount.accountbalance =  Result.getString("accountbalance");
                objAccount.accountownershiptype =  Result.getString("accountownershiptype");
                objAccount.accountnumber = Result.getString("accountnumber");
                objAccount.accountstatus = Result.getString("accountstatus");
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
        return objAccount;

    }
    public List<Account> getAccounts()
    {
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();

        List<Account> AccountsList = new ArrayList<Account>();
        Account objAccount = new Account();
        try{
            // objStatement.executeQuery(strInsertUser);
            String  listAccountQuery =  "SELECT * FROM public.tblaccount ";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(listAccountQuery);
            ResultSet Result = objPreparedStatement.executeQuery();
            //accountid, aaccounttypeid, accountbalance, accountownershiptype, accountnumber, accountstatus
            while(Result.next()){
                objAccount.accountid = Result.getString("accountid");
                objAccount.aaccounttypeid =Result.getString("aaccounttypeid");
                objAccount.accountbalance = Result.getString("accountbalance");
                objAccount.accountownershiptype = Result.getString("accountownershiptype");
                objAccount.accountnumber = Result.getString("accountnumber");
                objAccount.accountstatus = Result.getString("accountstatus");
                AccountsList.add(objAccount);
            }
        } catch(SQLException e){
            throw (new Error(e));
        }

        return AccountsList;
    }
    public String getLastDataEntry()
    {
        // I AM BUILDING THIS FUNCTION SO THAT I KNOW THE ID OF THE LAST ITEM THAT HAS BEEN ADDED TO THE DB , SO THAT I CAN USE IT TO GENERATE THE BANK ACCOUNT NUMBER 
        // like if the last id , is 13 the bank account number would be 1000-722022-13 or some thing like this 
        //
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        try{
            String getLastQuery = "select max(accountID) from public.tblaccount ";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLastQuery);
            ResultSet Result = objPreparedStatement.executeQuery();
            String lastID ="";
            while(Result.next()){
                lastID = Result.getString(1);
                if(lastID == null){
                    lastID = "0";
                }
            }
            
           
            return lastID;
        }catch(SQLException e){
            throw(new Error(e));
        }
    }
    
    
    
}
