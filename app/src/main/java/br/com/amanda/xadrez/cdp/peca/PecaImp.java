package br.com.amanda.xadrez.cdp.peca;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
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
    public boolean validaMovimento(Posicao atual, Posicao nova) throws PecaInexistenteError {
        boolean valido = false;
        int i = 0;
        List<Movimento> movimentos = getMovimentos();
        if (movimentos != null && nova.isVazio()) {
            while (i< movimentos.size() && !valido) {
                Movimento m = movimentos.get(i);
                valido = m.isValido(atual, nova) || isMovimentoEspecial(atual, nova);
                i++;
            }
            valido = valido && corPermite(atual, nova);
        }
        return valido;
    }

    @Override
    public boolean validaConquista(Posicao atual, Posicao nova) throws PecaInexistenteError {
        boolean valido = false;
        List<Movimento> conquistas = getConquistas();
        if (conquistas != null && !nova.isVazio() && !nova.getPeca().getCor().equals(cor)) {
            int i = 0;
            while (i<conquistas.size() && !valido) {
                Movimento m = conquistas.get(i);
                valido = m.isValido(atual, nova) || isMovimentoEspecial(atual, nova);
                i++;
            }
            valido = valido && corPermite(atual, nova);
        }
        return valido;
    }

    public abstract List<Movimento> getMovimentos();

    public abstract List<Movimento> getConquistas();

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

    @Override
    public boolean isSaltador(){
        return false;
    }
}
