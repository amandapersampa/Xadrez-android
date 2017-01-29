package br.com.amanda.xadrez.cdp.Pecas;

import java.util.ArrayList;
import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.movimentos.DiagonalDistancia1;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.movimentos.VerticalDistancia1;

/**
 * Created by amand on 26/01/2017.
 */

public class Peao extends PecaImp {
    private final List<Movimento> movimentos;
    private final List<Movimento> conquistas;

    public Peao(Posicao posicao, Cor cor) {
        super(posicao, cor);
        List<Movimento> mv = new ArrayList<>();
        mv.add(new VerticalDistancia1());
        List<Movimento> cq = new ArrayList<>();
        cq.add(new DiagonalDistancia1());
        this.movimentos = mv;
        this.conquistas = cq;
    }

    @Override
    protected List<Movimento> getMovimentos() {
        return movimentos;
    }

    @Override
    protected List<Movimento> getConquistas() {
        return conquistas;
    }

    @Override
    protected boolean corPermite(Posicao nova) {
        return getCor().validar(getPosicao(), nova);
    }

    @Override
    protected boolean isMovimentoEspecial(Posicao nova){
        if(isPrimeiroMovimento()){
            return this.getPosicao().subtrai(nova).getEixoX() == 2;
        }
        return false;
    }
}
