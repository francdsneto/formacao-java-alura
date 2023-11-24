package estudos.formacaojava.alura.screenmatch.modelos;

import estudos.formacaojava.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {

    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "filme='" + getNome() + '\'' +
                "anoLancamento='" + getAnoDeLancamento() + '\'' +
                '}';
    }
}
