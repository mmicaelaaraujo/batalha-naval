package logica;

import java.util.Random;

public class Tabuleiro {

    int [][] nivelFacil = new int[6][6];
    int [][] nivelIntermediario = new int[7][7];
    int [][] nivelDificil = new int[8][8];

    Embarcacao[] naviosFacil = new Embarcacao[9];
    Embarcacao[] naviosIntermediario = new Embarcacao[10];
    Embarcacao[] naviosDificil = new Embarcacao[13];


    // definição dos atributos de cada nível:
    public Tabuleiro (int nivel) {
        if (nivel == 1) {
            nivelFacil = new int[6][6];
            naviosFacil[0] = new Embarcacao("Submarino", 1);
            naviosFacil[1] = new Embarcacao("Submarino", 1);
            naviosFacil[2] = new Embarcacao("Submarino", 1);
            naviosFacil[3] = new Embarcacao("Submarino", 1);
            naviosFacil[4] = new Embarcacao("Destroier", 2);
            naviosFacil[5] = new Embarcacao("Destroier", 2);
            naviosFacil[6] = new Embarcacao("Cruzador", 3);
            naviosFacil[7] = new Embarcacao("Encouraçado", 4);
            naviosFacil[8] = new Embarcacao("Porta-aviões", 5);

        }
        else if (nivel == 2) {
            nivelIntermediario = new int[7][7];
            naviosIntermediario[0] = new Embarcacao("Submarino", 1);
            naviosIntermediario[1] = new Embarcacao("Submarino", 1);
            naviosIntermediario[2] = new Embarcacao("Submarino", 1);
            naviosIntermediario[3] = new Embarcacao("Submarino", 1);
            naviosIntermediario[4] = new Embarcacao("Destroier", 2);
            naviosIntermediario[5] = new Embarcacao("Destroier", 2);
            naviosIntermediario[6] = new Embarcacao("Destroier", 2);
            naviosIntermediario[7] = new Embarcacao("Cruzador", 3);
            naviosIntermediario[8] = new Embarcacao("Encouraçado", 4);
            naviosIntermediario[9] = new Embarcacao("Porta-aviões", 5);
            
        }
        else if (nivel == 3) {
            nivelDificil = new int[8][8];
            naviosDificil[0] = new Embarcacao("Submarino", 1);
            naviosDificil[1] = new Embarcacao("Submarino", 1);
            naviosDificil[2] = new Embarcacao("Submarino", 1);
            naviosDificil[3] = new Embarcacao("Submarino", 1);
            naviosDificil[4] = new Embarcacao("Submarino", 1);
            naviosDificil[5] = new Embarcacao("Submarino", 1);
            naviosDificil[6] = new Embarcacao("Destroier", 2);
            naviosDificil[7] = new Embarcacao("Destroier", 2);
            naviosDificil[8] = new Embarcacao("Cruzador", 3);
            naviosDificil[9] = new Embarcacao("Cruzador", 3);
            naviosDificil[10] = new Embarcacao("Encouraçado", 4);
            naviosDificil[11] = new Embarcacao("Encouraçado", 4);
            naviosDificil[12] = new Embarcacao("Porta-aviões", 5);
        }
        
    }

    public void posicionarNavios() {
        Random gerador = new Random(); // gera coordenadas aleatórias

        // laço de repetição do nível fácil:

        for (int i = 0; i < naviosFacil.length; i++) {                  //percorre os navios adicionados
            Embarcacao navio = naviosFacil[i];
            boolean posicionado = false;
            while(!posicionado){                                        // garante que o navio encontre uma vaga dentro da matriz                  
                int linha = gerador.nextInt(nivelFacil.length);
                int coluna = gerador.nextInt(nivelFacil[0].length);

                if (coluna + navio.getTamanho() <= nivelFacil[0].length){   // checa se o navio cabe na horizontal
                    for (int j = 0; j <navio.getTamanho(); j++){            // preenche a matriz
                        nivelFacil[linha][coluna + j] = 1;
                    }
                    posicionado = true;
                }
            }
            
        }
    }

}
