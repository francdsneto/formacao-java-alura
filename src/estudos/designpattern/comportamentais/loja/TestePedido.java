package estudos.designpattern.comportamentais.loja;

import estudos.designpattern.comportamentais.loja.pedido.GeraPedido;
import estudos.designpattern.comportamentais.loja.pedido.GeraPedidoHandler;
import estudos.designpattern.comportamentais.loja.pedido.acao.EnviarEmailPedido;
import estudos.designpattern.comportamentais.loja.pedido.acao.SalvarPedidoBancoDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestePedido {
    public static void main(String[] args) {
        String cliente = "Marluce";
        BigDecimal valorOrcamento = new BigDecimal("100");
        int quantidadeItens = Integer.parseInt("4");

        GeraPedido gerador = new GeraPedido(cliente,valorOrcamento,quantidadeItens);

        /**
         * O padrão command separa as informações da qual se está trabalhando da lógica que deve ser executada com ela.
         * Como se pode observar abaixo, fica bem claro a responsabilidade da classe que o código abaixo está executando.
         *
         * O comando execute Gera um Pedido de acordo com as informações fornecidas pelo Gerador
         */

        new GeraPedidoHandler(
                Arrays.asList(new SalvarPedidoBancoDados(), new EnviarEmailPedido())
        ).execute(gerador);
    }

}
