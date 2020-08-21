/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class buyBooks extends javax.swing.JFrame {

    /**
     * Creates new form updateBooks
     */
    
    int num = -1;
    customer c;
    public buyBooks() throws ClassNotFoundException, IOException {
        initComponents();
        tableUpdate();
    }

    buyBooks(customer c) throws ClassNotFoundException, IOException {
         initComponents();
         this.c = new customer();
          this.c.setName(c.getName());
          this.c.setUsername(c.getUsername());
          this.c.setCnic(c.getCnic());
          this.c.setAmount(c.getAmount());
        tableUpdate();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Books");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 51, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Click on the Book Row below to Update");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book Title", "Book Author", "Book Genre", "Published Year", "Quantity In Stock", "Price"
            }
        ));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, 680, 290));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem/viewBooks.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new customerHome(c).setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(buyBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try {
            book b = new book();
            int index = jTable1.getSelectedRow();
        num = index;
        b.setTitle(model.getValueAt(index, 0).toString());
        b.setGenre(model.getValueAt(index, 2).toString());
        b.setAuthor(model.getValueAt(index, 1).toString());
        b.setYear(Integer.parseInt(model.getValueAt(index, 3).toString()));
        b.setQuantity(Integer.parseInt(model.getValueAt(index, 4).toString()));
        b.setPrice(Double.parseDouble(model.getValueAt(index, 5).toString()));
        new setQuantity(b,c).setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(buyBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_jTable1MouseClicked

     public void tableUpdate() throws ClassNotFoundException, FileNotFoundException, IOException
    {
 
        
           
           
            DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
             RandomAccessFile file = new RandomAccessFile("books.dat","rw");
             book b = new book();
             int n = (int) (file.length()/b.size());
            dft.setRowCount(0);
            for(int i = 0; i < n; i++)
            {
                    b.read();
                    Object[] array = new Object[6];
                
                    array[0] = b.getTitle();
                    array[1] = b.getAuthor();
                    array[2] = b.getGenre();                   
                    array[3] = b.getYear();
                    array[4] = b.getQuantity();       
                    array[5] = b.getPrice();
                   
               
                dft.addRow(array);
            }
    
            
      
        
    }
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
            java.util.logging.Logger.getLogger(buyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new buyBooks().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(buyBooks.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(buyBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
