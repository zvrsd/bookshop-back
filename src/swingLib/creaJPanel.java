package swingLib;


import bookshop.CarrierF;
import bookshop.CarrierListF;
import bookshop.CarrierStatusF;
import bookshop.CarrierStatusList;
import bookshop.PackageStatusF;
import bookshop.PackageStatusList;
import com.nope.bookshop.ui.BookAddJPanel;
import com.nope.bookshop.ui.BookListJPanel;
import com.nope.bookshop.ui.BookStatusAddJPanel;
import com.nope.bookshop.ui.BookStatusListJPanel;
import com.nope.bookshop.ui.CategoryAddJPanel;
import com.nope.bookshop.ui.CategoryListJPanel;
import com.nope.bookshop.ui.KeywordAddJPanel;
import com.nope.bookshop.ui.KeywordListJPanel;
import com.nope.bookshop.ui.PublisherAddJPanel;
import com.nope.bookshop.ui.PublisherListJPanel;
import com.nope.bookshop.ui.VatAddJPanel;
import com.nope.bookshop.ui.VatListJPanel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingUtilities;



public class creaJPanel extends JPanel {
	
    private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public creaJPanel() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, .0, .0, .0, .0, .0, .0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbl1 = new JLabel("Creation");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 2;
		gbc_lbl1.gridy = 1;
		add(lbl1, gbc_lbl1);
		
		JCheckBox chckbxAuteur = new JCheckBox("Auteur");
		chckbxAuteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
				authorCra c1;
				c1 = new authorCra();
				JFrame f1 = new JFrame(); 
				f1.getContentPane().add(c1); 
				f1.setVisible(true);
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				
			}
		});
		buttonGroup.add(chckbxAuteur);
		GridBagConstraints gbc_chckbxAuteur = new GridBagConstraints();
		gbc_chckbxAuteur.anchor = GridBagConstraints.WEST;
		gbc_chckbxAuteur.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAuteur.gridx = 2;
		gbc_chckbxAuteur.gridy = 3;
		add(chckbxAuteur, gbc_chckbxAuteur);
		
		JCheckBox chckbxClient = new JCheckBox("Client");
		chckbxClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
			}
		});
		buttonGroup.add(chckbxClient);
		GridBagConstraints gbc_chckbxClient = new GridBagConstraints();
		gbc_chckbxClient.anchor = GridBagConstraints.WEST;
		gbc_chckbxClient.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxClient.gridx = 2;
		gbc_chckbxClient.gridy = 4;
		add(chckbxClient, gbc_chckbxClient);
		
		JCheckBox chckbxCommande = new JCheckBox("Commande");
		chckbxCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
			}
		});
		buttonGroup.add(chckbxCommande);
		GridBagConstraints gbc_chckbxCommande = new GridBagConstraints();
		gbc_chckbxCommande.anchor = GridBagConstraints.WEST;
		gbc_chckbxCommande.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCommande.gridx = 2;
		gbc_chckbxCommande.gridy = 5;
		add(chckbxCommande, gbc_chckbxCommande);
		
		JCheckBox chckbxLivre = new JCheckBox("Livre");
		chckbxLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddBook();
                            
			}
		});
		buttonGroup.add(chckbxLivre);
		GridBagConstraints gbc_chckbxLivre = new GridBagConstraints();
		gbc_chckbxLivre.anchor = GridBagConstraints.WEST;
		gbc_chckbxLivre.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLivre.gridx = 2;
		gbc_chckbxLivre.gridy = 6;
		add(chckbxLivre, gbc_chckbxLivre);
		
		JCheckBox chckbxEditeur = new JCheckBox("Editeur");
		chckbxEditeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddPublisher();
			}
		});
		buttonGroup.add(chckbxEditeur);
		GridBagConstraints gbc_chckbxEditeur = new GridBagConstraints();
		gbc_chckbxEditeur.anchor = GridBagConstraints.WEST;
		gbc_chckbxEditeur.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEditeur.gridx = 2;
		gbc_chckbxEditeur.gridy = 7;
		add(chckbxEditeur, gbc_chckbxEditeur);
		
		JCheckBox chckbxPackage = new JCheckBox("Package");
		chckbxPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PackageCrea p1 = new PackageCrea(); 
				p1.setVisible(true);
			}
		});
		buttonGroup.add(chckbxPackage);
		GridBagConstraints gbc_chckbxPackage = new GridBagConstraints();
		gbc_chckbxPackage.anchor = GridBagConstraints.WEST;
		gbc_chckbxPackage.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPackage.gridx = 2;
		gbc_chckbxPackage.gridy = 8;
		add(chckbxPackage, gbc_chckbxPackage);
		
                JCheckBox chckbxKeyword = new JCheckBox("Mot-Clef");
		chckbxKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddKeyword();
			}
		});
		buttonGroup.add(chckbxKeyword);
		GridBagConstraints gbc_chckbxKeyword = new GridBagConstraints();
		gbc_chckbxKeyword.anchor = GridBagConstraints.WEST;
		gbc_chckbxKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxKeyword.gridx = 2;
		gbc_chckbxKeyword.gridy = 9;
		add(chckbxKeyword, gbc_chckbxKeyword);
                
                JCheckBox chckbxCarrier = new JCheckBox("Transporteur");
		chckbxCarrier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddCarrier();
			}
		});
		buttonGroup.add(chckbxCarrier);
		GridBagConstraints gbc_chckbxCarrier = new GridBagConstraints();
		gbc_chckbxCarrier.anchor = GridBagConstraints.WEST;
		gbc_chckbxCarrier.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCarrier.gridx = 2;
		gbc_chckbxCarrier.gridy = 10;
		add(chckbxCarrier, gbc_chckbxCarrier);
                
                JCheckBox chckbxVat = new JCheckBox("TVA");
		chckbxVat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddVAT();
			}
		});
		buttonGroup.add(chckbxVat);
		GridBagConstraints gbc_chckbxVat = new GridBagConstraints();
		gbc_chckbxVat.anchor = GridBagConstraints.WEST;
		gbc_chckbxVat.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVat.gridx = 2;
		gbc_chckbxVat.gridy = 11;
		add(chckbxVat, gbc_chckbxVat);
                
                JCheckBox chckbxEmploye = new JCheckBox("Employe");
		chckbxEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            //CODE HERE
			}
		});
		buttonGroup.add(chckbxEmploye);
		GridBagConstraints gbc_chckbxEmploye = new GridBagConstraints();
		gbc_chckbxEmploye.anchor = GridBagConstraints.WEST;
		gbc_chckbxEmploye.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEmploye.gridx = 2;
		gbc_chckbxEmploye.gridy = 12;
		add(chckbxEmploye, gbc_chckbxEmploye);
                
                JCheckBox chckbxStatutColis = new JCheckBox("Statut Colis");
		chckbxStatutColis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddPackageStatus();
			}
		});
		buttonGroup.add(chckbxStatutColis);
		GridBagConstraints gbc_chckbxStatutColis = new GridBagConstraints();
		gbc_chckbxStatutColis.anchor = GridBagConstraints.WEST;
		gbc_chckbxStatutColis.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxStatutColis.gridx = 2;
		gbc_chckbxStatutColis.gridy = 13;
		add(chckbxStatutColis, gbc_chckbxStatutColis);
                
                JCheckBox chckbxStatutTransporteur = new JCheckBox("Statut Transporteur");
		chckbxStatutTransporteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddCarrierStatus();
			}
		});
		buttonGroup.add(chckbxStatutTransporteur);
		GridBagConstraints gbc_chckbxStatutT = new GridBagConstraints();
		gbc_chckbxStatutT.anchor = GridBagConstraints.WEST;
		gbc_chckbxStatutT.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxStatutT.gridx = 2;
		gbc_chckbxStatutT.gridy = 14;
		add(chckbxStatutTransporteur, gbc_chckbxStatutT);
		
                JCheckBox chckbxStatutLivre = new JCheckBox("Statut Livre");
		chckbxStatutLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            createFrameAddBookStatus();
			}
		});
		buttonGroup.add(chckbxStatutLivre);
		GridBagConstraints gbc_chckbxStatutLivre = new GridBagConstraints();
		gbc_chckbxStatutLivre.anchor = GridBagConstraints.WEST;
		gbc_chckbxStatutLivre.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxStatutLivre.gridx = 2;
		gbc_chckbxStatutLivre.gridy = 15;
		add(chckbxStatutLivre, gbc_chckbxStatutLivre);

		JButton btnFollow = new JButton("Suivant");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
			}
		});
		GridBagConstraints gbc_btnFollow = new GridBagConstraints();
		gbc_btnFollow.insets = new Insets(0, 0, 5, 5);
		gbc_btnFollow.gridx = 3;
		gbc_btnFollow.gridy = 16;
		add(btnFollow, gbc_btnFollow);
		
		JLabel lbltRckerUser = new JLabel("L'utilisateur est  : ");
		GridBagConstraints gbc_lbltRckerUser = new GridBagConstraints();
		gbc_lbltRckerUser.gridwidth = 3;
		gbc_lbltRckerUser.insets = new Insets(0, 0, 0, 5);
		gbc_lbltRckerUser.gridx = 0;
		gbc_lbltRckerUser.gridy = 18;
		add(lbltRckerUser, gbc_lbltRckerUser);

	}
        
        
    /* 
    * **********************
    * ====== CREATION ======
    * **********************
    
    /**
     * CATEGORY
     */
    public void createFrameAddCategory(){

        // Creation d'un JDialog qui va contenir le Panel
        fenetreLib dialog = new fenetreLib();

        // Creation du JPanel permettant l'affichage de la liste des mot-clefs
        CategoryAddJPanel categoryAddJPanel = new CategoryAddJPanel(dialog);

        // Definition d'un titre pour le panel d'affichage de la liste des mot-clefs
        //categoryListJPanel.setTitle("titre");
        // Ajout du Panel dans le JDialog
        dialog.setContentPane(categoryAddJPanel);

        // Configuration supplementaire et affichage du JDialog 
        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);

    }

    /**
     * BOOK STATUS
     */
    public void createFrameAddBookStatus(){

        fenetreLib dialog = new fenetreLib();

        BookStatusAddJPanel panel = new BookStatusAddJPanel(dialog);
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * VAT
     */
    public void createFrameAddVAT(){

        fenetreLib dialog = new fenetreLib();

        VatAddJPanel panel = new VatAddJPanel(dialog);
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * PUBLISHER
     */
    public void createFrameAddPublisher(){

        fenetreLib dialog = new fenetreLib();

        PublisherAddJPanel panel = new PublisherAddJPanel(dialog);
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * KEYWORD
     */
    public void createFrameAddKeyword(){

        fenetreLib dialog = new fenetreLib();

        KeywordAddJPanel panel = new KeywordAddJPanel(dialog);
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * BOOK
     */
    public void createFrameAddBook(){

        fenetreLib dialog = new fenetreLib();

        BookAddJPanel panel = new BookAddJPanel(dialog);
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * PACKAGE STATUS
     */
    public void createFrameAddPackageStatus(){

        fenetreLib dialog = new fenetreLib();

        PackageStatusF frame = new PackageStatusF();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * CARRIER STATUS
     */
    public void createFrameAddCarrierStatus(){

        fenetreLib dialog = new fenetreLib();

        CarrierStatusF frame = new CarrierStatusF();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * CARRIER
     */
    public void createFrameAddCarrier(){

        fenetreLib dialog = new fenetreLib();

        CarrierF frame = new CarrierF();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * EMPLOYE
     */
    public void createFrameAddEmployee(){
        /*
        fenetreLib dialog = new fenetreLib();
        
        CarrierF frame = new CarrierF();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);*/
    }

    /**
     * ************************************
     * ====== RECHERCHE / AFFICHAGE =======
     * ************************************
     */
    /**
     * CATEGORY
     */
    public void createFrameListCategory(){

        fenetreLib dialog = new fenetreLib();

        CategoryListJPanel panel = new CategoryListJPanel();
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * BOOK
     */
    public void createFrameListBook(){

        fenetreLib dialog = new fenetreLib();

        BookListJPanel panel = new BookListJPanel();
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * BOOK STATUS
     */
    public void createFrameListBookStatus(){

        fenetreLib dialog = new fenetreLib();

        BookStatusListJPanel panel = new BookStatusListJPanel();
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * KEYWORD
     */
    public void createFrameListKeyword(){

        fenetreLib dialog = new fenetreLib();

        KeywordListJPanel panel = new KeywordListJPanel();
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * PUBLISHER
     */
    public void createFrameListPublisher(){

        fenetreLib dialog = new fenetreLib();

        PublisherListJPanel panel = new PublisherListJPanel();
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * VAT
     */
    public void createFrameListVat(){

        fenetreLib dialog = new fenetreLib();

        VatListJPanel panel = new VatListJPanel();
        //categoryListJPanel.setTitle("titre");

        dialog.setContentPane(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * CARRIER
     */
    public void createFrameListCarrier(){

        fenetreLib dialog = new fenetreLib();

        CarrierListF frame = new CarrierListF();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * CARRIER STATUS
     */
    public void createFrameListCarrierStatus(){

        fenetreLib dialog = new fenetreLib();

        CarrierStatusList frame = new CarrierStatusList();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * PACKAGE STATUS
     */
    public void createFrameListPackageStatus(){

        fenetreLib dialog = new fenetreLib();

        PackageStatusList frame = new PackageStatusList();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }

    /**
     * EMPLOYEE
     */
    public void createFrameListEmployee(){

        /*
        fenetreLib dialog = new fenetreLib();

        PackageStatusList frame = new PackageStatusList();
        dialog.setContentPane(frame.getContentPane());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
         */
    }

}