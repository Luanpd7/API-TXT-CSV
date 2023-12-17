/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.ConexaoBD;
import model.Veiculo;

/**
 *
 * @author Luan Pereira
 */
public class VeiculoDAO {
    
    private ConexaoBD conexao = new ConexaoBD();
    PreparedStatement pstm;
    ResultSet rs;
    
    
    public void insert(Veiculo veiculo) throws SQLException{
        
        Connection con = conexao.getConexao();
        try (PreparedStatement pst = con.prepareStatement("insert into Veiculo(idVEICULO, modelo, montadora, placa, TIPO_VEICULO_idTIPO_VEICULO) " + 
                "values (0,?,?,?,?) ")){
            
            pst.setString(1, veiculo.getModelo());
       
            pst.setString(2, veiculo.getMontadora());
            
            pst.setString(3, veiculo.getPlaca());
            
            pst.setInt(4, veiculo.getIdTipoVeiculo()); 
            
            pst.executeUpdate();
            
            Statement st = con.createStatement();
            
            
        }
        conexao.close();
    }
    
  public int getCodigo() {
    Connection con = conexao.getConexao();  //vai abrir a conexao com o bd
    String sql = "select max(idVEICULO) from veiculo"; //variavel sql vai receber um script que vai ser preparado para pst
    try (PreparedStatement pst = con.prepareStatement(sql); //pst recebe o script
         ResultSet rs = pst.executeQuery()) {  //resultSet recebe os dados retornado direto do bd

        if (rs.next()) {
            return rs.getInt(1); // Retorna o valor inteiro
        } else {
            return -1; // Valor padrão ou código de erro se não houver resultados
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Algo deu errado: " + e.getMessage());
        return -1; // Valor padrão ou código de erro em caso de exceção
    }
}
    
    public ResultSet listarTipoVeiculo(){
        Connection con = conexao.getConexao();
        String sql = "select * from tipo_veiculo Order By idTIPO_VEICULO";
        
        try{
            pstm = con.prepareStatement(sql);
            return pstm.executeQuery();
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro na coleta de tipos de veiculos" + erro);
            return null;
        }
        
    }
    
    
    
    
}
