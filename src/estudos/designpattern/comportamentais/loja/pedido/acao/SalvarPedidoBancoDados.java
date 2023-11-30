package estudos.designpattern.comportamentais.loja.pedido.acao;

import estudos.designpattern.comportamentais.loja.pedido.Pedido;

public class SalvarPedidoBancoDados implements AcaoAposGerarPedido {

    public void executarAcao(Pedido pedido) {
        System.out.println("Salvar pedido no Banco de Dados");
    }

}
