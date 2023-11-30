package estudos.designpattern.comportamentais.loja.imposto;

import estudos.designpattern.comportamentais.loja.orcamento.Orcamento;

import java.math.BigDecimal;
public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
