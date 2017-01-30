package br.com.amanda.xadrez.cdp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amand on 29/01/2017.
 */

public class PosicaoFactory {
    private final List<Posicao> posicoes;

    public PosicaoFactory(){
        posicoes = new ArrayList<>();
    }

    public Posicao fabricarPosicao(int eixoX, int eixoY){
        Posicao nova = new PosicaoImp(eixoX,eixoY);
        Posicao p = contains(nova);
        if(p==null){
            this.posicoes.add(nova);
            return nova;
        }
        return p;
    }

    public Posicao contains(Posicao posicao){
        for (Posicao p: posicoes) {
            if(p.equals(posicao)){
                return p;
            }
        }
        return null;
    }
}
