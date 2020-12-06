package Pages;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Cursor;

public class Start extends JFrame {

	private JPanel contentPane;
	static Start frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Start();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
       //madan@gmail.com 
	
      //madan@123
	 //nishtha@gmail.com
	//nishtha@123
	//saurabh@
	public Start(){
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("GLA-ClassRoom");
		
		
		setBackground(Color.WHITE);
		
		Image img = Toolkit.getDefaultToolkit().getImage("D:\\colleage\\gr1.png");

		contentPane=new JPanel();
		contentPane.setBackground(new Color(102, 102, 153));
		

		setResizable(false);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       setBounds(100, 100, 383, 578);
		       setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
		        contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
		
		//create Start button
		JButton btnStart = new JButton("START.");
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setToolTipText("start here");
		btnStart.setIcon(null);
		btnStart.setBackground(new Color(0, 0, 51));
		btnStart.setBounds(101, 271, 140, 34);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							Login frame1 = new Login();
							contentPane.setVisible(false);
						    frame.setVisible(false);
							frame1.setVisible(true);
						    frame1.controlframe(frame1);
							
				
			}
		});
		

		btnStart.setForeground(new Color(51, 51, 102));
		btnStart.setFont(new Font("Georgia", Font.ITALIC, 30));
		btnStart.setBorder(null);
		contentPane.setBorder(null);
		contentPane.add(btnStart);
	}



	

}
