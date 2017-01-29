package br.com.amanda.xadrez.cdp.Pecas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.movimentos.Horizontal;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.movimentos.Vertical;

/**
 * Created by amand on 26/01/2017.
 */

public class Torre extends PecaImp {
    private final List<Movimento> movimentos;

    public Torre(Posicao posicao, Cor cor) {
        super(posicao, cor);
        List<Movimento> mv = new ArrayList<>();
        mv.add(new Vertical());
        mv.add(new Horizontal());
        this.movimentos = mv;
    }

    @Override
    protected List<Movimento> getMovimentos() {
        return Collections.unmodifiableList(movimentos);
    }

    @Override
    protected List<Movimento> getConquistas() {
        return Collections.unmodifiableList(movimentos);
    }
}
