package estudos.formacaojava.alura.desafios.musica.model;

public class AnaliseClassificacao {

    public void analisar(Audio audio)
    {
        if(audio.getClassificacao() == 10)
        {
            System.out.printf("%s é considerado um sucesso absoluto!\n", audio.getTitulo());
        }
        else if(audio.getClassificacao() > 5 && audio.getClassificacao() < 10)
        {
            System.out.printf("%s está no gosto da galera!\n", audio.getTitulo());
        }
        else if(audio.getClassificacao() == 5)
        {
            System.out.printf("%s tem uma classificação mediana!\n", audio.getTitulo());
        }
        else
        {
            System.out.printf("%s não está agradando!\n", audio.getTitulo());
        }
    }

}
