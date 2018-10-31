import javax.swing.*;
import java.sql.*;

public class ListDataBase {

    public void function() throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastro", "postgres", "12345")) {
            connection.setAutoCommit(false);

            String sql = "SELECT * FROM pessoas;";
            System.out.println("Connected to PostgreSQL database!");

            try(Statement statement = connection.prepareStatement(sql)){
                ((PreparedStatement) statement).execute();
                ResultSet resultSet = statement.getResultSet();
                String lista = "";
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String perfil = resultSet.getString("perfil");
                    lista += id + "\n" + nome + "\n" + perfil + "\n\n";
                }
                JOptionPane.showMessageDialog(null,lista);
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
