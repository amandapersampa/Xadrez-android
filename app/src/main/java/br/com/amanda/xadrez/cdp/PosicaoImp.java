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

    public PosicaoImp(int eixoX, int eixoY){
        this.eixoX = eixoX;
        this.eixoY = eixoY;
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
    public Posicao somaVertical(Posicao destino) {
        int eixoXFinal = eixoX;
        if(this.eixoX > destino.getEixoX())
            eixoXFinal -= 1;
        else{
            eixoXFinal += 1;
        }
        return new PosicaoImp(this.getPeca(),eixoXFinal, this.eixoY);
    }

    @Override
    public Posicao somaHorizontal(Posicao destino) {
        int eixoYFinal = eixoY;
        if(this.eixoY > destino.getEixoY())
            eixoYFinal -= 1;
        else{
            eixoYFinal += 1;
        }
        return new PosicaoImp(this.getPeca(),this.eixoX, eixoYFinal);
    }

    @Override
    public Posicao somaDiagonal(Posicao destino) {
        Posicao p = somaVertical(destino);
        p = p.somaHorizontal(destino);
        return p;
    }

    @Override
    public boolean isVazio() {
        return peca.isVazio();
    }

    @Override
    public boolean mesmaPosicao(Posicao posicao) {
        return this.getEixoX() == posicao.getEixoX() && this.getEixoY() == posicao.getEixoY();
    }

    @Override
    public void setPeca(Peca peca){
        this.peca = peca;
    }

    @Override
    public boolean noLimite() {
        return eixoX < 8 && eixoY <8;
    }


}
