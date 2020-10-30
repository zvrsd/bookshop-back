package swingLib;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import librairie.Author;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class authorJPanel extends JPanel {
	private JTextField NameTxt;
	private JTextField firstnameTxt;
	private JTextField clueTxt;
	private Connection connection;
 	private ResultSet result;
 	private Statement state;
 	private String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;"; 
    private String username = "sa"; 
    private String password = "sa"; 
    private JTable table;
    private  ArrayList titre = new ArrayList();
    private  ArrayList data = new ArrayList();
    private String entree;
	private String 	entreeF;
    private String entreeC; 
    static ResultSetMetaData md;
    static Statement stmt;
    static ResultSet rs;
    static int columns;
    Vector columnNamesVector;
    Vector dataVector;
    ArrayList subArray;
    Vector subVector;
    ArrayList row;
    String sql;
    ArrayList<Author> authorL;
    String requete = ""; 
 
    
  
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public authorJPanel() throws SQLException {
		setBackground(Color.WHITE);
		
		JLabel lbl1 = new JLabel("Recherche d'un auteur");
		
		JLabel lblName = new JLabel("par Nom");
		
		JLabel lblFirstname = new JLabel("par Prénom");
		
		JLabel lblClue = new JLabel("par Mot-Clef");
		
		NameTxt = new JTextField();
		NameTxt.setColumns(10);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setColumns(10);
		
		clueTxt = new JTextField();
		clueTxt.setColumns(10);
	
		
		JButton btnSearch1 = new JButton("Rechercher");
		btnSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entree = NameTxt.getText();
		
				try {
					table.setModel(getDefaultTableModel());
					entree = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnSearch2 = new JButton("Rechercher");
		btnSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entreeF = firstnameTxt.getText();
			
				try {
					table.setModel(getDefaultTableModel());
					entreeF = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnSearch3 = new JButton("Rechercher");
		btnSearch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entreeC = clueTxt.getText();
				/*
				 * DefaultTableModel dm = (DefaultTableModel) table.getModel(); int rowCount =
				 * dm.getRowCount(); //Remove rows one by one from the end of the table for (int
				 * i = rowCount - 1; i >= 0; i--) { dm.removeRow(i); }
				 */
				try {
					table.setModel(getDefaultTableModel());
					entreeC = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblCbName = new JLabel("par Nom");
		
		
		//ComboBox nom
		JComboBox nameCB = new JComboBox();
		nameCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				entree = nameCB.getSelectedItem().toString();
				try {
					table.setModel(getDefaultTableModel());
					entree = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		nameCB.setModel(initNomModel());

		nameCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JLabel lblCbFirstname = new JLabel("et");
		
		//ComboBox prnom
	
		JComboBox firstNmCB = new JComboBox();
		firstNmCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				entreeF = firstNmCB.getSelectedItem().toString();
				
				try {
					table.setModel(getDefaultTableModel());
					entreeF = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			
			}
		});
		
		firstNmCB.setModel(initFirstModel());
		firstNmCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

			}
		});
		
		JLabel lblCbClue = new JLabel("par Mot-Clef");
		
		//ComboBox clue
		
		JComboBox<String> clueCB = new JComboBox();
		clueCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				entreeC = clueCB.getSelectedItem().toString();
	
				
				try {
					table.setModel(getDefaultTableModel() );
					entree = null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			
		});
		
		clueCB.setModel(initClueModel());
		clueCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			

			}
		});
		
		CancelButton btnCancel = new CancelButton();
	
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblClue)
								.addComponent(lblFirstname))
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbl1)
								.addComponent(NameTxt, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(firstnameTxt)
								.addComponent(clueTxt))
							.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSearch1)
								.addComponent(btnSearch2)
								.addComponent(btnSearch3)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(23)
									.addComponent(lblCbFirstname))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblCbName, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(firstNmCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(nameCB, 0, 156, Short.MAX_VALUE))
							.addGap(8)
							.addComponent(lblCbClue)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(clueCB, 0, 207, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(416, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(41))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(NameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch1))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFirstname)
							.addGap(18)
							.addComponent(lblClue))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(firstnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(clueTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch3))))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(clueCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCbName)
						.addComponent(lblCbClue))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstNmCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCbFirstname))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancel)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(getDefaultTableModel())
	        ;
		scrollPane.setColumnHeaderView(table);
		setLayout(groupLayout);

	}
	
	private Vector initNomVector() {
		Vector nameAuthor = new Vector(); 
		nameAuthor.add("-- Faîtes votre choix --");
		
		 try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       String query = "SELECT * from Author ";
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
			   nameAuthor.add(result.getString("author_l_name"));
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nameAuthor;
	}


private DefaultComboBoxModel initNomModel() {

	return new DefaultComboBoxModel(initNomVector());
}

private Vector initFirstVector() {
	Vector fnameAuthor = new Vector();
	fnameAuthor.add("-- Faîtes votre choix --");
	
	 try {
		connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       String query = "SELECT * from Author ";
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
			fnameAuthor.add(result.getString("author_f_name"));
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return fnameAuthor;
}

private DefaultComboBoxModel initFirstModel() {
	return new DefaultComboBoxModel(initFirstVector());
}

private Vector initClueVector() {
	Vector clueAuthor = new Vector(); 
	clueAuthor.add("-- Faîtes votre choix --");
	 try {
		connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       String query = "SELECT * from Author ";
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
			clueAuthor.add(result.getString("author_post_it"));
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return clueAuthor;
}

private DefaultComboBoxModel initClueModel() {
	return new DefaultComboBoxModel(initClueVector());
}

public String getEntree() {
	return entree;
}

public void setEntree(String entree) {
	this.entree = entree;
}

public String getEntreeF() {
	return entreeF;
}

public void setEntreeF(String entreeF) {
	this.entreeF = entreeF;
}

public String getEntreeC() {
	return entreeC;
}

public void setEntreeC(String entreeC) {
	this.entreeC = entreeC;
}



public DefaultTableModel getDefaultTableModel() throws SQLException{
    
    Vector<String> columnNames = new Vector<>();
    Vector<Vector> data = new Vector<>();
    
    //Vector<Category> categories = new Vector(categoryDAO.getAll());
    
    columnNames.add("ID");
    columnNames.add("Nom");
    columnNames.add("PrÃ©nom");
    columnNames.add("Commentaires");
   
    authorL = getAuteur();
for(Author author : authorL){
        
        Vector<Object> row = new Vector<>();
        row.add(author.getId());
        row.add(author.getName());
        row.add(author.getFirstname());
        row.add(author.getPostIt());
        data.add(row);
    }
  
    
    
    return new DefaultTableModel(data, columnNames);
}

public ArrayList getAuteur() throws SQLException {
	if (entree != null) {
	 requete = getEntree();
	 sql = "SELECT * FROM Author where author_l_name = '" + requete + "'" ;}else if (entreeF != null) {
		 requete = getEntreeF();
		 sql = "SELECT * FROM Author where author_f_name = '" + requete + "'" ;
	 }else {
		 requete = getEntreeC();
		 sql = "SELECT * FROM Author where author_post_it = '" + requete + "'" ;
	 }
      authorL = new ArrayList<Author>(); 
	  
		// "//author_f_name  author_post_it

try {
	connection = DriverManager.getConnection(url, username, password);
	stmt = connection.createStatement();
} catch (SQLException e1) {

	e1.printStackTrace();
}

try {
	rs = stmt.executeQuery( sql );
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
while (rs.next())
{authorL.add(new Author(rs.getLong("Author_Id"), rs.getString("author_l_name"), rs.getString("author_f_name"), rs.getString("author_post_it")));
  

    }



return authorL;
}

	
public static void main (String []args) throws SQLException {
	authorJPanel p1 = new authorJPanel();
	JFrame f1 = new JFrame(); 
	f1.getContentPane();
	f1.setBounds(240, 240, 580, 580);
	f1.getContentPane().add(p1);
	f1.setVisible(true);
}
}