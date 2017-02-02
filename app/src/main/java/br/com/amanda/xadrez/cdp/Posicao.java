package br.com.amanda.xadrez.cdp;

import br.com.amanda.xadrez.cdp.peca.Peca;

public interface Posicao {
    Posicao subtrai(Posicao posicaoImp);

    int getEixoX();

    int getEixoY();

    Peca getPeca();

    boolean mesmaPosicao(Posicao posicao);

    Posicao somaVertical(Posicao destino);

    Posicao somaHorizontal(Posicao destino);

    Posicao somaDiagonal(Posicao destino);

    boolean isVazio();

    void setPeca(Peca peca);


    boolean noLimite();
}
