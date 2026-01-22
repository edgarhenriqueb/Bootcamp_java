// ==============================
// Inicialização de dados
// ==============================

// Recupera a lista de funcionários do localStorage, ou cria um array vazio se não existir
let funcionarios = JSON.parse(localStorage.getItem("funcionarios")) || [];

// ==============================
// Seleção de elementos do DOM
// ==============================
const tabela = document.getElementById("tabelaFuncionarios"); // Tabela para listar funcionários
const form = document.getElementById("formFuncionario"); // Formulário de cadastro/edição
const alerta = document.getElementById("alerta"); // Elemento para mostrar alertas

const modalFuncionarioEl = document.getElementById("modalFuncionario"); // Modal do Bootstrap
const modalBootstrap = new bootstrap.Modal(modalFuncionarioEl); // Inicializa o modal do Bootstrap

const btnAdicionar = document.getElementById("btnAdicionar"); // Botão para adicionar novo funcionário
const inputBusca = document.getElementById("inputBusca"); // Campo de busca
const btnBuscar = document.getElementById("btnBuscar"); // Botão para buscar

// ==============================
// Eventos
// ==============================

// Clique no botão "Adicionar" abre o modal em modo de cadastro
btnAdicionar.addEventListener("click", () => {
  form.reset(); // Limpa o formulário
  document.getElementById("modoEdicao").value = ""; // Define que não é edição
  document.getElementById("modalFuncionarioLabel").textContent = "Cadastrar Funcionário"; // Atualiza título do modal
  modalBootstrap.show(); // Abre o modal
});

// Submissão do formulário (cadastro ou edição)
form.addEventListener("submit", (e) => {
  e.preventDefault(); // Evita recarregar a página

  // Captura os valores do formulário
  const id = document.getElementById("id").value.trim();
  const nome = document.getElementById("nome").value.trim();
  const cpf = formatarCPF(document.getElementById("cpf").value.trim());
  const cargo = document.getElementById("cargo").value.trim() || "Sem cargo";
  const ativo = document.getElementById("ativo").value === "true";

  const modoEdicao = document.getElementById("modoEdicao").value;

  // ==============================
  // Cadastro
  // ==============================
  if (modoEdicao === "") {
    // Verifica se já existe um funcionário com o mesmo ID
    if (funcionarios.some(f => f.id == id)) {
      mostrarAlerta("ID já existente!", "danger");
      return;
    }
    // Adiciona novo funcionário
    funcionarios.push({ id, nome, cpf, cargo, ativo });
    mostrarAlerta(`O cadastro do funcionário ${nome} foi realizado com sucesso!`, "success");
  } 
  // ==============================
  // Edição
  // ==============================
  else {
    // Atualiza dados do funcionário existente
    const index = funcionarios.findIndex(f => f.id == modoEdicao);
    funcionarios[index] = { id, nome, cpf, cargo, ativo };
    mostrarAlerta(`Dados do funcionário ${nome} atualizados com sucesso!`, "success");
  }

  salvar(); // Salva alterações no localStorage e atualiza a tabela
  modalBootstrap.hide(); // Fecha o modal
});

// ==============================
// Funções principais
// ==============================

// Lista os funcionários na tabela
function listar(dados = funcionarios) {
  tabela.innerHTML = "";

  if (dados.length === 0) {
    tabela.innerHTML = `
      <tr>
        <td colspan="6" class="text-center text-muted py-4">
          Nenhum funcionário encontrado.
        </td>
      </tr>`;
    return;
  }

  // Preenche a tabela com os funcionários
  dados.forEach(f => {
    tabela.innerHTML += `
      <tr>
        <td>${f.id}</td>
        <td>${f.nome}</td>
        <td>${f.cpf}</td>
        <td>${f.cargo}</td>
        <td class="${f.ativo ? "status-ativo" : "status-inativo"}">${f.ativo ? "Ativo" : "Inativo"}</td>
        <td>
          <button class="btn btn-outline-primary btn-sm acao-btn me-2" onclick="editar(${f.id})" title="Editar">
            ✏️
          </button>
          <button class="btn btn-outline-danger btn-sm acao-btn" onclick="excluir(${f.id})" title="Excluir">
            🗑️
          </button>
        </td>
      </tr>
    `;
  });
}

// Preenche o formulário para edição de um funcionário
function editar(id) {
  const f = funcionarios.find(f => f.id == id);
  if (!f) return;

  document.getElementById("id").value = f.id;
  document.getElementById("nome").value = f.nome;
  document.getElementById("cpf").value = f.cpf.replace(/\D/g, "");
  document.getElementById("cargo").value = f.cargo;
  document.getElementById("ativo").value = f.ativo;

  document.getElementById("modoEdicao").value = f.id; // Define modo edição
  document.getElementById("modalFuncionarioLabel").textContent = "Editar Funcionário"; // Atualiza título
  modalBootstrap.show(); // Abre modal
}

// Exclui um funcionário
function excluir(id) {
  if (confirm("Deseja realmente excluir este funcionário?")) {
    const f = funcionarios.find(f => f.id == id);
    funcionarios = funcionarios.filter(f => f.id != id);
    salvar();
    mostrarAlerta(`O funcionário ${f.nome} foi excluído com sucesso!`, "success");
  }
}

// Salva os dados no localStorage e atualiza a tabela
function salvar() {
  localStorage.setItem("funcionarios", JSON.stringify(funcionarios));
  listar();
}

// Formata CPF no padrão 000.000.000-00
function formatarCPF(cpf) {
  return cpf.replace(/\D/g, "")
    .replace(/(\d{3})(\d)/, "$1.$2")
    .replace(/(\d{3})(\d)/, "$1.$2")
    .replace(/(\d{3})(\d{1,2})$/, "$1-$2");
}

// Filtra funcionários com base em um termo de busca
function filtrarFuncionarios(termo) {
  termo = termo.trim().toLowerCase();

  if (termo === "") {
    listar(funcionarios);
    return;
  }

  const filtrados = funcionarios.filter(f => {
    return (
      f.id.toString().includes(termo) ||
      f.nome.toLowerCase().includes(termo) ||
      f.cpf.toLowerCase().includes(termo) ||
      f.cargo.toLowerCase().includes(termo) ||
      (f.ativo ? "ativo" : "inativo").includes(termo)
    );
  });

  listar(filtrados);
}

// Eventos de busca
btnBuscar.addEventListener("click", () => {
  filtrarFuncionarios(inputBusca.value);
});

inputBusca.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    filtrarFuncionarios(inputBusca.value);
  }
});

// ==============================
// Função de alerta
// ==============================

let alertaTimeout;

// Exibe mensagens de alerta na tela
function mostrarAlerta(msg, tipo = "success") {
  clearTimeout(alertaTimeout);

  alerta.textContent = msg;
  alerta.className = `position-fixed bottom-0 start-50 translate-middle-x mb-4 px-4 py-2 rounded-3 shadow alert alert-${tipo} show d-block`;
  alerta.style.opacity = 0.95;

  alertaTimeout = setTimeout(() => {
    alerta.style.opacity = 0;
    setTimeout(() => {
      alerta.className = "d-none";
    }, 500);
  }, 3000);
}

// ==============================
// Inicialização
// ==============================

// Lista os funcionários ao carregar a página
listar();
