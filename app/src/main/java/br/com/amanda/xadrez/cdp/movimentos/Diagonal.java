package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

public class Diagonal extends MovimentoImp {

    public Diagonal(int movimentoMaximo){
        super(movimentoMaximo);
    }

    @Override
    public boolean isValido(Posicao posicao, Posicao nova) {
        Posicao p = posicao.subtrai(nova);
        return (p.getEixoX() == p.getEixoY() && p.getEixoY()<= getMovimentoMaximo()) && p.getEixoY()<=getMovimentoMaximo();
    }

    @Override
    public Posicao andar(Posicao origem, Posicao destino) {
        return origem.somaDiagonal(destino);
    }
}
