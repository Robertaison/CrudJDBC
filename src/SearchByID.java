import javax.swing.*;
import java.sql.*;

public class SearchByID {
    public void funcion() throws SQLException{
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastro", "postgres", "12345")) {
            String id = JOptionPane.showInputDialog("Digite o id da pessoa que deseja consultar");
            String sql = "SELECT * FROM pessoas WHERE id = "+id;
            System.out.println("Connected to PostgreSQL database!");

            try(Statement statement = connection.prepareStatement(sql)){
                ((PreparedStatement) statement).execute();

                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                String nome = resultSet.getString("nome");
                String perfil = resultSet.getString("perfil");
                System.out.println(id);
                System.out.println(nome);
                System.out.println(perfil);

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
