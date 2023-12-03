package estudos.formacaojava.alura.desafios.buscacep.cepapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import estudos.formacaojava.alura.desafios.buscacep.exception.CepInvalidoException;
import estudos.formacaojava.alura.desafios.buscacep.exception.ParametroInvalidoException;
import estudos.formacaojava.alura.desafios.buscacep.modelo.CepInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;

public class CepApi implements iCepApi {

    private String urlResultadoPorCep;
    private String urlResultadoPorEndereco;
    private HttpClient httpClient;
    private Gson gson;

    public CepApi() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.urlResultadoPorCep = "https://viacep.com.br/ws/%s/json/";
        this.urlResultadoPorEndereco = "https://viacep.com.br/ws/%s/%s/%s/json/";

    }

    @Override
    public CepInfo buscar(String cep) throws IOException, InterruptedException {
        String urlComCep = this.urlResultadoPorCep.formatted(cep);
        HttpRequest request = HttpRequest.newBuilder(URI.create(urlComCep)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() >= 400)
        {
            throw new CepInvalidoException("O cep digitado é inválido, informe um CEP numérico de 8 dígitos.");
        }
        return gson.fromJson(response.body(),CepInfo.class);
    }

    @Override
    public List<CepInfo> buscar(String estado, String cidade, String rua) throws IOException, InterruptedException {
        String urlComEndereco = this.urlResultadoPorEndereco.formatted(estado,cidade,rua);
        HttpRequest request = null;

        try
        {
            request = HttpRequest.newBuilder(URI.create(urlComEndereco)).build();
        }
        catch(IllegalArgumentException e)
        {
            throw new ParametroInvalidoException("""
                                                 Um ou mais parametros informados para a busca são inválidos!
                                                 1 - Informe a sigla do estado
                                                 2 - O nome da cidade
                                                 3 - O nome da rua
                                                 """);
        }

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() >= 400)
        {
            throw new CepInvalidoException("As informações de endereço são inválidas!");
        }
        TypeToken<List<CepInfo>> collectionType = new TypeToken<List<CepInfo>>(){};
        return gson.fromJson(response.body(),collectionType);
    }
}
