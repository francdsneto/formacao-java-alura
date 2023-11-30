package estudos.designpattern.comportamentais.loja;

import estudos.designpattern.comportamentais.loja.imposto.CalculadoraImposto;
import estudos.designpattern.comportamentais.loja.imposto.ICMS;
import estudos.designpattern.comportamentais.loja.imposto.ISS;
import estudos.designpattern.comportamentais.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteImposto {

    public static void main(String[] args) {
        /**
         * Padrão de projeto Strategy
         *
         * No exemplo do calculo de imposto em vez de se usar um Enum com o tipo
         * do imposto e utilizar switch case para cada tipo de imposto, foi criada
         * uma interface com o método calcular e classes para cada tipo de imposto,
         * reduzindo o código dos métodos calcular, tornando mais legível e mais fácil
         * de dar manutenção em futuros novos impostos que possam vir a surgir.
         */
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalculadoraImposto calculadora = new CalculadoraImposto();
        System.out.println(calculadora.calcular(orcamento,new ISS()));
        System.out.println(calculadora.calcular(orcamento,new ICMS()));
    }

}
