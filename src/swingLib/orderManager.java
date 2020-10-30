package swingLib;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import librairie.Address;
import librairie.Author;
import librairie.Customer;
import librairie.Order;
import librairie.OrderStatus;
import librairie.ShippingOffer;

import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pdfTest.PdfConstructor;
import pdfTest.TestConstructeur;
import pdfTest.TestIText1;

public class orderManager extends JPanel {
	private JTextField IdTxt;
	private JTextField debDateTxt;
	private JTextField finDateTxt;
	private JTextField trackTxt;
	
	private JTable table;
	
	//connexion Bdd
	private Connection connection;
 	private ResultSet result;
 	private Statement state;
 	private String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;";	
    private String username = "sa"; 
    private String password = "sa"; 
    
    //outils de recherche
    private String research = ""; 
	private String requete = ""; 
	private  ArrayList<Order> orderL;
	private String sql;
	private Statement stmt;
	private String entreeId;
	private String entreeDate;
	private String entreeTracker;
	int ent;
	int ent1;
	private String status;
	private String requete2;
	private long orderId;
	private int status_id;
	private int orderStatusId;
	private OrderStatus os;
        final ImageIcon icon = new ImageIcon("icone.png");
	Image image2 = icon.getImage().getScaledInstance(32,32,0);
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public orderManager() throws SQLException {
		
		JLabel lbl1 = new JLabel("Gestionnaire de commande");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lbl2 = new JLabel("S\u00E9lection commande");
		
		JLabel lblId = new JLabel("par Id");
		
		JLabel lblDate = new JLabel("par Date");
		
		JLabel lblADate = new JLabel("\u00E0");
		
		JLabel lblTracker = new JLabel("par Client ID");
		
		JLabel lblStatus = new JLabel("par Statut");
		
		IdTxt = new JTextField();
		IdTxt.setColumns(10);
		
		debDateTxt = new JTextField();
		debDateTxt.setColumns(10);
		
		finDateTxt = new JTextField();
		finDateTxt.setColumns(10);
		
		trackTxt = new JTextField();
		trackTxt.setColumns(10);
		
		
		//Méthode de recherche à faire 
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 status = comboBox.getSelectedItem().toString(); 
				 String requete = "SELECT * from ORDER_STATUS where ORDER_STATUS_NAME= '" + status + "'" ;
				 try {
						connection = DriverManager.getConnection(url, username, password);
						stmt = connection.createStatement();
						result = stmt.executeQuery(requete);
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				 try {
					while (result.next())
					 {
						orderStatusId = result.getInt("ORDER_STATUS_ID");
					
					     }
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}				
				 
				 String requete2 = "SELECT * from  ASSOC_STATUS_ORDER where ORDER_STATUS_ID = '" +  orderStatusId + "'" ;
				 ArrayList<Long> orderIdList = new ArrayList();
				 				 try {
				 						connection = DriverManager.getConnection(url, username, password);
				 						stmt = connection.createStatement();
				 						result = stmt.executeQuery(requete2);
				 						
				 					} catch (SQLException e1) {

				 						e1.printStackTrace();
				 					}
				 				 try {
				 					while (result.next())
				 					 {
				 						orderIdList.add(result.getLong("ORDER_ID"));
				 					
				 					     }
				 				} catch (SQLException e2) {
				 					// TODO Auto-generated catch block
				 					e2.printStackTrace();
				 				}				
				 				 
				 for (Long orderId : orderIdList) {
					 sql = "SELECT * from [ORDER] where [ORDER_ID]= '" + orderId + "'" ;
					 
				 }
				 
				 
				 //---------------------Modele JTable
									try {
										table.setModel(getDefaultTableModel());
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
						
			}});
			
		
		comboBox.setModel(initStatutModel() );
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Commande pr\u00E9visualisation", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		
		//Problème avec ma méthode par recherche client
		JButton btnSearch = new JButton("Rechercher");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entreeId = IdTxt.getText();
				entreeDate = debDateTxt.getText();
				entreeTracker = trackTxt.getText();
						
				try {
					if (entreeId != null) {
						
						 research = getEntreeId();
						 ent = Integer.parseInt(research);
						 sql = "SELECT * from [ORDER] where [ORDER_ID]= '" + ent + "'" ;
						 
						}else if (entreeDate != null) {
							 research = getEntreeDate();
							 sql = "SELECT * from [ORDER] where [ORDER_CREATION_DATE] = '" + research + "'" ;
							
						 }else if (entreeTracker != null){
							 entreeTracker = trackTxt.getText();
							 research = getEntreeTracker();
							 ent1 = Integer.parseInt(research);
							 sql = "SELECT * from [ORDER] where [CUSTOMER_ID] = '" + ent1 + "'" ;
							
						 }else {
							
							 sql = "SELECT * from [ORDER]"; 
							
							
						 }
					
					table.setModel(getDefaultTableModel());
					research = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		CancelButton btnAnnuler = new CancelButton();
		
		
		JButton btnEdition = new JButton("Editer");
		btnEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TestIText1();
                             JOptionPane.showMessageDialog(new JFrame(), "Bon de commande edite", "Edition Bon de commande",  JOptionPane.WARNING_MESSAGE,  new ImageIcon(image2));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(271)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdition)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTracker)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(trackTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDate)
									.addGap(22)
									.addComponent(debDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblADate)
									.addGap(18)
									.addComponent(finDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblId)
									.addGap(32)
									.addComponent(IdTxt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStatus)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSearch)
							.addGap(80))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl1))
					.addContainerGap(187, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lbl1)
					.addGap(18)
					.addComponent(lbl2)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(IdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(lblADate)
						.addComponent(finDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(debDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTracker)
						.addComponent(trackTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdition))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		
		
		
		Object[][] data = new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			};
			String [] titre = {"ID Commande", "ID Client", "Date commande", "Date livraison", "Prix HT livraison"}
		;
			
		table = new JTable();
		table.setModel(getDefaultInitTableModel());
		/*
		 * add(table.getTableHeader(), BorderLayout.NORTH); add(table,
		 * BorderLayout.CENTER);
		 */
		scrollPane.add(table);
		scrollPane.setRowHeaderView(table);
		setLayout(groupLayout);

		 
		setLayout(groupLayout);
		
	}
        
        
	
	private Vector initStatutVector() {
		Vector statut = new Vector(); 
		statut.add("-- Faîtes votre choix --");
		
		 try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       String query = "SELECT * from Package_Status ";
	       try {
			state = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       try {
			result = state.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       try {
			while (result.next()) {
			   statut.add(result.getString("package_status_name"));
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statut;
	}


private DefaultComboBoxModel initStatutModel() {

	return new DefaultComboBoxModel(initStatutVector());
}


public String getEntreeId() {
	return entreeId;
}

public void setEntreeId(String entreeId) {
	this.entreeId = entreeId;
}

public String getEntreeDate() {
	return entreeDate;
}

public void setEntreeDate(String entreeDate) {
	this.entreeDate = entreeDate;
}

public String getEntreeTracker() {
	return entreeTracker;
}

public void setEntreeTracker(String entreeTracker) {
	this.entreeTracker = entreeTracker;
}





public DefaultTableModel getDefaultTableModel() throws SQLException{
    
    Vector<String> columnNames = new Vector<>();
    Vector<Vector> data = new Vector<>();
    
    //Vector<Category> categories = new Vector(categoryDAO.getAll());
    
    columnNames.add("ID Commande");
    columnNames.add("ID Client");
    columnNames.add("Date commande");
    columnNames.add("Date livraison");
    columnNames.add("Prix HT livraison");
   
orderL = getOrder();

for(Order order : orderL){
	/*
	 * public Order(Long id, Customer customer, Address adresseLiv, Address
	 * adresseBil, ShippingOffer shipping, String dateOrder, String dateLivraison,
	 * String ipCustomer, String commentaire, double priceTaxFree) { this.id = id;
	 * this.customer = customer; this.adresseLiv = adresseLiv; this.adresseBil =
	 * adresseBil; this.shipping = shipping; this.dateOrder = dateOrder;
	 * this.dateLivraison = dateLivraison; this.ipCustomer = ipCustomer;
	 * this.commentaire = commentaire; this.priceTaxFree = priceTaxFree; }
	 */
        Vector<Object> row = new Vector<>();
        row.add(order.getId());
        row.add(order.getCustomerId());
		/*
		 * row.add(order.getAdresseLiv()); row.add(order.getAdresseBil());
		 * row.add(order.getShipping());
		 */
        row.add(order.getDateOrder());
        row.add(order.getDateLivraison());
        row.add(order.getPriceTaxFree());
        data.add(row);
    }
  
    
    
    return new DefaultTableModel(data, columnNames);
}

public DefaultTableModel getDefaultInitTableModel(){
    
    Vector<String> columnNamesI = new Vector<>();
    Vector<Vector> dataI = new Vector<>();
    
    //Vector<Category> categories = new Vector(categoryDAO.getAll());
    
    columnNamesI.add("ID Commande");
    columnNamesI.add("ID Client");
    columnNamesI.add("Date commande");
    columnNamesI.add("Date livraison");
    columnNamesI.add("Prix HT livraison");
    
    
        
        Vector<Object> row = new Vector<>();
        row.add("");
        row.add("");
        row.add("");
        row.add("");
        row.add("");
        dataI.add(row);
    
    
    return new DefaultTableModel(dataI, columnNamesI);
}


public ArrayList getOrder() throws SQLException {
	
	
	orderL = new ArrayList();
	 try {
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
			result = stmt.executeQuery(sql);
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
while (result.next())
{orderL.add(new Order(result.getLong("ORDER_ID"), result.getLong("CUSTOMER_ID"), result.getString("ORDER_CREATION_DATE"), result.getString("ORDER_SHIPPING_TIME_LIMIT"), result.getDouble("ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE")));
  System.out.print(orderL);

    }
System.out.println(orderL);
return orderL;
}

public static void main(String [] args) throws SQLException {
	fenetreLib f1 = new fenetreLib(); 
	orderManager od = new orderManager();
	od.setVisible(true);

	f1.getContentPane().add(od); 
	f1.setVisible(true);
}
}
