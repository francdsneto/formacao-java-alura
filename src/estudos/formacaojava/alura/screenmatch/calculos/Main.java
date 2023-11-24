package estudos.formacaojava.alura.screenmatch.calculos;

public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match!");

        String nomeFilme = "TOP GUN";
        String descricao = "Filme de aventura com galã dos anos 80";
        Integer anoLancamento = 1994;

        String sinopse = """
                Filme %s!
                %s
                Muito bom!
                Ano de lançamento:
                %d
                """.formatted(nomeFilme, descricao, anoLancamento);

        System.out.println(sinopse);
    }
}