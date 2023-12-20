package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import util.ConnectionPool;

public class likeDAO {
	public boolean insert(String matname, String uname) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try 
		{
			String sql = "insert into likey(matname,uname) values(?,?)";
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
	public boolean likecheck(String matname, String uname) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select matname,uname from likey where uname = ? and matname = ?";
			
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
	
	public int likecount(String matname) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) from likey where matname = ?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, matname);
			System.out.println("matname : " + matname);
			
			rs = stmt.executeQuery();
			if (!rs.next()) { return 0;}
			return rs.getInt(1);
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
			String sql = "delete from likey where matname = ? and uname = ?";
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
	/*
	public String likelist(String matname) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select matname, count(matname) from likey group by matname";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			
			System.out.println("matname : " + matname);
			
			rs = stmt.executeQuery();
			if (!rs.next()) { return 0;}
			return 
		} finally {
			if (rs != null)rs.close();
			if (stmt!=null)stmt.close();
			if (conn!= null)conn.close();
		}
	}
	
	*/
}
