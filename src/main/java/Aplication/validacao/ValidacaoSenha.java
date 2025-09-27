package Aplication.validacao;

import Aplication.bd.DAO;
import Aplication.classes.Usuario;

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
                hasLower = true; //verrifica se tem letra minuscula
            } else if (Character.isDigit(c)) { //verifica se são digitos
                hasNumber = true; //verrrifica se tem numero
            } else {
                return false;
            }
        }

        if(hasNumber && hasLower && hasUpper){
            return true;
        }

        return false;
    }

    public static void cadastro(String login, String senha, boolean validacao){
        if (validacao == true || !login.isEmpty()){
            try{
                Usuario usuario = new Usuario(0, login, senha);
                DAO dao = new DAO();
                if (dao.existe(usuario)){ //vai chegar se ja existe esse login
                    JOptionPane.showMessageDialog(null, "Este usuario ja existe!");
                } else {
                    dao.inserir(usuario);
                    JOptionPane.showMessageDialog(null, "Perfil criado!");
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possivel criar usuário.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Senha invalida");
        }
    }
}
