package br.com.amanda.xadrez.cdp;

public class PosicaoImp implements Posicao {
    private final int eixoX;
    private final int eixoY;

    public PosicaoImp(int eixoX, int eixoY){
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }

    @Override
    public Posicao subtrai(Posicao posicaoImp){
        return new PosicaoImp(Math.abs(eixoX- posicaoImp.getEixoX()), Math.abs(eixoY- posicaoImp.getEixoY()));
    }

    public int getEixoX() {
        return eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    @Override
    public boolean equals(Object o)
    {
        try{
            return getEixoX() == ((Posicao) o).getEixoX() && getEixoY() == ((Posicao) o).getEixoY();
        }
        catch (Exception e){
            return false;
        }
    }
}
