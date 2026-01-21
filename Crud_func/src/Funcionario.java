package Crud_func.src;

public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private boolean ativo;
    private String cargo;

    public Funcionario(int id, String nome, String cpf, boolean ativo, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = ativo;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Ativo: " + ativo);
        System.out.println("Cargo: " + cargo);
        System.out.println("---------------------------");
    }
}
