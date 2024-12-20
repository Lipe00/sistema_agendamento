/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema_agendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sistema_agendamento.ValidarCPF.*;

/**
 *
 * @author T-GAMER
 */
public class frmViewAgendamento extends javax.swing.JFrame {
    Vector<String> medicosCPF = new Vector<String>();
    Vector<Integer> agendamentos = new Vector<Integer>();

    /**
     * Creates new form frmViewAgendamento
     */
    public frmViewAgendamento() {
        initComponents();
        loadDatas();
        loadMedicos();
        
        DefaultTableModel modelo = (DefaultTableModel) TabelaAgendamentos.getModel();
        modelo.setRowCount(0);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaAgendamentos = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnCad = new javax.swing.JButton();
        btnAlt = new javax.swing.JButton();
        btnExc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxMedico = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxData = new javax.swing.JComboBox<>();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agendamentos :: Listar");
        jLabel1.setOpaque(true);

        TabelaAgendamentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Horário", "Paciente", "Médico"
            }
        ));
        jScrollPane1.setViewportView(TabelaAgendamentos);
        if (TabelaAgendamentos.getColumnModel().getColumnCount() > 0) {
            TabelaAgendamentos.getColumnModel().getColumn(0).setMinWidth(150);
            TabelaAgendamentos.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        btnAtualizar.setBackground(new java.awt.Color(0, 51, 204));
        btnAtualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCad.setBackground(new java.awt.Color(0, 255, 102));
        btnCad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCad.setForeground(new java.awt.Color(255, 255, 255));
        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        btnAlt.setBackground(new java.awt.Color(255, 153, 51));
        btnAlt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAlt.setForeground(new java.awt.Color(255, 255, 255));
        btnAlt.setText("Alterar");
        btnAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltActionPerformed(evt);
            }
        });

        btnExc.setBackground(new java.awt.Color(255, 51, 51));
        btnExc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExc.setForeground(new java.awt.Color(255, 255, 255));
        btnExc.setText("Excluir");
        btnExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Médico:");

        cbxMedico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Data:");

        cbxData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDataActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(102, 153, 255));
        btnMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbxData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        carregarTabelaHorarios();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        // TODO add your handling code here:
        new frmAgendamento(-1).setVisible(true);
    }//GEN-LAST:event_btnCadActionPerformed

    private void btnAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltActionPerformed
        // TODO add your handling code here:
        int setar = TabelaAgendamentos.getSelectedRow();
        
        if(setar == -1){
            JOptionPane.showMessageDialog(null, "Escolha um registro para alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            int id = agendamentos.get(setar);
            JOptionPane.showMessageDialog(null, setar);

            if(id == -1){
                JOptionPane.showMessageDialog(null, "Escolha um registro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                new frmAgendamento(id).setVisible(true);
        }
        }
        
        
    }//GEN-LAST:event_btnAltActionPerformed

    private void btnExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcActionPerformed
        // TODO add your handling code here:
        int setar = TabelaAgendamentos.getSelectedRow();

        if(setar == -1){
            JOptionPane.showMessageDialog(null, "Escolha um registro para deletar!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            String cpf = sanitizeCpf(TabelaAgendamentos.getModel().getValueAt(setar, 0).toString());

            MedicoDTO objMedicoDTO = new MedicoDTO();
            objMedicoDTO.setCpfMed(cpf);

            MedicoDAO objMedicoDAO = new MedicoDAO();
            objMedicoDAO.ExcluirMedico(objMedicoDTO);

            btnAtualizar.doClick();
        }
    }//GEN-LAST:event_btnExcActionPerformed

    private void cbxDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDataActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxDataActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        new frmMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    public void loadDatas(){
        ResultSet rs;
        try{
            AgendamentoDAO objAgendamentoDAO = new AgendamentoDAO();
            rs = objAgendamentoDAO.cbxDatas();
            cbxData.removeAllItems();
            cbxData.addItem("Selecione uma data");
            
            //FORMATANDO AS DATAS
            SimpleDateFormat sdfEntrada = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfSaida = new SimpleDateFormat("dd/MM/yyyy");
            
            
            String dataAtual = sdfSaida.format(new java.util.Date());

            boolean encontrouDataAtual = false;
            while (rs.next()) {
                String dataSQL = rs.getString("dataAgenda");
                String dataFormatada = sdfSaida.format(sdfEntrada.parse(dataSQL));
                cbxData.addItem(dataFormatada);

                // Verificar se é a data atual
                if (dataFormatada.equals(dataAtual)) {
                    cbxData.setSelectedItem(dataFormatada);
                    encontrouDataAtual = true;
                }
            }

            // Caso não encontre a data atual na lista
            if (!encontrouDataAtual) {
                cbxData.setSelectedIndex(0); // Voltar para "Selecione uma data"
            }
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar combobox data:" +
           erro);
        } catch (ParseException ex) {
            Logger.getLogger(frmViewAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void loadMedicos(){
        ResultSet rs;
        
        try{
            MedicoDAO objMedicoDAO= new MedicoDAO();
            
            rs = objMedicoDAO.CarregarCBX();
            
            medicosCPF.clear();
            cbxMedico.removeAllItems();
            cbxMedico.addItem("Selecione um médico");
            medicosCPF.addElement("");
            while(rs.next()){
                medicosCPF.addElement(rs.getString(1));
                cbxMedico.addItem(rs.getString(2));
                
            }
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar combobox médicos:" +
           erro);
        }
    }

    public void carregarTabelaHorarios() {
        String[] horarios = {
            "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00", "10:30:00",
            "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00",
            "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00",
            "17:00:00", "17:30:00", "18:00:00", "18:30:00", "19:00:00"
        };
        int medIndex = cbxMedico.getSelectedIndex();
        String cpfMed;
        if(medIndex == 0){
            cpfMed = "%%";
        }else{
            cpfMed = medicosCPF.get(medIndex);
        }
        
        int dataIndex = cbxData.getSelectedIndex();
        String data;
        if(dataIndex != 0 && medIndex != 0){
            try {
                data = cbxData.getItemAt(dataIndex);
                
                //FORMATAÇÃO DE DATAS
                SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfSaida = new SimpleDateFormat("yyyy-MM-dd");
                String dataFormatada = sdfSaida.format(sdfEntrada.parse(data));
                
                AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
                Map<String, String[]> horariosOcupados = agendamentoDAO.buscarHorariosOcupados(dataFormatada, cpfMed);

                DefaultTableModel modelo = (DefaultTableModel) TabelaAgendamentos.getModel();
                modelo.setRowCount(0); 

                agendamentos.clear();
                
                for (String horario : horarios) {
                    if (horariosOcupados.containsKey(horario)) {
                        String[] dados = horariosOcupados.get(horario);
                        
                        modelo.addRow(new Object[]{(horario.substring(0, horario.length() - 3)), dados[0], dados[1]});
                        agendamentos.addElement(Integer.parseInt(dados[2]));
                    } else {
                        modelo.addRow(new Object[]{(horario.substring(0, horario.length() - 3)), "", ""});
                        agendamentos.addElement(-1);
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(frmViewAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (dataIndex == 0){
            JOptionPane.showMessageDialog(null, "Informe uma data válida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Informe um médico!", "Erro", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(frmViewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmViewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmViewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmViewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmViewAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaAgendamentos;
    private javax.swing.JButton btnAlt;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnExc;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> cbxData;
    private javax.swing.JComboBox<String> cbxMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
