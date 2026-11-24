//	Matriz, criacao do tabuleiro, posicionamento aleatorio e verificacao de tiros.
package logica;

import java.util.Random;

public class Tabuleiro {

    int[][] grade; // conta a agua e os indices dos navios
    boolean [][] tiros; // tiros dados
    Embarcacao[] navios;

    // definição dos atributos de cada nível:
    public Tabuleiro (int nivel) {
        if (nivel == 1) {
            grade = new int[6][6];
            navios = new Embarcacao[9];
            navios[0] = new Embarcacao("Submarino", 1);
            navios[1] = new Embarcacao("Submarino", 1);
            navios[2] = new Embarcacao("Submarino", 1);
            navios[3] = new Embarcacao("Submarino", 1);
            navios[4] = new Embarcacao("Destroier", 2);
            navios[5] = new Embarcacao("Destroier", 2);
            navios[6] = new Embarcacao("Cruzador", 3);
            navios[7] = new Embarcacao("Encouraçado", 4);
            navios[8] = new Embarcacao("Porta-aviões", 5);
        }
        else if (nivel == 2) {
            grade = new int[7][7];
            navios = new Embarcacao[10];
            navios[0] = new Embarcacao("Submarino", 1);
            navios[1] = new Embarcacao("Submarino", 1);
            navios[2] = new Embarcacao("Submarino", 1);
            navios[3] = new Embarcacao("Submarino", 1);
            navios[4] = new Embarcacao("Destroier", 2);
            navios[5] = new Embarcacao("Destroier", 2);
            navios[6] = new Embarcacao("Destroier", 2);
            navios[7] = new Embarcacao("Cruzador", 3);
            navios[8] = new Embarcacao("Encouraçado", 4);
            navios[9] = new Embarcacao("Porta-aviões", 5);    
        }
        else {
            grade = new int[8][8];
            navios = new Embarcacao[13];
            navios[0] = new Embarcacao("Submarino", 1);
            navios[1] = new Embarcacao("Submarino", 1);
            navios[2] = new Embarcacao("Submarino", 1);
            navios[3] = new Embarcacao("Submarino", 1);
            navios[4] = new Embarcacao("Submarino", 1);
            navios[5] = new Embarcacao("Submarino", 1);
            navios[6] = new Embarcacao("Destroier", 2);
            navios[7] = new Embarcacao("Destroier", 2);
            navios[8] = new Embarcacao("Cruzador", 3);
            navios[9] = new Embarcacao("Cruzador", 3);
            navios[10] = new Embarcacao("Encouraçado", 4);
            navios[11] = new Embarcacao("Encouraçado", 4);
            navios[12] = new Embarcacao("Porta-aviões", 5);
        }

        tiros = new boolean[grade.length][grade[0].length];
        
    }

    public void posicionarNavios() {
        Random gerador = new Random(); // gera coordenadas aleatórias

        for (int i = 0; i < navios.length; i++) {                  //percorre os navios adicionados
            Embarcacao navio = navios[i];
            boolean posicionado = false;
            while(!posicionado){                                        // garante que o navio encontre uma vaga dentro da matriz                  
                int linha = gerador.nextInt(grade.length);
                int coluna = gerador.nextInt(grade[0].length);

                if (coluna + navio.getTamanho() <= grade[0].length
                        && estaLivre(linha, coluna, navio.getTamanho())) {   // checa se o navio cabe na horizontal
                    for (int j = 0; j < navio.getTamanho(); j++){            // preenche a matriz
                        grade[linha][coluna + j] = 1;
                    }
                    posicionado = true;
                }
            }
            
        }

        }
        // Confere se as casas onde o navio ficaria estão livres ou não
        private boolean estaLivre(int linha, int coluna, int tamanho) {
            for (int j = 0; j < tamanho; j++) {
                if(grade[linha][coluna + j++] != 0) {
                    return false;
                }
            }
        return true;
    }
    // Processa um tiro e devolve o que aconteceu
    public ResultadoTiro atirar(int linha, int coluna) {
        if (tiros[linha][coluna]) {
            return ResultadoTiro.REPETIDA;
        }

        tiros[linha][coluna] = true;

        if (grade[linha][coluna] == 0) {
            return ResultadoTiro.AGUA;
        }

        Embarcacao navio = navios[grade[linha][coluna] - 1];
        navio.registrarAcerto();

        if (navio.estaAfundada()) {
            return ResultadoTiro.AFUNDOU;
        }
        return ResultadoTiro.ACERTOU;
    }

    // Quando todos os navios forem afundados
    public boolean todosAfundados() {
        for (int i = 0; i < navios.length; i++) {
            if (!navios[i].estaAfundada()) {
                return false;
            }
        }
        return true;
    }

    public int getTamanho() {
        return grade.length;
    }

    // Devolve o navio de uma casa, ou null se for água
    public Embarcacao getEmbarcacaoEm(int linha, int coluna) {
        if (grade[linha][coluna] == 0) {
            return null;
        }
        return navios[grade[linha][coluna] - 1];
    }
}