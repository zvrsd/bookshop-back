package com.nope.bookshop.ui;

import com.nope.bookshop.dao.CategoryDAO;
import com.nope.bookshop.entity.Category;
import com.nope.bookshop.listener.DatabaseUpdateListener;
import com.nope.bookshop.res.Strings;
import com.nope.bookshop.uidefault.GenericJDialog;
import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.uimodel.UneditableTableModel;
import java.util.List;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author User
 */
public class CategoryListJPanel extends javax.swing.JPanel implements DatabaseUpdateListener{
    

    /**
     * Creates new form ListCategoryJPanel
     */
    public CategoryListJPanel() {
        initComponents();
        initListPanel();
        initCategoriesTree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categorySplitPane = new javax.swing.JSplitPane();
        categoryTreeScrollPane = new javax.swing.JScrollPane();
        categoryTree = new javax.swing.JTree();
        listPanel = new javax.swing.JPanel();

        categoryTreeScrollPane.setMinimumSize(new java.awt.Dimension(200, 64));
        categoryTreeScrollPane.setPreferredSize(new java.awt.Dimension(200, 275));
        categoryTreeScrollPane.setViewportView(categoryTree);

        categorySplitPane.setLeftComponent(categoryTreeScrollPane);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        categorySplitPane.setRightComponent(listPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categorySplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categorySplitPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void initListPanel(){
        subListCategories = new SubListCategoryJPanel(this);
        
        categorySplitPane.setRightComponent(subListCategories);
        subListCategories.setVisible(true);
    }
    
    private void initCategoriesTree() {
        categoryTree.setModel(getDefaultTreeModel());
    }
    
    private DefaultTreeModel getDefaultTreeModel(){
        
        List<Category> categories = new Vector(new CategoryDAO().getAll());
        Category rootCategory = categories.get(0);
        
        DefaultMutableTreeNode rootNode = buildTree(rootCategory);
        
        return new DefaultTreeModel(rootNode);
    }
      
    private DefaultMutableTreeNode buildTree(Category category) {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(category);

        for (Category c : category.getCategories()) {
            node.add(buildTree(c));
        }
        return node;
    }
    
    @Override
    public void databaseUpdated() {
        subListCategories.refreshData();
        initCategoriesTree();
    }
    
    private ListGenericJPanel<Category> subListCategories;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane categorySplitPane;
    private javax.swing.JTree categoryTree;
    private javax.swing.JScrollPane categoryTreeScrollPane;
    private javax.swing.JPanel listPanel;
    // End of variables declaration//GEN-END:variables


    
    class SubListCategoryJPanel extends ListGenericJPanel<Category>{

        private CategoryListJPanel listCategoryPanel;
                
        public SubListCategoryJPanel(CategoryListJPanel listCategoryPanel) {
            super();
            this.listCategoryPanel = listCategoryPanel;
            this.dao = new CategoryDAO();
            initTable();
            setTitle(Strings.TEXT_LIST + Strings.ELEMENT_CATEGORY);
        }

        @Override
        protected void initTable() {
            super.initTable();
            setTableModel(getDefaultTableModel());
            listCategoryPanel.initCategoriesTree();
        }
        
        @Override
        protected DefaultTableModel getDefaultTableModel() {
            super.getDefaultTableModel();
            
            Vector<String> columnNames = new Vector<>();
            Vector<Vector> data = new Vector<>();

            Vector<Category> categories = new Vector(elements);

            columnNames.add("ID");
            columnNames.add("Nom");

            for (Category category : categories) {

                Vector<Object> row = new Vector<>();
                row.add(category.getId());
                row.add(category.getName());
                row.add(category);
                data.add(row);
            }

            return new UneditableTableModel(data, columnNames);
        }

        @Override
        public void addNewElement() {
            super.addNewElement();
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            CategoryAddJPanel categoryAddJPanel = new CategoryAddJPanel(dialog);
            
            categoryAddJPanel.addDatabaseListener(listCategoryPanel);
            categoryAddJPanel.setTitle(Strings.TEXT_CREATE + Strings.ELEMENT_CATEGORY);
            
            dialog.setContentPane(categoryAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
        } 

        @Override
        public void editSelectedElement(Category t) {
            super.editSelectedElement(t);
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            CategoryEditJPanel categoryAddJPanel = new CategoryEditJPanel(dialog, t);
            
            categoryAddJPanel.addDatabaseListener(listCategoryPanel);
            categoryAddJPanel.setTitle(Strings.TEXT_EDIT + Strings.ELEMENT_CATEGORY);
            
            dialog.setContentPane(categoryAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
        }
    }
}