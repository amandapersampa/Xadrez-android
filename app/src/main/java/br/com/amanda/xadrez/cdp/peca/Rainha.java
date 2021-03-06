package br.com.amanda.xadrez.cdp.peca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.movimentos.Diagonal;
import br.com.amanda.xadrez.cdp.movimentos.Horizontal;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.movimentos.Vertical;

public class Rainha extends PecaImp {
    private final List<Movimento> movimentos;

    public Rainha(Cor cor) {
        super("Rainha",cor);
        List<Movimento> mv = new ArrayList<>();
        mv.add(new Vertical(getMovimentoMaximo()));
        mv.add(new Horizontal(getMovimentoMaximo()));
        mv.add(new Diagonal(getMovimentoMaximo()));
        this.movimentos = mv;
    }

    @Override
    public List<Movimento> getMovimentos() {
        return Collections.unmodifiableList(movimentos);
    }

    @Override
    public List<Movimento> getConquistas() {
        return Collections.unmodifiableList(movimentos);
    }
}
