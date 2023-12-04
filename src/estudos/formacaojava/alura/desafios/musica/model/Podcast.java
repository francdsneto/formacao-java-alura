package estudos.formacaojava.alura.desafios.musica.model;

public class Podcast extends Audio {

    private String apresentador;
    private String descricao;

    public Podcast(String apresentador, String descricao, String titulo, double duracao, int classificacao) {
        super(titulo, duracao, classificacao);
        this.apresentador = apresentador;
        this.descricao = descricao;
    }

    public String getApresentador() {
        return apresentador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Classificação de 0 a 10
     * @return
     */
    @Override
    public int getClassificacao() {
        if(this.getTotalReproducoes() > 0 && this.getCurtidas() > 0)
        {
            double media = (double) this.getCurtidas() / this.getTotalReproducoes();
            media = media > 1 ? 1 : media;
            return (int) Math.round(media* 10);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "apresentador='" + apresentador + '\'' +
                ", descricao='" + descricao + '\'' +
                ", titulo='" + this.getTitulo() + '\'' +
                ", duracao='" + this.getDuracao() + '\'' +
                ", totalReproducoes=" + this.getTotalReproducoes() +
                ", curtidas=" + this.getCurtidas() +
                ", classificacao='" + this.getClassificacao() + '\'' +
                '}';
    }
}
