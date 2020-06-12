package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class order extends JFrame {

	JPanel pan = new JPanel();
	JButton btnAdmin = new JButton("관리자");

	order() {
		setTitle("버거킹 키오스크"); // 프레임 이름
		setSize(720, 1080); // 프레임 크기
		open();
	}

	public void open() {
		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(pan);

		pan.setLayout(null);
		btnAdmin.setBounds(620, 10, 80, 20);
		pan.add(btnAdmin);

		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new loginCheck();
			}

		});
	}
}
