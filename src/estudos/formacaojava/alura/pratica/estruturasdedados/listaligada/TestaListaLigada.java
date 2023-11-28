package estudos.formacaojava.alura.pratica.estruturasdedados.listaligada;

public class TestaListaLigada {
    public static void main(String[] args) {

        /**
         * Testa método adiciona no começo
         */

        System.out.println("Cria lista ligada e adiciona 3 Strings de nomes:");
        ListaLigada lista = new ListaLigada();

        System.out.println(lista);
        lista.adicionaNoComeco("mauricio");
        System.out.println(lista);
        lista.adicionaNoComeco("paulo");
        System.out.println(lista);
        lista.adicionaNoComeco("guilherme");
        System.out.println(lista);

        /**
         * Após implementar o método adiciona, testa adicionar objeto no fim
         */
        System.out.println("Adiciona elemento no começo:");
        lista.adiciona("marcelo");
        System.out.println(lista);

        /**
         * Testa adicionar célula no meio da lista
         */
        System.out.println("Adiciona elemento em um indice da lista:");
        lista.adiciona(2, "gabriel");
        System.out.println(lista);

        /**
         * Testa pega celula
         */
        System.out.println("Testa pegar o elemento em determinado indice");
        Object x = lista.pega(2);
        System.out.println(x);

        /**
         * Testa o método tamanho
         */
        System.out.println("Testar obter tamanho da lista:");
        System.out.println(lista.tamanho());

        /**
         * Testa funcionalidade de remover do começo
         */
        System.out.println("Testar remover do começo:");
        lista.removeDoComeco();
        System.out.println(lista);

        /**
         * Testa funcionalidade de remover por indice
         */
        System.out.println("Testar remover por indice:");
        lista.remove(2);
        System.out.println(lista);

        /**
         * Testa funcionalidade contem
         */
        System.out.println("Testar contem:");
        System.out.println(lista.contem("gabriel"));
        System.out.println(lista.contem("andré"));

    }
}
