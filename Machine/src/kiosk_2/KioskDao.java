package kiosk_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class KioskDao {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "java";
	private static final String password = "1234";
	
	 Connection con = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 PreparedStatement pstmt = null;
	

	public Connection getconnect() {
	      if (con == null) {
	          try {
	             // 자신의 DB가 제공하는 드라이버 이름을 명시하여 호출
	             // 호출된 Driver가 자기 자신을 초기화하여 객체가 생성되고, DriverManager에 등록한다
	             Class.forName(driver);
	             // Connection 객체를 이용해 DriverManager에 등록된 DB와 연결을 한다.
	             // 연결에 성공하면 Connection 객체가 반환되고, 실패하면 예외가 발생한다.
	             con = DriverManager.getConnection(url, user, password);
	          } catch (ClassNotFoundException e1) {
//	             System.out.println("DB 드라이버 로딩 실패 : " + e1.getMessage());
//	             System.out.println("DB 드라이버 로딩 실패 : " + e1.toString());
	          } catch (SQLException e2) {
//	             System.out.println("DB 접속 실패 : " + e2.toString());
	          } catch (Exception e3) {
//	             System.out.println("Unknown error");
	             e3.printStackTrace();
	          }
	       }
		return con;
	    }
	
	   // DB 종료 메소드
	   public void dbclose() {
	      try {
	         if (con != null)
	            con.close();
	         if (rs != null)
	            rs.close();
	         if (stmt != null)
	            stmt.close();
	         if (pstmt != null)
	            pstmt.close();
	      } catch (SQLException e) {
//	         System.out.println(e + "-> dbclose 실패");
	      }
	   }
	   
	// 관리자 아이디로 로그인 했는지 체크하는 메소드
	   @SuppressWarnings("null")
	public int idCheck(String id, String pw) {
	      int rst = 0;
	      getconnect(); // DB 접속
	      try {
	         // SQL 구문
	         String sql = "SELECT COUNT(*) AS CNT FROM EMPS WHERE ID=? AND PW=?";
	         pstmt = con.prepareStatement(sql); 
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

	public int insertProduct(KioskVo dto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = getconnect();
			String sql = "insert into product values (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getKind());
			ps.setString(2, dto.getMenu());			
			ps.setInt(3, dto.getPrice());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // ps try - catch
			} // ps if
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				} // con try - catch
			} // con if
		} // try - catch - finally
		return result;
	}

	public Vector getProduct() {
		Vector data = new Vector();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		      con = getconnect();
		      String sql = "select kind, menu, price from product order by kind asc";
		      stmt = con.createStatement();
		      rs = stmt.executeQuery(sql);
		 
		      while (rs.next()) {
		    	int kind = rs.getInt("kind");
		    	String menu = rs.getString("menu");		       
		        int price = rs.getInt("price");
		        
		        Vector row = new Vector();
		        row.add(kind);
		        row.add(menu);
		        row.add(price);		      
		        data.add(row);
		      } // while
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      if (rs != null) { try { rs.close(); } catch (SQLException e2) { e2.printStackTrace(); } // rs try - catch
		      } // rs if
		      if (stmt != null) { try { stmt.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
		      } // stmt if
		      if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
		      } // con if
		    } // try - catch - finally
		    return data;
	}
	
	public int updateProduct(KioskVo dto) {
		Connection con = null;
	    PreparedStatement ps = null;
	    int result = 0;
	    try {
	        con = getconnect();
	        String sql = "update product set kind=?, price=? where menu=?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, dto.getKind());
	        ps.setInt(2, dto.getPrice());	        
	        ps.setString(3, dto.getMenu());
	        result = ps.executeUpdate();
	      } catch (Exception e) {
	        e.printStackTrace();
	      } finally {
	        if (ps != null) { try { ps.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
	        } // ps if
	        if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
	        } // con if
	      } // try - catch - finally
	      return result;		
	}
	
	public int deleteProduct(KioskVo dto) {
		Connection con = null;
	    PreparedStatement ps = null;
	    int result =0;
	    try {
	    	con = getconnect();
	    	String sql = "delete product where menu=?";
	    	ps = con.prepareStatement(sql);
	    	ps.setString(1, dto.getMenu());
	    	result = ps.executeUpdate();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	        if (ps != null) { try { ps.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
	        } // ps if
	        if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
	        } // con if
	      } // try - catch - finally
	      return result;
	}
	
	

}
