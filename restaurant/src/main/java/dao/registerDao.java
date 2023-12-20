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
	
	public ArrayList<matObj> array() throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "select * from matplace order by ts desc";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			ArrayList<matObj> recentlist = new ArrayList<matObj>();
			while(rs.next()) {
				recentlist.add(new matObj(rs.getString("name")));
			}
			return recentlist;
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
	
	public ArrayList<matObj> matlist() throws NamingException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "select * from matplace";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			ArrayList<matObj> matlist = new ArrayList<matObj>();
			while(rs.next()) {
				matlist.add(new matObj(rs.getString("name"),rs.getString("category"),rs.getString("location"),rs.getString("pricerange")));
			}
			return matlist;
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}
	/*
	public boolean addFavorite(String restaurantName) throws NamingException, SQLException
	{
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionPool.get(); // ConnectionPool 클래스는 실제 데이터베이스 연결을 관리하는 클래스로 가정합니다.

            // 아래 SQL문은 가정일뿐, 실제 데이터베이스에 맞게 수정해야 합니다.
            String sql = "INSERT INTO favorite (user_id, restaurant_id) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);

            // 사용자 아이디는 세션에서 가져오거나, 다른 방식으로 받아온다고 가정합니다.
            String userId = session.setAttribute("id", uid);

            stmt.setString(1, userId);
            stmt.setString(2, restaurantName);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // 즐겨찾기 추가 성공 여부를 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 예외 발생 시 실패로 간주
        } finally {
            // 리소스 정리
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addLike(String restaurantName)throws NamingException, SQLException
    {
        // addFavorite 메서드와 유사하게 구현
        return// 좋아요 테이블에 사용자 아이디와 식당 이름을 추가하는 쿼리문을 실행
    }
	*/
	
}






