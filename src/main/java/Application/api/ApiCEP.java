package Application.api;

import Application.dto.EnderecoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCEP {
    EnderecoDto enderecoDto = new EnderecoDto();

    public EnderecoDto getEndereco(String cep) throws IOException, InterruptedException {
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper(); //localiza os objetos
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class); //le o json e transforma em objeto
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro, verifique o CEP digitado.", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
        return enderecoDto;
    }
}
