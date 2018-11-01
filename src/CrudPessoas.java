import dao.PessoasDAO;
import dao.implementation.*;

import javax.swing.*;
import java.sql.SQLException;

public class CrudPessoas {
    public static void main(String[] args) throws SQLException {
        PessoasDAO pessoasDAO = new PessoasDAO();
        int opcao = 6;

        while(opcao!=0){
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escreva a operação que gostaria de realizar" + "\n" +
                    "------------------------------------------" + "\n\n" +
                    "1. Listar pessoas cadastradas" + "\n" +
                    "2. Adicionar pessoas" + "\n" +
                    "3. Pesquisar pessoas por ID" + "\n" +
                    "4. Deletar por ID" + "\n" +
                    "5. Atualizar pessoa por ID" + "\n\n" +
                    "------------------------------------------" + "\n" +
                    "0. Sair"));

            switch (opcao){
                case 1:
                        pessoasDAO.list();
                    break;
                case 2:
                        pessoasDAO.save();
                    break;
                case 3:
                        pessoasDAO.searchID();
                    break;
                case 4:
                        pessoasDAO.delete();
                    break;
                case 5:
                        pessoasDAO.updateID();
                    break;
                case 0:
                        JOptionPane.showMessageDialog(null,"Saindo...");
                    break;
                default:
                        JOptionPane.showMessageDialog(null,"Digite alguma opcao valida");
                    break;
            }
        }
    }
}
