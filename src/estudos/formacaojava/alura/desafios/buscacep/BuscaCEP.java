package estudos.formacaojava.alura.desafios.buscacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import estudos.formacaojava.alura.desafios.buscacep.arquivo.GeradorArquivo;
import estudos.formacaojava.alura.desafios.buscacep.cepapi.CepApi;
import estudos.formacaojava.alura.desafios.buscacep.cepapi.iCepApi;
import estudos.formacaojava.alura.desafios.buscacep.exception.CepInvalidoException;
import estudos.formacaojava.alura.desafios.buscacep.exception.ParametroInvalidoException;
import estudos.formacaojava.alura.desafios.buscacep.modelo.CepInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class BuscaCEP {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        iCepApi cepApi = new CepApi();
        GeradorArquivo geradorArquivo = new GeradorArquivo();

        var tipoBusca = "";
        var cep = "";
        CepInfo cepInfo = null;
        List<CepInfo> listaCepInfo = null;

        do
        {
            System.out.println("""
                    Que tipo de busca deseja realizar?
                    1 - CEP
                    2 - Endereço
                    3 - Sair""");

            tipoBusca = scanner.nextLine();

            switch (tipoBusca)
            {
                case "1": {
                    System.out.println("Digite o CEP para a busca ou Sair para voltar ao menu!");
                    cep = scanner.nextLine();

                    if(cep.equalsIgnoreCase("sair")) {
                        break;
                    }

                    try
                    {
                        cepInfo = cepApi.buscar(cep);

                        if(!cepInfo.erro())
                        {
                            geradorArquivo.geraArquivo(cepInfo,"cep.json");
                        }
                        else
                        {
                            System.out.println("O CEP é válido, mas não existe registro para este CEP.");
                        }

                    }
                    catch (IOException | InterruptedException | CepInvalidoException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "2" : {
                    System.out.println("Digite a sigla do Estado:");
                    var siglaEstado = scanner.nextLine();
                    System.out.println("Digite o nome da Cidade:");
                    var cidade = URLEncoder.encode(scanner.nextLine(), Charset.defaultCharset());
                    System.out.println("Digite o nome da rua:");
                    var rua = URLEncoder.encode(scanner.nextLine(), Charset.defaultCharset());

                    try
                    {
                        listaCepInfo = cepApi.buscar(siglaEstado,cidade,rua);
                        geradorArquivo.geraArquivo(listaCepInfo,"ceps.json");
                    }
                    catch (IOException | InterruptedException | CepInvalidoException | ParametroInvalidoException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "3": {
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                }
            }



        }
        while (!tipoBusca.equalsIgnoreCase("3"));


    }
}
