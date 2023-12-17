/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan Pereira
 */
public class ConexaoBD {
    
    public Connection connection = null;
    
    
    public Connection getConexao()  {
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/mydb";
        
        try{
           Class.forName(DRIVER);
           connection = DriverManager.getConnection(URL,"root","root");
           return connection;
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Driver não encontrado. " +e.toString() );
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Problemas de conexão com o banco de dados. " +e.toString());
        }
        return null;
    }
    
    public void close (){
        try{
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Problemas ao fechar o banco de dados" +e.toString());
        }
        
    }
    
}
