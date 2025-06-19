import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class FeiraLivros {
    static TreeMap<String, TreeSet<Livro>> autores = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Exibir todos os livros");
            System.out.println("3 - Exibir autores e seus livros");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner);
                    break;
                case 2:
                    exibirLivros();
                    break;
                case 3:
                    exibirAutores();
                    break;
                case 4:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    static void cadastrarLivro(Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        Livro livro = new Livro(titulo, autor, ano);

        autores.putIfAbsent(autor, new TreeSet<>());
        autores.get(autor).add(livro);

        System.out.println("Livro cadastrado!");
    }

    static void exibirLivros() {
        System.out.println("\nTodos os livros cadastrados:");
        for (TreeSet<Livro> livrosDoAutor : autores.values()) {
            for (Livro livro : livrosDoAutor) {
                System.out.println(livro); 
            }
        }
    }

    static void exibirAutores() {
        System.out.println("\nAutores e seus livros:");
        for (String autor : autores.keySet()) {
            System.out.println(autor + ":");
            for (Livro livro : autores.get(autor)) {
                System.out.println("- " + livro.getTitulo() + " (" + livro.getAno() + ")");
            }
        }
    }
}


