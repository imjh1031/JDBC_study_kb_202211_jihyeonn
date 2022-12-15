package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("작성자 id : ");
		int writer_id = scanner.nextInt();
		
		Connection connection = DBConnection.getInstance().getConnection();
		
		String sql = "select * from board_mst where writer_id = ?"; // 1.
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, writer_id); 							// 2. (1)쿼리를 읽는 첫번째 물음표(?)
			ResultSet rs = pstmt.executeQuery();					// select 때만 Result가 필요함
			
			System.out.println("id\ttitle\t\tcontent\t\t\tread_count\twriter_id");
			
			while(rs.next()) {
				System.out.println("id : " + rs.getInt(1)
				+ "\ttitle : " + rs.getString(2)
				+ "\tcontent : " + rs.getString(3)
				+ "\tread_count : " + rs.getInt(4)
				+ "\twriter_id : " + rs.getInt(5));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
