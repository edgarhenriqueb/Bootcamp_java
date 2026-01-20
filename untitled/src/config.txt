# Sistema CRUD de Funcionários em Java

## Descrição do Projeto

Este projeto consiste no desenvolvimento de um sistema CRUD (Create, Read, Update e Delete) em Java, executado por meio do terminal. O sistema tem como finalidade o gerenciamento de funcionários de uma empresa, permitindo o cadastro, a consulta, a atualização e a exclusão de registros.



---

## Funcionalidades

O sistema disponibiliza um menu interativo com as seguintes opções:

- Cadastro de funcionários, contendo:
  - Identificador único (ID)
  - Nome
  - CPF (informado apenas com números e formatado automaticamente)
  - Status do funcionário (ativo ou inativo)
  - Cargo (apenas para funcionários ativos)

- Consulta de funcionários cadastrados
- Atualização dos dados de um funcionário por meio do ID
- Exclusão de funcionários utilizando o ID
- Encerramento do sistema

---

## Regras de Negócio

- O sistema suporta o cadastro de até 100 funcionários
- Não é permitido o cadastro de funcionários com IDs duplicados
- Funcionários inativos recebem automaticamente o cargo "Sem cargo"
- O CPF deve ser informado apenas com números
- O CPF é formatado automaticamente no padrão XXX.XXX.XXX-XX

---

## Tecnologias Utilizadas

- Java
- java.util.Scanner
- Execução via terminal

---

## Como Executar o Projeto

1. Certifique-se de que o Java JDK esteja instalado no sistema
2. Salve o arquivo principal como `Main.java`
3. Abra o terminal na pasta do projeto
4. Compile o código com o comando:
   ```bash
   javac Main.java


