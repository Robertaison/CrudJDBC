import javax.swing.*;
import java.sql.*;

public class DeleteByID {
    public void function()throws SQLException{
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastro", "postgres", "12345")) {
            String id = JOptionPane.showInputDialog("Digite o id da pessoa que deseja remover");
            String sql = "DELETE FROM pessoas WHERE id = "+id;
            JOptionPane.showMessageDialog(null,"Connected to PostgreSQL database!");

            try(Statement statement = connection.prepareStatement(sql)){
                boolean resultado = ((PreparedStatement) statement).execute();
                if(resultado){
                    JOptionPane.showMessageDialog(null,"Erro");
                }else{
                    JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso");
                }
            }catch (Exception e){
                e.printStackTrace();
                connection.rollback();
            }


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
