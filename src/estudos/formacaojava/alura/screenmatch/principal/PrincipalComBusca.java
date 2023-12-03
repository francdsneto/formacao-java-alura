package estudos.formacaojava.alura.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import estudos.formacaojava.alura.screenmatch.excessao.ErroConversaoAnoException;
import estudos.formacaojava.alura.screenmatch.modelos.Titulo;
import estudos.formacaojava.alura.screenmatch.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        var busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .setPrettyPrinting()
                        .create();

        while(!busca.equalsIgnoreCase("Sair")) {

            System.out.println("Digite um filme para busca:");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("Sair"))
                break;


            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=567c7693";

            HttpClient client = HttpClient.newHttpClient();

            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco.replace(" ", "+")))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

                System.out.println(meuTituloOmdb);

                /**
                 * Tratando excessões
                 */

                Titulo titulo = new Titulo(meuTituloOmdb);
                System.out.println(titulo);

                titulos.add(titulo);


            } catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro de formatação de número:");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ocorreu um erro de endereço:");
                System.out.println(e.getMessage());
            } catch (ErroConversaoAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escritor = new FileWriter("filmes.json");
        escritor.write(gson.toJson(titulos));
        escritor.close();

        System.out.println("O programa finalizou corretamente");

    }
}
