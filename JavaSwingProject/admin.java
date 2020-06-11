package project;

import javax.swing.JFrame;

public class admin extends JFrame {
	public admin() {
		setTitle("관리자 모드");
		setSize(600, 600);
		setVisible(true);
		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
