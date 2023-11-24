package estudos.formacaojava.alura.desafios.advinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoAdvinhacao {

    public static void main(String[] args) {

        int numeroGerado = new Random().nextInt(100);

        System.out.println("Um número entre 0 e 100 foi escolhido!");
        System.out.println("Tente advinhar o número em até 5 tentativas!");

        Scanner scanner = new Scanner(System.in);
        boolean numeroEncontrado = false;

        for (int i = 1; i <= 5; i++) {

            System.out.println("Essa é a sua tentativa de número " + i);
            System.out.println("Qual número entre 0 a 100 foi escolhido?");

            int numeroEscolhidoPorUsuario = scanner.nextInt();

            if(numeroEscolhidoPorUsuario < numeroGerado)
            {
                System.out.println("Você errou! O número escolhido é maior que " + numeroEscolhidoPorUsuario);
            }
            else if(numeroEscolhidoPorUsuario > numeroGerado)
            {
                System.out.println("Você errou! O número escolhido é menor que " + numeroEscolhidoPorUsuario);
            }
            else
            {
                System.out.println("Parabéns! Você advinhou o número escolhido - " + numeroGerado);
                numeroEncontrado = true;
                break;
            }

        }

        if(!numeroEncontrado)
        {
            System.out.println("Que pena, você não conseguiu advinhar o número!");
            System.out.println("O número escolhido foi " + numeroGerado);
        }

    }
}
