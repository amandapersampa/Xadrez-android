package br.com.amanda.xadrez.cdp;

import org.junit.Test;
import br.com.amanda.xadrez.cdp.Pecas.Peca;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;
import br.com.amanda.xadrez.utils.PecaInexistenteError;
import static org.junit.Assert.*;

public class TabuleiroTest {
    private final PosicaoFactory posicaoFactory = new PosicaoFactory();
    private final Tabuleiro tab = new Tabuleiro(posicaoFactory);

    public TabuleiroTest() throws PecaInexistenteError {
    }

    @Test
    public void possiveisMovimentos() throws Exception {

    }

    @Test
    public void moverPeao() throws Exception, MovimentoNaoPermitidoError {
        Posicao p0 = posicaoFactory.fabricarPosicao(2,1);
        Posicao p1 = posicaoFactory.fabricarPosicao(3,1);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }

    @Test
    public void moverPeaoDuplo() throws Exception, MovimentoNaoPermitidoError {
        Posicao p0 = posicaoFactory.fabricarPosicao(2,1);
        Posicao p1 = posicaoFactory.fabricarPosicao(4,1);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }

    @Test
    public void conquistarPeao() throws Exception, MovimentoNaoPermitidoError {
        Posicao p0 = posicaoFactory.fabricarPosicao(2,1);
        Posicao p1 = posicaoFactory.fabricarPosicao(4,1);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }
}