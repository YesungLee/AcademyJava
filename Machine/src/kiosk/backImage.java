package kiosk;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class backImage extends JFrame { // 배경화면 담당하는 클래스

	ImageIcon icon = new ImageIcon("images/main.png"); // 백그라운드 이미지 가져오기
	JScrollPane scrollPane;
	

	backImage() {
		setTitle("버거킹 무인 메뉴 시스템"); // 프레임 이름
		setSize(720, 1080); // 프레임 크기
		

		BackGround BackPanel = new BackGround();
		BackPanel.setLayout(null);

		// 화면보다 더 큰 컴포넌트를 표시하기 위해 스크롤 페인 선언
		scrollPane = new JScrollPane(BackPanel);
		setContentPane(scrollPane);

		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료시 메모리에서 제거

		JPanel panel1 = new JPanel();

		add(panel1);
		setVisible(true); // 화면에 표시
	}

	// 배경화면 표시
	class BackGround extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
	}
}
