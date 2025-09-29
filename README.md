# Apoio ao cidadão
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
### Projeto educacional.

---
## Sobre o projeto
Projeto avaliativo do primeiro semestre do curso de ciência da computação. Ele visa demonstrar os conhecimentos obtidos sobre Java e MySQL. \
 O sistema foi feito em grupo (na seção contribuintes estão os nomes dos integrantes do grupo).

---
### Objetivo:
A proposta era de criar um sistema que auxiliasse a realização de uma ODS (Objetivo de desenvolvimento Sustentável), enquanto colocamos em prática o que foi aprendido durante o semestre. Nesse caso escolhemos a ODS 1 (acabar com a pobreza em todas as suas formas, em todos os
lugares).
Assim criamos um sistema capaz de ajudar os trabalhadores de locais públicos como ouvidorias, fóruns
comunitários e instituições que atendem pessoas em situação precária, permitindo registrar essas pessoas e as suas necessidades que devem ser atendidas pelo governo. 

### O que faz
- Registra o cadastro do funcionário responsável pelo atendimento, o adicionando no banco de dados;
- Realiza o ‘login’ do funcionário, permitindo o acesso ao sistema por meio de uma consulta ao banco de dados;
- Registrar informações das pessoas que solicitam ajuda e organizar os
  tipos de auxílio de que precisam, como cestas básicas, transporte, ou apoio
  financeiro, permitindo um acompanhamento mais eficiente e justo;
- Permite a visualização, atualização e a exclusão dos cadastros;
- Permite a busca por cadastros específicos, seja por id, nome, cep ou outras informações coletadas;
- Permite a exclusão do cadastro do funcionário;
- Além disso, ele valida todas as informações inseridas, garantindo que os dados sejam
  precisos e completos.

Embora o sistema não elimine a pobreza diretamente, ele torna o combate à
pobreza mais organizado, eficiente e justo, ajudando a garantir que nenhuma
pessoa em situação de vulnerabilidade fique sem atendimento.

### Tecnologias utilizadas
- Linguagem de Programação: Java;
- Interface Gráfica: Java Swing;
- Banco de dados: MySQL;
- Controle de versão: Git e GitHub;
- IDE: NetBeans e IntelliJ IDEA. \
O NetBeans foi utilizado durante a criação do projeto, toda a parte gráfica e a maioria do código foi escrito nele. Porém, ao revisitar o projeto para fazer melhorias e correções de ‘bugs’, o IntelliJ foi utilizado.
- Conexão com o banco de dados: JDBC (Java Database Connectivity).
- Padrão de Projeto: MVC (Model-View-Controller)

---
## Instruções para rodar o projeto localmente
- O projeta utiliza conexão com um banco de dados MySQL local, então é necessário a criação de um com o nome `apoio_ao_cidadao`, o arquivo ```script.sql``` está presente na raiz do projeto, ele contém o script para a criação do banco de dados e suas tabelas.;
- Clone o repositório com o seguinte comando no terminal:
```git clone https://github.com/Gabriel-sgg/Apoio_ao_cidadao.git```;
- Abra o projeto na IDE de sua preferência;
- Na pasta ```src\main\Application\bd\``` crie uma Java class chamada ConexaoBD, e copie o seguinte código:
~~~java
package Application.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    // Configurações do banco
    private static String host = "";
    private static String porta = "";
    private static String db = "";
    private static String usuario = "";
    private static String senha = "";

    public static Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC",
                usuario, senha
            );
            return c;
        } catch (SQLException e) {
            System.out.println(" Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}
~~~
Nos campos vazios insira as informações do seu banco de dados local;
- Execute o projeto, ele pode ser executado pelo arquivo ```Apoio_ao_cidadao.java``` que está na pasta ```src\main\Application\```, ou crie um arquivo .jar pela IDE que utilize o mesmo arquivo como main class.


### Pré-requisitos 
- Acesso ao MySQL (pode ser o MySQL Workbench ou outro software de sua preferência);
- JDK (Java Development Kit) instalado na máquina;
- IDE da sua preferência (NetBeans, IntelliJ IDEA, Eclipse, etc);
- Clonar este repositório.

---
## Responsáveis
- Gabriel Sales Garcia;
- Kaique Santos Silva;
- Pedro Henrique Cordeiro;
- Daniel Dias Silva;
- Lucas Viana Ferreira. 
- Professor responsável: Túlio Cearamicoli Vivaldini.
