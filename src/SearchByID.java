import javax.swing.*;
import java.sql.*;

public class SearchByID {
    public void funcion() throws SQLException{
        try(Connection connection = DataBaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da pessoa que deseja consultar"));
            String sql = "SELECT * FROM pessoas WHERE id = (?)";
            System.out.println("Connected to PostgreSQL database!");

            try(PreparedStatement statement = connection.prepareStatement(sql)){
                search(id, statement);

            }catch (Exception e){
                e.printStackTrace();
                connection.rollback();
            }


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    private void search(int id, PreparedStatement statement) throws SQLException {
        statement.setInt(1,id);
        statement.execute();

        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        String nome = resultSet.getString("nome");
        String perfil = resultSet.getString("perfil");
        JOptionPane.showMessageDialog(null,id + "\n" + nome + "\n" + perfil);
    }
}
