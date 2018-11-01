package dao.implementation;

import model.Pessoa;

import javax.swing.*;
import java.sql.*;

public class InsertIntoDatabase {


    public  void function(Pessoa pessoa) throws SQLException{
        try(Connection connection = DataBaseConnection.getConnection())  {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO pessoas ( nome, perfil) values (?,?)";
            JOptionPane.showMessageDialog(null,"Connected to PostgreSQL database!");

            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
                adiciona(pessoa.getNome(), pessoa.getPerfil(), statement);
                connection.commit();

            }catch (Exception e){
                e.printStackTrace();
                connection.rollback();
            }


        }  catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    private static void adiciona(String nome, String perfil,  PreparedStatement statement) throws SQLException {
        statement.setString(1,nome);
        statement.setString(2,perfil);
        boolean resultado = statement.execute();
        if(resultado){
            JOptionPane.showMessageDialog(null,"Erro.");
        }else{
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                JOptionPane.showMessageDialog(null,"Para pessoa cadastrada foi gerado id: " + id);
            }
        }
    }
}
