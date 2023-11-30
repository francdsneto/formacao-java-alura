package estudos.designpattern.comportamentais.loja;

import estudos.designpattern.comportamentais.loja.desconto.CalculadoraDesconto;
import estudos.designpattern.comportamentais.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDesconto {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("200"),6);
        Orcamento orcamento2 = new Orcamento(new BigDecimal("1000"),1);
        CalculadoraDesconto calculadora = new CalculadoraDesconto();
        System.out.println(calculadora.calcular(orcamento));
        System.out.println(calculadora.calcular(orcamento2));
    }
}
