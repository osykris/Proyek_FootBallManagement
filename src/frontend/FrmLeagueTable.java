/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;
import backend.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class FrmLeagueTable extends javax.swing.JFrame {

    /**
     * Creates new form FrmLeagueTable
     */
    public FrmLeagueTable() {
        initComponents();
        kosongkanForm();
        viewData();
    }
    
    public void kosongkanForm() {
        txtID.setText("0");
        txtTeam_Name.setText("");
        txtMatch.setText("");
        txtWin.setText("");
        txtDraw.setText("");
        txtLoss.setText("");
        txtPoints.setText("");
    }
    public void viewData(){
        String[] kolom = { "ID", "Team_Name", "played", "win", "draw", "loss", "points"};
        ArrayList<LeagueTable> list = new LeagueTable().getAllLeagueTable();
        Object rowData[] = new Object[7];

        tblLeague.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (LeagueTable lt : list) {
            rowData[0] = lt.getID_League();
            rowData[1] = lt.getName();
            rowData[2] = lt.getMatchesPlayed();
            rowData[3] = lt.getWinCount();
            rowData[4] = lt.getDrawCount();
            rowData[5] = lt.getDefeatCount();
            rowData[6] = lt.getPoints();
            

            ((DefaultTableModel) tblLeague.getModel()).addRow(rowData);
        }
    }
    
     public void cari(String keyword){
        String[] kolom = { "ID", "Team_Name", "played", "win", "draw", "loss", "points"};
        ArrayList<LeagueTable> list = new LeagueTable().searchLeague(keyword);
        Object rowData[] = new Object[7];

        tblLeague.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (LeagueTable lt : list) {
            rowData[0] = lt.getID_League();
            rowData[1] = lt.getName();
            rowData[2] = lt.getMatchesPlayed();
            rowData[3] = lt.getWinCount();
            rowData[4] = lt.getDrawCount();
            rowData[5] = lt.getDefeatCount();
            rowData[6] = lt.getPoints();
            

            ((DefaultTableModel) tblLeague.getModel()).addRow(rowData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLeague = new javax.swing.JTable();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTeam_Name = new javax.swing.JTextField();
        txtMatch = new javax.swing.JTextField();
        txtWin = new javax.swing.JTextField();
        txtDraw = new javax.swing.JTextField();
        txtLoss = new javax.swing.JTextField();
        txtPoints = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnBaru = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LEAGUE TABLE");

        tblLeague.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Team_Name", "Played", "Win", "Draw", "Loss", "Points", "ID", "Team_ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblLeague.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLeagueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLeague);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel2.setText("Team Name");

        jLabel3.setText("Matches Played");

        jLabel4.setText("Win Count");

        jLabel5.setText("Draw Count");

        jLabel6.setText("Loss Count");

        jLabel7.setText("Points");

        jLabel8.setText("ID ");

        txtTeam_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeam_NameActionPerformed(evt);
            }
        });

        txtMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatchActionPerformed(evt);
            }
        });

        txtPoints.setToolTipText("");

        txtID.setEditable(false);

        btnBaru.setText("Tambah Baru");
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(493, 493, 493))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(btnBaru)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTeam_Name)
                                    .addComponent(txtMatch)
                                    .addComponent(txtWin)
                                    .addComponent(txtDraw)
                                    .addComponent(txtLoss)
                                    .addComponent(txtPoints)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCari)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(230, 230, 230))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTeam_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtWin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru)
                    .addComponent(btnHapus)
                    .addComponent(btnSave)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back)
                .addGap(20, 20, 20))
        );

        setSize(new java.awt.Dimension(657, 617));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new FrmDashboard().setVisible(true);
            dispose();
    }//GEN-LAST:event_backActionPerformed

    private void txtTeam_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeam_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeam_NameActionPerformed

    private void txtMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        LeagueTable lt = new LeagueTable();
        lt.setID_League(Integer.parseInt(txtID.getText()));
        lt.setName(txtTeam_Name.getText());
        lt.setMatchesPlayed(Integer.parseInt(txtMatch.getText()));
        lt.setWinCount(Integer.parseInt(txtWin.getText()));
        lt.setDrawCount(Integer.parseInt(txtDraw.getText()));
        lt.setDefeatCount(Integer.parseInt(txtLoss.getText()));
        lt.setPoints(Integer.parseInt(txtPoints.getText()));
        lt.save();
        txtID.setText(Integer.toString(lt.getID_League()));
        viewData(); 
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblLeague.getModel();
        int row = tblLeague.getSelectedRow();
        LeagueTable lt = new LeagueTable().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        lt.delete();
        kosongkanForm();
        viewData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_btnBaruActionPerformed

    private void tblLeagueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLeagueMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblLeague.getModel();
        int row = tblLeague.getSelectedRow();
        
        txtID.setText(model.getValueAt(row, 0).toString());
        txtTeam_Name.setText(model.getValueAt(row, 1).toString());
        txtMatch.setText(model.getValueAt(row, 2).toString());
        txtWin.setText(model.getValueAt(row, 3).toString());
        txtDraw.setText(model.getValueAt(row, 4).toString());
        txtLoss.setText(model.getValueAt(row, 5).toString());
        txtPoints.setText(model.getValueAt(row, 6).toString());
                                    
    }//GEN-LAST:event_tblLeagueMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed
                                    
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
            java.util.logging.Logger.getLogger(FrmLeagueTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLeagueTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLeagueTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLeagueTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLeagueTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSave;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLeague;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDraw;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLoss;
    private javax.swing.JTextField txtMatch;
    private javax.swing.JTextField txtPoints;
    private javax.swing.JTextField txtTeam_Name;
    private javax.swing.JTextField txtWin;
    // End of variables declaration//GEN-END:variables
}
