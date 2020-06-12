package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {

	JPanel pan = new JPanel();
	JPanelChange win = new JPanelChange();
	JButton btnAdmin = new JButton("관리자");

	main() { // 생성자
		win.setTitle("Hamburger Kiosk");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.jpanel03 = new JPanel03(win);
		win.jpanel04 = new JPanel04(win);

		win.add(win.jpanel01); // 초기화면을 JPanel01 클래스로 받는다.
		win.setSize(730, 1080); // 화면 사이즈
		win.setResizable(false); // 창 크기 조절 불가
		win.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setVisible(true); // 화면 활성화
	}

	public static void main(String[] args) {
		new main();
	}

}