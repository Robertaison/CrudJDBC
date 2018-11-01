import javax.swing.*;
import java.sql.SQLException;

public class CrudPessoas {
    public static void main(String[] args) throws SQLException {

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
                        ListDataBase lista = new ListDataBase();
                        lista.function();
                    break;
                case 2:
                        InsertIntoDatabase inserir = new InsertIntoDatabase();
                        inserir.function();
                    break;
                case 3:
                        SearchByID pesquisa = new SearchByID();
                        pesquisa.funcion();
                    break;
                case 4:
                        DeleteByID delete = new DeleteByID();
                        delete.function();
                    break;
                case 5:
                        UpdateAtID update = new UpdateAtID();
                        update.function();
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
