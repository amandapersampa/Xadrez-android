package br.com.amanda.xadrez.cdp;

import org.junit.Test;

import java.util.List;

import br.com.amanda.xadrez.cdp.peca.Peao;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.cdp.peca.Torre;
import br.com.amanda.xadrez.cdp.peca.Vazio;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;
import br.com.amanda.xadrez.utils.PecaInexistenteError;
import static org.junit.Assert.*;

public class TabuleiroTest {

    @Test
    public void possiveisConquistas() throws Exception {

    }

    @Test
    public void possiveisMovimentos() throws Exception {
        PosicaoFactory p = new PosicaoFactory(new PecaFactory(), 8);
        Tabuleiro tab = new Tabuleiro(p);
        List<Posicao> lp = tab.possiveisMovimentos(p.fabricarPosicao(1,1));
        assertEquals(0, lp.size());
    }

    @Test
    public void moverPeao() throws Exception, MovimentoNaoPermitidoError {
        assertEquals(true, moveu(1,0,2,0));
    }

    @Test
    public void moverPeaoDuplo() throws Exception, MovimentoNaoPermitidoError {
        assertEquals(true, moveu(1,0,3,0));
    }

    @Test
    public void moverCavalo() throws Exception, MovimentoNaoPermitidoError {
        assertEquals(true, moveu(0,1,2,2));
    }

    @Test
    public void naoMoverTorre() throws Exception, MovimentoNaoPermitidoError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Tabuleiro tab = new Tabuleiro(posicaoFactory);
        Peca torre = new Torre(Cor.BRANCA);
        Posicao p0 = posicaoFactory.fabricarPosicao(torre, 0,0);
        Posicao p1 = posicaoFactory.fabricarPosicao(posicaoFactory.getVazio(), 3,0);
        Peca peca = tab.getPeca(p1);
        try {
            tab.mover(p0, p1);
        }
        catch (MovimentoNaoPermitidoError e) {
            Peca movida = tab.getPeca(p1);
            assertEquals(peca, movida);
        }
    }

    @Test
    public void moverTorre() throws Exception, MovimentoNaoPermitidoError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Tabuleiro tab = new Tabuleiro(posicaoFactory);
        /*
        Tirar Peão da frente
         */
        Posicao p0B = posicaoFactory.fabricarPosicao(1,0);
        Posicao p1B = posicaoFactory.fabricarPosicao(3,0);
        Peca pecaB = tab.getPeca(p0B);
        tab.mover(p0B, p1B);
        Peca movida = tab.getPeca(p1B);
        assertEquals(pecaB, movida);

        /*
            Mover Torre ate a posicao antiga do Peao
         */
        Posicao p0T = posicaoFactory.fabricarPosicao(0,0);
        Posicao p1T = posicaoFactory.fabricarPosicao(2,0);
        Peca torre = tab.getPeca(p0T);
        tab.mover(p0T, p1T);
        movida = tab.getPeca(p1T);
        assertEquals(torre, movida);

        /*
            Mover Torre ate a posicao antiga do Peao
         */
        p0T = posicaoFactory.fabricarPosicao(2,0);
        p1T = posicaoFactory.fabricarPosicao(2,1);
        torre = tab.getPeca(p0T);
        tab.mover(p0T, p1T);
        movida = tab.getPeca(p1T);
        assertEquals(torre, movida);

        /*
            Usar a Torre para conquistar o Peao
         */
        Posicao p0P = posicaoFactory.fabricarPosicao(6,1);
        tab.conquistar(p1T, p0P);
        movida = tab.getPeca(p0P);
        assertEquals(torre, movida);
    }

    @Test
    public void conquistarPeao() throws Exception, MovimentoNaoPermitidoError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Tabuleiro tab = new Tabuleiro(posicaoFactory);

        Posicao p0B = posicaoFactory.fabricarPosicao(1,0);
        Posicao p1B = posicaoFactory.fabricarPosicao(3,0);
        Peca pecaB = tab.getPeca(p0B);
        tab.mover(p0B, p1B);
        Peca movida = tab.getPeca(p1B);
        assertEquals(pecaB, movida);

        Posicao p0P = posicaoFactory.fabricarPosicao(6,1);
        Posicao p1P = posicaoFactory.fabricarPosicao(4,1);
        Peca pecaP = tab.getPeca(p0P);
        tab.mover(p0P, p1P);
        movida = tab.getPeca(p1P);
        assertEquals(pecaP, movida);

        tab.conquistar(p1B, p1P);
        movida = tab.getPeca(p1P);

        assertEquals(pecaB, movida);
    }

    private boolean moveu(int origemX, int origemY, int destinoX, int destinoY) throws PecaInexistenteError, MovimentoNaoPermitidoError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Tabuleiro tab = new Tabuleiro(posicaoFactory);
        Posicao p0 = posicaoFactory.fabricarPosicao(origemX, origemY);
        Posicao p1 = posicaoFactory.fabricarPosicao(destinoX, destinoY);
        Peca peca = tab.getPeca(p0);
        tab.mover(p0, p1);
        Peca movida = tab.getPeca(p1);
        return peca.equals(movida);
    }
}