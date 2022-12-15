package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcInsert1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("등록할 아이디를 입력하세요. ");
		String username = scanner.nextLine();
		
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "insert into user_mst values(0, ?)";			// 1.
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			int successCount = pstmt.executeUpdate();				// 2. executeUpdate() 몇 행이 들어간지 successCount에 입력됨
			System.out.println("데이터 " + successCount + "건 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
