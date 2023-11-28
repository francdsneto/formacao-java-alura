package estudos.formacaojava.alura.pratica.estruturasdedados.pilha;

import java.util.Stack;

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        /**
         * Testa inserção
         */
        pilha.insere("Mauricio");
        System.out.println(pilha);
        pilha.insere("Guilherme");
        System.out.println(pilha);

        /**
         * Testa remoção
         */
        String r1 = pilha.remove();
        System.out.println(r1);
        String r2 = pilha.remove();
        System.out.println(r2);

        /**
         * Verificando se a pilha está vazia
         */
        System.out.println(pilha.vazia());

        /**
         * Testando a pilha do java
         */
        Stack<String> stack = new Stack<String>();
        stack.push("Mauricio");
        stack.push("Marcelo");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        String nome = stack.peek();
        System.out.println(nome);
    }
}
