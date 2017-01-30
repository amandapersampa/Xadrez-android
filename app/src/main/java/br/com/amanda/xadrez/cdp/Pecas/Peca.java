package br.com.amanda.xadrez.cdp.Pecas;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.utils.ConquistaNaoPermitidaError;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;

/**
 * Created by amand on 26/01/2017.
 */

public interface Peca {
    boolean validaMovimento(Posicao nova);

    boolean validaConquista(Posicao nova);

    Posicao getPosicao();

    Cor getCor();

    void mover(Posicao nova) throws MovimentoNaoPermitidoError;

    void conquistar(Posicao nova) throws ConquistaNaoPermitidaError;
}
