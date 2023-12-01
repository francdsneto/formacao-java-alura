package estudos.designpattern.loja.pedido.acao;

import estudos.designpattern.loja.pedido.Pedido;

public class SalvarPedidoBancoDados implements AcaoAposGerarPedido {

    public void executarAcao(Pedido pedido) {
        System.out.println("Salvar pedido no Banco de Dados");
    }

}
