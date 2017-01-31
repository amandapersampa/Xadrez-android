package br.com.amanda.xadrez.cdp;

import org.junit.Test;

import br.com.amanda.xadrez.cdp.pecas.PecaFactory;

import static org.junit.Assert.*;

/**
 * Created by amand on 31/01/2017.
 */
public class PosicaoFactoryTest {
    @Test
    public void fabricarPosicao() throws Exception {
        PecaFactory  pecaf = new PecaFactory();
        PosicaoFactory pf = new PosicaoFactory(pecaf, 8);
        Posicao[][] posicoes = new Posicao[8][8];


        for(int i = 0; i<8 ; i++){
            for( int j = 0; j< 8 ; j++) {
                posicoes[i][j] = pf.fabricarPosicao(pecaf.vazio(), i, j);
                System.out.print(posicoes[i][j].getPeca().getNome()+" ");
            }
            System.out.println();
        }
    }

}