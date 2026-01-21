package Atv_poo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Questão Pessoa");
            System.out.println("2 - Questão Jogador de Futebol");
            System.out.println("3 - Questão Elevador");
            System.out.println("0 - Finalizar programa");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    questaoPessoa(sc);
                    break;
                case 2:
                    questaoJogador(sc);
                    break;
                case 3:
                    questaoElevador(sc);
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    /* ==============================
       QUESTÃO 01 - Pessoa
    =============================== */
    private static void questaoPessoa(Scanner sc) {

        System.out.println("\n=== CADASTRO DE PESSOA ===");

        System.out.print("Nome: ");
        String nomePessoa = sc.nextLine();

        System.out.print("Ano de nascimento: ");
        int ano = sc.nextInt();

        System.out.print("Mês de nascimento(em numero ex 05): ");
        int mes = sc.nextInt();

        System.out.print("Dia de nascimento: ");
        int dia = sc.nextInt();

        System.out.print("Altura (ex: 1,75): ");
        double altura = sc.nextDouble();
        sc.nextLine();

        Pessoa pessoa = new Pessoa(
                nomePessoa,
                LocalDate.of(ano, mes, dia),
                altura
        );

        pessoa.imprimirDados();
    }

    /* ==============================
       QUESTÃO 02 - Jogador de Futebol
    =============================== */
    private static void questaoJogador(Scanner sc) {

        System.out.println("\n=== CADASTRO DE JOGADOR ===");

        System.out.print("Nome: ");
        String nomeJogador = sc.nextLine();

        System.out.print("Posição(zagueiro,goleiro,meio-campo,atacante): ");
        String posicao = sc.nextLine();

        System.out.print("Ano de nascimento: ");
        int ano = sc.nextInt();

        System.out.print("Mês de nascimento(ex:05): ");
        int mes = sc.nextInt();

        System.out.print("Dia de nascimento: ");
        int dia = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Nacionalidade: ");
        String nacionalidade = sc.nextLine();

        System.out.print("Altura (ex: 1,80): ");
        double alturaJogador = sc.nextDouble();

        System.out.print("Peso (em kg ex:70,00): ");
        double peso = sc.nextDouble();
        sc.nextLine();

        JogadorFute jogador = new JogadorFute(
                nomeJogador,
                posicao,
                LocalDate.of(ano, mes, dia),
                nacionalidade,
                alturaJogador,
                peso
        );

        jogador.imprimirDados();
    }

    /* ==============================
       QUESTÃO 03 - Elevador
    =============================== */
    private static void questaoElevador(Scanner sc) {

        System.out.println("\n=== CONTROLE DO ELEVADOR ===");

        Elevador elevador = new Elevador();

        System.out.print("Capacidade do elevador: ");
        int capacidade = sc.nextInt();

        System.out.print("Total de andares (sem térreo): ");
        int totalAndares = sc.nextInt();

        elevador.inicializa(capacidade, totalAndares);

        int opcao;

        do {
            System.out.println("\n--- MENU DO ELEVADOR ---");
            System.out.println("1 - Entrar pessoa");
            System.out.println("2 - Sair pessoa");
            System.out.println("3 - Subir andar");
            System.out.println("4 - Descer andar");
            System.out.println("5 - Mostrar status");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    elevador.entra();
                    break;
                case 2:
                    elevador.sai();
                    break;
                case 3:
                    elevador.sobe();
                    break;
                case 4:
                    elevador.desce();
                    break;
                case 5:
                    System.out.println("Andar atual: " + elevador.getAndarAtual());
                    System.out.println("Pessoas no elevador: " + elevador.getPessoasPresentes());
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
