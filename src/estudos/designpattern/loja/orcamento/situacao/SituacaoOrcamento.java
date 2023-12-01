package estudos.designpattern.loja.orcamento.situacao;

import estudos.designpattern.loja.DomainException;
import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class SituacaoOrcamento {

    /**
     * Aplicação do padrão State
     *
     * Assim como o strategy, ele resolve o problema de aplicar uma ação de acordo com algum tipo de parametro, porém
     * possui uma situação a mais, a transição de estado.
     *
     * Através desse padrão é possível aprovar ou negar a chamada de uma transição de um estado[situacao] para outra
     * de acordo com os métodos implementados em cada classe especifica de estado.
     *
     * Se for possível transitar de um estado para outro, o método é sobrescrito e o novo estádo é setado como situação
     * /estado atual.
     *
     * Se não for possível, o método não é sobrescrito e ao tentar chamá-lo a classe abstrata, da qual os estados/situações
     * herdam, lançara uma exception informando que não é possível transitar para o novo estado escolhido.
     *
     * Obs: No padrão state, um estado conhece para qual padrão pode ou não transitar.
     * @param orcamento
     * @return
     */

    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    public void aprovar(Orcamento orcamento){
        throw new DomainException("O orçamento não pode ser aprovado!");
    }

    public void reprovar(Orcamento orcamento) {
        throw new DomainException("O orçamento não pode ser reprovado!");
    }

    public void finalizar(Orcamento orcamento) {
        throw new DomainException("O orçamento não pode ser finalizado!");
    }

}
