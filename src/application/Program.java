package application;

import repository.ConexaoBd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.next();

        inserir(nome, cpf);

        consulta();

        sc.close();

    }

    public static void inserir(String nome, String cpf) {

        ConexaoBd conexao = new ConexaoBd();
        Connection conn = conexao.conectar();

        try {
            String adicionar = String.format("INSERT INTO cliente (nome, cpf) VALUES ('%s', '%s')", nome, cpf);

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou o cliente " + nome + " no banco de dados");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar um cliente no BD.");
        }
        finally {
            conexao.desconectar(conn);
        }
    }

    public static void consulta() {
        ConexaoBd conexao = new ConexaoBd();
        Connection conn = conexao.conectar();

        try {
            String consulta = "SELECT * FROM cliente";

            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                System.out.print(resultado.getString("nome"));
                System.out.print(" - " + resultado.getString("cpf") + "\n");

            }
        } catch (SQLException ex) {
            System.out.println("NÃ£o conseguiu consultar os dados do Cliente");
        } finally {
            conexao.desconectar(conn);
        }
    }

}
