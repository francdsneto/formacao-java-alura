package estudos.designpattern.comportamentais.loja.pedido;

import estudos.designpattern.comportamentais.loja.orcamento.Orcamento;
import estudos.designpattern.comportamentais.loja.pedido.acao.AcaoAposGerarPedido;

import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {


    /**
     * Padrão Observer Ou Listener
     *
     * Temos uma lista de observadores [ classes que implementam a interface AcaoAposGerarPedido ]
     *
     * Esses observadores serão notificados quando execute chamar a função executarAcao de cada
     * observer que estão presentes na lista de acoes.
     */
    private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    /**
     * Padrão Command
     *
     * Separa os dados em GeraPedido, e executa o comando aqui, na classe handler     *
     */
    public void execute(GeraPedido dados)
    {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(),orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));

    }
}
