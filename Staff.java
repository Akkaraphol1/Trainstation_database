import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Staff extends JFrame {

	private static JTextField[] T = new JTextField[10];
	private JLabel[] L = new JLabel[10];
	private JButton[] B = new JButton[4];
	private Object[] columns = {"PS_Staff","First Name", "Last Name", "Location", "Gender", "Telephone"};
    private DefaultTableModel listModel = new DefaultTableModel();
    private static JTable table = new JTable();
    private 	JScrollPane pane = new JScrollPane();
    
	public Staff(String sStaff)
	{
		getContentPane().setLayout(null);
		
		//FN
		L[0] = new JLabel("First Name");
		L[0].setBounds(50,200,200,50);
		L[0].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(L[0]);
		
		T[0] = new JTextField();
		T[0].setBounds(170,200,150,50);
		T[0].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(T[0]);
		
		//LN
		L[1] = new JLabel("Last Name");
		L[1].setBounds(350,200,200,50);
		L[1].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(L[1]);
				
		T[1] = new JTextField();
		T[1].setBounds(470,200,150,50);
		T[1].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(T[1]);
		
		//Location
		L[2] = new JLabel("Location");
		L[2].setBounds(650,200,200,50);
		L[2].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(L[2]);
				
		T[2] = new JTextField();
		T[2].setBounds(770,200,150,50);
		T[2].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(T[2]);
		
		//Gender
		L[3] = new JLabel("Gender");
		L[3].setBounds(950,200,200,50);
		L[3].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(L[3]);
						
		T[3] = new JTextField();
		T[3].setBounds(1070,200,150,50);
		T[3].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(T[3]);
		
		//Telephone
		L[4] = new JLabel("Telephone");
		L[4].setBounds(1250,200,200,50);
		L[4].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(L[4]);
						
		T[4] = new JTextField();
		T[4].setBounds(1370,200,150,50);
		T[4].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(T[4]);
		
		//Password_Staff
				L[5] = new JLabel("CodeStaff");
				L[5].setBounds(1550,200,200,50);
				L[5].setFont(new Font("Tahoma", Font.BOLD, 20));
				getContentPane().add(L[5]);
		
		T[5] = new JTextField();
		T[5].setBounds(1670,200,150,50);
		T[5].setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(T[5]);
	
	
		// Go
				B[2] = new JButton("Go");
				B[2].setBounds(1200,800,100,50);
				B[2].setFont(new Font("Tahoma", Font.BOLD, 20));
				B[2].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						 Trainthree T = new Trainthree("Welcome to Trainstaion");
						   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						   T.setSize(1520,1000);
						   T.setVisible(true);
						   T.setLocation(300, 10);
						 

					}
				});

				getContentPane().add(B[2]);
				
		
		// ADD
		B[0] = new JButton("Add");
		B[0].setBounds(900,800,100,50);
		B[0].setFont(new Font("Tahoma", Font.BOLD, 20));
		B[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					PreparedStatement ps; // = con.prepareStatement("insert into
											// user(user_id,user_Last,user_password,user_password2)
											// values(?,?,?,?);");
					String query = "INSERT INTO `staff`(`PS_Staff`,`First Name`, `Last Name`, `Location`, `Gender`, `Telephone`) VALUES (?,?,?,?,?,?)";
					ps = con.prepareStatement(query);

				  	
					String PS_S = T[5].getText();
					ps.setString(1, T[5].getText());
					int m1 = PS_S.length();

					String name = T[0].getText();
					ps.setString(2, T[0].getText());
					int m2 = name.length();
					
					String last = T[1].getText();
					ps.setString(3, T[1].getText());
					int m3 = last.length();

					String LC = T[2].getText();
					ps.setString(4, T[2].getText());
					int m4 = last.length();
	                 ////gen
					String gen1 = T[3].getText();
					ps.setString(5, T[3].getText());
					int m5 = gen1.length();

					String Tel = T[4].getText();
					ps.setString(6, T[4].getText());
					int m6 = Tel.length();

				
					ps.setString(1, PS_S);
					ps.setString(2, name);
					ps.setString(3, last);
					ps.setString(4, LC);
					ps.setString(5, gen1);
					ps.setString(6, Tel);
			
					
					if(m1 <= 4)
					{
						JOptionPane.showMessageDialog(null,
								"Please Input new Password for protect!!!");
						T[5].requestFocus();
						return;
						
					}
					// ResultSet rs = ps.executeQuery();
					if (m2 <= 3) // First Name
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (First Name)\n First Name must more than four number.");
						T[0].requestFocus();
						return;
					}

					if (m3 < 1) // Last Name
					{
						JOptionPane.showMessageDialog(null, "Please Input (Last Name)");
						T[1].requestFocusInWindow();
						return;
					}

				
					if (LC.equals("")) // Location
					{
						JOptionPane.showMessageDialog(null, "Please Input (Password Not Match!)");
						T[2].requestFocusInWindow();
						return;
					}
					
					if (m5 <= 1) // Gender
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (Gender)\n Male or Female");
						T[3].requestFocus();
						return;
					}


					if (m6 <= 9 || m6 >= 11) // telephone
					{
						JOptionPane.showMessageDialog(null,
								"Please Input (number phone) You must have a only ten digits!!!  ");
						T[4].requestFocusInWindow();
						return;
					}

					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Registration done successfully....");
						
					} else {
						System.out.println("Registration Failed...");
					}
				} catch (Exception ex) {
					Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);

				}
				

			}
		});

		getContentPane().add(B[0]);
		
		B[3] = new JButton("Staff");
		B[3].setBounds(1500,800,100,50);
		B[3].setFont(new Font("Tahoma", Font.BOLD, 20));
		B[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    TrainSS1 T = new TrainSS1();
		        T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        T.setVisible(true);
		        T.setSize(1910,1000);
		        T.setLocation(10,10);
			}
		});

		getContentPane().add(B[3]);

		table = new JTable();
		  table.setBackground(Color.WHITE);
	        table.setForeground(Color.black);
	        Font font = new Font("Tohama",Font.BOLD,15);
	        table.setFont(font);
	        table.setRowHeight(40);
		
		JScrollPane pane = new JScrollPane(table);
        pane.setBounds(250, 300, 1400, 450);
        
        getContentPane().add(pane);
		
		pane.setViewportView(table);
		
		//Delete
		B[1] = new JButton("Delete");
		B[1].setBounds(600,800,100,50);
		B[1].setFont(new Font("Tahoma", Font.BOLD, 20));
		B[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] options = { "Yes", "No" };
				int n = JOptionPane
						.showOptionDialog(null, "Do you want to Delete data?",
								"Confirm to Delete?",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[1]);
				if (n == 0) // Confirm Delete = Yes
				{

					for (int i = 0; i < table.getRowCount(); i++) {
						Boolean chkDel = Boolean.valueOf(table.getValueAt(i, 0).toString()); // Checked
						if(chkDel) // Checked to Delete
						{
							String strDate= table.getValueAt(i, 1)
									.toString(); // get CustomerID
							
							DeleteData(strDate); // Delete Data
						}
					}
					
					JOptionPane.showMessageDialog(null, "Delete Data Successfully");

					PopulateData(); // Reload Table
				}

			}
		});

		getContentPane().add(B[1]);

		PopulateData();
	}
	
	


private static void PopulateData() {
	// Clear table
			table.setModel(new DefaultTableModel());

			// Model for Table
			DefaultTableModel model = new DefaultTableModel() {

				public Class<?> getColumnClass(int column) {
					switch (column) {
					case 0:
						return Boolean.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					case 5:
						return String.class;
					case 6:
						return String.class;
					case 7:
						return String.class;
					case 8:
						return String.class;
					case 9:
						return String.class;
					case 10:
						return String.class;
				
					default:
						return String.class;
					}
				}
			};
			table.setModel(model);

// Add Column
model.addColumn("Select");
model.addColumn("PS_Staff");
model.addColumn("First Name");
model.addColumn("Last Name");
model.addColumn("Location");
model.addColumn("Gender");
model.addColumn("Telephone");

Connection connect = null;
Statement s = null;

try {


	Class.forName("com.mysql.cj.jdbc.Driver");
	connect = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			"root", "");
	

	s = connect.createStatement();

	String sql = "SELECT * FROM  staff ORDER BY PS_Staff ASC";

	ResultSet rec = s.executeQuery(sql);
	int row = 0;
	while ((rec != null) && (rec.next())) {
		model.addRow(new Object[0]);
		model.setValueAt(false, row, 0); // Checkbox
		model.setValueAt(rec.getString("PS_Staff"), row, 1);
		model.setValueAt(rec.getString("First Name"), row, 2);
		model.setValueAt(rec.getString("Last Name"), row, 3);
		model.setValueAt(rec.getString("Location"), row, 4);
		model.setValueAt(rec.getString("Gender"), row, 5);
		model.setValueAt(rec.getString("Telephone"), row, 6);
	
		row++;
	}

} catch (Exception e) {
	// TODO Auto-generated catch block
	JOptionPane.showMessageDialog(null, e.getMessage());
	e.printStackTrace();
}

try {
	if (s != null) {
		s.close();
		connect.close();
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}



// Delete
private void DeleteData(String strDate) {

Connection connect = null;
Statement s = null;

try {

	Class.forName("com.mysql.cj.jdbc.Driver");
	connect = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			"root", "");
	
	s = connect.createStatement();

	String sql = "DELETE FROM staff  WHERE " + "PS_Staff = '"
			+ strDate + "' ";
	s.execute(sql);

} catch (Exception e) {
	// TODO Auto-generated catch block
	JOptionPane.showMessageDialog(null, e.getMessage());
	e.printStackTrace();
}

try {
	if (s != null) {
		s.close();
		connect.close();
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	e.printStackTrace();
}
		getContentPane().add(B[1]);
			
}

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				 Staff S = new Staff("Staff");
			        S.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        S.setVisible(true);
			        S.setSize(1900,1000);
			 	   S.setLocation(10, 10);
			}
		});
	}
}
