package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import util.ConnectionPool;

public class starDAO {
   public boolean insert(String matname, String uname) throws NamingException, SQLException
   {
      Connection conn = null;
      PreparedStatement stmt = null;
      try 
      {
         String sql = "insert into favorite(matname,uname) values(?,?)";
         conn = ConnectionPool.get();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, matname);
         stmt.setString(2, uname);
         
         int count = stmt.executeUpdate();
         return (count>0) ? true : false;
      }
      finally 
      {
         if(stmt!=null) stmt.close();
         if(conn!=null) conn.close();
      }
   }
   public boolean starcheck(String matname, String uname) throws NamingException, SQLException
   {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
         String sql = "select matname,uname from favorite where uname = ? and matname = ?";
         
         conn = ConnectionPool.get();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, uname);
         stmt.setString(2, matname);
         
         rs = stmt.executeQuery();
         if (!rs.next()) return false;
         return true;
      } finally {
         if (rs != null)rs.close();
         if (stmt!=null)stmt.close();
         if (conn!= null)conn.close();
      }
   }
   
   public boolean delete(String matname, String uname) throws NamingException, SQLException
   {
      Connection conn = null;
      PreparedStatement stmt = null;
      try 
      {
         String sql = "delete from favorite where matname = ? and uname = ?";
         conn = ConnectionPool.get();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, matname);
         stmt.setString(2, uname);
         int count = stmt.executeUpdate();
         return (count >0) ? true : false;
      }
      finally
      {
         if(stmt!=null) stmt.close();
         if(conn!=null) conn.close();
      }
   }
   
}