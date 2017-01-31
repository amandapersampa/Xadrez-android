package br.com.amanda.xadrez.cdp.pecas;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
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

    @Override
    public boolean equals(Object o){
        try{
            Vazio vazio = ((Vazio) o);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
