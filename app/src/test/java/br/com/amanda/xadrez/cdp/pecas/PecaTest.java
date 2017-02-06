package br.com.amanda.xadrez.cdp.pecas;

import org.junit.Ignore;
import org.junit.Test;

import br.com.amanda.xadrez.cdp.Cor;
import br.com.amanda.xadrez.cdp.Posicao;
import br.com.amanda.xadrez.cdp.PosicaoFactory;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.utils.PecaInexistenteError;

import static org.junit.Assert.*;

@Ignore
public class PecaTest {
    private final int posX = 5;
    private final int posY = 5;
    private final String nome;
    private final Cor cor;

    public PecaTest(String nome, Cor cor) throws PecaInexistenteError {
        this.cor = cor;
        this.nome = nome;
    }

    private Posicao getP0(PosicaoFactory posicaoFactory) throws PecaInexistenteError {
        Peca peca = posicaoFactory.getPecaFactory().fabricar(nome, cor);
        return posicaoFactory.fabricarPosicao(peca, posX, posY);
    }

    private Posicao getP1(PosicaoFactory posicaoFactory, int novoX, int novoY) throws PecaInexistenteError {
        Peca peca = posicaoFactory.getPecaFactory().fabricar(nome, cor.getOposto());
        return posicaoFactory.fabricarPosicao(peca, novoX, novoY);
    }

    @Test
    public void testaMovimentoDiagonalDistancia1(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX-1, posY-1));
    }

    @Test
    public void testaMovimentoVerticalDistancia1(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX+1, posY));
    }

    @Test
    public void testaMovimentoHorizontalDistancia1(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX, posY+1));
    }

    @Test
    public void testaMovimentoVerticalPeaoPreto(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX-1, posY));
    }

    @Test
    public void testaMovimentoDiagonal(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX-5, posY-5));
    }

    @Test
    public void testaMovimentoVertical(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX-4, posY));
    }

    @Test
    public void testaMovimentoHorizontal(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX, posY-3));
    }

    @Test
    public void testaMovimentoL(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX+2, posY+1));
    }

    @Test
    public void testaConquistaHorizontal(boolean expected) throws Exception {
        assertEquals(expected, validaConquista(posX, posY+2));
    }

    @Test
    public void testaConquistaDiagonalDistancia1(boolean expected) throws Exception {
        assertEquals(expected, validaConquista(posX+1, posY+1));
    }

    @Test
    public void testaConquistaPeaoPreto(boolean expected) throws Exception {
        assertEquals(expected, validaConquista(posX-1, posY+1));
    }

    @Test
    public void testaConquistaVerticalDistancia1(boolean expected) throws Exception {
        assertEquals(expected, validaConquista(posX+1, posY));
    }

    @Test
    public void testaConquistaHorizontalDistancia1(boolean expected) throws Exception {
        assertEquals(expected, validaMovimento(posX, posY+1));
    }

    @Test
    public void testaConquistaDiagonal(boolean expected) throws Exception {
        assertEquals(expected, validaConquista(posX-3, posY-3));
    }

   @Test
    public void testaConquistaL(boolean expected) throws Exception {
       assertEquals(expected, validaMovimento(posX+1, posY-2));
    }

    @Test
    public void testaConquistaVertical(boolean expected) throws Exception {
        assertEquals(expected, validaConquista(posX-5, posY));
    }

    private boolean validaMovimento(int novoX, int novoY) throws PecaInexistenteError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Posicao p0 = getP0(posicaoFactory);
        Posicao p1 = posicaoFactory.fabricarPosicao(novoX,novoY);
        return p0.getPeca().validaMovimento(p0, p1, posicaoFactory);
    }

    private boolean validaConquista(int novoX, int novoY) throws PecaInexistenteError {
        PosicaoFactory posicaoFactory = new PosicaoFactory(new PecaFactory(), 8);
        Posicao p0 = getP0(posicaoFactory);
        Posicao p1 = getP1(posicaoFactory, novoX,novoY);
        return p0.getPeca().validaConquista(p0, p1, posicaoFactory);

    }

}