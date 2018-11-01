package dao.implementation;

import model.Pessoa;

import javax.swing.*;
import java.sql.*;

public class UpdateAtID {
    public  void function(int id, Pessoa pessoa) throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            String sql = "UPDATE pessoas SET nome = ?, perfil = ? WHERE id = ?";
            System.out.println("Connected to PostgreSQL database!");

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                update(id, pessoa.getNome(), pessoa.getPerfil(), statement);
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

    private void update(int id, String nome, String perfil, PreparedStatement statement) throws SQLException {
        statement.setString(1,nome);
        statement.setString(2,perfil);
        statement.setInt(3,id);
        statement.executeUpdate();
    }

}
