package br.com.amanda.xadrez.cdp.Pecas;

import java.util.List;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.utils.ConquistaNaoPermitidaError;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;

public abstract class PecaImp implements Peca {
    private final Cor cor;
    private Posicao posicao;
    private boolean primeiroMovimento;

    protected PecaImp(Posicao posicao, Cor cor) {
        this.cor = cor;
        this.posicao = posicao;
        this.primeiroMovimento = true;
    }

    @Override
    public boolean validaMovimento(Posicao nova) {
        return valida(this.posicao, nova, getMovimentos());
    }

    @Override
    public boolean validaConquista(Posicao nova) {
        return valida(this.posicao, nova, getConquistas());
    }

    @Override
    public Posicao getPosicao() {
        return posicao;
    }

    @Override
    public void mover(Posicao nova) throws MovimentoNaoPermitidoError {
        if (validaMovimento(nova)) {
            posicao = nova;
            moveu();
        }
        else {
            throw new MovimentoNaoPermitidoError();
        }
    }

    @Override
    public void conquistar(Posicao nova) throws ConquistaNaoPermitidaError {
        if (validaConquista(nova)) {
            posicao = nova;
            moveu();
        }
        else {
            throw new ConquistaNaoPermitidaError();
        }
    }

    protected abstract List<Movimento> getMovimentos();

    protected abstract List<Movimento> getConquistas();

    protected boolean valida(Posicao atual, Posicao nova, List<Movimento> movimentos) {
        boolean valido = false;
        if (movimentos != null) {
            valido = movimentos.get(0).isValido(atual, nova);

            for (Movimento m : movimentos) {
                boolean movimentoEspecial = isMovimentoEspecial(nova);
                valido = valido || m.isValido(atual, nova) || movimentoEspecial;
            }
            valido = valido && corPermite(nova);
        }
        return valido;
    }

    protected boolean isMovimentoEspecial(Posicao nova) {
        return false;
    }

    protected boolean corPermite(Posicao nova){
        return true;
    }

    public Cor getCor(){
        return cor;
    }

    protected boolean isPrimeiroMovimento(){
        return this.primeiroMovimento;
    }

    protected void moveu(){
        this.primeiroMovimento = false;
    }

}
