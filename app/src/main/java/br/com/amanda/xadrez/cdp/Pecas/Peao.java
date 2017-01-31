package br.com.amanda.xadrez.cdp.pecas;

import java.util.ArrayList;
import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.movimentos.Diagonal;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.movimentos.Vertical;

public class Peao extends PecaImp {
    private final List<Movimento> movimentos;
    private final List<Movimento> conquistas;
    public Peao(Cor cor) {
        super("Peao", 2, cor);
        List<Movimento> mv = new ArrayList<>();
        mv.add(new Vertical(getMovimentoMaximo()));
        List<Movimento> cq = new ArrayList<>();
        cq.add(new Diagonal(getMovimentoMaximo()));
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
    protected boolean corPermite(Posicao posicao, Posicao nova) {
        return getCor().validar(posicao, nova);
    }

    @Override
    protected boolean isMovimentoEspecial(Posicao posicao, Posicao nova){
        if(isPrimeiroMovimento()){
            Posicao resultante = posicao.subtrai(nova);
            return resultante.getEixoX() == 2 && resultante.getEixoY() == 0;
        }
        return false;
    }

    @Override
    public void moveu(){
        if(this.isPrimeiroMovimento()) {
            super.moveu();
            setMovimentoMaximo(1);
            List<Movimento> mv = new ArrayList<>();
            mv.add(new Vertical(getMovimentoMaximo()));
            List<Movimento> cq = new ArrayList<>();
            cq.add(new Diagonal(getMovimentoMaximo()));
        }
    }
}
