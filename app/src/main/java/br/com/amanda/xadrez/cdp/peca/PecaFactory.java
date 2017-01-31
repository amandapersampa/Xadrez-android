package br.com.amanda.xadrez.cdp.peca;

import java.util.ArrayList;
import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

/**
 * Created by amand on 28/01/2017.
 */

public class PecaFactory {
    private final List<Peca> pecas;
    private final Peca vazia = new Vazio();

    public PecaFactory(){
        pecas = new ArrayList<>();
        Cor branco = Cor.BRANCA;
        Cor preto = Cor.PRETO;
        pecas.add(new Torre(branco));
        pecas.add(new Cavalo(branco));
        pecas.add(new Bispo(branco));
        pecas.add(new Rainha(branco));
        pecas.add(new Rei(branco));
        pecas.add(new Peao(branco));
        pecas.add(new Torre(preto));
        pecas.add(new Cavalo(preto));
        pecas.add(new Bispo(preto));
        pecas.add(new Rainha(preto));
        pecas.add(new Rei(preto));
        pecas.add(new Peao(preto));
        pecas.add(vazia);
        pecas.add(new Parede());
    }

    public Peca fabricar(String peca, Cor cor) throws PecaInexistenteError {
        for(Peca p : pecas){
            if(p.getNome().equals(peca) && p.getCor().equals(cor)){
                return p;
            }
        }
        throw new PecaInexistenteError();
    }

    public Peca vazio(){
        return vazia;
    }
}
