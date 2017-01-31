package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.PosicaoImp;
import br.com.amanda.xadrez.cdp.pecas.Peca;
import br.com.amanda.xadrez.cdp.pecas.Rei;

import static org.junit.Assert.*;

/**
 * Created by amand on 26/01/2017.
 */
public class HorizontalDistancia1Test {
    private final Movimento mv = new Horizontal(1);
    private final MovimentoTest mvT = new MovimentoTest();
    private final Peca rei = new Rei(Cor.PRETO);

    @Test
    public void moveNaHorizontalDistancia1() throws Exception {
        PosicaoImp p0 = new PosicaoImp(rei, 0,0);
        PosicaoImp p1 = new PosicaoImp(rei, 0,1);

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