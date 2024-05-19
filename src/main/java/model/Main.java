package model;

import java.sql.Connection;
import javax.swing.JOptionPane;

public class Main {
  //Caminho do arquivo csv = C:\\Users\\luan0\\OneDrive - SENAC-SC\\Área de Trabalho\\3 Semestre\\csv.csv
  //Caminho do arquivo txt = C:\\Users\\luan0\\OneDrive - SENAC-SC\\Área de Trabalho\\3 Semestre\\txtalan.txt
    public static void main(String[] args) {
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection connection = conexaoBD.getConexao();
        if (connection != null) {
              String[] options = {"Importar CSV", "Importar TXT", "Exportar CSV", "Exportar TXT"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha uma operação:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );

            switch (choice) {
                case 0:
                    // Importar dados do CSV
                    String csvFilePath = JOptionPane.showInputDialog("Digite o caminho do arquivo CSV:");
                    if (csvFilePath != null && !csvFilePath.isEmpty()) {
                        ImportDataCSV.importFromCSV(connection, csvFilePath);
                        JOptionPane.showMessageDialog(null, "Dados importados com sucesso do arquivo " + csvFilePath);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum caminho de arquivo fornecido.");
                    }
                    break;
                case 1:
                    // Importar dados do TXT
                    String txtFilePath = JOptionPane.showInputDialog("Digite o caminho do arquivo TXT:");
                    if (txtFilePath != null && !txtFilePath.isEmpty()) {
                        ImportDataTXT.importFromTXT(connection, txtFilePath);
                        JOptionPane.showMessageDialog(null, "Dados importados com sucesso do arquivo " + txtFilePath);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum caminho de arquivo fornecido.");
                    }
                    break;
               case 2:
                    // Exportar dados para CSV
                    String exportCsvPath = JOptionPane.showInputDialog("Digite o caminho para salvar o arquivo CSV:");
                    if (exportCsvPath != null && !exportCsvPath.isEmpty()) {
                        ExportData.exportToCSV(connection, "C:\\\\Users\\\\luan0\\\\OneDrive - SENAC-SC\\\\Área de Trabalho\\\\3 Semestre\\\\dados.csv");
                        JOptionPane.showMessageDialog(null, "Dados exportados com sucesso para " + exportCsvPath);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum caminho de arquivo fornecido.");
                    }
                    break;
                case 3:
                    // Exportar dados para TXT
                    String exportTxtPath = JOptionPane.showInputDialog("Digite o caminho para salvar o arquivo TXT:");
                    if (exportTxtPath != null && !exportTxtPath.isEmpty()) {
                        ExportData.exportToTXT(connection, "C:\\Users\\luan0\\OneDrive - SENAC-SC\\Área de Trabalho\\3 Semestre\\dados.txt");
                        JOptionPane.showMessageDialog(null, "Dados exportados com sucesso para 'output.txt'");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum caminho de arquivo fornecido.");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Operação cancelada.");
            // Fechar conexão
            conexaoBD.close();
        }
    }
    }
}