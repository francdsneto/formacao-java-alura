package estudos.formacaojava.alura.desafios.buscacep.cepapi;

import estudos.formacaojava.alura.desafios.buscacep.modelo.CepInfo;

import java.io.IOException;
import java.util.List;

public interface iCepApi {

    CepInfo buscar(String cep) throws IOException, InterruptedException;

    List<CepInfo> buscar(String estado, String cidade, String rua) throws IOException, InterruptedException;

}
