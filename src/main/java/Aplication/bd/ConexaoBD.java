package Aplication.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    // Configurações do banco
    private static String host = "localhost";
    private static String porta = "3306"; 
    private static String db = "apoio_ao_cidadao";
    private static String usuario = "root";     
    private static String senha = "";

    public static Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC",
                usuario, senha
            );
            return c;
        } catch (SQLException e) {
            System.out.println(" Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}
