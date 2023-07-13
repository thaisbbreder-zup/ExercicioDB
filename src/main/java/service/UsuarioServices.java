package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Manipulação do banco
public class UsuarioServices {
    public static void consultaTodosDadosNoBanco(Statement statement) {
        String sql = "select * from usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_usuario") + " | NOME: " +
                        resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insereDadosNoBanco(Statement statement, String nome) {
        String sql = "insert into usuarios (nome) values ('" + nome + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("Inserção feita com sucesso!\n");
            consultaTodosDadosNoBanco(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizaDadosNoBanco(Statement statement, String novoNome) {
        String sql = "update usuarios SET nome = '" + novoNome + "' where id_usuario = 1";
        try {
            int usuarioUpdate = statement.executeUpdate(sql);
            System.out.println("'" + novoNome + "' foi inserido no ID 1!\n");
            consultaTodosDadosNoBanco(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletaDadosNoBanco(Statement statement, String nome) {
        String sql = "delete from usuarios where nome = '" + nome + "'";
        try {
            int usuarioDeletado = statement.executeUpdate(sql);
            System.out.println("'" + nome + "' foi deletado!\n");
            consultaTodosDadosNoBanco(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultaNomesDoBanco(Statement statement) {
        String sql = "select * from usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("NOME: " +
                        resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}




