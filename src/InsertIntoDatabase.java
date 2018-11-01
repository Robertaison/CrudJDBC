import javax.swing.*;
import java.sql.*;

public class InsertIntoDatabase {


    public  void function() throws SQLException{
        try (Connection connection = DataBaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            String nome = JOptionPane.showInputDialog("Digite o nome que deseja adicionar");
            String perfil = JOptionPane.showInputDialog("Fale sobre seu perfil");

            String sql = "INSERT INTO pessoas ( nome, perfil) values (?,?)";
            JOptionPane.showMessageDialog(null,"Connected to PostgreSQL database!");

            try(Statement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
                adiciona(nome, perfil, statement);
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

    private static void adiciona(String nome, String perfil,  Statement statement) throws SQLException {
        ((PreparedStatement) statement).setString(1,nome);
        ((PreparedStatement) statement).setString(2,perfil);
        boolean resultado = ((PreparedStatement) statement).execute();
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
