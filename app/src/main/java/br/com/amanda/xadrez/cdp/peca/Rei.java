package br.com.amanda.xadrez.cdp.peca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.movimentos.Diagonal;
import br.com.amanda.xadrez.cdp.movimentos.Horizontal;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.movimentos.Vertical;

public class Rei extends PecaImp {
    private final List<Movimento> movimentos;

    public Rei(Cor cor) {
        super("Rei", 1,cor);
        List<Movimento> mv = new ArrayList<>();
        mv.add(new Horizontal(getMovimentoMaximo()));
        mv.add(new Vertical(getMovimentoMaximo()));
        mv.add(new Diagonal(getMovimentoMaximo()));
        this.movimentos = mv;
    }

    @Override
    protected List<Movimento> getMovimentos(){
        return Collections.unmodifiableList(movimentos);
    }

    @Override
    protected List<Movimento> getConquistas(){
        return Collections.unmodifiableList(movimentos);
    }
}