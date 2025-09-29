import Application.api.ApiCEP;
import Application.dto.EnderecoDto;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException, InterruptedException{
        ApiCEP apiCEP = new ApiCEP();
        try{
            EnderecoDto enderecoDto = apiCEP.getEndereco("07500000");
            System.out.println(apiCEP.getEndereco("07500000 \n"));
            System.out.println(enderecoDto.getUf());

        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
