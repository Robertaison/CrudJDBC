import javax.swing.*;
import java.sql.*;

public class UpdateAtID {
    public  void function() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastro", "postgres", "12345")) {
            connection.setAutoCommit(false);

            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id que será alterado"));
            String nome = JOptionPane.showInputDialog("Digite o nome que deseja adicionar");
            String perfil = JOptionPane.showInputDialog("Fale sobre seu perfil");


            String sql = "UPDATE pessoas SET nome = ?, perfil = ? WHERE id = ?";
            System.out.println("Connected to PostgreSQL database!");

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,nome);
                statement.setString(2,perfil);
                statement.setInt(3,id);
                statement.executeUpdate();
                connection.commit();


            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
            }



        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}
