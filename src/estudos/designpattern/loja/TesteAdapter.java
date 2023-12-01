package estudos.designpattern.loja;

import estudos.designpattern.loja.http.JavaHttpClient;
import estudos.designpattern.loja.orcamento.ItemOrcamento;
import estudos.designpattern.loja.orcamento.Orcamento;
import estudos.designpattern.loja.orcamento.RegistroOrcamento;

import java.math.BigDecimal;

public class TesteAdapter {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("10"));
        orcamento.adicionarItem(item);
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroOrcamento registro = new RegistroOrcamento(new JavaHttpClient());
        registro.registrar(orcamento);
    }
}
