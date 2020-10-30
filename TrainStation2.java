import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class TrainStation2 extends JFrame {

	 private JTextField empid;
	 private JTextField empsal;
	 private JTextField price;
	 
	 private JTextField aog,tung,ticketstat, balance,train,seat;
	 private String TK2;
	 private String[] ST = new String[1];
	private JButton[] B = new JButton[2];

 
	private JTextField[] T = new JTextField[7];
	private JComboBox[] CX = new JComboBox[2];
	private JRadioButton[] CB = new JRadioButton[5];
	private JTextField[] TF = new JTextField[6];
	private JLabel[] LB = new JLabel[12];
	private JButton n2 ;

	
	private  String[] colomns5={"First Name","Last Name","Start","Destination","Ticket Price","Time out","Arrival Time","Train","Seat NO.","Status","DateTime"};
	private Object[][] data;
	
	    
	    private DefaultTableModel model5= new DefaultTableModel(data,colomns5);
	    private JTable table30 = new JTable ( model5 );
	
	    
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
	                out.writeObject(model5.getDataVector());
	                out.writeObject(getColumnNames());
	                out.close();
	            }
	            catch (Exception ex) {
	                ex.printStackTrace();
	            }
	    }
	    private Vector<String> getColumnNames() {
	        Vector<String> columnNames = new Vector<String>();
	        for (int i = 0; i < table30.getColumnCount(); i++)
	            columnNames.add(table30.getColumnName(i) );
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
	            model5.setDataVector(rowData, columnNames);
	            in.close();
	          
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	     
		private double[] M = new double[4]; 

	int ticketprice;
	int random;
	int seatrandom;
	private JButton btnAdd,btnReset;
	
	String srandom;
	String tostring;
	String tontangpaitang;
	String tontangpaitang2;
	String timeaog;
	String timetung;
	
	String statticket;
	String seatno;

	
	double PTB = 50 ;
	double PTN = 50 ;
	double BTP = 100 ;
	double BTN = 100 ;
	double NTB = 75 ;
	double NTP = 75 ;
	
	private JButton n = new JButton("Add");
	private JButton jbtSave = new JButton("Save");
	private JButton jbtLoad = new JButton("Load ");
	
	@SuppressWarnings("unchecked")
	public TrainStation2(){
		getContentPane().setLayout(null);
		JTable table = new JTable(); 
		//table.setSize(50,50);
		table.setFont(new Font("TH sarabun",Font.BOLD,15));
		
		DefaultTableModel tableModel = new DefaultTableModel ( );

		tableModel.addColumn ( "Travel between" );

		tableModel.addColumn ( "Out" );

		tableModel.addColumn ( "To" );
		
		tableModel.addColumn ( "Price" );


		String [ ] dataRow01 = new String [ 4 ];

		dataRow01 [ 0 ] = "Bangkok to Songkra";
		dataRow01 [ 1 ] = "05.20";
		dataRow01 [ 2 ] = "08.30";
		dataRow01 [ 3 ] = "50";
		tableModel.addRow ( dataRow01 );


		String [ ] dataRow02 = new String [ 4 ];
		dataRow02 [ 0 ] = "Songkra to Bangkok";
		dataRow02 [ 1 ] = "08.50";
		dataRow02 [ 2 ] = "11.15";
		dataRow02 [ 3 ] = "50";
		tableModel.addRow ( dataRow02 );


		String [ ] dataRow03 = new String [ 4 ];
		dataRow03 [ 0 ] = "Bangkok to Chiengmai";
		dataRow03 [ 1 ] = "07.30";
		dataRow03 [ 2 ] = "10.15";
		dataRow03 [ 3 ] = "100";
		tableModel.addRow ( dataRow03 );
		 
		
		String [ ] dataRow04 = new String [ 4 ];
		dataRow04 [ 0 ] = "Chiengmai to Bangkok";
		dataRow04 [ 1 ] = "10.35";
		dataRow04 [ 2 ] = "13.45";
		dataRow04 [ 3 ] = "100";
		tableModel.addRow ( dataRow04 );

	
		String [ ] dataRow05 = new String [ 4 ];
		dataRow05 [ 0 ] = "Songkra to Chiengmai";
		dataRow05 [ 1 ] = "09.15";
		dataRow05 [ 2 ] = "12.30";
		dataRow05 [ 3 ] = "75";
		tableModel.addRow ( dataRow05 );


		String [ ] dataRow06 = new String [ 4 ];
		dataRow06 [ 0 ] = "Chiengmai to Songkra";
		dataRow06 [ 1 ] = "16.15";
		dataRow06 [ 2 ] = "19.10";
		dataRow06 [ 3 ] = "75";
		tableModel.addRow ( dataRow06 );

		table.setModel(tableModel);

		table.setBackground(Color.WHITE);
		        table.setForeground(Color.black);
		        Font font = new Font("Tohama",Font.BOLD,15);
		        table.setFont(font);
		        table.setRowHeight(40);

		        JScrollPane pane = new JScrollPane(table);
		        pane.setBounds(595, 50, 800, 257);
		        
		        getContentPane().add(pane);

		        Object[] row = new Object[6];


		// get selected row data From table to textfields 
		        table.addMouseListener(new MouseAdapter(){
		        
		        @Override
		        public void mouseClicked(MouseEvent e){
		            
		            // i = the index of the selected row
		            int i = table.getSelectedRow();
		            
		            TF[0].setText(tableModel.getValueAt(i, 0).toString());
		            TF[1].setText(tableModel.getValueAt(i, 1).toString());
		            TF[2].setText(tableModel.getValueAt(i, 2).toString());
		            TF[3].setText(tableModel.getValueAt(i, 3).toString());
		            TF[4].setText(tableModel.getValueAt(i, 4).toString());
		            TF[5].setText(tableModel.getValueAt(i, 5).toString());
		            
		            row[0] = TF[0].getText();
                    row[1] = TF[1].getText();
                    row[2] = TF[2].getText();
                    row[3] = TF[3].getText();
                    row[4] = TF[4].getText();		          
                    row[5] = TF[5].getText();
         
                    
                    // add row to the model
                    tableModel.addRow(row);
		        }
		        });

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
		   	
		   	LB[0] = new JLabel("First Name : ");
		   	LB[0].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[0].setBounds(120, 370, 150, 50);
		   	getContentPane().add(LB[0]);
		   	
			LB[1] = new JLabel("Last Name : ");
		   	LB[1].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[1].setBounds(120, 430, 150, 50);
		   	getContentPane().add(LB[1]);
		   	
		 	LB[2] = new JLabel("Money : ");
		   	LB[2].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[2].setBounds(120, 670, 150, 50);
		   	getContentPane().add(LB[2]);
		   	
			LB[3] = new JLabel("Start : ");
		   	LB[3].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[3].setBounds(120, 490, 150, 50);
		   	getContentPane().add(LB[3]);
		   	
			LB[4] = new JLabel("Destination : ");
		   	LB[4].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[4].setBounds(120, 550, 300, 50);
		   	getContentPane().add(LB[4]);
		   	
		   	LB[11] = new JLabel("Ticket Price : ");
		   	LB[11].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[11].setBounds(120, 610, 300, 50);
		   	getContentPane().add(LB[11]);
		   	
			LB[5] = new JLabel("Cancel Ticket : ");
		   	LB[5].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[5].setBounds(120, 730, 300, 50);
		   	getContentPane().add(LB[5]);
		   	
		 	LB[6] = new JLabel("Balance : ");
		   	LB[6].setFont(new Font("Tohama",Font.BOLD,25));
		   	LB[6].setBounds(120, 840, 150, 50);
		   	getContentPane().add(LB[6]);
		   	
			LB[7] = new JLabel("Children  -10 ");
		   	LB[7].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[7].setBounds(1270, 300, 150, 50);
		   	getContentPane().add(LB[7]);
		   	
		   	LB[8] = new JLabel("Adult      -5 ");
		   	LB[8].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[8].setBounds(1270, 330, 150, 50);
		   	getContentPane().add(LB[8]);
		   	
		   	LB[9] = new JLabel("Older      -3 ");
		   	LB[9].setFont(new Font("Tohama",Font.BOLD,20));
		   	LB[9].setBounds(1270, 360, 150, 50);
		   	getContentPane().add(LB[9]);
		   
		   	//textField
			T[0] = new JTextField();
			T[0].setEnabled(false);
		   	T[0].setFont(new Font("Tohama",Font.BOLD,25));
		   	T[0].setBounds(360, 370, 150, 50);
		   	getContentPane().add(T[0]);
		   	
			T[1] = new JTextField();
			T[1].setEnabled(false);
		   	T[1].setFont(new Font("Tohama",Font.BOLD,25));
		   	T[1].setBounds(360, 430, 150, 50);
		   	getContentPane().add(T[1]);
		   	
		   	//Money
		 	T[2] = new JTextField();
		 	T[2].setText("0");
		 	T[2].setEnabled(false);
		   	T[2].setFont(new Font("Tohama",Font.BOLD,25));
		   	T[2].setBounds(360, 670, 150, 50);
		   	getContentPane().add(T[2]);
	
		   	price = new JTextField();
			price.setColumns(10);
		 	price.setEnabled(false);
		   	price.setFont(new Font("Tohama",Font.BOLD,25));
		   	price.setBounds(360, 610, 150, 50);
		   	getContentPane().add(price);
		   	
		   	//Balance
		 	T[3] = new JTextField();
		 	T[3].setEnabled(false);
		   	T[3].setFont(new Font("Tohama",Font.BOLD,25));
		   	T[3].setBounds(360, 840, 150, 50);
		   	getContentPane().add(T[3]);
		   	

		      empsal = new JTextField();	
			  empsal.setBounds(410, 604, 133, 20);
			  empsal.setColumns(10);
		  
			  empid = new JTextField();
			  empid.setBounds(410, 573, 133, 20);
			  empid.setColumns(10);
			  
			  aog = new JTextField();
			  aog.setBounds(410, 604, 133, 20);
			  aog.setColumns(10);
		
			  tung = new JTextField();
			  tung.setBounds(410, 604, 133, 20);
			  tung.setColumns(10);
			  
			  ticketstat = new JTextField();
			  ticketstat.setBounds(410, 604, 133, 20);
			  ticketstat.setColumns(10);
			  
		
			  train = new JTextField();
			  train.setBounds(125, 550, 100,25);
			  train.setEditable(false);	 
			 
			  seat = new JTextField();
			  seat.setBounds(125, 550, 100,25);
			  seat.setEditable(false);
		   	
			 
			  random = 1 + ( int ) ( Math.random() * 6 );
				srandom=(Integer.toString(random));
				
				seatrandom =  1 + ( int ) ( Math.random() * 50 );
				seatno =(Integer.toString(seatrandom));
				statticket = "Successfully";
			  
		   	
			// Combobox
	 		String[] choosecards = { "Bangkok","Songkra","Chiengmai","Choose"};
	 		CX[0] = new JComboBox<Object>(choosecards);
	 		CX[0].setEnabled(false);
	 		CX[0].setFont(new Font("Tohama", Font.BOLD, 18));
	 		CX[0].setSelectedIndex(3);
	 		CX[0].setBounds(360, 490, 200, 40);
	 		CX[0].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
                   
				
				}
			});
	 		getContentPane().add(CX[0]);
		   	
	 		
	 		String[] choosecards2 = { "Bangkok","Songkra","Chiengmai","Choose"};
	 		CX[1] = new JComboBox<Object>(choosecards2);
	 		CX[1].setEnabled(false);
	 		CX[1].setFont(new Font("Tohama", Font.BOLD, 18));
	 		CX[1].setSelectedIndex(3);
	 		CX[1].setBounds(360, 550, 200, 40);
	 		CX[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
                    if(CX[0].getSelectedItem().equals("Songkra") && CX[1].getSelectedItem().equals("Bangkok")){
                    	
                    	timeaog = "08.50";
    					timetung = "11.15";
    					tontangpaitang = "Songkra";
    					tontangpaitang2 = "Bangkok";
    					
                    	if(CB[0].isSelected()){
                        M[1] = PTN - 10;
						TK2 = String.format("B%.2f", M[1]);
						price.setText(TK2);
                    	}
                    	else if(CB[1].isSelected()){
                    	M[1] = PTN - 5;
                        TK2 = String.format("B%.2f", M[1]);
    						price.setText(TK2);
                    	}
                    	else if(CB[2].isSelected()){
                    	M[1] = PTN - 3;
                 		TK2 = String.format("B%.2f", M[1]);
    						price.setText(TK2);
                    	}
                    	T[2].setEnabled(true);
                    	B[0].setEnabled(true);
					}
					else if (CX[0].getSelectedItem().equals("Bangkok") && CX[1].getSelectedItem().equals("Songkra")){
						
						 timeaog = "05.20";
						 timetung = "08.30";
						 tontangpaitang = "Bangkok";
							tontangpaitang2 = "Songkra";
						
						if(CB[0].isSelected()){
	                        M[1] = PTB - 10;
							TK2 = String.format("B%.2f", M[1]);
							price.setText(TK2);
	                    	}
	                    	else if(CB[1].isSelected()){
	                    	M[1] = PTB - 5;
	                        TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	else if(CB[2].isSelected()){
	                    	M[1] = PTB - 3;
	                 		TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	T[2].setEnabled(true);
	                    	B[0].setEnabled(true);
						
					}
					else if (CX[0].getSelectedItem().equals("Bangkok") && CX[1].getSelectedItem().equals("Chiengmai")){
						 
						 timeaog = "07.30";
							timetung = "10.15";
						 tontangpaitang = "Bangkok";
							tontangpaitang2 = "Chiengmai";
							
						if(CB[0].isSelected()){
	                        M[1] = BTP - 10;
							TK2 = String.format("B%.2f", M[1]);
							price.setText(TK2);
	                    	}
	                    	else if(CB[1].isSelected()){
	                    	M[1] = BTP - 5;
	                        TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	else if(CB[2].isSelected()){
	                    	M[1] = BTP - 3;
	                 		TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	T[2].setEnabled(true);
	                    	B[0].setEnabled(true);
					}
					else if (CX[0].getSelectedItem().equals("Chiengmai") && CX[1].getSelectedItem().equals("Bangkok")){
						
						timeaog = "10.35";
						timetung = "13.45";
						tontangpaitang = "Chiengmai";
						tontangpaitang2 = "Bangkok";
						
						if(CB[0].isSelected()){
	                        M[1] = BTN - 10;
							TK2 = String.format("B%.2f", M[1]);
							price.setText(TK2);
	                    	}
	                    	else if(CB[1].isSelected()){
	                    	M[1] = BTN - 5;
	                        TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	else if(CB[2].isSelected()){
	                    	M[1] = BTN - 3;
	                 		TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	T[2].setEnabled(true);
	                    	B[0].setEnabled(true);
					}
					
					else if (CX[0].getSelectedItem().equals("Chiengmai") && CX[1].getSelectedItem().equals("Songkra")){
						
						timeaog = "16.15";
						timetung = "19.10";
						tontangpaitang = "Chiengmai";
						tontangpaitang2 = "Songkra";
						if(CB[0].isSelected()){
	                        M[1] = NTP - 10;
							TK2 = String.format("B%.2f", M[1]);
							price.setText(TK2);
	                    	}
	                    	else if(CB[1].isSelected()){
	                    	M[1] = NTP - 5;
	                        TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	else if(CB[2].isSelected()){
	                    	M[1] = NTP - 3;
	                 		TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	T[2].setEnabled(true);
	                    	B[0].setEnabled(true);
					}
					else if (CX[0].getSelectedItem().equals("Songkra") && CX[1].getSelectedItem().equals("Chiengmai")){
						
						timeaog = "09.15";
						timetung = "12.30";
						tontangpaitang = "Songkra";
						tontangpaitang2 = "Chiengmai";
						if(CB[0].isSelected()){
	                        M[1] = NTB - 10;
							TK2 = String.format("B%.2f", M[1]);
							price.setText(TK2);
	                    	}
	                    	else if(CB[1].isSelected()){
	                    	M[1] = NTB - 5;
	                        TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	else if(CB[2].isSelected()){
	                    	M[1] = NTB - 3;
	                 		TK2 = String.format("B%.2f", M[1]);
	    						price.setText(TK2);
	                    	}
	                    	T[2].setEnabled(true);
	                    	B[0].setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please to select");
						price.setText("");
						T[2].setEnabled(false);
					}
                 
				}
			});
	 		getContentPane().add(CX[1]);
					
           // All RadioButton
	 		CB[3] = new JRadioButton("yes");
	 		CB[3].setEnabled(false);
			CB[3].setFont(new Font("Tohama",Font.BOLD,30));
		   	CB[3].setBounds(360, 720, 400, 80);
		   	getContentPane().add(CB[3]);
		   	
		   	CB[4] = new JRadioButton("no");
	 		CB[4].setEnabled(false);
			CB[4].setFont(new Font("Tohama",Font.BOLD,30));
		   	CB[4].setBounds(360, 770, 400, 80);
		   	getContentPane().add(CB[4]);
		   	
		   	CB[0] = new JRadioButton("Children");
			CB[0].setFont(new Font("Tohama",Font.BOLD,20));
		   	CB[0].setBounds(550, 370, 250, 30);
		   	getContentPane().add(CB[0]);
		   	
			CB[1] = new JRadioButton("Adult");
			CB[1].setFont(new Font("Tohama",Font.BOLD,20));
		   	CB[1].setBounds(550, 400, 250, 30);
		   	getContentPane().add(CB[1]);
		   	
			CB[2] = new JRadioButton("Older");
			CB[2].setFont(new Font("Tohama",Font.BOLD,20));
		   	CB[2].setBounds(550, 430, 250, 30);
		   	getContentPane().add(CB[2]);
		   	
		   	CB[0].addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   int result = JOptionPane.showConfirmDialog(
					            CB[0], "Are you sure ?\nif You pressed yes ,You don't have Edit.", " Children ",
					            JOptionPane.YES_NO_OPTION);
					        if (result == JOptionPane.YES_OPTION)
					        {
					        	   CB[1].setEnabled(false);
					   	    	   CB[2].setEnabled(false);
					   	    	 CB[0].setEnabled(false);
					   	    	   T[0].setEnabled(true);
					   	    	 T[1].setEnabled(true);
					   	    	CX[0].setEnabled(true);
					   	    	CX[1].setEnabled(true);
					   	    	   	  				   	       
					        }
					        else if (result == JOptionPane.NO_OPTION){
					          	CB[0].setSelected(false);
		   	     
				   }
				   }
			  });
			CB[1].addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   int result = JOptionPane.showConfirmDialog(
					            CB[1], "Are you sure ?\nif You pressed yes ,You don't have Edit.", " Adult ",
					            JOptionPane.YES_NO_OPTION);
					        if (result == JOptionPane.YES_OPTION)
					        {
					        	   CB[0].setEnabled(false);
					   	    	   CB[2].setEnabled(false);
					   	    	 CB[1].setEnabled(false);
					   	    	   T[0].setEnabled(true);
					   	    	 T[1].setEnabled(true);
					   	    	CX[0].setEnabled(true);
					   	    	CX[1].setEnabled(true);
					   	    	
					   	    			   	    					   	 				 
					        }
					        else if (result == JOptionPane.NO_OPTION){
					        	CB[1].setSelected(false);
		   	     
				   }
				   }
			  });
			CB[2].addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   int result = JOptionPane.showConfirmDialog(
					            CB[2], "Are you sure ?\nif You pressed yes ,You don't have Edit.", " Older ",
					            JOptionPane.YES_NO_OPTION);
					        if (result == JOptionPane.YES_OPTION)
					        {
					        	   CB[0].setEnabled(false);
					   	    	   CB[1].setEnabled(false);
					   	    	 CB[2].setEnabled(false);
					   	    	   T[0].setEnabled(true);
					   	    	 T[1].setEnabled(true);
					   	    	CX[0].setEnabled(true);
					   	    	CX[1].setEnabled(true);
					   	    
					        }
					        else if (result == JOptionPane.NO_OPTION){
					        	CB[2].setSelected(false);
		   	     
				   }
				   }
			  });
		   	
			B[0] = new JButton("Pay");
			B[0].setEnabled(false);
			B[0].setFont(new Font("Tohama",Font.BOLD,20));
			B[0].setBounds(850, 880, 100, 50);
			B[0].addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   
					   M[0] = Double.parseDouble(T[2].getText()); 
					  // M[1] = Double.parseDouble(price.getText());

					     
					   ST[0] = String.format("B%.2f", - M[1] + M[0]);
					   
					   if(M[0] >= M[1]){
						   JOptionPane.showMessageDialog(null,"You have buy a train tricket Successfully.");
						   T[3].setText(ST[0]);
						   CB[3].setEnabled(true);
						   CB[4].setEnabled(true);
					   }
					   else {
						   JOptionPane.showMessageDialog(null,"Sorry, You don't have enough money.");
					   T[3].setText("");
					   CB[3].setEnabled(false);
					   CB[4].setEnabled(false);
					   }
					   
				
				   }
			});
			
			CB[3].addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					  
					 
					        if (CB[3].isSelected())
					        {
					        	  
					               for (int i = 1; i <= 10; i++) {
					            	   random = 1 + ( int ) ( Math.random() * 6 );
					               }

		    					srandom=(Integer.toString(random));
		    					
		    					seatrandom =  1 + ( int ) ( Math.random() * 50 );
		    					seatno =(Integer.toString(seatrandom));
		    					statticket = "Cancel";
		    					CB[4].setSelected(false);
		    					B[0].setEnabled(false);
					   	    			   	    					   	 				 
					        }
					        				
					        else {
					        	CB[3].setSelected(false);
					        }
					   
				   }
			  });
			CB[4].addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					  
					
					      
					     if (CB[4].isSelected())
					        {
					    	  for (int i = 1; i <= 10; i++) {
				            	   random = 1 + ( int ) ( Math.random() * 6 );
				               }

		    					srandom=(Integer.toString(random));
		    					
		    					seatrandom =  1 + ( int ) ( Math.random() * 50 );
		    					seatno =(Integer.toString(seatrandom));
		    					statticket = "Successfully";
					        	CB[3].setSelected(false);        	
					        	B[0].setEnabled(false);
				   }
					     
					     else{
					    	 CB[4].setSelected(false);
					     }
				   }
			  });
		   	
			
			getContentPane().add(B[0]);
			
			
			btnReset = new JButton("Reset");
			btnReset.setFont(new Font("Tohama",Font.BOLD,20));
			btnReset.setBounds(1050, 880, 100, 50);
			 getContentPane().add(btnReset);
			
			 btnReset.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent event) {
					   T[0].setEnabled(false);
					   T[1].setEnabled(false);
					   CB[0].setEnabled(true);
		   	    	   CB[1].setEnabled(true);
		   	    	   CB[2].setEnabled(true);
		   	    	CB[0].setSelected(false);
		   	    	CB[1].setSelected(false);
		   	    	CB[2].setSelected(false);
					   CB[3].setSelected(false);
					   CB[3].setEnabled(false);
					   CB[4].setSelected(false);
					   CB[4].setEnabled(false);
					   T[0].setText("");
					   T[1].setText("");
					   T[2].setText("");
					   price.setText("");
					   T[3].setText("");
					   CX[0].setEnabled(false);
					   CX[0].setSelectedIndex(3);
					   CX[1].setEnabled(false);
					   CX[1].setSelectedIndex(3);
				   }
			 });
			 
		  	//Table2
		   
			  JTable table30 = new JTable ( model5 );
			  model5.setColumnIdentifiers(colomns5);
			  table30.setModel(model5);
			  table30.setRowHeight(35);

				table30.setAutoResizeMode ( JTable.AUTO_RESIZE_ALL_COLUMNS );


				TableColumnModel columnMode = table30.getColumnModel ( );
				TableColumn columnsecond = columnMode.getColumn ( 4 );

				columnsecond.setPreferredWidth (80);
				columnsecond.setResizable ( false );
				 
				 
				TableColumnModel columnMode1 = table30.getColumnModel ( );
				TableColumn columnthird = columnMode1.getColumn ( 2 );

				columnthird.setPreferredWidth ( 80);
				columnthird.setResizable ( false );
					 
			
				TableColumnModel columnMode3 = table30.getColumnModel ( );
				TableColumn columnfive = columnMode3.getColumn ( 3 );

				columnfive.setPreferredWidth (85);
				columnfive.setResizable ( false );
							 
				 TableColumnModel columnMode4 = table30.getColumnModel ( );

					TableColumn columnsix = columnMode4.getColumn ( 5 );

					columnsix.setPreferredWidth (90);
					 columnsix.setResizable ( false );
					 
					 
					 TableColumnModel columnMode5 = table30.getColumnModel ( );

						TableColumn columnseven = columnMode5.getColumn ( 6 );

						columnseven.setPreferredWidth (100);
						 columnseven.setResizable ( false );	
						 
							TableColumnModel columnMode6 = table30.getColumnModel ( );
							TableColumn columneight = columnMode6.getColumn ( 7 );

							columneight.setPreferredWidth (40);
							columneight.setResizable ( false );	 
							
							
							TableColumnModel columnMode7 = table30.getColumnModel ( );
							TableColumn columnnine = columnMode7.getColumn ( 0 );

							columnnine.setPreferredWidth (80);
							columnnine.setResizable ( false );
							
							TableColumnModel columnMode8 = table30.getColumnModel ( );
							TableColumn columnten = columnMode8.getColumn ( 1 );

							columnten.setPreferredWidth (80);
							columnten.setResizable ( false );

							TableColumnModel columnMode9 = table30.getColumnModel ( );
							TableColumn columneleven = columnMode9.getColumn ( 8 );

							columneleven.setPreferredWidth (80);
							columneleven.setResizable ( false );

							
							  JScrollPane scrollPane3 = new JScrollPane(table30);
							  scrollPane3.setBounds(800, 445, 964,415);
							  getContentPane().add(scrollPane3);
							 
							   n = new JButton("Add");
							   n.setFont(new Font("Tohama",Font.BOLD,20));
							  Object [] row2 = new Object[12];
							  n.addActionListener(new ActionListener() {
							   public void actionPerformed(ActionEvent event) {
							

									 
								   if(RegisterTrain2()) {
										JOptionPane.showMessageDialog(null,
												"Congratulation!!! You have payment successfully.");
								   row2[0] = T[0].getText();
								   row2[1] = T[1].getText();
								   empsal.setText(tontangpaitang);
								   row2[2] = empsal.getText();
								   empid.setText(tontangpaitang2);
								   row2[3] = empid.getText();
								   price.setText(TK2);
								   row2[4] = price.getText();
								   aog.setText(timeaog);
								   row2[5] = aog.getText();
								   tung.setText(timetung);
								   row2[6] = tung.getText(); 
								   train.setText(srandom);
								   row2[7]=train.getText();
								   seat.setText(seatno);
								   row2[8]=seat.getText();
								   ticketstat.setText(statticket);
								   row2[9]=ticketstat.getText();
								   Time.setText(currentDate);
								   row2[10]=Time.getText();
								   B[0].setEnabled(false);	
								   
								   
								   if (table30.getSelectedRow() >= 0 )
								   model5.insertRow (table30.getSelectedRow(),
					                        new java.util.Vector());
								   model5.addRow(row2);
								   }
						      
						   }		   
						   
						  });
						  
							  
							  n.setBounds(1650, 880, 100, 50);			  
								 getContentPane().add(n);
							  
								// save Table
							  JButton jbtSave = new JButton("Save");
							    jbtSave.setFont(new Font("Tohama",Font.BOLD,20));
				
						        jbtSave.addActionListener(new ActionListener() {
						            public void actionPerformed(ActionEvent e) {
						                saveTable();
						            }
						        });
							    jbtSave.setBounds(1250, 880, 100, 50);			  
								 getContentPane().add(jbtSave);
												  
								
							 
							 n2 = new JButton("Check");
							    n2.setBounds(1450,880,100,50);
							    n2.setFont(new Font("Tohama", Font.BOLD, 20));
							    getContentPane().add(n2);
											 
							    
							 n2.addActionListener(new ButtonListener());
					
	}
	
	
	
	private Boolean RegisterTrain2()
	{	
		
		String strN = T[0].getText();
		String strL = T[1].getText();
		String start = empsal.getText();
		String prices = price.getText();
		String Mon = T[2].getText();
		String Bans = T[3].getText();
		String Ban2 = CB[3].getText();
		
		if(strN.equals("")) // First Name
		{
			JOptionPane.showMessageDialog(null,
					"Please select one choice from Three"
					+ "\nPlease Input (First Name)");
			T[0].requestFocus(); 
			return false;
		}	
		
		if(strL.equals("")) // Last Name
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Last Name)");
			T[1].requestFocusInWindow(); 
			return false;
		}	
		
		
		if(prices.equals("")) // Start
		{
			JOptionPane.showMessageDialog(null,
					"Please to Choose Start and destiny");
			empid.requestFocusInWindow(); 
			return false;
		}
		if(Mon.equals("")) // Money
		{
			JOptionPane.showMessageDialog(null,
					"Please to Input(Money)");
			T[2].requestFocusInWindow(); 
			return false;
		}

		if(Bans.equals("")) // Balance
		{
			JOptionPane.showMessageDialog(null,
					"Please to press pay and choose ticket");
			T[3].requestFocusInWindow(); 
			return false;
		}
		
		
		return rootPaneCheckingEnabled;
	}
	
	
	public static void main(String[] args) 
	{
		TrainStation2 TS3 = new TrainStation2();
		TS3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TS3.setVisible(true);
		TS3.setSize(1900,1000);
		TS3.setLocation(10,10);
		TS3.setResizable(true);
	}
	
	public class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == n2)
				{
					 Special S = new Special("Special Train");
				       S.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				       S.setVisible(true);
				       S.setSize(1920,1000);
				       S.setLocation(10,10);

				}
				
			
			}

	}
}