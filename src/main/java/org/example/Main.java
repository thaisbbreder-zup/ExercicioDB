package org.example;

import connection.Conexao;
import service.UsuarioServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = Conexao.getConnection();
        Scanner entradaDoUsuario = new Scanner(System.in);

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                System.out.println("\n----------------------- BEM VINDE AO BANCO DE DADOS DA ZUP! -----------------------");

                System.out.println("\nO nosso banco está assim atualmente: ");
                UsuarioServices.consultaTodosDadosNoBanco(statement);

                System.out.println("\n---- Digite o nome que deseja inserir no final da tabela: ");
                String nomeInserir = entradaDoUsuario.nextLine();
                UsuarioServices.insereDadosNoBanco(statement, nomeInserir);

                System.out.println("\n---- Digite um nome para inserir no id 1: ");
                String novoNome = entradaDoUsuario.nextLine();
                UsuarioServices.atualizaDadosNoBanco(statement, novoNome);

                System.out.println("\n---- Digite o nome que deseja deletar: ");
                String nomeDeletar = entradaDoUsuario.nextLine();
                UsuarioServices.deletaDadosNoBanco(statement, nomeDeletar);

                System.out.println("\n---- Pressione enter para consultar os nomes que restaram!");
                entradaDoUsuario.nextLine();
                UsuarioServices.consultaNomesDoBanco(statement);

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Conexão com o banco de dados falhou!");
        }
    }
}


