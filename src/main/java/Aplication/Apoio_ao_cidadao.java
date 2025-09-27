package Aplication;

import Aplication.telas.LoginTela;

/* coisas que podem ser melhoradas:
testes
arrumar erro na hora do cadastro
arrumar mensagem de erro do cep
arrumar atualzar que apaga as informações, tenho uma ideia, colocar tudo no dao como iterrogação e cada campo como um método
*/
public class Apoio_ao_cidadao {

    public static void main(String[] args) {
        LoginTela t = new LoginTela();
        t.setVisible(true);
    }
}
