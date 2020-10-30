package swingLib;

import javax.swing.JPanel;


	import javax.swing.JPanel;
	import javax.swing.JScrollPane;

	import java.awt.Color;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;

	import javax.swing.DefaultComboBoxModel;
	import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
	import javax.swing.table.AbstractTableModel;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.table.TableModel;

	import librairie.Author;
import librairie.Event;
import librairieDAO.EventDAO;

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
import java.awt.Font;
import java.awt.Insets;


		

		

		public class EventSearch extends JPanel {
			private JTextField nameTxt;
			private JTextField dateTxt;
			private String entreeNom;
			private String 	entreeDate;
			final ImageIcon icon = new ImageIcon("icone.png");
		    Image image2 = icon.getImage().getScaledInstance(32,32,0);
		    private Connection connection;
		 	private ResultSet result;
		 	private Statement state;
		 	private String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;"; 
		    private String username = "sa"; 
		    private String password = "sa"; 
			
		
		
			public EventSearch() throws SQLException {
				setBackground(Color.WHITE);
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{74, 0, 301, 0};
				gridBagLayout.rowHeights = new int[]{27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				setLayout(gridBagLayout);
				
				JLabel lbl1 = new JLabel("Recherche d'un Evenement");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 22));
				GridBagConstraints gbc_lbl1 = new GridBagConstraints();
				gbc_lbl1.insets = new Insets(0, 0, 5, 5);
				gbc_lbl1.anchor = GridBagConstraints.NORTHWEST;
				gbc_lbl1.gridx = 1;
				gbc_lbl1.gridy = 0;
				add(lbl1, gbc_lbl1);
				
				JLabel lblName = new JLabel("par Nom : ");
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.anchor = GridBagConstraints.EAST;
				gbc_lblName.gridx = 0;
				gbc_lblName.gridy = 2;
				add(lblName, gbc_lblName);
				
				nameTxt = new JTextField();
				GridBagConstraints gbc_nameTxt = new GridBagConstraints();
				gbc_nameTxt.insets = new Insets(0, 0, 5, 5);
				gbc_nameTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_nameTxt.gridx = 1;
				gbc_nameTxt.gridy = 2;
				add(nameTxt, gbc_nameTxt);
				nameTxt.setColumns(10);
				
				JLabel lblDate = new JLabel("par Date :");
				GridBagConstraints gbc_lblDate = new GridBagConstraints();
				gbc_lblDate.anchor = GridBagConstraints.EAST;
				gbc_lblDate.insets = new Insets(0, 0, 5, 5);
				gbc_lblDate.gridx = 0;
				gbc_lblDate.gridy = 4;
				add(lblDate, gbc_lblDate);
				
				dateTxt = new JTextField();
				GridBagConstraints gbc_dateTxt = new GridBagConstraints();
				gbc_dateTxt.insets = new Insets(0, 0, 5, 5);
				gbc_dateTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_dateTxt.gridx = 1;
				gbc_dateTxt.gridy = 4;
				add(dateTxt, gbc_dateTxt);
				dateTxt.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Evenement :");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 6;
				add(lblNewLabel, gbc_lblNewLabel);
				
				JComboBox EventcomboBox = new JComboBox();
				EventcomboBox.setModel(initNomModel());
				EventcomboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						entreeNom = EventcomboBox.getSelectedItem().toString();
						try {
							EventDAO ed = new EventDAO(); 
							Event eS = ed.searchEvent(entreeNom);
							JOptionPane.showMessageDialog(new JFrame(), eS , "Résultat recherche",  JOptionPane.WARNING_MESSAGE,  new ImageIcon(image2));
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				});
				GridBagConstraints gbc_EventcomboBox = new GridBagConstraints();
				gbc_EventcomboBox.insets = new Insets(0, 0, 5, 5);
				gbc_EventcomboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_EventcomboBox.gridx = 1;
				gbc_EventcomboBox.gridy = 6;
				add(EventcomboBox, gbc_EventcomboBox);
				
				CancelButton cclButton = new CancelButton();
				GridBagConstraints gbc_cclButton = new GridBagConstraints();
				gbc_cclButton.anchor = GridBagConstraints.EAST;
				gbc_cclButton.insets = new Insets(0, 0, 0, 5);
				gbc_cclButton.gridx = 1;
				gbc_cclButton.gridy = 9;
				add(cclButton, gbc_cclButton);
				
				JButton btnFollow = new JButton("Suivant");
				btnFollow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						entreeNom = nameTxt.getText();
						entreeDate = dateTxt.getText(); 
						if( entreeNom!= null) {
							try {
							EventDAO ed = new EventDAO(); 
							Event eS = ed.searchEvent(entreeNom);
							JOptionPane.showMessageDialog(new JFrame(), eS , "Résultat recherche",  JOptionPane.WARNING_MESSAGE,  new ImageIcon(image2));
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else if(entreeDate != null) {
						
							EventDAO ed;
							try {
								ed = new EventDAO();
							Event eS = ed.searchEventDate(entreeDate);
							JOptionPane.showMessageDialog(new JFrame(), eS , "Résultat recherche",  JOptionPane.WARNING_MESSAGE,  new ImageIcon(image2));
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
						}else {
							JOptionPane.showMessageDialog(new JFrame(), "Champ de recherche vide !", "Erreur Recherche",  JOptionPane.WARNING_MESSAGE,  new ImageIcon(image2));
						}
					}
				});
				GridBagConstraints gbc_btnFollow = new GridBagConstraints();
				gbc_btnFollow.anchor = GridBagConstraints.WEST;
				gbc_btnFollow.gridx = 2;
				gbc_btnFollow.gridy = 9;
				add(btnFollow, gbc_btnFollow);
				
			}
			private DefaultComboBoxModel initNomModel() {

				return new DefaultComboBoxModel(initNomVector());
			}
			
			private Vector initNomVector() {
				Vector nameEvent = new Vector(); 
				nameEvent.add("-- Faîtes votre choix --");
				
				 try {
					connection = DriverManager.getConnection(url, username, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       String query = "SELECT * from Event ";
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
						nameEvent.add(result.getString("EVENT_NAME"));
					   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return nameEvent;
			}

		
	public static void main (String []args) throws SQLException {
		
		EventSearch e1 = new EventSearch(); 
		fenetreLib f1 = new fenetreLib(); 
		
		f1.add(e1); 
	}
		
		
		
		}
			
			