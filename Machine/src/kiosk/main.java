package kiosk;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {

	//JPanel pan = new JPanel();
		JPanelChange win = new JPanelChange();
		JButton btnAdmin = new JButton("관리자");

		main() { // 생성자
			win.setTitle("Hamburger Kiosk");
			win.jpanel01 = new JPanel01(win);
			win.jpanel02 = new JPanel02(win);
			win.jpanel03 = new JPanel03(win);
			win.jpanel04 = new JPanel04(win);
			win.jpanel05 = new JPanel05(win);
			//JPanelBottom jb = new JPanelBottom();
			JPanel mainPanel = new JPanel(); // 메인페널 생성 후 메인패널 위에 패널1 ,5 생성
			
			
			mainPanel.setLayout(new GridLayout(2,1));
		
			
			mainPanel.add(win.jpanel01);  // 초기화면을 JPanel01 클래스로 받는다.
			mainPanel.add(win.jpanel05);  // 		
			
			//win.add(win.jpanel01); // 초기화면을 JPanel01 클래스로 받는다.

			win.add(mainPanel);		
			

			win.setSize(730, 500); // 화면 사이즈
			win.setResizable(false); // 창 크기 조절 불가
			win.setLocationRelativeTo(null); // 중앙에서 프레임 실행
			win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			win.setVisible(true); // 화면 활성화s		
		}

		public static void main(String[] args) {
			new main();
		}

}