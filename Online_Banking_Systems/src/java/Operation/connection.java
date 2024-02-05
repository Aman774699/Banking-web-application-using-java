
package Operation;
import Customers.Client;
import Operation.connection;
import Myconnection.Getconnect;
import java.sql.*;
import Operation.Account_holder_operation;

public class connection {
      
        public void insertClient(Client c)
        {
           
            try{
                Connection con;
                PreparedStatement ps;
                con=Getconnect.getconnect();
                String sql="insert into new_registration values(?,?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setString(1,c.getUsername());
                ps.setString(2,c.getPassword());
                ps.setString(3,c.getConfirm_password());
                ps.setString(4,c.getEmail());
                ps.setString(5,c.getFull_name());
                ps.executeUpdate();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        public void loginClient(Client c)
        {
          try{
               Connection con;
                PreparedStatement ps;
                con=Getconnect.getconnect();
                String sql="insert into  Login_client values(?,?)";
                ps=con.prepareStatement(sql);
                ps.setString(1, c.getNetBankingId());
                ps.setString(2, c.getPassword());
                ps.executeUpdate();
              }
          catch(Exception e)
           {
               System.out.println(e);
           }
        }
        
        public boolean check(String username,String password)
        {
            try{
                Connection con=null;
                PreparedStatement ps=null;
                ResultSet rs=null;
                con=Getconnect.getconnect();
                String sql="select * from  Login_client where username=? and password=?";
                ps=con.prepareStatement(sql);
                Client c=new Client();
                ps.setString(1, username);
                ps.setString(2, password);
                rs=ps.executeQuery();
                if(rs.next()){
                    return true;
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return false;
        }

        public boolean validuser(String email,Client c1)
        {
          Account_holder_operation aho=new Account_holder_operation();
                 try{
                Connection con;
                PreparedStatement ps;
                ResultSet rs;
                con=Getconnect.getconnect();
                String  sql="select * from account_holders where email=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, email);
                rs=ps.executeQuery();
                if(rs.next())
                {
                     insertClient(c1);
                     return true;
                }
                }
            catch(Exception e)
            {
                System.out.println(e);
            }
                 System.out.println("Customer does not exist in our banking system");
                 return false;
        }        
}
