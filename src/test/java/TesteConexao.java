import Application.bd.ConexaoBD;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = ConexaoBD.obtemConexao();
        if (conn != null) {
            System.out.println("✅ Conexão com o banco realizada com sucesso!");
        } else {
            System.out.println("❌ Falha ao conectar ao banco.");
        }
    }
}
