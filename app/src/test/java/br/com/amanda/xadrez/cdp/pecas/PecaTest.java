package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.cdp.PosicaoImp;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.cdp.peca.Vazio;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

import static org.junit.Assert.*;

@Ignore
public class PecaTest {
    private final int posX = 5;
    private final int posY = 5;
    private final Peca peca;
    private final Peca vazio = new Vazio();
    private final Posicao p0;

    public PecaTest(String nome, Cor cor) throws PecaInexistenteError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        PecaFactory pecaFactory = posicaoFactory.getPecaFactory();
        this.peca = pecaFactory.fabricar(nome, cor);
        this.p0 = new PosicaoImp(peca, posX, posY);
    }

    @Test
    public void testaMovimentoDiagonalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX-1,posY-1);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoVerticalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio,posX+1,posY);

        boolean possoMover = peca.validaMovimento(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoHorizontalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX,posY+1);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoVerticalPeaoPreto(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX-1,posY);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoDiagonal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX-5,posY-5);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoVertical(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX,posY-7);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoHorizontal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+4,posY);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaMovimentoL(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+2,posY+1);

        boolean possoMover = peca.validaMovimento(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaHorizontal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+5,posY);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaDiagonalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+1,posY+1);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaPeaoPreto(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX-1,posY+1);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaVerticalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+1,posY);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaHorizontalDistancia1(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+1,posY);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaDiagonal(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+3,posY-3);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

   @Test
    public void testaConquistaL(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio, posX+2,posY+1);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaConquistaVertical(boolean expected) throws Exception {
        PosicaoImp p1 = new PosicaoImp(vazio,posX,posY+8);

        boolean possoMover = peca.validaConquista(p0, p1);

        assertEquals(expected, possoMover);
    }

}