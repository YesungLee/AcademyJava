package newkiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginCheck { // 로그인 창이 뜨는 클래스
	
	JFrame frame = new JFrame(""); // 프레임 선언
	JDialog dialog = new JDialog(frame, "관리자 로그인"); // 다이얼로그 선언
	JPanel pan = new JPanel(); // 패널 선언
	// 레이블 선언
	JLabel lblId = new JLabel("아이디");
	JLabel lblPw = new JLabel("비밀번호");
	// 아이디와 비번을 입력 받을 텍스트 필드 선언
	JTextField txtId = new JTextField("");
	JPasswordField pw = new JPasswordField();
	// 리셋 버튼과 로그인 버튼을 선언
	JButton btnReset = new JButton("다시 입력");
	JButton btnLogin = new JButton("로그인");

	// GUI 구현 생성자
	public loginCheck() {
		dialog.setSize(300, 180); // 다이얼로그의 크기 설정
		dialog.setVisible(true); // 다이얼로그를 표시 해줌
		dialog.setResizable(false); // 창 크기 조절 불가
		dialog.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// X 버튼 누르면 다이얼로그만 종료
		dialog.setContentPane(pan); // 일반적인 컴포넌트들을 가질 수 있는 패널

		pan.setLayout(null); // 레이아웃에 속하지 않음
		// panel에 label과 textfield 추가, 좌표 지정
		pan.add(lblId);
		lblId.setBounds(50, 20, 60, 30);
		pan.add(lblPw);
		lblPw.setBounds(50, 60, 60, 30);
		pan.add(txtId);
		txtId.setBounds(130, 20, 120, 30);
		pan.add(pw);
		pw.setBounds(130, 60, 120, 30);
		pan.add(btnReset);
		btnReset.setBounds(30, 100, 100, 30);
		pan.add(btnLogin);
		btnLogin.setBounds(150, 100, 100, 30);

		// 다시 입력 버튼을 누르면 아이디와 패스워드 텍스트 초기화
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				pw.setText("");
			}

		});
		
		// 로그인 버튼을 누르면 DB와 연동하여 로그인 체크를 함
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbDao dbCheck = new dbDao(); // dbDao 클래스를 dbCheck로 선언
				@SuppressWarnings("deprecation")
				int login = dbCheck.idCheck(txtId.getText(), pw.getText());
				if (login == 1) { // 로그인 성공 시
					new admin(); // admin 클래스 실행
					dialog.dispose(); // loginCheck 클래스의 다이얼로그는 종료
				} else { // 로그인 실패 시 메시지 출력과 아이디, 비밀번호 초기화
					JOptionPane.showMessageDialog(null, "로그인 실패");
					txtId.setText("");
					pw.setText("");
				}
			}

		});
	}
}
