package Pages;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Window.Type;

public class Login extends JFrame {


	private String myclassname,myemail,myclasscode;
	private JPanel contentPane;
	private static final String UNDERSCORE= "_";
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
	//control student view list
	String[] str= {""};
	
	//grades
	String[] grades= {""};
	int givinggrades=10;
	
	int row=0;
	
	String mylink="";
	
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
	
	Login f;
	//constructor
	public Login() {
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Dialog", Font.BOLD, 16));
		setTitle("GLA-ClassRoom");
		start();
	}

	public void controlframe(Login f1) {
		f=f1;
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
		setResizable(false);
		
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
							//dashboard();
							list();
										
									
								}
							}
					if(check==0) {
						
						//Print message if password is wrong
					
					JOptionPane.showInternalMessageDialog(contentPane,"Please check your id OR password");
					}	
				}
				catch(Exception e1) {
					//System.out.println("sql exception");
				}	
				
			}
		});                                          //login action complete
		
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(255, 140, 0));
		btnLogin.setBounds(212, 388, 116, 36);
		btnLogin.setBorder(null);
		//it add button on panel
		contentPane.add(btnLogin);                  //login button complete
		
		try {
		//create button signup
		JButton btnSignup = new JButton("Sign Up");
		
		//code for action happen
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							Signup frame1 = new Signup();
							contentPane.setVisible(false);
							f.setVisible(false);
							frame1.my();
							
							
						}
		});                                                 //signup action complete
		
		
		
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignup.setBackground(new Color(255, 140, 0));
		btnSignup.setBounds(33, 388, 116, 36);
		btnSignup.setBorder(null);
		//it add button on panel
		contentPane.add(btnSignup);                          //signup button complete
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
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
					catch(Exception e1) {
						//System.out.println("sql excetion");
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
		
		JLabel lblNewLabel_4 = new JLabel("LogIn Here !");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setBounds(93, 53, 204, 54);
		contentPane.add(lblNewLabel_4);
		
		
		
		
	}                                       //complete Start()





//It is called first signup of new account
public void dashboard(String email){
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setMyEmail(email);
	contentPane = new JPanel();
	//setBounds(100, 100, 383, 578);
	//setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	contentPane.setForeground(Color.RED);

	contentPane.setBackground(new Color(102, 102, 153));
	contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Create Classes", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	//button join (it is used by student & student enter class code to join class that is given by teacher)
	JButton btnJoinClass = new JButton("Join Class");
	btnJoinClass.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			joinClass();

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
			createClassByTeacher();

					 }
			
	});
	btnCreateClass.setForeground(Color.WHITE);
	btnCreateClass.setBackground(Color.BLACK);
	btnCreateClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnCreateClass.setBounds(90, 219, 191, 32);
	contentPane.add(btnCreateClass);                             //button create complete

	
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


//it is used by student to join the class by entering the valid class code
public void joinClass() {
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


//This function create the class by the teacher
public void createClassByTeacher() {
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
					 String sql="insert into classinfo(CLASS_CODE,CLASS_CREATE,EMAIL,CLASS_NAME) values('"+ classcode +"','Yes','"+ getMyEmail() +"','"+ classname +"')";
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


//to draw the line
int controlpaint=0;
public void paint(Graphics gp) {
	super.paint(gp);
	Graphics2D graphics=(Graphics2D) gp;
	
	
	graphics.setColor(Color.DARK_GRAY);
	
	Stroke s=new BasicStroke(3f);
	
	graphics.setStroke(s);
	if(controlpaint==1 || controlpaint==3) {
	Line2D line=new Line2D.Float(0.0f,66.00f,383.00f,66.00f);
	graphics.draw(line);
	}
	if(controlpaint==2) {
		Line2D line=new Line2D.Float(0.0f,515.00f,383.00f,515.00f);
		graphics.draw(line);
		}
	//controlpaint++;
	
	
}

//This method provides class list on panel for both student and teacher
public void list() {
	

	
	 int check=0;
	//variable to control arrange of frames
	j=50;
	contentPane = new JPanel();

	contentPane.setForeground(Color.RED);
	 try {
		    String sql="select class_code from classinfo where email='"+getMyEmail()+"'";
		    ResultSet rs=st.executeQuery(sql);
		    while(rs.next()) {
		    	check=1;	
		    }
		    if(check==0) {
		    	contentPane.setVisible(false);
		    	dashboard(getMyEmail());
		    }
		    }
		    catch(Exception e) {
		    //System.out.println("i ma breakable");	
		    }
	
	if(check!=0) {
	
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
	controlpaint=1;
	
	
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
    if(classcreate.equals("No")) {
	JMenuItem menu1=new JMenuItem("Join");
	//action for join
	menu1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			joinClass();
		}
	});
	menu1.setIconTextGap(8);

	menu1.setForeground(Color.WHITE);
	menu1.setBackground(new Color(100, 149, 237)); 
	menu.add(menu1);
	
	JMenuItem menu4=new JMenuItem("Remove");
	//Action for Create
	menu4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			remove("No");
		}
	});
	menu4.setIconTextGap(8);

	menu4.setForeground(Color.WHITE);
	menu4.setBackground(new Color(100, 149, 237));
	menu.add(menu4);
    }
	
	//create -menu2
	if(classcreate.equals("Yes")) {
	JMenuItem menu2=new JMenuItem("Create");
	//Action for Create
	menu2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			createClassByTeacher();
		}
	});
	menu2.setIconTextGap(8);
	menu2.setForeground(Color.WHITE);
	menu2.setBackground(new Color(100, 149, 237));
	menu.add(menu2);
	
	JMenuItem menu3=new JMenuItem("Remove");
	//Action for Create
	menu3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			remove("Yes");
		}
	});
	menu3.setIconTextGap(8);

	menu3.setForeground(Color.WHITE);
	menu3.setBackground(new Color(100, 149, 237));
	menu.add(menu3);
	}
	
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
	menu3.setBackground(new Color(100, 149, 237));
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
			controlpaint=4;
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
	
	

	
	

	}
	
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




//This show Assignment List coreesepond to each class
public void assignList(JButton bt1) {

	contentPane = new JPanel();

	contentPane.setForeground(Color.RED);

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
    
	if(classcreate.equals("Yes")) {
		
		controlpaint=3;
		repaint();
		
		
		try {
			String sql="select count(class_create) from classinfo where class_code='"+bt1.getText()+"' and class_create='No' " ;
			ResultSet rs=st.executeQuery(sql);
			String count="";
			
			while(rs.next()) {
				 count=rs.getString(1);	
			}
			
			JLabel scount=new JLabel("Students: "+count);
			scount.setForeground(Color.GREEN);
			scount.setFont(new Font("Tahoma", Font.BOLD, 15));
			scount.setVisible(true);
			contentPane.setLayout(null);
			scount.setBounds(10, 7, 120,25);
			scount.setBackground(Color.WHITE);
			contentPane.add(scount);
			
			
			
		}
		catch(Exception e1) {
			System.out.println("rest step hi");
		}
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(310, 11, 45, 20);
		contentPane.add(menuBar);

		menuBar.setBorder(null);
		menuBar.setBackground(SystemColor.activeCaption);	
		JMenuItem view = new JMenuItem("View");
		
		    //Action
		view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					contentPane.setVisible(false);
                      controlpaint=4;
					studentlist(bt1);
					
				}
			});
		view.setForeground(Color.WHITE);
		view.setBackground(new Color(0, 102, 51));
		view.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		view.setBorder(null);
		menuBar.add(view);
		
	}
	
	JInternalFrame internalFrame;		

	int control=50;
	
	
try {	
		String sql="select assignment_name,due_date,assignment_id from assignmentlist where class_code='"+bto+"'" ;
		ResultSet rs=st.executeQuery(sql);
		String assign="";
		String duedate="";
		String assignmentid="";
		
		
		while(rs.next()) {
			    assign=rs.getString(1);
			    duedate=rs.getString(2);
			    assignmentid=rs.getString(3);
			    
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
				
				
				JButton asname=new JButton(assignmentid);
				if(classcreate.equals("Yes")) {
				
				asname.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
                        contentPane.setVisible(false);
						
						submit(asname,bt1);
					}
					});
				}
				else {
					asname.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
	                        contentPane.setVisible(false);
							
							studentsubmit(asname,bt1);
						}
						});
				}
					
				
				asname.setToolTipText("view submittions\r\n");
				asname.setForeground(Color.WHITE);
				asname.setBackground(Color.BLACK);
				asname.setBounds(217, 39, 85, 21);
				internalFrame.getContentPane().add(asname);
				

			
		}
		
		
		
	}
	catch(Exception e1) {
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
	btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnBack.setBounds(15, 500, 106, 32);
	contentPane.add(btnBack);
	
	if(classcreate.equalsIgnoreCase("Yes")){
	   JButton btnMore = new JButton(" + ");
	   btnMore.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
     
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

//this function tell the student how many student in thier class and he can also remove the student
public void studentlist(JButton classcd){
	contentPane = new JPanel();
	contentPane.setToolTipText("");
	contentPane.setBackground(Color.DARK_GRAY);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	//System.out.println(classcd.getText());
	DefaultListModel<String> l1=new DefaultListModel<>();
	
	try {
		int counts=0;
		
		String sql="SELECT email from classinfo where class_code='"+classcd.getText()+"' and class_create='No' ";
		ResultSet rs=st.executeQuery(sql);
		int ic=0;
		while(rs.next()) {
			counts++;	
		}
		
		 str=new String[counts];
		 //System.out.println(str[0]+" "+str[1]);
		
		String sql3="SELECT email from classinfo where class_code='"+classcd.getText()+"' and class_create='No' ";
		ResultSet rs3=st.executeQuery(sql3);
		while(rs3.next()) {
			str[ic]=rs3.getString(1);
			ic++;	
			
		}
		for(ic=0;ic<counts;ic++) {
		String sql1=" SELECT username from account where email='"+str[ic]+"'";
	    ResultSet rs1=st.executeQuery(sql1);
	    while(rs1.next()) {
	    	l1.addElement(rs1.getString(1));
	    	
	    }
		}
		
	}
	catch(Exception e2) {
		e2.printStackTrace();
	}
	JList<String> list = new JList<>(l1);

	list.setFont(new Font("Tahoma", Font.PLAIN, 14));
	list.setForeground(Color.ORANGE);
    list.setBackground(new Color(112, 128, 144));
	list.setBounds(10, 10, 350, 490);
	contentPane.add(list);
	
	JButton btnRemove = new JButton("Remove");
	btnRemove.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			String data="";
			if(list.getSelectedIndex()!=-1) {
				try {
					
					int response=JOptionPane.showInternalConfirmDialog(contentPane, "Do you Want Remove student From Your class");
					if(response==0) {
					
					String sql="DELETE from classinfo where email='"+str[list.getSelectedIndex()]+"'";
					st.executeUpdate(sql);
					studentlist(classcd);
					}
					else {
						
					}
				}
				catch(Exception e2){
					
				}
				
			}
		}
	});
	btnRemove.setBounds(274, 510, 85, 21);
	contentPane.add(btnRemove);
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			contentPane.setVisible(false);
			assignList(classcd);
		}
	});
	btnBack.setBounds(10, 510, 85, 21);
	btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	contentPane.add(btnBack);
	
	
	
}

//link open
public static void openURL(String url) {
	String osName = System.getProperty("os.name");
	//System.out.println(osName);
	try {
		if (osName.startsWith("Windows"))
			Runtime.getRuntime().exec(
					"rundll32 url.dll,FileProtocolHandler " + url);
		else {
			String[] browsers = { "firefox", "opera", "konqueror",
					"epiphany", "mozilla", "netscape" };
			String browser = null;
			for (int count = 0; count < browsers.length && browser == null; count++)
				if (Runtime.getRuntime().exec(
						new String[] { "which", browsers[count] })
						.waitFor() == 0)
					browser = browsers[count];
			Runtime.getRuntime().exec(new String[] { browser, url });
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error in opening browser"
				+ ":\n" + e.getLocalizedMessage());
	}
}


//it is used by student to upload their work or too see the see the uploaded the assignment
public void studentsubmit(JButton assignmentid,JButton classcode){

	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 128));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	controlpaint=2;
	repaint();
	JButton btnBack = new JButton("BACK");
	btnBack.setBackground(new Color(128, 128, 128));
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			assignList(classcode);
		}
	});
	btnBack.setBounds(10, 10, 85, 21);
	btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	contentPane.add(btnBack);
	
	
	
	JLabel lblDescription = new JLabel(" Description ");
	lblDescription.setForeground(new Color(0, 0, 0));
	lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblDescription.setBounds(10, 41, 97, 21);
	contentPane.add(lblDescription);
	

	JEditorPane descript= new JEditorPane();
	descript.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	descript.setForeground(Color.WHITE);
	descript.setFont(new Font("Tahoma", Font.PLAIN, 14));
	descript.setBackground(Color.GRAY);
	descript.setBounds(10, 73, 349, 161);
	contentPane.add(descript);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	scrollPane_1.setPreferredSize(new Dimension(1, 1));
	scrollPane_1.setViewportBorder(null);
	scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane_1.setBounds(10, 73, 349, 161);
	contentPane.add(scrollPane_1);
	scrollPane_1.setViewportView((descript));
	
	int n=Integer.parseInt(assignmentid.getText());
	
	//Description of assignment
	try
	{
		String sql="SELECT assignment_name,file_location,links from assignmentlist where assignment_id='"+assignmentid.getText()+"'";
		ResultSet rs=st.executeQuery(sql);
		String description="";
		String file="";
		String links="";
		while(rs.next()) {
			description=rs.getString(1);
			file=rs.getString(2);
			links=rs.getString(3);
			
		}
		descript.setText(description);
		descript.setEditable(false);
		
		if(!file.equals("")) {
			
			JLabel Files = new JLabel(" Files ");
			Files.setForeground(new Color(0, 0, 0));
			
			Files.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Files.setBounds(10, 255, 110, 26);
			contentPane.add(Files);
			
			JLabel location = new JLabel(file);
			location.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					try  
					{  
					File file = new File(location.getText());   
					if(!Desktop.isDesktopSupported())                            //check if Desktop is supported by Platform or not  
					{  
						JOptionPane.showInternalMessageDialog(contentPane, "Not supported Format");
					 
					}  
					Desktop desktop = Desktop.getDesktop();  
					if(file.exists()) {                                               //checks file exists or not  
					desktop.open(file);                                              //opens the specified file  
					}
					else {
						JOptionPane.showInternalMessageDialog(contentPane, "File not Exist");
					}
					}
				
					catch(Exception e1)  
					{  
					//e1.printStackTrace();  
					}
					
				}
			});
			location.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			location.setFont(new Font("Tahoma", Font.PLAIN, 15));
			location.setForeground(new Color(211, 211, 211));
			location.setBounds(10, 299, 227, 21);
			contentPane.add(location);
			
		
		}
		
		if(!links.equals("")) {
			JLabel link = new JLabel(" Links ");
			
			link.setForeground(new Color(0, 0, 0));
			link.setFont(new Font("Tahoma", Font.PLAIN, 16));
			link.setBounds(10, 350, 110, 26);
			contentPane.add(link);
			
			JLabel llocation = new JLabel(links);
			llocation.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openURL(llocation.getText().trim());
				
				}
			});
			llocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			llocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
			llocation.setForeground(new Color(211, 211, 211));
			llocation.setBounds(10, 390, 227, 21);
			contentPane.add(llocation);
			
		
		}
		
	}
	catch(Exception e) {
		
	}
	int controlvar=0;
	try {
	    String sql1="select Email from submittionlist where assignment_id='"+n+"'";
		//it execute sql query
		ResultSet rs=st.executeQuery(sql1);
	
		String myemail="";
		while(rs.next()) {
			myemail=rs.getString(1);
			if(myemail.equals(getMyEmail())){
				controlvar=1;
				break;
			}
			
		}
		
		//if assignment uploaded by student
		if(controlvar==1) {
	   
			try {
				
				String sql2="SELECT status,grades from submittionlist where assignment_id='"+n+"' and email='"+getMyEmail()+"'";
				String gr="0/0";
			
				ResultSet rs1=st.executeQuery(sql2);
				while(rs1.next()){
					if(rs1.getString(1).contentEquals("Checked")) {
						
						gr=rs1.getString(2);
					}	
				}
				
		JLabel grades = new JLabel("Grades: "+gr);
		grades.setForeground(Color.WHITE);
		grades.setBackground(new Color(135, 206, 235));
		grades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		grades.setBounds(10, 503, 85, 21);
		contentPane.add(grades);
		
		JLabel Status = new JLabel("Submitted");
		Status.setForeground(Color.WHITE);
		Status.setBackground(new Color(135, 206, 235));
		Status.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		Status.setBounds(259, 498, 66, 26);
		contentPane.add(Status);
		//System.out.println("hi");
			}
          catch(Exception e1) {
				
			}
		}
	}
	catch(Exception e2) {
	System.out.println(e2);	
	}
	
	//if assignment not uplooaded yet
	if(controlvar==0)
	{
		JLabel lb = new JLabel("None");
		lb.setBounds(117, 505, 97, 17);
		contentPane.add(lb);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 503, 50, 20);
		contentPane.add(menuBar);

		menuBar.setBorder(null);
		menuBar.setBackground(SystemColor.activeCaption);
		
		//Create Menu
		JMenu menu = new JMenu("Upload");
		menu.setForeground(Color.WHITE);
		menu.setBackground(new Color(0, 128, 128));

	    menu.setBorder(null);
	    
	    
	    JMenuItem menu1=new JMenuItem("File");
	    menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser j=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				
				int r=j.showOpenDialog(null);
				if(r==JFileChooser.APPROVE_OPTION) {
				   lb.setText(j.getSelectedFile().getAbsolutePath());
						
				}
				else {
					lb.setText("None");
				}
			}
		});
	    menu1.setIconTextGap(8);
		menu1.setForeground(Color.WHITE);
		menu1.setBackground(new Color(100, 149, 237)); 
		menu.add(menu1);
		
		
		JMenuItem menu4=new JMenuItem("link");
		menu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mylink="";
				String s=JOptionPane.showInternalInputDialog(contentPane, "Enter Link here!");	
				try {
				if(!s.equals("")) {
					 String text=s;
					  mylink="";
						for(int i=0;i<text.length();i++) {
							if(String.valueOf(text.charAt(i)).equals("\\")){
								mylink= mylink + "\\\\";
								System.out.println(text);
								
							}
							else {
								mylink = mylink + String.valueOf(text.charAt(i));
							}
								
						}
				}
			
				}
				catch(Exception e2) {
					
				}
			}
		});
		menu4.setIconTextGap(8);

		menu4.setForeground(Color.WHITE);
		menu4.setBackground(new Color(100, 149, 237));
		menu.add(menu4);
		menuBar.add(menu);
		
	

	
	
	//System.out.println(n);
	JButton btnSubmit = new JButton("Submit");
	btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			try {   
				     //check if alredy uploaded
				    String sql1="select Email from submittionlist where assignment_id='"+n+"'";
					ResultSet rs=st.executeQuery(sql1);
					int controlvar=0;
					String myemail="";
					while(rs.next()) {
						myemail=rs.getString(1);
						if(myemail.equals(getMyEmail())){
							controlvar=1;
							break;
						}
						
					}
					if(controlvar==1) {
						JOptionPane.showInternalMessageDialog(contentPane, "You Have already uploaded this assignment");
					}
					else {
						
						//for "\"slace store in database
						 String text=lb.getText();
						 String text1="";
							for(int i=0;i<text.length();i++) {
								if(String.valueOf(text.charAt(i)).equals("\\")){
									text1= text1 + "\\\\";
									System.out.println(text);
									
								}
								else {
									text1 = text1 + String.valueOf(text.charAt(i));
								}
									
							}
							//complete logic
							
							int confirm=JOptionPane.showInternalConfirmDialog(contentPane, "Do you Want To Submit?");
							if(confirm==0) {
								
							   //submitton date
								DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
						      JFormattedTextField today = new JFormattedTextField(dateFormat);
						      today.setValue(new Date());
						      String submitdate=today.getText();
						      
						      //
						      
						        int subid=0;
								String mysql="select * from submittionlist order by submittion_id desc limit 1";
								ResultSet myrs=st.executeQuery(mysql);
								if(myrs.next()) {
									subid=Integer.parseInt(myrs.getString("submittionlist_id")) + 1;
								}
								
								
								
								  //upload to aws bucket
//								App ob=new App();
								
							
								File ol=new File(text1);
									
									//original filename
									 String new1="";
									 String mynew="";
									
										for(int i=0;i<text1.length();i++) {
											if(String.valueOf(text1.charAt(i)).equals("\\")){
												new1= "";
								
											}
											else {
												new1 = new1 + String.valueOf(text1.charAt(i));
												
											}
												
										}
										
										//ne file name
										String new2="";

										String pre="";
										
										//extract suffix of file
										for(int i=0;i<new1.length();i++) {
											if(String.valueOf(new1.charAt(i)).equals(".")){
												pre= "";
												
												
											}
											else {
												pre = pre + String.valueOf(new1.charAt(i));
											}
												
										}
										
										//new file name
										new2 = String.valueOf(n) +"-"+ String.valueOf(subid) + "." + pre;
										mynew = text1.substring(0,(text1.length()-new1.length()));
										
										//new completete path
										mynew = mynew+new2;


										
										File ne=new File(mynew);
										
										if(ol.renameTo(ne)) {
//upload into s3 bucket
											
//											String fileName = folderName + SUFFIX + new2;
//											s3client.putObject(new PutObjectRequest(bucketName, fileName, 
//													new File(mynew))
//													.withCannedAcl(CannedAccessControlList.PublicRead));
	
									}
								
								//
						      
						      
						      
						      
						      
						      
									
			String sql="INSERT INTO submittionlist(Email,File,assignment_id,submit_date,links) values('"+getMyEmail()+"','"+new2+"','"+n+"','"+submitdate+"','"+mylink+"')";
			st.executeUpdate(sql);
			
			if(ne.renameTo(ol)) {
				
			}
			JOptionPane.showInternalMessageDialog(contentPane, "Successfully uploaded");
							}
			}
			}
			catch(Exception e1){
			e1.printStackTrace();	
			}
		}
	});
	btnSubmit.setBounds(274, 503, 85, 21);
	contentPane.add(btnSubmit);
	}
	
	
	
}
 

//it used by teacher to giving the grades and view assignment of students
public void submit(JButton assignmentid,JButton classcode) {
	
	
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	//setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
	contentPane.setForeground(Color.RED);

	if(mode==1) {
		contentPane.setBackground(new Color(102, 102, 153));	
	}
	else {
	contentPane.setBackground(new Color(0, 128, 128));
	}
	contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Submittion List", TitledBorder.CENTER, TitledBorder.TOP, null, Color.ORANGE));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBorder(null);
	scrollPane.setBounds(10, 20, 347, 470);
	
	contentPane.add(scrollPane);
	
	
	JTable table;
	String[][] s=new String[30][2];
	String[] s1={"Email","Grades"};
	
	int n=Integer.parseInt(assignmentid.getText());
	
	row=0;
	try {
		String sql="select Email,grades from submittionlist where assignment_id='"+n+"'";
		
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next()) {

			s[row][0]=rs.getString(1);              //email
			s[row][1]=rs.getString(2);             //grades
			//System.out.println(s[row][0]);
			row++;
			}
		}
		
	catch(Exception e2) {
		System.out.println(e2);
	}
	
	table = new JTable(s,s1);
	table.setFont(new Font("Tahoma", Font.BOLD, 12));
	table.setForeground(new Color(0, 191, 255));
	table.setBackground(Color.GRAY);
	table.setCellSelectionEnabled(true);
	ListSelectionModel select=table.getSelectionModel();
	select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	scrollPane.setViewportView(table);
	
	
	//Give grades
	
	grades=new String[row];
 
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {

			//System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));

			for(int i=0;i<row;i++) {
				grades[i]=(String)table.getValueAt(i,1);
				}
		}
	});
	
	
	JButton done = new JButton("Done");
	done.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showInternalMessageDialog(contentPane, "Click on any cell to giving these grades!");
			for(int i=0;i<row;i++) {
				try {
					String sql="UPDATE submittionlist SET grades='"+grades[i]+"' , status='Checked' where assignment_id='"+assignmentid.getText()+"' and email='"+(String)table.getValueAt(i,0)+"'";
					st.executeUpdate(sql);
					JOptionPane.showInternalMessageDialog(contentPane, "Grades successfully uploaded");
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}

		}
	});
	done.setBounds(274, 510, 85, 21);
	contentPane.add(done);
	
	
	//view the Assignment
	JButton btnView = new JButton("View");
	btnView.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			    String subemail=(String)table.getValueAt(table.getSelectedRow(),0);
				String sql="SELECT file from submittionlist where assignment_id='"+assignmentid.getText()+"' and email='"+subemail+"'";
				ResultSet rs=st.executeQuery(sql);
				while(rs.next()) {
					int pane=JOptionPane.showInternalConfirmDialog(contentPane, "Do you want open it?");
					if(pane==0) {
						try  
						{  
						File file = new File(rs.getString(1));   
						if(!Desktop.isDesktopSupported())                                                //check if Desktop is supported by Platform or not  
						{  
							JOptionPane.showInternalMessageDialog(contentPane, "Not supported Format");
						 
						}  
						Desktop desktop = Desktop.getDesktop();  
						if(file.exists()) {                                                            //checks file exists or not  
						desktop.open(file);                                                           //opens the specified file  
						}
						else {
						JOptionPane.showInternalMessageDialog(contentPane, "File not Exist");
						}
						}  
						catch(Exception e1)  
						{  
						
						}
					}
					//System.out.println(rs.getString(1));
				}
			}
			catch(Exception e1) {
				
			}
			
		}
	});
	btnView.setBounds(141, 510, 85, 21);
	contentPane.add(btnView);
	
	JButton btnCancel = new JButton("Back");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			contentPane.setVisible(false);
			assignList(classcode);
		}
	});
	btnCancel.setBackground(Color.BLACK);
	btnCancel.setForeground(Color.WHITE);
	btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnCancel.setBounds(10, 505, 100, 28);
	contentPane.add(btnCancel);	
}

//This method shows profile
public void profile() {

//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	contentPane.setBackground(Color.DARK_GRAY);
	//setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\downloads\\pic\\maths.png"));
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

//This method create the assignment to upload the assignment (Student)
public void CreateAssignment(String class_code) {

	contentPane = new JPanel();
	contentPane.setForeground(Color.RED);
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
	
	JTextField linktext = new JTextField();
	linktext.setColumns(10);
	linktext.setBounds(128, 156, 201, 24);
	contentPane.add(linktext);
	
	JLabel links = new JLabel("Links :");
	links.setForeground(new Color(72, 61, 139));
	links.setFont(new Font("Tahoma", Font.BOLD, 16));
	links.setBounds(34, 163, 93, 24);
	contentPane.add(links);
	
	 //dihkhdhk
	
	JLabel	lb=new JLabel("None file selected");
	lb.setBackground(new Color(0, 0, 0));
	lb.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lb.setForeground(new Color(255, 255, 255));
	lb.setBounds(160, 313, 100, 19);
	contentPane.add(lb);
	

	btnNewButton = new JButton("Choose file");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {			
		
			JFileChooser j=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
			int r=j.showOpenDialog(null);
			if(r==JFileChooser.APPROVE_OPTION) {
				lb.setText(j.getSelectedFile().getAbsolutePath());
				
				
				
			}
			else {
				lb.setText("None");
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
					JOptionPane.showMessageDialog(contentPane, "None filed cannot be Emptied");
				}
				else {
					
					//for \slace store in database
					 String text=lb.getText();
					 String text1="",link="";
					 String link12=linktext.getText();
						for(int i=0;i<text.length();i++) {
							if(String.valueOf(text.charAt(i)).equals("\\")){
								text1= text1 + "\\\\";
								//System.out.println(text);
								
							}
							else {
								text1 = text1 + String.valueOf(text.charAt(i));
							}
								
						}
						
						for(int i=0;i<link12.length();i++) {
							if(String.valueOf(link12.charAt(i)).equals("\\")){
								link= link + "\\\\";
								//System.out.println(text);
								
							}
							else {
								link = link + String.valueOf(link12.charAt(i));
							}
								
						}
						
						int valid=0;
						String checkdateformate=textField_1.getText();
							if(checkdateformate.charAt(2)=='-' && checkdateformate.charAt(5)=='-' && checkdateformate.length()==10) {
								valid=1;
								
								
						}
							int resp=JOptionPane.showInternalConfirmDialog(contentPane, "Do you Want to submit!");
							if(valid==1 && resp==0) {
								
								int myassignid=0;
								String mysql="select * from assignmentlist order by assignment_id desc limit 1";
								ResultSet myrs=st.executeQuery(mysql);
								if(myrs.next()) {
									myassignid=Integer.parseInt(myrs.getString("assignment_id")) +1;
								}	
								
								
						   //upload to aws bucket
//								App ob=new App();
								
							
								File ol=new File(text1);
									
									//original filename
									 String new1="";
									 String mynew="";
									
										for(int i=0;i<text1.length();i++) {
											if(String.valueOf(text1.charAt(i)).equals("\\")){
												new1= "";
								
											}
											else {
												new1 = new1 + String.valueOf(text1.charAt(i));
												
											}
												
										}
										
										//ne file name
										String new2="";
										String asid="asid";
										String pre="";
										
										//extract suffix of file
										for(int i=0;i<new1.length();i++) {
											if(String.valueOf(new1.charAt(i)).equals(".")){
												pre= "";
												
												
											}
											else {
												pre = pre + String.valueOf(new1.charAt(i));
											}
												
										}
										
										//new file name
										new2 = asid + String.valueOf(myassignid) + "." + pre;
										mynew = text1.substring(0,(text1.length()-new1.length()));
										
										//new completete path
										mynew = mynew+new2;


										
										File ne=new File(mynew);
										
										if(ol.renameTo(ne)) {
//upload into s3 bucket
											
//											String fileName = folderName + SUFFIX + new2;
//											s3client.putObject(new PutObjectRequest(bucketName, fileName, 
//													new File(mynew))
//													.withCannedAcl(CannedAccessControlList.PublicRead));
	
									}

						//complete logic	
				String sql1="insert into assignmentlist(CLASS_NAME,CLASS_CODE,ASSIGNMENT_NAME,DUE_DATE,FILE_LOCATION,LINKS) values('"+ class_name+"','"+  class_code +"','"+textField.getText()+"','"+textField_1.getText()+"','"+new2+"','"+link+"')";
				st.executeUpdate(sql1);
				
				if(ne.renameTo(ol)) {

					///again rename;
				}
				
				JOptionPane.showInternalMessageDialog(contentPane,"Successfully assignment uploaded!");
				contentPane.setVisible(false);
				list();
							}
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
	
	
	
	JButton btnNewButton_1;
	btnNewButton_1 = new JButton("View");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			try  
			{  
			File file = new File(lb.getText());   
			if(!Desktop.isDesktopSupported())                    //check if Desktop is supported by Platform or not  
			{  
				JOptionPane.showInternalMessageDialog(contentPane, "Not supported Format");
			 
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(file.exists())                                          //checks file exists or not  
			desktop.open(file);                                       //opens the specified file  
			}  
			catch(Exception e1)  
			{  
			//e1.printStackTrace();  
			}
		}
	});
	btnNewButton_1.setBounds(34, 347, 110, 21);
	contentPane.add(btnNewButton_1);
	

		
}

//it used to change the setting like theme of application
public void settings() {
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setBounds(100, 100, 383, 578);
	contentPane = new JPanel();
	contentPane.setForeground(Color.GRAY);
	
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
	
	rdbtnDarkMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnDarkMode.setBounds(20, 72, 115, 21);
	bg.add(rdbtnDarkMode);
	
	
	contentPane.add(rdbtnDarkMode);
	
	JRadioButton rdbtnNormalMode = new JRadioButton("Normal Mode");
	rdbtnNormalMode.setForeground(Color.LIGHT_GRAY);
	
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
	
	rdbtnAllow.setFont(new Font("Tahoma", Font.PLAIN, 14));
	rdbtnAllow.setBounds(20, 156, 105, 21);
	contentPane.add(rdbtnAllow);
	bg1.add(rdbtnAllow);
	
	JRadioButton rdbtnNotAllow = new JRadioButton("Not Allow");
	rdbtnNotAllow.setForeground(Color.LIGHT_GRAY);

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
	rdbtnDoYouWant.setForeground(Color.ORANGE);
	
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
	
	if(mode==1) {
		contentPane.setBackground(Color.DARK_GRAY);	
		rdbtnDarkMode.setBackground(Color.DARK_GRAY);
		rdbtnNormalMode.setBackground(Color.DARK_GRAY);
		rdbtnAllow.setBackground(Color.DARK_GRAY);
		rdbtnNotAllow.setBackground(Color.DARK_GRAY);
		rdbtnDoYouWant.setBackground(Color.DARK_GRAY);
	}
	else {
	contentPane.setBackground(new Color(0, 128, 128));
	rdbtnDarkMode.setBackground(new Color(0, 128, 128));
	rdbtnNormalMode.setBackground(new Color(0, 128, 128));
	rdbtnAllow.setBackground(new Color(0, 128, 128));
	rdbtnNotAllow.setBackground(new Color(0, 128, 128));
	rdbtnDoYouWant.setBackground(new Color(0, 128, 128));
	}
	
}


//it used by student or by teacher to delete the class
public void remove(String s) {
	try {
		if(s.contentEquals("Yes")) {
			String classcode=JOptionPane.showInternalInputDialog(contentPane, "Enter Code of Class");
			if(!classcode.contentEquals("")) {
				
				    int mycheck=0;					 
				    String sql1="select class_code from classinfo where email='"+getMyEmail()+"'";
				    
				    ResultSet rs1=st.executeQuery(sql1);
				    
				    while(rs1.next()) {
				    	if(rs1.getString(1).equals(classcode))
				    	   mycheck++;
				    }
				    if(mycheck>0) {
				    	String sql="delete from classinfo where class_code='"+classcode+"'";
						st.executeUpdate(sql);
						JOptionPane.showInternalMessageDialog(contentPane, "Class successfully deleted : " + classcode);
						list();	
				    }
				    else {
				    	JOptionPane.showInternalMessageDialog(contentPane, "Wrong class code");
				    }
				
			}
			else {
				JOptionPane.showInternalMessageDialog(contentPane, "class code cannot be empty");
			}
	
		}
		else {
			String classcode=JOptionPane.showInternalInputDialog(contentPane, "Enter Code of Class");
			if(!classcode.contentEquals("")) {
				 int mycheck=0;					 
				    String sql1="select class_code from classinfo where email='"+getMyEmail()+"'";
				    
				    ResultSet rs1=st.executeQuery(sql1);
				    while(rs1.next()) {
				    	if(rs1.getString(1).equals(classcode))
				    	mycheck++;
				    }
				    if(mycheck>0) {
				
			String sql="delete from classinfo where class_code='"+classcode+"' and email='"+getMyEmail()+"'";
			st.executeUpdate(sql);
			JOptionPane.showInternalMessageDialog(contentPane, "Class successfully deleted : " + classcode);
			list();
				    }
				    else {
				    	JOptionPane.showInternalMessageDialog(contentPane, "Wrong class code");
				    }
			}
			else {
				JOptionPane.showInternalMessageDialog(contentPane, "class code cannot be empty");
			}

		}
	}
	catch(Exception e){
		//System.out.println(e);
	}
}
}


