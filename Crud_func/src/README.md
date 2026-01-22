# CRUD de Funcionários - Console Java

Este projeto é um **CRUD (Create, Read, Update, Delete)** desenvolvido em **Java**, funcionando no **console**. Ele permite cadastrar, consultar, atualizar e excluir funcionários diretamente no terminal, com um limite máximo de 100 registros.

O sistema utiliza **arrays** para armazenar os funcionários durante a execução do programa e garante funcionalidades básicas de validação, como **IDs únicos** e formatação de **CPF**.

---

## Funcionalidades

- **Cadastrar funcionário:**  
  - Solicita ID, nome, CPF, status (ativo/inativo) e cargo (somente se ativo).  
  - ID deve ser único; duplicatas não são permitidas.  
  - CPF é formatado automaticamente no padrão `000.000.000-00`.  

- **Consultar funcionários:**  
  - Exibe todos os funcionários cadastrados no console.  
  - Mostra todos os campos: ID, nome, CPF, cargo e status.  

- **Atualizar funcionário:**  
  - Permite alterar qualquer informação de um funcionário existente, usando o ID como referência.  
  - Atualiza nome, CPF, status e cargo.  

- **Excluir funcionário:**  
  - Remove um funcionário do array pelo ID.  
  - Ajusta a lista para não deixar espaços vazios no array.  

- **Interface simples de menu:**  
  - Navegação por opções numeradas no console:  
    1. Cadastrar  
    2. Consultar  
    3. Atualizar  
    4. Excluir  
    0. Sair  

---

## Tecnologias utilizadas

| Tecnologia | Uso no projeto |
|------------|----------------|
| **Java** | Linguagem de programação principal para lógica do CRUD. |
| **Scanner** | Leitura de entradas do usuário via console. |
| **Array** | Armazena até 100 funcionários durante a execução do programa. |

---

## Estrutura do projeto

Crud_func/
├─ src/
│ ├─ Main.java # Classe principal com menu e lógica do CRUD
│ └─ Funcionario.java # Classe modelo com atributos e métodos de exibição


- **Main.java**: Contém o menu, interação com o usuário e métodos de CRUD (cadastrar, consultar, atualizar, excluir).  
- **Funcionario.java**: Classe que representa um funcionário, com atributos `id`, `nome`, `cpf`, `ativo` e `cargo`, além de métodos getters, setters e exibição formatada.

---

## Como usar

1. Abra o projeto em uma IDE Java (Eclipse, IntelliJ, NetBeans, etc.) ou terminal.  
2. Compile os arquivos `.java`. Por exemplo:

```bash
javac src/*.java
Execute o programa:

java src.Main
Navegue pelo menu digitando o número da opção desejada:

1: Cadastrar funcionário

2: Consultar funcionários

3: Atualizar funcionário

4: Excluir funcionário

0: Sair do sistema

Siga as instruções no console para inserir dados.
