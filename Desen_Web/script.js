let funcionarios = JSON.parse(localStorage.getItem("funcionarios")) || [];

const tabela = document.getElementById("tabelaFuncionarios");
const form = document.getElementById("formFuncionario");
const alerta = document.getElementById("alerta");

const modalFuncionarioEl = document.getElementById("modalFuncionario");
const modalBootstrap = new bootstrap.Modal(modalFuncionarioEl);

const btnAdicionar = document.getElementById("btnAdicionar");
const inputBusca = document.getElementById("inputBusca");
const btnBuscar = document.getElementById("btnBuscar");

btnAdicionar.addEventListener("click", () => {
  form.reset();
  document.getElementById("modoEdicao").value = "";
  document.getElementById("modalFuncionarioLabel").textContent = "Cadastrar Funcionário";
  modalBootstrap.show();
});

form.addEventListener("submit", (e) => {
  e.preventDefault();

  const id = document.getElementById("id").value.trim();
  const nome = document.getElementById("nome").value.trim();
  const cpf = formatarCPF(document.getElementById("cpf").value.trim());
  const cargo = document.getElementById("cargo").value.trim() || "Sem cargo";
  const ativo = document.getElementById("ativo").value === "true";

  const modoEdicao = document.getElementById("modoEdicao").value;

  if (modoEdicao === "") {
    if (funcionarios.some(f => f.id == id)) {
      mostrarAlerta("ID já existente!", "danger");
      return;
    }
    funcionarios.push({ id, nome, cpf, cargo, ativo });
    mostrarAlerta(`O cadastro do funcionário ${nome} foi realizado com sucesso!`, "success");
  } else {
    const index = funcionarios.findIndex(f => f.id == modoEdicao);
    funcionarios[index] = { id, nome, cpf, cargo, ativo };
    mostrarAlerta(`Dados do funcionário ${nome} atualizados com sucesso!`, "success");
  }

  salvar();
  modalBootstrap.hide();
});

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

function editar(id) {
  const f = funcionarios.find(f => f.id == id);
  if (!f) return;

  document.getElementById("id").value = f.id;
  document.getElementById("nome").value = f.nome;
  document.getElementById("cpf").value = f.cpf.replace(/\D/g, "");
  document.getElementById("cargo").value = f.cargo;
  document.getElementById("ativo").value = f.ativo;

  document.getElementById("modoEdicao").value = f.id;
  document.getElementById("modalFuncionarioLabel").textContent = "Editar Funcionário";
  modalBootstrap.show();
}

function excluir(id) {
  if (confirm("Deseja realmente excluir este funcionário?")) {
    const f = funcionarios.find(f => f.id == id);
    funcionarios = funcionarios.filter(f => f.id != id);
    salvar();
    mostrarAlerta(`O funcionário ${f.nome} foi excluído com sucesso!`, "success");
  }
}

function salvar() {
  localStorage.setItem("funcionarios", JSON.stringify(funcionarios));
  listar();
}

function formatarCPF(cpf) {
  return cpf.replace(/\D/g, "")
    .replace(/(\d{3})(\d)/, "$1.$2")
    .replace(/(\d{3})(\d)/, "$1.$2")
    .replace(/(\d{3})(\d{1,2})$/, "$1-$2");
}

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

btnBuscar.addEventListener("click", () => {
  filtrarFuncionarios(inputBusca.value);
});

inputBusca.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    filtrarFuncionarios(inputBusca.value);
  }
});

let alertaTimeout;

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

listar();
