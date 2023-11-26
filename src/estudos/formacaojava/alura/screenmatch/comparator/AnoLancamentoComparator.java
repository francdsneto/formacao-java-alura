package estudos.formacaojava.alura.screenmatch.comparator;

import estudos.formacaojava.alura.screenmatch.modelos.Titulo;

import java.util.Comparator;

public class AnoLancamentoComparator implements Comparator<Titulo> {
    @Override
    public int compare(Titulo o1, Titulo o2) {
        if(o1.getAnoDeLancamento() < o2.getAnoDeLancamento())
            return -1;
        if(o1.getAnoDeLancamento() > o2.getAnoDeLancamento())
            return 1;
        return 0;
    }
}
