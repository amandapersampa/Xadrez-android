package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

/**
 * Created by amand on 26/01/2017.
 */
public class HorizontalTest {
    private final Movimento mv = new Horizontal();
    private final MovimentoTest mvT = new MovimentoTest();

    @Test
    public void naoMoveNaDiagonalMaiorQue1() throws Exception {
        mvT.testaDiagonal(mv, false);
    }

    @Test
    public void naoMoveNaVertical() throws Exception {
        mvT.testaVertical(mv, false);
    }

    @Test
    public void moveNaHorizontal() throws Exception {
        mvT.testaHorizontal(mv, true);
    }

    @Test
    public void naoMoveEmL() throws Exception {
        mvT.testaL(mv, false);
    }

}