
package logica;

import java.util.Random;

public class Partida {

    int tamanho;
    int tirosRestantes;
    int totalPartes = 0;
    int partesAcertadas = 0;

    String[][] embarcacoes;
    boolean[][] jogadas;

    Random sorteio = new Random();

    public Partida(String nivel) {

        if (nivel.equalsIgnoreCase("dificil")) {
            tamanho = 8;
            tirosRestantes = 40;

        } else if (nivel.equalsIgnoreCase("intermediario")) {
            tamanho = 7;
            tirosRestantes = 35;

        } else {
            tamanho = 6;
            tirosRestantes = 30;
        }

        embarcacoes = new String[tamanho][tamanho];
        jogadas = new boolean[tamanho][tamanho];

        posicionarEmbarcacoes();
    }

    // posiciona as embarcacoes no tabuleiro

    public void posicionarEmbarcacoes() {

        int[] tamanhos;
        int[] quantidades;

        if (tamanho == 6) {
            tamanhos = new int[]{1, 2, 3, 4, 5};
            quantidades = new int[]{4, 2, 1, 1, 1};

        } else if (tamanho == 7) {
            tamanhos = new int[]{1, 2, 3, 4, 5};
            quantidades = new int[]{4, 3, 1, 1, 1};

        } else {
            tamanhos = new int[]{1, 2, 3, 4, 5};
            quantidades = new int[]{6, 2, 2, 2, 1};
        }

        String[] nomes = {
            "Submarino",
            "Destroier",
            "Cruzador",
            "Encouraçado",
            "Porta-aviões"
        };

        for (int i = 0; i < nomes.length; i++) {

            for (int j = 0; j < quantidades[i]; j++) {

                boolean posicionado = false;

                while (!posicionado) {

                    int linha = sorteio.nextInt(tamanho);
                    int coluna = sorteio.nextInt(tamanho);
                    boolean horizontal = sorteio.nextBoolean();

                    int fimLinha = linha;
                    int fimColuna = coluna;

                    if (horizontal) {
                        fimColuna += tamanhos[i] - 1;
                    } else {
                        fimLinha += tamanhos[i] - 1;
                    }

                    if (fimLinha >= tamanho || fimColuna >= tamanho) {
                        continue;
                    }

                    boolean livre = true;

                    for (int k = 0; k < tamanhos[i]; k++) {

                        int l = linha;
                        int c = coluna;

                        if (horizontal) {
                            c += k;
                        } else {
                            l += k;
                        }

                        if (embarcacoes[l][c] != null) {
                            livre = false;
                            break;
                        }
                    }

                    if (livre) {

                        for (int k = 0; k < tamanhos[i]; k++) {

                            int l = linha;
                            int c = coluna;

                            if (horizontal) {
                                c += k;
                            } else {
                                l += k;
                            }

                            embarcacoes[l][c] = nomes[i];
                            totalPartes++;
                        }

                        posicionado = true;
                    }
                }
            }
        }
    }

    // registra a jogada e retorna o nome da embarcacao quando acwrta

    public String realizarJogada(int linha, int coluna) {

        if (linha < 0 || linha >= tamanho || coluna < 0 || coluna >= tamanho) {
            return "";
        }

        if (jogadas[linha][coluna] || partidaFinalizada()) {
            return "";
        }

        jogadas[linha][coluna] = true;
        tirosRestantes--;

        if (embarcacoes[linha][coluna] != null) {
            partesAcertadas++;
            return embarcacoes[linha][coluna];
        }

        return null;
    }

    public boolean jaFoiJogado(int linha, int coluna) {
        return jogadas[linha][coluna];
    }

    public boolean venceu() {
        return partesAcertadas == totalPartes;
    }

    public boolean partidaFinalizada() {
        return venceu() || tirosRestantes == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getTirosRestantes() {
        return tirosRestantes;
    }

    public int getTotalPartes() {
        return totalPartes;
    }

    public int getPartesAcertadas() {
        return partesAcertadas;
    }

}
