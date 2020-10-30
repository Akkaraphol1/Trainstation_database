import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Trainthree extends JFrame{
	
private JButton[] n = new JButton[6];
private JLabel[] L = new JLabel[5];
 
JLabel imageLabel;
public JLabel img;

private Image image = null;

public Trainthree(String filename){
	
	getContentPane().setLayout(null);

	
    n[0] = new JButton("Normal");
    n[0].setBounds(50,800,200,100);
    n[0].setFont(new Font("Tohama", Font.BOLD, 25));
    getContentPane().add(n[0]);

    n[1] = new JButton("Extraordinary");
    n[1].setBounds(1200,800,200,100);
    n[1].setFont(new Font("Tohama", Font.BOLD, 25));
    getContentPane().add(n[1]);

    n[2] = new JButton("Contact");
    n[2].setBounds(280,800,200,100);
    n[2].setFont(new Font("Tohama", Font.BOLD, 25));
    getContentPane().add(n[2]);
    
    n[3] = new JButton("Table time");
    n[3].setBounds(510,800,200,100);
    n[3].setFont(new Font("Tohama", Font.BOLD, 25));
    getContentPane().add(n[3]); 
    
    n[4] = new JButton("Member");
    n[4].setBounds(740,800,200,100);
    n[4].setFont(new Font("Tohama", Font.BOLD, 25));
    getContentPane().add(n[4]);
   
    n[5] = new JButton("History_Sell");
    n[5].setBounds(970,800,200,100);
    n[5].setFont(new Font("Tohama", Font.BOLD, 25));
    getContentPane().add(n[5]);

       ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/trainnee.png");
       JLabel imageLabel = new JLabel(image); 
       imageLabel.setBounds(100, 60, 1280, 720);
       imageLabel.setVisible(true);
       getContentPane().add(imageLabel);	   
	   
       


n[0].addActionListener(new ButtonListener());
n[1].addActionListener(new ButtonListener());
n[2].addActionListener(new ButtonListener());
n[3].addActionListener(new ButtonListener());
n[4].addActionListener(new ButtonListener());
n[5].addActionListener(new ButtonListener());
}
	
public static void main(String[] args){
	   
	   Trainthree T = new Trainthree("Welcome to Trainstaion");
	   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   T.setSize(1520,1000);
	   T.setVisible(true);
	   T.setLocation(300, 10);
	 
	   
	}	
	
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == n[0])
			{
				TrainStation1 TS = new TrainStation1();
				TS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				TS.setVisible(true);
				TS.setSize(1900,1000);
				TS.setLocation(10,10);
				TS.setResizable(true);
			}
			if (e.getSource() == n[1])
			{
				TrainStation2 TS3 = new TrainStation2();
				TS3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				TS3.setVisible(true);
				TS3.setSize(1900,1000);
				TS3.setLocation(10,10);
				TS3.setResizable(true);
				   
			}
			if (e.getSource() == n[4])
			{
				 Data_Member M = new Data_Member("Member");
			        M.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        M.setVisible(true);
			        M.setSize(1900,1000);
			 	   M.setLocation(10, 10);
			}
			if (e.getSource() == n[3])
			{
				TrainTable a = new TrainTable();
				a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				a.setVisible(true);
				a.setSize(1520,1000);
				a.setLocation(300,10);
			}	
			if (e.getSource() == n[2])
			{
				  Contact C = new Contact("Contact");
				     C.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				     C.setSize(1520,1000);
				     C.setVisible(true);
				     C.setLocation(300,10);
				     
			}	
			if (e.getSource() == n[5])
			{
				History_Sell HS = new History_Sell("History buy a Ticket");
				HS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				HS.setSize(1520, 1000);
				HS.setVisible(true);
				HS.setLocation(300,10);

			}	
		}

	}

}
