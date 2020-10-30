package swingLib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import librairie.Author;
import librairie.Event;
import librairieDAO.AuthorDAO;
import librairieDAO.EventDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EventCrea extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtfacultatif;
	private JTextField remiseTxt;
        ImageIcon img = new ImageIcon("image4.png");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventCrea frame = new EventCrea();
					frame.setVisible(true);
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventCrea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
                setTitle("Book Shop"); 
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{68, 46, 247, 0};
		gbl_contentPane.rowHeights = new int[]{36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lbl1 = new JLabel("Cr\u00E9ation d'un \u00E9venement");
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel.add(lbl1);
		
		JLabel lblId = new JLabel("");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 2;
		contentPane.add(lblId, gbc_lblId);
		
		JLabel lblNewLabel_5 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 2;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblName = new JLabel("Nom de l'event");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		contentPane.add(lblName, gbc_lblName);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 4;
		contentPane.add(lblDate, gbc_lblDate);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDateFin = new JLabel("Date de fin");
		GridBagConstraints gbc_lblDateFin = new GridBagConstraints();
		gbc_lblDateFin.anchor = GridBagConstraints.EAST;
		gbc_lblDateFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateFin.gridx = 1;
		gbc_lblDateFin.gridy = 5;
		contentPane.add(lblDateFin, gbc_lblDateFin);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 5;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL ");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.anchor = GridBagConstraints.EAST;
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 1;
		gbc_lblUrl.gridy = 6;
		contentPane.add(lblUrl, gbc_lblUrl);
		
		txtfacultatif = new JTextField();
	
		GridBagConstraints gbc_txtfacultatif = new GridBagConstraints();
		gbc_txtfacultatif.insets = new Insets(0, 0, 5, 0);
		gbc_txtfacultatif.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfacultatif.gridx = 2;
		gbc_txtfacultatif.gridy = 6;
		contentPane.add(txtfacultatif, gbc_txtfacultatif);
		txtfacultatif.setColumns(10);
		
		JLabel lblRemise = new JLabel("Remise");
		GridBagConstraints gbc_lblRemise = new GridBagConstraints();
		gbc_lblRemise.anchor = GridBagConstraints.EAST;
		gbc_lblRemise.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemise.gridx = 1;
		gbc_lblRemise.gridy = 7;
		contentPane.add(lblRemise, gbc_lblRemise);
		
		remiseTxt = new JTextField();
		remiseTxt.setText(".");
		GridBagConstraints gbc_remiseTxt = new GridBagConstraints();
		gbc_remiseTxt.insets = new Insets(0, 0, 5, 0);
		gbc_remiseTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_remiseTxt.gridx = 2;
		gbc_remiseTxt.gridy = 7;
		contentPane.add(remiseTxt, gbc_remiseTxt);
		remiseTxt.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 9;
		contentPane.add(panel_1, gbc_panel_1);
		
		CancelButton btnCancel = new CancelButton();
		panel_1.add(btnCancel);
		
		JButton btnFollow = new JButton("Suivant");
		panel_1.add(btnFollow);
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					try {
						String nom = textField_1.getText();
						String date = textField_2.getText();
						String dateFin = textField_3.getText();
						String remise = remiseTxt.getText();
						double rem = Double.parseDouble(remise);
						String url = txtfacultatif.getText();
						EventDAO e1;
						e1 = new EventDAO("jdbc:sqlserver://localhost:1433;databaseName=BookShop;", "sa", "sa");
                                                Event eC = new Event(nom, date, dateFin, rem, url != null ? url : "");
						e1.createEvent(eC);
						dispose();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
	    		
			}
		});
		
	}
	 

}
