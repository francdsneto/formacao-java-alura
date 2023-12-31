package estudos.designpattern.loja;

import estudos.designpattern.loja.imposto.CalculadoraImposto;
import estudos.designpattern.loja.imposto.ICMS;
import estudos.designpattern.loja.imposto.ISS;
import estudos.designpattern.loja.orcamento.ItemOrcamento;
import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteImposto {

//    public static void main(String[] args) {
//        /**
//         * Padrão de projeto Strategy
//         *
//         * No exemplo do calculo de imposto em vez de se usar um Enum com o tipo
//         * do imposto e utilizar switch case para cada tipo de imposto, foi criada
//         * uma interface com o método calcular e classes para cada tipo de imposto,
//         * reduzindo o código dos métodos calcular, tornando mais legível e mais fácil
//         * de dar manutenção em futuros novos impostos que possam vir a surgir.
//         */
//        Orcamento orcamento = new Orcamento(new BigDecimal("100"),1);
//        CalculadoraImposto calculadora = new CalculadoraImposto();
//        System.out.println(calculadora.calcular(orcamento,new ISS()));
//        System.out.println(calculadora.calcular(orcamento,new ICMS()));
//    }

    public static void main(String[] args) {

        /**
         * Nova solução para impostos usando decorator em vez da interface do strategy
         */

        Orcamento orcamento = new Orcamento();
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("100"));
        orcamento.adicionarItem(item);
        CalculadoraImposto calculadora = new CalculadoraImposto();
        System.out.println(calculadora.calcular(orcamento,new ISS(null)));
        System.out.println(calculadora.calcular(orcamento,new ICMS(null)));
        System.out.println(calculadora.calcular(orcamento,new ISS(new ICMS(null))));
    }

}
