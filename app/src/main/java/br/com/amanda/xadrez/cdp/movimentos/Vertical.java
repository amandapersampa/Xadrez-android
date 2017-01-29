package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

/**
 * Created by amand on 26/01/2017.
 */

public class Vertical implements Movimento {

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao pos = posicao.subtrai(nova);
        return pos.getEixoX() != 0 && pos.getEixoY() == 0;
    }
}
