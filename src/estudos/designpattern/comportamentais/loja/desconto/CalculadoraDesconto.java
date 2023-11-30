package estudos.designpattern.comportamentais.loja.desconto;

import estudos.designpattern.comportamentais.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDesconto {

    /**
     * Se o cliente comprar mais de 5 itens recebe 10% de desconto
     * Se o cliente comprar mais de 500 reais também tem desconto de 10%
     * @param orcamento
     * @return
     */
    public BigDecimal calcular(Orcamento orcamento) {
        /**
         * Aqui se aplica a Chain Of Responsability
         *
         * Esse padrão de projeto, diferente do Strategy, que sabendos exatamente qual Tipo de ação deve ser aplicada,
         * o Chain of Responsability, temos uma série de ações que podem ser executadas dependnedo de um condicional.
         * Se um condicional não se aplica, passa a verificação para o próximo, e assim sucessivamente, até acabar
         * as análises dos condicionais, possuindo uma resposta default caso nenhuma condicional seja atendida.
         *
         * No Chain of Responsabilioty, as classes formam uma cadeia, onde uma conhece a próxima a ser chamada, até
         * que se chegue a chamada default.
         *
         * Um outro exemplo de aplicação, poderia ser uma validação de um Username em um cadastro.
         *
         * Uma classe verifica o tamanho da string do username,
         * A seguinte verifica letras maiusculas,
         * a próxima caracteres especiais,
         * a próxima verifica a existencia de espaços,
         * etc...
         *
         * As classes acima poderiam retornar uma exception com uma mensagem informando onde está o problema no username
         * A resposta default não retornaria exception alguma, prosseguindo o registro do usuário.
         */
        Desconto cadeiaDeDescontos = new DescontoOrcamentoMaisCincoItens(
                            new DescontoOrcamentoValorMaiorQuinhentos(
                                    new SemDesconto()));

        return cadeiaDeDescontos.calcular(orcamento);
    }

}
