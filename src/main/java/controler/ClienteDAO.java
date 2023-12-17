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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ConexaoBD;

/**
 *
 * @author Luan Pereira
 */
public class ClienteDAO {
    
    private ConexaoBD conexao = new ConexaoBD();
    PreparedStatement pstm;
    ResultSet rs;
    
    public void insert(Cliente cliente) throws SQLException{
        Connection con = conexao.getConexao();
        
        try(PreparedStatement pst = con.prepareStatement ("insert into cliente (idCLIENTE, nome, sexo, cpf, VEICULO_idVEICULO) " +
                "values (0,?,?,?,?) ")){
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSexo());
            pst.setInt(3,cliente.getCpf());
            pst.setInt(4, cliente.getIdVeiculo());
            
            pst.executeUpdate();
            
            Statement st = con.createStatement();
            
           ResultSet rs = st.executeQuery("select last_insert_id()") ;
           
           if (rs.next()){
               cliente.setCodigo(rs.getInt(1));
           }
        }
        conexao.close();
    }
    
    public void update(Cliente cliente){
        Connection con = conexao.getConexao();
        String sql = "update cliente set nome = ?, sexo = ?, cpf = ? where idCliente = ?";
        
        try {
             pstm = con.prepareStatement(sql);
             
            pstm.setString(1,cliente.getNome());
            pstm.setString(2,cliente.getSexo());
            pstm.setInt(3,cliente.getCpf());
            pstm.setInt(4,cliente.getCodigo());
            
            pstm.execute();
            pstm.close();
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"erro no update do cliente" + erro);
        }
    }
    
    public void delete(Cliente cliente){
        Connection con = conexao.getConexao();
        String sql = "delete from cliente where idCLiente = ?";
        
        try{
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, cliente.getCodigo());
            
            pstm.execute();
            pstm.close();
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro no delete do cliente" + erro);
        }
    }
    
    public ArrayList<Cliente> PesquisarFuncionario(){
    ArrayList<Cliente> listaCliente = new ArrayList();
    Connection con = conexao.getConexao();
    
    
    String sql = "select * from Cliente";
    
     try {
         PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         
         while(rs.next()){
             Cliente cliente = new Cliente();
             cliente.setCodigo(rs.getInt("idCliente"));
             cliente.setNome(rs.getString("nome"));
             cliente.setSexo(rs.getString("sexo"));
             cliente.setCpf(rs.getInt("cpf"));
             
             
              listaCliente.add(cliente);
              
             
         }
         
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null, "Cliente Pesquisar" + erro);
     }
     return listaCliente;
 }
}
