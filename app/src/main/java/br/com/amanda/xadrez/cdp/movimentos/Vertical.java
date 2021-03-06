package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

public class Vertical extends MovimentoImp {

    public Vertical(int movimentoMaximo){
        super(movimentoMaximo);
    }

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao pos = posicao.subtrai(nova);
        return pos.getEixoX() <= getMovimentoMaximo() && pos.getEixoY() == 0;
    }

    @Override
    public Posicao andar(Posicao origem, Posicao destino) {
        return origem.somaVertical(destino);
    }
}
