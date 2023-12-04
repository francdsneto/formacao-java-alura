package estudos.formacaojava.alura.desafios.musica.model;

public class Musica extends Audio {

    public String album;
    public String cantor;
    private final String genero;

    public Musica(String album, String cantor, String genero, String titulo, double duracao, int classificacao) {
        super(titulo, duracao, classificacao);
        this.album = album;
        this.cantor = cantor;
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public String getCantor() {
        return cantor;
    }

    public String getGenero() {
        return genero;
    }

    /**
     * Classificação de 0 a 5
     * @return
     */
    @Override
    public int getClassificacao() {
        if(this.getTotalReproducoes() > 0 && this.getCurtidas() > 0)
        {
            double media = (double) this.getCurtidas() / this.getTotalReproducoes();
            media = media > 1 ? 1 : media;

            if(media > 0.75)
            {
                return 10;
            }
            else if(media > 0.5 && media < 0.75)
            {
                return 5;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "album='" + album + '\'' +
                ", cantor='" + cantor + '\'' +
                ", genero='" + genero + '\'' +
                ", titulo='" + this.getTitulo() + '\'' +
                ", duracao='" + this.getDuracao() + '\'' +
                ", totalReproducoes=" + this.getTotalReproducoes() +
                ", curtidas=" + this.getCurtidas() +
                ", classificacao='" + this.getClassificacao() + '\'' +
                '}';
    }
}
