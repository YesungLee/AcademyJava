package newkiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class main {

	JFrame frame = new JFrame();
	JPanel pan = new JPanel();
	ImageIcon admin = new ImageIcon("images/admin.png"); // 관리자 이미지 가져오기
	ImageIcon order = new ImageIcon("images/order.png"); // 주문하기 이미지 가져오기
	JButton btnAdmin = new JButton("", admin);
	JButton btnOrder = new JButton("", order);
	JScrollPane scrollPane;

	public main() {
		// frame 기본 설정
		frame.setTitle("버거킹 무인 메뉴 시스템");
		frame.setSize(720, 300);
		frame.setResizable(false); // 창 크기 조절 불가
		frame.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.add(pan);
		pan.setLayout(null);
		btnAdmin.setBounds(0, 0, 360, 300);
		pan.add(btnAdmin);
		btnOrder.setBounds(360, 0, 360, 300);
		pan.add(btnOrder);

		// 관리자 모드 버튼 클릭
		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new loginCheck();
			}
		});

		// 주문하기 버튼 클릭
		btnOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new order();
				frame.dispose();
			}
		});
	}

	public static void main(String[] args) {
		new main();
	}
}