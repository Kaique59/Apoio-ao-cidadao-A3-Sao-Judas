package Application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDto {

    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;



    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "cep='" + cep + '\'' +
                ", \nlogradouro='" + logradouro + '\'' +
                ", \ncomplemento='" + complemento + '\'' +
                ", \nunidade='" + unidade + '\'' +
                ", \nbairro='" + bairro + '\'' +
                ", \nlocalidade='" + localidade + '\'' +
                ", \nuf='" + uf + '\'' +
                ", \nestado='" + estado + '\'' +
                ", \nregiao='" + regiao + '\'' +
                ", \nibge='" + ibge + '\'' +
                ", \ngia='" + gia + '\'' +
                ", \nddd='" + ddd + '\'' +
                ", \nsiafi='" + siafi + '\'';
    }
}
