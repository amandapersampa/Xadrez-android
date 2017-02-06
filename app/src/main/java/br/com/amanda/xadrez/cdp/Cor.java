package br.com.amanda.xadrez.cdp;

public enum Cor {
    BRANCA{
        public boolean validar(Posicao posicao, Posicao nova){
            return nova.getEixoX()>posicao.getEixoX();
        }
        public Cor getOposto() {
            return Cor.PRETO;
        }
    }, PRETO{
        public boolean validar(Posicao posicao, Posicao nova){
            return nova.getEixoX()< posicao.getEixoX();
        }
        public Cor getOposto() {
            return Cor.BRANCA;
        }
    }, INDIFERENTE;

    public boolean validar(Posicao posicao, Posicao nova){
        return true;
    }

    public Cor getOposto() {
        return Cor.INDIFERENTE;
    }
}
