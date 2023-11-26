package estudos.formacaojava.alura.screenmatch.principal;

import estudos.formacaojava.alura.screenmatch.comparator.AnoLancamentoComparator;
import estudos.formacaojava.alura.screenmatch.modelos.Filme;
import estudos.formacaojava.alura.screenmatch.modelos.Serie;
import estudos.formacaojava.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {

    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar",2023);
        outroFilme.avalia(10);
        var maisUmFilme = new Filme("O Auto da Compadecida",2000);
        maisUmFilme.avalia(15);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();

        lista.add(maisUmFilme);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        /**
         * Lambda expression
         */
//        lista.forEach( (t) -> System.out.println(t));
        /**
         * Method Reference
         */
//        lista.forEach(System.out::println);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
//            Jeito antigo
//            if(item instanceof Filme)
//            {
//                Filme filme = (Filme) item;
//                System.out.println("Classificacao: " + filme.getClassificacao());
//            }

            /**
             * Nesse if também é possível colocar && e fazer outra verificação, como por exemplo
             * if(item instance Filme filme && filme.getClassificacao() > 2)
             */
            if(item instanceof Filme filme)
            {
                System.out.println("Classificacao: " + filme.getClassificacao());
            }

        }

        ArrayList<String> buscaPorArtista = new ArrayList();

        buscaPorArtista.add("Stalone");
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Samuel El Jackson");
        buscaPorArtista.add("Manoel Gomes");

        System.out.println("Antes da ordenação:");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);

        /**
         * Adicionada interface Comparable em Titulo para ordenaçãp
         */
        Collections.sort(lista);

        System.out.println("Lista de titulos ordenados:");
        System.out.println(lista);

        /**
         * Ordenação através da classe com interface Comparator
         */
        System.out.println("Lista de titulos ordenados por ano lançamento:");
        Collections.sort(lista, new AnoLancamentoComparator());
        System.out.println(lista);

        /**
         * Ordernar através uma classe Comparator anonima
         * Ordena inversamente, pois quem tem mais avaliações, neste caso, vem primeiro
         */
//        Comparator<Titulo> comparatorPorMediaAvaliacoes = new Comparator<>() {
//            public int compare(Titulo t1, Titulo t2) {
//                return Double.compare(t1.pegaMedia(),t2.pegaMedia());
//            }
//        };

        /**
         * Mesmo comparator anterior, porém, usando lambda
         */
//        Comparator<Titulo> comparatorPorMediaAvaliacoes = (Titulo t1, Titulo t2) -> {
//            return Double.compare(t1.pegaMedia(),t2.pegaMedia());
//        };
        // Código ainda mais minimalista
        Comparator<Titulo> comparatorPorMediaAvaliacoes = (Titulo t1, Titulo t2) -> Double.compare(t1.pegaMedia(),t2.pegaMedia());

        System.out.println("Lista ordenada por total de avaliacoes:");

        /**
         * Duas formas de usar o comparador
         */
        //Collections.sort(lista,comparatorPorMediaAvaliacoes);
        lista.sort(comparatorPorMediaAvaliacoes);
        System.out.println(lista);



    }
}
