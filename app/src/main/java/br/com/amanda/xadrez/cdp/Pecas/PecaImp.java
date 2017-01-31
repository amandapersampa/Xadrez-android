package br.com.amanda.xadrez.cdp.pecas;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.utils.ConquistaNaoPermitidaError;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;

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
    public boolean validaMovimento(Posicao posicao, Posicao nova) {
        return valida(posicao, nova, getMovimentos());
    }

    @Override
    public boolean validaConquista(Posicao posicao, Posicao nova) {
        return valida(posicao, nova, getConquistas());
    }

    protected abstract List<Movimento> getMovimentos();

    protected abstract List<Movimento> getConquistas();

    protected boolean valida(Posicao atual, Posicao nova, List<Movimento> movimentos) {
        boolean valido = false;
        if (movimentos != null) {
            valido = movimentos.get(0).isValido(atual, nova);

            for (Movimento m : movimentos) {
                boolean movimentoEspecial = isMovimentoEspecial(atual, nova);
                valido = valido || m.isValido(atual, nova) || movimentoEspecial;
            }
            valido = valido && corPermite(atual, nova);
        }
        return valido;
    }

    protected boolean isMovimentoEspecial(Posicao posicao, Posicao nova) {
        return false;
    }

    protected boolean corPermite(Posicao posicao, Posicao nova){
        return true;
    }

    public Cor getCor(){
        return cor;
    }

    protected boolean isPrimeiroMovimento(){
        return this.primeiroMovimento;
    }

    @Override
    public void moveu(){
        if(isPrimeiroMovimento()) {
            this.primeiroMovimento = false;
        }
    }

    protected int getMovimentoMaximo(){
        return movimentoMaximo;
    }

    protected void setMovimentoMaximo(int movimentoMaximo){
        this.movimentoMaximo = movimentoMaximo;
    }

    @Override
    public String getNome(){
        return nome;
    }

}
