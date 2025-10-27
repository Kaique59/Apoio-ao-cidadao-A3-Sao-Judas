# Apoio ao cidadão

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge\&logo=openjdk\&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge\&logo=mysql\&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge\&logo=apache-netbeans-ide\&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge\&logo=intellij-idea\&logoColor=white)

### Projeto educacional.

---

## Sobre o projeto

Projeto avaliativo do primeiro semestre do curso de **Análise e Desenvolvimento de Sistemas (ADS)**.
Ele visa demonstrar os conhecimentos obtidos sobre Java e MySQL.
O sistema foi feito em grupo (na seção *contribuintes* estão os nomes dos integrantes do grupo).

---

### Objetivo

A proposta era criar um sistema que auxiliasse a realização de uma ODS (Objetivo de Desenvolvimento Sustentável), enquanto colocávamos em prática o que foi aprendido durante o semestre.
Nesse caso, escolhemos a **ODS 1** — *acabar com a pobreza em todas as suas formas, em todos os lugares*.

Assim, criamos um sistema capaz de ajudar trabalhadores de locais públicos como ouvidorias, fóruns comunitários e instituições que atendem pessoas em situação precária, permitindo registrar essas pessoas e as suas necessidades que devem ser atendidas pelo governo.

---

### O que faz

* Registra o cadastro do funcionário responsável pelo atendimento, adicionando-o no banco de dados;
* Realiza o login do funcionário, permitindo o acesso ao sistema por meio de uma consulta ao banco de dados;
* Registra informações das pessoas que solicitam ajuda e organiza os tipos de auxílio de que precisam (como cestas básicas, transporte ou apoio financeiro), permitindo um acompanhamento mais eficiente e justo;
* Permite a visualização, atualização e exclusão dos cadastros;
* Permite a busca por cadastros específicos, seja por ID, nome, CEP ou outras informações coletadas;
* Permite a exclusão do cadastro do funcionário;
* Valida todas as informações inseridas, garantindo que os dados sejam precisos e completos.

Embora o sistema não elimine a pobreza diretamente, ele torna o combate à pobreza mais organizado, eficiente e justo, ajudando a garantir que nenhuma pessoa em situação de vulnerabilidade fique sem atendimento.

---

### Tecnologias utilizadas

* **Linguagem de Programação:** Java
* **Interface Gráfica:** Java Swing
* **Banco de dados:** MySQL
* **Controle de versão:** Git e GitHub
* **IDE:** NetBeans e IntelliJ IDEA

  * O NetBeans foi utilizado durante a criação do projeto, incluindo toda a parte gráfica e a maioria do código.
  * O IntelliJ foi utilizado posteriormente para melhorias e correções de bugs.
* **Conexão com o banco de dados:** JDBC (Java Database Connectivity)
* **Padrão de Projeto:** MVC (Model-View-Controller)

---

## Instruções para rodar o projeto localmente

* O projeto utiliza conexão com um banco de dados MySQL local, então é necessário criar um banco com o nome `apoio_ao_cidadao`.
  O arquivo `script.sql` está presente na raiz do projeto e contém o script de criação do banco e suas tabelas.
* Clone o repositório com o comando:

```bash
git clone https://github.com/Gabriel-sgg/Apoio_ao_cidadao.git
```

* Abra o projeto na IDE de sua preferência;
* Na pasta `src\main\Application\bd\`, crie uma Java class chamada `ConexaoBD` e copie o código abaixo:

```java
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
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}
```

Preencha os campos com as informações do seu banco local.

* Execute o projeto pelo arquivo `Apoio_ao_cidadao.java` (em `src\main\Application\`) ou gere um `.jar` configurando essa classe como *Main Class*.

---

### Pré-requisitos

* Acesso ao MySQL (MySQL Workbench ou outro cliente);
* JDK (Java Development Kit) instalado;
* IDE de sua preferência (NetBeans, IntelliJ IDEA, Eclipse etc.);
* Repositório clonado.

---

## Responsáveis

* Gabriel Sales Garcia
* Kaique Santos Silva
* Pedro Henrique Cordeiro
* Daniel Dias Silva
* Lucas Viana Ferreira

**Professor responsável:** Túlio Cearamicoli Vivaldini
