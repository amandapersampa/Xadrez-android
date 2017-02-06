package br.com.amanda.xadrez.cdp.peca;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

/**
 * Created by amand on 26/01/2017.
 */

public interface Peca {
    boolean validaMovimento(Posicao posicao, Posicao nova, PosicaoFactory posicaoFactory) throws PecaInexistenteError;

    boolean validaConquista(Posicao posicao, Posicao nova, PosicaoFactory posicaoFactory) throws PecaInexistenteError;

    List<Posicao> possiveisMovimentos(Posicao posicao);

    List<Posicao> possiveisConquistas(Posicao posicao);

    Cor getCor();

    String getNome();

    void moveu();

    boolean isVazio();
}
