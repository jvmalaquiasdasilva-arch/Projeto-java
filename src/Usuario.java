public abstract class Usuario {

    private String nome;
    private String cpf;
    private String email;

    public Usuario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Cada subclasse (Aluno, Funcionario) define seu próprio "tipo" e dados extras
    public abstract String getTipo();

    public abstract String getDadosEspecificos();

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | CPF: " + cpf +
                " | E-mail: " + email +
                " | Tipo: " + getTipo() +
                " | " + getDadosEspecificos();
    }
}
