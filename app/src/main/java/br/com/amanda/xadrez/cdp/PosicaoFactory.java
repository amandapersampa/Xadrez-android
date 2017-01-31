package br.com.amanda.xadrez.cdp;

import java.util.ArrayList;
import java.util.List;

import br.com.amanda.xadrez.cdp.pecas.Peca;
import br.com.amanda.xadrez.cdp.pecas.PecaFactory;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

/**
 * Created by amand on 29/01/2017.
 */

public class PosicaoFactory {
    private final Posicao[][] posicoes;
    private final PecaFactory pecaFactory;
    private final int largura;

    public PosicaoFactory(PecaFactory pecaFactory, int tabuleiro) {
        this.largura = tabuleiro;
        posicoes = new Posicao[tabuleiro][tabuleiro];
        for(int i = 0 ; i< tabuleiro; i++){
            for ( int j = 0 ; j<tabuleiro ; j++){
                posicoes[i][j] = new PosicaoImp(pecaFactory.vazio(), i , j);
            }
        }
        this.pecaFactory = pecaFactory;
    }

    public Posicao fabricarPosicao(Peca peca, int eixoX, int eixoY) throws PecaInexistenteError{
        posicoes[eixoX][eixoY].setPeca(peca);
        return posicoes[eixoX][eixoY];
    }

    public Posicao fabricarPosicao(int eixoX, int eixoY) throws PecaInexistenteError{
        return posicoes[eixoX][eixoY];
    }

    public Posicao[][] getTabuleiroVazio(){
        return this.posicoes;
    }

    public PecaFactory getPecaFactory(){
        return pecaFactory;
    }

    public int getLargura(){
        return this.largura;
    }
}
