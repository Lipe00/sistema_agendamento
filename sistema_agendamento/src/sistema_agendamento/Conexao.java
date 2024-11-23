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
import javax.swing.JOptionPane;

public class Conexao {
    
     public static String status = "Não conectou..."; 
    
    public static java.sql.Connection getConexao() {
        Connection conn = null; //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão
             String driverName = "com.mysql.cj.jdbc.Driver";
             Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
             String url = "jdbc:mysql://localhost:3306/sistema_agendamento";
             String username = "root"; //nome de um usuário de seu BD
             String password = ""; //sua senha de acesso
             conn = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//
             if (conn != null) {
                status = ("STATUS--->Conectado com sucesso!");
             } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
             }
             return conn;
        } catch (ClassNotFoundException e) {
            //Driver não encontrado
             JOptionPane.showMessageDialog(null, "O driver expecificado nao foi encontrado.");
             return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
             JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
    
    //MÉTODO PARA VERIFICAR O STATUS DA CONEXÃO
    public static String statusConection() {
        return status;
    } 
    
    //MÉTODO PARA FECHAR A CONEXÃO
    public static boolean FecharConexao() {
        try {
            Conexao.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    } 
    
    //MÉTODO PARA REINICIAR A CONEXÃO
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return Conexao.getConexao();
    } 




    
}
