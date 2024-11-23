/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_agendamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author T-GAMER
 */
public class AgendamentoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendamentoDTO> lista = new ArrayList<>();
    
    public ResultSet buscarHorarios(String data, String cpfMed){
        conn = Conexao.getConexao();
         String sql = "SELECT * FROM agendamento WHERE dataAgenda = ? AND cpf_med_FK = ? ORDER BY horaAgenda";
         try{
             pstm = conn.prepareStatement(sql);
             pstm.setString(1, data);
             pstm.setString(2, cpfMed);
             return pstm.executeQuery();
         }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public ResultSet cbxDatas(){
         conn = Conexao.getConexao();
         String sql = "SELECT DISTINCT dataAgenda FROM agendamento ORDER BY dataAgenda";
         try{
             pstm = conn.prepareStatement(sql);
             return pstm.executeQuery();
         }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
     }
    
    public void cadastrarAgendamento(AgendamentoDTO objAgendamentoDTO) {
        String sql = "INSERT INTO agendamento (`dataAgenda`, `horaAgenda`, `cpf_pac_FK`, `cpf_med_FK`) "
                   + "VALUES (?, ?, ?, ?)";
        conn = Conexao.getConexao();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objAgendamentoDTO.getDataAgenda());
            pstm.setString(2, objAgendamentoDTO.getHoraAgenda());
            pstm.setString(3, objAgendamentoDTO.getCpfPac());
            pstm.setString(4, objAgendamentoDTO.getCpfMed());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Agendamento cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar agendamento: " + e.getMessage());
        }
    }
    
    public ArrayList<AgendamentoDTO> listarAgendamentos(String cpfMed,String data){
        String sql = "SELECT * FROM `agendamento` "
                + "INNER JOIN paciente ON agendamento.cpf_pac_FK = paciente.cpfPac "
                + "INNER JOIN medico ON agendamento.cpf_med_FK = medico.cpfMed "
                + "WHERE agendamento.dataAgenda = ? "
                + "AND agendamento.cpf_med_FK = ?"
                + "ORDER BY agendamento.horaAgenda";
        conn = Conexao.getConexao();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, data);
            pstm.setString(2, cpfMed);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                AgendamentoDTO objAgendamentoDTO = new AgendamentoDTO();
                objAgendamentoDTO.setIdAgenda(rs.getInt("idAgenda"));
                objAgendamentoDTO.setCpfPac(rs.getString("cpfPac"));
                objAgendamentoDTO.setNomePac(rs.getString("nomePac"));
                objAgendamentoDTO.setCpfMed(rs.getString("cpfMed"));
                objAgendamentoDTO.setNomeMed(rs.getString("nomeMed"));
                objAgendamentoDTO.setHoraAgenda(rs.getString("horaAgenda"));
                objAgendamentoDTO.setDataAgenda(rs.getString("dataAgenda"));
                lista.add(objAgendamentoDTO);
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;

    }
    
    public Map<String, String[]> buscarHorariosOcupados(String data, String cpfMed) {
        Map<String, String[]> horariosOcupados = new HashMap<>();
        Connection conn = Conexao.getConexao(); // Conexão com o banco

        String sql = "SELECT horaAgenda, nomePac, nomeMed, idAgenda " +
                     "FROM agendamento " +
                     "JOIN paciente ON agendamento.cpf_pac_FK = paciente.cpfPac " +
                     "JOIN medico ON agendamento.cpf_med_FK = medico.cpfMed " +
                     "WHERE agendamento.dataAgenda = ? " +
                     "AND agendamento.cpf_med_FK LIKE ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, data);
            pstm.setString(2, cpfMed);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String hora = rs.getString("horaAgenda");
                String paciente = rs.getString("nomePac");
                String medico = rs.getString("nomeMed");
                String id = String.valueOf(rs.getInt("idAgenda"));
                horariosOcupados.put(hora, new String[]{paciente, medico, id});
            }

            rs.close();
            pstm.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Tratamento simples de erro
        }

        return horariosOcupados;
    }
    
    public ArrayList<AgendamentoDTO> buscarAgendamento(int id){
        String sql = "SELECT * FROM `agendamento` "
                + "INNER JOIN paciente ON agendamento.cpf_pac_FK = paciente.cpfPac "
                + "INNER JOIN medico ON agendamento.cpf_med_FK = medico.cpfMed "
                + "INNER JOIN especialidade ON medico.id_esp_FK = especialidade.idEsp "
                + "WHERE agendamento.idAgenda = ? "
                + "ORDER BY agendamento.horaAgenda";
        conn = Conexao.getConexao();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                AgendamentoDTO objAgendamentoDTO = new AgendamentoDTO();
                objAgendamentoDTO.setIdAgenda(rs.getInt("idAgenda"));
                objAgendamentoDTO.setCpfPac(rs.getString("cpfPac"));
                objAgendamentoDTO.setNomePac(rs.getString("nomePac"));
                objAgendamentoDTO.setCpfMed(rs.getString("cpfMed"));
                objAgendamentoDTO.setNomeMed(rs.getString("nomeMed"));
                objAgendamentoDTO.setHoraAgenda(rs.getString("horaAgenda"));
                objAgendamentoDTO.setDataAgenda(rs.getString("dataAgenda"));
                objAgendamentoDTO.setIdEsp(rs.getInt("idEsp"));
                objAgendamentoDTO.setNomeEsp(rs.getString("nomeEsp"));
                lista.add(objAgendamentoDTO);
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;

    }
    
    public void alterarAgendamento(AgendamentoDTO objAgendamentoDTO) {
        String sql = "UPDATE agendamento "
                    + "SET dataAgenda = ?,"
                    + "horaAgenda = ?,"
                    + "cpf_pac_FK = ?,"
                    + "cpf_med_FK = ?"
                    + "WHERE idAgenda = ?";
        conn = Conexao.getConexao();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objAgendamentoDTO.getDataAgenda());
            pstm.setString(2, objAgendamentoDTO.getHoraAgenda());
            pstm.setString(3, objAgendamentoDTO.getCpfPac());
            pstm.setString(4, objAgendamentoDTO.getCpfMed());
            pstm.setInt(5, objAgendamentoDTO.getIdAgenda());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Agendamento alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar agendamento: " + e.getMessage());
        }
    }
    
}
