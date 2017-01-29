package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

public class L implements Movimento {

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao pos = posicao.subtrai(nova);
        return  ((pos.getEixoX() == 1) && (pos.getEixoY()) == 2)
                || ((pos.getEixoX() == 2) && (pos.getEixoY()) == 1);
    }
}
