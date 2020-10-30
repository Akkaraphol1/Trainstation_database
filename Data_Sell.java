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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class Data_Sell extends JFrame {
	private JTextField[] TT = new JTextField[13];
	private JLabel[] LB = new JLabel[13];
	private JTextField[] MC = new JTextField[2];
	  private static JTable table = new JTable(); 
	  
		private JLabel LB1[] = new JLabel[12]; 
		JLabel imageLabel,imageLabel2;
		public JLabel img;
		private JButton nn = new JButton();
		 private JButton n2 = new JButton();
		private JButton CC= new JButton();
		 
		 
		    private JButton n3 = new JButton();
		    private JButton Add2 = new JButton();
		    private Connection conn;
		    private PreparedStatement stmt;
		    private ResultSet rs;
		private JButton send ;
		private JButton TTT ;
		private JButton[] n = new JButton[5];
		private JButton Refresh;
		private JButton SaveData = new JButton();
		
		 private String[] columnNames = 
		        {"CodeSell", "CodeTicket","CodeMember","Train","Start","Destiny","Time_Out","Time_Arrival","Discount","Price_Ticket","State","Date/Month/Year"};
		
		  
		    private Object[][] data;
		     
			    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
			    private JTable myJTable = new JTable(tableModel);
		  
	//register_1
			   
			    private DefaultTableModel listModel = new DefaultTableModel();
			    private static JTable table3 = new JTable();
			    private 	JScrollPane pane3 = new JScrollPane();
			    
			    
		     
		    private JButton NA = new JButton("Add ");
		    private JButton jbtSave = new JButton("Save Table");
		    private JButton jbtLoad = new JButton("Load Table");

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
		     

	
	public Data_Sell(){
		getContentPane().setLayout(null);
		

	      //setting from time in window 
		
		       JLabel currentTime = new JLabel("Current Time : ");
		       currentTime.setFont(new Font("Tohama",Font.BOLD,20));
		   	 currentTime.setBounds(30, 10, 350, 55);
		   	 add(currentTime);
		   
		 	LB[12] = new JLabel("CodeSell :");
		   	LB[12].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[12].setBounds(50, 70, 150, 50);
		   	getContentPane().add(LB[12]);
		   	
		   	LB[0] = new JLabel("CodeTicket :");
		   	LB[0].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[0].setBounds(50, 130, 150, 50);
		   	getContentPane().add(LB[0]);
		   	
			LB[1] = new JLabel("CodeMem :");
		   	LB[1].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[1].setBounds(50, 190, 150, 50);
		   	getContentPane().add(LB[1]);
		   
			LB[3] = new JLabel("Train :");
		   	LB[3].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[3].setBounds(50, 250, 150, 50);
		   	getContentPane().add(LB[3]);
		   	
			LB[4] = new JLabel("Start :");
		   	LB[4].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[4].setBounds(50, 310, 300, 50);
		   	getContentPane().add(LB[4]);
		   	
		   	LB[11] = new JLabel("Destiny : ");
		   	LB[11].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[11].setBounds(50, 370, 150, 50);
		   	getContentPane().add(LB[11]);
		   	
			LB[5] = new JLabel("Time_Out : ");
		   	LB[5].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[5].setBounds(50, 430, 300, 50);
		   	getContentPane().add(LB[5]);
		  
		   
			LB[7] = new JLabel("Time_Arrival :");
		   	LB[7].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[7].setBounds(50, 490, 150, 50);
		   	getContentPane().add(LB[7]);
		   	
		   	LB[8] = new JLabel("Discount :");
		   	LB[8].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[8].setBounds(50, 550, 150, 50);
		   	getContentPane().add(LB[8]);
		  
		   	LB[9] = new JLabel("Price_Ticket :");
		   	LB[9].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[9].setBounds(50, 610, 150, 50);
		   	getContentPane().add(LB[9]);
		 
		   	
		  	//Codesell
		 	TT[0] = new JTextField();
		   	TT[0].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[0].setBounds(200, 70, 150, 50);
		   	getContentPane().add(TT[0]);

		   	//CodeTicket
		   	TT[1] = new JTextField();
		   	TT[1].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[1].setBounds(200, 130, 150, 50);
		   	getContentPane().add(TT[1]);
		   	
		   	//Ps_mem
			TT[2] = new JTextField();
		   	TT[2].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[2].setBounds(200, 190, 150, 50);
		   	getContentPane().add(TT[2]);
	 		
	 		// Train_num
	 		TT[3] = new JTextField();
		   	TT[3].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[3].setBounds(200, 250, 150, 50);
		   	getContentPane().add(TT[3]);
		   	
		   	//Start
		   	TT[4] = new JTextField();
		   	TT[4].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[4].setBounds(200, 310, 150, 50);
		   	getContentPane().add(TT[4]);
		   	
		    //Destiny
		   	TT[5] = new JTextField();
		   	TT[5].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[5].setBounds(200, 370, 150, 50);
		   	getContentPane().add(TT[5]);
		   	
		   	//Time_out
			TT[6] = new JTextField();
		   	TT[6].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[6].setBounds(200, 430, 150, 50);
		   	getContentPane().add(TT[6]);
		   	
		   // Time arrival
		   	TT[7] = new JTextField();
		   	TT[7].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[7].setBounds(200, 490, 150, 50);
		   	getContentPane().add(TT[7]);
		   	
		    // Discount
		   	TT[8] = new JTextField();
		   	TT[8].setFont(new Font("Tohama",Font.BOLD,20));
		   	TT[8].setBounds(200, 550, 150, 50);
		   	getContentPane().add(TT[8]);
		   	
		   	// Price_Ticket
		   	TT[9] = new JTextField();
		   	TT[9].setFont(new Font("Tohama",Font.BOLD,20));
	 		TT[9].setBounds(200, 610, 150, 50);
	 		getContentPane().add(TT[9]);
		  
		   	//Time
		   	TT[11] = new JTextField();
		   	//TT[11].setText("22-10-2020");
		   	TT[11].setEnabled(false);
		 	TT[11].setFont(new Font("Tohama",Font.BOLD,25));
		   	TT[11].setBounds(180, 20, 150, 35);
		   	getContentPane().add(TT[11]);
		   	
			TT[12] = new JTextField();
			TT[12].setVisible(false);
		   	//TT[12].setEnabled(false);
		 	TT[12].setFont(new Font("Tohama",Font.BOLD,25));
		   	TT[12].setBounds(380, 10, 150, 35);
		   	getContentPane().add(TT[12]);
		   	
		   	
			myJTable.setBackground(Color.LIGHT_GRAY);
	        myJTable.setForeground(Color.black);
	        Font font1 = new Font("Tohama", Font.BOLD, 15);
	        myJTable.setFont(font1);
	        myJTable.setRowHeight(40);
			
	        //scrollPane3
			 JScrollPane scrollPane3 = new JScrollPane(myJTable);
			  scrollPane3.setBounds(550, 100, 1300, 300);//550, 350, 1300,500
			  getContentPane().add(scrollPane3);
			  
			    send = new JButton("Send");
							send.setBounds(1600,430,100,50);
						    send.setFont(new Font("Tohama", Font.BOLD, 20));
						    send.addActionListener(new ActionListener() {
					            public void actionPerformed(ActionEvent e) {
					            	Data_Sell_T2 DS2 = new Data_Sell_T2("Data_Sell_T2");
					        		DS2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        		DS2.setSize(1900, 1000);
					        		DS2.setVisible(true);
					        		DS2.setLocation(10,10);
					                
					            }
					        });
						    getContentPane().add(send);
				        
				        //check
						    CC = new JButton("Check");
							CC.setBounds(600, 430, 100, 50);
						    CC.setFont(new Font("Tohama", Font.BOLD, 20));
						    CC.addActionListener(new ActionListener() {
					            public void actionPerformed(ActionEvent e) {
					            	 TrainDSTP1 TD = new  TrainDSTP1("Page Datasell");
					        		 TD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        		 TD.setSize(1520,1000);
					        		 TD.setLocation(300,10);
					        		 TD.setVisible(true);
					            
					            }
					              
					        });
					         
							getContentPane().add(CC);
							
	  
						    
						    
			NA = new JButton("Add");
			NA.setBounds(850, 430, 100, 50);
		    NA.setFont(new Font("Tohama", Font.BOLD, 20));
		    Object [] row2 = new Object[12];
		    NA.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	row2[0] = TT[0].getText();
                    row2[1] = TT[1].getText();
                    row2[2] = TT[2].getText();
                    row2[3] = TT[3].getText();
                    row2[4] = TT[4].getText();
                    row2[5] = TT[5].getText();
                    row2[6] = TT[6].getText();
                    row2[7] = TT[7].getText();
                    row2[8] = TT[8].getText();
                    row2[9] = TT[9].getText();
                    row2[10] = TT[12].getText();
                    row2[11] = TT[11].getText();
 
                  
	            if (myJTable.getSelectedRow() >= 0){
	               
	                	 tableModel.insertRow (myJTable.getSelectedRow(),

	                             new java.util.Vector());
						   tableModel.addRow(row2);
	                	
	              }
	            else
	                    tableModel.addRow(row2);
	            }
	              
	        });
	         
			getContentPane().add(NA);
			
			Refresh = new JButton("Refresh");
			Refresh.setBounds(600, 880, 120, 50);
			Refresh.setFont(new Font("Tohama", Font.BOLD, 20));
		    Refresh.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  Data_Sell DS = new Data_Sell();
	                  DS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                  DS.setSize(1900,1000);
	                  DS.setLocation(10,10);
	                  DS.setVisible(true);
	                
	            }
	        });
		    getContentPane().add(Refresh);
			
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
									String query = "INSERT INTO `data_sell`(`PS_Data_Sell`,`TIC_PS`, `PS_Mem`, `Train_Num`, `Start`, `Destiny`, `Time_Out`, `Time_Arrival`,`Discount`, `Price_Ticket`,`Ticket_State`, `Date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
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
									ps.setString(6, TT[5].getText());
									int m6 = AO.length();
									
									String TU = TT[6].getText();
									ps.setString(7, TT[6].getText());
									int m7 = TU.length();
									
									String TN = TT[7].getText();
									ps.setString(8, TT[7].getText());
									int m8 = TN.length();
									
									String SE = TT[8].getText();
									ps.setString(9, TT[8].getText());
									int m9 = SE.length();
									
									String STA = TT[9].getText();
									ps.setString(10, TT[9].getText());
									int m10 = STA.length();
									
									String TTS = TT[12].getText();
									ps.setString(11, TT[12].getText());
									int m11 = TTS.length();
									
									String SS = TT[11].getText();
									ps.setString(12, TT[11].getText());
									int m12 = SS.length();
									
								
								 
									ps.setString(1, CDT);
									ps.setString(2, FN);
									ps.setString(3, LT);
									ps.setString(4, ST);
									ps.setString(5, DT);
									ps.setString(6, AO);
									ps.setString(7, TU);
									ps.setString(8, TN);
									ps.setString(9,SE);
									ps.setString(10, STA);
									ps.setString(11, TTS);
									ps.setString(12, SS);
									
									
									int x = ps.executeUpdate();
									if (x > 0) {
										System.out.println("Add Data successfully....");
										
									} else {
										System.out.println("Add Failed...");
									}
								} catch (Exception ex) {
									Logger.getLogger(Data_Sell.class.getName()).log(Level.SEVERE, null, ex);

								}
							}
				});
			 

        getContentPane().add(Add2);
		   	
			
		        
			JButton jbtSave = new JButton("Save");
			jbtSave.setBounds(1100,430,100,50);
		    jbtSave.setFont(new Font("Tohama", Font.BOLD, 20));
		    jbtSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                saveTable();
	            }
	        });
		    getContentPane().add(jbtSave);
		 
		    
				JButton jbtLoad = new JButton("Upload");
				jbtLoad.setBounds(1350,430,100,50);
			    jbtLoad.setFont(new Font("Tohama", Font.BOLD, 20));
			    jbtLoad.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                loadTable();
		            }
		        });
			    getContentPane().add(jbtLoad);
		      
		 

				// ScrollPane
				JScrollPane pane3 = new JScrollPane();
				pane3.setBounds(20, 670, 500, 250);
				getContentPane().add(pane3);

				// Table
				table3 = new JTable();
				  table3.setBackground(Color.WHITE);
			        table3.setForeground(Color.black);
			        Font font = new Font("Tohama",Font.BOLD,15);
			        table3.setFont(font);
			        table3.setRowHeight(40);
				
				pane3.setViewportView(table3);
	        
				 table3.addMouseListener(new MouseAdapter() {
					   @Override
					   public void mouseClicked(MouseEvent arg0) {
					    int row = table3.getSelectedRow();
					    if (row != -1) {
					    
					
					   
					     TT[2].setText(table3.getValueAt(row, 2).toString());
					     
				
					    
					    }
					   }
					  });
//check
				
				// Clear table
				table3.setModel(new DefaultTableModel());

				// Model for Table
				DefaultTableModel model = (DefaultTableModel) table3.getModel();
			
				model.addColumn("First Name");
				model.addColumn("Last Name");
				model.addColumn("Password");
				model.addColumn("Confirm Password");
				

				Connection connect = null;
				Statement s = null;

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect= DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/trainstation2? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					
					s = connect.createStatement();

					String sql = "SELECT * FROM  register_1 ORDER BY Date ASC";

					ResultSet rec = s.executeQuery(sql);
					int row = 0;
					while ((rec != null) && (rec.next())) {
						model.addRow(new Object[0]);
						model.setValueAt(rec.getString("First Name"), row, 0);
						model.setValueAt(rec.getString("Last Name"), row, 1);
						model.setValueAt(rec.getString("Password"), row, 2);
						model.setValueAt(rec.getString("Confirm Password"), row, 3);
						
						
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
				
			        table.addMouseListener(new MouseAdapter() {
						   @Override
						   public void mouseClicked(MouseEvent arg0) {
						    int row = table.getSelectedRow();
						    if (row != -1) {
						     //TT[0].setText(myJTable.getValueAt(row, 0).toString());
						    	
						     TT[1].setText(table.getValueAt(row, 1).toString());
						     
						     TT[3].setText(table.getValueAt(row, 9).toString());
						     TT[4].setText(table.getValueAt(row, 4).toString());
						     TT[5].setText(table.getValueAt(row, 5).toString());
						     TT[6].setText(table.getValueAt(row, 7).toString());
						     TT[7].setText(table.getValueAt(row, 8).toString());
						     TT[9].setText(table.getValueAt(row, 6).toString());
						     TT[12].setText(table.getValueAt(row, 11).toString());
						     TT[11].setText(table.getValueAt(row, 12).toString());
						 
						   
						    
						    }
						   }
						  });
			        
			        
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
        Data_Sell DS = new Data_Sell();
        DS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DS.setSize(1900,1000);
        DS.setLocation(10,10);
        DS.setVisible(true);
        
	}

}
