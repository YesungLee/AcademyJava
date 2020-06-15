package kiosk;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.crypto.Data;

public class admin {
	
	JFrame frame = new JFrame(""); // 프레임 선언
	JDialog dialog = new JDialog(frame, "관리자 페이지"); // 다이얼로그 선언
	JPanel pan = new JPanel(); // 패널 선언
	JLabel lblNo = new JLabel("주문 번호");
	JLabel lblMenu = new JLabel("주문 메뉴");
	JTextArea txtOrdered = new JTextArea(""); // 주문된 목록을 확인할 txtOrdered 선언
	JScrollPane scrollpane = new JScrollPane(txtOrdered); // txtOrdered에 scrollbar를 만들어줌
	
	public admin() {
		dialog.setSize(400, 300); // 다이얼로그의 크기 설정
		dialog.setVisible(true); // 다이얼로그를 표시 해줌
		dialog.setResizable(false); // 창 크기 조절 불가
		dialog.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// X 버튼 누르면 다이얼로그만 종료
		dialog.setContentPane(pan); // 일반적인 컴포넌트들을 가질 수 있는 패널
		
		txtOrdered.setEditable(false); // 수정하지 못하도록 설정
		
		pan.setLayout(null); // 레이아웃에 속하지 않음
		// panel에 label과 textfield 추가, 좌표 지정
		pan.add(lblNo);
		lblNo.setBounds(50, 20, 60, 30);
		pan.add(lblMenu);
		lblMenu.setBounds(230, 20, 60, 30);
		pan.add(txtOrdered);
		txtOrdered.setBounds(40, 60, 300, 200);
		
		// Ordered 테이블을 읽어옴
		dbDao dao = new dbDao();
		ArrayList<dbVo> arr = new ArrayList<dbVo>();
		arr = dao.importOrdered();
		for (int i=0; i<arr.size(); i++) {
			txtOrdered.append(arr.get(i).getNo() + " \t " + arr.get(i).getMenu());
		}
	}

}
