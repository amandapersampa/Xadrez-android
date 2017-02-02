package br.com.amanda.xadrez.cdp;

import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.utils.PecaInexistenteError;


public class PosicaoFactory {
    private final Posicao[][] posicoes;
    private final PecaFactory pecaFactory;
    private final int largura;

    public PosicaoFactory(PecaFactory pecaFactory, int tabuleiro) {
        this.largura = tabuleiro;
        posicoes = new Posicao[tabuleiro][tabuleiro];
        for(int i = 0 ; i< tabuleiro; i++){
            for ( int j = 0 ; j<tabuleiro ; j++){
                posicoes[i][j] = new PosicaoImp(PecaFactory.vazio(), i , j);
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

    public Posicao fabricarPosicaoAndada(Posicao origem, Posicao destino, Movimento movimento) throws PecaInexistenteError{
        Posicao p = movimento.andar(origem, destino);
         return posicoes[p.getEixoX()][p.getEixoY()];
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
