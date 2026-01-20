import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // vetores com capacidade para 100 funcionários
        int[] ids = new int[100];
        String[] nomes = new String[100];
        String[] cpfs = new String[100];
        boolean[] ativos = new boolean[100];
        String[] cargos = new String[100];

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

            // função de cadastro de funcionarios
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
                            if (ids[i] == novoId) {
                                idDuplicado = true;
                                System.out.println("❌ ID já existente. Por favor, utilize outro ID.");
                                break;
                            }
                        }

                    } while (idDuplicado);

                    ids[total] = novoId;

                    System.out.print("Nome: ");
                    nomes[total] = sc.nextLine();

                    System.out.print("CPF (somente números): ");
                    String cpf = sc.nextLine();
                    cpfs[total] = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);

                    System.out.print("Funcionário ativo? (true/false): ");
                    ativos[total] = sc.nextBoolean();
                    sc.nextLine();

                    if (ativos[total]) {
                        System.out.print("Cargo: ");
                        cargos[total] = sc.nextLine();
                    } else {
                        cargos[total] = "Sem cargo";
                    }

                    total++;
                    System.out.println("Funcionário cadastrado com sucesso!");
                }

                // metodo de consulta de funcionarios
            } else if (opcao == 2) {

                if (total == 0) {
                    System.out.println("Nenhum funcionário cadastrado.");
                } else {
                    System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
                    for (int i = 0; i < total; i++) {
                        System.out.println("ID: " + ids[i]);
                        System.out.println("Nome: " + nomes[i]);
                        System.out.println("CPF: " + cpfs[i]);
                        System.out.println("Ativo: " + ativos[i]);
                        System.out.println("Cargo: " + cargos[i]);
                        System.out.println("---------------------------");
                    }
                }

                // metodo para atualizar os funcionarios
            } else if (opcao == 3) {

                System.out.print("Digite o ID do funcionário: ");
                int idBusca = sc.nextInt();
                sc.nextLine();

                boolean encontrado = false;

                for (int i = 0; i < total; i++) {
                    if (ids[i] == idBusca) {

                        System.out.print("Novo nome: ");
                        nomes[i] = sc.nextLine();

                        System.out.print("Novo CPF (somente números): ");
                        String cpfNovo = sc.nextLine();
                        cpfs[i] = cpfNovo.substring(0, 3) + "." + cpfNovo.substring(3, 6) + "." + cpfNovo.substring(6, 9) + "-" + cpfNovo.substring(9);

                        System.out.print("Funcionário ativo? (true/false): ");
                        ativos[i] = sc.nextBoolean();
                        sc.nextLine();

                        if (ativos[i]) {
                            System.out.print("Novo cargo: ");
                            cargos[i] = sc.nextLine();
                        } else {
                            cargos[i] = "Sem cargo";
                        }

                        encontrado = true;
                        System.out.println("Dados atualizados com sucesso!");
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Funcionário não encontrado.");
                }

                // Metodo de exclusão de funcionario
            } else if (opcao == 4) {

                System.out.print("Digite o ID do funcionário: ");
                int idExcluir = sc.nextInt();

                boolean removido = false;

                for (int i = 0; i < total; i++) {
                    if (ids[i] == idExcluir) {

                        for (int j = i; j < total - 1; j++) {
                            ids[j] = ids[j + 1];
                            nomes[j] = nomes[j + 1];
                            cpfs[j] = cpfs[j + 1];
                            ativos[j] = ativos[j + 1];
                            cargos[j] = cargos[j + 1];
                        }

                        total--;
                        removido = true;
                        System.out.println("Funcionário excluído com sucesso!");
                        break;
                    }
                }

                if (!removido) {
                    System.out.println("Funcionário não encontrado.");
                }
// função de finalização de sistema
            } else if (opcao == 0) {
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
