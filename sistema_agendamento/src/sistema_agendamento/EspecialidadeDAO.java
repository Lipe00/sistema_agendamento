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

public class EspecialidadeDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EspecialidadeDTO> lista = new ArrayList<>();
    
    public void cadastrarEspecialidade(EspecialidadeDTO objEspecialidadeDTO){
        String sql = "INSERT INTO `especialidade`(`nomeEsp`) "
                        + "VALUES (?)";
        
        conn = Conexao.getConexao();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objEspecialidadeDTO.getNomeEsp());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Especialidade cadastrada com sucesso!");
            
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 

    }
    
    public ArrayList<EspecialidadeDTO> ListarEspecialidades(){
        String sql = "SELECT * FROM especialidade";
        conn = Conexao.getConexao();
        
        try{
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery(sql);
            
            while(rs.next()){
                EspecialidadeDTO objEspecialidadeDTO = new EspecialidadeDTO();
                objEspecialidadeDTO.setIdEsp(rs.getInt("idEsp"));
                objEspecialidadeDTO.setNomeEsp(rs.getString("nomeEsp"));
                lista.add(objEspecialidadeDTO);
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
    public void AlterarEspecialidade(EspecialidadeDTO objEspecialidadeDTO){
        String sql = "UPDATE especialidade "
                        + "SET nomeEsp = ? "
                        + "WHERE idEsp = ?";
        
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objEspecialidadeDTO.getNomeEsp());
            pstm.setInt(2, objEspecialidadeDTO.getIdEsp());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Especialidade alterada com sucesso!");
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public void ExcluirEspecialidade(EspecialidadeDTO objEspecialidadeDTO){
        String sql = "DELETE FROM especialidade "
                        + "WHERE idEsp = ?";
        
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objEspecialidadeDTO.getIdEsp());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Especialidade excluída com sucesso!");
            conn = null;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public ResultSet carregarCBX(){
        String sql = "SELECT * FROM especialidade "
                        + "ORDER BY nomeEsp";
        
        conn = Conexao.getConexao();
        try{
            pstm = conn.prepareStatement(sql);
          
            return pstm.executeQuery();
        }catch (SQLException erro) {
            System.out.println(erro.getMessage());
            return null; 
        } 
    }
}
