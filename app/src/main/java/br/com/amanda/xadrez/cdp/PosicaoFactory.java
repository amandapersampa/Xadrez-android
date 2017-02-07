package br.com.amanda.xadrez.cdp;

import java.util.ArrayList;
import java.util.List;

import br.com.amanda.xadrez.cdp.movimentos.Movimento;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.utils.PecaInexistenteError;


public class PosicaoFactory {
    private final Posicao[][] posicoes;
    private final PecaFactory pecaFactory;
    private final int largura;

    public PosicaoFactory(PecaFactory pecaFactory, int tabuleiro) {
        this.largura = tabuleiro;
        posicoes = new Posicao[tabuleiro][tabuleiro];
        for (int i = 0; i < tabuleiro; i++) {
            for (int j = 0; j < tabuleiro; j++) {
                posicoes[i][j] = new PosicaoImp(PecaFactory.vazio(), i, j);
            }
        }
        this.pecaFactory = pecaFactory;
    }

    public Posicao fabricarPosicao(Peca peca, int eixoX, int eixoY) throws PecaInexistenteError {
        posicoes[eixoX][eixoY].setPeca(peca);
        return posicoes[eixoX][eixoY];
    }

    public Posicao fabricarPosicao(int eixoX, int eixoY) throws PecaInexistenteError {
        return posicoes[eixoX][eixoY];
    }

    public Posicao fabricarPosicaoAndada(Posicao origem, Posicao destino, Movimento movimento) throws PecaInexistenteError {
        Posicao p = movimento.andar(origem, destino);
        return posicoes[p.getEixoX()][p.getEixoY()];
    }

    public Posicao[][] getTabuleiroVazio() {
        return this.posicoes;
    }

    public PecaFactory getPecaFactory() {
        return pecaFactory;
    }

    public Peca getVazio() throws PecaInexistenteError {
        return pecaFactory.fabricar("Vazio", Cor.INDIFERENTE);
    }

    public int getLargura() {
        return this.largura;
    }

    public List<Posicao> getPosicoesAoRedor(Posicao posicao) throws PecaInexistenteError {
        List<Posicao> posicoes = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    posicoes.add(fabricarPosicao(posicao.getEixoX() + i, posicao.getEixoY() + j));
                }
            }
        }
        return posicoes;
    }

    public boolean campoLivre(Posicao atual, Posicao nova) throws PecaInexistenteError {
        List<Movimento> movimentos = atual.getPeca().getMovimentos();
        int i = 0;
        boolean valido = false;
        while (i < movimentos.size() && !valido) {
            valido = isLivre(atual, nova, movimentos.get(i));
            i++;
        }
        return valido;
    }

    private boolean isLivre(Posicao atual, Posicao nova, Movimento m)throws PecaInexistenteError {
        boolean valido = true;
        if (m.isValido(atual, nova) && !atual.getPeca().isSaltador()) {
            Posicao anterior = atual;
            Posicao posterior = fabricarPosicaoAndada(anterior, nova, m);
            while (!anterior.mesmaPosicao(nova) && valido && posterior.noLimite()) {
                valido = posterior.isVazio() && !anterior.mesmaPosicao(posterior);
                anterior = posterior;
                posterior = fabricarPosicaoAndada(anterior, nova, m);
            }
        }
        return valido;
    }

    public List<Posicao> possiveisMovimentos(Posicao posicao, Posicao nova) throws PecaInexistenteError {
        List<Posicao> pM = new ArrayList<>();
        for (Posicao p : getPosicoesAoRedor(posicao)) {
            if (posicao.getPeca().validaMovimento(posicao, p)) {
                pM.add(posicao);
            }
        }
        return pM;
    }

    public List<Posicao> possiveisConquistas(Posicao posicao, Posicao nova) {
        List<Posicao> pM = new ArrayList<>();
        return pM;
    }

}
