package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class order extends JFrame { // 화면을 표시하기 위한 JFrame 상속
	
	JPanel pan1 = new JPanel();
	JButton btn = new JButton("버거");
	
	
	public order() {
		this.setTitle("주문 화면"); // 프레임 제목
		this.setSize(720, 1080); // 프레임 사이즈
		this.setResizable(false); // 창 크기 조절 불가
		this.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setContentPane(pan1); // 일반적인 컴포넌트들을 가질 수 있는 패널
		pan1.setLayout(null); // 레이아웃 받지 않음
		btn.setBounds(100, 100, 100, 100); // btn 좌표, 사이즈 값 지정
		pan1.add(btn); // pan1에 btn 추가
		this.setVisible(true); // 프레임 표시
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // order 종료시 메모리에서 종료
		
	}
}
