package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoImp;

/**
 * Created by amand on 26/01/2017.
 */

public class Diagonal extends MovimentoImp {

    public Diagonal(int movimentoMaximo){
        super(movimentoMaximo);
    }

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao p = posicao.subtrai(nova);
        return (p.getEixoX() == p.getEixoY() && p.getEixoY()<= getMovimentoMaximo()) && p.getEixoY()<=getMovimentoMaximo();
    }
}
