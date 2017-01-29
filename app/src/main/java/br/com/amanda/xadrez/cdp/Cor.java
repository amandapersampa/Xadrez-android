package br.com.amanda.xadrez.cdp;

/**
 * Created by amand on 27/01/2017.
 */

public enum Cor {
    BRANCA("SOMA"), PRETO("SUBTRAI"), INDIFERENTE();

    private String operacao;

    Cor(String operacao){
        this.operacao = operacao;
    }

    Cor(){
    }

    public boolean validar(Posicao posicao, Posicao nova){
        return (operacao.equals("SOMA") && nova.getEixoX()>posicao.getEixoX())
                || (operacao.equals("SUBTRAI") && nova.getEixoX()<posicao.getEixoX());
    }
}
