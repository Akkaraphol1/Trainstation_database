import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.StatementImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField FN;
	private JPasswordField PS;
	protected Statement MyConnection;
	private JButton B = new JButton();
	
	JLabel imageLabel,imageLabel2;
	public JLabel img;

	
	private Image image = null;
	private Image image2 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login("Login");
					frame.setVisible(true);
					frame.setSize(800, 690);
			        frame.setVisible(true);
                    frame.setLocation(960, 270);
                    frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void paint(Graphics g){
	     super.paint(g);

	     g.setColor(Color.blue);
	     g.drawRect(30, 115, 745, 500); 
	     
	}
	

	/**
	 * Create the frame.
	 */
	public login(String file) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		 ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/LOG1.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(35, 90, 730, 100);
	       imageLabel.setVisible(true);
	       contentPane.add(imageLabel);	   
		
	       
		JLabel lblUsername = new JLabel("username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblUsername.setBounds(126, 240, 237, 79);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblPassword.setBounds(126, 350, 237, 56);
		contentPane.add(lblPassword);

		JButton btnNewButton = new JButton("sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register_1 f5 = new register_1("Register");
				f5.setVisible(true);
				f5.setLocation(300, 100);
				f5.setSize(1500, 900);
				f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(80, 480, 150, 70);
		contentPane.add(btnNewButton);

		FN = new JTextField();
		FN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		FN.setBounds(394, 250, 218, 67);
		contentPane.add(FN);
		FN.setColumns(10);

		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				register_1 f5 = new register_1("Register");
				String query = "SELECT * FROM `register_1` WHERE `First Name` =? and `Confirm Password` =? ";
				try {

					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					PreparedStatement ps;

					String name = FN.getText();
					int m1 = name.length();
					String pass = String.valueOf(PS.getPassword());

					if (m1 <= 3) // Name
					{
						JOptionPane.showMessageDialog(null,
								"Sorry, Name incorrect. \n Please to try again!!! ");
						FN.requestFocusInWindow();
						return;
					}

					if (pass.equals("")) // Password
					{
						JOptionPane.showMessageDialog(null,
								"Sorry, Password incorrect\n Please to try again!!! ");
						PS.requestFocusInWindow();
						return;
					}
					
	
					
					ps = con.prepareStatement(query);
					ps.setString(1, name);
					ps.setString(2, pass);
					ResultSet rs = ps.executeQuery();
					int i = 0;

					while (rs.next()) {

						i++;
					}
					if (i == 1) {
						System.out.println("Registration done successfully....");
						 Trainthree T = new Trainthree("Welcome to Trainstaion");
						   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						   T.setSize(1500,1000);
						   T.setVisible(true);
						   T.setLocation(300, 10);
					}

					else {
						System.out.println("Registration Failed because you don't have a register....");
					}

				} catch (Exception ex) {
					Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
				}

      			}

		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnLogin.setBounds(320, 480, 150, 70);
		contentPane.add(btnLogin);


		
			B = new JButton("Forget");
			B.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
			B.setBounds(570, 480, 150, 70);
		
			B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (e.getSource() == B)
					{
						Forget FG = new Forget();
				         FG.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							FG.setVisible(true);
							FG.setSize(800, 690);
					        FG.setVisible(true);
			                FG.setLocation(960, 270);
			                FG.setResizable(false);
				         
						 	
					}

				
			}
			});
			getContentPane().add(B);		
		
		PS = new JPasswordField();
		PS.setBounds(394, 350, 218, 67);
		contentPane.add(PS);
	}

}
