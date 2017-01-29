package br.com.amanda.xadrez.cdp;

/**
 * Created by amand on 26/01/2017.
 */

public interface Posicao {
    Posicao subtrai(Posicao posicaoImp);

    int getEixoX();

    int getEixoY();

}
