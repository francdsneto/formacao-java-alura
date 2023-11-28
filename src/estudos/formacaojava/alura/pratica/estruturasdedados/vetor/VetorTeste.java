package estudos.formacaojava.alura.pratica.estruturasdedados.vetor;

import estudos.formacaojava.alura.pratica.estruturasdedados.modelo.Aluno;

public class VetorTeste {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("Joao");
        Aluno a2 = new Aluno("Jose");
        Aluno a3 = new Aluno("Danilo");

        Vetor lista = new Vetor();

        /**
         * Testa adiciona
         */
        System.out.println("Testando adiciona:");
        System.out.println(lista.tamanho());
        lista.adiciona(a1);
        System.out.println(lista.tamanho());
        lista.adiciona(a2);
        System.out.println(lista.tamanho());

        System.out.println(lista);

        /**
         * Testa contém
         */
        System.out.println("Testando contém:");
        System.out.println(lista.contem(a1));
        System.out.println(lista.contem(a3));

        /**
         * Testa pega
         */
        System.out.println("Testando pega:");
        Aluno x = null;
        try {
            x = lista.pega(200);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(x);

        /**
         * Testa adiciona em posição específica
         */
        try {
            lista.adiciona(1, a3);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lista);

        /**
         * testa remove
         */
        System.out.println("Testa remove:");
        lista.remove(1);
        System.out.println(lista);
        System.out.println(lista.tamanho());

        /**
         * Testando bug no código de remoção do artigo da alura
         *
         * Bug corrigido:
         * Adicionada validação houveRemocao ao método remove
         */
        lista.remove(10);
        System.out.println(lista.tamanho());
        lista.remove(20);
        System.out.println(lista.tamanho());

        /**
         * Testando garantia de espaço
         */
        System.out.println("Testando garanteEspaco:");

        for(int i = 0; i < 300; i++) {
            Aluno y = new Aluno("Joao" + i);
            lista.adiciona(y);
        }
        System.out.println(lista);

    }

}
