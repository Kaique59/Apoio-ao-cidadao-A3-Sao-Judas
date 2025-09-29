package Application.validacao;

import Application.bd.DAO;
import Application.classes.Usuario;

import javax.swing.*;

public class ValidacaoSenha {

    public static boolean validacao(String senha, String login){

        if (senha.length() < 8 || senha.length() > 32 || login.isEmpty()){ //verifica largura da senha ou se tá vazia
            return false;
        }

        char[] passChars = senha.toCharArray();

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasNumber = false;

        for (char c : passChars){
            if (Character.isUpperCase(c)) {
                hasUpper = true; //verifica se tem letra maiusula
            } else if (Character.isLowerCase(c)) {
                hasLower = true; //verifica se tem letra minuscula
            } else if (Character.isDigit(c)) { //verifica se são digitos
                hasNumber = true; //verifica se tem numero
            } else {
                return false;
            }
        }

        if(hasNumber && hasLower && hasUpper){
            return true;
        }

        return false;
    }

    public static boolean cadastro(String login, String senha, boolean validacao){
        if (validacao || !login.isEmpty()){
            try{
                Usuario usuario = new Usuario(0, login, senha);
                DAO dao = new DAO();

                if (dao.existe(usuario)){
                    //vai chegar se ja existe esse login
                    JOptionPane.showMessageDialog(null, "Este usuário ja existe!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                } else {
                    dao.inserir(usuario);
                    JOptionPane.showMessageDialog(null, "Perfil criado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível criar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Senha ou login invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
