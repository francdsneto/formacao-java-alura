package Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    }

}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() < o2.length() ? -1 : o1.length() > o2.length() ? 1 : 0;
    }

}