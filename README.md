# Bootcamp Java

Este repositório reúne as atividades práticas desenvolvidas durante um Bootcamp de Java, com foco no aprendizado da linguagem, Programação Orientada a Objetos (POO) e aplicação prática por meio de projetos de console, incluindo um CRUD de funcionários e exercícios de POO.

O objetivo principal é consolidar os conceitos fundamentais da linguagem Java por meio de exercícios e projetos práticos, permitindo ao usuário praticar lógica de programação, estruturas de controle e manipulação de objetos.

## Estrutura do Repositório

```text
Bootcamp_java/
├── Atv_poo/       # Exercícios de POO (Pessoa, Jogador de Futebol, Elevador)
├── Crud_func/     # Projeto CRUD de funcionários via terminal
├── out/           # Arquivos compilados gerados pelo ambiente de desenvolvimento
└── README.md      # Este arquivo
```
## Descrição das Pastas

### Atv_poo

Esta pasta contém atividades voltadas para Programação Orientada a Objetos em Java.  
Os exercícios abordam os seguintes conceitos:

- Criação e utilização de classes e objetos  
- Encapsulamento  
- Construtores  
- Métodos e manipulação de atributos  
- Organização e estruturação do código  
- Boas práticas em POO  

As atividades incluem:

1. **Cadastro de Pessoa**  
   Permite registrar uma pessoa com nome, data de nascimento e altura, exibindo informações formatadas.

2. **Cadastro de Jogador de Futebol**  
   Permite registrar um jogador com nome, posição, data de nascimento, nacionalidade, altura e peso, exibindo todas as informações.

3. **Simulação de Elevador**  
   Controla um elevador em um prédio, permitindo entrar e sair pessoas, subir e descer andares e exibir o status atual do elevador.

Esses exercícios fortalecem a base conceitual necessária para desenvolver aplicações em Java, reforçando a lógica de programação e a manipulação de objetos.

### Crud_func

Esta pasta contém um CRUD completo de funcionários, executado via console, aplicando conceitos de POO e lógica de programação.

**Funcionalidades implementadas:**

- Cadastro de funcionários com ID, nome, CPF, cargo e status ativo/inativo  
- Listagem de funcionários em tabela no console  
- Atualização de dados de um funcionário existente  
- Exclusão de funcionários  
- Menu interativo para navegação fácil pelo console  

Este projeto aplica de forma prática conceitos fundamentais de Java, como:

- POO (classes, objetos, métodos)  
- Estruturas de controle (if, switch, loops)  
- Coleções e arrays  
- Interação com o usuário via console  

### out

Diretório gerado automaticamente pelo ambiente de desenvolvimento, contendo arquivos compilados do projeto.

## Como Executar os Projetos

### Pré-requisitos

- Java Development Kit (JDK) versão 8 ou superior  
- IDE Java (IntelliJ IDEA, Eclipse, VS Code) ou terminal configurado com Java  

### Execução

```bash
# 1. Abra a pasta do projeto na IDE ou terminal
# 2. Compile os arquivos .java
javac src/*.java

# 3. Execute a classe principal correspondente
java src.Main
