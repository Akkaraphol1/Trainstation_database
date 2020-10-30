import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPasswordField;

public class register_1 extends JFrame {

	private static final String Boolean = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField FN,LN,Gen,Age,Tel,Time;

	private JPasswordField PS;
	private JPasswordField PS2;
	JLabel imageLabel,imageLabel2;
	public JLabel img;

	private JButton[] BB = new JButton[20];
	
	private Image image = null;
	private Image image2 = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register_1 f5 = new register_1("Register");
					f5.setVisible(true);
					f5.setLocation(300, 100);
					f5.setSize(1500, 900);
					f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void paint(Graphics g){
	     super.paint(g);
	     g.setColor(Color.blue);
	     g.drawRect(60, 160, 600, 700); 
	     g.setColor(Color.black);
	     g.drawRect(65, 165, 590, 690); 
	     g.setColor(Color.red);
	     g.drawRect(75, 760, 520, 80); 
	     g.setColor(Color.red);
	     g.drawRect(55, 50, 1410, 815); 
	     
	}
	
	
	/**
	 * Create the frame.
	 */
	public register_1(String filename) {
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		 ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/Traun.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(650, 120, 800, 700);
	       imageLabel.setVisible(true);
	       contentPane.add(imageLabel);	   
		
	       ImageIcon image2 = new ImageIcon("C:/Users/User/workspace/TrainStation/img/PPP.png");
	       JLabel imageLabel2 = new JLabel(image2); 
	       imageLabel2.setBounds(50, 15, 1400, 100);
	       imageLabel2.setVisible(true);
	       contentPane.add(imageLabel2);	   
	       
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegister.setBounds(247, 116, 220, 81);
		contentPane.add(lblRegister);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblFirstName.setBounds(83, 195, 179, 50);
		contentPane.add(lblFirstName);

		FN = new JTextField();
		FN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		FN.setBounds(377, 200, 200, 45);
		contentPane.add(FN);
		FN.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblLastName.setBounds(83, 255, 173, 45);
		contentPane.add(lblLastName);

		LN = new JTextField();
		LN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		LN.setColumns(10);
		LN.setBounds(377, 260, 200, 45);
		contentPane.add(LN);

		//setting from time in window 
	       JLabel currentTime = new JLabel("Current Time : ");
	       currentTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	   	 currentTime.setBounds(83, 615, 287, 50);
	   	 contentPane.add(currentTime);
	   	 
	   	Time = new JTextField();
	   	Time.setFont(new Font("Tohama",Font.BOLD,20));
	    Time.setEditable(false);
	   	Time.setBounds(377, 620, 200, 45);
	   	contentPane.add(Time);
	 
	   	 Calendar c = Calendar.getInstance();
	   	 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	   	String currentDate = df.format(c.getTime());
	   	Time.setText(currentDate);
	
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblPassword.setBounds(83, 315, 179, 50);
		contentPane.add(lblPassword);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					PreparedStatement ps; // = con.prepareStatement("insert into
											// user(user_id,user_Last,user_password,user_password2)
											// values(?,?,?,?);");
					String query = "INSERT INTO `register_1`(`Date`,`First Name`, `Last Name`, `Password`, `Confirm Password`, `Gender`, `Age`, `Telephone`) VALUES (?,?,?,?,?,?,?,?)";
					ps = con.prepareStatement(query);

					
					String currentDate = Time.getText();
					ps.setString(1, Time.getText());
				  	int TT = currentDate.length();
				  	
				  	
					String name = FN.getText();
					ps.setString(2, FN.getText());
					int m1 = name.length();

					String last = LN.getText();
					ps.setString(3, LN.getText());
					int m2 = last.length();

					String pass = String.valueOf(PS.getPassword());
					ps.setString(4, PS.getText());
					int m3 = pass.length();

					String pass2 = String.valueOf(PS2.getPassword());
					ps.setString(5, PS2.getText());
					int m4 = pass2.length();

	                 ////gen
					String gen1 = Gen.getText();
					ps.setString(6, Gen.getText());
					int m5 = gen1.length();

					String age2 = Age.getText();
					ps.setString(7, Age.getText());
					int m6 = age2.length();

					String Tele = Tel.getText();
					ps.setString(8, Tel.getText());
					int m7 = Tele.length();
					
					
					ps.setString(1, currentDate);
					ps.setString(2, name);
					ps.setString(3, last);
					ps.setString(4, pass);
					ps.setString(5, pass2);
					ps.setString(6, gen1);
					ps.setString(7, age2);
					ps.setString(8, Tele);
					

					
					if(TT <= 7)
					{
						JOptionPane.showMessageDialog(null,
								"Please Input Time");
						Time.requestFocus();
						return;
						
					}
					// ResultSet rs = ps.executeQuery();
					if (m1 <= 3) // First Name
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (First Name)\n First Name must more than four number.");
						FN.requestFocus();
						return;
					}

					if (m2 < 1) // Last Name
					{
						JOptionPane.showMessageDialog(null, "Please Input (Last Name)");
						LN.requestFocusInWindow();
						return;
					}

					if (m3 <= 3) // Password
					{
						JOptionPane.showMessageDialog(null,
								"Please Input Password \n Password must more than four number.");
						PS.requestFocusInWindow();
						return;
					} else if (m4 <= 3) // Confirm Password
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (Confirm Password)\n Confirmpassword must equal to password.");
						PS2.requestFocusInWindow();
						return;
					}

					if (!pass.equals(pass2)) // Password math
					{
						JOptionPane.showMessageDialog(null, "Please Input (Password Not Match!)");
						PS.requestFocusInWindow();
						return;
					}
					
					if (m5 <= 1) // Gender
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (Gender)\n Male or Female");
						Gen.requestFocus();
						return;
					}

					if (m6 <= 0) // Age
					{
						JOptionPane.showMessageDialog(null, "Please Input (Age)");
						Age.requestFocusInWindow();
						return;
					}

					if (m7 <= 9 || m7 >= 11) // telephone
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (number phone) You must have a only ten digits!!!  ");
						Tel.requestFocusInWindow();
						return;
					}

					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Registration done successfully....");
						login frame = new login("Login");
						frame.setVisible(true);
						frame.setSize(800, 690);
				        frame.setVisible(true);
	                    frame.setLocation(960, 270);
	                    frame.setResizable(false);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} else {
						System.out.println("Registration Failed...");
					}
				} catch (Exception ex) {
					Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);

				}
				

			}
		});
		btnNewButton.setBounds(80, 733, 150, 57);
		contentPane.add(btnNewButton);
		
		BB[0] = new JButton("Login");
		BB[0].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		BB[0].setBounds(420, 733, 150, 57);
	
		BB[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == BB[0])
				{
					login frame = new login("Login");
					frame.setVisible(true);
					frame.setSize(800, 690);
			        frame.setVisible(true);
                    frame.setLocation(960, 270);
                    frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}

			
		}
		});
		contentPane.add(BB[0]);		

		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblConfirmPassword.setBounds(83, 375,287, 50);
		contentPane.add(lblConfirmPassword);

		PS = new JPasswordField();
		PS.setBounds(377, 320, 200, 45);
		PS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		PS.setColumns(10);
		contentPane.add(PS);

		PS2 = new JPasswordField();
		PS2.setBounds(377, 380, 200, 45);
		PS2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		PS2.setColumns(10);
		contentPane.add(PS2);
		
		//Gender
		JLabel lblG = new JLabel("Gender");
		lblG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblG.setBounds(83, 435, 287, 50);
		contentPane.add(lblG);

		Gen = new JTextField();
		Gen.setBounds(377, 440, 200, 45);
		Gen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		Gen.setColumns(10);
		contentPane.add(Gen);
		
		//Age
				JLabel A = new JLabel("Age");
				A.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
				A.setBounds(83, 495, 287, 50);
				contentPane.add(A);

				Age = new JTextField();
				Age.setBounds(377, 500, 200, 45);
				Age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
				Age.setColumns(10);
				contentPane.add(Age);
				
				//Telephone
				JLabel Te = new JLabel("Telephone");
				Te.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
				Te.setBounds(83, 555, 287, 50);
				contentPane.add(Te);

				Tel = new JTextField();
				Tel.setBounds(377, 560, 200, 45);
				Tel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
				Tel.setColumns(10);
				contentPane.add(Tel);
				
				
				
	}
}
