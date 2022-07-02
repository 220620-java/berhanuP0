package com.revature.berhanu.prj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Transaction {
    String transactionid, tsourceuserid, tsourceaccountid, tdestinationuserid, tdestinationaccountid, amount, date, time, transactiontype, remark;
    public void createTransaction(String tsourceuserid,String tsourceaccountid, String tdestinationuserid, String tdestinationaccountid, String amount,String date,String time,String transactiontype,String remark){
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        String insertTransactionQuery= "INSERT INTO public.tbltransaction"+
            "(transactionid, tsourceuserid, tsourceaccountid, tdestinationuserid, tdestinationaccountid, amount, date, time, transactiontype, remark)"+
            "VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Long objTSUID = Long.parseLong(tsourceuserid);
        Long objTSAID = Long.parseLong(tsourceaccountid);
        Long objTDUID = Long.parseLong(tdestinationuserid);
        Long objTDAID = Long.parseLong(tdestinationaccountid);
        Double objAMNT = Double.parseDouble(amount);

        try{
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(insertTransactionQuery);
            objPreparedStatement.setLong(1,objTSUID);
            objPreparedStatement.setLong(2,objTSAID );
            objPreparedStatement.setLong(3,objTDUID);
            objPreparedStatement.setLong(4,objTDAID );
            objPreparedStatement.setDouble(5,objAMNT);
            objPreparedStatement.setString(6,date );
            objPreparedStatement.setString(7,time );
            objPreparedStatement.setString(8,transactiontype );
            objPreparedStatement.setString(9,remark );
            
            int  Result = objPreparedStatement.executeUpdate();
            System.out.println("Transaction Created");  
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public List<Transaction> getTransactions()
    {   
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        List<Transaction> TransactionList = new ArrayList<Transaction>();
        Transaction objTransaction = new Transaction();
         
        try{
            String  listTransactionQuery =  "SELECT * FROM public.tbltransaction ";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(listTransactionQuery);
            ResultSet Result = objPreparedStatement.executeQuery();
            while(Result.next()){
                objTransaction.transactionid = Result.getString("transactionid");
                objTransaction.tsourceuserid = Result.getString("tsourceuserid");
                objTransaction.tsourceaccountid = Result.getString("tsourceaccountid");
                objTransaction.tdestinationuserid = Result.getString("tdestinationuserid");
                objTransaction.tdestinationaccountid = Result.getString("tdestinationaccountid");
                objTransaction.amount = Result.getString("amount");
                objTransaction.date = Result.getString("date");
                objTransaction.time = Result.getString("time");
                objTransaction.transactiontype = Result.getString("transactiontype");
                objTransaction.remark = Result.getString("remark");
                TransactionList.add(objTransaction);
            }
        } catch(SQLException e){
            throw (new Error(e));
        }
        return TransactionList;
                
    }
    public void updateTransaction(String transactionid, String tsourceuserid,String tsourceaccountid, String tdestinationuserid, String tdestinationaccountid, String amount,String date,String time,String transactiontype,String remark){
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        String updateTransactionQuery= "UPDATE public.tbltransaction"+
        "SET  tsourceuserid=?, tsourceaccountid=?, tdestinationuserid=?, tdestinationaccountid=?, amount=?, date=?, time=?, transactiontype=?, remark=?"+
        "WHERE transactionid=?";
        Long objTRNID = Long.parseLong(transactionid);
        Long objTSUID = Long.parseLong(tsourceuserid);
        Long objTSAID = Long.parseLong(tsourceaccountid);
        Long objTDUID = Long.parseLong(tdestinationuserid);
        Long objTDAID = Long.parseLong(tdestinationaccountid);
        Double objAMNT = Double.parseDouble(amount);

        try{
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateTransactionQuery);
            objPreparedStatement.setLong(1,objTSUID);
            objPreparedStatement.setLong(2,objTSAID );
            objPreparedStatement.setLong(3,objTDUID);
            objPreparedStatement.setLong(4,objTDAID );
            objPreparedStatement.setDouble(5,objAMNT);
            objPreparedStatement.setString(6,date );
            objPreparedStatement.setString(7,time );
            objPreparedStatement.setString(8,transactiontype );
            objPreparedStatement.setString(9,remark );
            objPreparedStatement.setLong(10,objTRNID);
            
            int  Result = objPreparedStatement.executeUpdate();
            System.out.println("Transaction Created");  
        }
        catch(SQLException e){
            throw (new Error(e));
        }
    }
    public void deleteTransaction(String ID){
        ServerConnect objServerConnection = new ServerConnect();   
        Connection objConnection = objServerConnection.connectToServer();
        Long objID = Long.parseLong(ID); 
        try {
            String deleteQuery = "DELETE FROM public.tbltransaction" +  
            " WHERE id = ?;";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);// step 4
            objPreparedStatement.setLong(1,objID); 
            objPreparedStatement.executeUpdate();
            System.out.println("Transaction Deleted ");
        } catch (Exception e) {
            throw  (new Error(e));
        }
    }
    public Object getSingleTransaction(String ID){
        Transaction objTransaction = new Transaction(); 
        ServerConnect objServerConnection = new ServerConnect();
        Connection objConnection = objServerConnection.connectToServer();
        Long objID = Long.parseLong(ID);
 
        try{
            // objStatement.executeQuery(strInsertUser);
            String getSingleTransactionQuery= "SELECT * FROM public.tbltransaction "
                                      + "Where ID = ?";
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleTransactionQuery);
            objPreparedStatement.setLong(1, objID);
            ResultSet Result = objPreparedStatement.executeQuery();
           
            while(Result.next()){
                objTransaction.transactionid = Result.getString("transactionid");
                objTransaction.tsourceuserid = Result.getString("tsourceuserid");
                objTransaction.tsourceaccountid = Result.getString("tsourceaccountid");
                objTransaction.tdestinationuserid = Result.getString("tdestinationuserid");
                objTransaction.tdestinationaccountid = Result.getString("tdestinationaccountid");
                objTransaction.amount = Result.getString("amount");
                objTransaction.date = Result.getString("date");
                objTransaction.time = Result.getString("time");
                objTransaction.transactiontype = Result.getString("transactiontype");
                objTransaction.remark = Result.getString("remark");
            }
        }
        catch(SQLException e){
            throw (new Error(e));
        }
        return objTransaction;
    }
}
