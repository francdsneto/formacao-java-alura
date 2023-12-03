package estudos.formacaojava.alura.desafios.buscacep.arquivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import estudos.formacaojava.alura.desafios.buscacep.modelo.CepInfo;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    private FileWriter writer;
    private Gson gson;

    public GeradorArquivo() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void geraArquivo(Object cepInfo, String fileName) throws IOException {
        writer = new FileWriter(fileName);
        writer.write(gson.toJson(cepInfo));
        writer.close();
    }

}
