package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

public class PeaoTest {
    private final PecaTest teste = new PecaTest("Peao", Cor.BRANCA);

    public PeaoTest() throws PecaInexistenteError {
    }

    @Test
    public void testaMovimentoDiagonalDistancia1() throws Exception {
        teste.testaMovimentoDiagonalDistancia1(false);
    }

    @Test
    public void testaMovimentoVerticalDistancia1() throws Exception {
        teste.testaMovimentoVerticalDistancia1(true);
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
        teste.testaMovimentoL(false);
    }

    @Test
    public void testaConquistaHorizontal() throws Exception {
        teste.testaConquistaHorizontal(false);
    }

    @Test
    public void testaConquistaDiagonalDistancia1() throws Exception {
        teste.testaConquistaDiagonalDistancia1(true);
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
    public void testaConquistaPeaoPreto() throws Exception {
        teste.testaConquistaPeaoPreto(false);
    }

    @Test
    public void testaMovimentoVerticalPeaoPreto() throws Exception {
        teste.testaMovimentoVerticalPeaoPreto(false);
    }
}