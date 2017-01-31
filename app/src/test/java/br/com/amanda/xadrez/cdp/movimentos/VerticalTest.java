package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

/**
 * Created by amand on 26/01/2017.
 */
public class VerticalTest {

    private final Movimento mv = new Vertical(8);
    private final MovimentoTest mvT = new MovimentoTest();


    @Test
    public void naoMoveNaDiagonalMaiorQue1() throws Exception {
        mvT.testaDiagonal(mv, false);
    }

    @Test
    public void moveNaVertical() throws Exception {
        mvT.testaVertical(mv, true);
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