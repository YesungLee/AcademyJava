package kiosk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbDao { // 입력한 아이디와 비밀번호를 확인 하는 클래스

		// 상태-변수(DB에 접속하는 id, pw, connnection...)
		// 공통적으로 사용하기에 static으로 선언
		static String url = "jdbc:oracle:thin:@localhost:1521:xe";
		static String user = "java";
		static String password = "1234";
		// DB 접속 리소스는 4개밖에 없다.
		static Connection conn = null; // 접속
		static Statement stmt = null;
		static ResultSet rs = null; // 결과
		static PreparedStatement pstmt = null;

		// 동작-메소드
		// [getconnect()-접속, dbclose()-종료] 같이 따라다님
		static void getconnect() {
			if (conn == null) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
				} catch (ClassNotFoundException e1) {
					System.out.println("드라이버 에러 : " + e1.getMessage());
				} catch (SQLException e2) {
					// System.out.println("접속 에러는 ?");
				}
			}
		}

		// 종료 메소드
		static void dbclose() {
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (SQLException e) {
				}
			}
		}

}
