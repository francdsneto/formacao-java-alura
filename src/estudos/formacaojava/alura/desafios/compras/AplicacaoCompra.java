package estudos.formacaojava.alura.desafios.compras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoCompra {

    public static void main(String[] args) {

        Cartao cartao = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        cartao = new Cartao(scanner.nextDouble());

        var continuarCompras = 1;

        while(continuarCompras != 0)
        {
            System.out.println("Digite a descrição da compra:");
            String descricao = scanner.next();
            System.out.println("Digite o valor da compra:");
            Double valor = scanner.nextDouble();

            Compra compra = new Compra(descricao,valor);

            try
            {
                cartao.adicionarCompra(compra);
                System.out.println("Digite o valor 0 para sair ou 1 para continuar");
                continuarCompras = scanner.nextInt();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                continuarCompras = 0;
            }

        }

        System.out.println(cartao);

    }

    private static class Cartao {
        private Double limiteCartao;
        private final List<Compra> compras;

        public Cartao(Double limiteCartao) {
            this.limiteCartao = limiteCartao;
            this.compras = new ArrayList<>();
        }

        public void adicionarCompra(Compra compra) throws Exception {
            if (compra.getValor() > this.limiteCartao)
            {
                throw new Exception("Limite insuficinente!");
            }
            else
            {
                compras.add(compra);
                this.limiteCartao -= compra.getValor();
                System.out.println("Compra realizada!");
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("******************************\n");
            builder.append("COMPRAS REALIZADAS:\n\n");

            compras.sort(Compra::compareTo);

            compras.forEach((c) -> builder.append("%s - R$%.2f\n".formatted(c.getDescricao(),c.getValor())));
            builder.append("\n\n******************************\n\n");

            builder.append("Saldo limite do cartão: R$%.2f".formatted(this.limiteCartao));

            return builder.toString();
        }
    }

    private static class Compra implements Comparable<Compra> {
        private String descricao;
        private Double valor;

        public Compra(String descricao, Double valor) {
            this.descricao = descricao;
            this.valor = valor;
        }

        public String getDescricao() {
            return descricao;
        }

        public Double getValor() {
            return valor;
        }

        @Override
        public int compareTo(Compra c) {
            return this.getValor().compareTo(c.getValor());
        }
    }

}
