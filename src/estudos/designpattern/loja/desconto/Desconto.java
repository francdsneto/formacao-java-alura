package estudos.designpattern.loja.desconto;

import estudos.designpattern.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    /**
     * Template Method
     *
     * Na versão anteriro da solução, as verificações ifs estavam dentro das classes filhas, repetindo-se
     * os ifs dentro de cada método calcular.
     *
     * Refatorando o código, a responsabilidade de verificação veio para a classe mãe, eliminando a repetição
     * de código nas classes filhas.
     *
     * O Template method funciona como um template, um modelo, onde ele extrai as partes em comum do processo
     * para a classe mãe, mas as classes especificas ele delega para as classes filhas.
     * @param orcamento
     * @return
     */
    public BigDecimal calcular(Orcamento orcamento)
    {
        if(deveAplicar(orcamento))
        {
            return efetuarCalculo(orcamento);
        }

        return proximo.calcular(orcamento);
    }
    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

    public abstract boolean deveAplicar(Orcamento orcamento);
}
