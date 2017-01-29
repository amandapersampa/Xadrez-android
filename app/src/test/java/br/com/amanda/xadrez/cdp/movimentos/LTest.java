package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

/**
 * Created by amand on 26/01/2017.
 */
public class LTest {
    private final Movimento mv = new L();
    private final MovimentoTest mvT = new MovimentoTest();

    @Test
    public void naoMoveNaDiagonal() throws Exception {
        mvT.testaDiagonal(mv, false);
    }

    @Test
    public void moveNaVertical() throws Exception {
        mvT.testaVertical(mv, false);
    }

    @Test
    public void moveNaHorizontal() throws Exception {
        mvT.testaHorizontal(mv, false);
    }

    @Test
    public void moveEmL() throws Exception {
        mvT.testaL(mv, true);
    }

}