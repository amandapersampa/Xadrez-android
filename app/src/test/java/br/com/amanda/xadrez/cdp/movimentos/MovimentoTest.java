package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Ignore;
import org.junit.Test;

import br.com.amanda.xadrez.cdp.PosicaoImp;

import static org.junit.Assert.assertEquals;

@Ignore
public class MovimentoTest {
    @Test
    public void testaDiagonal(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(4,4);
        PosicaoImp p1 = new PosicaoImp(0,0);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaVertical(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(0,0);
        PosicaoImp p1 = new PosicaoImp(10,0);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaHorizontal(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(0,0);
        PosicaoImp p1 = new PosicaoImp(0,5);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaL(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(4,5);
        PosicaoImp p1 = new PosicaoImp(3,7);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }
}
