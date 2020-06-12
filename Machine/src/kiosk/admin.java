package kiosk;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class admin {
	
	JFrame frame = new JFrame(""); // 프레임 선언
	JDialog dialog = new JDialog(frame, "관리자 페이지"); // 다이얼로그 선언
	JPanel pan = new JPanel(); // 패널 선언
	
	public admin() {
		dialog.setSize(700, 700); // 다이얼로그의 크기 설정
		dialog.setVisible(true); // 다이얼로그를 표시 해줌
		dialog.setResizable(false); // 창 크기 조절 불가
		dialog.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// X 버튼 누르면 다이얼로그만 종료
		dialog.setContentPane(pan); // 일반적인 컴포넌트들을 가질 수 있는 패널
	}

}
