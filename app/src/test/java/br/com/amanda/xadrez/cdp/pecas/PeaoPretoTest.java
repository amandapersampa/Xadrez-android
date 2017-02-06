package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

import static org.junit.Assert.assertEquals;

public class PeaoPretoTest {
    private final PecaTest teste = new PecaTest("Peao", Cor.PRETO);

    @Test
    public void testaMovimentoVerticalPeaoPreto() throws Exception {
        teste.testaMovimentoVerticalPeaoPreto(true);
    }

    @Test
    public void testaConquistaPeaoPreto() throws Exception {
        teste.testaConquistaPeaoPreto(true);
    }

    public PeaoPretoTest() throws PecaInexistenteError {
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
        teste.testaMovimentoL(false);
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
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        PecaFactory pecaFactory = posicaoFactory.getPecaFactory();
        Peca peaoP = pecaFactory.fabricar("Peao", Cor.PRETO);
        Peca peaoB = pecaFactory.fabricar("Peao", Cor.BRANCA);
        Posicao p1 = posicaoFactory.fabricarPosicao(peaoB, 4,4);
        Posicao p0 = posicaoFactory.fabricarPosicao(peaoP, 5,5);

        boolean possoMover = p0.getPeca().validaConquista(p0, p1, posicaoFactory);

        assertEquals(true, possoMover);
    }

    @Test
    public void testaConquistaVertical() throws Exception {
        teste.testaConquistaVertical(false);
    }
}
