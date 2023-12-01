package estudos.designpattern.loja.desconto;

import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoOrcamentoMaisCincoItens extends Desconto {


    public DescontoOrcamentoMaisCincoItens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento)  {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getItens().size() > 5;
    }
}
