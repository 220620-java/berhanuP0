package com.revature.berhanu.prj0.Models;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.berhanu.prj0.Utility.ServerConnect;

import java.sql.*;

public class AccountUser {
    public String AccountUserId, AUUserID, AUAccountID;
    
    public void createAccountUser(String auuserid, String auaccountid){
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        String insertAccountUserQuery= "INSERT INTO public.tblaccountuser("+
            "accountuserid, auuserid, auaccountid)"+
            "VALUES (default, ?, ?)";
        Long objAUUserID = Long .parseLong(auuserid);
        Long objAUAccountID = Long .parseLong(auaccountid);
        try{
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(insertAccountUserQuery);
            objPreparedStatement.setLong(1,objAUUserID);
            objPreparedStatement.setLong(2,objAUAccountID );
             objPreparedStatement.executeUpdate();
            System.out.println("The Account has been linked to a user");  
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public List<AccountUser> getAccountUsers()
    {   
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        List<AccountUser> AccountUserList = new ArrayList<AccountUser>();
        AccountUser objAccountUser = new AccountUser();
         
        try{
            String  listAccountUserQuery =  "SELECT * FROM public.tblaccountuser ";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(listAccountUserQuery);
            ResultSet Result = objPreparedStatement.executeQuery();
            while(Result.next()){
                objAccountUser.AccountUserId = Result.getString("accountuserid");
                objAccountUser.AUUserID = Result.getString("auuserid");
                objAccountUser.AUAccountID = Result.getString("auaccountid");
                AccountUserList.add(objAccountUser);
            }
        } catch(SQLException e){
            throw (new Error(e));
        }
        return AccountUserList;
                
    }
    public void updateAccountUser(String accountuserid, String auuserid, String auaccountid){
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        String updateAccountUserQuery= "UPDATE public.tblaccountuser"+
        "SET  auuserid=?, auaccountid=?"+
        "WHERE accountuserid=?;)";
        Long objAccountUserID = Long.parseLong(accountuserid);
        Long objAUUserID = Long .parseLong(auuserid);
        Long objAUAccountID = Long .parseLong(auaccountid);
        try{
            // use excuteUpdate for staments that do not return rows
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateAccountUserQuery);
            objPreparedStatement.setLong(1,objAUUserID);
            objPreparedStatement.setLong(2,objAUAccountID );
            objPreparedStatement.setLong(3,objAccountUserID );
             
               objPreparedStatement.executeUpdate();
            System.out.println("The Account link has been updated");  
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public void deleteAccountUser(String accountuserid){
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        String deleteAccountUserQuery= "DELETE FROM public.tblaccountuser WHERE accountuserid=?;";

        Long objAccountUserID = Long.parseLong(accountuserid);
        
        try{
            // use excuteUpdate for staments that do not return rows
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteAccountUserQuery);
            objPreparedStatement.setLong(1,objAccountUserID);
             
               objPreparedStatement.executeUpdate();
            System.out.println("The Account link has been deleted");  
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public Object getSingleAccountType (String ID){
        
        AccountUser objAccountUser = new AccountUser(); 
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        Long objID = Long.parseLong(ID);
 
        try{
            // objStatement.executeQuery(strInsertUser);
            String getAccountUserQuery= "SELECT * FROM public.tblaccountuser "
                                      + "Where ID = ?";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(getAccountUserQuery);
            objPreparedStatement.setLong(1, objID);
            ResultSet Result = objPreparedStatement.executeQuery();
           
            while(Result.next()){
                // here we are retierving data and send it to the calling method based on ID 
                objAccountUser.AccountUserId = Result.getString("accountuserid");
                objAccountUser.AUUserID = Result.getString("auuserid");
                objAccountUser.AUAccountID = Result.getString("auaccountid");
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
        return objAccountUser;
    }

}
