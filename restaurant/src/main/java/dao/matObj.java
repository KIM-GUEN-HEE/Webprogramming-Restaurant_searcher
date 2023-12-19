package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class matObj {
	private String name, category, location, pricerange;
	
	public matObj(String name, String category, String location, String pricerange) {
		this.name = name;
		this.category = category;
		this.location = location;
		this.pricerange = pricerange;
	}
	public matObj(String name) {
		this.name = name;
		
	}
	public matObj() {
		
	}
	
	public String getName() {return this.name;}
	public String getCategory() {return this.category;}
	public String getLocation() {return this.location;}
	public String getPricerange() {return this.pricerange;}
}
