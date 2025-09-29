package Application.bd;
//VER SE TA FUNCIONANDO
import Application.classes.Cidadaos;
import Application.classes.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*Data Acess Object, encasula o o codigo de aceeso a bases de dados, apropriado para manipulacao de difwrentes 
tipos de objetos em projetos com muitas classes*/
public class DAO {
    //FUNCIONARIOS 
    public boolean existe (Usuario usuario) throws Exception{
        String sql = "SELECT * FROM tb_funcionario WHERE login = ? AND senha =?";
        try (Connection conn = ConexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    
    public void inserir (Usuario usuario) throws Exception{
        String sql = "INSERT INTO tb_funcionario (login, senha) VALUES (?,?)";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getLogin());
            System.out.println(usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            System.out.println(usuario.getSenha());
            ps.execute();
        }
    }
    
    public void excluir(Usuario usuario) throws Exception{
        String sql = "DELETE FROM tb_funcionario WHERE login = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getLogin());
            ps.execute();
        }                   
    }
    
    //CIDADAOS
    public void inserir (Cidadaos cidadaos) throws Exception{
        String sql = "INSERT INTO tb_cidadaos (nome, cpf, telefone, endereco) VALUES (?,?,?,?)";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cidadaos.getNome());
            ps.setString(2, cidadaos.getCpf());
            ps.setString(3, cidadaos.getTelefone());
            ps.setString(4, cidadaos.getEndereco());
            ps.execute();  
        }
    }
    
    public void inserirNecessidades (Cidadaos cidadaos) throws Exception{
        String sql = "INSERT INTO tb_necessidades (descricao, status) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cidadaos.getNecessidades());
            ps.setString(2, "Não atendido");
            ps.execute();  
                }
    }
    
    public void atualizar(Cidadaos cidadaos) throws Exception{
        String sql = "UPDATE tb_cidadaos SET nome = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cidadaos.getNome());
            ps.setString(2, cidadaos.getTelefone());
            ps.setInt(3, cidadaos.getId());
            ps.execute();
                 }
    }

    public void atualizarEndereco(Cidadaos cidadaos) throws Exception{
        String sql = "UPDATE tb_cidadaos SET endereco = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cidadaos.getEndereco());
            ps.setInt(2, cidadaos.getId());
            ps.execute();
        }
    }
    
    public void atualizarNecessidades(Cidadaos cidadaos) throws Exception{
        String sql = "UPDATE tb_necessidades SET descricao = ?, status = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cidadaos.getNecessidades());
            ps.setString(2, cidadaos.getStatus());
            ps.setInt(3, cidadaos.getId());         
            ps.execute();
                 }
    }
    
  
    //o metodo excluir() deve ser chamado dps do excluirNecessidades() e excluirStatus()
    public void excluir(Cidadaos cidadaos) throws Exception{
        String sql = "DELETE FROM tb_cidadaos WHERE ID = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, cidadaos.getId());
            ps.execute();
                 }                     
    }
    
    public void excluirNecessidades(Cidadaos cidadaos) throws Exception{
        String sql = "DELETE FROM tb_necessidades WHERE ID = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, cidadaos.getId());
            ps.execute();
                 }                     
    }
    
    
    public boolean existe (Cidadaos cidadaos) throws Exception{
        String sql = "SELECT * FROM tb_cidadaos WHERE cpf = ?";
            try (Connection conn = ConexaoBD.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cidadaos.getCpf());
            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    
    public void busca (Cidadaos cidadaos) throws Exception{
        String sql = "SELECT * FROM tb_cidadaos WHERE id = ?";
            try (Connection conn = ConexaoBD.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, cidadaos.getId());
            ps.execute();
        }
    }
}