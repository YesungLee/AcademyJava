package kiosk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class dbDao { // 입력한 아이디와 비밀번호를 확인 하는 클래스

	// 상태-변수(DB에 접속하는 id, pw, connnection...)
	// 공통적으로 사용하기에 static으로 선언
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "java";
	static String password = "1234";
	// DB 접속 리소스는 4개밖에 없다.
	Connection conn = null; // DB와 연결하는 객체
	Statement stmt = null; // 정적쿼리 -> 인자 값이 변하지 않을 떄 사용, 그냥 가져오는 것
	ResultSet rs = null; // 결과
	// 인자만 변하고 구문이 같을 경우(쿼리문에 ? 사용하여 ?에 변수 할당이 가능한 객체)
	// 구문 생성 및 컴파일 시간을 단축 시킬 수 있도록 지원하는 클래스
	// 동적쿼리 -> 정적쿼리 보다 성능면에서 우위
	PreparedStatement pstmt = null;

	// DB 접속 메소드
	public void getconnect() {
		if (conn == null) {
			try {
				// 자신의 DB가 제공하는 드라이버 이름을 명시하여 호출
				// 호출된 Driver가 자기 자신을 초기화하여 객체가 생성되고, DriverManager에 등록한다
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// Connection 객체를 이용해 DriverManager에 등록된 DB와 연결을 한다.
				// 연결에 성공하면 Connection 객체가 반환되고, 실패하면 예외가 발생한다.
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e1) {
//            System.out.println("DB 드라이버 로딩 실패 : " + e1.getMessage());
//            System.out.println("DB 드라이버 로딩 실패 : " + e1.toString());
			} catch (SQLException e2) {
//            System.out.println("DB 접속 실패 : " + e2.toString());
			} catch (Exception e3) {
//            System.out.println("Unknown error");
				e3.printStackTrace();
			}
		}
	}

	// DB 종료 메소드
	public void dbclose() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
//         System.out.println(e + "-> dbclose 실패");
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
			rs = pstmt.executeQuery(); // 수행 결과를 객체의 값으로 반환
			if (rs.next()) {
				rst = rs.getInt("CNT"); // CNT에 있는 결과를 읽음
			}
		} catch (SQLException e) { // 에러 발생 시 구문
			System.out.println("쿼리 에러 : " + e.getMessage());
		}
		dbclose(); // DB 종료
		return rst;
	}

	// Ordered 테이블을 읽어오는 메소드
	public ArrayList<dbVo> importOrdered() {
		ArrayList<dbVo> arr = new ArrayList<dbVo>();
		getconnect();
		try {
			String sql = "SELECT NO, MENU FROM ORDERED";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				arr.add(new dbVo(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbclose();
		return arr;
	}

	// 해당 메뉴의 가격을 조회하는 메소드
	public int menuPrice(String menu) {
		int rst = 0;
		getconnect(); // DB 접속
		try {
			// SQL 구문
			String sql = "select price from product where menu='?'";
			pstmt = conn.prepareStatement(sql); // SQL 구문을 실행 시켜 줌
			pstmt.setString(1, menu); // 첫 번째 물음표에 id를 넣음
			rs = pstmt.executeQuery(); // 수행 결과를 객체의 값으로 반환
			if (rs.next()) {
				rst = rs.getInt("price"); // CNT에 있는 결과를 읽음
			}
		} catch (SQLException e) { // 에러 발생 시 구문
			System.out.println("쿼리 에러 : " + e.getMessage());
		}
		dbclose(); // DB 종료
		return rst;
	}

	// INSERT 메소드
	public void pay(int num, String menu) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			// 접속 성공시 conn = 접속결과 객체값
			stmt = conn.createStatement();
			String sql = "INSERT INTO ORDERED VALUES(?, ?)";
			stmt.executeUpdate(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, menu);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
		} catch (SQLException e2) {
			System.out.println("드라이버 접속실패");
			e2.printStackTrace();
		}
	}
}