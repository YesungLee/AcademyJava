package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class order extends JFrame {

	loginCheck login;
	JPanel pan = new JPanel();
	JButton btnAdmin = new JButton("관리자");
	JTextField txt = new JTextField("d");

	order() {
		setTitle("버거킹 키오스크"); // 프레임 이름
		setSize(720, 1080); // 프레임 크기
	}

	public void open() {
		setResizable(false); // 창 크기 조절 불가
		setLocationRelativeTo(null); // 중앙에서 프레임 실행
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(pan);

		pan.setLayout(null);
		btnAdmin.setBounds(620, 10, 120, 30);
		pan.add(btnAdmin);
		txt.setBounds(100, 100, 100, 100);
		pan.add(txt);

		btnAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new loginCheck();
			}

		});
	}
}
