
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class History_Sell extends JFrame{

	 private static JTable table = new JTable();
	    private 	JScrollPane pane = new JScrollPane();
	    private JButton Add2 = new JButton();
		private JButton Refresh;
		private JButton send ;
		private JButton TTT ;
		private JButton[] n = new JButton[5];
		private JButton SaveData = new JButton();
		private JButton[] B = new JButton[4];
		JLabel imageLabel,imageLabel2;
		public JLabel img;

		private Image image = null;
		private Image image2 = null;
		
	public History_Sell(String File){
		
		getContentPane().setLayout(null);
		// Go
		B[2] = new JButton("Back");
		B[2].setBounds(900,800,200,100);
		B[2].setFont(new Font("Tahoma", Font.BOLD, 25));
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
		
		 ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/Hist.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(60, 40, 1400, 200);
	       imageLabel.setVisible(true);
	       getContentPane().add(imageLabel);	   

		table = new JTable();
		  table.setBackground(Color.WHITE);
	        table.setForeground(Color.black);
	        Font font = new Font("Tohama",Font.BOLD,15);
	        table.setFont(font);
	        table.setRowHeight(40);
		
		JScrollPane pane = new JScrollPane(table);
        pane.setBounds(60, 250, 1400, 500);
        
        getContentPane().add(pane);
		
		pane.setViewportView(table);
		
		//Delete
		B[1] = new JButton("Delete");
		B[1].setBounds(300,800,200,100);
		B[1].setFont(new Font("Tahoma", Font.BOLD, 25));
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
					case 11:
						return String.class;
					case 12:
						return String.class;
					case 13:
						return String.class;
					case 14:
						return String.class;
					case 15:
						return String.class;
					
					
					default:
						return String.class;
					}
				}
			};
			table.setModel(model);

// Add Column
model.addColumn("Select");
model.addColumn("PS_Sell_T2");
model.addColumn("PS_Data_sell");
model.addColumn("TIC_PS");
model.addColumn("PS_Staff");
model.addColumn("PS_Mem");
model.addColumn("Train_Num");
model.addColumn("Start");
model.addColumn("Destiny");
model.addColumn("Time_Out");
model.addColumn("Time_Arrival");
model.addColumn("Discount");
model.addColumn("Price_Ticket");
model.addColumn("Ticket_State");
model.addColumn("Date");


Connection connect = null;
Statement s = null;

try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	connect = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
			"root", "");
	

	s = connect.createStatement();

	String sql = "SELECT * FROM  data_sell_t2 ORDER BY PS_Sell_T2 ASC";

	ResultSet rec = s.executeQuery(sql);
	int row = 0;
	while ((rec != null) && (rec.next())) {
		model.addRow(new Object[0]);
		model.setValueAt(false, row, 0); // Checkbox
		model.setValueAt(rec.getString("PS_Sell_T2"), row, 1);
		model.setValueAt(rec.getString("PS_Data_sell"), row, 2);
		model.setValueAt(rec.getString("TIC_PS"), row, 3);
		model.setValueAt(rec.getString("PS_Staff"), row, 4);
		model.setValueAt(rec.getString("PS_Mem"), row, 5);
		model.setValueAt(rec.getString("Train_Num"), row, 6);
		model.setValueAt(rec.getString("Start"), row, 7);
		model.setValueAt(rec.getString("Destiny"), row, 8);
		model.setValueAt(rec.getString("Time_Out"), row, 9);
		model.setValueAt(rec.getString("Time_Arrival"), row, 10);
		model.setValueAt(rec.getString("Discount"), row, 11);
		model.setValueAt(rec.getDouble("Price_Ticket"), row, 12);
		model.setValueAt(rec.getString("Ticket_State"), row, 13);
		model.setValueAt(rec.getString("Date"), row, 14);
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

	String sql = "DELETE FROM data_sell_t2  WHERE " + "PS_Sell_T2 = '"
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
		History_Sell HS = new History_Sell("History buy a Ticket");
		HS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		HS.setSize(1520, 1000);
		HS.setVisible(true);
		HS.setLocation(300,10);

	}
	
}

