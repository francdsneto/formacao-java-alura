package estudos.designpattern.loja.pedido.acao;

import estudos.designpattern.loja.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido{

    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando e-mail com os dados do pedido");
    }

}
