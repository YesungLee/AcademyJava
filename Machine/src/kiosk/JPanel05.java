package kiosk;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPanel05  extends JPanel{
	JPanelChange win;
	JTextArea textbox = new JTextArea();
	
	public JPanel05(JPanelChange win)
	{
		setLayout(null);
		this.win = win;
		
		textbox.setBounds(7, 10, 710, 300);
		textbox.setEditable(false); // 텍스트 수정 X
		add(textbox);
	}
	public void setTextBox(String text)
	{
	  textbox.append(text);
	}
	


}
