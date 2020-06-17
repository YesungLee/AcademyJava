package newkiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class order extends JFrame {

	ImageIcon imgBackground = new ImageIcon("images/main.png"); // 백그라운드 이미지 가져오기
	ImageIcon imgSetmenu = new ImageIcon("images/setMenu.png");

	ImageIcon imgSetburger = new ImageIcon("images/붉은대게와퍼세트.png");
	ImageIcon imgSetburger2 = new ImageIcon("images/더콰트로치즈세트.png");
	ImageIcon imgSetburger3 = new ImageIcon("images/트러플통모짜와퍼세트.png");
	ImageIcon imgSetburger4 = new ImageIcon("images/통모짜와퍼세트.png");

	// 패널이 전환되어도 항상 그대로 유지하고 있는 컴포넌트들
	JButton btnPanChg = new JButton("", imgSetmenu);
	JButton btnPanChg2 = new JButton("햄버거");
	JButton btnPanChg3 = new JButton("사이드");
	JButton btnPanChg4 = new JButton("음료");
	JButton btnOrder = new JButton("주문하기");
	JButton btnReset = new JButton("다시담기");

	private JScrollPane scrollPane;
	private String[] columnType = { "메뉴", "개수", "가격"};
	private Object[][] data = {
			{ "붉은대게와퍼세트", 1, "10600원"},
			{ "테스트", 5, "35000원"},
			{ "더콰트로치즈세트", 2, "21200원"} };
	DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnType);
	JTable cart = new JTable(defaultTableModel);
	JScrollPane jScollPane = new JScrollPane(cart);

	// 메뉴 버튼 생성과 메뉴 버튼을 담을 패널 생성
	JPanel pan = new JPanel();
	JButton btnSetburger = new JButton("", imgSetburger);
	JButton btnSetburger2 = new JButton("", imgSetburger2);
	JButton btnSetburger3 = new JButton("", imgSetburger3);
	JButton btnSetburger4 = new JButton("", imgSetburger4);

	JPanel pan2 = new JPanel();
	JButton btnburger = new JButton("");
	JButton btnburger2 = new JButton("");
	JButton btnburger3 = new JButton("");
	JButton btnburger4 = new JButton("");

	JPanel pan3 = new JPanel();
	JButton btnSide = new JButton("");
	JButton btnSide2 = new JButton("");
	JButton btnSide3 = new JButton("");
	JButton btnSide4 = new JButton("");

	JPanel pan4 = new JPanel();
	JButton btnDrink = new JButton("");
	JButton btnDrink2 = new JButton("");
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

	public order() {
		// 배경화면 설정
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imgBackground.getImage(), 0, 0, null);
				setOpaque(false); // 그림을 표시하게 설정, 투명하게 조절
				super.paintComponent(g);
			}
		};

		// 항상 보여질 background 패널에 컴포넌트들 추가
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
		
		
		cart.setBounds(10, 630, 690, 250);
		cart.setBorder(new LineBorder(Color.BLACK, 1));
		cart.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
//		cart.setFillsViewportHeight(true);
		cart.setShowGrid(false); // 그리드 안보이게
		cart.setRowHeight(20); // 행 높이 설정
		background.add(cart);

		pan.setBounds(10, 288, 692, 332);
		pan.setLayout(new GridLayout(0, 2, 0, 0));
		
		pan.add(btnSetburger);
		pan.add(btnSetburger2);
		pan.add(btnSetburger3);
		pan.add(btnSetburger4);
		background.add(pan);
		
		pan2.add(btnburger);
		pan2.add(btnburger2);
		pan2.add(btnburger3);
		pan2.add(btnburger4);
		background.add(pan2);
		
		add(background);
		frame(); // frame 메서드 실행

		// 세트 메뉴 패널 전환
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cart.clearSelection();
			}
		});

		// 세트 메뉴 패널 전환
		btnPanChg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.setVisible(true);
			}
		});

		// 햄버거 메뉴 패널 전환
		btnPanChg2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.setVisible(false);
				pan2.setVisible(true);
			}
		});

		// 사이드 메뉴 패널 전환
		btnPanChg3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				pan.removeAll();
//				CreateSide();
//				background.add(pan);
//				pan.updateUI();
			}
		});

		// 음료 메뉴 패널 전환
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

	// 패널 전환 메소드들
	public void CreateSet() { // 세트 메뉴
		pan.add(btnSetburger);
		pan.add(btnSetburger2);
		pan.add(btnSetburger3);
		pan.add(btnSetburger4);
		
	}

	public void CreateBurger() { // 햄버거
		pan2.add(btnburger);
		pan2.add(btnburger2);
		pan2.add(btnburger3);
		pan2.add(btnburger4);
	}

	public void CreateSide() { // 사이드
		pan3.add(btnSide);
		pan3.add(btnSide2);
		pan3.add(btnSide3);
		pan3.add(btnSide4);
	}

	public void CreateDrink() { // 음료
		pan4.add(btnDrink);
		pan4.add(btnDrink2);
		pan4.add(btnDrink3);
		pan4.add(btnDrink4);
	}

}