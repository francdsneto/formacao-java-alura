package estudos.formacaojava.alura.desafios.banco;

import java.util.Scanner;

public class BancoDigital {

    public static void main(String[] args) {

        String nomeCliente;
        String tipoConta;
        double saldoInicial;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seus dados iniciais!");

        System.out.println("Informa seu nome");
        nomeCliente = scanner.nextLine();

        System.out.println("Digite o tipo de conta! Ex: Corrente, Salário, Poupança...");
        tipoConta = scanner.nextLine();

        System.out.println("Digite seu saldo inicial.");
        saldoInicial = scanner.nextDouble();

        String resumoCliente = """
                *******************************************
                Dados iniciais do cliente:
                
                Nome:           %s
                Tipo conta:     %s
                Saldo Inicial:  R$ %.2f
                *******************************************
                """.formatted(nomeCliente,tipoConta,saldoInicial);

        System.out.println(resumoCliente);
        System.out.print("\n\n\n");


        int opcaoSelecionada = 0;

        String operacoes = """
                Operações
                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                """;

        System.out.println(operacoes);

        while(opcaoSelecionada != 4)
        {
            System.out.println("Digite a opção desejada:");

            opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada)
            {
                case 1 : {
                    System.out.printf("Seu saldo é de R$%.2f \n",saldoInicial);
                    break;
                }
                case 2 : {
                    System.out.println("Informa o valor de deposito:");
                    double deposito = scanner.nextDouble();
                    saldoInicial += deposito;
                    System.out.printf("Valor de %.2f depositado com sucesso!\n", deposito);
                    System.out.println("Saldo atualizado de R$"+saldoInicial);
                    break;
                }
                case 3 : {
                    System.out.println("Informa o valor de transferencia:");
                    double transferencia = scanner.nextDouble();
                    while(transferencia > saldoInicial)
                    {
                        System.out.println("""
                                O valor informado é maior que o valor do seu saldo de %.2f
                                Informe um valor menor ou igual para concluir a transferência.
                                """);
                        transferencia = scanner.nextDouble();
                    }
                    saldoInicial -= transferencia;
                    System.out.printf("Valor de %.2f transferido com sucesso!\n", transferencia);
                    System.out.println("Saldo atualizado de R$"+saldoInicial);
                    break;
                }
                case 4 : {
                    System.out.println("Até logo!");
                }
                default: {
                    System.out.println("Opção inválida! Selecione um valor entre 1 e 4!");
                }
            }

        }

    }

}
