package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

public interface Movimento {
    boolean isValido(Posicao posicao, Posicao nova);

    int getMovimentoMaximo();

    void setMovimentoMaximo(int movimentoMaximo);

    Posicao andar(Posicao origem, Posicao destino);
}
