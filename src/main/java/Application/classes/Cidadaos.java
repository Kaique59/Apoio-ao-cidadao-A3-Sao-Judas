
package Application.classes;
//crud da tabela cidadaos
public class Cidadaos {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String enderecos;
    private String necessidades;
    private String status;
    
    public Cidadaos (int id, String nome, String cpf, String telefone, String endereco, String necessidades, String status){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = endereco;
        this.necessidades = necessidades;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return enderecos;
    }
    public void setEndereco(String endereco) {
        this.enderecos = endereco;
    }

    public String getNecessidades() {
        return necessidades;
    }
    public void setNecessidades(String necessidades) {
        this.necessidades = necessidades;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
