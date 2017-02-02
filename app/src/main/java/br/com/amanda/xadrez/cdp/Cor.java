package br.com.amanda.xadrez.cdp;

public enum Cor {
    BRANCA{
        public boolean validar(Posicao posicao, Posicao nova){
            return nova.getEixoX()>posicao.getEixoX();
        }
    }, PRETO{
        public boolean validar(Posicao posicao, Posicao nova){
            return nova.getEixoX()< posicao.getEixoX();
        }
    }, INDIFERENTE;

    public boolean validar(Posicao posicao, Posicao nova){
        return true;
    }
}
