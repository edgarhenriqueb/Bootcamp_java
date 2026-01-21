package teste;

import java.time.LocalDate;
import java.time.Period;

public class JogadorFute {

    public String nome;
    public String posicao;
    public LocalDate dataNascimento;
    public String nacionalidade;
    public double altura;
    public double peso;

    public JogadorFute(String nome, String posicao, LocalDate dataNascimento, String nacionalidade, double altura, double peso) {
        this.nome = nome;
        this.posicao = posicao.toLowerCase();
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public int tempoParaAposentadoria() {
        int idadeAtual = calcularIdade();
        int idadeAposentadoria;

        switch (posicao) {
            case "goleiro":
                idadeAposentadoria = 40;
                break;
            case "zagueiro":
                idadeAposentadoria = 40;
                break;
            case "meio-campo":
                idadeAposentadoria = 38;
                break;
            case "atacante":
                idadeAposentadoria = 35;
                break;
            default:
                return -1; //caso a posição seja invalida
        }

        return Math.max(idadeAposentadoria - idadeAtual, 0);
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Posição: " + posicao);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Altura: " + altura + " m");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Idade: " + calcularIdade() + " anos");

        int tempo = tempoParaAposentadoria();

        if (tempo > 0) {
            System.out.println("Tempo para aposentadoria: " + tempo + " anos");
        } else if (tempo == 0) {
            System.out.println("Tempo para aposentadoria: 0 anos");
            System.out.println("O jogador já pode se aposentar.");
        } else {
            System.out.println("Posição inválida para cálculo de aposentadoria");
        }
    }
}