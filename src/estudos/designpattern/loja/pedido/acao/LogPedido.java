package estudos.designpattern.loja.pedido.acao;

import estudos.designpattern.loja.pedido.Pedido;

public class LogPedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido foi gerado: "+pedido);
    }
}
