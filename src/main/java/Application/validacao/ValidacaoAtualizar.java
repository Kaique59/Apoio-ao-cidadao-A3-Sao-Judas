package Application.validacao;

import Application.bd.DAO;
import Application.classes.Cidadaos;

import javax.swing.*;

public class ValidacaoAtualizar {

    public static boolean validarAtualizar(int id, String nome, String telefone, String endereco, String necessidades, String status, String cep){
        boolean vn;
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

        //TELEFONE
        char[] passCharsTel = telefone.toCharArray();
        boolean hasNumberTel = false;
        for (char c : passChars){
            if (Character.isDigit(c)) { //verifica se são digitos
                hasNumberTel = true; //verifica se tem numero
            }
        }
        //verifica largura da senha, if e else simplificado
        vTel = telefone.length() > 10 || hasNumberTel;

        //VALIDAÇÃO FINAL
        if (vn && vTel){
            try{
                Cidadaos cidadaos = new Cidadaos(id, nome, " ", telefone, endereco, necessidades, status);
                DAO dao = new DAO();
                dao.atualizar(cidadaos);
                dao.atualizarNecessidades(cidadaos);
                if (!cep.isEmpty()){dao.atualizarEndereco(cidadaos);}
                JOptionPane.showMessageDialog(null, "Pessoa atualizada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Erro! Verifique se todas as informações estão corretas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
