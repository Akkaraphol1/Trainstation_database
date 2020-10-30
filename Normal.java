import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class Normal extends JFrame{

	private JLabel LB[] = new JLabel[12]; 
	JLabel imageLabel,imageLabel2;
	public JLabel img;

	
	private JButton TTT ;
	private JButton[] n = new JButton[5];
	private Image image = null;
	private Image image2 = null;
	private JButton send ;
	
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
	     
	  
	public Normal(String filename){
		
		getContentPane().setLayout(null);

		myJTable.setBackground(Color.LIGHT_GRAY);
        myJTable.setForeground(Color.black);
        Font font = new Font("Tohama", Font.BOLD, 15);
        myJTable.setFont(font);
        myJTable.setRowHeight(40);
		
		 JScrollPane scrollPane3 = new JScrollPane(myJTable);
		  scrollPane3.setBounds(830, 220, 1030,615);
		  getContentPane().add(scrollPane3);
		
		  
		JButton jbtAddRow = new JButton("Add");
		jbtAddRow.setBounds(1140,850,100,50);
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
		jbtSave.setBounds(1340,850,100,50);
	    jbtSave.setFont(new Font("Tohama", Font.BOLD, 20));
	    jbtSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTable();
            }
        });
	    getContentPane().add(jbtSave);
	    
	    
			JButton jbtLoad = new JButton("Load");
			jbtLoad.setBounds(1540,850,100,50);
		    jbtLoad.setFont(new Font("Tohama", Font.BOLD, 20));
		    jbtLoad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                loadTable();
	            }
	        });
		    getContentPane().add(jbtLoad);
	      
		    
		    JButton send = new JButton("send");
			send.setBounds(1740,850,100,50);
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
	 
		  ImageIcon image = new ImageIcon("C:/Users/User/workspace/TrainStation/img/NTR.png");
	       JLabel imageLabel = new JLabel(image); 
	       imageLabel.setBounds(10, 10, 1880, 200);
	       imageLabel.setVisible(true);
	       getContentPane().add(imageLabel);	   
		   
	       ImageIcon image2 = new ImageIcon("C:/Users/User/workspace/TrainStation/img/NTGS.png");
	       JLabel imageLabel2 = new JLabel(image2); 
	       imageLabel2.setBounds(10, 160, 800, 800);
	       imageLabel2.setVisible(true);
	       getContentPane().add(imageLabel2);	 
	       
	      n[0] = new JButton("Go");
	      n[0].setBounds(940,850,100,50);
	      n[0].setFont(new Font("Tohama", Font.BOLD, 20));
	      getContentPane().add(n[0]); 
	       
	      n[0].addActionListener(new ButtonListener());     
	      
	     
		}
			
	public void paint(Graphics g){
	     super.paint(g);
	    
	     g.setColor(Color.BLUE);
	     g.drawRect(822, 250, 1075, 695); 
	     
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Normal N = new Normal("Special Train");
       N.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       N.setVisible(true);
       N.setSize(1920,1000);
       N.setLocation(10,10);
	}
	
	  public class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == n[0])
				{
					 Trainthree T = new Trainthree("Welcome to Trainstaion");
					   T.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					   T.setSize(1520,1000);
					   T.setVisible(true);
					   T.setLocation(300, 10);
					 
					   
				}
			}
	  }

}
