import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Contact extends JFrame{

	private JButton B;
	private JLabel L;
	
	JLabel imageLabel,imageLabel2;
	public JLabel img;
	
	private Image image = null;
	private Image image2 = null;
	

	public Contact(String File){
		
		getContentPane().setLayout(null);
		
		 ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/CT.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(100, 60, 1280, 720);
	       imageLabel.setVisible(true);
	       getContentPane().add(imageLabel);	
	       
	       
	       B = new JButton("Back");
	       B.setBounds(640,800,200,100);
	       B.setFont(new Font("Tohama", Font.BOLD, 25));
	       B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 Trainthree T = new Trainthree("Welcome to Trainstaion");
					   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					   T.setSize(1520,1000);
					   T.setVisible(true);
					   T.setLocation(300, 10);
					 
				}
			});

	       getContentPane().add(B); 
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Contact C = new Contact("Contact");
     C.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     C.setSize(1520,1000);
     C.setVisible(true);
     C.setLocation(300,10);
     
	}

}
