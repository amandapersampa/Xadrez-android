package br.com.amanda.xadrez.cdp.peca;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

public abstract class PecaImp implements Peca {
    private final Cor cor;
    private boolean primeiroMovimento;
    private int movimentoMaximo;
    private final String nome;

    protected PecaImp(String nome, int movimentoMaximo, Cor cor) {
        this.cor = cor;
        this.primeiroMovimento = true;
        this.nome = nome;
        this.movimentoMaximo = movimentoMaximo;
    }

    protected PecaImp(String nome, Cor cor) {
        this.cor = cor;
        this.primeiroMovimento = true;
        this.nome = nome;
        this.movimentoMaximo = 8;
    }

    @Override
    public boolean validaMovimento(Posicao atual, Posicao nova, PosicaoFactory posicaoFactory) throws PecaInexistenteError {
        boolean valido = false;
        boolean movimentoEspecial;
        List<Movimento> movimentos = getMovimentos();
        if (movimentos != null && nova.isVazio()) {
            for (Movimento m : movimentos) {
                valido =  valido || m.isValido(atual, nova);
                movimentoEspecial = isMovimentoEspecial(atual, nova);
                valido = valido || campoLivre(atual, nova, m, posicaoFactory) || movimentoEspecial;
            }
            valido = valido && corPermite(atual, nova);
        }
        return valido;
    }

    @Override
    public boolean validaConquista(Posicao atual, Posicao nova, PosicaoFactory posicaoFactory) throws PecaInexistenteError {
        boolean valido = false;
        boolean movimentoEspecial;
        List<Movimento> conquistas = getConquistas();
        if (conquistas != null && !nova.isVazio() && !nova.getPeca().getCor().equals(cor)) {
            int i = 0;
            while (i<conquistas.size() && !valido) {
                Movimento m = conquistas.get(i);
                valido = m.isValido(atual, nova);
                movimentoEspecial = isMovimentoEspecial(atual, nova);
                valido = valido || campoLivre(atual, nova, m, posicaoFactory) || movimentoEspecial;
                i++;
            }
            valido = valido && corPermite(atual, nova);
        }
        return valido;
    }

    protected abstract List<Movimento> getMovimentos();

    protected abstract List<Movimento> getConquistas();

    protected boolean isMovimentoEspecial(Posicao posicao, Posicao nova) {
        return false;
    }

    protected boolean corPermite(Posicao posicao, Posicao nova) {
        return true;
    }

    public Cor getCor() {
        return cor;
    }

    protected boolean isPrimeiroMovimento() {
        return this.primeiroMovimento;
    }

    @Override
    public void moveu() {
        if (isPrimeiroMovimento()) {
            this.primeiroMovimento = false;
        }
    }

    protected int getMovimentoMaximo() {
        return movimentoMaximo;
    }

    protected void setMovimentoMaximo(int movimentoMaximo) {
        this.movimentoMaximo = movimentoMaximo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean isVazio() {
        return false;
    }

    private boolean campoLivre(Posicao atual, Posicao nova, Movimento m, PosicaoFactory posicaoFactory) throws PecaInexistenteError {
        if (m.isValido(atual, nova)) {
            boolean valido = true;
            Posicao anterior = atual;
            Posicao posterior = posicaoFactory.fabricarPosicaoAndada(anterior, nova, m);
            while (!posterior.mesmaPosicao(nova) && valido && posterior.noLimite()) {
                valido = posterior.isVazio();
                anterior = posterior;
                if (anterior.mesmaPosicao(posterior)) {
                    return false;
                }
                posterior = posicaoFactory.fabricarPosicaoAndada(anterior, nova, m);
            }
            return valido;
        }
        return false;
    }

}
