package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Conexão com banco
public class Conexao {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/zupfood",
                    "postgres", "thais123");
            if (connection != null) {
                System.out.println("Banco de dados conectado!");
                Statement statement = connection.createStatement();
            } else {
                System.out.println("Conexão com o banco de dados falhou!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
