package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoImp;

/**
 * Created by amand on 26/01/2017.
 */

public class VerticalDistancia1 implements Movimento{
    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao pos = posicao.subtrai(nova);
        return pos.getEixoX() == 1 && pos.getEixoY()==0;
    }
}
