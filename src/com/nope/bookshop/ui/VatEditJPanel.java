/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nope.bookshop.ui;

import com.nope.bookshop.dao.VatDAO;
import com.nope.bookshop.entity.Vat;
import com.nope.bookshop.exception.DatabaseException;
import com.nope.bookshop.listener.DatabaseUpdateListener;
import com.nope.bookshop.res.Strings;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class VatEditJPanel extends javax.swing.JPanel{

    private Vat vat;
    private Window parent;
    private List<DatabaseUpdateListener> listeners;
    
    /**
     * Creates new form AddKeywordJPanel
     * @param parent
     * @param vat
     */
    public VatEditJPanel(Window parent, Vat vat) {
        this.vat = vat;
        this.parent = parent;
        this.listeners = new ArrayList<>();
        initComponents();
        initFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        fieldsPanel = new javax.swing.JPanel();
        fieldsSubPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Création");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel)
        );

        nameLabel.setText("Taux");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fieldsSubPanelLayout = new javax.swing.GroupLayout(fieldsSubPanel);
        fieldsSubPanel.setLayout(fieldsSubPanelLayout);
        fieldsSubPanelLayout.setHorizontalGroup(
            fieldsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsSubPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField)
                .addContainerGap())
        );
        fieldsSubPanelLayout.setVerticalGroup(
            fieldsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fieldsSubPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fieldsSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout fieldsPanelLayout = new javax.swing.GroupLayout(fieldsPanel);
        fieldsPanel.setLayout(fieldsPanelLayout);
        fieldsPanelLayout.setHorizontalGroup(
            fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldsSubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fieldsPanelLayout.setVerticalGroup(
            fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsPanelLayout.createSequentialGroup()
                .addComponent(fieldsSubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        confirmButton.setText("Valider");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Annuler");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Supprimer");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmButton)
                .addContainerGap())
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fieldsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        confirmAction();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancelAction();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteAction();
    }//GEN-LAST:event_deleteButtonActionPerformed

    protected void initFields(){
        if(vat == null){
            return;
        }
        nameTextField.setText(""+vat.getRate());
    }
    
    protected void cancelAction(){
        int result = JOptionPane.showConfirmDialog(
                this,
                Strings.MSG_ASK_CONFIRMATION,
                Strings.MSG_CANCEL_EDITION,
                JOptionPane.YES_NO_OPTION
        );
        if (parent == null) {
            return;
        }
        if (result == JOptionPane.YES_OPTION) {
            parent.dispose();

        }
    }
    protected void confirmAction(){
        int result = JOptionPane.showConfirmDialog(
                this,
                Strings.MSG_ASK_CONFIRMATION, 
                Strings.MSG_CONFIRM_EDITION, 
                JOptionPane.YES_NO_OPTION
        );
        if(parent == null){
            return;
        }
        if(result == JOptionPane.YES_OPTION){
            
            try {
                vat.setRate(Float.parseFloat(getVatRateValue()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        this, 
                        Strings.MSG_INVALID_FIELD+" : "+e.getMessage(), 
                        Strings.MSG_ERROR, 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            
            try {
                new VatDAO().update(vat);
            } catch (DatabaseException ex) {
                JOptionPane.showMessageDialog(
                        this, 
                        ex.getMessage(), 
                        Strings.MSG_ERROR, 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            JOptionPane.showMessageDialog(
                        this, 
                        Strings.ELEMENT_VAT+" "+Strings.MSG_SUCCESSFULLY_EDITED, 
                        Strings.MSG_INFO, 
                        JOptionPane.INFORMATION_MESSAGE
            );
            
            notifyDatabaseListener();
            parent.dispose();
        }
    }
    protected void deleteAction(){
        int result = JOptionPane.showConfirmDialog(
                this,
                Strings.MSG_ASK_CONFIRMATION,
                Strings.MSG_CONFIRM_DELETION,
                JOptionPane.YES_NO_OPTION
        );
        if (getParentWindow() == null) {
            return;
        }
        if (result == JOptionPane.YES_OPTION) {
            
            try {
                new VatDAO().delete(vat);
            } catch (DatabaseException ex) {
                JOptionPane.showMessageDialog(
                        this, 
                        ex.getMessage(), 
                        Strings.MSG_ERROR, 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            JOptionPane.showMessageDialog(
                        this, 
                        Strings.ELEMENT_VAT+" "+Strings.MSG_SUCCESSFULLY_DELETED, 
                        Strings.MSG_INFO, 
                        JOptionPane.INFORMATION_MESSAGE
            );
            notifyDatabaseListener();
            getParentWindow().dispose();
        }
    }

    public void addDatabaseListener(DatabaseUpdateListener listener){
        listeners.add(listener);
    }
    
    /**
     * Notify all listeners
     */
    protected void notifyDatabaseListener(){
        for(DatabaseUpdateListener listener : listeners){
            listener.databaseUpdated();
        }
    }
    
    public Window getParentWindow(){
        return parent;
    }
    
    public String getVatRateValue(){
        return nameTextField.getText();
    }
    public Vat getVat(){
        return vat;
    }

    public void setTitle(String title){
        titleLabel.setText(title);
    }
    
    /**
     * Whether the delete button is displayed or not
     * 
     * @param isAllowed 
     */
    public void allowDeletion(boolean isAllowed){
        deleteButton.setEnabled(isAllowed);
        deleteButton.setVisible(isAllowed);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel fieldsPanel;
    private javax.swing.JPanel fieldsSubPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

    
}