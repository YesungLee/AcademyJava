package project;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class start extends JFrame {
	private MainProcess main;
	ImageIcon admin = new ImageIcon("images/admin.png"); // 관리자 이미지 가져오기
	ImageIcon order = new ImageIcon("images/order.png"); // 주문하기 이미지 가져오기
	ImageIcon icon = new ImageIcon("images/main.png"); // 백그라운드 이미지 가져오기
	JButton btnAdmin = new JButton("",admin);
	JButton btnOrder = new JButton("",order);
	JScrollPane scrollPane;

	
	public start() {
		setTitle("버거킹 무인 메뉴 시스템"); // 프레임 이름
		setSize(720, 1080); // 프레임 크기

		BackGround BackPanel = new BackGround();
		BackPanel.setLayout(null);
		btnAdmin.setBounds(0, 780, 360, 300);
		BackPanel.add(btnAdmin);
		this.add(BackPanel);
		
		btnOrder.setBounds(360, 780, 360, 300);
		BackPanel.add(btnOrder);
		this.add(BackPanel);

		// 화면보다 더 큰 컴포넌트를 표시하기 위해 스크롤 페인 선언
		scrollPane = new JScrollPane(BackPanel);
		setContentPane(scrollPane);

		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료시 메모리에서 제거

		JPanel panel1 = new JPanel();
		goAdmin(panel1);
		goOrder(panel1);
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

	// 관리자 화면으로 이동
	public void goAdmin(JPanel panel) {
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showAdmin(); // 메인창 메소드를 이용해 창뛰우기
			}
		});
	}
	
	// 주문 화면으로 이동
	public void goOrder(JPanel panel) {
		btnOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showOrder(); // 메인창 메소드를 이용해 창뛰우기
			}
		});
	}

	// mainProcess와 연동
	public void setMain(MainProcess main) {
		this.main = main;
	}

}
