import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class test extends JFrame {

	ImageIcon icon = new ImageIcon("images/main.png"); // 백그라운드 이미지 가져오기

	// 패널 전환에 필요한 패널 생성
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan4 = new JPanel();

	// 패널이 전환되어도 항상 그대로 유지하고 있는 컴포넌트들
	JButton btnPanChg = new JButton("세트메뉴");
	JButton btnPanChg2 = new JButton("햄버거");
	JButton btnPanChg3 = new JButton("사이드");
	JButton btnPanChg4 = new JButton("음료");
	JButton btnOrder = new JButton("주문하기");
	JButton btnReset = new JButton("다시담기");
	JTable cart = new JTable();

	// 메뉴 버튼 생성과 메뉴 버튼을 담을 패널 생성
	JPanel pan = new JPanel();
	JButton btnSetburger = new JButton("세트버거");
	JButton btnSetburger2 = new JButton("");
	JButton btnSetburger3 = new JButton("");
	JButton btnSetburger4 = new JButton("");

	JButton btnburger = new JButton("");
	JButton btnburger2 = new JButton("그냥버거");
	JButton btnburger3 = new JButton("");
	JButton btnburger4 = new JButton("");
	
	JButton btnSide = new JButton("");
	JButton btnSide2 = new JButton("그냥버거");
	JButton btnSide3 = new JButton("");
	JButton btnSide4 = new JButton("");
	
	JButton btnDrink = new JButton("");
	JButton btnDrink2 = new JButton("그냥버거");
	JButton btnDrink3 = new JButton("");
	JButton btnDrink4 = new JButton("");

	// 프레임 그려주는 메소드
	public void frame() {
		setTitle("버거킹 무인 메뉴 시스템");
		setSize(720, 1080);
		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); // 화면에 표시
	}

	public test() {

		// 배경화면 설정
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); // 그림을 표시하게 설정, 투명하게 조절
				super.paintComponent(g);
			}
		};

		// 기본 화면 설정
		background.setLayout(null);
		btnPanChg.setBounds(10, 10, 165, 93);
		background.add(btnPanChg);
		btnPanChg2.setBounds(185, 10, 165, 93);
		background.add(btnPanChg2);
		btnPanChg3.setBounds(360, 10, 165, 93);
		background.add(btnPanChg3);
		btnPanChg4.setBounds(535, 10, 165, 93);
		background.add(btnPanChg4);
		btnOrder.setBounds(80, 900, 230, 100);
		background.add(btnOrder);
		btnReset.setBounds(370, 900, 230, 100);
		background.add(btnReset);
		cart.setShowGrid(false);
		cart.setFillsViewportHeight(true);
		cart.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cart.setBorder(new LineBorder(Color.BLACK, 1));
		cart.setBounds(10, 630, 690, 250);
		background.add(cart);
//		getContentPane().add(background);

		pan.setBounds(10, 288, 692, 332);
		pan.setLayout(new GridLayout(0, 2, 0, 0));
		pan.add(btnSetburger);
		pan.add(btnSetburger2);
		pan.add(btnSetburger3);
		pan.add(btnSetburger4);
		background.add(pan);
		getContentPane().add(background);
		
		JLabel lblNewLabel = new JLabel("메뉴");
		lblNewLabel.setBounds(12, 630, 57, 15);
		background.add(lblNewLabel);
		frame(); // frame 메서드 실행

		// 세트메뉴 클래스 실행
		btnPanChg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.removeAll();
				CreateSet();
				background.add(pan);
				pan.updateUI();
			}
		});

		// 세트메뉴 클래스 실행
		btnPanChg2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.removeAll();
				CreateBurger();
				background.add(pan);
				pan.updateUI();
			}
		});

		// 세트메뉴 클래스 실행
		btnPanChg3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.removeAll();
				CreateSide();
				background.add(pan);
				pan.updateUI();
			}
		});

		// 세트메뉴 클래스 실행
		btnPanChg4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.removeAll();
				CreateDrink();
				background.add(pan);
				pan.updateUI();
			}
		});
	}

	public void CreateSet() { // 세트 메뉴
		pan.add(btnSetburger);
		pan.add(btnSetburger2);
		pan.add(btnSetburger3);
		pan.add(btnSetburger4);
	}

	public void CreateBurger() { // 햄버거
		pan.add(btnburger);
		pan.add(btnburger2);
		pan.add(btnburger3);
		pan.add(btnburger4);
	}
	
	public void CreateSide() { // 사이드
		pan.add(btnSide);
		pan.add(btnSide2);
		pan.add(btnSide3);
		pan.add(btnSide4);
	}
	
	public void CreateDrink() { // 음료
		pan.add(btnDrink);
		pan.add(btnDrink2);
		pan.add(btnDrink3);
		pan.add(btnDrink4);
	}
}