package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

/**
 * Created by amand on 26/01/2017.
 */

public class DiagonalDistancia1 implements Movimento {
    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao dif = posicao.subtrai(nova);
        return dif.getEixoY() == 1 && dif.getEixoX() == 1;
    }
}
