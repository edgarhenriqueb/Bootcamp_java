package Crud_func.src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Funcionario[] funcionarios = new Funcionario[100];
        int total = 0;
        int opcao;

        do {
            System.out.println("\n=== CRUD DE FUNCIONÁRIOS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            // CADASTRAR
            if (opcao == 1) {

                if (total >= 100) {
                    System.out.println("Limite máximo de funcionários atingido.");
                } else {

                    int novoId;
                    boolean idDuplicado;

                    do {
                        System.out.print("ID: ");
                        novoId = sc.nextInt();
                        sc.nextLine();

                        idDuplicado = false;
                        for (int i = 0; i < total; i++) {
                            if (funcionarios[i].getId() == novoId) {
                                idDuplicado = true;
                                System.out.println("ID já existente.");
                                break;
                            }
                        }
                    } while (idDuplicado);

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF (somente números): ");
                    String cpf = sc.nextLine();
                    cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);

                    System.out.print("Funcionário ativo? (true/false): ");
                    boolean ativo = sc.nextBoolean();
                    sc.nextLine();

                    String cargo;
                    if (ativo) {
                        System.out.print("Cargo: ");
                        cargo = sc.nextLine();
                    } else {
                        cargo = "Sem cargo";
                    }

                    funcionarios[total] = new Funcionario(novoId, nome, cpf, ativo, cargo);
                    total++;

                    System.out.println("Funcionário cadastrado com sucesso!");
                }

                // CONSULTAR
            } else if (opcao == 2) {

                if (total == 0) {
                    System.out.println("Nenhum funcionário cadastrado.");
                } else {
                    System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
                    for (int i = 0; i < total; i++) {
                        funcionarios[i].exibir();
                    }
                }

                // ATUALIZAR
            } else if (opcao == 3) {

                System.out.print("Digite o ID do funcionário: ");
                int idBusca = sc.nextInt();
                sc.nextLine();

                boolean encontrado = false;

                for (int i = 0; i < total; i++) {
                    if (funcionarios[i].getId() == idBusca) {

                        System.out.print("Novo nome: ");
                        funcionarios[i].setNome(sc.nextLine());

                        System.out.print("Novo CPF (somente números): ");
                        String cpfNovo = sc.nextLine();
                        cpfNovo = cpfNovo.substring(0, 3) + "." + cpfNovo.substring(3, 6) + "." + cpfNovo.substring(6, 9) + "-" + cpfNovo.substring(9);
                        funcionarios[i].setCpf(cpfNovo);

                        System.out.print("Funcionário ativo? (true/false): ");
                        boolean ativo = sc.nextBoolean();
                        sc.nextLine();
                        funcionarios[i].setAtivo(ativo);

                        if (ativo) {
                            System.out.print("Novo cargo: ");
                            funcionarios[i].setCargo(sc.nextLine());
                        } else {
                            funcionarios[i].setCargo("Sem cargo");
                        }

                        encontrado = true;
                        System.out.println("Dados atualizados com sucesso!");
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Funcionário não encontrado.");
                }

                // EXCLUIR
            } else if (opcao == 4) {

                System.out.print("Digite o ID do funcionário: ");
                int idExcluir = sc.nextInt();

                boolean removido = false;

                for (int i = 0; i < total; i++) {
                    if (funcionarios[i].getId() == idExcluir) {

                        for (int j = i; j < total - 1; j++) {
                            funcionarios[j] = funcionarios[j + 1];
                        }

                        funcionarios[total - 1] = null;
                        total--;
                        removido = true;

                        System.out.println("Funcionário excluído com sucesso!");
                        break;
                    }
                }

                if (!removido) {
                    System.out.println("Funcionário não encontrado.");
                }

            } else if (opcao == 0) {
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
