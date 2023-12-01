package estudos.designpattern.loja.desconto;

import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoOrcamentoValorMaiorQuinhentos extends Desconto {

    public DescontoOrcamentoValorMaiorQuinhentos(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }

}
