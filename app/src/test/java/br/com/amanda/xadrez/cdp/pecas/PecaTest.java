package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Ignore;
import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Pecas.Peca;
import br.com.amanda.xadrez.cdp.Pecas.PecaFactory;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.cdp.PosicaoImp;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

import static org.junit.Assert.*;

@Ignore
public class PecaTest {
    private final PosicaoFactory posicaoFactory = new PosicaoFactory();
    private final PecaFactory pecaFactory = new PecaFactory(posicaoFactory);
    private final int posX = 5;
    private final int posY = 5;
    private Peca peca;

    public PecaTest(String peca, Cor cor) throws PecaInexistenteError {
        this.peca = pecaFactory.fabricar(peca, posX, posY, cor);
    }

    @Test
    public void testaMovimentoDiagonalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX-1,posY-1);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoVerticalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+1,posY);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoHorizontalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX,posY+1);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoVerticalPeaoPreto(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX-1,posY);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoDiagonal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX-5,posY-5);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoVertical(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX,posY-7);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoHorizontal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+4,posY);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoL(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+2,posY+1);

        boolean possoMover = peca.validaMovimento(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaHorizontal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+2,posY);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaDiagonalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+1,posY+1);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaPeaoPreto(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX-1,posY+1);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaVerticalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+1,posY);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaHorizontalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+1,posY);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaDiagonal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+3,posY-3);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

   @Test
    public void testaConquistaL(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX+2,posY+1);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaVertical(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(posX,posY+10);

        boolean possoMover = peca.validaConquista(p1);

        assertEquals(expected, possoMover);
    }

}