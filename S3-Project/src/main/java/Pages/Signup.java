package Pages;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



public class Signup  {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private Connection cn;
	private Statement st;
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					 frame = new Signup();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JFrame f;
	public Signup() {
		 f=new JFrame();
		 f.setVisible(true);
	}
	public void my() {

		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			   cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignmentsystem?serverTimezone=UTC","root","");
			   st=cn.createStatement();
				
			}
			catch(ClassNotFoundException  e1) {
				System.out.println("step 1");
			}
			catch(SQLException e1) {
				System.out.println("rest step");
			}
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 383, 578);
		f.setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.DARK_GRAY);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Create Account", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
		f.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create username labels
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBackground(Color.MAGENTA);
		lblUsername.setBounds(31, 139, 100, 47);
		contentPane.add(lblUsername);
		
		//create Textfield userame
		textFieldName = new JTextField();
		textFieldName.setBounds(134, 151, 202, 29);
		contentPane.add(textFieldName);
		textFieldName.setBorder(null);
		textFieldName.setColumns(10);
		
		
		//create  email label
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(Color.MAGENTA);
		lblEmail.setBounds(31, 198, 100, 36);
		contentPane.add(lblEmail);
		
		//create Textfield email
		textFieldEmail = new JTextField();
		textFieldEmail .setBounds(134, 205, 202, 29);
		contentPane.add(textFieldEmail );
		textFieldEmail.setBorder(null);
		textFieldEmail .setColumns(10);
		
		//create  Password label
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPassword.setBounds(31, 244, 100, 42);
		contentPane.add(lblPassword);
		
		//create Textfield Password
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(134, 254, 202, 29);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
			//create button
		
		JButton btnClickHere = new JButton("Sign Up");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for action happen
				if(textFieldName.getText().contentEquals("") || textFieldEmail.getText().contentEquals("") || textFieldPassword.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(contentPane, "All fields are required");
				}
				
				
				else {
					 //Valid Email
					 String validId=textFieldEmail.getText();
					 int length=validId.length();
					 if(length>10 && (validId.substring(length-10, length).equals("@gmail.com")) || (validId.substring(length-10, length).equals("@yahoo.com"))) {
				 try {     
					 
					
							//sql query for checking the email,password info in database
							String sql="select Email from account where email='"+ textFieldEmail.getText() +"'" ;
							//it execute sql query
							ResultSet rs=st.executeQuery(sql);	
							int check=0;
							while(rs.next()) {
								check++;
								
									}
							if(check>0) {
							JOptionPane.showInternalMessageDialog(contentPane,"All ready have account");
							}
							else {
						
						String sql1="insert into account(USERNAME,EMAIL,PASSWORD) values('"+ textFieldName.getText() +"','"+ textFieldEmail.getText() +"','"+textFieldPassword.getText()+"')";
						st.executeUpdate(sql1);
						JOptionPane.showInternalMessageDialog(contentPane,"Successfully created!");
						Login frame1 = new Login();
						contentPane.setVisible(false);
					    f.setVisible(false);
						frame1.setVisible(true);
					    frame1.controlframe(frame1);
					    frame1.dashboard(textFieldEmail.getText());
						
							
					}
				 }
					catch(SQLException e1) {
						System.out.println("rest step");
					}
					 }
					 else {
						 JOptionPane.showInternalMessageDialog(contentPane,"Invalid Email"); 
					 }

			}
		
				
			}
		});
		
		btnClickHere.setForeground(Color.BLACK);
		btnClickHere.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClickHere.setBackground(Color.ORANGE);
		btnClickHere.setBounds(212, 388, 116, 36);
		contentPane.setBorder(null);
		contentPane.add(btnClickHere);
		btnClickHere.setBorder(null);
		//f.add(contentPane);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				Login frame1 = new Login();
				contentPane.setVisible(false);
			    f.setVisible(false);
				frame1.setVisible(true);
			    frame1.controlframe(frame1);
			}
		});
			
		Back.setForeground(Color.BLACK);
		Back.setFont(new Font("Tahoma", Font.BOLD, 14));
		Back.setBackground(Color.ORANGE);
		Back.setBounds(33, 388, 116, 36);
		Back.setBorder(null);
		contentPane.setBorder(null);
		contentPane.add(Back);
		
		
	}
	
	
}


