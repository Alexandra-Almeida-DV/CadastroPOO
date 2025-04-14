CadastroPOO - Sistema de Cadastro em Java
📝 Descrição
Sistema de cadastro de pessoas físicas e jurídicas com persistência em arquivos binários, desenvolvido em Java como parte de exercício acadêmico de Programação Orientada a Objetos.

🛠️ Pré-requisitos
JDK 8 ou superior

NetBeans IDE (recomendado)

Sistema operacional: Windows, Linux ou macOS

🚀 Como Executar
No NetBeans:
Importar o projeto:

Abra o NetBeans

Arquivo > Abrir Projeto > Selecione a pasta CadastroPOO

Configurar a classe principal:

Clique com o botão direito no projeto > Propriedades

Selecione Executar

Em Classe Principal digite: cadastropoo.CadastroPOO

Clique em OK

Executar o projeto:

Clique com o botão direito no projeto > Executar

Ou use o atalho F6

Via Linha de Comando:
Navegue até a pasta do projeto:

bash
Copy
cd caminho/para/CadastroPOO
Compile o projeto:

bash
Copy
javac -d build src/cadastropoo/*.java src/model/*.java
Execute o programa:

bash
Copy
java -cp build cadastropoo.CadastroPOO
⚙️ Funcionalidades
Cadastro de pessoas físicas (CPF, idade)

Cadastro de pessoas jurídicas (CNPJ)

Persistência em arquivos binários

Recuperação de dados

Operações CRUD completas

📁 Estrutura do Projeto
Copy
CadastroPOO/
├── src/
│   ├── cadastropoo/
│   │   └── CadastroPOO.java         (Classe principal)
│   └── model/
│       ├── Pessoa.java              (Classe base)
│       ├── PessoaFisica.java        (Pessoa física)
│       ├── PessoaJuridica.java      (Pessoa jurídica)
│       ├── PessoaFisicaRepo.java    (Repositório PF)
│       └── PessoaJuridicaRepo.java  (Repositório PJ)
├── pessoas_fisicas.dat              (Dados persistidos PF)
├── pessoas_juridicas.dat            (Dados persistidos PJ)
└── README.md                        (Este arquivo)
🔍 Saída Esperada
Ao executar, o programa mostrará:

Copy
Dados de Pessoa Física Armazenados.
Dados de Pessoa Física Recuperados.
Id: 1
Nome: João Silva
CPF: 111.111.111-11
Idade: 30

Dados de Pessoa Jurídica Armazenados.
Dados de Pessoa Jurídica Recuperados.
Id: 3
Nome: Empresa ABC
CNPJ: 11.111.111/0001-11
🐛 Solução de Problemas
Se encontrar o erro "Could not find or load main class":

Verifique se a classe principal está configurada corretamente

Limpe e reconstrua o projeto (Limpar e Construir)

Delete a pasta build e tente novamente

Verifique se todos os arquivos fonte estão nos locais corretos

📜 Licença
Este projeto foi desenvolvido para fins educacionais.
