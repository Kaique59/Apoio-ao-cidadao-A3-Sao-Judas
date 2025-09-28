package Aplication;

import Aplication.telas.LoginTela;

/* coisas que podem ser melhoradas:
testes
arrumar erro na hora do cadastro
arrumar mensagem de erro do cep
arrumar atualzar que apaga as informações, tenho uma ideia, colocar tudo no dao como iterrogação e cada campo como um método

// Supondo que os valores do "POST" estejam em um Map<String, String> chamado postData
public void atualizarDados(int id, Map<String, String> postData) throws Exception {
    String selectSql = "SELECT * FROM dados WHERE id = ?";
    String valor1, valor2, valor3, valor4;

    try (Connection conn = ConexaoBD.obtemConexao();
         PreparedStatement selectPs = conn.prepareStatement(selectSql)) {
        selectPs.setInt(1, id);
        try (ResultSet rs = selectPs.executeQuery()) {
            if (rs.next()) {
                valor1 = postData.getOrDefault("valor1", rs.getString("valor1"));
                valor2 = postData.getOrDefault("valor2", rs.getString("valor2"));
                valor3 = postData.getOrDefault("valor3", rs.getString("valor3"));
                valor4 = postData.getOrDefault("valor4", rs.getString("valor4"));
            } else {
                // Registro não encontrado
                return;
            }
        }
    }

    String updateSql = "UPDATE dados SET valor1 = ?, valor2 = ?, valor3 = ?, valor4 = ? WHERE id = ?";
    try (Connection conn = ConexaoBD.obtemConexao();
         PreparedStatement updatePs = conn.prepareStatement(updateSql)) {
        updatePs.setString(1, valor1);
        updatePs.setString(2, valor2);
        updatePs.setString(3, valor3);
        updatePs.setString(4, valor4);
        updatePs.setInt(5, id);
        updatePs.executeUpdate();
    }
}
caso tudo isso ainad nn der certo, fazer um método para cada campo

agr criar metodo pra atualizar só o endereço no dao
*/
public class Apoio_ao_cidadao {

    public static void main(String[] args) {
        LoginTela t = new LoginTela();
        t.setVisible(true);
    }
}
