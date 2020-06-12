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
	Connection conn = null; // 접속
	Statement stmt = null;
	ResultSet rs = null; // 결과
	PreparedStatement pstmt = null;

	// 생성자 -> DB 연결 역할
	dbDao() {
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				// System.out.println("접속 성공");
			} catch (ClassNotFoundException e1) {
				System.out.println("드라이버 에러 : " + e1.getMessage());
			} catch (SQLException e2) {
				// System.out.println("접속 에러는 ?");
			}
		}
	}

	// DB 접속 메소드
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

	// DB 종료 메소드
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

	// 관리자 아이디로 로그인 했는지 체크하는 메소드
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

	public void importOrdered() {
		admin temp = new admin();
		getconnect(); // DB 접속
		try {
			String sql = "SELECT NO, MENU FROM ORDERED";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				temp.txtOrdered.setText(rs.getString("NO") + "\t" + rs.getString("MENU"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbclose(); // DB 종료
	}
	/*
	// Ordered 테이블을 읽어오는 메소드
	public dbVo importOrdered() {
		dbVo temp = new dbVo();
		getconnect(); // DB 접속
		try {
			String sql = "SELECT NO, MENU FROM ORDERED";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 쿼리에 실행에 따라 4가지 값을 가져옴
			if (rs.next()) {
				temp.setNo(rs.getString("NO"));
				temp.setMenu(rs.getString("MENU"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbclose(); // DB 종료
		return temp;
	}
	*/
}
