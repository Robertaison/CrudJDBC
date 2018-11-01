package dao.implementation;

import model.Pessoa;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListDataBase {

    public void function() throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection())  {
            connection.setAutoCommit(false);

            String sql = "SELECT * FROM pessoas;";
            System.out.println("Connected to PostgreSQL database!");

            try(PreparedStatement statement = connection.prepareStatement(sql)){
                list(statement);
            }catch (Exception e){
                e.printStackTrace();
                connection.rollback();
            }


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    private void list(PreparedStatement statement) throws SQLException {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String lista = "";
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        Pessoa pessoa;

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String perfil = resultSet.getString("perfil");
            pessoa = new Pessoa(nome, perfil, id);
            pessoas.add(pessoa);
        }

        for(Pessoa aux : pessoas){
            lista += aux;
        }

        JOptionPane.showMessageDialog(null,lista);
    }
}
