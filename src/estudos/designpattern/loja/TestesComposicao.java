package estudos.designpattern.loja;

import estudos.designpattern.loja.orcamento.ItemOrcamento;
import estudos.designpattern.loja.orcamento.Orcamento;
import estudos.designpattern.loja.orcamento.OrcamentoProxy;

import java.math.BigDecimal;

public class TestesComposicao {

    /**
     * Padrão Composite
     *
     * Parecido com um decorator, onde
     *
     * @param args
     */
    public static void main(String[] args) {
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        novo.adicionarItem(antigo);

        OrcamentoProxy proxy = new OrcamentoProxy(novo);

        System.out.println(proxy.getValor());
        System.out.println(proxy.getValor());


    }

}
