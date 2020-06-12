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
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "java";
			String password = "1234";
			// DB 접속 리소스는 4개밖에 없다.
			Connection conn = null; // 접속
			Statement stmt = null;
			ResultSet rs = null; // 결과
			PreparedStatement pstmt = null;
	
	dbDao() { // 생성자 -> DB 연결 역할
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
		//		System.out.println("접속 성공");
			} catch (ClassNotFoundException e1) {
				System.out.println("드라이버 에러 : " + e1.getMessage());
			} catch (SQLException e2) {
				// System.out.println("접속 에러는 ?");
			}
		}
	}
	
	public void getconnect() {
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

	
	public void dbclose() {
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
	
	public int idCheck(String id, String pw) {
		int rst = 0;
		getconnect(); // DB 접속
		try {
			// SQL 구문
			String sql = "SELECT COUNT(*) AS CNT FROM EMPS WHERE ID=? AND PW=?";
			pstmt = conn.prepareStatement(sql); // SQL 구문을 실행 시켜 줌
			pstmt.setString(1, id); // 첫 번째 물음표에 id를 넣음
			pstmt.setString(2, pw); // 두 번째 물음표에 pwd를 넣음
			rs = pstmt.executeQuery(); // rs에 객체의 값을 반환
			if (rs.next()) {
				rst = rs.getInt("CNT"); // CNT에 있는 결과를 읽음
			}
		} catch (SQLException e) { // 에러 발생 시 구문
			System.out.println("쿼리 에러 : " + e.getMessage());
		}
		dbclose(); // DB 종료
		return rst;
	}
}
