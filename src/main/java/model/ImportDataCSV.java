package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ImportDataCSV {

    public static void importFromCSV(Connection connection, String filePath) {
          if (filePath == null || filePath.isEmpty()) {
            System.out.println("O caminho do arquivo é nulo ou vazio.");
            return;
        }
          
        String query = "INSERT INTO f_registros (GENERO, CATEGORIA, MIDIA, TIPO_MIDIA, CLASSIFICACAO, PARTICIPANTE) VALUES (?, ?, ?, ?, ?, ?)";

       try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            String line;
            br.readLine(); // Ignora o cabeçalho

             while ((line = br.readLine()) != null) {
                String[] values = line.split(";"); // Use ponto e vírgula como delimitador
               
                // Verifique se a linha tem o número esperado de colunas
                if (values.length != 6) {
                    System.err.println("Linha inválida: " + line);
                    continue;
                }

                pstmt.setString(1, values[0]);
                pstmt.setString(2, values[1]);
                pstmt.setString(3, values[2]);
                pstmt.setString(4, values[3]);
                pstmt.setString(5, values[4]);
                pstmt.setString(6, values[5]);

                pstmt.executeUpdate();
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
