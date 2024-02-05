
package Operation;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import Customers.account_holder;
import java.sql.*;
import Myconnection.Getconnect;
import java.util.ArrayList;
import Customers.Transactions;

public class Transaction {

    public void maintainTransaction(long debitaccount,long creditaccount,long amount,String transaction_type,long currentbalance) {
        try{
        Connection con;
        PreparedStatement ps;
        con = Getconnect.getconnect();
        String sql = "insert into transactions(account_from,account_to,amount,transaction_type,current_balance) values(?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setLong(1, debitaccount);
        ps.setLong(2, creditaccount);
        ps.setLong(3,amount);
        ps.setString(4, transaction_type);
        ps.setLong(5, currentbalance);
        ps.executeUpdate();
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public Transactions fetchtransition(long accountnumber)
    {
        Transactions tn=new Transactions();
        try{
            Connection con;
            PreparedStatement ps;
            con=Getconnect.getconnect();
            String sql="Select * from transactions where account_from=?";
            ps=con.prepareStatement(sql);
            ps.setLong(1, accountnumber);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                 tn.setTransactions_id(rs.getInt(1));
                 tn.setTransaction_date(rs.getString(2));
                 tn.setAccount_from(rs.getInt(3));
                 tn.setAccount_to(rs.getInt(4));
                 tn.setAmont(rs.getInt(5));
                 tn.setTransaction_type(rs.getString(6));
                 tn.setCurrentbalance(rs.getLong(7));
                 return tn;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return tn;
    }
}
