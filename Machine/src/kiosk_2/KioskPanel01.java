package kiosk_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class KioskPanel01 extends JPanel { // 1번째 패널

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

	JButton btnOK = new JButton("주문");
	JButton btnCancel = new JButton("취소");
//	JButton btnOrders = new JButton("주문");

	JLabel btn1Label = new JLabel("0");
	JLabel btn2Label = new JLabel("0");
	JLabel btn3Label = new JLabel("0");
	JLabel btn4Label = new JLabel("0");
	
	JButton btnAdmin = new JButton("관리자");

	ImageIcon img1 = new ImageIcon("images/붉은대게와퍼세트.png");
	ImageIcon img2 = new ImageIcon("images/더콰트로치즈세트.png");
	ImageIcon img3 = new ImageIcon("images/트러플통모짜와퍼세트.png");
	ImageIcon img4 = new ImageIcon("images/통모짜와퍼세트.png");

	JLabel setber1 = new JLabel(img1);
	JLabel setber2 = new JLabel(img2);
	JLabel setber3 = new JLabel(img3);
	JLabel setber4 = new JLabel(img4);
	
	int setMenu1Price = 10600;
	int setMenu2Price = 10000;
	int setMenu3Price = 10300;
	int setMenu4Price = 10300;

	public KioskPanel01() {
		
		setLayout(null);

		btnOK.setSize(70, 20);
		btnOK.setLocation(450, 10);
		add(btnOK);

		btnCancel.setSize(70, 20);
		btnCancel.setLocation(530, 10);
		add(btnCancel);
		
		/*btnOrders.setSize(70,20);
		btnOrders.setLocation(370,10);
		add(btnOrders);	*/	

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

		btnAdmin.setBounds(630, 10, 80, 20);

		add(btnAdmin);

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

		// 관리자 버튼과 이벤트를 실행하는 메소드
		   btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginCheck();
			}
		});
		//세트메뉴 클릭시 Jpanel01번 불러옴
		/*btnSetMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});*/
        // 단품 클릭시 Jpanel02번 불러옴
		/*btnSingleMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});*/
		//사이드 클릭시 Jpanel03번 불러옴
		/*btnSide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});*/
		//음료 클릭시 Jpanel04번 불러옴
		/*btnDrink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});*/
		// + 버튼 클릭시 btn1Label 값 1씩 증가
		btn1MenuPlus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cnt = btn1Label.getText();
				int icnt = Integer.parseInt(cnt) + 1;
				btn1Label.setText(Integer.toString(icnt));

			}
		});
		// - 버튼 클릭시 btn1Label 값 1씩 감소 (0까지)
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

		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				String count1 = btn1Label.getText();
				int icounnt1 = Integer.parseInt(count1);
				btn1Label.setText(Integer.toString(icounnt1));
				
				String count2 = btn2Label.getText();
				int icounnt2 = Integer.parseInt(count2);
				btn2Label.setText(Integer.toString(icounnt2));
				
				String count3 = btn3Label.getText();
				int icounnt3 = Integer.parseInt(count3);
				btn3Label.setText(Integer.toString(icounnt3));
				
				String count4 = btn4Label.getText();
				int icounnt4 = Integer.parseInt(count4);
				btn4Label.setText(Integer.toString(icounnt4));
				
				int sumPrice = (icounnt1*setMenu1Price)+(icounnt2*setMenu2Price)+(icounnt3*setMenu3Price)
						+(icounnt4*setMenu4Price);
				
				if (!btn1Label.getText().equals("0")) {						
					KioskPanel02.setTextBox("붉은대게와퍼세트  \t" + btn1Label.getText() +"개  \t"+icounnt1*setMenu1Price+ "원 \n");
				}
				if (!btn2Label.getText().equals("0")) {					
					KioskPanel02.setTextBox("더콰트로치즈세트  \t" + btn2Label.getText() + "개  \t"+icounnt2*setMenu2Price+ "원 \n");
				}
				if (!btn3Label.getText().equals("0")) {					
					KioskPanel02.setTextBox("트러플통모짜와퍼세트  \t" + btn3Label.getText() +"개  \t"+icounnt3*setMenu3Price+ "원 \n");
				}
				if (!btn4Label.getText().equals("0")) {					
					KioskPanel02.setTextBox("통모짜와퍼세트  \t" + btn4Label.getText() + "개  \t"+icounnt4*setMenu4Price+ "원 \n");
				}

				if (btn1Label.getText().equals("0") && btn2Label.getText().equals("0")
						&& btn3Label.getText().equals("0") && btn4Label.getText().equals("0")) {
					KioskPanel02.setTextBox("주문 내역이 없습니다." + "\n");
				}
				KioskPanel02.setTextBox("\n 세트 합계: "+sumPrice+"원 입니다. \n\n");
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KioskPanel02.textbox.setText("");
				btn1Label.setText("0");
				btn2Label.setText("0");
				btn3Label.setText("0");
				btn4Label.setText("0");
				
			}
		});		
		
		/*btnOrders.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(btnOrders)) {
					new Order();					
					
				}
				
			}
		});*/
		
		/*btnOrders.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource().equals(btnOrders)) {
					JOptionPane.showMessageDialog(btnOrders, "주문이 완료되었습니다.");
					}
				
			}
		});*/
	}
}
