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
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import model.ConexaoBD;
import model.Servico;

/**
 *
 * @author Luan Pereira
 */
public class ServicoDAO {
     private ConexaoBD conexao = new ConexaoBD();
    PreparedStatement pstm;
    ResultSet rs;
    
    public void insert(Servico servico) throws SQLException{
        Connection con = conexao.getConexao();
        
        try(PreparedStatement pst = con.prepareStatement ("insert into servico (id, numero_apolice, CLIENTE_idCLIENTE, FUNCIONARIO_idFUNCIONARIO, TipoSeguro_id) " +
                "values (0,?,?,?,?) ")){
            
            pst.setInt(1, servico.getNumero_apolice());
            pst.setInt(2, servico.getIdCliente());
            pst.setInt(3,servico.getIdFuncionario());
            pst.setInt(4, servico.getIdTipoSeguro());
         
            
           
            
            pst.executeUpdate();
            
            Statement st = con.createStatement();
            
           ResultSet rs = st.executeQuery("select last_insert_id()") ;
           
          
        }
        conexao.close();
    }
    
  public ResultSet listarCliente(){
        Connection con = conexao.getConexao();
        String sql = "select * from cliente Order By nome";
        
        try{
            pstm = con.prepareStatement(sql);
            return pstm.executeQuery();
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro na coleta de clientes" + erro);
            return null;
        }
}
  
  public ResultSet listarFuncionario(){
        Connection con = conexao.getConexao();
        String sql = "select * from funcionario Order By nome";
        
        try{
            pstm = con.prepareStatement(sql);
            return pstm.executeQuery();
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro na coleta de clientes" + erro);
            return null;
        }
       
}
  public ResultSet listarTipoSeguro(){
       Connection con = conexao.getConexao();
       String sql = "select * from tipo_seguro order by nome";
       
       try{
           pstm = con.prepareStatement(sql);
           return pstm.executeQuery();
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Erro na coleta de tipo de seguro" + e);
            return null;
       }
   }
  
  public ArrayList<Servico> PesquisarServico(){
    ArrayList<Servico> listaServico = new ArrayList();
    Connection con = conexao.getConexao();
    
    
    String sql = "select numero_apolice, c.nome, f.nome, t.nome, modelo from servico inner join cliente as c on CLIENTE_idCLIENTE = idCLIENTE inner join funcionario as f  on FUNCIONARIO_idFUNCIONARIO = idFUNCIONARIO \n" +
"inner join tipo_seguro as t on TipoSeguro_id = idTIPO_SEGURO inner join veiculo on VEICULO_idVEICULO = idVEICULO";
    
     try {
         PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         
         while(rs.next()){
             Servico servico = new Servico();
        
             servico.setNumero_apolice(rs.getInt("numero_apolice"));
             servico.setNomeCliente(rs.getString("c.nome"));
             servico.setNomeFuncionario(rs.getString("f.nome"));
             servico.setNomeTipoSeguro(rs.getString("t.nome"));
             servico.setModelo(rs.getString("modelo"));
             
             
              listaServico.add(servico);
              
             
         }
         
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null, "Cliente Pesquisar" + erro);
     }
     return listaServico;
 }
  
  
  
   public ArrayList<Servico> PesquisarTiposSeguro(){
    ArrayList<Servico> listaServico = new ArrayList();
    Connection con = conexao.getConexao();
    
    
    String sql = "select nome, descricao from tipo_seguro";
    
     try {
         PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         
         while(rs.next()){
             Servico servico = new Servico();
             servico.setNomeTipoSeguro(rs.getString("nome"));
             servico.setDescricao(rs.getString("descricao"));
             
              listaServico.add(servico);
              
             
         }
         
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null, "Tipo seguro Pesquisar" + erro);
     }
     return listaServico;
 }
  
}
