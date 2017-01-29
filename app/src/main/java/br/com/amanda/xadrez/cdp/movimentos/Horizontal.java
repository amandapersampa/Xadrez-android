package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoImp;

public class Horizontal implements Movimento {

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao pos = posicao.subtrai(nova);
        return pos.getEixoX() == 0 && pos.getEixoY() != 0;
    }
}
