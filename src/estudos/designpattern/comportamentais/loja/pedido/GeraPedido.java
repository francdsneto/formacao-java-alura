package estudos.designpattern.comportamentais.loja.pedido;

import estudos.designpattern.comportamentais.loja.orcamento.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GeraPedido {

    private String cliente;
    private BigDecimal valorOrcamento;
    private int quantidadeItens;

    public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public int getQuantidadeItens() {
        return this.quantidadeItens;
    }

    public BigDecimal getValorOrcamento() {
        return this.valorOrcamento;
    }

    public String getCliente() {
        return this.cliente;
    }
}
