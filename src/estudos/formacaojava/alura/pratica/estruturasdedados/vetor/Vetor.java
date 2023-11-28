package estudos.formacaojava.alura.pratica.estruturasdedados.vetor;

import estudos.formacaojava.alura.pratica.estruturasdedados.modelo.Aluno;

import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[100];
    private int totalAlunos = 0;

    public void adiciona(Aluno aluno) {
        this.garanteEspaco();
        this.alunos[totalAlunos] = aluno;
        totalAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno) throws IllegalAccessException {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalAccessException("Posição inválida");
        }
        this.garanteEspaco();
        for(int i = totalAlunos - 1; i >= posicao; i-=1) {
            alunos[i+1] = alunos[i];
        }
        alunos[posicao] = aluno;
        totalAlunos++;
    }

    public Aluno pega(int posicao) throws IllegalAccessException {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalAccessException("Posição inválida");
        }
        return alunos[posicao];
    }

    public void remove(int posicao) {
        boolean houveRemocao = false;
        for(int i = posicao; i < this.totalAlunos; i++) {
            this.alunos[i] = this.alunos[i+1];
            houveRemocao = true;
        }
        if(houveRemocao)
            totalAlunos--;
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < alunos.length; i++) {
            if(alunos[i] != null && aluno.equals(alunos[i]))
                return true;
            else
                break;
        }
        return false;
    }

    public int tamanho() {
        return totalAlunos;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalAlunos;
    }

    private void garanteEspaco() {
        if(totalAlunos == alunos.length) {
            System.out.println("Tamanho array redimencionado:");
            System.out.println("Tamanho atual - "+alunos.length);
            Aluno[] novoArray = new Aluno[alunos.length*2];
            for(int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }
            this.alunos= novoArray;
            System.out.println("Tamanho redimencionado: - "+alunos.length);
        }

    }

    public String toString() {
        return Arrays.toString(alunos);
    }

}
