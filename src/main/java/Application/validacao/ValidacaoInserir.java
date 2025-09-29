package Application.validacao;

import Application.classes.Cidadaos;
import Application.bd.DAO;

import javax.swing.*;

public class ValidacaoInserir {

    public static boolean validarInserir(String nome, String cpf, String telefone, String endereco, String necessidades){
        boolean vn;
        boolean vCpf;
        boolean vTel;

        //NOME
        char[] passChars = nome.toCharArray();
        boolean hasNumber = false;
        for (char c : passChars){
            if (Character.isDigit(c)) { //verifica se são digitos
                hasNumber = true; //verifica se tem numero
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
        //verifica largura da senha, if else simplificado
        vCpf = cpf.length() == 11 || hasNumberCpf;

        //TELEFONE
        char[] passCharsTel = telefone.toCharArray();
        boolean hasNumberTel = false;
        for (char c : passChars){
            if (Character.isDigit(c)) { //verifica se são digitos
                hasNumberTel = true; //verifica se tem numero
            }
        }
        //verifica largura da senha, if else simplificado
        vTel = telefone.length() > 10 || hasNumberTel;

        //VALIDAÇÃO FINAL
        if (vn && vCpf && vTel && !necessidades.isEmpty() ){ //a exclamação é o not, ent se não estiver vazia
            try{
                Cidadaos cidadaos = new Cidadaos(0, nome, cpf, telefone, endereco, necessidades, " ");
                DAO dao = new DAO();
                if (dao.existe(cidadaos)){
                    JOptionPane.showMessageDialog(null, "Pessoa já está cadastrada!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, "Pessoa inserida!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dao.inserir(cidadaos);
                    dao.inserirNecessidades(cidadaos);
                    return true;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível inserir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Erro! Verifique se todas as informações estão corretas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
