package Aplication.validacao;

import Aplication.classes.Cidadaos;
import Aplication.bd.DAO;

import javax.swing.*;

public class ValidacaoCadastro {

    public static void validarCadastro(String nome, String cpf, String telefone, String endereco, String necessidades){
        boolean vn;
        boolean vCpf;
        boolean vTel;

        //NOME
        char[] passChars = nome.toCharArray();
        boolean hasNumber = false;
        for (char c : passChars){
            if (Character.isDigit(c)) { //verifica se são digitos
                hasNumber = true; //verrrifica se tem numero
            }
        }
        if (nome.length() > 200 || nome.isEmpty() || hasNumber){ //verifica largura da senha
            vn = false;
        }else {
            vn = true;
        }

        //CPF
        char[] passCharsCpf = cpf.toCharArray();
        boolean hasNumberCpf = false;
        for (char c : passCharsCpf){
            if (Character.isDigit(c)) { //verifica se são digitos
                hasNumberCpf = true; //verrrifica se tem numero
            }
        }
        if (cpf.length() == 11 || hasNumberCpf){ //verifica largura da senha
            vCpf = true;
        }else {
            vCpf = false;
        }

        //TELEFONE
        char[] passCharsTel = telefone.toCharArray();
        boolean hasNumberTel = false;
        for (char c : passChars){
            if (Character.isDigit(c)) { //verifica se são digitos
                hasNumberTel = true; //verrrifica se tem numero
            }
        }
        if (telefone.length() > 10 || hasNumberTel){ //verifica largura da senha
            vTel = true;
        }else {
            vTel = false;
        }

        //VALIDAÇÃO FINAL
        if (vn && vCpf && vTel && !necessidades.isEmpty()){ //a exclamação é o not, ent se não estiver vazia
            try{
                Cidadaos cidadaos = new Cidadaos(0, nome, cpf, telefone, endereco, necessidades, " ");
                DAO dao = new DAO();
                if (dao.existe(cidadaos)){
                    JOptionPane.showMessageDialog(null, "Pessoa já está cadastrada!");
                } else{
                    JOptionPane.showMessageDialog(null, "Pessoa inserida!");
                    dao.inserir(cidadaos);
                    dao.inserirNecessidades(cidadaos);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possivel inserir.");
            }
        } else{
            JOptionPane.showMessageDialog(null, "Erro! Verifique se todas as informações estão corretas.");
        }
    }
}
