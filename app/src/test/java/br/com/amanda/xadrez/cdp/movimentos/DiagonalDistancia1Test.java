package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.PosicaoImp;

import static org.junit.Assert.*;

/**
 * Created by amand on 26/01/2017.
 */
public class DiagonalDistancia1Test {
    private final Movimento mv = new DiagonalDistancia1();
    private final MovimentoTest mvT = new MovimentoTest();

    @Test
    public void moveNaDiagonalDistancia1() throws Exception {
        PosicaoImp p0 = new PosicaoImp(1,1);
        PosicaoImp p1 = new PosicaoImp(0,0);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(true, possoMover);
    }

    @Test
    public void moveNaDiagonalMaiorQue1() throws Exception {
        mvT.testaDiagonal(mv, false);
    }

    @Test
    public void naoveNaVertical() throws Exception {
        mvT.testaVertical(mv, false);
    }

    @Test
    public void naoMoveNaHorizontal() throws Exception {
        mvT.testaHorizontal(mv, false);
    }

    @Test
    public void naoMoveEmL() throws Exception {
        mvT.testaL(mv, false);
    }
}