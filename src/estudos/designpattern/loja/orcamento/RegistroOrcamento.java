package estudos.designpattern.loja.orcamento;

import estudos.designpattern.loja.DomainException;
import estudos.designpattern.loja.http.HttpAdapter;

import java.util.Map;

public class RegistroOrcamento {

    private HttpAdapter http;

    public RegistroOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) throws DomainException {

        /**
         * Aqui será necessário realizar uma chamda http externa para acessar
         * a Api que fará o registro do orcamento.
         *
         * Podemos usar diversas formas de acessar a api externa:
         *
         * URL Connection
         * HttpClient
         * lib Rest
         * etc...
         *
         * Usamos aqui o método Adapter, onde se cria uma classe Adapter
         * com chamas comum recebendo parametros pré definidos e dentro da Adapter,
         * dependendo da forma que se escolheu para implementar a requisição http,
         * se constroi a lógica, ficando de responsabilidade apenas da classe adapter
         * realizar essa tarefa. Tirando a responsabilidade de saber como acessar a api
         * da classe RegistroOrcamento.
         *
         */

        if(orcamento.isFinalizado())
        {
            throw new DomainException("Orcamento não finalizado");
        }

        String url = "https://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getItens().size()
        );
        http.post(url, dados);
    }
}
