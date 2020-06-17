package kiosk_2;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class KioskMain extends JFrame{
	
	
	//컨포넌트 컨트롤
	
	
	KioskMain() { // 생성자
		KioskPanel01 kioskPanel01 = new KioskPanel01();
		KioskPanel02 kioskPanel02 = new KioskPanel02();
		
		setTitle("Hamburger Kiosk");		
		
		JPanel mainPanel = new JPanel(); // 메인페널 생성 후 메인패널 위에 패널1 ,5 생성			
		
		mainPanel.setLayout(new GridLayout(2,1));		
		
		mainPanel.add(kioskPanel01);  // 초기화면을 JPanel01 클래스로 받는다.
		mainPanel.add(kioskPanel02);
		
		add(mainPanel);
		
		setSize(730, 700); // 화면 사이즈
		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); // 화면 활성화		
	}

	public static void main(String[] args) {
		new KioskMain();

	}

}
