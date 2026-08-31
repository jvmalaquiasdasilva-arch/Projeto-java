import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i + 1) + " - " + livros.get(i));
        }
    }


    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + " - " + usuarios.get(i));
        }
    }


    public boolean realizarEmprestimo(Livro livro, Usuario usuario) {
        if (livro == null || usuario == null) {
            return false;
        }
        if (!livro.isDisponivel()) {
            return false;
        }
        livro.setDisponivel(false);
        emprestimos.add(new Emprestimo(livro, usuario));
        return true;
    }

    public boolean devolverLivro(Livro livro) {
        if (livro == null || livro.isDisponivel()) {
            return false;
        }

        Emprestimo emprestimoEncontrado = null;
        for (Emprestimo e : emprestimos) {
            if (e.getLivro() == livro) {
                emprestimoEncontrado = e;
                break;
            }
        }

        if (emprestimoEncontrado != null) {
            emprestimos.remove(emprestimoEncontrado);
        }

        livro.setDisponivel(true);
        return true;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
