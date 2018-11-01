import javax.swing.*;
import java.sql.*;

public class DeleteByID {
    public void function()throws SQLException{
        try(Connection connection = DataBaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da pessoa que deseja remover"));
            String sql = "DELETE FROM pessoas WHERE id = (?)";
            JOptionPane.showMessageDialog(null,"Connected to PostgreSQL database!");

            try(PreparedStatement statement = connection.prepareStatement(sql)){
                delete(connection, id, statement);

            }catch (Exception e){
                e.printStackTrace();
                connection.rollback();
            }


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    private void delete(Connection connection, int id, PreparedStatement statement) throws SQLException {
        statement.setInt(1,id);
        boolean resultado = statement.execute();
        if(resultado){
            JOptionPane.showMessageDialog(null,"Erro");
        }else{
            JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso");
            connection.commit();
        }
    }
}
