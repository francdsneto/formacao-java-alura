package estudos.designpattern.loja.imposto;

import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImposto {

    /**
     * Calcula o imposto em cima de um orçamento
     * Problema - Código engessado, sempre que surgir um novo imposto terá que adicionar um novo case
     * essa classe pode sempre crescer a ponto de no futuro não ser mais fácil dar manutenção
     * @param orcamento
     * @return
     */
//    public BigDecimal calcular(Orcamento orcamento, TipoImposto tipoImposto) {
//        switch (tipoImposto) {
//            case ICMS: {
//                return orcamento.getValor().multiply(new BigDecimal("0.1"));
//            }
//            case ISS: {
//                return orcamento.getValor().multiply(new BigDecimal("0.06"));
//            }
//            default: {
//                return BigDecimal.ZERO;
//            }
//        }
//    }

    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }

}
