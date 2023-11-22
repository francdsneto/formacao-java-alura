package Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<String>();

        palavras.add("Brasil");
        palavras.add("Nordeste");
        palavras.add("Paraíba");
        palavras.add("Ceará");

        /**
         * Ordena por ordem alfabética
         */
        // Collections.sort(palavras);

        Comparator<String> comparador = new ComparadorPorTamanho();

        //Collections.sort(palavras, comparador);

        /**
         * Usando o sort da própria interface List
         */
        palavras.sort(comparador);

        System.out.println(palavras);

        /**
         * Forma comum de percorrer a lista e imprimir
         */
        /* for(String p : palavras)
        {
            System.out.println(p);
        } */

        Consumer<String> consumidor = new ImprimeNaLinha();
        palavras.forEach(consumidor);

    }

}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println(t);        
    }

 }
class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() < o2.length() ? -1 : o1.length() > o2.length() ? 1 : 0;
    }

}