package br.com.amanda.xadrez.cdp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.amanda.xadrez.cdp.Pecas.Bispo;
import br.com.amanda.xadrez.cdp.Pecas.Cavalo;
import br.com.amanda.xadrez.cdp.Pecas.Parede;
import br.com.amanda.xadrez.cdp.Pecas.Peca;
import br.com.amanda.xadrez.cdp.Pecas.PecaFactory;
import br.com.amanda.xadrez.cdp.Pecas.Rainha;
import br.com.amanda.xadrez.cdp.Pecas.Rei;
import br.com.amanda.xadrez.cdp.Pecas.Torre;
import br.com.amanda.xadrez.cdp.Pecas.Vazio;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;
import br.com.amanda.xadrez.utils.PecaInexistenteError;


public class Tabuleiro {
    private final Map<Posicao, Peca> espacos;
    private final PosicaoFactory posicaoFactory;
    private final PecaFactory pecaFactory;
    private final int altura = 10;
    private final int largura = 10;
    private final Peca vazio;
    private final Peca parede;

    public Tabuleiro(PosicaoFactory posicaoFactory) throws PecaInexistenteError {
        this.espacos = new HashMap<>();
        this.posicaoFactory = posicaoFactory;
        this.pecaFactory = new PecaFactory(posicaoFactory);
        adicionarParedes();
        adicionaEspacosVazios();
        adicionaPecasIniciais(8, Cor.PRETO);
        adicionaPecasIniciais(1, Cor.BRANCA);
        vazio = espacos.get(posicaoFactory.fabricarPosicao(3,3));
        parede = espacos.get(posicaoFactory.fabricarPosicao(0,0));
    }

    private void adicionarParedes() throws PecaInexistenteError {
            int chao = 0;
            int teto = 10;
            int direita = 0;
            int esquerda = 10;
            for (int i = 0; i < largura; i++) {
                addPeca("Parede", chao, i, Cor.INDIFERENTE);
                addPeca("Parede", teto, i, Cor.INDIFERENTE);
                addPeca("Parede", i, direita, Cor.INDIFERENTE);
                addPeca("Parede", i, esquerda, Cor.INDIFERENTE);
            }
    }

    private void adicionaEspacosVazios() throws PecaInexistenteError {
        for (int i = 3; i < altura - 3 ; i++) {
            for (int j = 0; j < largura; j++) {
                addPeca("Vazio", i, j, Cor.INDIFERENTE);
            }
        }
    }

    private void adicionaPecasIniciais(int posX, Cor cor) throws PecaInexistenteError {
        addPeca("Torre", posX, 1, cor);
        addPeca("Cavalo", posX, 2, cor);
        addPeca("Bispo", posX, 3, cor);
        addPeca("Rei", posX, 4, cor);
        addPeca("Rainha", posX, 5, cor);
        addPeca("Bispo", posX, 6, cor);
        addPeca("Cavalo", posX, 7, cor);
        addPeca("Torre", posX, 8, cor);
        adicionaPeao(posX+1, cor);
    }

    private void adicionaPeao(int posX, Cor cor) throws PecaInexistenteError {
        for(int i = 0 ; i < largura; i++) {
            addPeca("Peao", posX, i, cor);
        }
    }

    private void addPeca(String nomePeca, int posX, int posY, Cor cor) throws PecaInexistenteError {
        Peca peca = pecaFactory.fabricar(nomePeca, posX, posY, cor);
        addPeca(peca, posX, posY);
    }

    private void addPeca(Peca peca, int posX, int posY){
        Posicao posicao = posicaoFactory.fabricarPosicao(posX, posY);
        espacos.put(posicao, peca);
    }

    public List<Posicao> possiveisMovimentos(Posicao posicao) {
        return null;
    }

    public Peca getPeca(Posicao posicao) {
        return this.espacos.get(posicao);
    }

    public void mover(Posicao posicao, Posicao nova) throws MovimentoNaoPermitidoError, PecaInexistenteError {
        Peca novaPeca = espacos.get(nova);
        Peca atualPeca = espacos.get(posicao);
        if (novaPeca.equals(vazio)) {
            atualPeca.mover(nova);
            addPeca("Vazio", posicao.getEixoX(), posicao.getEixoY(), Cor.INDIFERENTE);
            addPeca(atualPeca, nova.getEixoX(), nova.getEixoY());
        }
        else{
            throw new MovimentoNaoPermitidoError();
        }
    }

    @Override
    public String toString(){
        return this.espacos.toString();
    }
}
