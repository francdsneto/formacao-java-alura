package estudos.designpattern.loja;

import estudos.designpattern.loja.desconto.CalculadoraDesconto;
import estudos.designpattern.loja.orcamento.ItemOrcamento;
import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDesconto {
    public static void main(String[] args) {

        Orcamento orcamento = new Orcamento();
        for (int i = 0; i < 6; i++) {
            ItemOrcamento item = new ItemOrcamento(new BigDecimal("240").divide(new BigDecimal(6)));
            orcamento.adicionarItem(item);
        }
        Orcamento orcamento2 = new Orcamento();
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("1000"));
        orcamento2.adicionarItem(item);
        CalculadoraDesconto calculadora = new CalculadoraDesconto();
        System.out.println(calculadora.calcular(orcamento));
        System.out.println(calculadora.calcular(orcamento2));
    }
}
