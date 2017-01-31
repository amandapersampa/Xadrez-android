package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.PosicaoImp;
import br.com.amanda.xadrez.cdp.peca.Bispo;
import br.com.amanda.xadrez.cdp.peca.Peca;

import static org.junit.Assert.*;

public class DiagonalDistancia1Test {
    private final Movimento mv = new Diagonal(1);
    private final Peca peca = new Bispo(Cor.BRANCA);
    private final MovimentoTest mvT = new MovimentoTest();

    @Test
    public void moveNaDiagonalDistancia1() throws Exception {
        PosicaoImp p0 = new PosicaoImp(peca,1,1);
        PosicaoImp p1 = new PosicaoImp(peca, 0,0);

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