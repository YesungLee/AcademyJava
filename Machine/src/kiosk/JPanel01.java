package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class JPanel01 extends JPanel { // 1번째 패널

	JPanelChange win;
	JButton btn = new JButton("세트메뉴");
	JButton btn2 = new JButton("단품");
	JButton btn3 = new JButton("사이드");
	JButton btn4 = new JButton("음료");
//	JPanel pan = new JPanel();
	JButton btnAdmin = new JButton("관리자");

	ImageIcon img1 = new ImageIcon("images/붉은대게와퍼세트.png");
	ImageIcon img2 = new ImageIcon("images/더콰트로치즈세트.png");
	ImageIcon img3 = new ImageIcon("images/트러플통모짜와퍼세트.png");
	ImageIcon img4 = new ImageIcon("images/통모짜와퍼세트.png");

	JButton setber1 = new JButton("", img1);
	JButton setber2 = new JButton("", img2);
	JButton setber3 = new JButton("", img3);
	JButton setber4 = new JButton("", img4);

	public JPanel01(JPanelChange win) {
		this.win = win;
		setLayout(null);

		btn.setSize(90, 20);
		btn.setLocation(10, 10);
		add(btn);
		btn2.setSize(70, 20);
		btn2.setLocation(110, 10);
		add(btn2);
		btn3.setSize(80, 20);
		btn3.setLocation(190, 10);
		add(btn3);
		btn4.setSize(70, 20);
		btn4.setLocation(280, 10);
		add(btn4);

//      pan.setLayout(null);
//      pan.add(setber1);        
		setber1.setBounds(10, 50, 165, 150);
		add(setber1);

//      pan.add(setber2);        
		setber2.setBounds(190, 50, 165, 150);
		add(setber2);

//      pan.add(setber3);        
		setber3.setBounds(370, 50, 165, 150);
		add(setber3);

//      pan.add(setber4);        
		setber4.setBounds(550, 50, 165, 150);
		add(setber4);

		btnAdmin.setBounds(630, 10, 80, 20);
//		pan.add(btnAdmin);
		add(btnAdmin);

		// 관리자 버튼과 이벤트를 실행하는 메소드
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new loginCheck();
			}
		});

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});

		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});
	}
}
