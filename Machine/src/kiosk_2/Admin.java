package kiosk_2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame implements ActionListener, MouseListener {
	KioskDao kioskDAO;
	KioskVo kioskDTO;

	// JFrame frame = new JFrame(""); // 프레임 선언
	JPanel pan; // 패널 선언
	JLabel jlKind, jlMenu, jlPrice; // 분류번호, 메뉴, 가격 라벨
	JTextField jtKind, jtMenu, jtPrice; // 분류번호 , 메뉴, 가격 텍스트필드
	JButton jbAdd, jbDel, jbChange; // 추가, 삭제, 수정 버튼

	/*
	 * JTextArea txtOrdered = new JTextArea(""); // 주문된 목록을 확인할 txtOrdered 선언
	 * JScrollPane scrollpane = new JScrollPane(txtOrdered); // txtOrdered에
	 * scrollbar를 만들어줌
	 */
// 테이블 - 데이터목록을 출력
	JTable table;
	Vector data, col;

	public Admin() {
		setTitle("관리자 페이지");
		setSize(1000, 700); // 다이얼로그의 크기 설정
		setVisible(true); // 다이얼로그를 표시 해줌
		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE);// X 버튼 누르면 다이얼로그만 종료
//		setContentPane(pan); // 일반적인 컴포넌트들을 가질 수 있는 패널

		// txtOrdered.setEditable(false); // 수정하지 못하도록 설정

//		pan.setLayout(null); // 레이아웃에 속하지 않음
//		kioskDAO = new KioskDao();

		// 분류번호
		add(jlKind = new JLabel("분류번호", JLabel.CENTER));
		jlKind.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlKind.setBorder(BorderFactory.createBevelBorder(0));
		jlKind.setBounds(10, 10, 120, 50);
		add(jtKind = new JTextField());
		jtKind.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtKind.setHorizontalAlignment(JTextField.CENTER);
		jtKind.setBounds(140, 10, 120, 50);

		// 메뉴
		add(jlMenu = new JLabel("메뉴", JLabel.CENTER));
		jlMenu.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlMenu.setBorder(BorderFactory.createBevelBorder(0));
		jlMenu.setBounds(10, 70, 120, 50);
		add(jtMenu = new JTextField());
		jtMenu.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtMenu.setHorizontalAlignment(JTextField.CENTER);
		jtMenu.setBounds(140, 70, 120, 50);

		// 가격
		add(jlPrice = new JLabel("가격", JLabel.CENTER));
		jlPrice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlPrice.setBorder(BorderFactory.createBevelBorder(0));
		jlPrice.setBounds(10, 130, 120, 50);
		add(jtPrice = new JTextField());
		jtPrice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jtPrice.setHorizontalAlignment(JTextField.CENTER);
		jtPrice.setBounds(140, 130, 120, 50);

		// 버튼
		add(jbAdd = new JButton("추가"));
		jbAdd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jbAdd.setBounds(270, 10, 120, 50);
		jbAdd.addActionListener(this);
		add(jbDel = new JButton("제거"));
		jbDel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jbDel.setBounds(270, 70, 120, 50);
		jbDel.addActionListener(this);
		add(jbChange = new JButton("수정"));
		jbChange.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jbChange.setBounds(270, 130, 120, 50);
		jbChange.addActionListener(this);

		// 컬럼 백터 - 테이블 상단 타이틀
		// String[] col = new String[6];
		col = new Vector();
		col.add("분류번호");
		col.add("메뉴");
		col.add("가격");

		// 테이블 수정 못하게 DefaultTableModel 사용
		DefaultTableModel model = new DefaultTableModel(kioskDAO.getProduct(), col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		/* 디폴트테이블을 테이블에 더해서 스크롤패널에 더한다 */
		table = new JTable(model);
		table.addMouseListener(this);
		JScrollPane scroll = new JScrollPane(table);
		jTableSet();
		add(scroll);
		scroll.setBounds(415, 10, 770, 250);

		// 화면중앙배치
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 1200) / 2, (screenSize.height - 300) / 2);

		setResizable(false);
		setSize(1200, 300);
		setTitle("메뉴 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	} // Admin 생성자 
	 


	@Override
	public void mouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		jtKind.setText(table.getValueAt(rowIndex, 0) + "");
		jtMenu.setText(table.getValueAt(rowIndex, 1) + "");
		jtPrice.setText(table.getValueAt(rowIndex, 2) + "");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ButtonFlag = e.getActionCommand();

		if (ButtonFlag.equals("추가")) {
			try {
				contentSet();				
				int result = kioskDAO.insertProduct(kioskDTO);
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "추가 되었습니다.");
					jTableRefresh();
					contentClear();
				} // inner if
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "메뉴를 입력하세요!");
				e2.printStackTrace();
				return;
			} // try - catch
		} else if (ButtonFlag.equals("제거")) {
			try {
				contentSet();
				int result = kioskDAO.deleteProduct(kioskDTO);

				if (result == 1) {
					JOptionPane.showMessageDialog(this, "제거 되었습니다.");
					jTableRefresh();
					contentClear();
				} // inner if
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "메뉴를 입력하세요!");
				e2.printStackTrace();
			} // try - catch
		} else if (ButtonFlag.equals("수정")) {
			try {
				contentSet();
				int result = kioskDAO.updateProduct(kioskDTO);

				if (result == 1) {
					JOptionPane.showMessageDialog(this, "수정 되었습니다.");
					jTableRefresh();
					contentClear();
					jtMenu.setFocusable(true);
				} // inner if
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "메뉴를 입력하세요!");
				e2.printStackTrace();
			} // try - catch
		} // if
	} // actionPerformed

	public void jTableRefresh() {
		// 테이블 수정 못하게 DefaultTableModel 사용
		DefaultTableModel model = new DefaultTableModel(kioskDAO.getProduct(), col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
		jTableSet();
	} // jTableRefresh : 테이블 내용을 갱신하는 메서드
	
	public void jTableSet() {
	    // 이동과 길이조절 여러개 선택 되는 것을 방지한다
//	    table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
	    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	     
	    // 컬럼 정렬에 필요한 메서드
	    DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
	    celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
	    DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
	    celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
	    DefaultTableCellRenderer celAlignLeft = new DefaultTableCellRenderer();
	    celAlignLeft.setHorizontalAlignment(JLabel.LEFT);
	     
	    // 컬럼별 사이즈 조절 & 정렬
	    table.getColumnModel().getColumn(0).setPreferredWidth(10);
	    table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(1).setPreferredWidth(10);
	    table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(2).setPreferredWidth(10);
	    table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(3).setPreferredWidth(10);
	    table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(4).setPreferredWidth(20);
	    table.getColumnModel().getColumn(4).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(5).setPreferredWidth(20);
	    table.getColumnModel().getColumn(5).setCellRenderer(celAlignCenter);
	  } // jTableRefresh : 테이블 옵션 설정하는 메서드
	
	public void contentSet() {
	    kioskDTO = new KioskVo();
	     
	    String menu = jtMenu.getText();
	    if (menu.equals("") || menu.equals(null)) JOptionPane.showMessageDialog(this, "메뉴를 입력하세요!");
	     
	    int kind, price;
	     
	    if (jtKind.getText().equals("") || jtKind.getText().equals(null)) {
	    	kind = 0;
	    } else {
	    	kind = Integer.parseInt(jtKind.getText());
	    } // if
	    if (jtPrice.getText().equals("") || jtPrice.getText().equals(null)) {
	    	price = 0;
	    } else {
	    	price = Integer.parseInt(jtPrice.getText());
	    } // if
	     
	    kioskDTO.setMenu(menu);
	    kioskDTO.setKind(kind);
	    kioskDTO.setPrice(price);
	  
	  } // content : 텍스트 필드에 입력된 내용을 셋하는 메서드
	
	 public void contentClear() {
		    jtMenu.setText("");
		    jtKind.setText("");
		    jtPrice.setText("");		    
		  } // contentClear : 텍스트 필드에 입력된 내용을 지우는 메서드
	 
} // Admin

