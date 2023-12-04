package estudos.formacaojava.alura.desafios.musica;

import estudos.formacaojava.alura.desafios.musica.model.AnaliseClassificacao;
import estudos.formacaojava.alura.desafios.musica.model.Audio;
import estudos.formacaojava.alura.desafios.musica.model.Musica;
import estudos.formacaojava.alura.desafios.musica.model.Podcast;

public class Principal {

    public static void main(String[] args) {

        Audio musica = new Musica("Cowboy do Asfalto","Chitãozinho & Xororó","Sertanejo", "Evidências", 3.30, 10);
        Audio podcast = new Podcast("Rogério Vilela","Bate papo descontraído","Inteligêcia Limitada",50,8);

        for (int i = 0; i < 1000; i++) {
            musica.reproduzir();
        }

        for (int i = 0; i < 735; i++) {
            musica.curtir();
        }

        for (int i = 0; i < 837; i++) {
            podcast.reproduzir();
        }

        for (int i = 0; i < 542; i++) {
            podcast.curtir();
        }

        System.out.println(musica);
        System.out.println(podcast);

        AnaliseClassificacao analise = new AnaliseClassificacao();
        analise.analisar(musica);
        analise.analisar(podcast);

    }

}
