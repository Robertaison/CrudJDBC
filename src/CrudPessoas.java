import javax.swing.*;

public class CrudPessoas {
    public static void main(String[] args){

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }
}
