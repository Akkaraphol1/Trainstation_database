import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TrainSS1 extends JFrame {

	private JTextField[] TF = new JTextField[10];
	private JTextField[] TT = new JTextField[13];
	private JTextField[] MC = new JTextField[2];
	private JLabel[] LB = new JLabel[13];
	
    private JButton n2 = new JButton();
    private JButton n3 = new JButton();
    private JButton Add2 = new JButton();
    private JButton Refresh = new JButton();
    private JButton Send = new JButton();
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    private JButton SaveData = new JButton();
    
	private String TK2;
	String timeaog;
	String timetung;
	
	
	  private static JTable table = new JTable(); 
	  
		private JLabel LB1[] = new JLabel[12]; 
		JLabel imageLabel,imageLabel2;
		public JLabel img;

		private JButton send ;
		private JButton TTT ;
		private JButton[] n = new JButton[5];
		private Image image = null;
		private Image image2 = null;
		
		  private String[] columnNames = 
		        {"First Name", "Last Name","Start","Destiny","Ticket Price","Time Out","Arrival Time","Train","Seat No.","Status","Date/Month/Year"};
		
		  
		    private Object[][] data;
		     
		    private JButton jbtAddRow = new JButton("Add new row");
		    private JButton jbtSave = new JButton("Save Table");
		    private JButton jbtLoad = new JButton("Load Table");
		         
		    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
		    private JTable myJTable = new JTable(tableModel);
		   
		   
		     
		    private JFileChooser myJFileChooser = new JFileChooser(new File("."));
		     
		    private void saveTable() {
		        if (myJFileChooser.showSaveDialog(this) ==
		                JFileChooser.APPROVE_OPTION ) {
		            saveTable(myJFileChooser.getSelectedFile());
		        }
		    }
		     
		    private void saveTable(File file) {
		        try {
		            ObjectOutputStream out = new ObjectOutputStream(
		                    new FileOutputStream(file));
		                out.writeObject(tableModel.getDataVector());
		                out.writeObject(getColumnNames());
		                out.close();
		            }
		            catch (Exception ex) {
		                ex.printStackTrace();
		            }
		    }
		     
		    private Vector<String> getColumnNames() {
		        Vector<String> columnNames = new Vector<String>();
		        for (int i = 0; i < myJTable.getColumnCount(); i++)
		            columnNames.add(myJTable.getColumnName(i) );
		            return columnNames;
		    }
		     
		    private void loadTable() {
		        if (myJFileChooser.showOpenDialog(this) ==
		                JFileChooser.APPROVE_OPTION )
		            loadTable(myJFileChooser.getSelectedFile());
		    }
		     
		    private void loadTable(File file) {
		        try {
		            ObjectInputStream in = new ObjectInputStream(
		            new FileInputStream(file));
		            Vector rowData = (Vector)in.readObject();
		            Vector columnNames = (Vector)in.readObject();
		            tableModel.setDataVector(rowData, columnNames);
		            in.close();
		        }
		        catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		     

	
	public TrainSS1(){
		
		getContentPane().setLayout(null);
		

		      //setting from time in window 
			       JLabel currentTime = new JLabel("Current Time : ");
			       currentTime.setFont(new Font("Tohama",Font.BOLD,20));
			   	 currentTime.setBounds(30, 10, 350, 55);
			   	 add(currentTime);
			   	 
			   	JTextField Time = new JTextField();
			   	Time.setFont(new Font("Tohama",Font.BOLD,20));
			   	Time.setEditable(false);
			   	Time.setBounds(180, 20, 150, 35);
			   	add(Time);
			   	 Calendar c = Calendar.getInstance();
			   	 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			   	String currentDate = df.format(c.getTime());
			   	Time.setText(currentDate);
			   	
			 	LB[12] = new JLabel("CodeTicket : ");
			   	LB[12].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[12].setBounds(50, 110, 200, 50);
			   	getContentPane().add(LB[12]);
			   	
			   	LB[0] = new JLabel("Name : ");
			   	LB[0].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[0].setBounds(50, 170, 150, 50);
			   	getContentPane().add(LB[0]);
			   	
				LB[1] = new JLabel("Subname : ");
			   	LB[1].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[1].setBounds(50, 230, 150, 50);
			   	getContentPane().add(LB[1]);
			   
				LB[3] = new JLabel("Start : ");
			   	LB[3].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[3].setBounds(50, 290, 150, 50);
			   	getContentPane().add(LB[3]);
			   	
				LB[4] = new JLabel("Destination : ");
			   	LB[4].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[4].setBounds(50, 350, 300, 50);
			   	getContentPane().add(LB[4]);
			   	
			   	LB[11] = new JLabel("Ticket Price : ");
			   	LB[11].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[11].setBounds(50, 410, 300, 50);
			   	getContentPane().add(LB[11]);
			   	
				LB[5] = new JLabel("Cancel Ticket : ");
			   	LB[5].setFont(new Font("Tohama",Font.BOLD,25));
			   	LB[5].setBounds(50, 530, 300, 50);
			   	getContentPane().add(LB[5]);
			  
			   
				LB[7] = new JLabel("Time Start ");
			   	LB[7].setFont(new Font("Tohama",Font.BOLD,20));
			   	LB[7].setBounds(50, 660, 150, 50);
			   	getContentPane().add(LB[7]);
			   	
			   	LB[8] = new JLabel("Time Destiny ");
			   	LB[8].setFont(new Font("Tohama",Font.BOLD,20));
			   	LB[8].setBounds(50, 720, 150, 50);
			   	getContentPane().add(LB[8]);
			  
			   	LB[9] = new JLabel("Train");
			   	LB[9].setFont(new Font("Tohama",Font.BOLD,20));
			   	LB[9].setBounds(50, 780, 150, 50);
			   	getContentPane().add(LB[9]);
			
				LB[10] = new JLabel("seat");
			   	LB[10].setFont(new Font("Tohama",Font.BOLD,20));
			   	LB[10].setBounds(50, 840, 150, 50);
			   	getContentPane().add(LB[10]);
			 
			  	
			 	TT[0] = new JTextField();
			   	TT[0].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[0].setBounds(250, 110, 200, 50);
			   	getContentPane().add(TT[0]);
	
			   	TT[1] = new JTextField();
			   	TT[1].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[1].setBounds(250, 170, 200, 50);
			   	getContentPane().add(TT[1]);
			   	
				TT[2] = new JTextField();
			   	TT[2].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[2].setBounds(250, 230, 200, 50);
			   	getContentPane().add(TT[2]);
		 		
		 		// Start
		 		TT[3] = new JTextField();
			   	TT[3].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[3].setBounds(250, 290, 200, 50);
			   	getContentPane().add(TT[3]);
			   	
			   	//Destiny
			   	TT[4] = new JTextField();
			   	TT[4].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[4].setBounds(250, 350, 200, 50);
			   	getContentPane().add(TT[4]);
			   	
			    //Ticket price
			   	TT[5] = new JTextField();
			   	TT[5].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[5].setBounds(250, 410, 200, 50);
			   	getContentPane().add(TT[5]);
			   	
			  
			   	//Cancel Ticket
				MC[1] = new JTextField();
			   	MC[1].setFont(new Font("Tohama",Font.BOLD,25));
			   	MC[1].setBounds(250, 530, 200, 50);
			   	getContentPane().add(MC[1]);
			   	
				
			   // Time arrival
			   	TT[7] = new JTextField();
			   	TT[7].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[7].setBounds(250, 670, 200, 50);
			   	getContentPane().add(TT[7]);
			   	
			    // Train des
			   	TT[8] = new JTextField();
			   	TT[8].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[8].setBounds(250, 730, 200, 50);
			   	getContentPane().add(TT[8]);
			   	
			   	// Train
			   	TT[9] = new JTextField();
			   	TT[9].setFont(new Font("Tohama",Font.BOLD,25));
		 		TT[9].setBounds(250, 790, 200, 50);
		 		getContentPane().add(TT[9]);
			   	
		 		//seat
		 		TT[10] = new JTextField();
			   	TT[10].setFont(new Font("Tohama",Font.BOLD,25));
			   	TT[10].setBounds(250, 850, 200, 50);
			   	getContentPane().add(TT[10]);
			   	
			   	
			    Add2 = new JButton("AddD");
				 Add2.setBounds(850, 880, 100, 50);
				 Add2.setFont(new Font("Tohama", Font.BOLD, 20));
				 Add2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
				          
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection con = DriverManager.getConnection(
												"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
												"root", "");
										PreparedStatement ps; // = con.prepareStatement("insert into
																// user(user_id,user_Last,user_password,user_password2)
																// values(?,?,?,?);");
										String query = "INSERT INTO `data_ticket`(`TIC_PS`,`TIC_Name`, `TIC_Last`, `TIC_Start`, `TIC_Des`, `TIC_Price`, `TIC_Time_S`, `TIC_Time_D`,`TIC_Train`, `TIC_Seat`, `TIC_State`, `TIC_Date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
										ps = con.prepareStatement(query);

									
										String CDT = TT[0].getText();
										ps.setString(1, TT[0].getText());
										int m1 = CDT.length();
										
										String FN = TT[1].getText();
										ps.setString(2, TT[1].getText());
										int m2 = FN.length();
										
										String LT = TT[2].getText();
										ps.setString(3, TT[2].getText());
										int m3 = LT.length();

										String ST = TT[3].getText();
										ps.setString(4, TT[3].getText());
										int m4 = ST.length();

										String DT = TT[4].getText();
										ps.setString(5, TT[4].getText());	
										int m5 = DT.length();
								
										String AO = TT[5].getText();
										ps.setString(7, TT[5].getText());
										int m6 = AO.length();
										
										String TU = MC[1].getText();
										ps.setString(8, MC[1].getText());
										int m7 = TU.length();
										
										String TN = TT[7].getText();
										ps.setString(9, TT[7].getText());
										int m8 = TN.length();
										
										String SE = TT[8].getText();
										ps.setString(10, TT[8].getText());
										int m9 = SE.length();
										
										String STA = TT[9].getText();
										ps.setString(11, TT[9].getText());
										int m10 = TN.length();
										
										String SS = TT[10].getText();
										ps.setString(11, TT[10].getText());
										int m11 = TN.length();
										
										String currentDate = Time.getText();
										ps.setString(12, Time.getText());
									  	int m12 = currentDate.length();
									 
										ps.setString(1, TT[0].getText());
										ps.setString(2, TT[1].getText());
										ps.setString(3, TT[2].getText());
										ps.setString(4, TT[3].getText());
										ps.setString(5, TT[4].getText());
										ps.setString(6, TT[5].getText());
										ps.setString(7, TT[7].getText());
										ps.setString(8, TT[8].getText());
										ps.setString(9,TT[9].getText());
										ps.setString(10, TT[10].getText());
										ps.setString(11, MC[1].getText());
										ps.setString(12, currentDate);	

										
										if(m1 <= 4 || m1 >= 7)
										{
											JOptionPane.showMessageDialog(null,
													"Please Input password at least 5 and less than 7");
											TT[0].requestFocus();
											return;
											
										}
										
										if(m2 <= 0 )
										{
											JOptionPane.showMessageDialog(null,
													"Please Input First Name");
											TT[1].requestFocus();
											return;
											
										}
										
										if(m3 <= 0 )
										{
											JOptionPane.showMessageDialog(null,
													"Please Input Last Name");
											TT[2].requestFocus();
											return;
											
										}
										
										if(m4 <= 5 )
										{
											JOptionPane.showMessageDialog(null,
													"Please Input location start");
											TT[3].requestFocus();
											return;
											
										}
										
										if(m5 <= 5 )
										{
											JOptionPane.showMessageDialog(null,
													"Please Input location destiny");
											TT[4].requestFocus();
											return;
											
										}
										
										if(m6 <= 0 || m6 >= 3 )
										{
											JOptionPane.showMessageDialog(null,
													"Please Input TicketPrice");
											TT[5].requestFocus();
											return;
											
										}
										
										int x = ps.executeUpdate();
										if (x > 0) {
											System.out.println("Registration done successfully....");
											
										} else {
											System.out.println("Registration Failed...");
										}
									} catch (Exception ex) {
										Logger.getLogger(Normal.class.getName()).log(Level.SEVERE, null, ex);

									}
								}
					});
				 

	        getContentPane().add(Add2);
			   	
			   	

			myJTable.setBackground(Color.LIGHT_GRAY);
	        myJTable.setForeground(Color.black);
	        Font font1 = new Font("Tohama", Font.BOLD, 15);
	        myJTable.setFont(font1);
	        myJTable.setRowHeight(40);
			
	        myJTable.addMouseListener(new MouseAdapter() {
				   @Override
				   public void mouseClicked(MouseEvent arg0) {
				    int row = myJTable.getSelectedRow();
				    if (row != -1) {
				     //TT[0].setText(myJTable.getValueAt(row, 0).toString());
				     TT[1].setText(myJTable.getValueAt(row, 0).toString());
				     TT[2].setText(myJTable.getValueAt(row, 1).toString());
				     TT[3].setText(myJTable.getValueAt(row, 2).toString());
				     TT[4].setText(myJTable.getValueAt(row, 3).toString());
				     TT[5].setText(myJTable.getValueAt(row, 4).toString());
				     TT[7].setText(myJTable.getValueAt(row, 5).toString());
				     TT[8].setText(myJTable.getValueAt(row, 6).toString());
				     TT[9].setText(myJTable.getValueAt(row, 7).toString());
				     TT[10].setText(myJTable.getValueAt(row, 8).toString());
				     MC[1].setText(myJTable.getValueAt(row, 9).toString());
				     Time.setText(myJTable.getValueAt(row, 10).toString());
				     
				   
				    
				    }
				   }
				  });
	        
			 JScrollPane scrollPane3 = new JScrollPane(myJTable);
			  scrollPane3.setBounds(550, 100, 1300, 300);//550, 350, 1300,500
			  getContentPane().add(scrollPane3);
	  
			JButton jbtAddRow = new JButton("Add");
			jbtAddRow.setBounds(850, 430, 100, 50);
		    jbtAddRow.setFont(new Font("Tohama", Font.BOLD, 20));
		    jbtAddRow.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	

	                if (myJTable.getSelectedRow() >= 0){
	                	TableColumn seasonColumn = myJTable.getColumn("");
	                	
	                	 tableModel.insertRow (myJTable.getSelectedRow(),

	                             new java.util.Vector());
	                   
	                	
	                }
	                else
	                    tableModel.addRow(new java.util.Vector());
	            }
	        });
	         
			getContentPane().add(jbtAddRow);
	      
		        
			JButton jbtSave = new JButton("Save");
			jbtSave.setBounds(1100,430,100,50);
		    jbtSave.setFont(new Font("Tohama", Font.BOLD, 20));
		    jbtSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                saveTable();
	            }
	        });
		    getContentPane().add(jbtSave);
		    /*
		    JButton send = new JButton("send");
			send.setBounds(1150,880,100,50);
		    send.setFont(new Font("Tohama", Font.BOLD, 20));
		    send.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Staff_Page frame = new Staff_Page("Staff");
					frame.setVisible(true);
					frame.setSize(800, 690);
			        frame.setVisible(true);
	                frame.setLocation(960, 270);
	                frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            }
	        });
		    getContentPane().add(send);
		    */
		    
				JButton jbtLoad = new JButton("Upload");
				jbtLoad.setBounds(1350,430,100,50);
			    jbtLoad.setFont(new Font("Tohama", Font.BOLD, 20));
			    jbtLoad.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                loadTable();
		            }
		        });
			    getContentPane().add(jbtLoad);
		      
			    send = new JButton("Send");
				send.setBounds(1600,430,100,50);
			    send.setFont(new Font("Tohama", Font.BOLD, 20));
			    send.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                Data_Sell DS = new Data_Sell();
		                DS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                DS.setSize(1900,1000);
		                DS.setLocation(10,10);
		                DS.setVisible(true);
		                
		            }
		        });
			    getContentPane().add(send);
	        
				Refresh = new JButton("Refresh");
				Refresh.setBounds(600, 880, 120, 50);
				Refresh.setFont(new Font("Tohama", Font.BOLD, 20));
			    Refresh.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	 TrainSS1 T = new TrainSS1();
		                 T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                 T.setVisible(true);
		                 T.setSize(1910,1000);
		                 T.setLocation(10,10);
		                
		            }
		        });
			    getContentPane().add(Refresh);
			    
//check
			   	
				 n2 = new JButton("Check");
				 n2.setBounds(1350,880,100,50);
				 n2.setFont(new Font("Tohama", Font.BOLD, 20));
				 n2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
                              
							 TrainSS1 T = new TrainSS1();
						        T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        T.setVisible(true);
						        T.setSize(1910,1000);
						        T.setLocation(10,10);
						
						}
					});

				 getContentPane().add(n2);
															 
				
				 n3 = new JButton("back");
				 n3.setBounds(1600,880,100,50);
				 n3.setFont(new Font("Tohama", Font.BOLD, 20));
				 n3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
                              
							   Trainthree T = new Trainthree("Welcome to Trainstaion");
							   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							   T.setSize(1520,1000);
							   T.setVisible(true);
							   T.setLocation(300, 10);
							 
						
						}
					});

				 getContentPane().add(n3);
												
				 
				 table = new JTable();
				
				  table.setBackground(Color.WHITE);
			        table.setForeground(Color.black);
			        Font font11 = new Font("Tohama",Font.BOLD,15);
			        table.setFont(font11);
			        table.setRowHeight(40);
				
				JScrollPane pane1 = new JScrollPane(table);
				pane1.setBounds(550, 500, 1300,350);
		        
		        getContentPane().add(pane1);
				
				pane1.setViewportView(table);
				  
						 SaveData = new JButton("Delete");
						 SaveData.setBounds(1100, 880, 100, 50);
						 SaveData.setFont(new Font("Tohama", Font.BOLD, 20));
						 SaveData.addActionListener(new ActionListener() {
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

									getContentPane().add(SaveData);

									PopulateData();
								}


protected void showTable() {
		// TODO Auto-generated method stub
		
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
	
	default:
		return String.class;
	}
}
};
table.setModel(model);

//Add Column
model.addColumn("Select");
model.addColumn("TIC_PS");
model.addColumn("TIC_Name");
model.addColumn("TIC_Last"); 
model.addColumn("TIC_Start");
model.addColumn("TIC_Des");
model.addColumn("TIC_Price");
model.addColumn("TIC_Time_S");
model.addColumn("TIC_Time_D");
model.addColumn("TIC_Train");
model.addColumn("TIC_Seat");
model.addColumn("TIC_State");
model.addColumn("TIC_Date");

Connection connect = null;
Statement s = null;

try {


Class.forName("com.mysql.cj.jdbc.Driver");
connect = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
"root", "");


s = connect.createStatement();

String sql = "SELECT * FROM  data_ticket ORDER BY TIC_PS ASC";

ResultSet rec = s.executeQuery(sql);
int row1 = 0;
while ((rec != null) && (rec.next())) {
model.addRow(new Object[0]);
model.setValueAt(false, row1, 0); // Checkbox
model.setValueAt(rec.getString("TIC_PS"), row1, 1);
model.setValueAt(rec.getString("TIC_Name"), row1, 2);
model.setValueAt(rec.getString("TIC_Last"), row1, 3);
model.setValueAt(rec.getString("TIC_Start"), row1, 4);
model.setValueAt(rec.getString("TIC_Des"), row1, 5);
model.setValueAt(rec.getString("TIC_Price"), row1, 6);
model.setValueAt(rec.getString("TIC_Time_S"), row1, 7);
model.setValueAt(rec.getString("TIC_Time_D"), row1, 8);
model.setValueAt(rec.getString("TIC_Train"), row1, 9);
model.setValueAt(rec.getString("TIC_Seat"), row1, 10);
model.setValueAt(rec.getString("TIC_State"), row1, 11);
model.setValueAt(rec.getString("TIC_Date"), row1, 12);



row1++;
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

//Delete
private void DeleteData(String strDate) {

Connection connect = null;
Statement s = null;

try {

Class.forName("com.mysql.cj.jdbc.Driver");
connect = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
"root", "");

s = connect.createStatement();

String sql = "DELETE FROM data_ticket  WHERE " + "TIC_PS = '"
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
getContentPane().add(SaveData);

}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TrainSS1 T = new TrainSS1();
        T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        T.setVisible(true);
        T.setSize(1910,1000);
        T.setLocation(10,10);
	}

	
}
