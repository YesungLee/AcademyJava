package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class order {

	dbDao dbdao;
	JFrame frame = new JFrame(""); // 프레임 선언
	JDialog dialog = new JDialog(frame, "주문하기"); // 다이얼로그 선언
	JPanel pan = new JPanel(); // 패널 선언
	JLabel lblPay = new JLabel("총 금액");
	JLabel lblValue = new JLabel("");
	JButton btnPay = new JButton("결제하기");

	public order() {
		dialog.setSize(300, 200); // 다이얼로그의 크기 설정
		dialog.setVisible(true); // 다이얼로그를 표시 해줌
		dialog.setResizable(false); // 창 크기 조절 불가
		dialog.setLocationRelativeTo(null); // 중앙에서 프레임 실행
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// X 버튼 누르면 다이얼로그만 종료
		dialog.setContentPane(pan); // 일반적인 컴포넌트들을 가질 수 있는 패널

		pan.setLayout(null); // 레이아웃에 속하지 않음
		pan.add(lblPay);
		lblPay.setText("100");
		lblPay.setBounds(60, 20, 60, 30);
		pan.add(lblValue);
		lblValue.setBounds(180, 20, 60, 30);
		pan.add(btnPay);
		btnPay.setBounds(90, 90, 100, 30);

		// 결제 버튼을 누르면 결제가 완료되어 DB에 데이터를 입력해줌
		btnPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbdao.pay(3, "테스트");
			}
		});
	}
}
