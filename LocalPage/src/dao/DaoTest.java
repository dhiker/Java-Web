package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Account;

public class DaoTest {
	public Account getQuery(String id) {
		String query[]= new String [2];
		Account a= new Account();
		DaoTest d= new DaoTest();
		
		query[0]= "select * from account where id=?";				//StringArray for PreparedStatement
		query[1]= id;
		
		String queryrs= d.queryDb(query);							
		if(!queryrs.equals("")) {									//check execute result is empty or not
			String querysa[]= queryrs.split(",");					//split result and set value object
			a.setId(querysa[0]);
			a.setPw(querysa[1]);
		}
		
		return a;													//return a value object
	}
	
	private String queryDb(String query[]) {
		String url= "jdbc:mariadb://localhost:3306/eclipsetest";
		String username= "test";
		String password= "sa";
		
		try(Connection conn= DriverManager.getConnection(url, username, password);	//add auto-close objects
				PreparedStatement pstmt= conn.prepareStatement(query[0]);
				) {					
			for(int i=1;i<query.length;i++)											//set value to PreparedStatement
				pstmt.setString(i, query[i]);
				
			ResultSet rs= pstmt.executeQuery();										//execute PreparedStatement
			
			while(rs.next()){														//make result to 1 string and return if have result
				String id= rs.getString("id");
				String pwd= rs.getString("password");
				
				rs.close();
				return id + ","+ pwd;
			}
			
			rs.close();
			return "";
						
		}catch(SQLException e) {						// add driver jar to \Java\lib\ext to avoid SQLException
			return "";
		}
	}
}