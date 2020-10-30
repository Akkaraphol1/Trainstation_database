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
public class Forget extends JFrame {
   
	private JButton B = new JButton();
	private JButton B2 = new JButton();
	//private JButton B3 = new JButton();
	private static JButton B3;
	private JLabel[]  L = new JLabel[2];
	private JTextField A = new JTextField(); 
	private JTextField A2 = new JTextField(); 
	
	JLabel imageLabel,imageLabel2;
	public JLabel img;

	private Image image = null;
	private Image image2 = null;
	
	public Forget(){
		
		getContentPane().setLayout(null);

		 ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/FGT.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(100, 50, 600, 100);
	       imageLabel.setVisible(true);
	       getContentPane().add(imageLabel);	   
		
	       
	    // Username   
		L[0] = new JLabel("Username :");
		L[0].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		L[0].setBounds(150, 225, 250, 67);
		getContentPane().add(L[0]);
		
		A = new JTextField();
		A.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		A.setBounds(440, 230, 218, 67);
		getContentPane().add(A);
		
	    // Telephone
		L[1] = new JLabel("Telephone :");
		L[1].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		L[1].setBounds(150, 345, 250, 67);
		getContentPane().add(L[1]);
		
		A2 = new JTextField();
		A2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		A2.setBounds(440, 350, 218, 67);
		getContentPane().add(A2);
		
		B = new JButton("Accept");
		B.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				register_1 f5 = new register_1("Register");
				String query = "SELECT * FROM `register_1` WHERE `First Name` =? and `Telephone` =? ";
				try {

					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					PreparedStatement ps;

					
					String name = A.getText();
					String Tele = A2.getText();
				
					int m1 = name.length();
					int m2 = Tele.length();

					ps = con.prepareStatement(query);
					ps.setString(1, name);
					ps.setString(2, Tele);
					ResultSet rs = ps.executeQuery();
					
					if (m1 <= 3) // Name
					{
						JOptionPane.showMessageDialog(null,
								"Sorry, Name incorrect. \n Please to try again!!! ");
						A.requestFocusInWindow();
						return;
					}

					if (Tele.equals("")) // telephone
					{
						JOptionPane.showMessageDialog(null,
								"Sorry, You don't have a data in train register. ");
						A2.requestFocusInWindow();
						return;
					}
					
	
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
						System.out.println("Server Failed because name or telephone incorrect ....");
					}

				} catch (Exception ex) {
					Logger.getLogger(Forget.class.getName()).log(Level.SEVERE, null, ex);
				}

			}

		});
		
		B.setBounds(200, 460, 150, 70);
		getContentPane().add(B);
		
		B3 = new JButton("Decline");
		B3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		B3.setBounds(460, 460, 150, 70);
		getContentPane().add(B3);
		
		
	}
	
	public void paint(Graphics g){
	     super.paint(g);
	     g.setColor(Color.blue);
	     g.drawRect(100, 80, 620, 500); 
	    
	     
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Forget FG = new Forget();
	         FG.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				FG.setVisible(true);
				FG.setSize(800, 690);
		        FG.setVisible(true);
                FG.setLocation(960, 270);
                FG.setResizable(false);
	         
	         B3.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent arg0) {
	 				 int result = JOptionPane.showConfirmDialog(FG,
	 				            "Do you want to Exit ?", "Exit Confirmation : ",
	 				            JOptionPane.YES_NO_OPTION);
	 				        if (result == JOptionPane.YES_OPTION)
	 				          FG.setVisible(false);
	 				        else if (result == JOptionPane.NO_OPTION)
	 				          FG.setVisible(true);
	 				      }
	 			
	 		});
	}
	 
	
			
}

