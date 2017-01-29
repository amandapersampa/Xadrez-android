package br.com.amanda.xadrez.cdp.movimentos;

import br.com.amanda.xadrez.cdp.Posicao;

public interface Movimento {
    boolean isValido(Posicao posicao, Posicao nova);
}
