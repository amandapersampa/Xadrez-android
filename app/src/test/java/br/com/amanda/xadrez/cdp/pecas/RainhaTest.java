package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

/**
 * Created by amand on 26/01/2017.
 */
public class RainhaTest {
    private final PecaTest teste = new PecaTest("Rainha", Cor.BRANCA);

    public RainhaTest() throws PecaInexistenteError {
    }

    @Test
    public void testaMovimentoDiagonalDistancia1() throws Exception {
        teste.testaMovimentoDiagonalDistancia1(true);
    }

    @Test
    public void testaMovimentoVerticalDistancia1() throws Exception {
        teste.testaMovimentoVerticalDistancia1(true);
    }

    @Test
    public void testaMovimentoHorizontalDistancia1() throws Exception {
        teste.testaMovimentoHorizontalDistancia1(true);
    }

    @Test
    public void testaMovimentoDiagonal() throws Exception {
        teste.testaMovimentoDiagonal(true);
    }

    @Test
    public void testaMovimentoVertical() throws Exception {
        teste.testaMovimentoVertical(true);
    }

    @Test
    public void testaMovimentoHorizontal() throws Exception {
        teste.testaMovimentoHorizontal(true);
    }

    @Test
    public void testaMovimentoL() throws Exception {
        teste.testaMovimentoL(false);
    }

    @Test
    public void testaConquistaHorizontal() throws Exception {
        teste.testaConquistaHorizontal(true);
    }

    @Test
    public void testaConquistaDiagonalDistancia1() throws Exception {
        teste.testaConquistaDiagonalDistancia1(true);
    }

    @Test
    public void testaConquistaVerticalDistancia1() throws Exception {
        teste.testaConquistaVerticalDistancia1(true);
    }

    @Test
    public void testaConquistaHorizontalDistancia1() throws Exception {
        teste.testaConquistaHorizontalDistancia1(true);
    }

    @Test
    public void testaConquistaDiagonal() throws Exception {
        teste.testaConquistaDiagonal(true);
    }

    @Test
    public void testaConquistaVertical() throws Exception {
        teste.testaConquistaVertical(true);
    }
}