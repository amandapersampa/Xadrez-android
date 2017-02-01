package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoImp;

public class Horizontal extends MovimentoImp {

    public Horizontal(int movimentoMaximo){
        super(movimentoMaximo);
    }

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao pos = posicao.subtrai(nova);
        return pos.getEixoX() == 0 && pos.getEixoY() <= getMovimentoMaximo();
    }

    @Override
    public Posicao andar(Posicao origem, Posicao destino) {
        return origem.somaHorizontal(destino);
    }
}
