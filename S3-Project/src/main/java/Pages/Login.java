package Pages;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Login extends JFrame {


	private String myclassname,myemail,myclasscode;
	private JPanel contentPane;
	
    //for login
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
		
	//for connecting database
	private Connection cn;
	private Statement st;
		
	JButton[] bt=new JButton[4];
	
	//some variables
	int k=40,ip=0;
	int j=0,j1=40;
	
    //For "Teacher Portal or Student Portal"
	String clcreate="";
		
	//like yes or no
	String classcreate="";
	
	///mode
	int mode=1;
	
	
	private JTextField textField;
	private JTextField textField_1;
	//static JLabel l;
	private JButton btnNewButton;
	
	
	
	//getter
	public String getMyClassName() {
		return myclassname;
	}
	public void setMyClassName(String myclassname) {
		this.myclassname=myclassname;
	}
	
	public String getMyEmail() {
		return myemail;
	}
	public void setMyEmail(String myemail) {
		this.myemail=myemail;
	}
	
	public void setMyClassCode(String myclasscode) {
		this.myclasscode=myclasscode;
	}
	public String getMyClassCode() {
		return myclasscode;
	}
	//complete getter settter
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//constructor
	public Login() {
//		setBackground(Color.WHITE);
		start();
	}
	
//This method start the application and authentication can be done here	
public void start() {
	
	    //database connnectivity
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignmentsystem?serverTimezone=UTC","root","");
		   st=cn.createStatement();
		}
		catch(ClassNotFoundException  e1) {
			System.out.println("database connection excetion");
		}
		catch(SQLException e11) {
			System.out.println("sql1 query exception");
		}

		//create panel for showing GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 578);
		contentPane = new JPanel();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
		contentPane.setForeground(new Color(255, 51, 102));

		contentPane.setBackground(new Color(102, 102, 153));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		//create labels entering Email
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(Color.MAGENTA);
		lblEmail.setBounds(31, 188, 100, 36);
		//add email label to panel
		contentPane.add(lblEmail);
		
		//create textfield for user input Email
		textFieldEmail = new JTextField();
		textFieldEmail.setMargin(new Insets(2, 5, 2, 5));
		textFieldEmail.setToolTipText("name");
		textFieldEmail.setBounds(134, 195, 210, 29);
		textFieldEmail.setBorder(null);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		//create label for entering password
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPassword.setBounds(31, 252, 100, 29);
		
		//add password label to panel
		contentPane.add(lblPassword);
		
		//create textfield for user input password
		textFieldPassword = new JPasswordField();
		textFieldPassword.setToolTipText("password");
		textFieldPassword.setBounds(134, 252, 210, 29);
		textFieldPassword.setBorder(null);
		textFieldPassword.setMargin(getInsets());
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		//create button Login
		JButton btnLogin = new JButton("Log In");
		
		//code for action happen
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//sql query for checking the email,password info in database
					 String sql="select Email,Password from account where email='"+ textFieldEmail.getText() +"' and password='"+ textFieldPassword.getText() +"'  " ;
					//it execute sql query
					ResultSet rs=st.executeQuery(sql);	
					
					String email="",password="";
					int check=0;
					while(rs.next()) {
						check++;
						 email=rs.getString(1);	
						 password=rs.getString(2);
						if(email.contentEquals(textFieldEmail.getText()) && password.contentEquals(textFieldPassword.getText())) {	
							
							//it redirect to create class	
							setMyEmail(email);
							contentPane.setVisible(false);
			                CreateClass();
										
									
								}
							}
					if(check==0) {
						
						//Print message if password is wrong
					
					JOptionPane.showInternalMessageDialog(contentPane,"Please check your id OR password");
					}	
				}
				catch(SQLException e1) {
					System.out.println("sql exception");
				}	
				
			}
		});                                          //login action complete
		
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBackground(new Color(255, 204, 51));
		btnLogin.setBounds(212, 388, 116, 36);
		btnLogin.setBorder(null);
		//it add button on panel
		contentPane.add(btnLogin);                  //login button complete
		
		
		//create button signup
		JButton btnSignup = new JButton("Sign Up");
		//code for action happen
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
							Signup frame = new Signup();
							frame.setVisible(true);
						}
		});                                                 //signup action complete
		
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignup.setBackground(new Color(255, 204, 51));
		btnSignup.setBounds(33, 388, 116, 36);
		btnSignup.setBorder(null);
		//it add button on panel
		contentPane.add(btnSignup);                          //signup button complete
		
		
		//forget password
		JLabel lblForgetPassword = new JLabel("Forget Password");
		lblForgetPassword.setToolTipText("click here for password reset\r\n");
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				int ch=0;
				//it show a user input frame for taking Email and Password
				String email=JOptionPane.showInternalInputDialog(contentPane, "Enter mail");
				if(!email.contentEquals("")) {
					try {
					String sql="select Email from account where email='"+ email +"'" ;
					//it execute sql query
					ResultSet rs=st.executeQuery(sql);	

					
					while(rs.next()) {
						ch++;
					
						}
					}
					catch(SQLException e1) {
						System.out.println("sql excetion");
					} 
				if(ch>0) {	
					
				 String password=JOptionPane.showInternalInputDialog(contentPane, "Enter password");
				
				 if(!password.contentEquals("")) {
					 try {
						   
							String sql="update account set password='"+ password +"' where email='"+ email +"' ";
							//it execute sql query
							st.executeUpdate(sql);
							
							JOptionPane.showInternalMessageDialog(contentPane, "password updated!");
							}
							catch(SQLException e1) {
								System.out.println("sql excetion");
							} 
				 }
				 else {
					 JOptionPane.showInternalMessageDialog(contentPane, "password cannot be empty"); 
				 }
				}
				else {
					JOptionPane.showInternalMessageDialog(contentPane, "Wrong Email!");	
					
				}
				}
			}
			catch(Exception e1) {
				//System.out.println(e1);
				
			}
				
				
				
			}
		});                                                       //forget password action complete
		lblForgetPassword.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblForgetPassword.setBackground(Color.YELLOW);
		lblForgetPassword.setForeground(Color.BLACK);
		lblForgetPassword.setBounds(198, 467, 146, 29);
		contentPane.add(lblForgetPassword);
		
		
		
		
	}                                       //complete Start()





//this method provides create class,join class or skip  pannel
public void CreateClass() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	contentPane = new JPanel();
	setBounds(100, 100, 383, 578);
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	contentPane.setForeground(Color.RED);

	contentPane.setBackground(new Color(102, 102, 153));
	contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Create Classes", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	//button join (it is used by student & student enter class code to join class that is given by teacher)
	JButton btnJoinClass = new JButton("Join Class");
	btnJoinClass.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			contentPane.setVisible(false);
//			EnterClassCode();
			try {
			String classcode=JOptionPane.showInternalInputDialog(contentPane,"Enter Class Code");
			if(!classcode.contentEquals("")) {
				int check=0;
				int var=0;
				String sql2="select class_code from classinfo where email='"+ getMyEmail() +"'";
				ResultSet rs2=st.executeQuery(sql2);
				while(rs2.next()) {
					//It eliminate duplicacy means if you join class already then you didn't join again
					String code=rs2.getString(1);
					if(code.contentEquals(classcode)) {
					var=1;
					}
				}
				if(var==1) {
					//message if you already join class
					JOptionPane.showMessageDialog(contentPane, "You have already joined this class");
				}
				else{
						
			String sql1="select class_name from classinfo where class_code='"+ classcode +"'";
			ResultSet rs=st.executeQuery(sql1);
		     String classname="";
		     
			while(rs.next()) {
				check++;
				 classname=rs.getString(1);
				 String sql="insert into classinfo(CLASS_CODE,CLASS_CREATE,EMAIL,CLASS_NAME) values('"+ classcode +"','No','"+ getMyEmail() +"','"+ classname +"')";
				 
				 st.executeUpdate(sql);
				 setMyClassName(classname);

					list();
					}
			if(check==0) {
				//message if class code is invalid
				JOptionPane.showMessageDialog(contentPane, "Wrong class code");
				
			}
				
				
			}
			}
			}
			catch(Exception e1) {
				
				//System.out.println("rest step hi");
			}
		}
	});
	btnJoinClass.setBackground(Color.BLACK);
	btnJoinClass.setForeground(Color.WHITE);
	btnJoinClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnJoinClass.setBounds(90, 275, 191, 32);
	contentPane.add(btnJoinClass);                                  //button join complete
	
	
	//button create(it is used by teacher & teacher create classcode and classname)
	JButton btnCreateClass = new JButton("Create Class");
	btnCreateClass.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			         String codeforclass = JOptionPane.showInternalInputDialog(contentPane,"Enter Class code ! it must be globally unique");
					 
					 if(!codeforclass.contentEquals("")) {
					     int classcodeexist=0;					 
						    String sql1="select class_code from classinfo where class_code='"+codeforclass+"'";
						    
						    ResultSet rs=st.executeQuery(sql1);
						    while(rs.next()) {
						    classcodeexist++;
						    }	
						 if(classcodeexist==0) {
							
							String classname=JOptionPane.showInternalInputDialog(contentPane,"Enter Class Name");
							
							if(classname.contentEquals("")) {
								 JOptionPane.showMessageDialog(contentPane, "classname cann't be empty");
							 }
							else {
								setMyClassCode(codeforclass);
							     String classcode=getMyClassCode();
								 String sql="insert into classinfo(CLASS_CODE,CLASS_CREATE,EMAIL,CLASS_NAME) values('"+ classcode +"','yes','"+ getMyEmail() +"','"+ classname +"')";
								 st.executeUpdate(sql);

								 contentPane.setVisible(false);
									list();
								
							}
					 }
						 else {
							 JOptionPane.showMessageDialog(contentPane, "This code exist in database. So,try another code");
					 }
					 }
					 else {
						 JOptionPane.showMessageDialog(contentPane, "class code cann't be empty");
					 
					 
			}
			}
							catch(Exception e1) {
								//System.out.println("rest step hi");
							}
					 }
			
	});
	btnCreateClass.setForeground(Color.WHITE);
	btnCreateClass.setBackground(Color.BLACK);
	btnCreateClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnCreateClass.setBounds(90, 219, 191, 32);
	contentPane.add(btnCreateClass);                             //button create complete
	
	//button skip(it is used by teacher and student if both are not interseted to create or join the class at present)
	JButton btnSkip = new JButton("Skip");
	btnSkip.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			list();
			
		}
	});
	btnSkip.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnSkip.setForeground(Color.WHITE);
	btnSkip.setBackground(Color.BLACK);
	btnSkip.setBounds(90, 333, 191, 32);
	contentPane.add(btnSkip);                                  //button skip complete
	
	JButton btnhome = new JButton("Log out");
	btnhome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			start();
			
		}
	});
	btnhome.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnhome.setForeground(Color.WHITE);
	btnhome.setBackground(Color.BLACK);
	btnhome.setBounds(90, 455, 191, 32);
	contentPane.add(btnhome);
}

int controlpaint=1;
public void paint(Graphics gp) {
	super.paint(gp);
	Graphics2D graphics=(Graphics2D) gp;
	
	
	graphics.setColor(Color.DARK_GRAY);
	
	Stroke s=new BasicStroke(3f);
	
	graphics.setStroke(s);
	if(controlpaint>1) {
	Line2D line=new Line2D.Float(0.0f,66.00f,383.00f,66.00f);
	graphics.draw(line);
	}
	controlpaint++;
	
	
}

//This method provides class list on panel
public void list() {
	//variable to control arrange of frames
	j=50;
	contentPane = new JPanel();
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 383, 578);
	contentPane.setForeground(Color.RED);
	//mode
    if(mode==1) {
	contentPane.setBackground(new Color(102, 102, 153));
    }
    else {
    contentPane.setBackground(new Color(0, 128, 128));
    }
	setContentPane(contentPane);
     
	classcreate="";
	clcreate="Student Portal";
	
    repaint();
	
	
	
	try {
		
		
		String sql="select class_name,class_create,class_code from classinfo where email='"+getMyEmail()+"'" ;
		ResultSet rs=st.executeQuery(sql);
//	System.out.println(getMyEmail());
	
		String clname="",clcode="";
		
		while(rs.next()) {
			 clname=rs.getString(1);
			 clcode=rs.getString(3);
			 classcreate=rs.getString(2);
			 if(classcreate.equals("Yes")) {
					clcreate="Teacher Portal";
					
				}
			 setMyClassName(clname);
			 setMyClassCode(clcode);
			 classList();
		}
		ip=0;
		
	}
	catch(SQLException e1) {
		System.out.println("rest step hi");
	}
	
	
	//MenuBar conatian Logout, Menu , Settings
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(220, 7, 140, 25);
	contentPane.add(menuBar);

	menuBar.setBorder(null);
	menuBar.setBackground(SystemColor.activeCaption);
	
	//Create Menu
	JMenu menu = new JMenu("Menu");
	menu.setForeground(Color.WHITE);
	menu.setBackground(new Color(0, 128, 128));
//	menu.setBackground(Color.DARK_GRAY);
    menu.setBorder(null);
	
    //Create item for menu like Join, Create, Profile
	JMenuItem menu1=new JMenuItem("Join");
	//action for join
	menu1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			System.out.println("hi");
		}
	});
	menu1.setIconTextGap(8);
//	menu1.setIcon(new ImageIcon("D:\\Downloads\\pic\\amazone1.jpg"));
	menu1.setForeground(Color.WHITE);
	menu1.setBackground(new Color(95, 158, 160));    
	
	//create -menu2
	JMenuItem menu2=new JMenuItem("Create");
	//Action for Create
	menu2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			System.out.println("hi2");
		}
	});
	menu2.setIconTextGap(8);
//	menu2.setIcon(new ImageIcon("D:\\Downloads\\pic\\amazone1.jpg"));
	menu2.setForeground(Color.WHITE);
	menu2.setBackground(new Color(100, 149, 237));
	
	//Profile
	JMenuItem menu3=new JMenuItem("Profile");
	//Action -menu3
	menu3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
		profile();
		}
	});
	menu3.setIconTextGap(8);
//	menu3.setIcon(new ImageIcon("D:\\Downloads\\pic\\amazone1.jpg"));
	menu3.setBackground(new Color(173, 216, 230));
	menu3.setForeground(Color.WHITE);
	
	
	//Menuitem -setting
	JMenuItem mnsettings = new JMenuItem("Settings");
	//Action
		mnsettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
//				start();
				settings();
				
			}
		});
	mnsettings.setForeground(Color.WHITE);
	mnsettings.setBackground(new Color(0, 128, 128));
//	mnsettings.setBackground(Color.DARK_GRAY);

	mnsettings.setBorder(null);

	//Menuitem -Logout
	JMenuItem mnLogout = new JMenuItem("LogOut");
	//Action
	mnLogout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			contentPane.setVisible(false);
			start();
			
		}
	});
	//mnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	mnLogout.setForeground(Color.WHITE);
	mnLogout.setBackground(new Color(0, 128, 128));
//	mnLogout.setBackground(Color.DARK_GRAY);
	mnLogout.setBorder(null);
	
	//Add menu,settings,Logout to MenuBar
	menuBar.add(menu);
	menuBar.add(mnsettings);
	menuBar.add(mnLogout);
	
	//Add menu1,2,3 to Menu
	menu.add(menu1);
	menu.add(menu2);
	menu.add(menu3);
	
	//end menubar
	
	JLabel classname=new JLabel(clcreate);
	classname.setForeground(Color.ORANGE);
	classname.setFont(new Font("Tahoma", Font.BOLD, 15));
	classname.setVisible(true);
	contentPane.setLayout(null);
	classname.setBounds(20, 7, 120,25);
	classname.setBackground(Color.WHITE);
	contentPane.add(classname);
	
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);	
			j=40;
		CreateClass();
		
			
		}
	});
	btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnBack.setForeground(new Color(255, 255, 255));
	btnBack.setBackground(new Color(0, 0, 0));
	btnBack.setBounds(10, 540, 85, 21);
	contentPane.add(btnBack);
	
	


	
}

//This makes internal frame corresponding to each class and it is always called list()
public void classList() {
	JInternalFrame internalFrame;		
	internalFrame = new JInternalFrame(getMyClassCode());

	if(mode==1) {
	internalFrame.getContentPane().setBackground(Color.DARK_GRAY);
	}
	else {
		internalFrame.getContentPane().setBackground(new Color(255,140,0));	
	}
	
	internalFrame.getContentPane().setLayout(null);
	internalFrame.setBorder(null);

	JLabel lblName = new JLabel(getMyClassName());
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblName.setBounds(10, 10, 135, 30);
	lblName.setForeground(Color.WHITE);
	internalFrame.getContentPane().add(lblName);

	JButton bt1=new JButton(getMyClassCode());
	
	bt1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			assignList(bt1);
			//setMyClassCode(bt1.getText());
		}
		});
		
	
	bt1.setToolTipText("Read More\r\n");
	bt1.setForeground(Color.WHITE);
	bt1.setBackground(Color.BLACK);
	bt1.setBounds(217, 39, 85, 21);
	
	internalFrame.getContentPane().add(bt1);
	

	internalFrame.setForeground(Color.WHITE);
	internalFrame.setBackground(Color.WHITE);
	internalFrame.setBounds(10, j, 349, 109);
	j+=115;
	ip++;
	contentPane.add(internalFrame);
	internalFrame.setVisible(true);
}
//complete classlist()




//This show Assignment List
public void assignList(JButton bt1) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	contentPane.setForeground(Color.RED);
//	contentPane.setBackground(new Color(138, 43, 226));
	if(mode==1) {
		contentPane.setBackground(new Color(102, 102, 153));	
	}
	else {
	contentPane.setBackground(new Color(0, 128, 128));
	}
	
	
	contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Assignments", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	String bto=bt1.getText();
	//System.out.println(bto+"  hi");
	JInternalFrame internalFrame;		

	int control=38;
	
try {	
		String sql="select assignment_name,due_date from assignmentlist where class_code='"+bto+"'" ;
		ResultSet rs=st.executeQuery(sql);
	
		String assign="";
		String duedate="";
		
		while(rs.next()) {
			    assign=rs.getString(1);
			    duedate=rs.getString(2);
			    internalFrame = new JInternalFrame(bto);
			    if(mode==1) {
				   internalFrame.getContentPane().setBackground(Color.DARK_GRAY);
			    }
			    else {
			    	internalFrame.getContentPane().setBackground(new Color(255,140,0));	
			    }
			    
				internalFrame.getContentPane().setLayout(null);
				
				JLabel lblName = new JLabel(assign);
				lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblName.setBounds(10, 10, 120, 30);
				lblName.setForeground(Color.WHITE);
				internalFrame.getContentPane().add(lblName);
				
				JLabel lblduedate = new JLabel("Due: "+duedate);
				lblduedate.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblduedate.setBounds(235, 10, 135, 30);
				lblduedate.setForeground(Color.WHITE);
				internalFrame.getContentPane().add(lblduedate);
				
				internalFrame.setForeground(Color.DARK_GRAY);
			
				
				internalFrame.setBounds(10, control, 349, 86);
				internalFrame.setBorder(null);
				contentPane.add(internalFrame);
				internalFrame.setVisible(true);
				control+=100;
				
				
				//Action on clicked on particular assignment
				internalFrame.getContentPane().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//System.out.println("hi");
						contentPane.setVisible(false);
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						setBounds(100, 100, 383, 578);
						contentPane = new JPanel();
						setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
						contentPane.setForeground(Color.RED);
//						contentPane.setBackground(new Color(138, 43, 226));
						if(mode==1) {
							contentPane.setBackground(new Color(102, 102, 153));	
						}
						else {
						contentPane.setBackground(new Color(0, 128, 128));
						}
						contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Submittion List", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
						setContentPane(contentPane);
						contentPane.setLayout(null);
						
						
						
						JButton btnCancel = new JButton("Back");
						btnCancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								contentPane.setVisible(false);
								list();
							}
						});
						btnCancel.setBackground(Color.BLACK);
						btnCancel.setForeground(Color.WHITE);
						btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
						btnCancel.setBounds(26, 490, 100, 34);
						contentPane.add(btnCancel);	
					}
				});
			
		}
		
		
		
	}
	catch(SQLException e1) {
		System.out.println("rest step hi");
	}
	
	
	
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			j=40;
			contentPane.setVisible(false);
			list();
			
		}
	});
	btnBack.setBackground(new Color(0, 0, 0));
	btnBack.setForeground(new Color(255, 255, 255));
	btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnBack.setBounds(15, 500, 106, 32);
	contentPane.add(btnBack);
	
	if(classcreate.equalsIgnoreCase("Yes")){
	   JButton btnMore = new JButton(" + ");
	   btnMore.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
       // CreateAssignment ca=new CreateAssignment();
         //    ca.setVisible(true);
			contentPane.setVisible(false);
			CreateAssignment(bto);
		}	
	});
	btnMore.setForeground(Color.WHITE);
	btnMore.setBackground(Color.BLACK);
	btnMore.setToolTipText("upload assignment");
	btnMore.setBounds(270, 500, 80, 32);
	contentPane.add(btnMore);
}
	
	
	
	

}//Complete Assignment list Method






//This method shows profile
public void profile() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	contentPane.setBackground(Color.DARK_GRAY);
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.WHITE);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblName.setBounds(36, 146, 80, 24);
	contentPane.add(lblName);
	
	JLabel lblEmail = new JLabel("Email :");
	lblEmail.setForeground(Color.WHITE);
	lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblEmail.setBounds(36, 189, 80, 24);
	contentPane.add(lblEmail);
	
	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblPassword.setForeground(Color.WHITE);
	lblPassword.setBounds(36, 238, 94, 24);
	contentPane.add(lblPassword);
	
	String email="",password="",username="";
	try {
		//sql query for checking the email,password info in database
		String sql="select Email,Password,username from account where email='"+getMyEmail()+"'" ;
		
		ResultSet rs=st.executeQuery(sql);	
		
		
		
		while(rs.next()) {
			
			 email=rs.getString(1);	
			 password=rs.getString(2);
			 username=rs.getString(3);
		
				}
		
	}
	catch(SQLException e1) {
		System.out.println("sql exception");
	}	
	
	JLabel lblNewLabel = new JLabel(username);
	lblNewLabel.setForeground(new Color(204, 204, 255));
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel.setBounds(150, 146, 159, 24);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel(email);
	lblNewLabel_1.setForeground(new Color(204, 153, 255));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(150, 189, 159, 24);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel(password);
	lblNewLabel_2.setForeground(new Color(204, 153, 255));
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_2.setBounds(150, 238, 159, 24);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblEdit = new JLabel("edit");
	lblEdit.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String name="";
			 try {
			name=JOptionPane.showInternalInputDialog(contentPane, "Enter name");
                   if(!name.contentEquals("")) {
				    String sql="update account set username='"+ name +"' where email='"+getMyEmail()+"' ";
					st.executeUpdate(sql);
					JOptionPane.showInternalMessageDialog(contentPane, "name update!");
					profile();
					}			
			}
			 catch(Exception e1) {

				} 
		}
	});
	lblEdit.setForeground(Color.GRAY);
	lblEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblEdit.setBounds(310, 154, 46, 13);
	contentPane.add(lblEdit);
	
	JLabel lblEdit_2 = new JLabel("edit");
	lblEdit_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			 try {
			String Password=JOptionPane.showInternalInputDialog(contentPane, "Enter Password");
			if(!Password.contentEquals("")) {

					String sql="update account set password='"+ Password +"' where email='"+getMyEmail()+"' ";
					//it execute sql query
					st.executeUpdate(sql);
					
					JOptionPane.showInternalMessageDialog(contentPane, "Password update!");
					profile();
					}
					
		}
			 catch(Exception e1) {
					
				} 
		}
	});
	lblEdit_2.setForeground(Color.GRAY);
	lblEdit_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblEdit_2.setBounds(310, 246, 46, 13);
	contentPane.add(lblEdit_2);
	
	JLabel lblNewLabel_3 = new JLabel("Profile");
	lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_3.setBounds(150, 63, 103, 24);
	contentPane.add(lblNewLabel_3);
	
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			contentPane.setVisible(false);
			list();
			
		}
	});
	btnBack.setBackground(new Color(0, 0, 0));
	btnBack.setForeground(new Color(255, 255, 255));
	btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnBack.setBounds(15, 500, 106, 32);
	contentPane.add(btnBack);
}


public void CreateAssignment(String class_code) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	contentPane.setForeground(Color.RED);
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	contentPane.setBackground(SystemColor.textInactiveText);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblduedate = new JLabel("Due date :");
	lblduedate.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblduedate.setForeground(new Color(72, 61, 139));
	lblduedate.setBounds(34, 244, 93, 19);
	contentPane.add(lblduedate);
	
	textField_1 = new JTextField();
	textField_1.setBounds(128, 244, 201, 24);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
	
	
	JLabel lblname = new JLabel("Name :");
	lblname.setForeground(new Color(72, 61, 139));
	lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblname.setBounds(34, 197, 93, 24);
	contentPane.add(lblname);

	textField = new JTextField();
	textField.setBounds(128, 197, 201, 24);
	contentPane.add(textField);
	textField.setColumns(10);
	
	
	
	
	
	
	 //dihkhdhk
	
	JLabel	lb=new JLabel("none file selected");
	lb.setBackground(new Color(0, 0, 0));
	lb.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lb.setForeground(new Color(255, 255, 255));
	lb.setBounds(160, 313, 210, 19);
	contentPane.add(lb);
	
	btnNewButton = new JButton("choose file");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
		
			JFileChooser j=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
			int r=j.showOpenDialog(null);
			if(r==JFileChooser.APPROVE_OPTION) {
				
				lb.setText(j.getSelectedFile().getAbsolutePath());
			}
			else {
				lb.setText("Operation is Cancelled");
			}
		}
	});
	btnNewButton.setBounds(34, 314, 110, 21);
	contentPane.add(btnNewButton);
	
JButton btnDone = new JButton("Done");
	
	btnDone.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String sql="select class_name from classinfo where class_code='"+ class_code +"'";
				ResultSet rs=st.executeQuery(sql);
				String class_name="";
				while(rs.next()) {
					class_name=rs.getString(1);
					
				}
				
				if(textField_1.getText().equals("") || textField.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "None filed cannot e Emptied");
				}
				else {
				String sql1="insert into assignmentlist(CLASS_NAME,CLASS_CODE,ASSIGNMENT_NAME,DUE_DATE) values('"+ class_name+"','"+  class_code +"','"+textField.getText()+"','"+textField_1.getText()+"')";
				st.executeUpdate(sql1);
				
				JOptionPane.showInternalMessageDialog(contentPane,"Successfully assignment uploaded!");
				contentPane.setVisible(false);
				list();
			}
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
			

			
		}
	});
	

	btnDone.setForeground(new Color(255, 255, 255));
	btnDone.setBackground(new Color(0, 0, 0));
	btnDone.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnDone.setBounds(227, 445, 102, 34);
	contentPane.add(btnDone);
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			list();	
		}
	});
	btnCancel.setBackground(Color.BLACK);
	btnCancel.setForeground(Color.WHITE);
	btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnCancel.setBounds(26, 445, 101, 34);
	contentPane.add(btnCancel);
	
//	btnNewButton_1 = new JButton("save");
//	btnNewButton_1.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			JFileChooser j=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());	
//			int r=j.showOpenDialog(null);
//			if(r==JFileChooser.APPROVE_OPTION) {
//				lb.setBounds(138, 345, 210, 19);
//				lb.setText(j.getSelectedFile().getAbsolutePath());
//			}
//			else {
//				lb.setText("operation is cancelled");
//			}
//		}
//	});
//	btnNewButton_1.setBounds(34, 347, 85, 21);
//	contentPane.add(btnNewButton_1);
		
}
public void settings() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	contentPane.setForeground(Color.GRAY);
	if(mode==1) {
		contentPane.setBackground(Color.DARK_GRAY);	
	}
	else {
	contentPane.setBackground(new Color(0, 128, 128));
	}
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	
	JLabel lblTheme = new JLabel("Theme");
	lblTheme.setForeground(new Color(30, 144, 255));
	lblTheme.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblTheme.setBounds(10, 41, 105, 24);
	contentPane.add(lblTheme);
	
	ButtonGroup bg=new ButtonGroup();
	
	JRadioButton rdbtnDarkMode = new JRadioButton("Dark Mode");
	rdbtnDarkMode.setForeground(Color.LIGHT_GRAY);
	rdbtnDarkMode.setBackground(Color.DARK_GRAY);
	rdbtnDarkMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnDarkMode.setBounds(20, 72, 115, 21);
	bg.add(rdbtnDarkMode);
	
	
	contentPane.add(rdbtnDarkMode);
	
	JRadioButton rdbtnNormalMode = new JRadioButton("Normal Mode");
	rdbtnNormalMode.setForeground(Color.LIGHT_GRAY);
	rdbtnNormalMode.setBackground(Color.DARK_GRAY);
	rdbtnNormalMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnNormalMode.setBounds(158, 72, 140, 21);
	bg.add(rdbtnNormalMode);
	contentPane.add(rdbtnNormalMode);
	
	
	
	
	JLabel lblSettings = new JLabel("Settings");
	lblSettings.setForeground(Color.ORANGE);
	lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblSettings.setBounds(138, 10, 81, 24);
	contentPane.add(lblSettings);
	
	
	ButtonGroup bg1=new ButtonGroup();
	JLabel lblNotifications = new JLabel("Notifications");
	lblNotifications.setForeground(new Color(30, 144, 255));
	lblNotifications.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNotifications.setBounds(10, 113, 105, 24);
	contentPane.add(lblNotifications);
	
	JRadioButton rdbtnAllow = new JRadioButton("Allow");
	rdbtnAllow.setForeground(Color.LIGHT_GRAY);
	rdbtnAllow.setBackground(Color.DARK_GRAY);
	rdbtnAllow.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnAllow.setBounds(20, 156, 105, 21);
	contentPane.add(rdbtnAllow);
	bg1.add(rdbtnAllow);
	
	JRadioButton rdbtnNotAllow = new JRadioButton("Not Allow");
	rdbtnNotAllow.setForeground(Color.LIGHT_GRAY);
	rdbtnNotAllow.setBackground(Color.DARK_GRAY);
	rdbtnNotAllow.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnNotAllow.setBounds(158, 156, 105, 21);
	contentPane.add(rdbtnNotAllow);
	bg1.add(rdbtnNotAllow);
	
	
	JLabel lblRemoveAccount = new JLabel("Remove Account");
	lblRemoveAccount.setForeground(new Color(30, 144, 255));
	lblRemoveAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblRemoveAccount.setBounds(10, 202, 140, 13);
	contentPane.add(lblRemoveAccount);
	
	JRadioButton rdbtnDoYouWant = new JRadioButton("Do You Want to ramove Account?");
	rdbtnDoYouWant.setForeground(new Color(255, 69, 0));
	rdbtnDoYouWant.setBackground(Color.DARK_GRAY);
	rdbtnDoYouWant.setFont(new Font("Tahoma", Font.PLAIN, 12));
	rdbtnDoYouWant.setBounds(30, 231, 268, 21);
	contentPane.add(rdbtnDoYouWant);
	
	JButton btnSave = new JButton("Save");
	btnSave.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnDarkMode.isSelected())
			{
				mode=1;
			}
			else if(rdbtnNormalMode.isSelected()) {
			mode=2;
			}
			contentPane.setVisible(false);
			list();
		}
	});
	btnSave.setBackground(Color.BLACK);
	btnSave.setForeground(Color.WHITE);
	btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnSave.setBounds(20, 414, 85, 21);
	contentPane.add(btnSave);
	

	
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			list();
		}
	});
	btnCancel.setForeground(Color.WHITE);
	btnCancel.setBackground(Color.BLACK);
	btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnCancel.setBounds(138, 414, 85, 21);
	contentPane.add(btnCancel);
	
}
}


