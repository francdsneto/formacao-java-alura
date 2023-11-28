package estudos.formacaojava.alura.pratica.estruturasdedados.modelo;

public class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        Aluno a = (Aluno) obj;
        return a.getNome().equals(this.nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
