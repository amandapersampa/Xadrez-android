package br.com.amanda.xadrez.cdp;

import br.com.amanda.xadrez.cdp.peca.Peca;

public class PosicaoImp implements Posicao {
    private final int eixoX;
    private final int eixoY;
    private Peca peca;

    public PosicaoImp(Peca peca, int eixoX, int eixoY){
        this.eixoX = eixoX;
        this.eixoY = eixoY;
        this.peca = peca;
    }

    @Override
    public Posicao subtrai(Posicao posicaoImp){
        return new PosicaoImp(posicaoImp.getPeca(), Math.abs(eixoX- posicaoImp.getEixoX()), Math.abs(eixoY- posicaoImp.getEixoY()));
    }

    public int getEixoX() {
        return eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    public Peca getPeca(){
        return peca;
    }

    @Override
    public boolean mesmaPosicao(Posicao posicao) {
        return this.getEixoY() == posicao.getEixoX() && this.getEixoY() == posicao.getEixoY();
    }

    @Override
    public void setPeca(Peca peca){
        this.peca = peca;
    }
}
