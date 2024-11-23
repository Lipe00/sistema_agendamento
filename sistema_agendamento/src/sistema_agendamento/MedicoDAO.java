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
public class MedicoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MedicoDTO> lista = new ArrayList<>();
    
    public void CadastrarMedico(MedicoDTO objMedicoDTO){
        String sql = "INSERT INTO medico"
                         + "(`cpfMed`, `nomeMed`, `endMed`, `telMed`, `crmMed`, `id_esp_FK`) "
                            + "VALUES (?,?,?,?,?,?)";
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objMedicoDTO.getCpfMed());
            pstm.setString(2, objMedicoDTO.getNomeMed());
            pstm.setString(3, objMedicoDTO.getEndMed());
            pstm.setString(4, objMedicoDTO.getTelMed());
            pstm.setString(5, objMedicoDTO.getCrmMed());
            pstm.setInt(6, objMedicoDTO.getEspMed());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");
            
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<MedicoDTO> ListarMedicos(){
        String sql = "SELECT * FROM medico "
                        + "INNER JOIN especialidade ON id_esp_FK = idEsp  "
                        + "ORDER BY nomeMed ";
        conn = Conexao.getConexao();
        
        try{
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while(rs.next()){
                MedicoDTO objMedicoDTO = new MedicoDTO();
                objMedicoDTO.setCpfMed(rs.getString("cpfMed"));
                objMedicoDTO.setNomeMed(rs.getString("nomeMed"));
                objMedicoDTO.setEndMed(rs.getString("endMed"));
                objMedicoDTO.setTelMed(rs.getString("telMed"));
                objMedicoDTO.setCrmMed(rs.getString("crmMed"));
                objMedicoDTO.setEspMed(rs.getInt("id_esp_FK"));
                objMedicoDTO.setNomeEspMed(rs.getString("nomeEsp"));
                lista.add(objMedicoDTO);
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
    public void AlterarMedico(MedicoDTO objMedicoDTO) {
        String sql = "UPDATE medico SET nomeMed = ?, endMed = ?, telMed = ?, crmMed = ?, id_esp_FK = ? WHERE cpfMed = ?";

        conn = Conexao.getConexao();
        try {
            pstm = conn.prepareStatement(sql); 

            pstm.setString(1, objMedicoDTO.getNomeMed());
            pstm.setString(2, objMedicoDTO.getEndMed());
            pstm.setString(3, objMedicoDTO.getTelMed());
            pstm.setString(4, objMedicoDTO.getCrmMed());
            pstm.setInt(5, objMedicoDTO.getEspMed());
            pstm.setString(6, objMedicoDTO.getCpfMed());

            pstm.execute();
            pstm.close();

            JOptionPane.showMessageDialog(null, "Médico alterado com sucesso!");
            conn = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void ExcluirMedico(MedicoDTO objMedicoDTO){
        String sql = "DELETE FROM medico WHERE cpfMed = ?";
        
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objMedicoDTO.getCpfMed());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Médico excluído com sucesso!");
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
     
     public ResultSet CarregarCBX(){
         conn = Conexao.getConexao();
         String sql = "SELECT * FROM medico ORDER BY nomeMed";
         try{
             pstm = conn.prepareStatement(sql);
             return pstm.executeQuery();
         }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
     }
     
     public ResultSet CarregarCBX(int idEsp){
         conn = Conexao.getConexao();
         String sql = "SELECT * FROM medico WHERE id_esp_FK = ? ORDER BY nomeMed";
         try{
             pstm = conn.prepareStatement(sql);
             pstm.setInt(1,idEsp);
             return pstm.executeQuery();
         }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
     }
}

    

