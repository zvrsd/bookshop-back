package swingLib;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cda611
 */
public class clientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form clientJPanel
     */
    public clientJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creaCljLbl = new javax.swing.JLabel();
        creaNmlbl = new javax.swing.JLabel();
        creaPnlbl = new javax.swing.JLabel();
        mailcreaLbl = new javax.swing.JLabel();
        pseudoCreaLbl = new javax.swing.JLabel();
        adCreaLbl = new javax.swing.JLabel();
        cpCreaLbl = new javax.swing.JLabel();
        villeCreaLbl = new javax.swing.JLabel();
        telCreaLbl = new javax.swing.JLabel();
        tel2CreaLbl = new javax.swing.JLabel();
        nmTxt = new javax.swing.JTextField();
        pnTxt = new javax.swing.JTextField();
        mailTxt = new javax.swing.JTextField();
        pseudoTxt = new javax.swing.JTextField();
        adrTxt = new javax.swing.JTextField();
        cpTxt = new javax.swing.JTextField();
        villeTxt = new javax.swing.JTextField();
        tel1Txt = new javax.swing.JTextField();
        tel2Txt = new javax.swing.JTextField();
        followBtn = new javax.swing.JButton();
        cancelBtn = new CancelButton();

        setBackground(new java.awt.Color(255, 255, 255));

        creaCljLbl.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        creaCljLbl.setText("Création d'un client");

        creaNmlbl.setText("Nom");

        creaPnlbl.setText("Prénom");

        mailcreaLbl.setText("Email");

        pseudoCreaLbl.setText("Pseudo");

        adCreaLbl.setText("Adresse rue");

        cpCreaLbl.setText("Code Postal");

        villeCreaLbl.setText("Ville");

        telCreaLbl.setText("Téléphone 1");

        tel2CreaLbl.setText("Téléphone 2");

        nmTxt.setText("jTextField1");

        pnTxt.setText("jTextField2");

        mailTxt.setText("jTextField3");

        pseudoTxt.setText("jTextField4");

        adrTxt.setText("jTextField5");

        cpTxt.setText("jTextField6");

        villeTxt.setText("jTextField7");

        tel1Txt.setText("jTextField8");

        tel2Txt.setText("jTextField9");

        followBtn.setText("Suivant");

        cancelBtn.setBackground(new java.awt.Color(255, 0, 51));
       
//        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cancelBtnActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(creaCljLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(creaNmlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(creaPnlbl)
                                    .addComponent(mailcreaLbl)
                                    .addComponent(pseudoCreaLbl)
                                    .addComponent(adCreaLbl)
                                    .addComponent(cpCreaLbl)
                                    .addComponent(villeCreaLbl)
                                    .addComponent(telCreaLbl)
                                    .addComponent(tel2CreaLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nmTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(pnTxt)
                                    .addComponent(mailTxt)
                                    .addComponent(pseudoTxt)
                                    .addComponent(adrTxt)
                                    .addComponent(cpTxt)
                                    .addComponent(villeTxt)
                                    .addComponent(tel1Txt)
                                    .addComponent(tel2Txt))))
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(followBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creaCljLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(creaNmlbl))
                    .addComponent(nmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creaPnlbl)
                    .addComponent(pnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailcreaLbl)
                    .addComponent(mailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pseudoCreaLbl)
                    .addComponent(pseudoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adCreaLbl)
                    .addComponent(adrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpCreaLbl)
                    .addComponent(cpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(villeCreaLbl)
                    .addComponent(villeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telCreaLbl)
                    .addComponent(tel1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tel2CreaLbl)
                    .addComponent(tel2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(followBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

//    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
//        // TODO add your handling code here:
//        
//        int result = JOptionPane.showConfirmDialog(new JFrame(), "Confirmez la fermeture de la fênetre ? ", "Quitter l'application", 1);
//    }//GEN-LAST:event_cancelBtnActionPerformed
public static void main(String []args){
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adCreaLbl;
    private javax.swing.JTextField adrTxt;
    private CancelButton cancelBtn;
    private javax.swing.JLabel cpCreaLbl;
    private javax.swing.JTextField cpTxt;
    private javax.swing.JLabel creaCljLbl;
    private javax.swing.JLabel creaNmlbl;
    private javax.swing.JLabel creaPnlbl;
    private javax.swing.JButton followBtn;
    private javax.swing.JTextField mailTxt;
    private javax.swing.JLabel mailcreaLbl;
    private javax.swing.JTextField nmTxt;
    private javax.swing.JTextField pnTxt;
    private javax.swing.JLabel pseudoCreaLbl;
    private javax.swing.JTextField pseudoTxt;
    private javax.swing.JTextField tel1Txt;
    private javax.swing.JLabel tel2CreaLbl;
    private javax.swing.JTextField tel2Txt;
    private javax.swing.JLabel telCreaLbl;
    private javax.swing.JLabel villeCreaLbl;
    private javax.swing.JTextField villeTxt;
    // End of variables declaration//GEN-END:variables
}
