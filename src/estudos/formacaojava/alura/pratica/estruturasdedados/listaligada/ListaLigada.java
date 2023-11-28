package estudos.formacaojava.alura.pratica.estruturasdedados.listaligada;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalElementos = 0;

    public void adicionaNoComeco(Object elemento) {
        Celula nova = new Celula(elemento,primeira);
        this.primeira = nova;

        if(this.totalElementos == 0)
        {
            this.ultima = this.primeira;
        }

        this.totalElementos++;
    }

    public void adiciona(Object elemento) {

        if(this.totalElementos == 0)
        {
            this.adicionaNoComeco(elemento);
        }
        else
        {
            Celula novaCelula = new Celula(elemento,null);
            this.ultima.setProximo(novaCelula);
            this.ultima = novaCelula;
            this.totalElementos++;
        }

    }

    public void adiciona(int posicao, Object elemento) {
        if(posicao == 0)
        {
           this.adicionaNoComeco(elemento);
        }
        else if (posicao == this.totalElementos)
        {
            this.adiciona(elemento);
        }
        else
        {
            Celula anterior = this.pegaCelula(posicao-1);
            Celula nova = new Celula(elemento,anterior.getProximo());
            anterior.setProximo(nova);
            this.totalElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void removeDoComeco() {
        if(this.totalElementos == 0) {
            throw new IllegalArgumentException("lista vazia");
        }

        this.primeira = this.primeira.getProximo();
        this.totalElementos--;

        if(this.totalElementos == 0) {
            this.ultima = null;
        }
    }

    public void remove(int posicao) {
        if(posicao == 0)
        {
            Celula celula = this.pegaCelula(posicao);
            this.primeira = celula.getProximo();
            this.totalElementos--;
        }
        else if(posicao == this.totalElementos)
        {
            Celula celula = this.pegaCelula(posicao-1);
            celula.setProximo(null);
            this.totalElementos--;
        }
        else
        {
            Celula anterior = this.pegaCelula(posicao-1);
            anterior.setProximo(anterior.getProximo().getProximo());
            this.totalElementos--;
        }
    }

    public int tamanho() {
        return this.totalElementos;
    }

    public boolean contem(Object o) {
        for (int i = 0; i < this.totalElementos; i++) {
            if(this.pega(i).equals(o))
            {
                return true;
            }
        }
        return false;
    }


    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalElementos;
    }

    private Celula pegaCelula(int posicao) {

        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posicao inexistente");
        }

        Celula atual = primeira;

        for(int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }



    @Override
    public String toString() {

        if(this.totalElementos == 0) {
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for(int i = 0; i < totalElementos; i++) {
            if(builder.toString().length() > 1)
            {
                builder.append(",");
            }
            builder.append(atual.getElemento());

            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();

    }

    private class Celula {

        private Object elemento;
        private Celula proximo;

        public Celula(Object elemento, Celula proximo) {
            this.elemento = elemento;
            this.proximo = proximo;
        }

        public Object getElemento() {
            return elemento;
        }

        public void setElemento(Object elemento) {
            this.elemento = elemento;
        }

        public Celula getProximo() {
            return proximo;
        }

        public void setProximo(Celula proximo) {
            this.proximo = proximo;
        }

    }

}
