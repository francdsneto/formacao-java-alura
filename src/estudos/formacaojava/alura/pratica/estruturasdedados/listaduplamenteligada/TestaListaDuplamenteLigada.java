package estudos.formacaojava.alura.pratica.estruturasdedados.listaduplamenteligada;

import estudos.formacaojava.alura.pratica.estruturasdedados.listaligada.ListaLigada;

public class TestaListaDuplamenteLigada {
    public static void main(String[] args) {

        /**
         * Testa método remove do fim
         */

        System.out.println("Cria lista ligada e adiciona 3 Strings de nomes:");
        ListaDuplamenteLigada lista = new ListaDuplamenteLigada();

        System.out.println(lista);
        lista.adicionaNoComeco("mauricio");
        System.out.println(lista);
        lista.adicionaNoComeco("paulo");
        System.out.println(lista);
        lista.adicionaNoComeco("guilherme");
        System.out.println(lista);

        /**
         * Testa remover do fim
         */
        System.out.println("Remove do fim:");;
        lista.removeDoFim();
        System.out.println(lista);

        /**
         * Testar remover por indice
         */
        lista.adiciona("João");
        lista.adiciona("José");

        lista.remove(3);
        System.out.println(lista);

        /**
         * Testando lista com outra abordagem
         */
        System.out.println(lista.contem("André"));
        System.out.println(lista.contem("paulo"));

    }
}
