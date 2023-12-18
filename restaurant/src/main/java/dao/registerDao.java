package dao;

import java.sql.*;
import javax.naming.NamingException;
import util.*;
import java.util.*;


public class registerDao {
	
	
	public boolean insert(String matname, String matcategory, String matlocation, String pricerange) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try 
		{
			String sql = "insert into matplace(name,category,location,pricerange,ts) values(?,?,?,?,?)";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, matname);
			stmt.setString(2, matcategory);
			stmt.setString(3, matlocation);
			stmt.setString(4, pricerange);
			stmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
			
			int count = stmt.executeUpdate();
			return (count>0) ? true : false;
		}
		finally 
		{
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
	
	public boolean exists(String matname) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			String sql = "select name from matplace where name = ?";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, matname);
			
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
	
	public ArrayList<matObj> search(String matname) throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "select * from matplace where name like ?";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + matname + "%");
			rs = stmt.executeQuery();
			
			ArrayList<matObj> searches = new ArrayList<matObj>();
			while(rs.next()) {
				searches.add(new matObj(rs.getString("name"),rs.getString("category"),rs.getString("location"),rs.getString("pricerange")));
			}
			return searches;
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
}
