# Atividades de POO - Java Console

Este projeto contém **três exercícios de Programação Orientada a Objetos (POO)** desenvolvidos em **Java**, todos executados via **console**.  
O sistema permite a criação e manipulação de objetos de diferentes classes: `Pessoa`, `JogadorFute` e `Elevador`.

---

## Funcionalidades

### 1. Cadastro de Pessoa
- Permite registrar uma pessoa com os seguintes dados:
  - Nome
  - Data de nascimento (ano, mês e dia)
  - Altura
- Calcula e exibe informações relevantes sobre a pessoa (por exemplo, idade e dados formatados).  

### 2. Cadastro de Jogador de Futebol
- Permite registrar um jogador com os seguintes dados:
  - Nome
  - Posição (zagueiro, goleiro, meio-campo, atacante)
  - Data de nascimento (ano, mês, dia)
  - Nacionalidade
  - Altura e peso
- Exibe todas as informações do jogador formatadas no console.  

### 3. Controle de Elevador
- Simula o funcionamento de um elevador em um prédio:
  - Inicializa capacidade máxima e número de andares
  - Permite:
    - Entrar pessoas
    - Sair pessoas
    - Subir e descer andares
    - Exibir status atual (andar e quantidade de pessoas)
- Garante que a capacidade máxima não seja ultrapassada e que o elevador não passe dos limites de andares.

---

## Tecnologias utilizadas

| Tecnologia | Uso no projeto |
|------------|----------------|
| **Java** | Linguagem principal para lógica e POO. |
| **Scanner** | Para leitura de entradas do usuário via console. |
| **LocalDate** | Para manipulação de datas (data de nascimento de pessoas e jogadores). |
| **POO (Classes e Objetos)** | Representação de `Pessoa`, `JogadorFute` e `Elevador`. |

---

## Estrutura do projeto

Atv_poo/
├─ src/
│ ├─ Main.java # Classe principal com menus e chamadas para cada exercício
│ ├─ Pessoa.java # Classe Pessoa com atributos, construtor e método de exibição
│ ├─ JogadorFute.java # Classe JogadorFute com atributos e métodos
│ └─ Elevador.java # Classe Elevador com métodos de controle de capacidade e andares


- **Main.java**: Contém o menu principal, seleção de atividades e chamadas para cada exercício.  
- **Pessoa.java**: Representa uma pessoa, com atributos como nome, data de nascimento e altura, e métodos para exibir dados.  
- **JogadorFute.java**: Representa um jogador de futebol, com atributos de posição, nacionalidade, altura, peso e métodos de exibição.  
- **Elevador.java**: Controla o funcionamento de um elevador, com atributos de capacidade, andar atual, total de andares e pessoas presentes.

---

## Como usar

1. Abra o projeto em uma IDE Java (Eclipse, IntelliJ, NetBeans, etc.) ou terminal.  
2. Compile todos os arquivos `.java`:

```bash
javac src/*.java
Execute o programa:

java src.Main
Navegue pelo menu principal digitando o número da opção desejada:

1: Questão Pessoa

2: Questão Jogador de Futebol

3: Questão Elevador

0: Finalizar programa

Siga as instruções no console para inserir dados e interagir com cada exercício.
