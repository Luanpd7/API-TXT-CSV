package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportData {

    public static void exportToCSV(Connection connection, String filePath) {
        String query = "SELECT * FROM f_registros";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter csvWriter = Files.newBufferedWriter(Paths.get(filePath))) {

            // Escreva o cabeçalho
            csvWriter.write("GENERO,CATEGORIA,MIDIA,TIPO MIDIA,CLASSIFICACAO,PARTICIPANTE");
            csvWriter.newLine();

            // Escreva os dados
            while (rs.next()) {
                csvWriter.write(rs.getString("GENERO") + ","
                        + rs.getString("CATEGORIA") + ","
                        + rs.getString("MIDIA") + ","
                        + rs.getString("TIPO_MIDIA") + ","
                        + rs.getString("CLASSIFICACAO") + ","
                        + rs.getString("PARTICIPANTE"));
                csvWriter.newLine();
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    
     public static void exportToTXT(Connection connection, String filePath) {
        String query = "SELECT * FROM f_registros"; // Substitua com sua tabela e colunas reais

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter txtWriter = Files.newBufferedWriter(Paths.get(filePath))) {

            // Escreva o cabeçalho
            txtWriter.write("GENERO CATEGORIA MIDIA TIPO_MIDIA CLASSIFICACAO PARTICIPANTE");
            txtWriter.newLine();

            // Escreva os dados
            while (rs.next()) {
                txtWriter.write(rs.getString("GENERO") + " "
                        + rs.getString("CATEGORIA") + " "
                        + rs.getString("MIDIA") + " "
                        + rs.getString("TIPO_MIDIA") + " "
                        + rs.getString("CLASSIFICACAO") + " "
                        + rs.getString("PARTICIPANTE"));
                txtWriter.newLine();
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}