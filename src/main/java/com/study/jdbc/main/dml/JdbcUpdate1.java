package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcUpdate1 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 계정의 id를 입력하세요. ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("수정할 아이디 입력 : ");
		String username = scanner.nextLine();
		
		Connection con =  DBConnection.getInstance().getConnection();
		String sql = "update user_mst set username = ? where id = ?"; // 1번 ? : username. 2번 ? : where
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, id);
			int successCount = pstmt.executeUpdate();
			System.out.println(successCount + "건 수정완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
