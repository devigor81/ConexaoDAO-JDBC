package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {

    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://babar.db.elephantsql.com/", "selxcqhy", "F53jmLFeEdty24276YRi1b5W_YJJo2Ej");
        } catch (SQLException ex) {
            System.out.println("Erro: NÃ£o conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: NÃ£o encontrou o driver do BD.");
        }

        return conn;
    }

    public void desconectar(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("NÃ£o conseguiu desconectar do BD.");
        }
    }

}
