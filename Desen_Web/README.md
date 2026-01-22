# CRUD de Funcionários

Um sistema completo de **CRUD (Create, Read, Update, Delete)** para gerenciamento de funcionários, desenvolvido com **HTML5, CSS3, JavaScript Vanilla e Bootstrap 5**.  
O projeto permite **cadastrar, editar, excluir e buscar funcionários**, mantendo os dados salvos localmente no navegador usando **localStorage**.  

Este projeto é ideal para quem quer aprender ou demonstrar conceitos de **manipulação do DOM, formulários, validações e armazenamento local**, com uma interface **responsiva e moderna**.

---

## Funcionalidades

- **Adicionar funcionário:**  
  Preenchimento de formulário com ID, nome, CPF, cargo e status (ativo/inativo).  
- **Editar funcionário:**  
  Atualização de qualquer informação existente no cadastro.  
- **Excluir funcionário:**  
  Exclusão de registros com confirmação para evitar acidentes.  
- **Listagem dinâmica:**  
  Tabela que exibe todos os funcionários, com cores diferenciadas para status ativo/inativo.  
- **Busca e filtro inteligente:**  
  Permite pesquisar por ID, nome, CPF, cargo ou status, com atualização instantânea da tabela.  
- **Alertas visuais:**  
  Mensagens de sucesso ou erro aparecem na tela para feedback do usuário.  
- **Armazenamento local:**  
  Todos os dados são mantidos no navegador via **localStorage**, sem necessidade de banco de dados.  
- **Responsivo e estilizado:**  
  Design limpo, moderno e compatível com desktop e dispositivos móveis.

---

## Tecnologias utilizadas

| Tecnologia | Função no projeto |
|------------|-----------------|
| **HTML5** | Estrutura da página, formulários e tabela de funcionários. |
| **CSS3** | Estilização personalizada, cores, animações e responsividade. |
| **JavaScript (Vanilla)** | Lógica do CRUD: cadastro, edição, exclusão, validação, busca e manipulação do DOM. |
| **Bootstrap 5** | Layout responsivo, modais, botões, tabelas e elementos interativos. |
| **LocalStorage** | Armazenamento dos dados no navegador, permitindo persistência sem backend. |

---

## Como funciona

1. **Cadastro:**  
   - O usuário clica em **Adicionar Funcionário**.  
   - Preenche ID, nome, CPF, cargo e status.  
   - Ao salvar, o funcionário é adicionado à tabela e ao localStorage.  

2. **Edição:**  
   - Ao clicar no ícone ✏️, o formulário é preenchido com os dados do funcionário.  
   - Após alterações e salvamento, os dados são atualizados na tabela e no localStorage.  

3. **Exclusão:**  
   - Ao clicar no ícone 🗑️, uma confirmação é solicitada.  
   - O funcionário é removido da tabela e do localStorage.  

4. **Busca:**  
   - O campo de busca filtra funcionários por qualquer informação (ID, nome, CPF, cargo ou status).  
   - A tabela é atualizada instantaneamente conforme o termo de pesquisa.  

5. **Alertas:**  
   - Todas as ações (cadastro, edição, exclusão) mostram mensagens visuais temporárias na tela para feedback do usuário.

---

---

## Instruções de uso

1. Clone ou faça o download do repositório:

```bash
git clone https://github.com/seu-usuario/crud-funcionarios.git
Abra o arquivo index.html no navegador.

Adicionar funcionário:

Clique em Adicionar Funcionário, preencha o formulário e clique em Salvar.

Editar funcionário:

Clique no ícone ✏️ correspondente ao funcionário, altere os dados e clique em Salvar.

Excluir funcionário:

Clique no ícone 🗑️ e confirme a exclusão.

Buscar funcionário:

Digite no campo de busca e pressione Enter ou clique no ícone 🔍 para filtrar os resultados.


