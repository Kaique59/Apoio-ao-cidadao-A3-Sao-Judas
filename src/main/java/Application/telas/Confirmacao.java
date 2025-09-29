// balão de confirmação da exclusão
package Application.telas;

import Application.classes.Cidadaos;
import Application.classes.Usuario;
import Application.bd.DAO;

import javax.swing.JOptionPane;

public class Confirmacao {
    public static int popUpLogin(String login, String senha) {

        Object[] options = {"Sim",
                    "Cancelar"};
        int c = JOptionPane.showOptionDialog(null,
                "Deseja seguir com a exclusão?",
                "ATENÇÃO!",
                JOptionPane.YES_NO_OPTION, //Pop-up de sim ou não
                JOptionPane.WARNING_MESSAGE, null,  //tipo de msg e icone
                options,  //Texto do botão
                options[0]); //texto default

        if (c == 0){
            try{
                Usuario usuario = new Usuario (0, login, senha);
                DAO dao = new DAO ();
                dao.excluir(usuario);

                JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso! Até mais ):");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Problemas técnicos, tente novamente mais tarde.");
            }
        }
        return c;
    }

    public static int popUpCadastro(int id) {

        Object[] options = {"Sim",
                "Cancelar"};
        int c = JOptionPane.showOptionDialog(null,
                "Deseja seguir com a exclusão?",
                "ATENÇÃO!",
                JOptionPane.YES_NO_OPTION, //Pop-up de sim ou não
                JOptionPane.WARNING_MESSAGE, null,  //tipo de msg e icone
                options,  //Texto do botão
                options[0]); //texto default

        if (c == 0){
            try{
                Cidadaos cidadaos = new Cidadaos(id, " ", " ", " ", " ", " ", " ");
                DAO dao = new DAO();
                dao.excluirNecessidades(cidadaos);
                dao.excluir(cidadaos);
                JOptionPane.showMessageDialog(null, "Pessoa excluida");
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Falha ao excluir. Verifique o id colocado.");
            }
        }
        return c;
    }

}
