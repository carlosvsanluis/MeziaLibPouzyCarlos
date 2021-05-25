package mezialibpouzycarlos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SIO_9
 */
public class PouzyApp extends javax.swing.JFrame {
    

    private static final String username ="root";
    private static final String password ="";
    private static final String dataConn ="jdbc:mysql://localhost:3306/pouzylibdb";
    
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
    
    public PouzyApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    //==========================Functions================================================
    
    public void updateDB()
    {
      try
       {
           Class.forName("com.mysql.jdbc.Driver");
           sqlConn =DriverManager.getConnection(dataConn,username,password);
           pst = sqlConn.prepareStatement("Select * from books");
           
           rs = pst.executeQuery();
           
           ResultSetMetaData stData= rs.getMetaData();
           
           q = stData.getColumnCount();
           
           DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
           RecordTable.setRowCount(0);
           
           while(rs.next()){
               
               Vector columnData = new Vector();
               
               for (i = 1; i <= q; i++)
               {
                   columnData.add(rs.getString("idbook"));
                   columnData.add(rs.getString("title"));
                   columnData.add(rs.getString("author"));
                   columnData.add(rs.getString("language"));
                   columnData.add(rs.getString("ibsn"));
                   columnData.add(rs.getString("available"));
               }
               RecordTable.addRow(columnData);
               
           }
       }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            
    }
    
    
    //=========================End Fungtions================================================
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        updateBookButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        insertAuthor = new javax.swing.JTextField();
        insertLanguage = new javax.swing.JTextField();
        insertIBSN = new javax.swing.JTextField();
        insertTitle = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        insertAvailable = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        showBooks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addBookButton.setText("AddBook");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setText("Delete Book");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        updateBookButton.setText("UpdateBook");
        updateBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idbook", "Title", "Author", "language", "ibsn", "availabe"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        insertAuthor.setText("Author");

        insertLanguage.setText("Language");

        insertIBSN.setText("IBSN Number");
        insertIBSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertIBSNActionPerformed(evt);
            }
        });

        insertTitle.setText("Title");
        insertTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertTitleActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        insertAvailable.setText("Available");
        insertAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAvailableActionPerformed(evt);
            }
        });

        jButton1.setText("TODO Show Users");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        showBooks.setText("Afficher Les Livres");
        showBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBooksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGap(241, 241, 241))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertIBSN, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(insertAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBookButton)
                                .addGap(115, 115, 115)
                                .addComponent(updateBookButton)
                                .addGap(114, 114, 114)
                                .addComponent(deleteBookButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(showBooks)))
                        .addGap(17, 17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(showBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertIBSN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(clearButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBookButton)
                            .addComponent(updateBookButton)
                            .addComponent(deleteBookButton))))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertTitleActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        try
       {
           Class.forName("com.mysql.jdbc.Driver");
           sqlConn = DriverManager.getConnection(dataConn,username,password);
           pst = sqlConn.prepareStatement("INSERT INTO `books` ( `title`, `author`, `language`, `ibsn`, `available`) "
                   + "VALUES (?,?,?,?,?); ");
           
           pst.setString(1, insertTitle.getText());
           pst.setString(2, insertAuthor.getText());
           pst.setString(3, insertLanguage.getText());
           pst.setString(4, insertIBSN.getText());
           pst.setString(5, insertAvailable.getText());
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(this, "Record Added");
           updateDB();
           
           
       }
        
        catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        
        
        
    }//GEN-LAST:event_addBookButtonActionPerformed
private JFrame frame;

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        
        frame = new Jframe("Exit");
        
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Pouzy Mezia",
                JOptionPane.YES_OPTION)==JOptionPane.YES_NO_OPTION)
        {
             System.exit(0);
        }   
            
    }//GEN-LAST:event_exitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        insertAuthor.setText("");
        insertLanguage.setText("");
        insertIBSN.setText("");
        insertTitle.setText("");
        insertAvailable.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void insertIBSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertIBSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertIBSNActionPerformed

    private void insertAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertAvailableActionPerformed

    private void updateBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookButtonActionPerformed
        
         DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
         int SelectedRows = jTable1.getSelectedRow();
        
        try
       {
           id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
           Class.forName("com.mysql.jdbc.Driver");
           sqlConn = DriverManager.getConnection(dataConn,username,password);
           pst = sqlConn.prepareStatement("UPDATE books set title=?, author=?, language=?, ibsn=?, available=? WHERE title=?");
           
           pst.setString(1, insertTitle.getText());
           pst.setString(2, insertAuthor.getText());
           pst.setString(3, insertLanguage.getText());
           pst.setString(4, insertIBSN.getText());
           pst.setString(5, insertAvailable.getText());
           pst.setString(6, insertTitle.getText());
           
           
           pst.executeUpdate();
           JOptionPane.showMessageDialog(this, "Record Updated");
           updateDB();
           
           
       }
        
        catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        catch (SQLException ex){
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        
    }//GEN-LAST:event_updateBookButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
         int SelectedRows = jTable1.getSelectedRow();   
         
         insertTitle.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
         insertAuthor.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
         insertLanguage.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
         insertIBSN.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
         insertAvailable.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
           
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow(); 
        
        try 
        {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            
            deleteItem = JOptionPane.showConfirmDialog(null,"Confirm if you want delete Item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            if (deleteItem == JOptionPane.YES_OPTION) 
            {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn =DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("DELETE from books where idbook =?");
                
                pst.setInt(1, id);
                pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"Books Record Updates");
             updateDB();
             
         insertTitle.setText("");
         insertTitle.requestFocus();
         insertAuthor.setText("");
         insertLanguage.setText("");
         insertIBSN.setText("");
         insertAvailable.setText("");
       
            }
        }
              catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        catch (SQLException ex){
            System.err.println(ex);
        }
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBooksActionPerformed
        updateDB();
    }//GEN-LAST:event_showBooksActionPerformed
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
      
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PouzyApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PouzyApp().setVisible(true);
               
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField insertAuthor;
    private javax.swing.JTextField insertAvailable;
    private javax.swing.JTextField insertIBSN;
    private javax.swing.JTextField insertLanguage;
    private javax.swing.JTextField insertTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton showBooks;
    private javax.swing.JButton updateBookButton;
    // End of variables declaration//GEN-END:variables

    private static class Jframe extends JFrame {

        public Jframe(String exit) {
        }
    }

    private static class Java_MysqlConn {

        public Java_MysqlConn() {
        }
    }

    
}
