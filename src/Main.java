import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {

        int opcao = 0;

        while (opcao != 7) {

            System.out.println("===== SISTEMA DA BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Devolver Livro");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                cadastrarLivro();

            } else if (opcao == 2) {
                System.out.println("\n--- LISTA DE LIVROS ---");
                biblioteca.listarLivros();

            } else if (opcao == 3) {
                cadastrarUsuario();

            } else if (opcao == 4) {
                System.out.println("\n--- LISTA DE USUÁRIOS ---");
                biblioteca.listarUsuarios();

            } else if (opcao == 5) {
                realizarEmprestimo();

            } else if (opcao == 6) {
                devolverLivro();

            } else if (opcao == 7) {
                System.out.println("Saindo do sistema...");

            } else {
                System.out.println("Opção inválida!");
            }

            System.out.println();
        }

        scanner.close();
    }


    static void cadastrarLivro() {
        System.out.println("\n--- CADASTRO DE LIVRO ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano de publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(titulo, autor, ano);
        biblioteca.cadastrarLivro(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }


    static void cadastrarUsuario() {
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        System.out.println("1 - Aluno");
        System.out.println("2 - Funcionário");
        System.out.print("Escolha o tipo de usuário: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            System.out.print("Turma: ");
            String turma = scanner.nextLine();

            Aluno aluno = new Aluno(nome, cpf, email, curso, turma);
            biblioteca.cadastrarUsuario(aluno);
            System.out.println("Aluno cadastrado com sucesso!");

        } else if (tipo == 2) {
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();

            Funcionario funcionario = new Funcionario(nome, cpf, email, cargo);
            biblioteca.cadastrarUsuario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");

        } else {
            System.out.println("Tipo de usuário inválido! Cadastro cancelado.");
        }
    }


    static void realizarEmprestimo() {
        System.out.println("\n--- REALIZAR EMPRÉSTIMO ---");

        System.out.println("Livros:");
        biblioteca.listarLivros();
        System.out.print("Escolha o número do livro: ");
        int indiceLivro = scanner.nextInt() - 1;

        System.out.println("Usuários:");
        biblioteca.listarUsuarios();
        System.out.print("Escolha o número do usuário: ");
        int indiceUsuario = scanner.nextInt() - 1;
        scanner.nextLine();

        Livro livro = biblioteca.getLivros().get(indiceLivro);
        Usuario usuario = biblioteca.getUsuarios().get(indiceUsuario);

        boolean sucesso = biblioteca.realizarEmprestimo(livro, usuario);

        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Não foi possível emprestar. O livro está indisponível.");
        }
    }

    static void devolverLivro() {
        System.out.println("\n--- DEVOLVER LIVRO ---");

        biblioteca.listarLivros();
        System.out.print("Escolha o número do livro a devolver: ");
        int indiceLivro = scanner.nextInt() - 1;
        scanner.nextLine();

        Livro livro = biblioteca.getLivros().get(indiceLivro);
        boolean sucesso = biblioteca.devolverLivro(livro);

        if (sucesso) {
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Este livro já estava disponível.");
        }
    }
}
