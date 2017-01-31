package br.com.amanda.xadrez.cdp.movimentos;

import org.junit.Ignore;
import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.PosicaoImp;
import br.com.amanda.xadrez.cdp.peca.Cavalo;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.Rainha;

import static org.junit.Assert.assertEquals;

@Ignore
public class MovimentoTest {
    private Peca rainha = new Rainha(Cor.PRETO);
    private Peca cavalo = new Cavalo(Cor.BRANCA);

    @Test
    public void testaDiagonal(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(rainha, 4,4);
        PosicaoImp p1 = new PosicaoImp(rainha, 0,0);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaVertical(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(rainha, 0,0);
        PosicaoImp p1 = new PosicaoImp(rainha, 8,0);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaHorizontal(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(rainha, 0,0);
        PosicaoImp p1 = new PosicaoImp(rainha, 0,5);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }

    @Test
    public void testaL(Movimento mv, boolean expected) throws Exception {
        PosicaoImp p0 = new PosicaoImp(cavalo, 4,5);
        PosicaoImp p1 = new PosicaoImp(cavalo, 3,7);

        boolean possoMover = mv.isValido(p0,p1);

        assertEquals(expected, possoMover);
    }
}
