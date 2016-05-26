package views;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CodexFrame extends javax.swing.JFrame {

    public CodexFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list_Choco = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btn_Nouveau = new javax.swing.JButton();
        label_NomChoco = new javax.swing.JLabel();
        txtzone_NomChoco = new javax.swing.JTextField();
        label_PourcentChoco = new javax.swing.JLabel();
        txtzone_PourcentChoco = new javax.swing.JTextField();
        label_Descript = new javax.swing.JLabel();
        scroll_Descript = new javax.swing.JScrollPane();
        txtzone_Descript = new javax.swing.JTextArea();
        pannel_ImgChoco = new javax.swing.JPanel();
        btn_Save = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        label_Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chocodex");

        jList1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(93, 53, 16)));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_Choco.setViewportView(jList1);

        btn_Nouveau.setBackground(new java.awt.Color(255, 255, 255));
        btn_Nouveau.setFont(new java.awt.Font("AR CENA", 0, 36)); // NOI18N
        btn_Nouveau.setForeground(new java.awt.Color(93, 53, 16));
        btn_Nouveau.setText("Nouvo Choco");
        btn_Nouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NouveauActionPerformed(evt);
            }
        });

        label_NomChoco.setFont(new java.awt.Font("AR CENA", 0, 14)); // NOI18N
        label_NomChoco.setForeground(new java.awt.Color(93, 53, 16));
        label_NomChoco.setText("Nom du Choco");

        label_PourcentChoco.setFont(new java.awt.Font("AR CENA", 0, 14)); // NOI18N
        label_PourcentChoco.setForeground(new java.awt.Color(93, 53, 16));
        label_PourcentChoco.setText("Pour100tage de KKO");

        label_Descript.setFont(new java.awt.Font("AR CENA", 0, 14)); // NOI18N
        label_Descript.setForeground(new java.awt.Color(93, 53, 16));
        label_Descript.setText("Description");

        txtzone_Descript.setColumns(20);
        txtzone_Descript.setRows(5);
        scroll_Descript.setViewportView(txtzone_Descript);

        pannel_ImgChoco.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(93, 53, 16)));
        pannel_ImgChoco.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout pannel_ImgChocoLayout = new javax.swing.GroupLayout(pannel_ImgChoco);
        pannel_ImgChoco.setLayout(pannel_ImgChocoLayout);
        pannel_ImgChocoLayout.setHorizontalGroup(
            pannel_ImgChocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );
        pannel_ImgChocoLayout.setVerticalGroup(
            pannel_ImgChocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        btn_Save.setBackground(new java.awt.Color(255, 255, 255));
        btn_Save.setFont(new java.awt.Font("AR CENA", 0, 18)); // NOI18N
        btn_Save.setForeground(new java.awt.Color(93, 53, 16));
        btn_Save.setText("Sauver les changements");

        btn_Delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_Delete.setFont(new java.awt.Font("AR CENA", 0, 18)); // NOI18N
        btn_Delete.setForeground(new java.awt.Color(93, 53, 16));
        btn_Delete.setText("Retirer le choco");

        label_Title.setFont(new java.awt.Font("AR DARLING", 0, 36)); // NOI18N
        label_Title.setForeground(new java.awt.Color(93, 53, 16));
        label_Title.setText("Le CHOCODEX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Title)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Nouveau)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(list_Choco, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_PourcentChoco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_NomChoco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_Descript, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtzone_NomChoco)
                                    .addComponent(txtzone_PourcentChoco)
                                    .addComponent(scroll_Descript, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(pannel_ImgChoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Delete)))
                        .addGap(158, 158, 158))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list_Choco, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_NomChoco)
                                    .addComponent(txtzone_NomChoco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_PourcentChoco)
                                    .addComponent(txtzone_PourcentChoco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_Descript)
                                    .addComponent(scroll_Descript, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pannel_ImgChoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Save)
                            .addComponent(btn_Delete))))
                .addGap(32, 32, 32)
                .addComponent(btn_Nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NouveauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NouveauActionPerformed

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
            java.util.logging.Logger.getLogger(CodexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new CodexFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Nouveau;
    private javax.swing.JButton btn_Save;
    private javax.swing.JList<String> jList1;
    private javax.swing.JLabel label_Descript;
    private javax.swing.JLabel label_NomChoco;
    private javax.swing.JLabel label_PourcentChoco;
    private javax.swing.JLabel label_Title;
    private javax.swing.JScrollPane list_Choco;
    private javax.swing.JPanel pannel_ImgChoco;
    private javax.swing.JScrollPane scroll_Descript;
    private javax.swing.JTextArea txtzone_Descript;
    private javax.swing.JTextField txtzone_NomChoco;
    private javax.swing.JTextField txtzone_PourcentChoco;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_Delete() {
        return btn_Delete;
    }

    public JButton getBtn_Nouveau() {
        return btn_Nouveau;
    }

    public JButton getBtn_Save() {
        return btn_Save;
    }

    public JList<String> getjList1() {
        return jList1;
    }

    public JScrollPane getList_Choco() {
        return list_Choco;
    }

    public JPanel getPannel_ImgChoco() {
        return pannel_ImgChoco;
    }

    public JScrollPane getScroll_Descript() {
        return scroll_Descript;
    }

    public JTextField getTxtzone_NomChoco() {
        return txtzone_NomChoco;
    }

    public JTextField getTxtzone_PourcentChoco() {
        return txtzone_PourcentChoco;
    }

    public void setjList1(JList<String> jList1) {
        this.jList1 = jList1;
    }

    public void setPannel_ImgChoco(JPanel pannel_ImgChoco) {
        this.pannel_ImgChoco = pannel_ImgChoco;
    }

    public void setTxtzone_Descript(JTextArea txtzone_Descript) {
        this.txtzone_Descript = txtzone_Descript;
    }

    public void setTxtzone_NomChoco(JTextField txtzone_NomChoco) {
        this.txtzone_NomChoco = txtzone_NomChoco;
    }

    public void setTxtzone_PourcentChoco(JTextField txtzone_PourcentChoco) {
        this.txtzone_PourcentChoco = txtzone_PourcentChoco;
    }

    public JTextArea getTxtzone_Descript() {
        return txtzone_Descript;
    }
}
