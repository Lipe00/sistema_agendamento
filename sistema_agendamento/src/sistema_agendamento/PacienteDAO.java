/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_agendamento;

/**
 *
 * @author T-GAMER
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane; 
public class PacienteDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PacienteDTO> lista = new ArrayList<>();
    
    public void CadastrarPaciente(PacienteDTO objPacienteDTO){
        String sql = "INSERT INTO `paciente` "
                        + "(`cpfPac`, `nomePac`, `endPac`, `telPac`)"
                        + "VALUES(?, ?, ?, ?) ";
         conn = Conexao.getConexao();
         
          try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPacienteDTO.getCpfPac());
            pstm.setString(2, objPacienteDTO.getNomePac());
            pstm.setString(3, objPacienteDTO.getEndPac());
            pstm.setString(4, objPacienteDTO.getTelPac());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
            
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
     public ArrayList<PacienteDTO> ListarPacientes(){
        String sql = "SELECT * FROM paciente ORDER BY nomePac";
        conn = Conexao.getConexao();
        
        try{
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while(rs.next()){
                PacienteDTO objPacienteDTO = new PacienteDTO();
                objPacienteDTO.setCpfPac(rs.getString("cpfPac"));
                objPacienteDTO.setNomePac(rs.getString("nomePac"));
                objPacienteDTO.setEndPac(rs.getString("endPac"));
                objPacienteDTO.setTelPac(rs.getString("telPac"));
                lista.add(objPacienteDTO);
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
     public ResultSet SelecionarPaciente(String cpf){
         conn = Conexao.getConexao();
         String sql = "SELECT * FROM paciente WHERE cpfPac = ? ORDER BY nomePac";
         try{
             pstm = conn.prepareStatement(sql);
             pstm.setString(1, cpf);
             return pstm.executeQuery();
         }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
     }
     
     public void AlterarPaciente(PacienteDTO objPacienteDTO){
        String sql = "UPDATE paciente SET nomePac = ?, endPac = ?, telPac = ? WHERE cpfPac = ?";
        
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPacienteDTO.getNomePac());
            pstm.setString(2, objPacienteDTO.getEndPac());
            pstm.setString(3, objPacienteDTO.getTelPac());
            pstm.setString(4, objPacienteDTO.getCpfPac());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso!");
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
     
     public void ExcluirPaciente(PacienteDTO objPacienteDTO){
        String sql = "DELETE FROM paciente WHERE cpfPac = ?";
        
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objPacienteDTO.getCpfPac());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
}
