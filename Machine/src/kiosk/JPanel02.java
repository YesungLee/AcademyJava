package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanel02 extends JPanel {

	JPanelChange win;
	JButton btn = new JButton("세트메뉴");
	JButton btn2 = new JButton("단품");
	JButton btn3 = new JButton("사이드");
	JButton btn4 = new JButton("음료");
	JPanel pan = new JPanel();
	JButton btnAdmin = new JButton("관리자");

	ImageIcon img1 = new ImageIcon("images/붉은대게와퍼.png");
	ImageIcon img2 = new ImageIcon("images/더콰트로치즈.png");
	ImageIcon img3 = new ImageIcon("images/트러플통모짜와퍼.png");
	ImageIcon img4 = new ImageIcon("images/통모짜와퍼.png");

	JButton ber1 = new JButton("", img1);
	JButton ber2 = new JButton("", img2);
	JButton ber3 = new JButton("", img3);
	JButton ber4 = new JButton("", img4);

	public JPanel02(JPanelChange win) {
		setLayout(null);
		this.win = win;

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

		pan.setLayout(null);
		pan.add(ber1);
		ber1.setBounds(10, 50, 150, 150);
		add(ber1);

		pan.add(ber2);
		ber2.setBounds(180, 50, 150, 150);
		add(ber2);

		pan.add(ber3);
		ber3.setBounds(350, 50, 150, 150);
		add(ber3);

		pan.add(ber4);
		ber4.setBounds(520, 50, 150, 150);
		add(ber4);

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
