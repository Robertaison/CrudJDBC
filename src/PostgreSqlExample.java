import java.sql.*;

public class PostgreSqlExample {
    public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/produto", "postgres", "postgres")) {
        connection.setAutoCommit(false);
        String nome = "Claudinho";
        String perfil = "Brasil";
        int ID = 4;

        String sql = "INSERT INTO pessoas (id, nome, perfil) values (?,?,?)";
        System.out.println("Connected to PostgreSQL database!");

        try(Statement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            adiciona("Joao", "Alucricrazy", 5, statement);
            connection.commit();
            adiciona(nome, perfil, ID, statement);
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

    private static void adiciona(String nome, String perfil, int ID, Statement statement) throws SQLException {
        ((PreparedStatement) statement).setInt(1 , ID);
        ((PreparedStatement) statement).setString(2,nome);
        ((PreparedStatement) statement).setString(3,perfil);
        boolean resultado = ((PreparedStatement) statement).execute();
        System.out.println(resultado);
        ResultSet resultSet = statement.getGeneratedKeys();
        while(resultSet.next()) {
            int id = resultSet.getInt("ID");
            System.out.println(id);
        }
    }
}
