/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package sistema_agendamento;

/**
 *
 * @author T-GAMER
 */
public class frmMenu extends javax.swing.JFrame {

    /** Creates new form frmMenu */
    public frmMenu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAgendamento = new javax.swing.JButton();
        btnEspecialidade = new javax.swing.JButton();
        btnMedico = new javax.swing.JButton();
        btnPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu");
        jLabel1.setOpaque(true);

        btnAgendamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgendamento.setText("Agendamento");
        btnAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentoActionPerformed(evt);
            }
        });

        btnEspecialidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEspecialidade.setText("Especialidade");
        btnEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecialidadeActionPerformed(evt);
            }
        });

        btnMedico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnMedico.setText("Medico");
        btnMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicoActionPerformed(evt);
            }
        });

        btnPaciente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnPaciente.setText("Paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEspecialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgendamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgendamento)
                    .addComponent(btnMedico))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEspecialidade)
                    .addComponent(btnPaciente))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentoActionPerformed
        // TODO add your handling code here:
        new frmViewAgendamento().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendamentoActionPerformed

    private void btnMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicoActionPerformed
        // TODO add your handling code here:
        new frmViewMedico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMedicoActionPerformed

    private void btnEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspecialidadeActionPerformed
        // TODO add your handling code here:
        new frmViewEspecialidade().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEspecialidadeActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        // TODO add your handling code here:
        new frmViewPaciente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPacienteActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendamento;
    private javax.swing.JButton btnEspecialidade;
    private javax.swing.JButton btnMedico;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
