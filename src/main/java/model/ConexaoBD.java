package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {

    private Connection connection = null;

    public Connection getConexao() {
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/bd.excel";

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, "root", "root");
            return connection;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado. " + e.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados. " + e.toString());
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao fechar o banco de dados" + e.toString());
        }

    }

    public void importarDadosDoTXT() {
        String filePath = "C:\\Users\\luan0\\OneDrive - SENAC-SC\\Área de Trabalho\\3 Semestre\\txtalan.txt";

        // Obter a conexão com o banco de dados
        Connection connection = getConexao();
        if (connection != null) {
            // Importar dados do arquivo txt para o banco de dados
            ImportDataTXT.importFromTXT(connection, filePath);

            // Fechar a conexão com o banco de dados
            close();
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao obter a conexão com o banco de dados.");
        }
    }
}