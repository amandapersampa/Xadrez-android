package br.com.amanda.xadrez.cdp;

import java.util.ArrayList;
import java.util.List;
import br.com.amanda.xadrez.cdp.peca.Peca;
import br.com.amanda.xadrez.cdp.peca.PecaFactory;
import br.com.amanda.xadrez.utils.ConquistaNaoPermitidaError;
import br.com.amanda.xadrez.utils.MovimentoNaoPermitidoError;
import br.com.amanda.xadrez.utils.PecaInexistenteError;


public class Tabuleiro {
    private final Posicao[][] espacos;
    private final PosicaoFactory posicaoFactory;
    private final PecaFactory pecaFactory;
    private final int largura;
    private final Peca vazio;

    public Tabuleiro(PosicaoFactory posicaoFactory) throws PecaInexistenteError {
        this.posicaoFactory = posicaoFactory;
        this.pecaFactory = posicaoFactory.getPecaFactory();
        this.largura = posicaoFactory.getLargura();
        this.espacos = posicaoFactory.getTabuleiroVazio();
        this.vazio = PecaFactory.vazio();
        adicionaPecasIniciais(7, Cor.PRETO);
        adicionaPeao(6, Cor.PRETO);
        adicionaPecasIniciais(0, Cor.BRANCA);
        adicionaPeao(1, Cor.BRANCA);
    }

    private void adicionaPecasIniciais(int posX, Cor cor) throws PecaInexistenteError {
        addPeca("Torre", posX, 0, cor);
        addPeca("Cavalo", posX, 1, cor);
        addPeca("Bispo", posX, 2, cor);
        addPeca("Rei", posX, 3, cor);
        addPeca("Rainha", posX, 4, cor);
        addPeca("Bispo", posX, 5, cor);
        addPeca("Cavalo", posX, 6, cor);
        addPeca("Torre", posX, 7, cor);
    }

    private void adicionaPeao(int posX, Cor cor) throws PecaInexistenteError {
        for(int i = 0 ; i < largura; i++) {
            addPeca("Peao", posX, i, cor);
        }
    }

    private void addPeca(String nomePeca, int posX, int posY, Cor cor) throws PecaInexistenteError {
        Peca peca = pecaFactory.fabricar(nomePeca, cor);
        Posicao posicao = posicaoFactory.fabricarPosicao(peca, posX, posY);
        posicao.setPeca(peca);
        espacos[posX][posY] = posicao;
    }

    public List<Posicao> possiveisMovimentos(Posicao posicao) throws PecaInexistenteError {
        List<Posicao> redor = posicaoFactory.getPosicoesAoRedor(posicao);
        List<Posicao> movimentos = new ArrayList<>();
        for(Posicao p : redor){
            posicaoFactory.possiveisMovimentos(posicao, p);
        }
        return movimentos;
    }

    public List<Posicao> possiveisConquistas(Posicao posicao) {
        return posicaoFactory.possiveisConquistas(posicao, posicao);
    }

    public Peca getPeca(Posicao posicao) {
        return espacos[posicao.getEixoX()][posicao.getEixoY()].getPeca();
    }

    public void mover(Posicao posicao, Posicao nova) throws MovimentoNaoPermitidoError, PecaInexistenteError {
        Peca atualPeca = posicao.getPeca();
        boolean isLivre = posicaoFactory.campoLivre(posicao, nova);
        if (atualPeca.validaMovimento(posicao,nova)&& isLivre) {
            posicao.setPeca(this.vazio);
            nova.setPeca(atualPeca);
            atualPeca.moveu();
        }else{
            throw new MovimentoNaoPermitidoError();
        }
    }

    public void conquistar(Posicao posicao, Posicao nova) throws ConquistaNaoPermitidaError, PecaInexistenteError {
        Peca atualPeca = getPeca(posicao);
        if (atualPeca.validaConquista(posicao,nova) && posicaoFactory.campoLivre(posicao,nova)) {
            posicao.setPeca(this.vazio);
            nova.setPeca(atualPeca);
            atualPeca.moveu();
        }else{
            throw new ConquistaNaoPermitidaError();
        }
    }

}