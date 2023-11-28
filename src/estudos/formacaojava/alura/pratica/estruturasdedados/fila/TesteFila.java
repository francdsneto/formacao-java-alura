package estudos.formacaojava.alura.pratica.estruturasdedados.fila;

import java.util.LinkedList;
import java.util.Queue;

public class TesteFila {

    public static void main(String[] args) {
        Fila fila = new Fila();

        /**
         * Teste da adição na fila
         */
        fila.adiciona("Mauricio");
        fila.adiciona("Guilherme");

        System.out.println(fila);

        /**
         * Testa remove
         */
        String x1 = fila.remove();
        System.out.println(x1);
        System.out.println(fila);

        /**
         * Testando a fila do Java
         */
        Queue<String> filaDoJava = new LinkedList<String>();

        filaDoJava.add("Mauricio");
        String x2 = filaDoJava.poll();

        System.out.println(x2);

    }

}
