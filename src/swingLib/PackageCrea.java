package swingLib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import librairie.Event;
import librairieDAO.EventDAO;
import librairieDAO.PackageDAO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import librairie.Package;

public class PackageCrea extends JFrame {

	private JPanel contentPane;
	private JTextField trackerTxt;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection connection;
 	private ResultSet result;
 	private Statement state;
 	private String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;";
 	
    private String username = "sa"; 
    private String password = "sa"; 
      ImageIcon img = new ImageIcon("image4.png");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PackageCrea frame = new PackageCrea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PackageCrea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 366);
                setTitle("Book Shop"); 
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lbl1 = new JLabel("Cr\u00E9ation d'un package");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.gridwidth = 3;
		gbc_lbl1.insets = new Insets(0, 0, 5, 0);
		gbc_lbl1.anchor = GridBagConstraints.WEST;
		gbc_lbl1.gridx = 2;
		gbc_lbl1.gridy = 0;
		contentPane.add(lbl1, gbc_lbl1);
		
		JLabel lblid = new JLabel("Id");
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.gridx = 1;
		gbc_lblid.gridy = 2;
		contentPane.add(lblid, gbc_lblid);
		
		JLabel lblidD = new JLabel("En cours d'attribution");
		GridBagConstraints gbc_lblidD = new GridBagConstraints();
		gbc_lblidD.insets = new Insets(0, 0, 5, 0);
		gbc_lblidD.gridx = 4;
		gbc_lblidD.gridy = 2;
		contentPane.add(lblidD, gbc_lblidD);
		
		JLabel lblTrack = new JLabel("Tracker");
		GridBagConstraints gbc_lblTrack = new GridBagConstraints();
		gbc_lblTrack.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrack.gridx = 1;
		gbc_lblTrack.gridy = 3;
		contentPane.add(lblTrack, gbc_lblTrack);
		
		trackerTxt = new JTextField();
		GridBagConstraints gbc_trackerTxt = new GridBagConstraints();
		gbc_trackerTxt.insets = new Insets(0, 0, 5, 0);
		gbc_trackerTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_trackerTxt.gridx = 4;
		gbc_trackerTxt.gridy = 3;
		contentPane.add(trackerTxt, gbc_trackerTxt);
		trackerTxt.setColumns(10);
		
		JLabel lblDate = new JLabel("Date de Livraison");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 4;
		contentPane.add(lblDate, gbc_lblDate);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCom = new JLabel("Commentaire");
		GridBagConstraints gbc_lblCom = new GridBagConstraints();
		gbc_lblCom.insets = new Insets(0, 0, 5, 5);
		gbc_lblCom.gridx = 1;
		gbc_lblCom.gridy = 5;
		contentPane.add(lblCom, gbc_lblCom);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 5;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStatus = new JLabel("Statut Livraison");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 1;
		gbc_lblStatus.gridy = 7;
		contentPane.add(lblStatus, gbc_lblStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(initStatutModel());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 7;
		contentPane.add(comboBox, gbc_comboBox);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 10;
		contentPane.add(panel, gbc_panel);
		
		CancelButton btnCancel = new CancelButton();
		
	
		panel.add(btnCancel);
		
		JButton btnFwButton = new JButton("Suivant");
		btnFwButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tracker = trackerTxt.getText();
					String date = textField_1.getText();
					String comm = textField_2.getText();
					
					PackageDAO e1;
					e1 = new PackageDAO();
					Package p1 = new Package(tracker, date, (comm != null ? comm : ""));
					e1.createPackage(p1);
					/*
					 * Long iden = e1.getId(p1); lblidD.setText(iden.toString());
					 */
					/*
					 * Ã  insÃ©rer dans : String query =[dbo].[ASSOC_STATUS_PACKAGE]
					 * ([PACKAGE_STATUS_ID] ,[PACKAGE_ID] ,[ASSOC_STATUS_PACKAGE_DATE]
					 * ,[ASSOC_STATUS_PACKAGE_POST_IT])
					 */
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
			}
		});
		btnFwButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnFwButton);
	}
	
	private Vector initStatutVector() {
		Vector statut = new Vector(); 
		statut.add("-- FaÃ®tes votre choix --");
		
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

//Vdsvl32254343823", "02-03-2020" ,"ras"
}
