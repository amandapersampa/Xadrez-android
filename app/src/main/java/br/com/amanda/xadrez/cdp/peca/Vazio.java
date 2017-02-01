package br.com.amanda.xadrez.cdp.peca;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;

/**
 * Created by amand on 27/01/2017.
 */

public class Vazio extends PecaImp {

    public Vazio(){
        super("Vazio", Cor.INDIFERENTE);
    }

    @Override
    protected List<Movimento> getMovimentos() {
        return null;
    }

    @Override
    protected List<Movimento> getConquistas() {
        return null;
    }

}
