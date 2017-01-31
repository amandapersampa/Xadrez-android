package br.com.amanda.xadrez.cdp.movimentos;

/**
 * Created by amand on 30/01/2017.
 */

public abstract class MovimentoImp implements Movimento {
    private int movimentoMaximo;

    public MovimentoImp(int movimentoMaximo){
        this.movimentoMaximo = movimentoMaximo;
    }

    public int getMovimentoMaximo(){
        return movimentoMaximo;
    }

    public void setMovimentoMaximo(int movimentoMaximo){
        this.movimentoMaximo = movimentoMaximo;
    }
}
