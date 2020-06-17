package kiosk;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class JPanelChange extends JFrame {
	
	public JPanel01 jpanel01 = null;
    public JPanel02 jpanel02 = null;
    public JPanel03 jpanel03 = null;
    public JPanel04 jpanel04 = null;
    public JPanel05 jpanel05 = null;

 
    public void change(String panelName) { // 패널 1번과 2번 변경 후 재설정
 
        if (panelName.equals("panel01")) {
            getContentPane().removeAll();
            getContentPane().setLayout(new GridLayout(2,1));
            getContentPane().add(jpanel01);
            getContentPane().add(jpanel05);
            
            revalidate();
            repaint();
        } else if(panelName.equals("panel02")){
            getContentPane().removeAll();
            getContentPane().setLayout(new GridLayout(2,1));
            getContentPane().add(jpanel02);
            getContentPane().add(jpanel05);
            revalidate();
            repaint();
        } else if(panelName.equals("panel03")) {
        	getContentPane().removeAll();
        	getContentPane().setLayout(new GridLayout(2,1));
            getContentPane().add(jpanel03);
            getContentPane().add(jpanel05);
            revalidate();
            repaint();
        } else {
        	getContentPane().removeAll();
        	getContentPane().setLayout(new GridLayout(2,1));
            getContentPane().add(jpanel04);
            getContentPane().add(jpanel05);
            revalidate();
            repaint();
        }
    }
}
