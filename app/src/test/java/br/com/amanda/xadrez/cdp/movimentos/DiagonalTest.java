package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

public class DiagonalTest {
    private final Movimento mv = new Diagonal(8);
    private final MovimentoTest mvT = new MovimentoTest();

    @Test
    public void moveNaDiagonal() throws Exception {
        mvT.testaDiagonal(mv, true);
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