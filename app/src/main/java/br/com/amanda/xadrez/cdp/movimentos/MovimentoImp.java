package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

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

    @Override
    public Posicao andar(Posicao origem, Posicao destino) {
        return origem;
    }
}
