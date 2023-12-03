package estudos.formacaojava.alura.desafios.buscacep.modelo;

public record CepInfo(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi,
        boolean erro) {
}
