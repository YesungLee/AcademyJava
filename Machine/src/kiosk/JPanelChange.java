package kiosk;

import javax.swing.JFrame;

public class JPanelChange extends JFrame {
	
	public JPanel01 jpanel01 = null;
    public JPanel02 jpanel02 = null;
    public JPanel03 jpanel03 = null;
    public JPanel04 jpanel04 = null;
 
    public void change(String panelName) { // 패널 1번과 2번 변경 후 재설정
 
        if (panelName.equals("panel01")) {
            getContentPane().removeAll();
            getContentPane().add(jpanel01);
            revalidate();
            repaint();
        } else if(panelName.equals("panel02")){
            getContentPane().removeAll();
            getContentPane().add(jpanel02);
            revalidate();
            repaint();
        } else if(panelName.equals("panel03")) {
        	getContentPane().removeAll();
            getContentPane().add(jpanel03);
            revalidate();
            repaint();
        } else {
        	getContentPane().removeAll();
            getContentPane().add(jpanel04);
            revalidate();
            repaint();
        }
    }
}
