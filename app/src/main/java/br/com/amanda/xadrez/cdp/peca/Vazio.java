package br.com.amanda.xadrez.cdp.peca;

import java.util.ArrayList;
import java.util.List;
import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;

public class Vazio extends PecaImp {

    public Vazio(){
        super("Vazio", Cor.INDIFERENTE);
    }

    @Override
    public List<Movimento> getMovimentos() {
        return new ArrayList<>();
    }

    @Override
    public List<Movimento> getConquistas() {
        return new ArrayList<>();
    }

    @Override
    public boolean isVazio(){
        return true;
    }
}
