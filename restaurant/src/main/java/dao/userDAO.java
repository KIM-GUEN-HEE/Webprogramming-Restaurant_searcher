package dao;

import java.sql.*;
import javax.naming.NamingException;
import util.ConnectionPool;
import java.util.*;


public class userDAO {
	// 멤버변수
	// 멤버함수(메소드)
	public boolean insert(String uid, String upass, String uname, String uphone, String uemail, String ubirth) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try 
		{
			String sql = "insert into user(id,pw,name,phone,email,birth) values(?,?,?,?,?,?)";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, upass);
			stmt.setString(3, uname);
			stmt.setString(4, uphone);
			stmt.setString(5, uemail);
			stmt.setString(6, ubirth);
			
			int count = stmt.executeUpdate();
			return (count>0) ? true : false;
		}
		finally 
		{
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
	public boolean exists(String uid) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			String sql = "select id from user where id = ?";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			
			rs = stmt.executeQuery();
			return rs.next();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
		
	}
	public boolean delete(String uid) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try 
		{
			String sql = "delete from user where id = ?";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			int count = stmt.executeUpdate();
			return (count >0) ? true : false;
		}
		finally
		{
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
	
	public int login(String uid, String upass) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select id, pw from user where id = ?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			
			rs = stmt.executeQuery();
			if (!rs.next()) return 1;
			if (!upass.equals(rs.getString("pw"))) return 2;
			return 0;
		} finally {
			if (rs != null)rs.close();
			if (stmt!=null)stmt.close();
			if (conn!= null)conn.close();
		}
	}
	
	
	
	
}
