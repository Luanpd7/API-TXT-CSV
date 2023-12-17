/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package projeto_pedro_final;

import javax.swing.JOptionPane;
import model.ConexaoBD;

/**
 *
 * @author Luan Pereira
 */
public class Projeto_pedro_final {

    public static void main(String[] args) {
        ConexaoBD conexao = new ConexaoBD();
         if(conexao.getConexao() != null){
             JOptionPane.showMessageDialog(null,"Conexão com sucesso");
         }
         else{
             JOptionPane.showMessageDialog(null,"Já existe conexão");
         }
    }
}
