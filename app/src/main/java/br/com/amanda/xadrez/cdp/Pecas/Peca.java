package br.com.amanda.xadrez.cdp.pecas;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.utils.ConquistaNaoPermitidaError;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;

/**
 * Created by amand on 26/01/2017.
 */

public interface Peca {
    boolean validaMovimento(Posicao posicao,Posicao nova);

    boolean validaConquista(Posicao posicao,Posicao nova);

    Cor getCor();

    String getNome();

    void moveu();
}
