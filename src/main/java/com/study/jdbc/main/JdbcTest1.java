package main.java.com.study.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import main.java.com.study.jdbc.util.DBConnection;

public class JdbcTest1 {

	public static void main(String[] args) {
		Connection connection = DBConnection.getInstance().getConnection();
		
		String sql = "select * from score_mst";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("id\tname\t\tscore");
			
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1) 
				+ "\t name: " + rs.getString(2) 
				+ "\t score: " + rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}









