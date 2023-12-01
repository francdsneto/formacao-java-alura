package estudos.designpattern.loja.orcamento;

import estudos.designpattern.loja.orcamento.situacao.EmAnalise;
import estudos.designpattern.loja.orcamento.situacao.Finalizado;
import estudos.designpattern.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel {

    private BigDecimal valor;
    private SituacaoOrcamento situacao;
    private List<Orcavel> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        this.valor = this.valor.subtract(situacao.calcularValorDescontoExtra(this));
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return valor;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public SituacaoOrcamento getSituacao() {
        return situacao;
    }

    public boolean isFinalizado() {
        return this.getSituacao() instanceof Finalizado;
    }

    public List<Orcavel> getItens() {
        return itens;
    }

    public void adicionarItem(Orcavel item) {
        this.itens.add(item);
        this.valor = this.valor.add(item.getValor());
    }
}
