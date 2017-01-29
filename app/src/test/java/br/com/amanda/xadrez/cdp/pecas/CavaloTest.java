package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

/**
 * Created by amand on 26/01/2017.
 */
public class CavaloTest {
    private final PecaTest teste = new PecaTest("Cavalo", Cor.BRANCA);

    public CavaloTest() throws PecaInexistenteError {
    }

    @Test
    public void testaMovimentoDiagonalDistancia1() throws Exception {
        teste.testaMovimentoDiagonalDistancia1(false);
    }

    @Test
    public void testaMovimentoVerticalDistancia1() throws Exception {
        teste.testaMovimentoVerticalDistancia1(false);
    }

    @Test
    public void testaMovimentoHorizontalDistancia1() throws Exception {
        teste.testaMovimentoHorizontalDistancia1(false);
    }

    @Test
    public void testaMovimentoDiagonal() throws Exception {
        teste.testaMovimentoDiagonal(false);
    }

    @Test
    public void testaMovimentoVertical() throws Exception {
        teste.testaMovimentoVertical(false);
    }

    @Test
    public void testaMovimentoHorizontal() throws Exception {
        teste.testaMovimentoHorizontal(false);
    }

    @Test
    public void testaMovimentoL() throws Exception {
        teste.testaMovimentoL(true);
    }

    @Test
    public void testaConquistaHorizontal() throws Exception {
        teste.testaConquistaHorizontal(false);
    }

    @Test
    public void testaConquistaDiagonalDistancia1() throws Exception {
        teste.testaConquistaDiagonalDistancia1(false);
    }

    @Test
    public void testaConquistaVerticalDistancia1() throws Exception {
        teste.testaConquistaVerticalDistancia1(false);
    }

    @Test
    public void testaConquistaHorizontalDistancia1() throws Exception {
        teste.testaConquistaHorizontalDistancia1(false);
    }

    @Test
    public void testaConquistaDiagonal() throws Exception {
        teste.testaConquistaDiagonal(false);
    }

    @Test
    public void testaConquistaVertical() throws Exception {
        teste.testaConquistaVertical(false);
    }

    @Test
    public void testaConquistaL() throws Exception {
        teste.testaConquistaL(true);
    }
}