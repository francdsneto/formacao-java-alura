package estudos.formacaojava.alura.desafios.convertertemperatura;

import java.util.Scanner;

public class ConverteCelsiusFarenheit {

    public static void main(String[] args) {

        System.out.println("Digite o valor em Celsius!");
        Scanner scanner = new Scanner(System.in);
        Double valorCelsius = scanner.nextDouble();
        Double valorFarenheit = converteCelsiusFarenheit(valorCelsius);

        System.out.printf("A temperatura de %.2f em Celsius equivale a %.2f em Farenheit!",valorCelsius,valorFarenheit);

    }

    public static Double converteCelsiusFarenheit(Double valorCelsius)
    {
        return (valorCelsius * 1.8) + 32;
    }

}
