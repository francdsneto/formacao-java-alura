package estudos.formacaojava.alura.pratica.estruturasdedados.listaduplamenteligada;

public class ListaDuplamenteLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalElementos = 0;

    public void adicionaNoComeco(Object elemento) {
        if(this.totalElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(elemento, this.primeira);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
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
            novaCelula.setAnterior(this.ultima);
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
            Celula proxima = anterior.getProximo();
            Celula nova = new Celula(elemento,proxima);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
            this.totalElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void removeDoFim() {
        if(this.totalElementos == 1) {
            this.removeDoComeco();
        }
        else
        {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProximo(null);
            this.ultima = penultima;
            this.totalElementos--;
        }
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
            this.removeDoComeco();
        }
        else if(posicao == this.totalElementos - 1)
        {
            this.removeDoFim();
        }
        else
        {
            Celula anterior = this.pegaCelula(posicao-1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            this.totalElementos--;
        }
    }

    public int tamanho() {
        return this.totalElementos;
    }

    public boolean contem(Object o) {

        Celula atual = this.primeira;

        while(atual.getProximo() != null)
        {
            if(atual.getElemento().equals(o))
            {
                return true;
            }
            atual = atual.getProximo();
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
        private Celula anterior;

        public Celula(Object elemento, Celula proximo) {
            this.elemento = elemento;
            this.proximo = proximo;
        }

        public Celula(Object elemento) {
            this(elemento, null);
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

        public Celula getAnterior() {
            return anterior;
        }

        public void setAnterior(Celula anterior) {
            this.anterior = anterior;
        }
    }
    
}
