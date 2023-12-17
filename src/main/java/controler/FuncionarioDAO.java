
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ConexaoBD;
import model.Funcionario;


public class FuncionarioDAO {
    
    private ConexaoBD conexao = new ConexaoBD();
    
    public void insert(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection con = conexao.getConexao();
        
        try(PreparedStatement pst = con.prepareStatement ("insert into funcionario(idFUNCIONARIO, nome, sexo, cpf)" + 
                "values (0,?,?,?)")) {
               
           pst.setString(1,funcionario.getNome());
           pst.setString(2, funcionario.getSexo());
           pst.setInt(3, funcionario.getCpf());

           pst.executeUpdate();
           
           Statement st = con.createStatement(); 
     
           ResultSet rs = st.executeQuery("select last_insert_id()") ;
           
           if(rs.next()){
               funcionario.setCodigo(rs.getInt(1));
           }
        }
        
        conexao.close();
     }
    
  public void update(Funcionario funcionario)throws SQLException{
    try (PreparedStatement pst = conexao.getConexao().prepareStatement
                ("update funcionario set nome = ?, sexo = ?, cpf = ?, " +
                 "where (idFUNCIONARIO = ?)")) {
        
        
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getSexo());
        pst.setInt(3, funcionario.getCpf());
        pst.setInt(4, funcionario.getCodigo());
       
        pst.executeUpdate();
        
      }
    conexao.close();
  }
  
  public void delete (Funcionario funcionario) throws SQLException{
      try(PreparedStatement pst = conexao.getConexao().prepareStatement("delete from funcionario where (idFUNCIONARIO = ?)")){
          pst.setInt(1,funcionario.getCodigo());
          pst.executeUpdate();
          
      }
      conexao.close();
  }
  
  public Funcionario getFuncionarioByCodigo(int codigo) throws SQLException{
      try(Statement st = conexao.getConexao().createStatement();
              ResultSet rs = st.executeQuery
              ("select * from funcionario where (idFUNCIONARIO = "+ codigo + ")")){
          if (rs.next())
              return new Funcionario (rs.getInt("idFUNCIONARIO"),
                                      rs.getString("Nome"),
                                      rs.getString("Sexo"),
                                          rs.getInt("CPF"));
      }
      return null;
  }
  
  public ArrayList<Funcionario> getFuncionarioByLista() throws SQLException{
      ArrayList<Funcionario> lista = new ArrayList<>();
      try(Statement st = conexao.getConexao().createStatement();
              ResultSet rs = st.executeQuery("select * from funcionario order by nome")){
          
          while (rs.next()){
              lista.add(new Funcionario( rs.getInt("idFUNCIONARIO"),
                                      rs.getString("Nome"),
                                      rs.getString("Sexo"),
                                          rs.getInt("CPF")));
             
          }
      }
      return lista;
  }
  

 
   public ArrayList<Funcionario> PesquisarFuncionario(){
    ArrayList<Funcionario> listaFuncionario = new ArrayList();
    Connection con = conexao.getConexao();
    
    
    String sql = "select * from funcionario";
    
     try {
         PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         
         while(rs.next()){
             Funcionario funcionario = new Funcionario();
             funcionario.setCodigo(rs.getInt("idFUNCIONARIO"));
             funcionario.setNome(rs.getString("nome"));
             funcionario.setSexo(rs.getString("sexo"));
             funcionario.setCpf(rs.getInt("cpf"));
             
             
              listaFuncionario.add(funcionario);
              
             
         }
         
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null, "Funcionario Pesquisar" + erro);
     }
     return listaFuncionario;
 }
  

    
    
    
  }
