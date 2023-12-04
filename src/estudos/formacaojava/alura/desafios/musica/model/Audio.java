package estudos.formacaojava.alura.desafios.musica.model;

public class Audio {

    private String titulo;
    private double duracao;
    private int totalReproducoes;
    private int curtidas;
    private int classificacao;

    public Audio(String titulo, double duracao, int classificacao) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public void curtir() {
        this.curtidas++;
    }

    public void reproduzir() {
        this.totalReproducoes++;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

}
