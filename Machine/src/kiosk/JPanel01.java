package kiosk;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
class JPanel01 extends JPanel { // 1번째 패널

	JPanelChange win;
	dbDao dbdao;
	JButton btnSetMenu = new JButton("세트메뉴");
	JButton btnSingleMenu = new JButton("단품");
	JButton btnSide = new JButton("사이드");
	JButton btnDrink = new JButton("음료");

	JButton btn1MenuPlus = new JButton("+");
	JButton btn1MenuMinus = new JButton("-");

	JButton btn2MenuPlus = new JButton("+");
	JButton btn2MenuMinus = new JButton("-");

	JButton btn3MenuPlus = new JButton("+");
	JButton btn3MenuMinus = new JButton("-");

	JButton btn4MenuPlus = new JButton("+");
	JButton btn4MenuMinus = new JButton("-");

	JButton btnOrder = new JButton("주문하기");
	JButton btnSelect = new JButton("선택하기");
	JButton btnCancel = new JButton("취소");

	JLabel btn1Label = new JLabel("0");
	JLabel btn2Label = new JLabel("0");
	JLabel btn3Label = new JLabel("0");
	JLabel btn4Label = new JLabel("0");

	JButton btnAdmin = new JButton("관리자");

	ImageIcon img1 = new ImageIcon("images/붉은대게와퍼세트.png");
	ImageIcon img2 = new ImageIcon("images/더콰트로치즈세트.png");
	ImageIcon img3 = new ImageIcon("images/트러플통모짜와퍼세트.png");
	ImageIcon img4 = new ImageIcon("images/통모짜와퍼세트.png");

	JButton setber1 = new JButton("", img1);
	JButton setber2 = new JButton("", img2);
	JButton setber3 = new JButton("", img3);
	JButton setber4 = new JButton("", img4);

	int price = 0;

	public JPanel01(JPanelChange win) {
		this.win = win;
		setLayout(null);

		btnOrder.setBounds(360, 10, 90, 20);
		add(btnOrder);
		btnSelect.setBounds(460, 10, 90, 20);
		add(btnSelect);
		btnCancel.setBounds(560, 10, 60, 20);
		add(btnCancel);
		btnAdmin.setBounds(630, 10, 80, 20);
		add(btnAdmin);

		btnSetMenu.setSize(90, 20);
		btnSetMenu.setLocation(10, 10);
		add(btnSetMenu);

		btnSingleMenu.setSize(70, 20);
		btnSingleMenu.setLocation(110, 10);
		add(btnSingleMenu);

		btnSide.setSize(80, 20);
		btnSide.setLocation(190, 10);
		add(btnSide);

		btnDrink.setSize(70, 20);
		btnDrink.setLocation(280, 10);
		add(btnDrink);

		setber1.setBounds(10, 50, 150, 150);
		add(setber1);
		setber2.setBounds(180, 50, 150, 150);
		add(setber2);
		setber3.setBounds(350, 50, 150, 150);
		add(setber3);
		setber4.setBounds(520, 50, 150, 150);
		add(setber4);

		btn1MenuMinus.setBounds(30, 210, 20, 20);
		add(btn1MenuMinus);
		btn1MenuPlus.setBounds(80, 210, 20, 20);
		add(btn1MenuPlus);
		add(btn1Label);
		btn1Label.setBounds(60, 210, 20, 20);

		btn2MenuMinus.setBounds(200, 210, 20, 20);
		add(btn2MenuMinus);
		btn2MenuPlus.setBounds(250, 210, 20, 20);
		add(btn2MenuPlus);
		add(btn2Label);
		btn2Label.setBounds(230, 210, 20, 20);

		btn3MenuMinus.setBounds(370, 210, 20, 20);
		add(btn3MenuMinus);
		btn3MenuPlus.setBounds(420, 210, 20, 20);
		add(btn3MenuPlus);
		add(btn3Label);
		btn3Label.setBounds(400, 210, 20, 20);

		btn4MenuMinus.setBounds(550, 210, 20, 20);
		add(btn4MenuMinus);
		btn4MenuPlus.setBounds(600, 210, 20, 20);
		add(btn4MenuPlus);
		add(btn4Label);
		btn4Label.setBounds(580, 210, 20, 20);

		// 주문하기 버튼 클릭
		btnOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new order();
			}
		});

		// 관리자 버튼과 이벤트를 실행하는 메소드
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new loginCheck();
			}
		});

		btnSetMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});

		btnSingleMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});

		btnSide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});

		btnDrink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});

		btn1MenuPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn1Label.getText();
				int icnt = Integer.parseInt(cnt) + 1;
				btn1Label.setText(Integer.toString(icnt));

			}
		});

		btn1MenuMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn1Label.getText();

				if (!cnt.equals("0")) {
					int icnt = Integer.parseInt(cnt) - 1;
					btn1Label.setText(Integer.toString(icnt));
				}
			}
		});

		btn2MenuPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn2Label.getText();
				int icnt = Integer.parseInt(cnt) + 1;
				btn2Label.setText(Integer.toString(icnt));

			}
		});
		btn2MenuMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn2Label.getText();

				if (!cnt.equals("0")) {
					int icnt = Integer.parseInt(cnt) - 1;
					btn2Label.setText(Integer.toString(icnt));
				}
			}
		});

		btn3MenuPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn3Label.getText();
				int icnt = Integer.parseInt(cnt) + 1;
				btn3Label.setText(Integer.toString(icnt));

			}
		});
		btn3MenuMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn3Label.getText();

				if (!cnt.equals("0")) {
					int icnt = Integer.parseInt(cnt) - 1;
					btn3Label.setText(Integer.toString(icnt));
				}
			}
		});

		btn4MenuPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn4Label.getText();
				int icnt = Integer.parseInt(cnt) + 1;
				btn4Label.setText(Integer.toString(icnt));

			}
		});
		btn4MenuMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn4Label.getText();

				if (!cnt.equals("0")) {
					int icnt = Integer.parseInt(cnt) - 1;
					btn4Label.setText(Integer.toString(icnt));
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.jpanel05.textbox.setText("");
			}
		});

		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btn1Label.getText().equals("0")) {
//					win.jpanel05.setTextBox("붉은대게와퍼세트" + "\t" + btn1Label.getText() + "개\t" + Integer.valueOf(btn1Label.getText())*dbdao.menuPrice("붉은대게와퍼세트") + "원\n");
					win.jpanel05.setTextBox("더콰트로치즈세트" + "\t" + btn2Label.getText() + "개\t"
							+ Integer.valueOf(btn2Label.getText()) * 10000 + "원\n");
				}
				if (!btn2Label.getText().equals("0")) {
					win.jpanel05.setTextBox("더콰트로치즈세트" + "\t" + btn2Label.getText() + "개\t"
							+ Integer.valueOf(btn2Label.getText()) * 10000 + "원\n");
				}
				if (!btn3Label.getText().equals("0")) {
					win.jpanel05.setTextBox("트러플통모짜와퍼세트" + "\t" + btn3Label.getText() + "개\t"
							+ Integer.valueOf(btn3Label.getText()) * 10300 + "원\n");
				}
				if (!btn4Label.getText().equals("0")) {
					win.jpanel05.setTextBox("통모짜와퍼세트" + "\t\t" + btn4Label.getText() + "개\t"
							+ Integer.valueOf(btn4Label.getText()) * 10300 + "원\n");
				}
			}
		});
	}
}
