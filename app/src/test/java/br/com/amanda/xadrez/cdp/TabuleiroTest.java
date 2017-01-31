package br.com.amanda.xadrez.cdp;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.peca.Peao;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.cdp.peca.Torre;
import br.com.amanda.xadrez.cdp.peca.Vazio;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;
import br.com.amanda.xadrez.utils.PecaInexistenteError;
import static org.junit.Assert.*;

public class TabuleiroTest {
    private final PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
    private final Tabuleiro tab = new Tabuleiro(posicaoFactory);
    private final Peca vazio = new Vazio();

    public TabuleiroTest() throws PecaInexistenteError {
    }

    @Test
    public void possiveisMovimentos() throws Exception {

    }

    @Test
    public void moverPeao() throws Exception, MovimentoNaoPermitidoError {
        Posicao p0 = posicaoFactory.fabricarPosicao(1,0);
        Posicao p1 = posicaoFactory.fabricarPosicao(2,0);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }

    @Test
    public void moverPeaoDuplo() throws Exception, MovimentoNaoPermitidoError {
        Peca peao = new Peao(Cor.BRANCA);
        Posicao p0 = posicaoFactory.fabricarPosicao(1,0);
        Posicao p1 = posicaoFactory.fabricarPosicao(3,0);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }

    @Test
    public void naoMoverTorre() throws Exception, MovimentoNaoPermitidoError {
        Peca torre = new Torre(Cor.BRANCA);
        Posicao p0 = posicaoFactory.fabricarPosicao(torre, 0,0);
        Posicao p1 = posicaoFactory.fabricarPosicao(vazio, 3,0);
        Peca peca = tab.getPeca(p1);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }

    @Test
    public void toStringTest() throws Exception {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Tabuleiro tab = new Tabuleiro(posicaoFactory);
        tab.toString();
    }

    @Test
    public void moverCavalo() throws Exception, MovimentoNaoPermitidoError {
        Posicao p0 = posicaoFactory.fabricarPosicao(0,1);
        Posicao p1 = posicaoFactory.fabricarPosicao(2,2);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }

    @Test
    public void conquistarPeao() throws Exception, MovimentoNaoPermitidoError {
        Posicao p0 = posicaoFactory.fabricarPosicao(1,0);
        Posicao p1 = posicaoFactory.fabricarPosicao(3,0);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        assertEquals(peca, movida);
    }
}