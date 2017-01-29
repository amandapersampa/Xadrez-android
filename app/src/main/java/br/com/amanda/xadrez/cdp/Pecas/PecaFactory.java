package br.com.amanda.xadrez.cdp.Pecas;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.cdp.PosicaoImp;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

/**
 * Created by amand on 28/01/2017.
 */

public class PecaFactory {
    private final PosicaoFactory posicaoFactory;

    public PecaFactory(PosicaoFactory posicaoFactory){
        this.posicaoFactory = posicaoFactory;
    }

    public Peca fabricar(String peca, int posX, int posY, Cor cor) throws PecaInexistenteError {
        Posicao posicao = posicaoFactory.fabricarPosicao(posX,posY);
        switch (peca){
            case "Torre":
                return new Torre(posicao, cor);
            case "Cavalo":
                return new Cavalo(posicao, cor);
            case "Bispo":
                return new Bispo(posicao, cor);
            case "Rainha":
                return new Rainha(posicao, cor);
            case "Rei":
                return new Rei(posicao, cor);
            case "Peao":
                return new Peao(posicao, cor);
            case "Vazio":
                return new Vazio(posicao);
            case "Parede":
                return new Parede(posicao);
        }
        throw new PecaInexistenteError();
    }
}
