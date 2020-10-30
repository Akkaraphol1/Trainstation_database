import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainTable extends JFrame {
     
	JButton a[] = new JButton[10];
	JLabel imageLabel,imageLabel2;
	public JLabel img;

	private Image image = null;
	private Image image2 = null;
	
	public TrainTable(){
		
		getContentPane().setLayout(null);
		
		 ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/Pic.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(10, 10, 1480, 200);
	       imageLabel.setVisible(true);
	       getContentPane().add(imageLabel);	   
		
	       ImageIcon image2 = new ImageIcon("C:/Users/User/workspace/TrainStation/img/coulum.png");
	       JLabel imageLabel2 = new JLabel(image2); 
	       imageLabel2.setBounds(45, 240, 1400, 100);
	       imageLabel2.setVisible(true);
	       getContentPane().add(imageLabel2);
	         
	       
	       a[0] = new JButton("Back");
	       a[0].setBounds(640,830,200,100);
	       a[0].setFont(new Font("Tohama", Font.BOLD, 25));
	       getContentPane().add(a[0]); 
	       
	       a[1] = new JButton("Normal");
	       a[1].setBounds(340,830,200,100);
	       a[1].setFont(new Font("Tohama", Font.BOLD, 25));
	       getContentPane().add(a[1]); 
	       
	       a[2] = new JButton("Extraordinary");
	       a[2].setBounds(940,830,200,100);
	       a[2].setFont(new Font("Tohama", Font.BOLD, 25));
	       getContentPane().add(a[2]); 
	       
	       
	       a[0].addActionListener(new ButtonListener());
	       a[1].addActionListener(new ButtonListener());
	       a[2].addActionListener(new ButtonListener());
	       
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			
			String query = "SELECT * FROM train_table";

			PreparedStatement statement = ( PreparedStatement ) con.prepareStatement ( query );

			ResultSet resultSet = statement.executeQuery ( );

			//////x//
			JTable table = new JTable(); 

			Object[] columns = {"No","Serial_train","Type_train","Start","Destiny","Travel_Between","Price"};
			        DefaultTableModel listModel = new DefaultTableModel();
			       
			        listModel.setColumnIdentifiers(columns);
			        
			table.setModel(listModel);
			
			table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.blue);
	        Font font = new Font("Tohama", Font.BOLD, 15);
	        table.setFont(font);
	        table.setRowHeight(40);
	        table.setEnabled(false);
	        
			JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(50, 350, 1400, 450);

	        getContentPane().add(pane);
	        Object[] row = new Object[7];
	        
			resultSet.first ( );

			while ( ! resultSet.isAfterLast ( ) )
			{
				
                 
				String datatime = resultSet.getString ( "Number_Train" );
				
				String datatime1 = resultSet.getString ( "Serial_Train" );

                String datatime2 = resultSet.getString ( "Type_Train" );
				
				String datatime3 = resultSet.getString ( "Start" );

                String datatime4 = resultSet.getString ( "Destiny" );
                
                String datatime5 = resultSet.getString ( "Travel_Between" );

                String datatime6 = resultSet.getString ( "Price" );
                
				
                row[0] = datatime;
                row[1] = datatime1;
                row[2] = datatime2;
                row[3] = datatime3;
                row[4] = datatime4;		
                row[5] = datatime5;
                row[6] = datatime6;
                
                
                // add row to the model
                listModel.addRow(row);
			

				resultSet.next ( );
			}


			resultSet.close ( );

			con.close ( );
		}
		catch ( ClassNotFoundException error )
		{

		} 
		catch ( SQLException error ) 
		{

		}
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrainTable a = new TrainTable();
		a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		a.setVisible(true);
		a.setSize(1520,1000);
		a.setLocation(300,10);

	}
	  
    public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == a[0])
			{
			 Trainthree T = new Trainthree("Welcome to Trainstaion");
		   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   T.setSize(1520,1000);
		   T.setVisible(true);
		   T.setLocation(300, 10);
			}
			
			if (e.getSource() == a[2])
			{
				TrainStation2 TS3 = new TrainStation2();
				TS3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				TS3.setVisible(true);
				TS3.setSize(1900,1000);
				TS3.setLocation(10,10);
				TS3.setResizable(true);
			
			}
			
			if (e.getSource() == a[1])
			{
				TrainStation1 TS = new TrainStation1();
				TS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				TS.setVisible(true);
				TS.setSize(1900,1000);
				TS.setLocation(10,10);
				TS.setResizable(true);
			}
			
		}
    }
    }
